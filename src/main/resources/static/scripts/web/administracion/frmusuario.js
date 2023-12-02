$(document).on("click", "#btnnuevo", function(){
    //alert("Hola estoy con JQUERY");
    $("#txtnomusuario").val("");
    $("#txtemail").val("");
    $("#txtpassword").val("");
    $("#txtnombres").val("");
    $("#txtapellidos").val("");
    $("#hddidusuario").val("0")
    $("#modalusuario").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#modalventas").modal("show");
    $("#txtnomusuario").val($(this).attr("data-nomusuario"));
    $("#txtemail").val($(this).attr("data-email"));
    $("#txtpassword").val($(this).attr("data-password"));
    $("#txtnombres").val($(this).attr("data-nombres"));
    $("#txtapellidos").val($(this).attr("data-apellidos"));
    $("#hddidusuario").val($(this).attr("data-idusuario"));
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/administracion/usuario/registrar",
        data: JSON.stringify({
            idusuario: $("#hddidventas").val(),
            nomusuario: $("#txtnomusuario").val(),
            email: $("#txtemail").val(),
            password: $("#txtpassword").val(),
            nombres: $("#txtnombres").val(),
            apellidos: $("#txtapellidos").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarUsuario();
            }
            alert(resultado.mensaje);
            $("#modalusuario").modal("hide")
        }

    })
});

function listarUsuario(){
    $.ajax({
        type: "GET",
        url: "/administracion/usuario/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblusuario > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblusuario > tbody").append("<tr>" +
                    "<td>"+value.idusuario+"</td>" +
                    "<td>"+value.nomusuario+"</td>" +
                    "<td>"+value.email+"</td>" +
                    "<td>"+value.password+"</td>" +
                    "<td>"+value.nombres+"</td>" +
                    "<td>"+value.apellidos+"</td>" +
                    "<td>"+
                    "<button type='button' class='btn btn-info btnactualizar'"+
                    " data-idusuario='"+value.idusuario+"'"+
                    " data-nomusuarios='"+value.nomusuario+"'"+
                    " data-email='"+value.email+"'"+
                    " data-password='"+value.password+"'"+
                    " data-nombres='"+value.nombres+"'"+
                    " data-apellidos='"+value.apellidos+"'>"+
                    "<i class='bi bi-pencil-square'></i>"+
                    "</button></td>"+
                    "<td>"+
                    "<button type='button' class='btn btn-danger btneliminar'"+
                    " data-idusuario='"+value.idusuario+"'"+
                    " data-nomusuario='"+value.nomusuario+"'"+
                    " data-email='"+value.email+"'"+
                    " data-password='"+value.password+"'"+
                    " data-nombres='"+value.nombres+"'"+
                    " data-apellidos='"+value.apellidos+"'>"+
                    "<i class='bi bi-trash'></i>"+
                    "</button></td></tr>");
            })
        }
    })
}


$(document).on("click", ".btneliminar", function(){
    //alert("Hola estoy con JQUERY");
    $("#lblmensajeeliminar").text("¿Está seguro de eliminar el usuario " +
            $(this).attr("data-nomusuario")+"?");
            $(this).attr("data-email")+"?");
            $(this).attr("data-password")+"?");
            $(this).attr("data-nombres")+"?");
            $(this).attr("data-apellidos")+"?");
    $("#hddidusuarioeliminar").val($(this).attr("data-idusuario"));
    $("#modaleliminarusuario").modal("show");
});


$(document).on("click", "#btneliminar", function(){
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/administracion/usuario/eliminar",
        data: JSON.stringify({
            idusuario: $("#hddidusuarioeliminar").val(),

        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarUsuario();
            }
            alert(resultado.mensaje);
            $("#modaleliminarusuario").modal("hide")
        }
    })
});