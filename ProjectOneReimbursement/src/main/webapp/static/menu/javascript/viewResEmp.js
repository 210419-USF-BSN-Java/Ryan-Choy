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
			
			let content = document.getElementById("resList")
			
			for(i = 0; i < resJSON.length; i++){
				let request ="<td>" + resJSON[i].reimbId + "</td><td>" + resJSON[i].amount + "</td><td>" + resJSON[i].dateSubmitted + "</td><td>" + resJSON[i].dateResolved + "</td><td>" + resJSON[i].description + "</td><td>" + resJSON[i].author + "</td><td>" + resJSON[i].resolver + "</td><td>" + resJSON[i].statusId + "</td><td>" + resJSON[i].typeId + "</td>";
				content.insertAdjacentHTML('beforeend',request);
			}
	} else if(xhr.readyState==4){
					alert("Failed to load your pending reimbursements! Please check your login status.");
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