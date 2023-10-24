//$('document').ready(function(){
//    $('.table .btn-edit').on('click', function(e){
//            e.preventDefault();
//
//            var href=$(this).attr('href')
//
//            console.log(href)
//
//            $.get(href, function(tool, status){
//                 $('#idEdit').val(tool.id);
//                $('#partNumberEdit').val(tool.partNumber);
//                $('#serialNumberEdit').val(tool.serialNumber);
//                $('#descriptionEdit').val(tool.description);
//                $('#locationEdit').val(tool.location);
//                console.log($('#locationEdit').val(tool.location));
//            });
//
//            $('#editModal').modal('show');
//     });
//});

$('document').ready(function(){
    $('.btn-edit-user').on('click', function(e){
            e.preventDefault();

            var href=$(this).attr('href')

            console.log(href)
            $.get(href, function(user, status){
                 $('#idUserEdit').val(user.id);
                $('#userIdUserEdit').val(user.userId);
                $('#firstNameUserEdit').val(user.firstName);
                $('#lastNameUserEdit').val(user.lastName);
                $('#emailUserEdit').val(user.email);
                $('#passwordUserEdit').val(user.password);

            });

            $('#editModalUser').modal('show');
     });
});

