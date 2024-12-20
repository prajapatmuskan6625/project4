<%@page import="java.util.List"%>
<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.rays.pro4.controller.JobCtl"%>
<%@page import="com.rays.pro4.controller.BaseCtl"%>
<%@page import="com.rays.pro4.Util.DataUtility"%>
<%@page import="com.rays.pro4.Util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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


<title>Insert title here</title>
</head>

<body>
	<jsp:useBean id="bean" class="com.rays.pro4.Bean.JobBean"
		scope="request"></jsp:useBean>
	<%@ include file="Header.jsp"%>

	<center>

		<form action="<%=ORSView.JOB_CTL%>" method="post">

			<div align="center">





				<%
					// List dlist= (List) request.getAttribute("dList");

					/* List Slist = (List) request.getAttribute("status"); */
					//List DList = (List) request.getAttribute("dob");
					 HashMap map = (HashMap) request.getAttribute("statuss");
				%>

				<h1>
					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<tr>
						<th><font size="5px"> Update Job </font></th>
					</tr>
					<%
						} else {
					%>
					<tr>
						<th><font size="5px"> Add Job </font></th>
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
					<th align="left">Title<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="title" placeholder="Enter Title"onkeydown="return /[a-zA-Z]/i.test(event.key)" maxlength="20"
						size="25" value="<%=DataUtility.getStringData(bean.getTitle())%>"></td>
					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("title", request)%></font></td>

				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>
				<tr>
					<th align="left">DateOfOpening<span style="color: red">*</span>
						:
					</th>
					<td><input type="text" name="DateOfOpening" id="udatee" readonly="readonly"
						placeholder="Enter DateOfOpening" size="25" 
						
						value="<%=DataUtility.getDateString(bean.getDateOfOpening())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("DateOfOpening", request)%></font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">Experience<span style="color: red">*</span>:
					</th>
					<td><input type="text" name="experience"
						placeholder="Enter Experience " size="25"
						value="<%=DataUtility.getStringData(bean.getExperience())%>"></td>
					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("experience", request)%></font></td>

				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>


				<tr>
					<th align="left">Status Role <span style="color: red">*</span>
						:
					</th>
					<td><%=HTMLUtility.getList("status", String.valueOf(bean.getStatus()), map)%></td>
					<td style="position: fixed"><font style="position: fixed"
						color="red"> <%=ServletUtility.getErrorMessage("status", request)%></font></td>
				</tr>


<%-- 
		 <tr>
					<th align="left">status  <span style="color: red">*</span> :
					</th>
					<td><input type="text"  name="status"
						maxlength="10" placeholder="Enter Job Name" size="25"
						value="<%=DataUtility.getStringData(bean.getStatus())%>"></td>
					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("status", request)%></font></td>
				</tr>  --%>
				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<%-- <th align="left">JobName <span style="color: red">*</span> :
				</th>
				<td>
					<%
						HashMap map = new HashMap();
						map.put("SBI", "SBI");
						map.put("BOB", "BOB");
						map.put("CANARA", "CANARA");
						map.put("KOTAK", "KOTAK");
						map.put("ICICI", "ICICI");

						String blist = HTMLUtility.getList("JobName", String.valueOf(bean.getId()), map);
					%> <%=blist%>
				<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("JobName", request)%></font></td>
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
							name="operation" value="<%=JobCtl.OP_UPDATE%>"> &nbsp;
							&nbsp; <input type="submit" name="operation"
							value="<%=JobCtl.OP_CANCEL%>"></td>

						<%
							} else {
						%>



						<td colspan="2"><input type="submit" name="operation"
							value="<%=JobCtl.OP_SAVE%>">&nbsp; &nbsp; <input
							type="submit" name="operation" value="<%=JobCtl.OP_RESET%>"></td>
						</center>
						<%
							}
						%>
					</tr>
				</table>
				<input type="hidden" name=id value="<%=bean.getId() %>>">
			</table>
	</center>

	<%@ include file="Footer.jsp"%>






</body>
</html>
