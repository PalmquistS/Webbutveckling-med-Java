<%@page import="beans.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome page</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link
	href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css"
	rel="stylesheet">

<link href="style/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
@use @material/icon-button";
@use "@material/top-app-bar/mdc-top-app-bar";

@include icon-button.core-styles;

@use "@material/switch";

@include switch.core-styles;
</style>
</head>
<body
	onload="checkCookie(<%UserBean bean = new UserBean();
int userId = 0;
// Check to see if the session has a user bean.
if (session.getAttribute("user") == null) {

	// if there is not one, goto the logout servlet
	RequestDispatcher rd = request.getRequestDispatcher("Logout");
	rd.forward(request, response);

} else {
	bean = (UserBean) session.getAttribute("user");
	userId = bean.getUserId();
	out.print(userId);
}%>)">


	<header class="mdc-top-bar mdc-top-app-bar">
  <div class="mdc-top-app-bar__row">
    <section class="mdc-top-app-bar__section mdc-top-app-bar__section--align-start">
      <span class="mdc-top-app-bar__title">Welcome</span>
    </section>
    <section class="mdc-top-app-bar__section mdc-top-app-bar__section--align-end" role="toolbar">
    
    	<form action="<%=request.getContextPath()%>/SearchForPostController" method="post">
	
	
	<label class="mdc-search mdc-text-field mdc-text-field--outlined">
					<span class="mdc-notched-outline"> <span
						class="mdc-notched-outline__leading"></span> <span
						class="mdc-notched-outline__notch"> <span
							class="mdc-floating-label" id="my-label-id">Search for post:</span>
					</span> <span class="mdc-notched-outline__trailing"></span>
				</span> <input type="text" name="searchForPost" class="mdc-text-field__input"
					aria-labelledby="my-label-id" required>
				</label>
		

	

	
      
      
      <button class="material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="Search" >search</button>
    </form>
    
     <form action="<%=request.getContextPath()%>/ShowAllPostsController" method="post">
      <button class="material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="Favorite">favorite</button>
        </form>
      
       <form action="success.jsp" >
  <button class="material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="Post_add" >post_add</button>
</form>
      
      
      <form action="<%=request.getContextPath()%>/Logout" method="post">
	
	
     
		     <button class="material-icons mdc-top-app-bar__action-item mdc-icon-button" aria-label="Logout" >logout</button>
</form>


     
    </section>
  </div>
</header>




	<main class="mdc-top-app-bar--fixed-adjust">


<label class="switch"> <input type="checkbox"> <span
			class="slider round" id="slider-id"
			onclick="changeColor(<%out.print(userId);%>)"></span>
		</label> <label for="another-basic-switch"> Dark mode off/on</label>


		<div class="index-card mdc-card mdc-card--outlined">
			<h1>
				Welcome,
				<%
			out.print(bean.getUserName());
			%>
			</h1>






		</div>


		

          <%@include file="includes/nextPostInclude.jsp" %>



	</main>
	<script
		src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
	<script>
		mdc.textField.MDCTextField
				.attachTo(document.querySelector('.mdc-search'));
	</script>
	<script>
		mdc.textField.MDCTextField
				.attachTo(document.querySelector('.mdc-tag'));
	</script>

	<script src="script/index.js"></script>
</body>
</html>