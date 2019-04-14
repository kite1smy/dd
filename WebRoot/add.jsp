<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <h1>添加图书</h1><hr/>
	<form action='<s:url action="ma_add" namespace="/"/>' method="post" enctype="multipart/form-data">
		名字：<input type="text" name="books.bookName"/><br/>
		作者：<input type="text" name="books.author"/><br />
		原价：<input type="text" name="books.bookPrice"/><br />
		当当价：<input type="text" name="books.dangPrice"/><br />
		库存：<input type="text" name="books.inventory"/><br />
		<select name="books.category.categoryId">
		<s:iterator value="#application.branchesList">
			<option value='<s:property value="categoryId"/>' ><s:property value="categoryName"/></option>
		</s:iterator>
		</select>
		封面：<input type="file" name="image"/><br/>
		<input type="submit"/>	
	</form>
  </body>
</html>
