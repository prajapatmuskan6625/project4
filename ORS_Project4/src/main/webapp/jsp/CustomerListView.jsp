<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@page import="com.rays.pro4.controller.CustomerListCtl"%>
<%@page import="com.rays.pro4.Bean.CustomerBean"%>
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
			yearRange : '1980:2006',
		//  mindefaultDate : "01-01-1962"
		});
	});
</script>
<script type="text/javascript">
	function validatephone(event) {
		const input = event.target;
		input.value = input.value.replace(/[^0-9.]/g, '')
		if (input.value.length > 0 && input.value[0] <= '5') {
			input.value = '';
		}
	}
</script>
</head>
<body>
	<jsp:useBean id="bean" class="com.rays.pro4.Bean.CustomerBean"
		scope="request"></jsp:useBean>
	<%@include file="Header.jsp"%>
	<form action="<%=ORSView.CUSTOMER_LIST_CTL%>" method="post">

		<center>

			<div align="centre">
				<h1>Customer List</h1>
				<h3>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>


				<%
					 List cList= (List) request.getAttribute("city");

					//List blist = (List) request.getAttribute("BankList");
					//List DList = (List) request.getAttribute("dob");
				%>

				<%
					int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;

					List list = ServletUtility.getList(request);
					Iterator<CustomerBean> it = list.iterator();

					if (list.size() != 0) {
				%>
				<table width="100%" align="center">
					<tr>
						<th></th>
						<label> First Name</font> :
						</label>
						<input type="text" name="firstName"  onkeydown="return /[a-zA-Z]/i.test(event.key)" maxlength="30"
						placeholder="Enter  Name"
							value="<%=ServletUtility.getParameter("firstName", request)%>">
						&nbsp;
					</tr>


					<tr>
						<th></th>
						<label>Company</font> :
						</label>
						<input type="text" name="company" placeholder="Enter  Company"
							value="<%=ServletUtility.getParameter("company", request)%>">
						&nbsp;
					</tr>
					
					<tr>
						<th></th>
						<label>PhoneNo</font> :
						</label>
						<input type="text" name="phoneNo" maxlength="10"  oninput="validatephone(event)"
						name="phoneNo" maxlength="10" size="25"placeholder="Enter  phoneNo"
							value="<%=ServletUtility.getParameter("phoneNo", request)%>">
						&nbsp;
					</tr>


					<label>City Role</font> :
					</label>
					<%= HTMLUtility.getList("city", String.valueOf(bean.getId()), cList)%>
					&nbsp;
 
					<tr>
						<input type="submit" name="operation"
							value="<%=CustomerListCtl.OP_SEARCH%>"> &nbsp;
						<input type="submit" name="operation"
							value="<%=CustomerListCtl.OP_RESET%>">
						</td>
					</tr>


					<table border="1" width="100%" align="centre" cellpadding=6px
						cellspacing=".2">
						<tr style="background: skyblue">
							<th><input type="checkbox" id="select_all" name="select">Select
								All</th>

							<th>S.No.</th>
							<th>FirstName</th>
							<th>LastName</th>
							<th>Date Of Birth</th>
							<th>Gender</th>
							<th>City</th>
							<th>Company</th>
							<th>PhoneNo</th>
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
							<td><%=bean.getFirstName()%></td>
							<td><%=bean.getLastName()%></td>
							<td><%=bean.getDob()%></td>
							<td><%=bean.getGender()%></td>
							<td><%=bean.getCity()%></td>
							<td><%=bean.getCompany()%></td>
							<td><%=bean.getPhoneNo() %></td>
							

							<td><a href="CustomerCtl?id=<%=bean.getId()%>">Edit</a></td>
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
					<td><input type="submit" name="operation" disabled="disabled"
						value="<%=CustomerListCtl.OP_PREVIOUS%>"></td>
					<%
						} else {
					%>
					<td><input type="submit" name="operation"
						value="<%=CustomerListCtl.OP_PREVIOUS%>"></td>
					<%
						}
					%>


					<td><input type="submit" name="operation"
						value="<%=CustomerListCtl.OP_DELETE%>"></td>
						
					<td><input type="submit" name="operation"
						value="<%=CustomerListCtl.OP_NEW%>"></td>

					<td align="right"><input type="submit" name="operation"
						value="<%=CustomerListCtl.OP_NEXT%>"
						<%=(list.size() < pageSize) ? "disabled" : ""%>></td>




				</tr>
			</table>
					


						<%
							}
							if (list.size() == 0) {
						%>
						<td align="centre"><input type="submit" name="operation"
							value="<%=CustomerListCtl.OP_BACK%>"> &nbsp; &nbsp;</td>
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