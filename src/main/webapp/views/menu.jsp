<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p><spring:message code="label.menu"/></p>
<a href="/appUsers.html"><spring:message code="label.title"/></a>
<a href="/address.html"><spring:message code="label.titleAddress"/></a>
<br/>
<a href="/exampleOne.html"><spring:message code="label.example"/> 1</a>
<br/>
<a href="/exampleTwo.html"><spring:message code="label.example"/> 2</a>
<br/>
<a href="/exampleThree.html"><spring:message code="label.example"/> 3</a>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<!-- csrf for log out-->
<form action="/logout" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>

<br/>
<div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <p>
            <spring:message code="label.welcome"/> : ${pageContext.request.userPrincipal.name} |
            <a href="javascript:formSubmit()"> Logout</a>
        </p>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <p>
            <a href="/login"> <spring:message code="label.login"/></a>
        </p>
    </c:if>
</div>