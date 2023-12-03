$(document).on("click", "#btnnuevo", function(){
    $("#txtnomrol").val("");
    $("#hddidrol").val("0")
    $("#modalrol").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#modalrol").modal("show");
    $("#txtnomrol").val($(this).attr("data-nomrol"));
    $("#hddidrol").val($(this).attr("data-idrol"));
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/administracion/rol/registrar",
        data: JSON.stringify({
            idrol: $("#hddidrol").val(),
            nomrol: $("#txtnomrol").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarRoles();
            }
            alert(resultado.mensaje);
            $("#modalrol").modal("hide");
        }
    });
});

function listarRoles(){
    $.ajax({
        type: "GET",
        url: "/administracion/rol/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblrol > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblrol > tbody").append("<tr>" +
                    "<td>"+value.idrol+"</td>" +
                    "<td>"+value.nomrol+"</td>" +
                    "<td>"+
                    "<button type='button' class='btn btn-info btnactualizar'"+
                    " data-idrol='"+value.idrol+"'"+
                    " data-nomrol='"+value.nomrol+"'>"+
                    "<i class='bi bi-pencil-square'></i>"+
                    "</button></td>"+
                    "<td>"+
                    "<button type='button' class='btn btn-danger btneliminar'"+
                    " data-idrol='"+value.idrol+"'"+
                    " data-nomrol='"+value.nomrol+"'>"+
                    "<i class='bi bi-trash'></i>"+
                    "</button></td></tr>");
            });
        }
    });
}

$(document).on("click", ".btneliminar", function(){
    $("#lblmensajeeliminar").text("¿Está seguro de eliminar el rol " +
            $(this).attr("data-nomrol")+"?");
    $("#hddidroldesactivar").val($(this).attr("data-idrol"));
    $("#modaleliminarrol").modal("show");
});

$(document).on("click", "#btneliminarrol", function(){
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/administracion/rol/eliminar",
        data: JSON.stringify({
            idrol: $("#hddidroldesactivar").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarRoles();
            }
            alert(resultado.mensaje);
            $("#modaleliminarrol").modal("hide");
        }
    });
});
