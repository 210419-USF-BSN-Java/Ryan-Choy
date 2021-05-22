//Ensure that the token has the right authorization

let token = sessionStorage.getItem("token");

//If not the right token or has the right authorization, redirect to the appropriate

if(!token){
	window.location.href="http://localhost:8080/ProjectOneReimbursement";
} else{
	
	let uType = token.split(":");
	if(uType.length === 2 && uType[1] === 2 ){
		//redirect to manager if manager
		window.location.href="http://localhost:8080/ProjectOneReimbursement/manager";
	}
	
	if(uType.length === 2 && uType[1] === 1){
		//employee stuff
	}
}