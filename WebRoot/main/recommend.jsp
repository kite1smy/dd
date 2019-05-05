<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2>编辑推荐</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<s:iterator value="booksList">
			<!--编辑推荐开始-->
			<div class=second_c_02_b1>
				<div class=second_c_02_b1_1>
					<a
						href='<s:url namespace="/public" action="books_select"/>?books.bookId=<s:property value="bookId"/>'
						target='_blank'><img
						src="<s:property value="productImage"/>"
						width=70 border=0 /> </a>
				</div>
				<div class=second_c_02_b1_2>
					<h3>
						<a
							href='<s:url namespace="/public" action="books_select"/>?books.bookId=<s:property value="bookId"/>'
							target='_blank' title='输赢'><s:property value="bookName" /></a>
					</h3>
					<h4>
						作者：
						<s:property value="author" />
						著 <br /> 出版社：<s:property value="press"/>&nbsp;&nbsp;&nbsp;&nbsp;出版时间：2006-7-1
					</h4>
					<h5>简介: &nbsp;<s:property value="messages" /></h5>
					<h6>
						定价：￥
						<s:property value="bookPrice" />
						&nbsp;&nbsp;圆梦价：￥
						<s:property value="dangPrice" />
					</h6>
					<div class=line_xx></div>
				</div>
			</div>
		</s:iterator>

		<!--编辑推荐结束-->

	</div>
</div>
