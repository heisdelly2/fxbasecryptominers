let userEmail = new URLSearchParams(window.location.search).get("email");
let user;

let password = document.getElementById("new-password");
let confirmPassword = document.getElementById("confirm-password")

document.addEventListener("click", function(e) {
    let targetId = e.target.id;

    if(targetId == "reset-password") {
        if(password.value == confirmPassword.value) {
            e.target.classList.remove("blue-background");
            e.target.innerHTML =
				"<span class='fa fa-spinner w3-text-white fa-spin w3-large'></span>";

            getUser()
        }
    }
})

function getUser() {
	let getUserXhr = new XMLHttpRequest();
	getUserXhr.open("GET", `user/email/${userEmail}`, true);
	getUserXhr.send();

	getUserXhr.onreadystatechange = function() {
		if (this.status == 200 && this.readyState == 4) {
            let response = JSON.parse(this.response)
            user = response
            resetPassword(user)

		}
	};
}

function resetPassword(user) {
    user.password = password.value;
    let resetPasswordXhr = new XMLHttpRequest();
    resetPasswordXhr.open("PUT", "/user", true);
    resetPasswordXhr.setRequestHeader("Content-type", "application/json")
    resetPasswordXhr.send(JSON.stringify(user));

    resetPasswordXhr.onreadystatechange = function() {
        if(this.status == 200 && this.readyState == 4) {
            location.href = "/get-started.html"
        }
    }
}