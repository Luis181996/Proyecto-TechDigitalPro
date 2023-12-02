$(document).ready(function () {

    $(document).on("click", "#btnnuevo", function () {
        $("#txtnombrefabricante").val("");
        $("#txtpaisfabricante").val("");
        $("#txtsitiofabricante").val("");
        $("#hddidfabricante").val("0");
        $("#modalfabricantes").modal("show");
    });

    $(document).on("click", ".btnactualizar", function () {
        $("#modalfabricantes").modal("show");
        $("#txtnombrefabricante").val($(this).attr("data-nomfabricante"));
        $("#txtpaisfabricante").val($(this).attr("data-paisfabricante"));
        $("#txtsitiofabricante").val($(this).attr("data-sitio-webfabricante"));
        $("#hddidfabricante").val($(this).attr("data-idfabricante"));
    });

   $(document).on("click", "#btnguardarfabricante", function () {
       $.ajax({
           type: "POST",
           contentType: "application/json",
           url: "/fabricantes/registrar",
           data: JSON.stringify({
               id: $("#hddidfabricante").val(),
               nombre: $("#txtnombrefabricante").val(),
               pais: $("#txtpaisfabricante").val(),
               sitio_web: $("#txtsitiofabricante").val()
           }),
           success: function (resultado) {
               if (resultado.respuesta) {

                   window.location.reload();
               }
               alert(resultado.mensaje);
               $("#modalfabricantes").modal("hide");
           }
       });
   });

    function listarFabricantes() {
        $.ajax({
            type: "GET",
            url: "/fabricantes/listar",
            dataType: "json",
            success: function (resultado) {
                $("#tblfabricantes > tbody").html("");
                $.each(resultado, function (index, value) {
                    $("#tblfabricantes > tbody").append("<tr>" +
                        "<td>" + value.id + "</td>" +
                        "<td>" + value.nombre + "</td>" +
                        "<td>" + value.pais + "</td>" +
                        "<td>" + value.sitio_web + "</td>" +
                        "<td>" +
                        "<button type='button' class='btn btn-info btnactualizar'" +
                        " data-idfabricante='" + value.id + "'" +
                        " data-nomfabricante='" + value.nombre + "'" +
                        " data-paisfabricante='" + value.pais + "'" +
                        " data-sitio-webfabricante='" + value.sitio_web + "'>" +
                        "<i class='bi bi-pencil-square'></i>" +
                        "</button></td></tr>");
                });
            }
        });
    }

});
