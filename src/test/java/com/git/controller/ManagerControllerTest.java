package com.git.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import com.git.domain.UserEntity;

import jxl.Sheet;
import jxl.Workbook;

public class ManagerControllerTest {
	public void trace() throws Exception {
		jxl.Workbook readwb = null;
		InputStream instream = new FileInputStream("C:\\Users\\tdp\\Desktop\\2.xls");
		readwb = Workbook.getWorkbook(instream);

		Sheet readsheet = readwb.getSheet(0);
		int rsColumns = readsheet.getColumns();
		int rsRows = readsheet.getRows();
		// 假设真实数据从第4行开始的
		String temp;
		String userId = null;
		String realname = null;
		Date startDate = null;
		UserEntity userEntity = null;

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
					case 2:
						temp = readsheet.getCell(j, i).getContents().trim();
						if (StringUtils.isNotBlank(temp)) {
							realname = temp;
						}
						break;
					case 3:
						temp = readsheet.getCell(j, i).getContents().trim();
						if (StringUtils.isNotBlank(temp)) {
							startDate = DateUtils.parseDate(temp, "yyyy-MM-dd");
						}
						break;
					default:
						break;
					}
					userEntity = new UserEntity(userId, realname, startDate);
					System.out.println(userEntity);
					userId = null;
					realname = null;
					startDate = null;
					userEntity = null;
				} catch (Exception e) {
				}
			}
		}
	}
	
	@Test
	public void demo() throws Exception{
		this.trace();
	}
}
