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
import com.rays.pro4.Model.PaymentModel;
import com.rays.pro4.Model.PaymentRoleModel;
import com.rays.pro4.Util.DataUtility;
import com.rays.pro4.Util.PropertyReader;
import com.rays.pro4.Util.ServletUtility;

@WebServlet(name = "PaymentListCtl", urlPatterns = { "/ctl/PaymentListCtl" })
public class PaymentListCtl extends BaseCtl {

	@Override
	protected void preload(HttpServletRequest request) {

		//PaymentModel umodel = new PaymentModel();
		PaymentRoleModel pmodel = new PaymentRoleModel();


		try {

			//List ulist = umodel.list(0, 0);
			List plist = pmodel.list(0, 0);

			//request.setAttribute("Amount", ulist);
			request.setAttribute("paymentType", plist);
			

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		PaymentBean bean = new PaymentBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setPaymentType(DataUtility.getString(request.getParameter("paymentType")));
		bean.setAmount(DataUtility.getString(request.getParameter("amount")));
		bean.setCustomerName(DataUtility.getString(request.getParameter("customerName")));
		bean.setMessage(DataUtility.getString(request.getParameter("message")));

		return bean;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("do get chalii.....");
		List list = null;
		List nextList = null;
		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		PaymentBean bean = (PaymentBean) populateBean(request);
		PaymentModel model = new PaymentModel();

		try {

			list = model.search(bean, pageNo, pageSize);
			System.out.println("list" + list);

			nextList = model.search(bean, pageNo + 1, pageSize);
			request.setAttribute("nextlist", nextList.size());

		} catch (ApplicationException e) {

			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {

			e.printStackTrace();
		}

		ServletUtility.setList(list, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PaymentListCtl doPost Start");
		List list = null;
		List nextList = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;

		String op = DataUtility.getString(request.getParameter("operation"));
		PaymentBean bean = (PaymentBean) populateBean(request);

		String[] ids = request.getParameterValues("ids");
		PaymentModel model = new PaymentModel();

		if (OP_SEARCH.equalsIgnoreCase(op)) {
			System.out.println("search chali");
			pageNo = 1;
		} else if (OP_NEXT.equalsIgnoreCase(op)) {
			pageNo++;
		} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
			pageNo--;
		} else if (OP_NEW.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.PAYMENT_CTL, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.PAYMENT_LIST_CTL, request, response);
			return;

		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			pageNo = 1;
			if (ids != null && ids.length > 0) {
				PaymentBean deletebean = new PaymentBean();
				for (String id : ids) {
					deletebean.setId(DataUtility.getInt(id));
					try {
						model.delete(deletebean);
					} catch (ApplicationException e) {
//						log.error(e);
						ServletUtility.handleException(e, request, response);
						return;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					ServletUtility.setSuccessMessage("Payment is Deleted Successfully", request);
				}
			} else {
				ServletUtility.setErrorMessage("Select at least one record", request);
			}
		}
		try {

			list = model.search(bean, pageNo, pageSize);
			nextList = model.search(bean, pageNo + 1, pageSize);
			request.setAttribute("nextList", nextList.size());

		} catch (ApplicationException e) {

			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {

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
		System.out.println("in getView method " + ORSView.PAYMENT_LIST_CTL);
		return ORSView.PAYMENT_LIST_VIEW;
	}

}
