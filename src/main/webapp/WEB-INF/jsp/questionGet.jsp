<%@ include file="header.jsp" %>

<div>
    <h1>${question.title}</h1>
</div>
<div>
    <div>
        <div id="question-likes">
            <a class="btn btn-mini like-btn" onclick="ajaxHandler.questionLike()"><i class="icon-chevron-up"></i></a>
            <span>${question.likes}</span>
            <a class="btn btn-mini dislike-btn" onclick="ajaxHandler.questionDislike()"><i class="icon-chevron-down"></i></a>
        </div>
        <div>
            <p>${question.text}</p>
        </div>
        <div>
            asked
            <span><fmt:formatDate value="${question.postingDate}" type="both"/></span>
        </div>
    </div>
    <div>
        <div>

            <h2>${fn:length(question.answers)} Answers</h2>
        </div>
        <c:forEach var="answer" items="${question.answers}">
            <div>
                <div id="answer-likes-${answer.id}">
                    <a class="btn btn-mini like-btn" onclick="ajaxHandler.answerLike(${answer.id})"><i class="icon-chevron-up"></i></a>
                    <span>${answer.likes}</span>
                    <a class="btn btn-mini dislike-btn" onclick="ajaxHandler.answerDislike(${answer.id})"><i class="icon-chevron-down"></i></a>
                </div>
                <div>
                    <p>${answer.text}</p>
                </div>
                <div>
                    <a class="btn btn-large" href="<spring:url value="/answers/delete/${question.id}/${answer.id}"/>">Delete Answer</a>
                </div>
                <div>
                    answered
                    <span><fmt:formatDate value="${answer.postingDate}" type="both"/></span>
                </div>
            </div>
        </c:forEach>
    </div>
    <div>
        <form:form id="answerForm" modelAttribute="answer" action="/answers/add" method="post">
            <div>
                <h2>Your Answer</h2>
                <form:textarea path="text"/>
                <input type="hidden" id="questionId" name="questionId" value="${question.id}"/>
            </div>
            <div>
                <input type="submit" value="Post Your Answer"/>
            </div>
        </form:form>
    </div>
</div>

<script src="<spring:url value="/resources/js/ajaxHandler.js"/>" defer></script>

<%@ include file="footer.jsp" %>