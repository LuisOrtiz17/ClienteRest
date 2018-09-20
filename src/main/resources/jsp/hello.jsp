<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Spring Boot</title>
</head>
    <body>     
        <p th:text="${saludo}"/>
        <h1>Luis Ortiz whit JSP</h1>
        <p th:text="${resultado}">
    </body>
</html>