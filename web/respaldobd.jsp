<%-- 
    Document   : respaldobd
    Created on : 15/07/2021, 01:14:12 PM
    Author     : juanb
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try {
        Calendar fecha = Calendar.getInstance();        
        String fechaHoy = fecha.get(Calendar.DATE) + "-" + fecha.get(Calendar.MONTH) + "-" + fecha.get(Calendar.YEAR);       
        String nombreArchivo = "Respaldo_elrinconsito_" + fechaHoy + ".sql";
        int copia_seguridad;

        Process runtimeProcess = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump.exe --routines --opt --password=  --user=root --databases elrinconsito2 -r C:\\Users\\juanb\\Desktop\\Backup_Rinconsito\\" + nombreArchivo);
        copia_seguridad = runtimeProcess.waitFor();
        if (copia_seguridad == 0) {
%> 
<script>
    function respaldoRealizado() {
        alert("Respaldo realizado exitosamente.");
        location.href = "sesioniniciadaadministrador.jsp";
    }
    respaldoRealizado();
</script>
<%
} else {
%>
<script>
    function respaldoNoRealizado() {
        alert("El respaldo no se pudo generar");
        location.href = "sesioniniciadaadministrador.jsp";
    }
    respaldoNoRealizado();
</script>
<%}
    } catch (Exception e) {
        out.println(e);       

    }
%>
