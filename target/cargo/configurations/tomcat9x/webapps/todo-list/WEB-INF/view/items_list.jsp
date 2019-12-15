<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Todo Items</title>
    <style><%@include file="/WEB-INF/view/styles/items_list.css"%></style>
</head>
<body>
    <div align="center">


        <table border="1" cellpadding="5">

            <caption><h2>Todo Items</h2></caption>

            <tr id="ColNames">
                <th>Title</th>
                <th>Deadline</th>
                <th>Edit</th>
                <th>Delete</th>
                <th>View</th>
            </tr>

            <c:forEach var="item" items="${todoData.items}">

                <c:url var="editUrl" value="addItem">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var="deleteUrl" value="deleteItem">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                  <c:url var="viewUrl" value="viewItem">
                         <c:param name="id" value="${item.id}"/>
                   </c:url>


                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${editUrl}">Edit</a></td>
                    <td><a href="${deleteUrl}">Delete</a></td>
                    <td><a href="${viewUrl}">View</a></td>
                </tr>
            </c:forEach>
        </table>
        <div id="addNew">
              <c:url var="addUrl" value="addItem"/>
              <a id="newItemText" href="${addUrl}">New Item</a>
         </div>
    </div>

</body>
</html>