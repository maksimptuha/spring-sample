<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Spring Sample</title>
    <link href="<spring:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<spring:url value="/resources/css/bootstrap-responsive.min.css"/>" rel="stylesheet"/>
    <link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
    <div id="main" class="span10">
        <div class="lang-menu">
            <p>
                <a href="?lang=en">English</a>
                | <a href="?lang=ru">Русский</a>
            </p>
        </div>
        <div class="navbar">
            <div class="menu navbar-inner span10">
                <a class="brand">Spring Sample</a>
                <ul class="unstyled nav">
                    <li>
                        <a href="<spring:url value="/home"/>"><spring:message code="questions"/></a>
                    </li>
                    <li>
                        <a href="<spring:url value="/questions/ask"/>"><spring:message code="askQuestion"/></a>
                    </li>
                </ul>
             </div>
        </div>

        <div class="container span10">