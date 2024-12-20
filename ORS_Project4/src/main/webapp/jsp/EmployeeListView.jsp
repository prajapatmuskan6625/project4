<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@page import="com.rays.pro4.controller.EmployeeListCtl"%>
<%@page import="com.rays.pro4.Bean.EmployeeBean"%>
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
<body>
<jsp:useBean id="bean" class="com.rays.pro4.Bean.EmployeeBean" scope="request"></jsp:useBean>
	<%@include file="Header.jsp"%>
	<form action="<%=ORSView.EMPLOYEE_LIST_CTL%>" method="post">

<center>

     <div align="centre">
				<h1>Employee List</h1>
				<h3>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>
				<% 
				
				List dlist = (List) request.getAttribute("department");
				%>
<%
		         			

                    int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;

                    List list = ServletUtility.getList(request);
					Iterator <EmployeeBean>it = list.iterator();

                      if (list.size() != 0) {
				%>
				<!-- <table width="100%" align="center">-->
				
		
				<tr>
					<th></th>
					<td align="center"><label>Name</font> :
					</label> <input type="text" name="name" placeholder="Enter  Name" onkeydown="return /[a-zA-Z]/i.test(event.key)" maxlength="20"
						value="<%=ServletUtility.getParameter("name", request)%>">
						&emsp;
						  &emsp;
						<%-- 
						<td align="center"><label>Department</font> :
					</label> <input type="text" name="department" placeholder="Enter department"
						value="<%=ServletUtility.getParameter("department", request)%>">
						 --%>
						 
						  &emsp; <label>Department</font> :
					  </label> <%=HTMLUtility.getList("department", String.valueOf(bean.getDepartment()),dlist)%>
					 
					
						&emsp;<td align="center"><label>Salary</font> :
					</label> <input type="text" name="salary" placeholder="Enter Salary"
						value="<%=ServletUtility.getParameter("salary", request)%>">
						 
						
						
						<input type="submit" name="operation"
						value="<%=EmployeeListCtl.OP_SEARCH%>"> &nbsp; <input
						type="submit" name="operation" value="<%=EmployeeListCtl.OP_RESET%>">
</td>
</tr>
				
				<table border="1" width="100%" align="centre" cellpadding=6px
					cellspacing=".2">
					<tr style="background: skyblue">
						<th><input type="checkbox" id="select_all" name="select">Select
							All</th>

                        <th>S.No.</th>
						<th>Name</th>
						<th>Gender</th>
						<th>Salary</th>
						<th>Department</th>
						<th>Edit</th>
					</tr>
					<%
						while (it.hasNext()) {
								bean = it.next();
					%>
					<tr align="centre">

     <td><input type="checkbox" class="checkbox" name="ids" value="<%=bean.getId()%>"></td>

                         <td><%=index++%></td>
						<td><%=bean.getName()%></td>
						<td><%=bean.getGender()%></td>
						<td><%=bean.getSalary()%></td>
						<td><%=bean.getDepartment()%></td>
						
						<td><a href="EmployeeCtl?id=<%=bean.getId()%>">Edit</a></td>
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
						value="<%=EmployeeListCtl.OP_PREVIOUS%>"></td>
					<%
						} else {
					%>
					<td><input type="submit" name="operation"
						value="<%=EmployeeListCtl.OP_PREVIOUS%>"></td>
					<%
						}
					%>


					<td><input type="submit" name="operation"
						value="<%=EmployeeListCtl.OP_DELETE%>"></td>
						
					<td><input type="submit" name="operation"
						value="<%=EmployeeListCtl.OP_NEW%>"></td>

					<td align="right"><input type="submit" name="operation"
						value="<%=EmployeeListCtl.OP_NEXT%>"
						<%=(list.size() < pageSize) ? "disabled" : ""%>></td>




				</tr>
			</table>
					
					

<%
						}
						if (list.size() == 0) {
					%>
					<td align="centre"><input type="submit" name="operation"
						value="<%=EmployeeListCtl.OP_BACK%>"></td>
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