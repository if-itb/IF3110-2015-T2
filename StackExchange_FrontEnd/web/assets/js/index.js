(function($){
    $(function(){

        setTimeout(function(){
            $('#recent-post .card .fixed-action-btn > .btn-floating').click()
        }, 500)

        $('#recent-post .card .fixed-action-btn > .btn-floating').click(function(e){
            e.stopPropagation()
        })

        $('#recent-post .card').hover(function(){
            $(this).find('.fixed-action-btn > .btn-floating').click();
        }, function(){
            $(this).find('.fixed-action-btn > .btn-floating').click();
        })

        $('#recent-post .card').click(function(){
            window.location.href="/answer?id=" + $(this).attr('data-id')
        })

        $('.modal-trigger').leanModal();


    }); // end of document ready
})(jQuery); // end of jQuery name space