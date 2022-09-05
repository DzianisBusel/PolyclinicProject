<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

    <body>
    <div align="center">
        <head>
            ADMIN Welcome to the Gregory House Polyclinic
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
                    Users id
                </th>
                <th>
                    Doctor room
                </th>
                <th>
                    enabled
                </th>
                <th>
                    First Name
                </th>
                <th>
                    Last Name
                </th>
                <th>
                    Login
                </th>
                <th>
                    Password
                </th>

                <th>
                    Specialization
                </th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                        <div align="center">
                                ${user.id}
                    </td>
                    <td>
                        <div align="center">
                                ${user.doctorRoom}
                    </td>
                    <td>
                        <div align="center">
                                ${user.enabled}
                    </td>
                    <td>
                            ${user.firstName}
                    </td>
                    <td>
                            ${user.lastName}
                    </td>
                    <td>
                        <div align="center">
                                ${user.login}
                    </td>
                    <td>
                        <div align="center">
                                ${user.password}
                    </td>
                    <td>
                        <div align="center">
                                ${user.specialization}
                    </td>
                    <td>
                        <form action="/delete" method="POST">
                            <input type="hidden" name="id" value="${user.id}">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        Add new user
        <form action="/add" method="POST">
            Doctor room:
            <input type="number" name="doctorRoom">
            First name:
            <input type="text" name="firstName">
            Last name:
            <input type="text" name="lastName">
            Login:
            <input type="text" name="login">
            Password:
            <input type="text" name="password">
            Specialization:
            <input type="text" name="specialization">
            Set the role (ROLE_???)
            <input type="text" name="role">
            <input type="submit" value="Add">
    </form>
        Add doctor appointment time
        <form action="/add_time" method="POST">
            Select id doctor:
            <input type="number" name="id">
            Set doctor appointment times (yyyy-mm-dd hh:mm:ss)
            <input type="text" name="time">
            <input type="submit" value="Add">
        </form>
<%--        <form action="/clear_doctimelist" method="POST">--%>
<%--            Clear doctor time list--%>
<%--            <input type="submit" value="Clear">--%>
<%--        </form>--%>
    </div>
    </body>
</html>