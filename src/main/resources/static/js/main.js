$('document').ready(function(){
    $('.action-tool-edit').on('click', function(e){
            e.preventDefault();

            var href=$(this).attr('href')

            console.log(href)

            $.get(href, function(tool, status){
                $('#barcodeIdEdit').val(tool.barcodeId);
                $('#parentBarcodeIdEdit').val(tool.parentBarcodeId);
                $('#partNumberEdit').val(tool.partNumber);
                $('#serialNumberEdit').val(tool.serialNumber);
                $('#descriptionEdit').val(tool.description);
                $('#locationEdit').val(tool.location);
                $('#shelfEdit').val(tool.shelf);
                $('#verificationTypeEdit').val(tool.verificationType);
                $('#nextDueDateEdit').val(tool.nextDueDate);
//                console.log($('#locationEdit').val(tool.location));
            });

            $('#editModal').modal('show');
     });
});

$('document').ready(function(){
    $('.action-user-edit').on('click', function(e){
            e.preventDefault();

            var href=$(this).attr('href')

            console.log(href);
            $.get(href, function(user, status){
            console.log(user);
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

$('document').ready(function(){
    $('.add-user').on('click', function(e){
            e.preventDefault();
            console.log("click")
            var href=$(this).attr('href')

            console.log(href)
            $.get(href, function(user, status){
                $('#userId').val(user.userId);
                $('#firstName').val(user.firstName);
                $('#lastName').val(user.lastName);
                $('#lastName').val(user.lastName);
                $('#email').val(user.email);
                $('#password').val(user.password);
            });

            $('#addModalUser').modal('show');
     });
});


