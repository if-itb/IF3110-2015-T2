function prepare(){
    if (window.XMLHttpRequest) {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    } else {  // code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
};

function VoteUp(bool,id){
    prepare();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            if(bool) {
                document.getElementById("q_vote"+id).innerHTML = xmlhttp.responseText;
            }
            else{
                document.getElementById("vote"+id).innerHTML = xmlhttp.responseText;
            }
        }
    }
    if(bool){
    	xmlhttp.open("GET","vote/questionvoteup.jsp?id="+id,true);
    }
    else{
    	xmlhttp.open("GET","vote/answervoteup.jsp?id="+id,true);
    }
    xmlhttp.send();
};

function VoteDown(bool,id){
	prepare();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            if(bool) {
                document.getElementById("q_vote"+id).innerHTML = xmlhttp.responseText;
            }
            else{
                document.getElementById("vote"+id).innerHTML = xmlhttp.responseText;
            }
        }
    }
    if(bool){
    	xmlhttp.open("GET","vote/questionvotedown.jsp?id="+id,true);
    }
    else{
    	xmlhttp.open("GET","vote/answervotedown.jsp?id="+id,true);
    }
    console.log(id);
    xmlhttp.send();
};