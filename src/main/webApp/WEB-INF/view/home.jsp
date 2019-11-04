<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>
<head>
    <title>Todo List Application</title>
</head>
<body>
    <div align="center">
       <c:url var="itemsUrl" value="items"/>
           <a href="${itemsUrl}">Show Todo Items </a>

    </div>

</body>
</html>