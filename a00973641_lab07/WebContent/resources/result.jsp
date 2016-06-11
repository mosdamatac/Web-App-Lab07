<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		</table>
		
		<table name="dbData">
		</table>

	</div>
	<footer>&copy; ${initParam.footer}</footer>
</div>
</body>
</html>