<%@ include file="../common/common.jsp"%>
<html lang="en">
  <body>
  		<h2 class="sub-header">Account</h2>
       	<form id="accAddForm">
       	  <div class="form-group row">
		    <label for="loginName" class="col-sm-2 col-form-label">Login name</label>
		    <div class="col-sm-6">
		    	<input type="text" class="form-control" id="loginName" name="loginName" placeholder="Enter login name"/>
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="email" class="col-sm-2 col-form-label">Email address</label>
		    <div class="col-sm-6">
		    	<input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email"/>
		    	<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="password" class="col-sm-2 col-form-label">Password</label>
		    <div class="col-sm-6">
		    	<input type="password" class="form-control" id="password" name="password" placeholder="Password"/>
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="aliasName" class="col-sm-2 col-form-label">Alias name</label>
		    <div class="col-sm-6">
		    	<input type="text" class="form-control" id="aliasName" name="aliasNm" placeholder="Enter alias name"/>
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="gender" class="col-sm-2 col-form-label">Gender</label>
		    <div class="col-sm-6">
		    	<select class="form-control" id="gender" name="gender">
				  <option selected>- Selected -</option>
				  <option value="Male">Male</option>
				  <option value="Female">Female</option>
				</select>
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="orgPath" class="col-sm-2 col-form-label">Organization</label>
		    <div class="col-sm-6">
		    	<input type="text" class="form-control" id="orgPath" name="orgPath" aria-describedby="emailHelp" placeholder="Enter organization path">
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		  	<label for="startTime" class="col-sm-2 col-form-label">Available from</label>
            <div class='input-group date col-sm-6' id='datetimepickerFrom'>
               	<input type="text" class="form-control" id="startTime" name="startTime" placeholder="Enter start time">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
            <div class="col-sm-4">
		    	<span></span>
		    </div>
          </div>
          <div class="form-group row">
          	<label for="endTime" class="col-sm-2 col-form-label">Available to</label>
            <div class='input-group date col-sm-6' id='datetimepickerTo'>
               	<input type="text" class="form-control" id="endTime" name="endTime" placeholder="Enter end email">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
            <div class="col-sm-4">
		    	<span></span>
		    </div>
          </div>
          <div class="form-group row">
		    <label for="lockUpN" class="col-sm-2 col-form-label">Lock up</label>
		    <div class="col-sm-6">
		    	<div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="lockUp" id="lockUpY" value="Y"/>
				  <label class="form-check-label" for="lockUpY">Yes</label>
				  <input class="form-check-input" type="radio" name="lockUp" id="lockUpN" value="N" checked/>
				  <label class="form-check-label" for="lockUpN">No</label>
				</div>
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
          <div class="row">
			    <div class="col-sm-3 col-sm-offset-5">
			    	<button id="submit" type="submit" class="btn btn-primary glyphicon glyphicon-ok black"> Submit</button>
		  			<button type="reset" class="btn btn-primary glyphicon glyphicon-repeat"> Reset</button>
		  			<button id="goBack" type="button" class="btn btn-primary glyphicon glyphicon-share-alt"> Goback</button>
			    </div>
			</div>
		</form>
        <br/>
  </body>
  	<script type="text/javascript" >
  	$(function () {
        $('#datetimepickerFrom').datetimepicker();
        $('#datetimepickerTo').datetimepicker({
            useCurrent: false 
        });
        $("#datetimepickerFrom").on("dp.change", function (e) {
            $('#datetimepickerTo').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepickerTo").on("dp.change", function (e) {
            $('#datetimepickerFrom').data("DateTimePicker").maxDate(e.date);
        });
        
        $('#accAddForm').validate({
        	debug: true,
        	onfocusout: true,
        	rules: {
				loginName: {
					required: true,
					minlength: 2,
					maxlength: 100
				},
				email: {
					required: true,
					email: true
				},
				password: {
					required: true,
					minlength: 8,
					maxlength: 100
				},
				aliasNm: {
					required: true,
					minlength: 2,
					maxlength: 100
				}
			},
			messages: {
				loginName: {
					required: "Please enter a loginName",
					minlength: "Your loginName must consist of at least 2 characters",
					maxlength: "Your loginName must consist of at least 2 characters"
				},
				email: "Please enter a valid email address",
				password: {
					required: "Please provide a password",
					minlength: "Your password must be at least 8 characters long",
					maxlength: "Your password must consist of at least 2 characters"
				},
				aliasNm: {
					required: "Please enter a aliasName",
					minlength: "Your aliasName must consist of at least 2 characters",
					maxlength: "Your aliasName must consist of at least 2 characters"
				}
			},
			errorPlacement: function(error, element) {
				var nextElement = element.parent().parent().find(".col-sm-4").find("span");
			    error.addClass("text-danger").insertAfter(nextElement);
			},
			submitHandler:function(form){
				$.ajax({
	  	  			url:'./user',
	  	  			type:'POST',
	  	  			data:$(form).serialize(),
	  	  			success:function(data,status){
	  	  				console.log(data);
	  	  				var result = jQuery.parseJSON(data);
	  	  				if(result.result == 'success'){
	  	  					form.reset();
	  	  					Shaunz.showSuccess('Success',result.message);
	  	  				} else {
	  	  					Shaunz.showError('Error',result.message);
	  	  				}
	  	  			},
	  	  			error:function(e){
	  	  				console.log(e);
	  	  			}
	  	  		});
			}
  		});
        
        $('#goBack').click(function(){
        	$('#FeatureContainer').load('./mngpages/account_lst.html');
        });
    });
	</script>
</html>
