<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div id="NewProduct_1_o_t" onmouseover="">
	<ul>
		<s:iterator value="booksList">
			 <li><a href='<s:url namespace="/public" action="books_select"/>?books.bookId=<s:property value="bookId"/>' target='_blank'><s:property value="bookName"/></a></li>
		 </s:iterator>
	</ul>
</div>