<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="/SampleWebProject/newuserprofile/css/themes/default/easyui.css" />
<script type="text/javascript" src="/SampleWebProject/newuserprofile/js/jquery.min.js"></script>  
<script type="text/javascript" src="/SampleWebProject/newuserprofile/js/jquery.easyui.min.js"></script>

<style>
#formTitle {
    color: orange;
    font-weight: bold;
    margin-bottom: 15px;
}

.formElement {
	font-size: 16px;
}

.formLabel {
	margin-right:15px;
}

.submitBtn {
	font-size: 16px;
	margin-top: 15px;
	margin-left: 90px;
}
</style>

<script type="text/javascript">

function initData() {
	$.get("/SampleWebProject/spring/province",
		function(data, status){
			setProvinceComboBox(data);
	});

	$.get("/SampleWebProject/spring/educationinstitute",
			function(data, status){
				setInstituteComboBox(data);
	});
}

function setProvinceComboBox(inputData) {
	$('#provinceCbx').combobox({
		valueField: 'id',
		textField: 'provinceName',
	    data: inputData
	});
}

function setInstituteComboBox(inputData) {
	$('#instituteCbx').combobox({
		valueField: 'id',
		textField: 'instituteName',
	    data: inputData
	});
}
</script>

<script type="text/javascript">
$(document).ready(function(){
	initData();

	
	$("#userProfileFormSubmitBtn").click(
		function(){

			userNameVal = $("#userNameTF").val();
			passwordVal = $("#passwordTF").val();
			firstNameVal = $("#firstNameTF").val();
			lastNameVal = $("#lastNameTF").val();
			emailVal = $("#emailTF").val();
			street1Val = $("#street1TF").val();
			street2Val = $("#street2TF").val();
			provinceVal = $("#provinceCbx").combobox("getValue");
			zipCodeVal = $("#zipCodeTF").val();
			positionVal = $("#positionTF").val();
			jobFromYearVal = $("#jobFromYearTF").val();
			jobToYearVal = $("#jobToYearTF").val();
			provinceVal = $("#provinceCbx").combobox("getValue");
			instituteVal = $("#instituteCbx").combobox("getValue");
			qualificationVal = $("#qualificationTF").val();
			educationInstituteFromYearVal = $("#educationInstituteFromYearTF").val();
			educationInstituteToYearVal = $("#educationInstituteToYearTF").val();

			var formParam = {};
			userAccount = {'userName':userNameVal, 'password':passwordVal};
			homeAddress = {'street1':street1Val, 'street2':street2Val, 'zipCode':zipCodeVal, 'province':{'id':provinceVal}};
			educations = [{'educationInstitute':{'id':instituteVal}, 'qualification':qualificationVal,
				'fromYear':educationInstituteFromYearVal, 'toYear':educationInstituteToYearVal}];
			jobs = [{'position':positionVal, 'fromYear':jobFromYearVal, 'toYear':jobToYearVal}];
			userProfile = {'firstName':firstNameVal, 'lastName':lastNameVal, 'email':emailVal,
					'userAccount':userAccount,
					'homeAddress':homeAddress,
					'educations':educations,
					'jobs':jobs};
			formParam = { 'userProfile': userProfile };

			/*
			formParam = {};
			formParam.userName = userNameVal;
			formParam.password = passwordVal;
			formParam.firstName = firstNameVal;
			formParam.lastName = lastNameVal;
			formParam.email = emailVal;
			formParam.street1 = street1Val;
			formParam.street2 = street2Val;
			formParam.provinceId = provinceVal;
			formParam.zipCode = zipCodeVal;
			formParam.educationInstituteId = instituteVal;
			formParam.educationQualification = qualificationVal;
			formParam.educationFromYear = educationInstituteFromYearVal;
			formParam.educationToYear = educationInstituteToYearVal;
			formParam.jobPosition = positionVal;
			formParam.jobFromYear = jobFromYearVal;
			formParam.jobToYear = jobToYearVal;			
			*/
			
			alert(JSON.stringify(formParam));
			
			//alert("value=" + $('#provinceCbx').combobox('getValue') + ", name=" + $('#provinceCbx').combobox('getText'));
			
			var request = $.ajax({
	            type: "POST",
	            url: "/SampleWebProject/resteasy/v2/userprofile",
	            contentType: 'application/json',
	            data: JSON.stringify(formParam),
	            dataType: "application/json"
	        });
	        request.always(function(data) {
	        	if (data.statusText == 'OK') {
	            	alert("บันทึกรายการเรียบร้อย");
	        	} else {
	        		alert("พบข้อผิดพลาด ไม่สามารถบันทึกรายการได้");
	        	}
	        });
	});
});
</script>

<title>Insert title here</title>
</head>
<body>
	<div id="formTitle">
		<label>User Profile Form</label>
	</div>
	<div class="formElement">
        <label for="userNameTF" class="formLabel">User name:</label>
        <input class="easyui-validatebox" type="text" id="userNameTF" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="passwordTF" class="formLabel">Password:</label>
        <input class="easyui-validatebox" type="password" id="passwordTF" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="firstNameTF" class="formLabel">First name:</label>
        <input class="easyui-validatebox" type="text" id="firstNameTF" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="lastNameTF" class="formLabel">Last name:</label>
        <input class="easyui-validatebox" type="text" id="lastNameTF" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="emailTF" class="formLabel" style="margin-right:42px;">Email:</label>
        <input class="easyui-validatebox" type="text" id="emailTF" data-options="validType:'email'" />
    </div>

	<div id="formTitle" style="margin-top:15px;">
		<label>Home Address</label>
	</div>
    <div class="formElement">
        <label for="street1TF" class="formLabel" style="margin-right:42px;">Street1:</label>
        <input class="easyui-validatebox" type="text" id="street1TF" />
    </div>
    <div class="formElement">
        <label for="street2TF" class="formLabel" style="margin-right:42px;">Street2:</label>
        <input class="easyui-validatebox" type="text" id="street2TF" />
    </div>
    <div class="formElement">
        <label for="provinceCbx" class="formLabel" style="margin-right:33px;">Province:</label>
        <input class="easyui-combobox" type="text" id="provinceCbx" />
    </div>
    <div class="formElement">
        <label for="zipCodeTF" class="formLabel" style="margin-right:37px;">Zipcode:</label>
        <input class="easyui-validatebox" type="text" id="zipCodeTF" />
    </div>

	<div id="formTitle" style="margin-top:15px;">
		<label>Job</label>
	</div>
	<div class="formElement">
        <label for="positionCbx" class="formLabel" style="margin-right:40px;">Job position:</label>
        <input class="easyui-validatebox" type="text" id="positionTF" data-options="required:true" style="width:400px;" />
    </div>
	<div class="formElement">
        <label for="jobFromYearTF" class="formLabel" style="margin-right:80px;">Period:</label>
        From year <input class="easyui-validatebox" type="text" id="jobFromYearTF" data-options="required:true" />
        To year <input class="easyui-validatebox" type="text" id="jobToYearTF" data-options="required:true" />
    </div>
    
    
    <div id="formTitle" style="margin-top:15px;">
		<label>Education</label>
	</div>
	<div class="formElement">
        <label for="instituteCbx" class="formLabel">Education institute:</label>
        <input class="easyui-combobox" type="text" id="instituteCbx" />
    </div>
    <div class="formElement">
        <label for="qualificationTF" class="formLabel" style="margin-right:37px;">Qualification:</label>
        <input class="easyui-validatebox" type="text" id="qualificationTF" />
    </div>
	<div class="formElement">
        <label for="educationInstituteFromYearTF" class="formLabel" style="margin-right:100px;">Period:</label>
        From year <input class="easyui-validatebox" type="text" id="educationInstituteFromYearTF" data-options="required:true" />
        To year <input class="easyui-validatebox" type="text" id="educationInstituteToYearTF" data-options="required:true" />
    </div>
    

    <div class="submitBtn">
    	<button id="userProfileFormSubmitBtn">Submit</button>
    </div>
</form>
</body>
</html>