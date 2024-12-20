package com.rays.pro4.Bean;

import java.util.Date;

import javax.servlet.http.HttpServlet;

public class PracticeBean extends HttpServlet{
	private Date dob;

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	
}
