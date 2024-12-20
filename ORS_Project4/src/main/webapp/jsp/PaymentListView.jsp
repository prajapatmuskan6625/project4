<%@page import="com.rays.pro4.controller.PaymentListCtl"%>
<%@page import="com.rays.pro4.Bean.PaymentBean"%>
<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@page import="javax.swing.text.html.HTML"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.rays.pro4.Util.DataUtility"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.pro4.Util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>
<script src="<%=ORSView.APP_CONTEXT%>/js/Checkbox11.js"></script>
<body>
	<jsp:useBean id="bean" class="com.rays.pro4.Bean.PaymentBean"
		scope="request"></jsp:useBean>
	<%@include file="Header.jsp"%>


	<form action="<%=ORSView.PAYMENT_LIST_CTL%>" method="post">

		<center>

			<div align="center">
				<h1>Payment List</h1>
				<h3>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>

			</div>
			<%
				//List ulist = (List) request.getAttribute("Amount");
			List plist = (List) request.getAttribute("paymentType");
			%>

			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;

				List list = ServletUtility.getList(request);
				Iterator<PaymentBean> it = list.iterator();

				if (list.size() != 0) {
			%>
			<table width="100%" align="center">
             &emsp;
				<tr>
					<th></th>
					<td align="center"><label>Amount</font> :
					</label> <input type="text" name="amount" placeholder="Enter  Amount"
						value="<%=ServletUtility.getParameter("amount", request)%>"> 

                 &emsp; <label>PaymentType</font> :
					</label> <%=HTMLUtility.getList("paymentType", String.valueOf(bean.getPaymentType()), plist)%>&nbsp;
					
					
				
 <%-- 
						<label>Amount</font> :
					</label> <%=HTMLUtility.getList("amount", String.valueOf(bean.getAmount()), ulist)%>

 --%> 

						<input type="submit" name="operation"
						value="<%=PaymentListCtl.OP_SEARCH%>"> &nbsp; <input
						type="submit" name="operation"
						value="<%=PaymentListCtl.OP_RESET%>">
			</table>
			<br>

			<table border="1" width="100%" align="center" cellpadding=6px
				cellspacing=".2">
				<tr style="background: skyblue">
					<th><input type="checkbox" id="select_all" name="select">Select
						All</th>

				<th>S.No.</th>
				<th>CustomerName</th>
				<th>Message</th>
				<th>PaymentType</th>
				<th>Amount</th>
				<th>Edit</th>
				</tr>

				<%
					while (it.hasNext()) {
							bean = it.next();
				%>


				<tr align="center">
					<td><input type="checkbox" class="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>

					<td><%=index++%></td>
					<td><%=bean.getCustomerName()%></td>
					<td><%=bean.getMessage()%></td>
					<td><%=bean.getPaymentType()%></td>
					<td><%=bean.getAmount()%></td>


					<td><a href="PaymentCtl?id=<%=bean.getId()%>">edit</td>

				</tr>

				<%
					}
				%>
			</table>

			<table width="100%">

				<tr>
					<th></th>
					<%
						if (pageNo == 1) {
					%>
					<td><input type="submit" name="operation" disabled="disabled"
						value="<%=PaymentListCtl.OP_PREVIOUS%>"></td>
					<%
						} else {
					%>
					<td><input type="submit" name="operation"
						value="<%=PaymentListCtl.OP_PREVIOUS%>"></td>
					<%
						}
					%>


					<td><input type="submit" name="operation"
						value="<%=PaymentListCtl.OP_DELETE%>"></td>
					<td><input type="submit" name="operation"
						value="<%=PaymentListCtl.OP_NEW%>"></td>

					<td align="right"><input type="submit" name="operation"
						value="<%=PaymentListCtl.OP_NEXT%>"
						<%=(list.size() < pageSize) ? "disabled" : ""%>></td>




				</tr>
			</table>
			<%
				}
				if (list.size() == 0) {
			%>
			<td align="center"><input type="submit" name="operation"
				value="<%=PaymentListCtl.OP_BACK%>"></td>
			<%
				}
			%>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
	</form>


	</center>
	<%@include file="Footer.jsp"%>

</body>
</html>