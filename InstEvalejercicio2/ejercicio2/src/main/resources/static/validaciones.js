function validacionDatos(){
    var telefono, email;
    emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i


    telefono = document.FormAltaProveedor.telefono.value;
    email = document.FormAltaProveedor.email.value;

    if(telefono > 9999999999){
    alert("Ingrese el número de télefono sin cero ni 15 y sin codigo de país (10 dígitos como máximo)")
    return false;
    }

    if(telefono.length < 9){
        alert("El número ingresado debe contener al menos 9 dígitos");
        return false;
        }

    if (!emailRegex.test(email)) {
        alert("El mail ingresado no es válido");
        return false;
    }
}