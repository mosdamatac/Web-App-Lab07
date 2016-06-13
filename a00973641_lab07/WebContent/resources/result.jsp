<%@ page import="java.util.List, java.sql.ResultSet, a00973641.data.MetaDataBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQL Result</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/style.css"/>
</head>
<body>
<div id="wrapper">
	<header>
		<h2>${initParam.course}</h2>
		<h4>${initParam.author}</h4>
	</header>
	<div id="main">
		<span id = "title">${sessionScope.sqlString }</span>
		<br/><br/>
		<table name="dbMetaData">
			<tr>
				<th>&nbsp;</th>
				<th>Data Type</th>
				<th>Column Width</th>
				<th>Searchable?</th>
				<th>Writeable?</th>
				<th>Nullable?</th>
			</tr>
			
			<%
			List<MetaDataBean> mdBean = (List<MetaDataBean>) request.getAttribute("rsmdMetaData");
			for (MetaDataBean mdb : mdBean) {
			%>
			
			<tr>
				<td><%= mdb.getColumnName() %></td>
				<td><%= mdb.getDataType() %></td>
				<td><%= mdb.getColumnWidth() %></td>
				<td><%= mdb.isSearchable() %></td>
				<td><%= mdb.isWriteable() %></td>
				<td><%= mdb.isNullable() %></td>
			</tr>
						
			<%} %>
		</table>
		
		<br/><br/>
		
		<table name="dbData">
			<tr>
			<% for (MetaDataBean mdb : mdBean) { %>
				<th><%= mdb.getColumnName() %></th>
			<%} %>
			</tr>
		
			<%
			ResultSet rs = (ResultSet) request.getAttribute("resultset");
			while (rs.next()) {
			%>
			<tr>
			<% for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) { %>
				<td><%= rs.getString(i) %></td>			
			<% } %>
			</tr>
			<% } %>
		</table>
		<br/><br/>
	</div>
	<footer>&copy; ${initParam.footer}</footer>
</div>
</body>
</html>