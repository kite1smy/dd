<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>圆梦网图书 – 圆梦之旅从此开启</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='<s:url value='/main/main.jsp'/>'>圆梦网图书</a> &gt;&gt;
			<a href='#'><font style='color: #cc3300'><strong><s:property value="category.categoryName"/></strong> </font></a>
			<s:if test="level==2">&gt;&gt;<font style='color: #cc3300'><strong><s:property value="branchName"/></strong></font></s:if>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										<s:set var="pid" value="category.categoryId"/>
										<a href='<s:url action="books_selectByPage" namespace="/public"/>
										?category.parentCategory.categoryId=<s:property value="#pid"/>
										'>&middot;
										<s:if test="branchId==null"><strong style='color: #cc3300'>全部</strong></s:if>
										<s:else>全部</s:else>
										&nbsp;(<s:property value="category.count"/>)</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<!--2级分类开始-->
						<s:iterator value="category.childrenCategory">
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href='<s:url action="books_selectByPage" namespace="/public"/>
										?category.categoryId=<s:property value="categoryId"/>
										&category.parentCategory.categoryId=<s:property value="#pid"/>
										'>
										<s:if test="branchId==categoryId"><strong style='color: #cc3300'><s:property value="categoryName"/>&nbsp;(<s:property value="count"/>)</strong></s:if>
										<s:else>
										
										<s:property value="categoryName"/>&nbsp;(<s:property value="count"/>)
										</s:else>
										</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
						</s:iterator> 
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
						<s:if test="pageIndex >1">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href='<s:url action="books_selectByPage" namespace="/public"/>?pageIndex=<s:property value="pageIndex-1"/>
									&category.parentCategory.categoryId=<s:property value="#pid"/>
										&category.categoryId=<s:property value="branchId"/>
									'>
								<img src='../images/page_up.gif' /> </a>
							</div>
						</s:if>
						<s:else>
							<div class='list_r_title_text3a'>
								<img src='../images/page_up_gray.gif' />
							</div>
						</s:else>
							<div class='list_r_title_text3b'>
								第<s:property value="pageIndex"/></>页/共<s:property value="pageTotal"/>页
							</div>
							
						<s:if test="pageIndex<pageTotal">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href='<s:url action="books_selectByPage" namespace="/public"/>?pageIndex=<s:property value="pageIndex+1"/>
									&category.parentCategory.categoryId=<s:property value="#pid"/>
										&category.categoryId=<s:property value="branchId"/>
									'>
									<img src='../images/page_down.gif' /> </a>
							</div>
						</s:if>
						<s:else>
							<div class='list_r_title_text3a'>
								<img src='../images/page_down_gray.gif' />
							</div>
						</s:else>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
					<s:iterator value="booksList">
						<div class="list_r_line"></div>
						<div class="clear"></div>

						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='<s:url action="books_select" namespace="/public"/>
							?books.bookId=<s:property value="bookId"/>'>
								<img src='<s:property value="productImage"/>' /> </a> </span>
							<h2>
								<a name="link_prd_name" href='<s:url action="books_select" namespace="/public"/>
							?books.bookId=<s:property value="bookId"/>'><s:property value="bookName"/></a>
							</h2>
							<h3>
								顾客评分：<s:property value="customeScore"/>
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'><s:property value="author"/></a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'>xxx出版社</a>
							</h4>
							<h4>
								出版时间：2009-01-01
							</h4>
							<h5>
								这是一本好书，描述了Struts、Hibernate和Spring等框架的整合应用！
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥<s:property value="bookPrice"/></span>
								<span class="red">￥<s:property value="dangPrice"/></span>
								节省：￥<s:property value="bookPrice-dangPrice"/>
							</h6>
							<span class="list_r_list_button"> 
							<a href="#"> 
							<img src='../images/buttom_goumai.gif' /> </a>
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div>
					</s:iterator>	
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
