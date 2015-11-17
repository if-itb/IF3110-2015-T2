(function($){
    $(function(){

        $('#question .card, #answer .card').hover(function(){
            $(this).find('.fixed-action-btn > .btn-floating').click();
        }, function(){
            $(this).find('.fixed-action-btn > .btn-floating').click();
        })

        $('.edit-btn').click(function(e){
            e.preventDefault()
            e.stopPropagation()

            $card = $(this).closest('.card')
            var text = $card.find('.input-content').text()
            console.log(text)

            $card.find('.card-content:eq(1)').empty().append('<div class="input-field"><textarea id="text-edit" class="materialize-textarea">' + text + '</textarea></div>')
            $('#text-edit').trigger('autoresize')
        })

    }); // end of document ready
})(jQuery); // end of jQuery name space