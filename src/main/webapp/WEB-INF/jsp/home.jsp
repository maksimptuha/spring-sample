<%@ include file="header.jsp" %>

<div>
    <c:forEach var="question" items="questions">
        <div>
            <div>
                <div>${fn:length(question.answers)}</div>
                <div>answers</div>
            </div>
            <div>
                <h3>
                    <a href="<spring:url value="/questions/get/${question.id}" htmlEscape="true"/>">${question.title}</a>
                </h3>
                <div>
                    <span><fmt:formatDate value="${question.postingDate}" pattern="yyyy-MM-dd"/></span>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<%@ include file="footer.jsp" %>