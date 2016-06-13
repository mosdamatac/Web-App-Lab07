<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath }/resources/style.css"/>
<title>Lab 07</title>
<script>
	function submitIt(myForm) {
		if (myForm.queryBox.value == "") {
			alert("Input cannot be empty")
			return false
		}
		
		return true
	}
</script>
</head>
<body>
<jsp:include page="/cookie"/>
<div id="wrapper">
	<header>
		<h2>${initParam.course}</h2>
		<h4>${initParam.author}</h4>
	</header>
	<div id="main">
		<span id="title">Database Table Metadata</span><br/><br/><br/>
		Enter the table name:<br/><br/>
		<form action="lab07" name="sqlForm" method="post" onSubmit="return submitIt(this)">
			<input type="text" name="queryBox" value="${requestScope.tbValue }"/><% %><br/><br/>
			<input type="submit" value="Enter SELECT Query" name="submitQuery" class="button"/><br/><br/>
		</form>
		<br/>
	</div>
	<footer>&copy; ${initParam.footer}</footer>
</div>
</body>
</html>