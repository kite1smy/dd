<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<s:iterator value="categoryList">
					<s:set var="pid" value="categoryId"/>
					<h3>[<a href='<s:url namespace="/public" action="books_selectByPage"/>?category.parentCategory.categoryId=<s:property value="#pid"/>'><s:property value="categoryName"/></a>]</h3>
					<ul class="ul_left_list">
					<s:iterator value="childrenCategory">
							<!--2级分类开始-->
							<li>
								<a href='<s:url namespace="/public" action="books_selectByPage"/>
								?category.categoryId=<s:property value="categoryId"/>
								&category.parentCategory.categoryId=<s:property value="#pid"/>
								'><s:property value="categoryName"/></a>
							</li>
							<!--2级分类结束-->
					</s:iterator>
						</ul>
						<div class="empty_left">
						</div>
				</s:iterator>
			</div>

			<div class="more2">
			</div>
			<!--1级分类结束-->

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
