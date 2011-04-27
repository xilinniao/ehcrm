<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/shop/admin/siteCategory.xhtml?method=onEditCategory" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="categoryId" id="categoryId"/>
						<input type="hidden" name="parentCategoryId" id="id_category_id" />
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
							    <th>上级分类</th>
								<td class="left"><input type="text" name="parentCategoryName" class="formText ro {required: true}" readonly id="id_category_name">
								<input type="button" class="formButton" id="parent_category_select" value="选择" hidefocus="true"/>
								</td>
							  </tr>
							  <tr>
							    <th>分类名称</th>
								<td><input type="text" name="categoryName" class="formText {required: true}" id="categoryName"/></td>
							  </tr>
							  <tr>
							    <th>分类URL</th>
								<td><input type="text" name="categoryUrl" id="categoryUrl" class="formText" /></td>
							  </tr>
							  <tr>
							    <th nowrap>页面关键字</th>
								<td><input type="text" name="keyWords" id="keyWords" class="formTextLL {required: true}" /></td>
							  </tr>
							  <tr>
							    <th>页面描述</th>
								<td><textarea name="categoryDesc" id="categoryDesc" style="width:450px;height:100px;"></textarea></td>
							  </tr>
							  <tr>
							    <th>排序号</th>
								<td><input type="text" name="orderNum" class="formText {required: true}" id="orderNum"></td>
							  </tr>
							  </tbody>
							</table>
							<div class="buttonArea">
								<input type="button" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
								<input type="button" class="formButtonSubmit" id="btnDelete" value="删除" hidefocus="true"/>
							</div>
						</form>