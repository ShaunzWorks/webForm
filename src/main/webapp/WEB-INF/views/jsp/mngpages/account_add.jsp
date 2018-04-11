<%@ include file="../common/common.jsp"%>
<html lang="en">
  <body>
  		<h2 class="sub-header">Account</h2>
       	<form action=''>
       	  <div class="form-group row">
		    <label for="loginName" class="col-sm-2 col-form-label">Login name</label>
		    <div class="col-sm-6">
		    	<input type="text" class="form-control" id="loginName" placeholder="Enter login name"/>
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="email" class="col-sm-2 col-form-label">Email address</label>
		    <div class="col-sm-6">
		    	<input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email"/>
		    	<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="password" class="col-sm-2 col-form-label">Password</label>
		    <div class="col-sm-6">
		    	<input type="password" class="form-control" id="password" placeholder="Password"/>
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		    <label for="gender" class="col-sm-2 col-form-label">Gender</label>
		    <div class="col-sm-6">
		    	<select class="form-control form-control-sm" id="gender">
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
		    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Organization</label>
		    <div class="col-sm-6">
		    	<input type="text" class="form-control" id="orgPath" aria-describedby="emailHelp" placeholder="Enter organization path">
		    </div>
		    <div class="col-sm-4">
		    	<span></span>
		    </div>
		  </div>
		  <div class="form-group row">
		  	<label for="startTime" class="col-sm-2 col-form-label">Available from</label>
            <div class='input-group date col-sm-6' id='datetimepickerFrom'>
               	<input type="text" class="form-control" id="startTime" placeholder="Enter start time">
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
               	<input type="text" class="form-control" id="endTime" placeholder="Enter end email">
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
            <div class="col-sm-4">
		    	<span></span>
		    </div>
          </div>
          <div class="row">
			    <div class="col-sm-3 col-sm-offset-5">
			    	<button id="submit" type="button" class="btn btn-primary">Submit</button>
		  			<button type="reset" class="btn btn-primary">Reset</button>
		  			<button id="goBack" type="button" class="btn btn-primary" onClick="openAccountLstPage()">Go Back</button>
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
    });
  	function openAccountLstPage(){
  		$('#FeatureContainer').load('./mngpages/account_lst.html');
  	};
	</script>
</html>
