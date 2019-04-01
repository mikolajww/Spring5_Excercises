<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
</script>

<div class="header">
    <h3><spring:message code="label.title"/></h3>
    <span style="float: right">
    	<a style="background-color: white" href="?lang=pl">pl</a> | <a style="background-color: white" href="?lang=en">en</a> | <a style="background-color: white" href="?lang=fr">fr</a> | <a style="background-color: white" href="?lang=ja">ja</a>
	</span>
    <br>

    <form id="langForm" action="" method="get">
	<span style="float: right">
		<select size="1" name="lang" onchange="form.submit()">
	        <option value ="pl">PL</option>
	        <option value ="en">EN</option>
	        <option value ="fr">FR</option>
			<option value ="fr">JA</option>
        </select>
	</span>
    </form>
</div>

