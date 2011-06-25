<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/shop/admin/goodsCategory.xhtml?method=onEditGoodscat" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="categoryId" id="categoryId"/>
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
							    <th>上级分类</th>
								<td>
								<select name="parentGoodscatId" id="id_category_id" class="formSelect">
									<c:forEach items="${categoryList }" var="b">
									<option value="${b.categoryId }">${b.categoryName }</option>
									</c:forEach>
								</select><label class="requireField">*</label>					
								</td>
							  </tr>
							  <tr>
							    <th>分类名称</th>
								<td>
								<input type="text" name="categoryName" class="formText {required: true}" id="categoryName" >
								<label class="requireField">*</label></td>
							  </tr>
							  <tr>
							    <th>分类关键字</th>
								<td><input type="text" name="keyWords" class="formTextL {required: true}" id="keyWords" >
								<label class="requireField">*</label>
								<div class="userTip">分类关键字能更好的推广您的商品，请认真填写该项内容,多个关键字用空格分开</div></td>
							  </tr>
							  <tr>
							    <th>分类描述</th>
								<td><input type="text" name="categoryDesc" class="formTextL {required: true}" id="categoryDesc" >
								<label class="requireField">*</label>
								<div class="userTip">描述能更好的推广您的商品，请认真填写该项内容</div></td>
							  </tr>
							  <tr>
							    <th>排序号</th>
								<td>
								<input type="text" name="orderNum" class="formTextSS {required: true,positiveInteger:true}" id="orderNum" ><label class="requireField">*</label>
								<div class="userTip">请填入数字，按数字从小到大进行排序</div>								
								</td>
							  </tr>
							  </tbody>
							</table>
							<div class="buttonArea">
								<input type="button" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
								<input type="button" class="formButtonSubmit" id="btnDelete" value="删除" hidefocus="true"/>
							</div>
						</form>