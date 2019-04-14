<%@page contentType="text/html;charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
ul li {
	text-decoration: none;
	list-style-type: none;
	line-height: 20px;
}

body {
	font-family: 宋体, Arial, Helvetica, sans-serif;
	font-size: 12px;
	background: #769b72 url(../images/booksaleimg/bg_grad.gif) top center
		no-repeat;
	cursor: default;
	color: #404040;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function f() {
		var path = '<s:url action="cart_add" namespace="/private"/>?books.bookId=<s:property value="books.bookId"/>&d='
				+ new Date().getSeconds();
		$(".abc").next().prop("src", path);
		$(".abc").prop("src", "../images/load.gif");
		setTimeout(function() {
			$(".abc").prop("src", "../images/label3.gif");
		}, 1000);
		setTimeout(function() {
			$(".abc").prop("src", "../images/buttom_goumai.gif");
		}, 2000);
	}
</script>
</head>
<body>
	<div style="width: 60%; margin: 20px auto;">
		<div style="width: 100%; float: left;">
			<h1></h1>
			<span><font color="#cccccc">丛书名：<s:property
						value="books.bookName" /></font></span>
			<hr />
			<div>
				<div style="float: left; width: 20%;">
					<img
						src='<s:property value="books.productImage"/>'
						border=0 />
				</div>
				<div style="float: left; width: 80%">
					<ul class="info">
						<li>作&nbsp;者：<s:property value="books.author" /></li>
						<li>出版社：大象出版社</li>
						<li style="float: left; width: 50%;">出版时间：2018-1-1</li>
						<li style="float: left; width: 50%;">字数：16k</li>
						<li style="float: clear;"></li>
						<li style="float: left; width: 50%;">版次：4</li>
						<li style="float: left; width: 50%;">页数：200</li>
						<li style="float: clear;"></li>
						<li style="float: left; width: 50%;">印刷时间：2018-6-1</li>
						<li style="float: left; width: 50%;">开本： 4</li>
						<li style="float: clear;"></li>
						<li style="float: left; width: 50%;">印次：2</li>
						<li style="float: left; width: 50%;">纸张：草纸</li>
						<li style="float: clear;"></li>
						<li style="float: left; width: 50%;">ISBN：xxx</li>
						<li style="float: left; width: 50%;">包装：精包装</li>
						<li>
							<div class='your_position'>
								您现在的位置:&nbsp; <a href='../main/main.jsp'>圆梦图书</a> &gt;&gt; <font
									style='color: #cc3300'> <a href="#"><s:property
											value='books.category.parentCategory.categoryName' /></a>
									&gt;&gt; <strong><a href="#"><s:property
												value='books.category.categoryName' /></a></strong>
								</font>
							</div>
						</li>
						<li>定价：￥<s:property value="books.bookPrice" />&nbsp;&nbsp;
							圆梦价：￥<s:property value="books.dangPrice" />&nbsp;&nbsp;节省：￥<s:property
								value="books.bookPrice-books.dangPrice" />
						</li>
						<li><img src='../images/buttom_goumai.gif' class="abc"
							onclick="f()" /> <img src='' style="display: none" /></li>
					</ul>
				</div>
				<div style="float: clear;"></div>
			</div>
		</div>
	</div>
</body>
</html>