<div class="index-card mdc-card mdc-card--outlined">
	<h4>Your next post:</h4>



	<form action="<%=request.getContextPath()%>/NewPostController"
		method="post">


		<label
			class="mdc-text mdc-text-field mdc-text-field--outlined mdc-text-field--textarea mdc-text-field--no-label">
			<span class="mdc-notched-outline"> <span
				class="mdc-notched-outline__leading"></span> <span
				class="mdc-notched-outline__trailing"></span>
		</span> <span class="mdc-text-field__resizer"> <textarea
					class="mdc-text-field__input" rows="8" cols="40" aria-label="Label"
					name="newPost" maxlength="5000" required></textarea>
		</span>
		</label> 
		
		
		

<label class=" mdc-tag mdc-text-field mdc-text-field--outlined">
  <span class="mdc-notched-outline">
    <span class="mdc-notched-outline__leading"></span>
    <span class="mdc-notched-outline__notch">
      <span class="mdc-floating-label" id="my-label-id">Tag:</span>
    </span>
    <span class="mdc-notched-outline__trailing"></span>
  </span>
  <input type="text" class="mdc-text-field__input" name="tagPost" aria-labelledby="my-label-id" >
</label>

		<button type="submit"
			class="post-button go-button mdc-button mdc-button--raised">
			<span class=" mdc-button__label">post</span>
		</button>
	</form>
</div>