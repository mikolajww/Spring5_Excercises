<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head> <title>Address Page</title> </head>
<body>
<h1><spring:message code="label.address"/></h1>
<form:form method="post" action="addAddress.html" modelAttribute="address">
    <table>
        <tr>
            <td><form:hidden path="id"/>
        </tr>
        <tr>
            <td><form:label path="country"><spring:message code="label.country"/></form:label></td>
            <td><form:input path="country" /></td>
        </tr>
        <tr>
            <td><form:label path="city"><spring:message code="label.city"/></form:label></td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td><form:label path="street"><spring:message code="label.street"/></form:label></td>
            <td><form:input path="street" /></td>
        </tr>
        <tr>
            <td><form:label path="houseNo"><spring:message code="label.houseNo"/></form:label></td>
            <td><form:input path="houseNo" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${address.id==0}">
                    <input type="submit" value="<spring:message code="label.addAddress"/>"/>
                </c:if>
                <c:if test="${address.id!=0}">
                    <input type="submit" value="<spring:message code="label.editAddress"/>"/>
                </c:if>
            </td>
        </tr>
    </table>

    <h3><spring:message code="label.addressList"/></h3>
    <c:if  test="${!empty addressList}">
        <table class="data">
            <tr>
                <th><spring:message code="label.country"/></th>
                <th><spring:message code="label.city"/></th>
                <th><spring:message code="label.street"/></th>
                <th><spring:message code="label.houseNo"/></th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${addressList}" var="address">
                <tr>
                    <td>${address.country} </td>
                    <td>${address.city} </td>
                    <td>${address.street}</td>
                    <td>${address.houseNo}</td>
                    <td><a href="address/delete/${address.id}.html">delete</a></td>
                    <td><a href="address.html?addressId=${address.id}">edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</form:form>
</body>
</html>

