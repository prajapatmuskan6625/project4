package com.rays.pro4.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.rays.pro4.Bean.BaseBean;
import com.rays.pro4.Bean.SalaryBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Model.SalaryModel;
import com.rays.pro4.Model.SalaryRoleModel;
import com.rays.pro4.Util.DataUtility;
import com.rays.pro4.Util.DataValidator;
import com.rays.pro4.Util.PropertyReader;
import com.rays.pro4.Util.ServletUtility;

@WebServlet(name = "SalaryCtl", urlPatterns = { "/ctl/SalaryCtl" })
public class SalaryCtl extends BaseCtl {
	// private static Logger log = Logger.getLogger(SalaryCtl.class);
	
	
	
//	@Override
//	protected void preload(HttpServletRequest request) {
//
//		SalaryRoleModel smodel = new SalaryRoleModel();
//		//LeadModel model = new LeadModel();
//
//		try {
//			List slist = smodel.list(0,0);
//			
//			request.setAttribute("statuss", slist);
//			
//			//request.setAttribute("List", dlist);
//
//		
//		} catch (ApplicationException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	 @Override protected void preload(HttpServletRequest request) {
		 HashMap map = new HashMap();
		 map.put("Active", "Active");
		 map.put("Inactive", "Inactive");
		
		 request.setAttribute("statuss", map);
		 super.preload(request);
	  
	 }	  


	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		SalaryBean bean = new SalaryBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setEmployee(DataUtility.getString(request.getParameter("employee")));
		bean.setAmount(DataUtility.getLong(request.getParameter("amount")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));


		return bean;

	}

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("employee"))) {
			request.setAttribute("employee", PropertyReader.getValue("error.require", "employee"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("employee"))) {
			request.setAttribute("employee", " Employee contains alphabet only ");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("amount"))) {
			request.setAttribute("amount", PropertyReader.getValue("error.require", "amount"));
			pass = false;
		} else if (!DataValidator.isLong(request.getParameter("amount"))) {
			request.setAttribute("amount", " Amount Must be an integer ");
			pass = false;
		}


		if (DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "dob"));
			pass = false;
		} else if (!DataValidator.isAge(request.getParameter("dob"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "Minimum Age 18 Year"));			
			pass = false;
		}
	
		
		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "status"));
			pass = false;
//		} else if (!DataValidator.isName(request.getParameter("status"))) {
//			request.setAttribute("status", " Status contains alphabet only ");
//			pass = false;
//		}
		}
		return pass; 
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("in get method");

		String op = DataUtility.getString(request.getParameter("operation"));

		SalaryModel model = new SalaryModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {

			SalaryBean bean;
			try {

				bean = model.findByPK(id);
				System.out.println(" FIND kiya");
				System.out.println(bean);
				ServletUtility.setBean(bean, request);

				ServletUtility.forward(getView(), request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;

		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));

		SalaryModel model = new SalaryModel();
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			SalaryBean bean = (SalaryBean) populateBean(request);

			try {
				if (id > 0) {

					model.update(bean);
					ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("Salary is successfully Updated", request);

				} else {
					long pk = model.add(bean);
                    ServletUtility.setBean(bean, request);
					ServletUtility.setSuccessMessage("Salary is successfully Added", request);
					//ServletUtility.forward(getView(), request, response);

				}

			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Salary already exists", request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (OP_DELETE.equalsIgnoreCase(op)) {

			SalaryBean bean = (SalaryBean) populateBean(request);
			try {
				model.delete(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ServletUtility.redirect(ORSView.SALARY_CTL, request, response);
			return;

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			System.out.println(" U  ctl Do post 77777");

			ServletUtility.redirect(ORSView.SALARY_LIST_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		return ORSView.SALARY_VIEW;
	}

}
