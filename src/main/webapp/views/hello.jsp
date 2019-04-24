<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Hello world!</title>
</head>
<body>
<h3><spring:message code="label.greeting"/></h3>

<br/>
${serverTime}

<br/>
${message}

</body>
</html>
