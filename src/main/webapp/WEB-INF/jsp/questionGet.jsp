<%@ include file="header.jsp" %>

<div>
    <h1>${question.title}</h1>
</div>
<div>
    <div>
        <div id="question-likes">
            <a class="btn btn-mini like-btn" onclick="questionGetAjax.questionLike()"><i class="icon-chevron-up"></i></a>
            <span>${question.likes}</span>
            <a class="btn btn-mini dislike-btn" onclick="questionGetAjax.questionDislike()"><i class="icon-chevron-down"></i></a>
        </div>
        <div>
            <p>${question.text}</p>
        </div>
        <div>
            <spring:message code="asked"/>
            <span><fmt:formatDate value="${question.postingDate}" pattern="yyyy-MM-dd HH:mm"/></span>
        </div>
    </div>
    <div>
        <div>
            <h2>${fn:length(question.answers)} <spring:message code="answersCapital"/></h2>
        </div>
        <c:forEach var="answer" items="${question.answers}">
            <div class="answer-${answer.id}">
                <div class="answer-likes-${answer.id}">
                    <a class="btn btn-mini like-btn" onclick="questionGetAjax.answerLike(${answer.id})"><i class="icon-chevron-up"></i></a>
                    <span>${answer.likes}</span>
                    <a class="btn btn-mini dislike-btn" onclick="questionGetAjax.answerDislike(${answer.id})"><i class="icon-chevron-down"></i></a>
                </div>
                <div>
                    <p>${answer.text}</p>
                </div>
                <div>
                    <a class="btn btn-large" onclick="questionGetAjax.deleteAnswer('/answers/delete/${answer.id}')">
                        <spring:message code="deleteAnswer"/>
                    </a>
                </div>
                <div>
                    <spring:message code="answered"/>
                    <span><fmt:formatDate value="${answer.postingDate}" pattern="yyyy-MM-dd HH:mm"/></span>
                </div>
            </div>
        </c:forEach>
    </div>
    <div id="answerForm">
        <form:form modelAttribute="answer" action="/answers/add" method="post">
            <div>
                <h2><spring:message code="yourAnswer"/></h2>
                <form:textarea path="text"/>
                <form:errors path="text" cssClass="text-error"/>
                <input type="hidden" id="questionId" name="questionId" value="${question.id}"/>
            </div>
            <div>
                <input type="submit" value="Post Your Answer"/>
            </div>
        </form:form>
    </div>
</div>

<script src="<spring:url value="/resources/js/questionGetAjax.js"/>" defer></script>

<%@ include file="footer.jsp" %>