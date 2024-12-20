<%@page import="com.rays.pro4.Util.DataUtility"%>
<%@page import="com.rays.pro4.controller.ORSView"%>
<%@page import="com.rays.pro4.Util.HTMLUtility"%>
<%@page import="com.rays.pro4.controller.WishListCtl"%>
<%@page import="com.rays.pro4.Bean.WishBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.pro4.Util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WishList View</title>
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


</head>
<body>

	<jsp:useBean id="bean" class="com.rays.pro4.Bean.WishBean"
		scope="request"></jsp:useBean>


	<%@include file="Header.jsp"%>
	<form action="<%=ORSView.WISH_LIST_CTL%>" method="post">

		<center>

			<div align="centre">
				<h1>Wish List</h1>
				<h3>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>

				<%
					List plist = (List) request.getAttribute("product");
				   // List dlist = (List) request.getAttribute("dlist");
				
				%>




				<%
					int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;

					List list = ServletUtility.getList(request);
					Iterator<WishBean> it = list.iterator();
					if (list.size() != 0) {
				%>
				
			 	<table width="100%" align="center">
			 	<th><th/>
					<tr> 
					
		        <td align="center"><label>Date</font> :
					</label> <input type="text" name="date" placeholder="Enter  Date" readonly="readonly" id="udatee"
						value="<%=ServletUtility.getParameter("date", request)%>">
						
					<td align="center"><label>UserName</font> :
						</label> <input type="text" name="userName" placeholder="Enter  UserName" onkeydown="return /[a-zA-Z]/i.test(event.key)" maxlength="20"
							value="<%=ServletUtility.getParameter("userName", request)%>">
							&emsp;&nbsp;
							
						&emsp;&nbsp;<label>Product</font> :
						</label><%=HTMLUtility.getList("product", String.valueOf(bean.getProduct()), plist)%>&emsp;&nbsp;
	
						<td><input type="submit" name="operation"
							value="<%=WishListCtl.OP_SEARCH%>"> <input
							type="submit" name="operation"
							value="<%=WishListCtl.OP_RESET%>"></td>

					</tr>

					<table border="1" width="100%" align="centre" cellpadding=6px
						cellspacing=".2">
						<tr style="background: skyblue">
							<th><input type="checkbox" id="select_all" name="select">Select
								All</th>

							<th>S.No.</th>
							<th>Product</th>
							<th>Date</th>
							<th>UserName</th>
							<th>Remark</th>



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
							<td><%=bean.getProduct()%></td>
							<td><%=bean.getDate()%></td>
							<td><%=bean.getUserName()%></td>
							<td><%=bean.getRemark()%></td>

							<td><a href="WishCtl?id=<%=bean.getId()%>">Edit</a></td>

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
						value="<%=WishListCtl.OP_PREVIOUS%>"></td>
					<%
						} else {
					%>
					<td><input type="submit" name="operation"
						value="<%=WishListCtl.OP_PREVIOUS%>"></td>
					<%
						}
					%>


					<td><input type="submit" name="operation"
						value="<%=WishListCtl.OP_DELETE%>"></td>
						
					<td><input type="submit" name="operation"
						value="<%=WishListCtl.OP_NEW%>"></td>

					<td align="right"><input type="submit" name="operation"
						value="<%=WishListCtl.OP_NEXT%>"
						<%=(list.size() < pageSize) ? "disabled" : ""%>></td>




				</tr>
			</table>
					
						<%
							}
							if (list.size() == 0) {
						%>
						<td align="centre"><input type="submit" name="operation"
							value="<%=WishListCtl.OP_BACK%>"> &nbsp; &nbsp;</td>
						<%
							}
						%>
						</tr>
						<input type="hidden" name="pageNo" value="<%=pageNo%>">
						<input type="hidden" name="pageSize" value="<%=pageSize%>">
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
