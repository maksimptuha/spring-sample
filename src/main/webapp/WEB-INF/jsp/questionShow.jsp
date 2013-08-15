<%@ include file="header.jsp" %>

<div>
    <div>
        <h1>${question.title}</h1>
    </div>
    <div>
        <div>
            <div id="question-likes">
                <a href="#">Like</a>
                <span>${question.likes}</span>
                <a href="#">Dislike</a>
            </div>
            <div>
                <p>${question.text}</p>
            </div>
            <div>
                asked
                <span><fmt:formatDate value="${question.postingDate}" pattern="yyyy-MM-dd"/></span>
            </div>
        </div>
        <div>
            <div>
                <h2>${fn:length(question.answers)} Answers</h2>
            </div>
            <c:forEach var="answer" items="${question.answers}">
                <div>
                    <div id="answer-likes">
                        <a href="#">Like</a>
                        <span>${answer.likes}</span>
                        <a href="#">Dislike</a>
                    </div>
                    <div>
                        <p>${answer.text}</p>
                    </div>
                    <div>
                        answered
                        <span><fmt:formatDate value="${answer.postingDate}" pattern="yyyy-MM-dd"/></span>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div>
            <form:form modelAttribute="answer" action="answers/add" method="post">
                <div>
                    <h2>Your Answer</h2>
                    <form:textarea path="text"/>
                </div>
                <div>
                    <input type="submit" value="Post Your Answer"/>
                </div>
            </form:form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>