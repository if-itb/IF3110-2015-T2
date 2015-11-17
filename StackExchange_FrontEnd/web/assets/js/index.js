(function($){
    $(function(){

        $('#recent-post .card').click(function(){
            window.location.href="/answer?id=" + $(this).attr('data-id')
        })

    }); // end of document ready
})(jQuery); // end of jQuery name space