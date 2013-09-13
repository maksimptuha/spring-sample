<%@ include file="header.jsp" %>

<div class="question-form span10">
    <form:form modelAttribute="question" action="/questions/add" method="post">
        <div class="question-title">
            <form:label path="title">
                <strong>
                    <spring:message code="title"/>
                </strong>
            </form:label>
            <spring:message var="inputPlaceholder" code="inputPlaceholder"/>
            <form:input path="title" maxlength="100" placeholder="${inputPlaceholder}" autocomplete="off"/>
            <form:errors path="title" cssClass="text-error"/>
        </div>
        <div class="question-text">
            <form:textarea path="text"/>
            <form:errors path="text" cssClass="text-error"/>
        </div>
        <div>
            <input type="submit" value="<spring:message code="postYourQuestion"/>"/>
        </div>
    </form:form>
</div>

<%@ include file="footer.jsp" %>