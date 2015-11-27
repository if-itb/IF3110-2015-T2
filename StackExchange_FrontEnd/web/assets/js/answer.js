(function($){
    $(function(){

        //$('#question .card, #answer .card').hover(function(){
        //    $(this).find('.fixed-action-btn > .btn-floating').click();
        //}, function(){
        //    $(this).find('.fixed-action-btn > .btn-floating').click();
        //})

        function getParameterByName(name) {
            name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
            var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
                results = regex.exec(location.search);
            return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
        }

        setTimeout(function(){
            $('#question .card, #answer .card').find('.fixed-action-btn > .btn-floating').click();
        }, 200)

        var save_mode = false;

        $('.edit-btn').click(function(e){
            e.preventDefault()
            e.stopPropagation()

            if (!save_mode){
                console.log("editing")

                $card = $(this).closest('.card')
                var text = $card.find('.input-content').text()
                console.log(text)

                $card.find('.card-content:eq(1)').empty().append('<div class="input-field"><textarea id="text-edit" class="materialize-textarea">' + text + '</textarea></div>')
                $('#text-edit').focus().trigger('autoresize')

                save_mode = true
            } else {

                console.log("saving")

                var id = $(this).closest('.card').attr('data-id')
                var content = $('#text-edit').val()
                var title = $('#topic-title h4').text()

                $('<form action="/question/edit?token=' + getParameterByName('token') + '" method="POST">' +
                    '<input type="hidden" name="id" value="' + id + '"/>' +
                    '<input type="hidden" name="content" value="' + content + '"/>' +
                    '<input type="hidden" name="title" value="' + title + '"/>' +
                '</form>').appendTo('body').submit();
            }
        })

        if (getParameterByName('token')){
            $('#add-answer-form').attr('action', '/answer/add?token=' + getParameterByName('token'));
        } else {
            $('#add-answer-form').attr('action', '/answer/add');
        }

        $('.question-upvote-btn').click(function(){
            var id = $(this).closest('.card').attr('data-id')
            $('<form action="/question/upvote?token=' + getParameterByName('token') + '" method="POST">' +
            '<input type="hidden" name="id" value="' + id + '"/></form>').appendTo('body').submit();
        })

        $('.question-downvote-btn').click(function(){
            var id = $(this).closest('.card').attr('data-id')
            $('<form action="/question/downvote?token=' + getParameterByName('token') + '" method="POST">' +
            '<input type="hidden" name="id" value="' + id + '"/></form>').appendTo('body').submit();
        })

        $('.answer-upvote-btn').click(function(){
            var id = $(this).closest('.card').attr('data-id')
            $('<form action="/answer/upvote?token=' + getParameterByName('token') + '" method="POST">' +
            '<input type="hidden" name="id" value="' + id + '"/></form>').appendTo('body').submit();
        })

        $('.answer-downvote-btn').click(function(){
            var id = $(this).closest('.card').attr('data-id')
            $('<form action="/answer/downvote?token=' + getParameterByName('token') + '" method="POST">' +
            '<input type="hidden" name="id" value="' + id + '"/></form>').appendTo('body').submit();
        })

        $('.question-close').click(function(){
            var id = $(this).closest('.card').attr('data-id')
            $('<form action="/question/delete?token=' + getParameterByName('token') + '" method="POST">' +
            '<input type="hidden" name="id" value="' + id + '"/></form>').appendTo('body').submit();
        })


    }); // end of document ready
})(jQuery); // end of jQuery name space