package com.git.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String userId;
	private String password;
	private Integer role;
	
	
	private String realname;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date startDate;
	
	
	
	public UserEntity(String userId, String realname, Date startDate) {
		super();
		this.userId = userId;
		this.realname = realname;
		this.startDate = startDate;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Transient
	private String roleText;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getRoleText() {
		UserRoleEnum userRoleEnum = UserRoleEnum.getUserRoleEnum(this.role);
		return userRoleEnum.text();
	}
	public void setRoleText(String roleText) {
		this.roleText = roleText;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userId=" + userId + ", password=" + password + ", role=" + role
				+ ", realname=" + realname + ", email=" + email + ", startDate=" + startDate + ", roleText=" + roleText
				+ "]";
	}
	
}
