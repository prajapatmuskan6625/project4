<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@page import="com.rays.pro4.controller.DoctorListCtl"%>
<%@page import="com.rays.pro4.Bean.DoctorBean"%>
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
<jsp:useBean id="bean" class="com.rays.pro4.Bean.DoctorBean" scope="request"></jsp:useBean>
	<%@include file="Header.jsp"%>
	<form action="<%=ORSView.DOCTOR_LIST_CTL%>" method="post">

<center>

     <div align="centre">
				<h1>Doctor List</h1>
				<h3>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>
				<% 
				
				List elist = (List) request.getAttribute("expertise");
				
				%>
 
<%
		         			

                    int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;

                    List list = ServletUtility.getList(request);
					Iterator <DoctorBean>it = list.iterator();

                      if (list.size() != 0) {
				%>
				<table width="100%" align="center">
				<tr>
					<th></th>
					<td align="center"><label>Name</font> :
					</label> <input type="text" name="name" onkeydown="return /[a-zA-Z]/i.test(event.key)" maxlength="20" placeholder="Enter  Name"
						value="<%=ServletUtility.getParameter("name", request)%>">
						
						<td align="center"><label>Dob</font> :
					</label> <input type="text" name="dob" placeholder="Enter  Dob" readonly="readonly"id="udatee"
						value="<%=ServletUtility.getParameter("dob", request)%>">
						
						
						
						<td align="center"><label>MobileNo</font> :
					</label> <input type="text" name="mobileNo" placeholder="Enter  mobileNo" oninput="validateMobileNo(event)" name="mobile" maxlength="10"
						value="<%=ServletUtility.getParameter("mobileNo", request)%>">
						
						<%-- <td align="center"><label>Expertise</font> :
					</label> <input type="text" name="expertise" placeholder="Enter Expertise "
						value="<%=ServletUtility.getParameter("expertise", request)%>">
						 --%>
				
					   &emsp; <label>Expertise</font> :
					  </label> <%=HTMLUtility.getList("expertise", String.valueOf(bean.getExpertise()),elist)%>
					 &nbsp;
					  
					 
					 
						 
				 		<input type="submit" name="operation"
						value="<%=DoctorListCtl.OP_SEARCH%>"> &nbsp; <input
						type="submit" name="operation" value="<%=DoctorListCtl.OP_RESET%>">
</td>
</tr>
				
				
					<table border="1" width="100%" align="centre" cellpadding=6px
						cellspacing=".2">
						<tr style="background: skyblue">
							<th><input type="checkbox" id="select_all" name="select">Select
								All</th>

                        <th>S.No.</th>
						<th>Name</th>
						<th>Date Of Birth</th>
						<th>Mobile No</th>
						<th>Expertise</th>
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
						<td><%=bean.getDob()%></td>
						<td><%=bean.getMobileNo()%></td>
						<td><%=bean.getExpertise()%></td>
						
						<td><a href="DoctorCtl?id=<%=bean.getId()%>">Edit</a></td>
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
						value="<%=DoctorListCtl.OP_PREVIOUS%>"></td>
					<%
						} else {
					%>
					<td><input type="submit" name="operation"
						value="<%=DoctorListCtl.OP_PREVIOUS%>"></td>
					<%
						}
					%>


					<td><input type="submit" name="operation"
						value="<%=DoctorListCtl.OP_DELETE%>"></td>
						
					<td><input type="submit" name="operation"
						value="<%=DoctorListCtl.OP_NEW%>"></td>

					<td align="right"><input type="submit" name="operation"
						value="<%=DoctorListCtl.OP_NEXT%>"
						<%=(list.size() < pageSize) ? "disabled" : ""%>></td>




				</tr>
			</table>
					

<%
						}
						if (list.size() == 0) {
					%>
					<td align="centre"><input type="submit" name="operation"
						value="<%=DoctorListCtl.OP_BACK%>"> &nbsp; &nbsp;</td>
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