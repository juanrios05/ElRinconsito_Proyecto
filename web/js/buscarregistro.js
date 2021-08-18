function buscar() {
    var tabla = document.getElementById("datos");
    var texto = document.getElementById("termino").value.toLowerCase();
    var celda = "";
    var resultado = false;
    var comparacion = "";
    
    for (var i = 1; i < tabla.rows.length; i++) {
        celda = tabla.rows[i].getElementsByTagName("td");
        resultado = false;
        
        for (var j = 0; j < celda.length && !resultado; j++) {
            comparacion = celda[j].innerHTML.toLowerCase();
            if (texto.length == 0 || (comparacion.indexOf(texto) > -1)) {
                resultado = true;
            }
        }
        if (resultado) {
            tabla.rows[i].style.display = '';
        } else {
            tabla.rows[i].style.display = 'none';
        }
    }
}

