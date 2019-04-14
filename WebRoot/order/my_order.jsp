<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>订单</title>
		<link rel="stylesheet"href="../css/dingdan.css"type="text/css">
	</head>
	<body>
		<table class="table-head table-mod">
			<tbody>
				<tr>
					<th width="331px">宝贝</th>
					<th>单价</th>
					<th>数量</th>
					<th>实付款</th>
					<th>交易状态</th>
				</tr>
			</tbody>
		</table>
		<!-- 外层循环 -->
		<s:iterator value="orderList">
		<div class="dom">
			<label>
				<span class="time">
					<input type="checkbox"/>
					<span class="time"><s:date name="orderTime"  format="yyyy-MM-dd hh:mm:ss" /></span>
				</span>
				<span>
					<span>订单号</span>
					<span>:</span>
					<span><s:property value="id"/></span>
				</span>
			</label>
		</div>
		
		
		<table class="tb">
			<!-- 内层循环 -->
			<s:iterator value="orderItemList" status="sta">
			<!-- 第一件商品 -->
			<tr>
				<td width="330px">
					<div style="display: block;">
						<img src='<s:property value="books.productImage"/>' style="float: left;"/>
						<p style="width: 230px; margin-left:10px; float: left;">
							<a href="javascript::"><span class="sp"><s:property value="books.bookName"/></span></a>
						</p>
					</div>
				</td>
				<td width="238px" align="center">
					<div>
						<p><s:property value="books.dangPrice"/>￥</p>
					</div>
				</td>
				<td width="238px" align="center"><s:property value="count"/></td>
				<s:if test="#sta.index==0">
					<td class="boder" rowspan='<s:property value="orderItemList.size" />'><s:property value="goodPrice"/>￥</td>
					<td class="boder" width="239px" rowspan='<s:property value="orderItemList.size" />'>
						<div>
							<p>
								<s:if test="orderState==0">未付款|<a href="http://localhost:8081/alipay.trade.page.pay-JAVA-UTF-8
								/index.jsp?id=<s:property value='id'/>&goodPrice=<s:property value="goodPrice"/>">付款</a></s:if>
								<s:if test="orderState==1">交易成功</s:if>
								</p>
							<p>订单详情</p>
						</div>
					</td>
				</s:if>
			</tr>
			</s:iterator>
		</table>
		</s:iterator>
		<div style="margin: 50px;text-align: center;">
				<a href="javascript:history.go(-1);">
				<input 	class="button_1"  type="button" value="取消" /></a>  
	    </div>
	</body>
</html>