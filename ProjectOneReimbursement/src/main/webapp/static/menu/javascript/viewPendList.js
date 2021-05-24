viewAllPending();

function viewAllPending(){
	let token = localStorage.getItem("token")
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ProjectOneReimbursement/viewAllPend";
	xhr.open("GET", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            let pendList = xhr.getResponseHeader("allPending");
			let pListJSON = JSON.parse(pendList);
			
			let content = document.getElementById("pendList");
				for(i = 0; i < pListJSON.length; i++){
				let request ="<td>" + pListJSON[i].reimbId + "</td><td>" + pListJSON[i].amount + "</td><td>" + new Date(pListJSON[i].dateSubmitted).toString()  + "</td><td>" + pListJSON[i].description + "</td><td>" + pListJSON[i].author + "</td><td>" + pListJSON[i].typeId + "</td>";
				content.insertAdjacentHTML('beforeend',request);
			}

		} 
		else if (xhr.readyState == 4){
			alert("Failed to load pending requests! Please check your login status.");
		}
	}
	
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

document.getElementById("resolve").addEventListener("click", requestAction);
document.getElementById("back").addEventListener("click", back);

function requestAction(){
	let reimID = document.getElementById("reimID").value;
	let action = document.getElementById("action").value;
	console.log(action);
	let token = localStorage.getItem("token")
	
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ERS/reimAction";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
            alert("You have successfully resolved this reimbursement request!");

		} 
		else if (xhr.readyState == 4){
			alert("Failed to resolved this reimbursement request!, please check your login status.");
		}
	}

	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.setRequestHeader("Authorization",token);
	let requestBody = `reimID=${reimID}&action=${action}`;
	xhr.send(requestBody);
}

function back(){

    window.location.href="http://localhost:8080/ProjectOneReimbursement/manager"

}
