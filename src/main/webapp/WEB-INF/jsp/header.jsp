<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Spring Sample</title>
</head>
<body>
    <div>
        <ul>
            <li>
                <a href="<spring:url value="/" htmlEscape="true"/>">Questions</a>
            </li>
        </ul>
        <div>
            <a href="<spring:url value="/questions/ask"/>">Ask Question</a>
        </div>
    </div>

    <div id="main">