<%@ include file="header.jsp" %>

<div class="span10">
    <div class="question-title-block span10">
        <h3>${question.title}</h3>
    </div>
    <div class="question-text-block span10">
        <div id="question-likes">
            <a class="btn btn-mini like-btn vote-up" onclick="questionGetAjax.questionLike()"><i class="icon-chevron-up"></i></a>
            <span class="vote-counter">${question.likes}</span>
            <a class="btn btn-mini dislike-btn vote-down" onclick="questionGetAjax.questionDislike()"><i class="icon-chevron-down"></i></a>
        </div>
        <div class="question-text-container">
            <p>${question.text}</p>
        </div>
        <div class="question-block-date">
            <spring:message code="asked"/>
            <span><joda:format value="${question.postingDate}" pattern="yyyy-MM-dd HH:mm"/></span>
        </div>
        <div class="answers-block-counter">
            <h4>${fn:length(question.answers)} <spring:message code="answersCapital"/></h4>
        </div>
    </div>
    <div class="answers-block span10">
        <c:forEach var="answer" items="${question.answers}">
            <div class="answer-${answer.id} answer span10">
                <div class="answer-likes-${answer.id} answer-likes">
                    <a class="btn btn-mini like-btn vote-up" onclick="questionGetAjax.answerLike(${answer.id})"><i class="icon-chevron-up"></i></a>
                    <span class="vote-counter">${answer.likes}</span>
                    <a class="btn btn-mini dislike-btn vote-down" onclick="questionGetAjax.answerDislike(${answer.id})"><i class="icon-chevron-down"></i></a>
                </div>
                <div class="answer-text">
                    <p>${answer.text}</p>
                </div>
                <div class="answer-delete">
                    <a class="btn btn-small" onclick="questionGetAjax.deleteAnswer('/answers/delete/${answer.id}')">
                        <spring:message code="deleteAnswer"/>
                    </a>
                </div>
                <div class="answer-date">
                    <spring:message code="answered"/>
                    <span><joda:format value="${answer.postingDate}" pattern="yyyy-MM-dd HH:mm"/></span>
                </div>
            </div>
        </c:forEach>
    </div>
    <div id="answer-form">
        <form:form modelAttribute="answer" action="/answers/add" method="post">
            <div class="answer-form-text">
                <h3><spring:message code="yourAnswer"/></h3>
                <form:textarea path="text"/>
                <form:errors path="text" cssClass="text-error"/>
                <input type="hidden" id="questionId" name="questionId" value="${question.id}"/>
            </div>
            <div>
                <input type="submit" class="btn btn-primary" value="<spring:message code="postYourQuestion"/>"/>
            </div>
        </form:form>
    </div>
</div>

<script src="<spring:url value="/resources/js/questionGetAjax.js"/>" defer></script>

<%@ include file="footer.jsp" %>