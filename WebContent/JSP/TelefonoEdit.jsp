<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
        <html>

        <head>
            <title>Modificar Telefono</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>
        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: black">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> APP Agenda </a>
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


                
                       
                         <form action="<%=request.getContextPath()%>/ActualizarTelefonoController?id='${id}'&correo='${correo}'" method="get">
                         
                         <input type="hidden"  class="form-control" name="id" required="required" value='${id}'>
                         <input type="hidden"  class="form-control" name="correo" required="required" value='${correo}'>

                        <fieldset class="form-group">
     
                            <label>Numero</label> <input type="text" " class="form-control" name="numero" value='${numero}' required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Tipo</label> <input type="text"  class="form-control" name="tipo" value='${tipo}'>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Operadora</label> <input type="text" class="form-control" name="operadora" value='${operadora}'>
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>