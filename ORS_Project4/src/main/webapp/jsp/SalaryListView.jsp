<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@page import="com.rays.pro4.controller.SalaryListCtl"%>
<%@page import="com.rays.pro4.Bean.SalaryBean"%>
<%@page import="java.util.Iterator"%>
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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#udatee").datepicker({
			changeMonth : true,
			changeYear : true,
			yearRange : '1980:2002',
		//dateFormat:'yy-mm-dd'
		});
	});
</script>
<body>
	<jsp:useBean id="bean" class="com.rays.pro4.Bean.SalaryBean"
		scope="request"></jsp:useBean>
	<%@include file="Header.jsp"%>
	<form action="<%=ORSView.SALARY_LIST_CTL%>" method="post">

		<center>

			<div align="centre">
				<h1>Salary List</h1>
				<h3>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>

				<%
					List slist = (List) request.getAttribute("status");
					List elist = (List) request.getAttribute("employee");
				%>

				<%
					int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;

					List list = ServletUtility.getList(request);
					Iterator<SalaryBean> it = list.iterator();

					if (list.size() != 0) {
				%>
				<table width="100%" align="center">
					<tr>
					<th></th>
					 
						<%-- <td align="center"><label>Employee</font> :
					</label> <input type="text" name="employee" placeholder="Enter  Employee"
						value="<%=ServletUtility.getParameter("employee", request)%>">
						  --%>
					
					<td align="center"><label>Amount</font> :
					</label> <input type="number" name="amount" placeholder="Enter  Amount"
						value="<%=ServletUtility.getParameter("amount", request)%>">
						
							
						<label>Employee</font> :
						</label>
						<%=HTMLUtility.getList("employee", String.valueOf(bean.getEmployee()), elist)%>
						&emsp;&nbsp;
						
						<td align="center"><label>Dob</font> :
						</label> <input type="text" name="dob" placeholder="Enter  Dob"
							id="udatee"
							value="<%=ServletUtility.getParameter("dob", request)%>">
							&nbsp;

							<%-- 
						<td align="center"><label>Status</font> :
					</label> <input type="text" name="status" placeholder="Enter status "
						value="<%=ServletUtility.getParameter("status", request)%>">
						
						 --%> <label>Status</font> :
						</label> <%=HTMLUtility.getList("status", String.valueOf(bean.getStatus()), slist)%>





							<input type="submit" name="operation"
							value="<%=SalaryListCtl.OP_SEARCH%>"> &nbsp; <input
							type="submit" name="operation"
							value="<%=SalaryListCtl.OP_RESET%>"></td>
					</tr>


					<table border="1" width="100%" align="centre" cellpadding=6px
						cellspacing=".2">
						<tr style="background: skyblue">
							<th><input type="checkbox" id="select_all" name="select">Select
								All</th>

							<th>S.No.</th>
							<th>Employee</th>
							<th>Amount</th>
							<th>Dob</th>
							<th>Status</th>
							<th>Edit</th>
						</tr>
						<%
							while (it.hasNext()) {
									bean = it.next();
						%>
						<tr align="centre">

							<td><input type="checkbox" class="checkbox" name="ids"
								value="<%=bean.getId()%>"></td>

							<td><%=index++%></td>
							<td><%=bean.getEmployee()%></td>
							<td><%=bean.getAmount()%></td>
							<td><%=bean.getDob()%></td>
							<td><%=bean.getStatus()%></td>

							<td><a href="SalaryCtl?id=<%=bean.getId()%>">Edit</a></td>
						</tr>
						<%
							}
						%>

						<table width="100%">

							<tr>
								<th></th>
								<%
									if (pageNo == 1) {
								%>
								<td><input type="submit" name="operation"
									disabled="disabled" value="<%=SalaryListCtl.OP_PREVIOUS%>"></td>
								<%
									} else {
								%>
								<td><input type="submit" name="operation"
									value="<%=SalaryListCtl.OP_PREVIOUS%>"></td>
								<%
									}
								%>


								<td><input type="submit" name="operation"
									value="<%=SalaryListCtl.OP_DELETE%>"></td>

								<td><input type="submit" name="operation"
									value="<%=SalaryListCtl.OP_NEW%>"></td>

								<td align="right"><input type="submit" name="operation"
									value="<%=SalaryListCtl.OP_NEXT%>"
									<%=(list.size() < pageSize) ? "disabled" : ""%>></td>




							</tr>
						</table>


						<%
							}
							if (list.size() == 0) {
						%>
						<td align="centre"><input type="submit" name="operation"
							value="<%=SalaryListCtl.OP_BACK%>"> &nbsp; &nbsp;</td>
						<%
							}
						%>
						</tr>
					</table>
					<br>

				</table>

				</table>
	</form>
	</br>
	</br>
	</br>
	</br>

	</center>

	<%@include file="Footer.jsp"%>



</body>
</html>