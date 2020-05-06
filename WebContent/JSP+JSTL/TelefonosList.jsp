<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../CSS/styles.css" rel="stylesheet" type="text/css" media="screen" />
    <title>FormularioRegistrarse</title>
</head>
<body>
    <div id="menu_bg">
        <div id="menu">
            <ul>
               <li><a href="index.html" class="active">Home</a></li>
                <li><a href="formulario.html">Registrarse</a></li>
                <li><a href="login.html">iniciar Sesion</a></li>
                <li><img src="../CSS/images/rss.png" alt="" title="" style="padding: 0px; margin: 0px;"/></li>
            </ul>
        </div>
    </div>
    <div id="logo">
        <h1><a href="#">AgendaTelefonica.com</a></h1>
         <a href="#" id="metamorph"><small>conectate siempre con tus amigos</small></a>
         <img src="../CSS/images/img2.jpg" alt="" title="" style="float: right; padding: 0px 60px 50px 0px"/>
    </div>
    
    
<div id="content">	
    <div id="contact">
        <div id="contact_left">
            <h2>BIENVENIDO</h2>
            <a href="#"><img src="../CSS/images/unlock.png" alt="location" title="location" class="location" /></a>
            <div class="grey_border"></div>
            
            <div id="contact_form">
            	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Telefonos</h3>
			<hr>
			<div class="container text-left">
			<form action="<%=request.getContextPath()%>/new?correo=<c:out value='${correo}' />" method="get">
			
			<tr>
				<td>Numero</td>
				<td><input type="text" name="numero"></td>
				<td><input type="text" name="correo" value='${correo}'></td>
			</tr>
			<tr>
				<td>Tipo</td>
				<td><input type="password" name="tipo"></td>
			</tr>
			<tr>
			<tr>
				<td>Operadora</td>
				<td><input type="text" name="operadora"></td>
			</tr>
				<td><input type="hidden" name="parametro" value="sesion"></td>
				<td><input type="submit" value="new"  ></td>
			</tr>
		</form>
			
			<a href="<%=request.getContextPath()%>/new?correo=<c:out value='${correo}' />" class="btn btn-success">Nuevo_telefono
            </a>

			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
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
							<td><c:out value="${telefono.id}" /></td>
							<td><c:out value="${telefono.numero}" /></td>
							<td><c:out value="${telefono.tipo}" /></td>
							<td><c:out value="${telefono.operadora}" /></td>
							<td><a href="edit?id=<c:out value='${telefono.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${telefono.id}' />">Delete</a>
								<a
								href="modify?id=<c:out value='${telefono.id}' />">Modify</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
            
               
               
               
            </div>
        </div>
        <div id="contact_right">
            <h2>Quisque Tempor</h2>
            <p><a href="#">Quisque tempor, tellus in placerat feugiat, metus massa pellentesque elit, id semper odio enim quis tellus.</a> 
Donec urna ipsum, bibendum eget malesuada nec, semper ut libero. Vestibulum id felis sem, quis convallis lacus. Donec lacinia mi vitae metus cursus sed mollis ligula mattis. 
Cras convallis iaculis erat, et venenatis turpis gravida non. Ut vehicula leo tempor dui scelerisque aliquam eget id odio. Praesent euismod egestas porta. Nulla imperdiet feugiat ipsum, id aliquam tortor mollis ut. Donec eget </p>
            <div class="read2"><a href="#">read more</a></div>
            
            <h2>Meet Our Company</h2>
                <div class="pad_left" style="background: url(../CSS/images/house.png) no-repeat 0px 3px">
                    1234 Some Street, Brooklyn, NY 11201
                </div>
                <div class="pad_left" style="background: url(../CSS/images/phone.png) no-repeat 0px 2px">
                    Phone:  1(234) 567 8910<br />
                    Fax: 1(234) 567 8910
                </div>
                <div class="pad_left" style="background: url(../CSS/images/contact_icon.png) no-repeat 0px 5px">
                    General: companyname@yahoo.com<br />
                    Support: support@yahoo.com
                </div>
        </div>
        <div class="clear"></div>
    </div>
    
    
    
    
    
    <div id="footer_repeat_bg">
        <div id="footer_bg">
            <div id="footer_width">
                <div id="footer_top">
                    <div id="footer_left">
                        <h2>About Us</h2>
                        <img src="../CSS/images/img1.jpg" alt="" title="" style="float: left; padding: 0px 20px 10px 0px"/>
                        <p><a href="#">Morbi id vehicula orci.</a> 
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
                        <h2>Contact Form</h2>
                        <form id="form1" method="post" action="#">
                            <fieldset>
                                <label>Name:</label><input id="text1" type="text" name="text1" value="" alt=""/>
                                <div class="clear"></div>
                                <label>E-mail:</label><input id="text2" type="text" name="text2" value="" alt=""/><br />
                                <textarea id="text_mess" name="text_mess" cols="0" rows="0"></textarea><br />
                                <input type="submit" id="login-submit" value="Send"/>
                               </fieldset>
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>
                <div id="footer_bot">
                    <div id="footer_bot_left">
                        <p>Copyright  2015.</p>
                        <p class="fdegt">Web Design: <a href="http://www.metamorphozis.com" class="koug">Free Website Templates</a></p>		
                    </div>
                    <div id="footer_icon">
                        <a href="#"><img src="../CSS/images/facebook.png" alt="" title=""/></a>
                        <a href="#"><img src="../CSS/images/twitter.png" alt="" title=""/></a>
                        <a href="#"><img src="../CSS/images/yahoo.png" alt="" title=""/></a>
                        <a href="#"><img src="../CSS/images/rss.png" alt="" title=""/></a>
                        <a href="#"><img src="../CSS/images/youtube.png" alt="" title=""/></a>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div><div class="clear"></div>
</div>
</body>
</html>