<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<link href="../css/book_head090107.css" rel="stylesheet" type="text/css" />
<div class="head_container">
	<div class="head_welcome">
		<div class="head_welcome_right">
			<span class="head_welcome_text"> </span>
			<span class="head_welcome_text"> <span class="little_n">
					| <a href='<s:url action="address_showAll" namespace="/private"/>' name="myaddress" class="head_black12a">我的收货地址</a>
					| <a href='<s:url namespace="/private" action="order_orderList"/>' name="mydangdang" class="head_black12a">我的订单</a> | <a
					href="#" name="helpcenter" class="head_black12a" target="_blank">帮助</a>
					| </span> </span>
			<div class="cart gray4012">
				<a href='<s:url namespace="/private" action="cart_show"/>'>购物车</a>
			</div>
		</div>
		<span class="head_toutext" id="logininfo">
		<b><s:property value="#session.user.nickName"/>您好，欢迎光临圆梦网</b>
		<s:if test="#session.user!=null">
			[&nbsp;<a href='<s:url action="user_loginOut" namespace="/public"/>' class="b">登出</a>&nbsp;]
		</s:if>
		<s:else>
			[&nbsp;<a href="../user/login_form.jsp" class="b">登录</a>|<a
			href="../user/register_form.jsp" class="b">注册</a>&nbsp;]
		</s:else>
		</span>
	</div>
	<div class="head_head_list">
		<div class="head_head_list_left">
			<span class="head_logo"><a href="#" name="backtobook"><img
						src="" /> </a> </span>
		</div>
		<div class="head_head_list_right">

			<div class="head_head_list_right_b">
			</div>
		</div>
	</div>
	<div class="head_search_div">

	</div>
	<div class="head_search_bg"></div>
</div>
