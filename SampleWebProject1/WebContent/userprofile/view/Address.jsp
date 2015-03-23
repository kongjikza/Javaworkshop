<%@page import="com.jas.myweb.domain.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map, com.jas.myweb.domain.Address" %>
    
<%
	String street1 = null;
	String street2 = null;
	String city = null;
	String province = null;
	int zipCode = 0;
	
	Map<String, Address> addressDb = (Map<String, Address>) application.getAttribute("USER_DB");
	if (addressDb != null) {
		Address address = addressDb.get( request.getParameter("city") );
		if (address != null) {
			street1 = address.getStreet1();
			street2 = address.getStreet2();
			city = address.getCity();
			province = address.getProvince();
			zipCode = address.getZipCode();
		}
	}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Street1: <%= street1 %><br>
street2: <%= street2 %><br>
city: <%= city %> <%= zipCode %><br>
province: <%= province %><br>
</body>
</html>