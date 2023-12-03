$(document).on("click", "#btnnuevo", function(){
    //alert("Hola estoy con JQUERY");
    $("#txtfecha").val("");
    $("#txtproducto_id").val("");
    $("#txtcliente_id").val("");
    $("#txtcantidad").val("");
    $("#txtprecio_total").val("");
    $("#hddidventas").val("0")
    $("#modalventas").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#modalventas").modal("show");
    $("#txtfecha").val($(this).attr("data-fechventas"));
    $("#txtproducto_id").val($(this).attr("data-prodventas"));
    $("#txtcliente_id").val($(this).attr("data-clienventas"));
    $("#txtcantidad").val($(this).attr("data-cantventas"));
    $("#txtprecio_total").val($(this).attr("data-precioventas"));
    $("#hddidventas").val($(this).attr("data-idventas"));
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/administracion/ventas/registrar",
        data: JSON.stringify({
            idventas: $("#hddidventas").val(),
            fecha: $("#txtfecha").val(),
            producto_id: $("#txtproducto_id").val(),
            cliente_id: $("#txtcliente_id").val(),
            cantidad: $("#txtcantidad").val(),
            precio_total: $("#txtprecio_total").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarVentas();
            }
            alert(resultado.mensaje);
            $("#modalventas").modal("hide")
        }

    })
});

function listarVentas(){
    $.ajax({
        type: "GET",
        url: "/ventas/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblventas > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblventas > tbody").append("<tr>" +
                    "<td>"+value.idventas+"</td>" +
                    "<td>"+value.fechventas+"</td>" +
                    "<td>"+value.prodventas+"</td>" +
                    "<td>"+value.clienventas+"</td>" +
                    "<td>"+value.cantventas+"</td>" +
                    "<td>"+value.precioventas+"</td>" +
                    "<td>"+
                    "<button type='button' class='btn btn-info btnactualizar'"+
                    " data-idventas='"+value.idventas+"'"+
                    " data-fechventas='"+value.fechventas+"'"+
                    " data-prodventas='"+value.prodventas+"'"+
                    " data-clienventas='"+value.clienventas+"'"+
                    " data-cantventas='"+value.cantventas+"'"+
                    " data-precioventas='"+value.precioventas+"'>"+
                    "<i class='bi bi-pencil-square'></i>"+
                    "</button></td>"+
                    "<td>"+
                    "<button type='button' class='btn btn-danger btneliminar'"+
                    " data-idventas='"+value.idventas+"'"+
                    " data-fechventas='"+value.fechventas+"'"+
                    " data-prodventas='"+value.prodventas+"'"+
                    " data-clienventas='"+value.clienventas+"'"+
                    " data-cantventas='"+value.cantventas+"'"+
                    " data-precioventas='"+value.precioventas+"'>"+
                    "<i class='bi bi-trash'></i>"+
                    "</button></td></tr>");
            })
        }
    })
}


$(document).on("click", ".btneliminar", function(){
    //alert("Hola estoy con JQUERY");
    $("#lblmensajeeliminar").text("¿Está seguro de eliminar las ventas " +
            $(this).attr("data-fechventas")+"?");
            $(this).attr("data-prodventas")+"?");
            $(this).attr("data-clienventas")+"?");
            $(this).attr("data-precioventas")+"?");
            $(this).attr("data-cantventas")+"?");
    $("#hddidventaseliminar").val($(this).attr("data-idventas"));
    $("#modaleliminarventas").modal("show");
});


$(document).on("click", "#btneliminar", function(){
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/administracion/ventas/eliminar",
        data: JSON.stringify({
            idventas: $("#hddidventaseliminar").val(),
            fechventas: $("txtfech").val(),
            prodventas: $("txtproducto_id").val(),
            clienventas: $("txtcliente_id").val(),
            precioventas: $("txtprecioventas").val(),
            cantventas: $("txt")
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarVentas();
            }
            alert(resultado.mensaje);
            $("#modaleliminarventas").modal("hide")
        }
    })
});
