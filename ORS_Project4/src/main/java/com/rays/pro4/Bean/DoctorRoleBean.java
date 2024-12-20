package com.rays.pro4.Bean;

public class DoctorRoleBean extends BaseBean {
	public static final int Skill   = 1;
	public static final int Domain   = 2;
	public static final int Assessing = 3;
	public static final int Dwelling = 4;
	public static final int Cognitive = 5;
	

	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getkey() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}
	


}


