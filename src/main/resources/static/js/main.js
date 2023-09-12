$('document').ready(function(){
    $('.table .btn-edit').on('click', function(e){
            e.preventDefault();

            var href=$(this).attr('href')

            console.log(href)

            $.get(href, function(tool, status){
                 $('#idEdit').val(tool.id);
                $('#partNumberEdit').val(tool.partNumber);
                $('#serialNumberEdit').val(tool.serialNumber);
                $('#descriptionEdit').val(tool.description);
                $('#locationEdit').val(tool.location);
                console.log($('#locationEdit').val(tool.location));
            });

            $('#editModal').modal('show');
     });
});
