<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 圆梦网</title>
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
 	function checkname(){
 		$(this).next().find("span").html("");
 		if(this.value){
 			$(this).next().find("span").html("姓名不能为空");
 		}
 	}
 	function checkeaddress(){
 		$(this).next().find("span").html("");
 		if(this.value){
 			$(this).next().find("span").html("地址不能为空");
 		}
 	}
 	function checkphone(){
 		$(this).next().find("span").html("");
 		if(this.value){
 			$(this).next().find("span").html("手机号不能为空");
 		}
 	}
 	function checkForm(){
 		var a = false;
 		$("span[style='color:red']").each(function(){
 			a|=$(this).html();
 		});
 		return !a&&$("#receiveName").val();
 	}
 	function historyGo(obj){
 		window.history.back(obj);
 	}
</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		添加收货地址：
	</div>
	<div class="fill_message">
	
		<form name="ctl00" action='<s:url action="address_add" namespace="/private"/>'
			method="post" id="f" onsubmit="return checkForm()">
			<input type="hidden" name="address.user.id" id="addressId" value='<s:property value="#session.user.id"/>'/>
			<table class="tab_login">
				<tr>
					<td valign="top" class="w1">收件人姓名：</td>
					<td><input onblur="checkname()" type="text" class="text_input"
						name="address.receiveName" id="receiveName" />
						<div class="text_left" id="nameValidMsg">
							<p>请填写有效的收件人姓名</p>
							<span id="name.info" style="color:red"></span>
						</div>
					</td>
				</tr>
				<tr>
					<td valign="top" class="w1">收件人详细地址：</td>
					<td><input onblur="checkeaddress()" type="text"
						name="address.address" class="text_input" id="fullAddress" />
						<div class="text_left" id="addressValidMsg">
							<p>请填写有效的收件人的详细地址</p>
							<span id="address.info" style="color:red"></span>
						</div></td>
				</tr>
				<tr>
					<td valign="top" class="w1">手机</td>
					<td><input onblur="checkphone()" type="text"
						class="text_input" name="address.mobile" id="phone" />
						<div class="text_left" id="phoneValidMsg">
							<p>请填写有效的收件人的手机</p>
							<span id="telphone.info" style="color:red"></span>
						</div></td>
				</tr>
			</table>

			<div class="login_in">
				<a href="javascript:historyGo(-1);"><input id="btnClientRegister"
					class="button_1"  type="button" value="取消" /></a> 
				<input id="btnClientRegister" class="button_1" name="submit" type="submit"
					value="添加" />
			</div>
		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

