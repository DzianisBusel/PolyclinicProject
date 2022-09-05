<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<div align="center">
    <head>
        PATIENT Welcome to the Gregory House Polyclinic
        <a href="/login">Exit</a>
        <style>
            table, th, tr, td {
                border: 1px solid;
            }
        </style>
    </head>
    <table>
        <tr>
            <th>
                Specialization
            </th>
            <th>
                First Name
            </th>
            <th>
                Last Name
            </th>
            <th>
                Doctor room
            </th>
            <th>
                Date
            </th>

        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                    <div align="center">
                            ${user.specialization}
                </td>
                <td>
                        ${user.firstName}
                </td>
                <td>
                        ${user.lastName}
                </td>
                <td>
                    <div align="center">
                            ${user.doctorRoom}
                </td>
                <td>
                    <form action="/book" method="POST">
                        <input type="hidden" name="doctorId" value="${user.id}"/>
                        <select name="time">
                            <c:forEach var="availableTime" items="${user.availableTimes}">
                                <option> ${availableTime} </option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Book">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
