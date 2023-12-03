$(document).ready(function () {

    $(document).on("click", "#btnnuevo", function () {
        $("#txtnombreproducto").val("");
        $("#txtdescproducto").val("");
        $("#txtprecioproducto").val("");
        $("#txtstockproducto").val("");
        $("#hddidproducto").val("0");
        $("#modalproductos").modal("show");
    });

    $(document).on("click", ".btnactualizar", function () {
        $("#modalproductos").modal("show");
        $("#txtnombreproducto").val($(this).attr("data-nomproducto"));
        $("#txtdescproducto").val($(this).attr("data-descproducto"));
        $("#txtprecioproducto").val($(this).attr("data-precioproducto"));
        $("#txtstockproducto").val($(this).attr("data-stockproducto"));
        $("#hddidproducto").val($(this).attr("data-idproducto"));
    });

    $(document).on("click", "#btnguardarproducto", function () {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/productos/registrar",
            data: JSON.stringify({
                idproductos: $("#hddidproducto").val(),
                nombre: $("#txtnombreproducto").val(),
                descripcion: $("#txtdescproducto").val(),
                precio: $("#txtprecioproducto").val(),
                stock: $("#txtstockproducto").val()
            }),
            success: function (resultado) {
                if (resultado.respuesta) {
                    window.location.reload();
                }
                alert(resultado.mensaje);
                $("#modalproductos").modal("hide");
            }
        });
    });

    function listarProductos() {
        $.ajax({
            type: "GET",
            url: "/productos/listar",
            dataType: "json",
            success: function (resultado) {
                $("#tblproductos > tbody").html("");
                $.each(resultado, function (index, value) {
                    $("#tblproductos > tbody").append("<tr>" +
                        "<td>" + value.idproductos + "</td>" +
                        "<td>" + value.nombre + "</td>" +
                        "<td>" + value.descripcion + "</td>" +
                        "<td>" + value.precio + "</td>" +
                        "<td>" + value.stock + "</td>" +
                        "<td>" +
                        "<button type='button' class='btn btn-info btnactualizar'" +
                        " data-idproducto='" + value.idproductos + "'" +
                        " data-nomproducto='" + value.nombre + "'" +
                        " data-descproducto='" + value.descripcion + "'" +
                        " data-precioproducto='" + value.precio + "'" +
                        " data-stockproducto='" + value.stock + "'>" +
                        "<i class='bi bi-pencil-square'></i>" +
                        "</button></td></tr>");
                });
            }
        });
    }

});
$(document).on("click", ".btneliminar", function(){
    $("#lblmensajeeliminar").text("¿Está seguro de eliminar el producto " +
            $(this).attr("data-nomproducto") + "?");
    $("#hddidproductoeliminar").val($(this).attr("data-idproducto"));
    $("#modaleliminarproducto").modal("show");
});


$(document).on("click", "#btneliminarproducto", function () {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/productos/eliminar",
        data: JSON.stringify({
            idproducto: $("#hddidproductoeliminar").val()
        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                listarProductos();
            }
            alert(resultado.mensaje);
            $("#modaleliminarproducto").modal("hide");
        },
        error: function (xhr, status, error) {
            console.error(xhr.responseText);
            alert("Error al eliminar el producto. Consulta la consola para obtener más detalles.");
        }
    });
});


