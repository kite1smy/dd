<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">
<s:iterator value="booksList">
	<!--热销图书A开始-->
	<div class="second_d_wai">
	
		<div class="img">
			<a href='<s:url namespace="/public" action="books_select"/>?books.bookId=<s:property value="bookId"/>' target='_blank'><img
					src="<s:property value="productImage"/>" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href='<s:url namespace="/public" action="books_select"/>?books.bookId=<s:property value="bookId"/>' target="_blank"><s:property value="bookName"/></a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥<s:property value="bookPrice" />
		</div>
		<div class="price">
			圆梦价：￥<s:property value="dangPrice" />
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
</s:iterator> 
</div>
<div class="clear"></div>