package com.rays.pro4.Bean;

/**
 * Role JavaBean encapsulates Role attributes.
 * 
 * @author Muskan prajapat
 *
 */
public class EmployeeRoleBean extends BaseBean{

	public static final int FEES  = 1;
	public static final int MANAGEMENT  = 2;
	public static final int  RECEPTION  = 3;
	public static final int  ACCOUNTING  = 4;
	public static final int DEVELOPMENT  = 5;

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
