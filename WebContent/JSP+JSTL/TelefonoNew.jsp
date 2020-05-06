<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> telf Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">telefonos</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${telefono != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${telefono == null}">
                            <form action="insert?correo=<c:out value='${correo}' />" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${telefono != null}">
                                    Edit User
                                </c:if>
                                <c:if test="${user == null}">
                                    Add New telefono
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${telefono != null}">
                            <input type="text" name="id" value="<c:out value='${telefono.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Numero</label> <input type="text" value="<c:out value='${telefono.numero}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Tipo</label> <input type="text" value="<c:out value='${telefono.tipo}' />" class="form-control" name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Operadora</label> <input type="text" value="<c:out value='${telefono.operadora}' />" class="form-control" name="country">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>