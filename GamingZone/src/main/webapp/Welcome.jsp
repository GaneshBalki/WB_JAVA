<%@page import="com.demo.beans.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.demo.service.ProductService"%>
<%@page import="com.demo.service.ProductServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GameZone Shopping Center</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        min-height: 100vh;
    }

    header {
        background-color: #333;
        color: #fff;
        padding: 10px;
    }

    header a {
        color: #fff;
        text-decoration: none;
        margin-left: 10px;
    }

    div {
        display: flex;
        margin-top: 100px;
        flex-wrap: wrap;
        justify-content: center;
    }

    div > div {
        width: 250px;
        height: 300px;
        margin: 10px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    form {
        display: inline-block;
        margin-top: 10px;
    }

    form button {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 8px 12px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 14px;
        border-radius: 5px;
        cursor: pointer;
    }

    footer {
        background-color: #333;
        color: #fff;
        padding: 10px;
        text-align: center;
        margin-top: auto;
    }

    div > div a {
        display: block;
        margin-bottom: 10px;
    }

    div > div img {
       width: 250px;
        height: auto;
    }
</style>

</head>
<body>
	<header>
		<b><span>GameZone Shopping Center</span></b> <a href="#">Home</a> | <a
			href="#">Category</a> | <a href="#">Login</a> |
	</header>
	<%
	ProductService ps = new ProductServiceImpl();
	List<Product> plist = ps.getAllProducts();
	%>
	
	<div style='display: flex;   margin-top:100px;'>
	<% 
	for(Product p:plist){
		%>
		<div >
			<form action='addtocart' method='post'>
				<input type='hidden' name='pid' value='<%=p.getPid() %>' /> 
				<input type='hidden' name='cid' value='<%=p.getCatId() %>' />
				<input type='hidden' name='cid' value='<%=p.getQty() %>' /> 
				
				<img src='<%=p.getImgurl() %>' alt="KEYBORD" width="250px">
				<p><%=p.getPname() %></p>
				<p><%=p.getPrice() %> &#x20b9</p>
			
				<button type='submit'>Add To Cart</button>
			</form>
		</div>
		
		<%
	}
	%></div>
	<c:forEach var='product' items='${plist}'>
		<div style='width: fit-content;height: fit-content'>
			<form action='addtocart' method='post'>
				<input type='hidden' name='pid' value='${product.pid}' /> 
				<input type='hidden' name='cid' value='${product.catId}' /> 
				<a href='${product.imgurl}'>Product Image</a>
				<p>${product.getPname()}</p>
				<p>${product.price}</p>
				<p>${product.shortDisc}</p>
				<button type='submit'>Add To Cart</button>
			</form>
		</div>
	</c:forEach>

	<footer style='margin-bottom: 0px;'>
		<p>All Right are reserved @gamezone.com</p>
	</footer>

</body>
</html>