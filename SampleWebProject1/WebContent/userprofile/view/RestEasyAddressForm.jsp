<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="/SampleWebProject/userprofile/css/themes/default/easyui.css" />
<script type="text/javascript" src="/SampleWebProject/userprofile/js/jquery.min.js"></script>  
<script type="text/javascript" src="/SampleWebProject/userprofile/js/jquery.easyui.min.js"></script>

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
$(document).ready(function(){
	$("#RestEasyAddressFormSubmitBtn").click(
		function(){
			street1Val = $("#street1").val();
			street2Val = $("#street2").val();
			cityVal = $("#city").val();
			provinceVal = $("#province").val();
			zipCodeVal = $("#zipCode").val();

			var address = {};
			address.street1 = street1Val;
			address.street2 = street2Val;
			address.city = cityVal;
			address.province = provinceVal;
			address.zipCode = zipCodeVal;

			alert(JSON.stringify(address));

			var request = $.ajax({
	            type: "POST",
	            url: "/SampleWebProject/resteasy/Address",
	            contentType: 'application/json',
	            data: JSON.stringify(address),
	            dataType: "application/json"
	        });
	        request.always(function(data) {

		        console.log(data);
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
		<label>Address Form</label>
	</div>
	<div class="formElement">
        <label for="street1" class="formLabel">Street1 :</label>
        <input class="easyui-validatebox" type="text" id="street1" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="street2" class="formLabel">Street2 :</label>
        <input class="easyui-validatebox" type="password" id="street2" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="city" class="formLabel">City :</label>
        <input class="easyui-validatebox" type="text" id="city" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="province" class="formLabel">Province :</label>
        <input class="easyui-validatebox" type="text" id="province" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="zipCode" class="formLabel" style="margin-right:42px;">Zipcode :</label>
        <input class="easyui-validatebox" type="text" id="zipCode" data-options="required:true" />
    </div>
    <div class="submitBtn">
    	<button id="RestEasyAddressFormSubmitBtn">Submit</button>
    </div>
</form>
</body>
</html>