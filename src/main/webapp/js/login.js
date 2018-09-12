function send(){
	$.post("login.action",{id:123,password:1231},function(data){
		alert("the return date is " + data);
	})
	
	return false;
}