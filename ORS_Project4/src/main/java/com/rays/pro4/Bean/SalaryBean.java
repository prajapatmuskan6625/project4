package com.rays.pro4.Bean;

import java.util.Date;

public class SalaryBean extends BaseBean {
	private String employee;
	private Long amount;
	private Date dob;
	private String status;
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String getkey() {
		// TODO Auto-generated method stub
		return employee;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return employee;
	}
	

}
