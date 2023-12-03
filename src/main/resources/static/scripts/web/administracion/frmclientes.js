$(document).on("click", "#btnagregarcliente", function () {
        $("#txtcliente_nombre").val("");
        $("#txtcliente_apellidos").val("");
        $("#txtcliente_direccion").val("");
        $("#txtcliente_telefono").val("");
        $("#txtcliente_correoelectronico").val("");
        $("#txtventa_fecha").val("");
        $("#txtventa_cantidad").val("");
        $("#txtventa_preciototal").val("");
        $("#modalNuevo").modal("show");
    });

    $(document).on("click", "#btnguardarcliente", function () {
        if (validarCampos()) {
            $.ajax({
                type: "POST",
                url: "/cliente/guardarcliente",
                contentType: "application/json",
                data: JSON.stringify({
                    idclientes : $("#hddidcliente").val(),
                    idventas : $("#hddidventa").val(),
                    nombre: $("#txtcliente_nombre").val(),
                    apellidos: $("#txtcliente_apellidos").val(),
                    direccion: $("#txtcliente_direccion").val(),
                    correo_electronico : $("#txtcliente_correoelectronico").val(),
                    telefono: $("#txtcliente_telefono").val(),
                    fecha: $("#txtventa_fecha").val(),
                    cantidad: $("#txtventa_cantidad").val(),
                    preciototal: $("#txtventa_preciototal").val(),
                }),
                success: function (resultado) {
                    alert(resultado.mensaje);
                }
            });

            $("#modalNuevo").modal("hide");

            setTimeout(function () {
                location.reload();
            }, 2000);
        }
    });

    function validarCampos() {
        $(".error-message").remove();
        var isValid = true;
        // Add your validation logic here
        return isValid;
    }