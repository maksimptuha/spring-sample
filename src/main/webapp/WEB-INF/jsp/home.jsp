<%@ include file="header.jsp" %>

<c:forEach var="question" items="${questions}">
    <div class="question-${question.id} question-block span10">
        <div class="answer-counter">
            <div class="answer-amount">${fn:length(question.answers)}</div>
            <div><spring:message code="answers"/></div>
        </div>
        <div class="question-container">
            <h3>
                <a href="<spring:url value="/questions/get/${question.id}"/>">
                    ${question.title}
                </a>
            </h3>
            <div class="question-delete">
                <a class="btn btn-small" onclick="homeAjax.deleteQuestion('/questions/delete/${question.id}')">
                    <spring:message code="deleteQuestion"/>
                </a>
            </div>
            <div class="question-date">
                <span><joda:format value="${question.postingDate}" pattern="yyyy-MM-dd HH:mm"/></span>
            </div>
        </div>
    </div>
</c:forEach>

<script src="<spring:url value="/resources/js/homeAjax.js"/>" defer></script>

<%@ include file="footer.jsp" %>