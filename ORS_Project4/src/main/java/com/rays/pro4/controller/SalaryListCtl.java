package com.rays.pro4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.rays.pro4.Bean.BaseBean;
import com.rays.pro4.Bean.SalaryBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Model.SalaryModel;
import com.rays.pro4.Model.SalaryRoleModel;
import com.rays.pro4.Util.DataUtility;
import com.rays.pro4.Util.ServletUtility;

@WebServlet(name = "SalaryListCtl", urlPatterns = { "/ctl/SalaryListCtl" })

public class SalaryListCtl extends BaseCtl {
	
//	private static Logger log = Logger.getLogger(SalaryListCtl.class);
	
	
	
	
	@Override
	protected void preload(HttpServletRequest request) {

		SalaryRoleModel smodel = new SalaryRoleModel();
		SalaryModel emodel = new SalaryModel();

		try {
			List slist = smodel.list(0,0);
			List elist = emodel.list(0,0);
			
			request.setAttribute("status", slist);
			request.setAttribute("employee", elist);
			
			//request.setAttribute("List", dlist);

		
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}




	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		SalaryBean bean = new SalaryBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setEmployee(DataUtility.getString(request.getParameter("employee")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		bean.setAmount(DataUtility.getLong(request.getParameter("amount")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));

		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list = null;

		int pageNo = 1;
		int pageSize = 10;

		SalaryBean bean = (SalaryBean) populateBean(request);
		String op = DataUtility.getString(request.getParameter("operation"));

		SalaryModel model = new SalaryModel();

		try {
			list = model.search(bean, pageNo, pageSize);
		} catch (Exception e) {
			ServletUtility.handleException(e, request, response);
		}

		if (list == null || list.size() == 0) {
			ServletUtility.setErrorMessage("No record found ", request);
		}

		ServletUtility.setList(list, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.setBean(bean, request);
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("search");
		List list = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		String op = DataUtility.getString(request.getParameter("operation"));
		SalaryBean bean = (SalaryBean) populateBean(request);
		String[] ids = request.getParameterValues("ids");

		SalaryModel model = new SalaryModel();

		if (OP_SEARCH.equalsIgnoreCase(op)) {
			System.out.println("qwerty");
			pageNo = 1;
		} else if (OP_NEXT.equalsIgnoreCase(op)) {
			pageNo++;
		} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
			pageNo--;
		} else if (OP_NEW.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.SALARY_CTL, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.SALARY_LIST_CTL, request, response);
			return;
		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			pageNo = 1;
			if (ids != null && ids.length > 0) {
				SalaryBean deletebean = new SalaryBean();
				for (String id : ids) {
					deletebean.setId(DataUtility.getInt(id));
					try {
						model.delete(deletebean);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ServletUtility.setSuccessMessage("Salary is Deleted Successfully", request);
				}
			} else {
				ServletUtility.setErrorMessage("Select at least one record", request);
			}
		}
		try {
			System.out.println("qwerty1");
			list = model.search(bean, pageNo, pageSize);
			System.out.println("1234567");
		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list == null || list.size() == 0 && !OP_DELETE.equalsIgnoreCase(op)) {
			ServletUtility.setErrorMessage("No record found ", request);
		}
		ServletUtility.setList(list, request);
		ServletUtility.setBean(bean, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.SALARY_LIST_VIEW;
	}

}
