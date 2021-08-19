<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/fec6c7f184.js" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="css/style2.css">
        <title>Informes</title>
    </head>
    <body>
        <div class="grid-container">
            <header>
                <div>
                    <a class="logo" href="sesioniniciadaadministrador.jsp">El Rinconsito</a>                    
                </div>                  
            </header>               
            <main>
                <div>
                    <ul class="lista-informes">
                        <li>
                            <a href="informeclientes.jsp" target="contenedorregistros">Clientes</a>
                        </li>
                        <span><b>|</b></span>
                        <li>
                            <a href="informeclientes.jsp" target="contenedorregistros">Productos</a>
                        </li>
                    </ul>                    
                </div>
                <div>
                    <iframe name="contenedorregistros" style="height: 600px; width: 100%;"></iframe>
                </div>
            </main>
        </div>
    </body>
</html>
