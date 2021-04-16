"use strict";


function setCookieExpireDate() {
	let date = new Date();
	date.setTime(date.getTime() + (10 * 60 * 1000));
	let expires = "expires=" + date.toUTCString();
	return expires;

}




function changeColor(id) {

	let isChecked = document.getElementById("slider-id").checked;
	let normal = "rgb(253, 253, 254)";
	let dark = "rgb(112, 128, 144)";


	if (isChecked) {
		document.body.style.background = normal;
		document.cookie = id + "=" + normal + ";" + setCookieExpireDate() + ";path=/";;
		document.getElementById("slider-id").checked = false;
	}
	else {
		document.body.style.background = dark;
		document.cookie = id + "=" + dark + ";" + setCookieExpireDate() + ";path=/";;
		document.getElementById("slider-id").checked = true;

	}
}




function checkCookie(id) {

	// Initiate checked function
	document.getElementById("slider-id").checked = false;

	let user = id;
	let cookieExists = false;
	let name = "";
	let value = "";
	let normal = "rgb(253, 253, 254)";

	// Read in all cookies as one string
	let cookie = document.cookie;

	// Get all the cookies pairs in an array
	let cookieArray = cookie.split(';');

	// Check if the cookie exist that has been search for
	for (let i = 0; i < cookieArray.length; i++) {
		name = cookieArray[i].split('=')[0];
		value = cookieArray[i].split('=')[1];

		if (user == name) {
			cookieExists = true;
			break;
		}
	}


	if (!cookieExists) {
		let userAccept = confirm("We use cookies!");
		if (userAccept) {
			cookie = user;
			document.cookie = user + "=" + normal + ";" + setCookieExpireDate() + ";path=/";;

		}
	}

	else {
		// If cookie already exists, set background color and change slider position on dark mode
		if (value == normal) {

			document.body.style.background = value;
			
		}

		else {

			document.body.style.background = value;
			document.getElementById("slider-id").click()

		}
	}
}


