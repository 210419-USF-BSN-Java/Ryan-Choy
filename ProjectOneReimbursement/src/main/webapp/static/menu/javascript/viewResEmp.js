viewRes();

function viewRes(){
	let token = sessionStorage.getItem("token");
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/viewResReimByEmp";
	xhr.open("GET",url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let resList = xhr.getResponseHeader("resolvedList");
			let resJSON = JSON.parse(resList);
			
				let reimtype = "";
				switch(Number(resJSON.typeId)){
				case 1:
				reimtype = "Lodging";
				break;
				case 2:
				reimtype = "Travel";
				break;
				case 3:
				reimtype = "Food";
				break;
				case 4:
				reimtype = "Other";
				break;
				default:
				break;
				
			}
			
			let statustype = "";
			switch(Number(resJSON.statusId)){
				case 2:
				statustype = "Approved";
				break;
				case 3:
				statustype = "Denied";
				break;
				default:
				break;
				
			}
			
			let content = document.getElementById("resList")
			
			for(i = 0; i < resJSON.length; i++){
				let request ="<td>" + resJSON[i].reimbId + "</td><td>" + resJSON[i].amount + "</td><td>" + new Date(resJSON[i].dateSubmitted).toString() + "</td><td>" + new Date(resJSON[i].dateResolved).toString() + "</td><td>" + resJSON[i].description + "</td><td>" + resJSON[i].author + "</td><td>" + resJSON[i].resolver + "</td><td>" + resJSON[i].statusId + "</td><td>" + reimtype + "</td>";
				content.insertAdjacentHTML('beforeend',request);
			}
	} else if(xhr.readyState==4){
					alert("Failed to load your resolved reimbursements! Please check your login status.");
	}

}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("User",token);
	xhr.send();
	
document.getElementById("back").addEventListener("click", back);
	function back(){
    window.location.href="http://localhost:8080/ProjectOneReimbursement/employee";
}
}