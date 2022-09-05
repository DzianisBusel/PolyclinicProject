<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

    <body>
    <div align="center">
        <head>

            Doctor!!! Welcome to the Gregory House Polyclinic
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
                    First Name
                </th>
                <th>
                    Last Name
                </th>
                <th>
                    Date
                </th>
            </tr>
            <c:forEach var="ticket" items="${tickets}">
                <tr>

                    <td>
                            ${ticket.patient.firstName}
                    </td>
                    <td>
                            ${ticket.patient.lastName}
                    </td>
                    <td>
                            ${ticket.date}
                        </td>
                </tr>
            </c:forEach>
        </table>

    </div>
    </body>
</html>