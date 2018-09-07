function send(){
	$.post("login",{name:123,password:12},function(data){
		alert("the return date is " + data);
	})
	
	return false;
}