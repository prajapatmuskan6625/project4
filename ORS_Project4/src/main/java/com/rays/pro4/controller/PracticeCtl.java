package com.rays.pro4.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.pro4.Bean.PracticeBean;
import com.rays.pro4.Util.DataUtility;


@WebServlet(name = "PracticeCtl", urlPatterns = { "/PracticeCtl" })

public class PracticeCtl extends HttpServlet{
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

	
		String dob = req.getParameter("dob");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    PracticeBean bean = new PracticeBean();
		
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e1) {

			e1.printStackTrace();
		}
	}
}





