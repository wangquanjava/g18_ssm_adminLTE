package com.git.domain;
public enum UserRoleEnum {
	student(0,"学生"),teacher(1,"老师"),lender(2,"导师"),admin(10,"管理员");
	private Integer role;
	private String text;
	
	public Integer role() {
		return role;
	}
	public String text() {
		return text;
	}

	
	private UserRoleEnum(Integer role, String text) {
		this.role = role;
		this.text = text;
	}

	public static UserRoleEnum getUserRoleEnum(Integer role){
		switch (role) {
		case 0:
			return UserRoleEnum.student;
		case 1:
			return UserRoleEnum.teacher;
		case 2:
			return UserRoleEnum.lender;
		case 10:
			return UserRoleEnum.admin;
		default:
			return UserRoleEnum.student;
		}
	}
}