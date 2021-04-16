
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Blankbook log in</title>
<link
	href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css"
	rel="stylesheet">

<link href="style/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="index-main-div">
		<div class="welcome-text">
			<h1>Welcome to Blankbook!</h1>
			<p>Enter your user name and password to log in.</p>
			</div>
			
			<div class="index-card mdc-card mdc-card--outlined">

			<form class="form" action="<%=request.getContextPath()%>/ControllerLogIn" method="post">
				<label class="mdc-user mdc-text-field mdc-text-field--outlined">
					<span class="mdc-notched-outline"> <span
						class="mdc-notched-outline__leading"></span> <span
						class="mdc-notched-outline__notch"> <span
							class="mdc-floating-label" id="my-label-id">Email:</span>
					</span> <span class="mdc-notched-outline__trailing"></span>
				</span> <input type="email" name="email" class="mdc-text-field__input"
					aria-labelledby="my-label-id">
				</label> 
				
				<label class="mdc-pass mdc-text-field mdc-text-field--outlined">
					<span class="mdc-notched-outline"> <span
						class="mdc-notched-outline__leading"></span> <span
						class="mdc-notched-outline__notch"> <span
							class="mdc-floating-label" id="my-label-id">Password:</span>
					</span> <span class="mdc-notched-outline__trailing"></span>
				</span> <input type="password" name="pass" class="mdc-text-field__input"
					aria-labelledby="my-label-id">
				</label>
				<div >
				<button type="submit"
					class="index-button go-button mdc-button mdc-button--raised">
					<span class=" mdc-button__label">Go</span>
				</button>
				</div>
			</form>


		</div>



	</div>
	
	<script
		src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>


	<script>
		mdc.textField.MDCTextField
				.attachTo(document.querySelector('.mdc-user'));
	</script>
	<script>
		mdc.textField.MDCTextField
				.attachTo(document.querySelector('.mdc-pass'));
	</script>

</body>
</html>