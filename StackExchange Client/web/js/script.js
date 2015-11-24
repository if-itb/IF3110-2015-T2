$(document).ready(function() {
    $(".vote-button").on("click", function() {
        var id = $(this).data("id");
        var type = $(this).data("type");
        var action = $(this).data("action");
        $.ajax({
            method: "POST",
            url: "vote",
            data: "id=" + id + "&type=" + type + "&action=" + action
        })
        .done(function(result) {
            if (result.hasOwnProperty("votes")) {
                $('#'+type+'-'+id+'-'+action).removeClass("vote-button").addClass("vote-button-yes");
                if (action === "up")
                    $('#'+type+'-'+id+'-down').removeClass("vote-button").addClass("vote-button-no");
                else
                    $('#'+type+'-'+id+'-up').removeClass("vote-button").addClass("vote-button-no");
                $('#'+type+'-'+id).html(result.votes);
                $('#'+type+'-up').off("click");
                $('#'+type+'-down').off("click");
            }
        });
    });
});

