<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="com.hotel.showRoom_Jdbc" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
* {
            margin: 0px;
            padding: 0px;
        }

        body > div {
            border: 1px solid navy;
            width: 400px;
            margin: 10px 300px;
            box-shadow: 10px 40px 20px -20px black;
        }

        body > div > div {

        }
body > div > div > h2 {
            background-color: orange;
            color: blueviolet;
            text-transform: capitalize;
        }

        body > div > div >  p:nth-child(2) {
            background-color: burlywood;
            color: crimson;
            height: 70px;
        }
        body > div > div > p:nth-child(3) {
            background-color: darkcyan;
            color: ghostwhite;
        }
        body > div > div > p:nth-child(4) {
            display: inline-block;
            background-color: gold;
            padding: 10px;
        }
        body > div > div > p:nth-child(5) {
            display: inline-block;
            background-color: gold;
            padding: 10px;
        }
   </style>
<body>
<% String city1 =request.getParameter("city"); %>
<% String roomtype =request.getParameter("rtype");%>

<% ResultSet res=showRoom_Jdbc.showroom(city1,roomtype); %>
<table>
<% while(res.next())
{
	String hot_id = res.getString("hotel_id");
	String city = res.getString("city");
	String ht_name=res.getString("hotel_name");
	String address = res.getString("address");
	String des= res.getString("discription");
	String ppn = res.getString("price_per_night");
	String phone1 = res.getString("phone1");
    String rating = res.getString("rating");

%>
<div> 
   <div>
   <h2><%= ht_name %></h2>
   <h2><%= des %></h2>
   <h2><%= address %></h2>
   <h2><%= phone1 %></h2>
   <h2><%= rating %></h2>
   <a href= "book?id=<%= hot_id %>" style="background-color: red; border: 1px solid black; text-decoration: none; width: 100px;">Book</a>
   </div>
   </div>
   <%} %>
</table>
</body>
</html>