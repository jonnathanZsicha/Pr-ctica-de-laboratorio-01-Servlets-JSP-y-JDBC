<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/Practica01/CSS/styles.css" rel="stylesheet" type="text/css" media="screen" />
    <title>Agenda_Telefonica</title>
</head>
<body>
    <div id="menu_bg">
        <div id="menu">
            <ul>
                <li><a href="/Practica01/Html/index.html" class="active">Home</a></li>
                <li><a href="/Practica01/JSP/Registrar.jsp">Registrarse</a></li>
                <li><a href="/Practica01/Html/login.html">iniciar Sesion</a></li>
                <li><img src="/Practica01/images/log.png" alt="" title="" style="padding: 0px; margin: 0px;"/></li>
            </ul>
        </div>
    </div>
    <div id="logo">
        <h1><a href="#">AgendaTelefonica.com</a></h1>
         <a href="#" id="metamorph"><small>Ingrese cedula o correo para busqueda de usuarios</small></a>
         
         <img src="/Practica01/images/logo2.png" alt="" title="" style="float: right; padding: 0px 60px 50px 0px"/>
         <form id="form11" name='sesion' action='http://localhost:8080/Practica01/BuscarUsuarioController' method='get'>
         
     
                    <fieldset>
                       
                        <small>conectate siempre con tus amigos</small><input id="correo" type="text" name="busqueda"  alt=""/><br />
                    
                        <input name="cedula" type="submit" id="contact-submit" value="cedula"/>
                        <input name="correo" type="submit" id="contact-clear" value="correo"/>
                    </fieldset>
                   </form>
                   		<table class="customers">
				<thead>
					<tr>
						<th >Cedula</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Correo</th>
						<th>Emviar_Correo</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:set var="p1" scope="request" value="${usuario}" />
					

						<tr>
							<td><c:out value="${p1.cedula}" /></td>
							<td><c:out value="${p1.nombre}" /></td>
							<td><c:out value="${p1.apellido}" /></td>
							<td><a href="mailto:<c:out value="${p1.correo}" />"><c:out value="${p1.correo}" /></a></td>
							<td><a href="mailto:<c:out value="${p1.correo}" />"><c:out value="${p1.correo}" /></a>
		
						</tr>
						
					
					<!-- } -->
				</tbody>

			</table>
			<table class="customers">
				<thead>
					<tr>
						
						<th>NUMERO</th>
						<th>TIPO</th>
						<th>OPERADOR</th>
						<th>Operaciones</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:set var = "p1" value = "${requestScope['telefonos']}" />
					<c:forEach var="telefono" items="${telefonos}">

						<tr>
							
							<td><c:out value="${telefono.numero}" /></td>
							<td><c:out value="${telefono.tipo}" /></td>
							<td><c:out value="${telefono.operadora}" /></td>
							<td><a href="tel:+593<c:out value="${telefono.numero}" />">Llamar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; </td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
    </div>
      
    <div id="content">
            <h2>Aliquam Elementum Felis</h2>
            <img src="/Practica01/images/img2.jpg" alt="" title="" style="float: left; padding: 0px 20px 10px 0px"/>
                <p><a href="#">In nisi tortor, adipiscing congue mattis et, vehicula id neque.</a><br />
Sed congue, ipsum ultricies dapibus malesuada, ligula purus pellentesque tellus, eu sagittis urna velit id justo. Donec vestibulum mauris eget massa egestas facilisis. Cras odio purus, condimentum non lacinia at, gravida sed leo. In sed ipsum id mi rutrum luctus. Nullam semper tristique lacus ut tincidunt. </p><br />
<p><a href="#">Aenean ac sapien vitae sapien consectetur rhoncus. </a><br />
Pellentesque libero nunc, consequat eu rutrum eu, convallis sit amet mauris. Etiam vehicula tincidunt turpis, ut varius mauris sodales et. Pellentesque id leo et metus consectetur venenatis vitae vehicula tellus. Etiam imperdiet varius lacus, et vulputate eros ullamcorper imperdiet.</p>
        <div class="more"><a href="#">mas</a></div>
        <div class="grey_border"></div>
        
        <div class="column3_box">
            <div class="column1">
                <h2>Quisque dignissim commodo fermentum</h2>
                <p><a href="#">Aenean venenatis dictum sapien vitae porttitor.</a><br /> 
Morbi ultrices dignissim est, vel placerat arcu viverra et. Duis sagittis posuere dignissim. Donec et elit risus, sit amet tempor libero. Ut et porta odio. Integer pharetra pretium dolor sit amet porttitor. Praesent id elementum nisl. Aliquam ac lectus ac felis venenatis porta et eget nisi.</p>
                <div class="more"><a href="#">mas</a></div>
            </div>
            <div class="column2">
                <h2>Donec vestibulum mauris eget massa</h2>
                <p><a href="">Cras odio purus, condimentum non lacinia at, gravida sed leo.</a><br />
In sed ipsum id mi rutrum luctus. Nullam semper tristique lacus ut tincidunt. Aenean ac sapien vitae sapien consectetur rhoncus. Pellentesque libero nunc, consequat eu rutrum eu, convallis sit amet mauris. </p>
            <div class="more"><a href="#">mas</a></div>
            </div>
            <div class="column3">
                <h2>Fusce sem nibh, varius a fringilla at</h2>
                <p><a href="#">Suspendisse potenti.</a><br />
Etiam rhoncus quam ut velit iaculis id egestas diam eleifend. Integer auctor felis risus. Maecenas vitae massa enim, eget fermentum velit. Cras tempor orci vitae nisl posuere dapibus. Ut tempus eleifend nunc eleifend venenatis. Nam sollicitudin risus a nisl vestibulum </p>
            <div class="more"><a href="#">mas</a></div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    
    <div id="footer_repeat_bg">
        <div id="footer_bg">
            <div id="footer_width">
                <div id="footer_top">
                    <div id="footer_left">
                        <h2>Acerca De</h2>
                        <img src="/Practica01/images/img1.jpg" alt="" title="" style="float: left; padding: 0px 20px 10px 0px"/>
                        <p><a href="#">Morbi id vehicula</a> <br />
Ut consequat commodo nunc nec tincidunt. Pellentesque vitae gravida nulla. Aliquam fermentum ipsum et mauris rutrum ac ornare convallis justo in eros fermentum eget cursus augue cursus. Donec sit amet eros eget ligula blandit congue. </p>
                    </div>
                    <div id="footer_middle">
                        <h2>Recent Posts</h2>
                        <ul class="ul_hover_bg">
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur</a></li>
                            <li><a href="#">Quisque nec lectus leo, et condimentum.</a></li>
                            <li><a href="#">Suspendisse porttitor purus a nisl </a></li>
                            <li><a href="#">Aliquam et leo quis massa ultricies </a></li>
                            <li><a href="#">Morbi eget arcu metus, facilisis </a></li>
                            <li><a href="#">Morbi condimentum enim in lorem ultr</a></li>
                        </ul>
                    </div>
                    <div id="footer_right">
                        <h2>Formulario Contacto</h2>
                        <form id="form1" method="post" action="#">
                            <fieldset>
                                <label>Nombre:</label><input id="text1" type="text" name="text1" value="" alt=""/>
                                <div class="clear"></div>
                                <label>E-mail:</label><input id="text2" type="text" name="text2" value="" alt=""/><br />
                                <textarea id="text_mess" name="text_mess" cols="0" rows="0"></textarea><br />
                                <input type="submit" id="login-submit" value="Emviar"/>
                               </fieldset>
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>
                <div id="footer_bot">
                    <div id="footer_bot_left">
                        <p>Copyright  2020 by Jonnathan Sicha. </p>
                            
                    </div>
                    <div id="footer_icon">
                        <a href="#"><img src="/Practica01/images/facebook.png" alt="" title=""/></a>
                        <a href="#"><img src="/Practica01/images/twitter.png" alt="" title=""/></a>
                        <a href="#"><img src="/Practica01/images/yahoo.png" alt="" title=""/></a>
                        <a href="#"><img src="/Practica01/images/rss.png" alt="" title=""/></a>
                        <a href="#"><img src="/Practica01/images/youtube.png" alt="" title=""/></a>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div><div class="clear"></div>
    </div>
    
</body>
</html>