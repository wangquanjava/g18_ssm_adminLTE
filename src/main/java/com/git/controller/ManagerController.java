package com.git.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.git.domain.AjaxJson;
import com.git.domain.UserEntity;
import com.git.service.UserService;

import jxl.Sheet;
import jxl.Workbook;

@Controller
@RequestMapping("managerController")
public class ManagerController {
	@Autowired
	private UserService userService;
	@Value("${file.folder}")
	private String uploadFolder;
	
	@RequestMapping(value="/uploadFile",method = RequestMethod.POST)
	public ResponseEntity<AjaxJson> uploadFile(@RequestParam("fileFieldName") MultipartFile multipartFile){
		try {
			//导入到数据库
			List<UserEntity> userEntities = this.trace(multipartFile.getInputStream());
			this.userService.addAll(userEntities);
			
			return ResponseEntity.status(HttpStatus.OK).body(new AjaxJson(true,"导入成功",null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(new AjaxJson(true,"导入失败",null));
	}
	
	
	public List<UserEntity> trace(InputStream instream) throws Exception {
		 Workbook readwb = Workbook.getWorkbook(instream);

		Sheet readsheet = readwb.getSheet(0);
		int rsColumns = readsheet.getColumns();
		int rsRows = readsheet.getRows();
		// 假设真实数据从第2行开始的
		String temp;
		String userId = null;
		String realname = null;
		Date startDate = null;
		List<UserEntity> userEntities= new ArrayList<>();

		for (int i = 1; i < rsRows; i++) {
			for (int j = 0; j < rsColumns; j++) {
				try {
					switch (j) {
					case 0:
						temp = readsheet.getCell(j, i).getContents().trim();
						if (StringUtils.isNotBlank(temp)) {
							userId = temp;
						}
						break;
					case 1:
						temp = readsheet.getCell(j, i).getContents().trim();
						if (StringUtils.isNotBlank(temp)) {
							realname = temp;
						}
						break;
					case 2:
						temp = readsheet.getCell(j, i).getContents().trim();
						if (StringUtils.isNotBlank(temp)) {
							startDate = DateUtils.parseDate(temp, "yyyy-MM-dd");
						}
						break;
					default:
						break;
					}
				} catch (Exception e) {
				}
			}
			userEntities.add(new UserEntity(userId, realname, startDate));
			userId = null;
			realname = null;
			startDate = null;
		}
		return userEntities;
	}
}
