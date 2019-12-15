<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <style><%@include file="/WEB-INF/view/styles/home.css"%></style>
    <title>Todo List Application</title>
</head>
<body>
    <div align="center">
       <c:url var="itemsUrl" value="items"/>
       <h1>Welcome in my ToDo application!</h1>
       <h2>You can create your ToDo list below. There are also example items that I created for tests. </h2>
       <h2>Enjoy! </h2>
           <a id="showTODO" href="${itemsUrl}">Show Todo Items </a>

    </div>

</body>
</html>