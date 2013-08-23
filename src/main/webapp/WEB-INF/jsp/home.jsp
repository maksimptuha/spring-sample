<%@ include file="header.jsp" %>

<c:forEach var="question" items="${questions}">
    <div class="question-${question.id}">
        <div>
            <div>${fn:length(question.answers)}</div>
            <div><spring:message code="answers"/></div>
        </div>
        <div>
            <h3>
                <a href="<spring:url value="/questions/get/${question.id}"/>">
                    ${question.title}
                </a>
            </h3>
            <div>
                <a class="btn btn-large" onclick="homeAjax.deleteQuestion('/questions/delete/${question.id}')">
                    <spring:message code="deleteQuestion"/>
                </a>
            </div>
            <div>
                <span><fmt:formatDate value="${question.postingDate}" pattern="yyyy-MM-dd HH:mm"/></span>
            </div>
        </div>
    </div>
</c:forEach>

<script src="<spring:url value="/resources/js/homeAjax.js"/>" defer></script>

<%@ include file="footer.jsp" %>