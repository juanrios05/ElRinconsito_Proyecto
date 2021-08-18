<%-- 
    Document   : registro
    Created on : 18/05/2021, 06:56:51 PM
    Author     : juanb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="js/controlregistros.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/style2.css">          
        <title>Registro</title>
    </head>
    <body>
        <header>
            <div>
                <a class="logo" href="index.jsp">El Rinconcito</a>
            </div>
        </header>
        <main>
            <div class="form-container">
                <form method="post" action="Controlador?menu=Registro" id="formregistro">
                    <ul class="form-items">
                        <li>
                            <h1>Registro</h1>
                        </li>
                        <li>     
                            <input type="text" placeholder="Cedula..." name="cedula" id="cedula" required />
                        </li>
                        <li>     
                            <input type="text" placeholder="Nombres..." name="nombres" id="nombres" required />
                        </li>
                        <li>                            
                            <input type="text" placeholder="Apellidos..." name="apellidos" id="apellidos" required />
                        </li>
                        <li>                            
                            <input type="text" placeholder="Telefono..." name="telefono" id="telefono" required />
                        </li>
                        <li>                            
                            <input type="text" placeholder="Direccion..." name="direccion" id="direccion" required />
                        </li>
                        <li>                            
                            <input type="email" placeholder="Correo..." name="correo" id="correo" required />
                        </li>
                        <li> 
                            <input type="password" placeholder="Contraseña..." name="clave" id="clave" required />
                        </li>
                        <li>                            
                            <input type="password" placeholder="Confirmar Contraseña..." name="confirmarClave" id="confirmarClave" required />
                        </li>
                        <li>
                            <button type="submit" value="Registrarse" name="accion" id="btnregistrarse">Registrarse</button>
                        </li>
                        <li>
                            <div>
                                ¿Ya tienes una cuenta?
                                <a href="iniciosesion.jsp">Iniciar Sesión</a>
                            </div>  
                        </li>  
                    </ul>
                </form> 
            </div>
        </main>
        <footer>All Rights Reserved @2021</footer>
    </body>
</html>
