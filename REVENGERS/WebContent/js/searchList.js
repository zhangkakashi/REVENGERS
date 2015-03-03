function verify(val){
	
	
	//alert(username);
	//2. send the data to servlet
	$.get("SearchBar?videoname=" + val,null,callback);//the third parameter is a function
	
	
}

function callback(data){
	//alert("get the data from server");
    //3. accept the return data
	//alert(data);
	//4. dynamically display the data to the web page
	var resultObj = $("#result");
	resultObj.html(data);
	
}