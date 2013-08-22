<%@ include file="header.jsp" %>

<form:form modelAttribute="question" action="/questions/add" method="post">
    <div>
        <form:label path="title">Title</form:label>
        <form:input path="title" maxlength="100"/>
    </div>
    <div>
        <form:textarea path="text"/>
    </div>
    <div>
        <input type="submit" value="Post Your Question"/>
    </div>
</form:form>

<%@ include file="footer.jsp" %>