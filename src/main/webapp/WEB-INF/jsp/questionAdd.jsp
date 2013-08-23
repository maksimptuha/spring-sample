<%@ include file="header.jsp" %>

<form:form modelAttribute="question" action="/questions/add" method="post">
    <div>
        <form:label path="title"><spring:message code="title"/></form:label>
        <form:input path="title" maxlength="100"/>
        <form:errors path="title" cssClass="text-error"/>
    </div>
    <div>
        <form:textarea path="text"/>
        <form:errors path="text" cssClass="text-error"/>
    </div>
    <div>
        <input type="submit" value="<spring:message code="postYourQuestion"/>"/>
    </div>
</form:form>

<%@ include file="footer.jsp" %>