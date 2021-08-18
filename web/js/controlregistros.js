window.addEventListener('load', function validacionregistro() {
    document.getElementById('btnregistrarse').addEventListener('click', function () {
        const clave = document.getElementById('clave');
        const confirmarClave = document.getElementById('confirmarClave');        

        if (confirmarClave.value === clave.value) {
            document.getElementById('formregistro').submit();
        } else {
            alert('Las contraseñas no coinciden');
            return false;
        }
    });
});
//function validacionRegistro() {
//    const clave = document.getElementById('clave');
//    const confirmarClave = document.getElementById('confirmarClave');
//
//    if (confirmarClave.value !== clave.value) {
//        alert("las contraseñas no coinciden");
//        return false;
//    } else {
//        setTimeout(function () {
//            location.reload();
//        }, 3000);
//
//        return true;
//    }
//}


