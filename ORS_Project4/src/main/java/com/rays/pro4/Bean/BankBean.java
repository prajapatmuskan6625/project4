package com.rays.pro4.Bean;

import java.util.Date;

public class BankBean extends BaseBean{
	
	/* private long id; */
	private String name;
	private Date dob;
	private int accountNo;
	private String bankName;
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;

	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String getkey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return dob+"";
	}

}
