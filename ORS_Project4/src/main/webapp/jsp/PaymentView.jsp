<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@page import="com.rays.pro4.controller.PaymentCtl"%>
<%@page import="com.rays.pro4.Util.DataUtility"%>
<%@page import="com.rays.pro4.Util.ServletUtility"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="bean" class="com.rays.pro4.Bean.PaymentBean"
		scope="request"></jsp:useBean>
	<%@ include file="Header.jsp"%>

	<center>

		<form action="<%=ORSView.PAYMENT_CTL%>" method="post">

			<%
				List plist = (List) request.getAttribute("paymentType");
			%>


			<div align="center">
				<h1>

					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<tr>
						<th><font size="5px"> Update Payment </font></th>
					</tr>
					<%
						} else {
					%>
					<tr>
						<th><font size="5px"> Add Payment </font></th>
					</tr>
					<%
						}
					%>
				</h1>

				<h3>
					<font color="red"> <%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"> <%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>

			</div>
			<input type="hidden" name="id" value="<%=bean.getId()%>"> 
			<input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>">
				 <input type="hidden" name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

			<table>
			
			
			
			<tr>
					<th align="left">CustomerName<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="customerName"
						placeholder="Enter CustomerName" onkeydown="return /[a-zA-Z]/i.test(event.key)" maxlength="20" size="25"
						value="<%=DataUtility.getStringData(bean.getCustomerName())%>"></td>
					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("customerName", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
				</tr>
				
				
				<tr>
					<th align="left">Message<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="message"
						placeholder="Enter Message" onkeydown="return /[a-zA-Z]/i.test(event.key)" maxlength="20" size="25"
						value="<%=DataUtility.getStringData(bean.getMessage())%>"></td>
					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("message", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
				</tr>
				
				
				
				
				
				
				
				<tr>
					<th align="left">PaymentType <span style="color: red">*</span> :
					</th>
					<td><%=HTMLUtility.getList("paymentType", String.valueOf(bean.getPaymentType()), plist)%></td>
					<td style="position: fixed"><font style="position: fixed"
						color="red"> <%=ServletUtility.getErrorMessage("PaymentType", request)%></font></td>
				</tr>
				
				

				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">Amount<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="amount"
						placeholder="Enter Amount" size="25"
						value="<%=DataUtility.getStringData(bean.getAmount())%>"></td>
					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("amount", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th></th>
					<%
						if (bean.getId() > 0) {
					%>
					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation" value="<%=PaymentCtl.OP_UPDATE%>"> &nbsp;
						&nbsp; <input type="submit" name="operation"
						value="<%=PaymentCtl.OP_CANCEL%>"> <%
 	} else {
 %>
					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation" value="<%=PaymentCtl.OP_SAVE%>"> <input
						type="submit" name="operation" value="<%=PaymentCtl.OP_RESET%>">

						<%
							}
						%>
				</tr>
			</table>
		</form>
	</center>

	<%@ include file="Footer.jsp"%>


</body>
</html>