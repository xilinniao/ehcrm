<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/shop/admin/goodscat.xhtml?method=onEditGoodscat" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="categoryId" id="categoryId"/>
						<input type="hidden" name="parentGoodscatId" id="id_category_id" />
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
								<td><input type="text" name="categoryName" class="formText {required: true}" id="categoryName" size="40"></td>
							  </tr>
							  <tr>
							    <th>页面关键字</th>
								<td><input type="text" name="keyWords" class="formText {required: true}" id="keyWords" size="40"></td>
							  </tr>
							  <tr>
							    <th>页面描述</th>
								<td><input type="text" name="categoryDesc" class="formText {required: true}" id="categoryDesc" size="40"></td>
							  </tr>
							  <tr>
							    <th>排序号</th>
								<td><input type="text" name="orderNum" class="formText {required: true}" id="orderNum" size="40"></td>
							  </tr>
							  </tbody>
							</table>
							<div class="buttonArea">
								<input type="button" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
								<input type="button" class="formButtonSubmit" id="btnDelete" value="删除" hidefocus="true"/>
							</div>
						</form>