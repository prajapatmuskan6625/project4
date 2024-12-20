package com.rays.pro4.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.pro4.Bean.BaseBean;
import com.rays.pro4.Bean.PaymentBean;
import com.rays.pro4.Exception.ApplicationException;
import com.rays.pro4.Exception.DuplicateRecordException;
import com.rays.pro4.Model.PaymentRoleModel;
import com.rays.pro4.Model.PaymentModel;
import com.rays.pro4.Util.DataUtility;
import com.rays.pro4.Util.DataValidator;
import com.rays.pro4.Util.PropertyReader;
import com.rays.pro4.Util.ServletUtility;

@WebServlet(name = "PaymentCtl", urlPatterns = { "/ctl/PaymentCtl" })
public class PaymentCtl extends BaseCtl {
	
	

	@Override
	protected void preload(HttpServletRequest request) {

		PaymentRoleModel pmodel = new PaymentRoleModel();
		//PaymentModel model = new PaymentModel();

		try {
			List plist = pmodel.list(0,0);
			
			request.setAttribute("paymentType", plist);
			
			//request.setAttribute("List", dlist);

		
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("paymentType"))) {
			request.setAttribute("paymentType", PropertyReader.getValue("error.require", "paymentType"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("paymentType"))) {
			request.setAttribute("paymentType", " Must Contain  alphabet Only");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("amount"))) {
			request.setAttribute("amount", PropertyReader.getValue("error.require", "amount"));
			pass = false;
		} else if (!DataValidator.isLong(request.getParameter("amount"))) {
			request.setAttribute("amount", "integer type only");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("customerName"))) {
			request.setAttribute("customerName", PropertyReader.getValue("error.require", "customerName"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("customerName"))) {
			request.setAttribute("customerName", " Must Contain  alphabet Only");
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("message"))) {
			request.setAttribute("message", PropertyReader.getValue("error.require", "message"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("message"))) {
			request.setAttribute("message", " Must Contain  alphabet Only");
			pass = false;
		}
		
		
		return pass;

	}

	protected BaseBean populateBean(HttpServletRequest request) {

		PaymentBean bean = new PaymentBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setPaymentType(DataUtility.getString(request.getParameter("paymentType")));
		bean.setAmount(DataUtility.getString(request.getParameter("amount")));
		bean.setCustomerName(DataUtility.getString(request.getParameter("customerName")));
		bean.setMessage(DataUtility.getString(request.getParameter("message")));
		



		populateDTO(bean, request);

		return bean;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doget chali...!!!!!");
		String op = DataUtility.getString(request.getParameter("operation"));
		PaymentModel model = new PaymentModel();
		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0 || op != null) {

			PaymentBean bean = new PaymentBean();
			
			try {
				bean = model.findByPK(id);

				System.out.println(bean);
				ServletUtility.setBean(bean, request);
				// ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		System.out.println("forwrd chalii...............");
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println("dopost chali....");
		System.out.println(op);
		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println(id);
		PaymentModel model = new PaymentModel();

		// if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
		PaymentBean bean = (PaymentBean) populateBean(request);

		if (OP_UPDATE.equalsIgnoreCase(op)) {

			if (id > 0) {
				/*
				 * bean.setId(id);
				 */				try {
					model.update(bean);
				} catch (Exception e) {
					e.printStackTrace();
				}

				ServletUtility.setBean(bean, request);

				System.out.println(bean);

				ServletUtility.setSuccessMessage("Payment is successfully Updated", request);

			}
		} else if (OP_SAVE.equalsIgnoreCase(op)) {
			System.out.println(" U ctl DoPost 33333");
			
			try {
				long pk = model.add(bean);
				/* bean.setId(pk); */
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ServletUtility.setSuccessMessage("Payment is successfully Added", request);

		} else if (OP_DELETE.equalsIgnoreCase(op)) {

			try {
				model.delete(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ServletUtility.redirect(ORSView.PAYMENT_CTL, request, response);
			return;

			
			
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			System.out.println(" U  ctl Do post 77777");

			ServletUtility.redirect(ORSView.PAYMENT_LIST_CTL, request, response);
			return;
		}
		System.out.println("forword");
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {

		return ORSView.PAYMENT_VIEW;

	}
}