<%@page import="java.util.List"%>
<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.rays.pro4.controller.EmployeeCtl"%>
<%@page import="com.rays.pro4.controller.BaseCtl"%>
<%@page import="com.rays.pro4.Util.DataUtility"%>
<%@page import="com.rays.pro4.Util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="bean" class="com.rays.pro4.Bean.EmployeeBean"
		scope="request"></jsp:useBean>
	<%@ include file="Header.jsp"%>

	<center>

		<form action="<%=ORSView.EMPLOYEE_CTL%>" method="post">
		
		
			<%
				List dlist = (List)request.getAttribute("departmentt");
			%>
		

			<div align="center">
				<h1>
					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<tr>
						<th><font size="5px"> Update Employee </font></th>
					</tr>
					<%
						} else {
					%>
					<tr>
						<th><font size="5px"> Add Employee </font></th>
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
			<table>
				<tr>
					<th align="left">Name<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="name" placeholder="Enter Name" onkeydown="return /[a-zA-Z]/i.test(event.key)" maxlength="20"
						size="25" value="<%=DataUtility.getStringData(bean.getName())%>"></td>
					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("name", request)%></font></td>

				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>
				<tr>
					<th align="left">Gender <span style="color: red">*</span> :
					</th>
					<td>
						<%
							HashMap map = new HashMap();
							map.put("Male", "Male");
							map.put("Female", "Female");

							String elist = HTMLUtility.getList("gender", String.valueOf(bean.getGender()), map);
						%> <%=elist%>
											</td>
					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("gender", request)%></font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">Salary<span style="color: red">*</span>:
					</th>
					<td><input type="text" name="salary" placeholder="Enter Salary"
						size="25"
						value="<%=DataUtility.getStringData(bean.getSalary())%>"></td>
					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("salary", request)%></font></td>

				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>

			  <%-- <tr>
					<th align="left">Department <span style="color: red">*</span>:
					</th>
					<td><input type="text" name="department"
						placeholder="Enter Department" size="25"
						value="<%=DataUtility.getStringData(bean.getDepartment())%>"></td>
					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("department", request)%></font></td>
				</tr>
				 --%>
				 
				<tr>
					<th align="left">Department <span style="color: red">*</span> :
					</th>
					<td><%=HTMLUtility.getList("department", String.valueOf(bean.getDepartment()), dlist)%></td>
					<td style="position: fixed"><font style="position: fixed"
						color="red"> <%=ServletUtility.getErrorMessage("department", request)%></font></td>
				</tr>
				
				
				
			 <%--  &emsp; <label>Department</font> :
					  </label> <%=HTMLUtility.getList("department", String.valueOf(bean.getDepartment()),dlist)%>
					 &nbsp; 
					  --%>
					 
					 
					 


				<tr>
					<th style="padding: 3px"></th>
				</tr>
				
				<table align="center">
				<tr>
					<%
						if (bean.getId() > 0) {
					%>
					<td colspan="2">&nbsp; &emsp; <input type="submit"
						name="operation" value="<%=EmployeeCtl.OP_UPDATE%>"> &nbsp;
						&nbsp; <input type="submit" name="operation"
						value="<%=EmployeeCtl.OP_CANCEL%>"></td>

					<%
						} else {
					%>

                       

					  <td colspan="2">  
					  <input type="submit" name="operation" value="<%=EmployeeCtl.OP_SAVE%>">&nbsp;
						&nbsp; <input type="submit" name="operation"
						value="<%=EmployeeCtl.OP_RESET%>"></td>
					</center>
					<%
						}
					%>
				</tr>
</table>
			</table>
	</center>

	<%@ include file="Footer.jsp"%>






</body>
</html>
