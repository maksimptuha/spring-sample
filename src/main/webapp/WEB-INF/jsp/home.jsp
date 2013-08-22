<%@ include file="header.jsp" %>

<c:forEach var="question" items="${questions}">
    <div>
        <div>
            <div>${fn:length(question.answers)}</div>
            <div>answers</div>
        </div>
        <div>
            <h3>
                <a href="<spring:url value="/questions/get/${question.id}"/>">
                    ${question.title}
                </a>
            </h3>
            <div>
                <a class="btn btn-large" href="<spring:url value="/questions/delete/${question.id}"/>">Delete Question</a>
            </div>
            <div>
                <span><fmt:formatDate value="${question.postingDate}" type="both"/></span>
            </div>
        </div>
    </div>
</c:forEach>

<%@ include file="footer.jsp" %>