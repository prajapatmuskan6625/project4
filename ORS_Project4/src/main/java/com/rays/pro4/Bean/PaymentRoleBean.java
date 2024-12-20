package com.rays.pro4.Bean;

/**
 * Role JavaBean encapsulates Role attributes.
 * 
 * @author Muskan prajapat
 *
 */
public class PaymentRoleBean extends BaseBean{

	public static final int CREDIT = 1;
	public static final int DEBIT = 2;
	public static final int  CASH = 3;
	public static final int CHEQUES = 4;
	public static final int NETBANKING = 5;

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
