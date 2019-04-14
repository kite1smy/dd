<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>生成订单 - 圆梦网</title>
<link href="../css/login.css" rel="stylesheet" type="text/css" />
<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
<link href="../css/address.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		cs($("[checked='checked']")[0]);
		//为单选框追加事件
		$("[name='order.address.id']").click(function(){
			cs(this);
		});
	});
	function cs(obj){
		//所有div隐藏
		$("li div").css("display","none");
		//所有的样式清空
		$("li").removeClass("address-wrap selected");
		
		//显示div
		$(obj).parent().parent().find("div").css("display","block");
		//追加class
		$(obj).parent().parent().addClass("address-wrap selected");
		
	}	
</script>
</head>
<body>
	<%@include file="../common/head1.jsp"%>
	<div class="login_step">
		生成订单骤: 1.确认订单 ><span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
	</div>
	<div class="fill_message">

		<form action='<s:url action="order_createOrder" namespace="/private"/>' method="post">
			<div class="address-wrap">
				
				<ul class="address-list">
				
				<!-- 寄送地址开始 -->
				
				<s:iterator value="addressList"> 
					
						<!-- 选中的样式 -->
						<%-- <li class="address-wrap selected">
							<div class="addressBox">
								<span class="marker-tip">寄送至</span>
							</div>  --%>
					
					
						<li class="address-wrap">
							<div class="addressBox" style="display: none">
								<span class="marker-tip">寄送至</span>
							</div>
							<!-- 数据 -->
							<label class="addressInfo"> 
								<input type="radio" name="order.address.id" value='<s:property value="id"/>'
						 		 <s:if test="selectedState==1">checked="checked"</s:if>/>
									<span class="user-address"> 
										<span><s:property value="address"/> </span> 
										<span>（</span>
										<span><s:property value="receiveName"/></span> 
										<span> 收）</span> 
										<em><s:property value="mobile"/></em>
									</span>
							</label>
						</li>
				</s:iterator>
				<!-- 寄送地址结束 -->
				</ul>
				
			</div>


			<div class="login_in">
				<input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" />
			</div>

		</form>
	</div>
	<%@include file="../common/foot1.jsp"%>
</body>
</html>

