<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/shop/admin/goodsInfo.xhtml?method=onEditGoods" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="goodsId" id="goodsId" value="${info.goodsId }"/>
						<input type="hidden" name="categoryId" id="id_category_id" value="${info.category.categoryId }"/>			
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>							  
							  <tr>
							    <th>商品名称</th>
								<td><input type="text" name="goodsName" class="formText {required: true}" id="goodsName" size="40" value="${info.goodsName }"></td>
							  </tr>
							  <tr>
							    <th>品牌</th>
								<td>
								<select name="brandId" id="brandId">
									<option value="">请选择</option>
									<c:forEach items="${brandList}" var="b">
									<option value="${b.brandId }">${b.name }</option>
									</c:forEach>
								</select>
								</td>
							  </tr>
							  <tr>
							    <th>商品编号</th>
								<td><input type="text" name="goodNo" class="formText {required: true}" id="goodNo" size="40" value="${info.goodNo }"></td>
							  </tr>
							  <tr>
							    <th>所属分类</th>
								<td><input type="text" name="categoryName" class="formText ro {required: true}" readonly id="id_category_name" size="40" value="${info.category.categoryName }">								
								<input type="button" class="formButton" id="parent_category_select" value="选择" hidefocus="true"/>
								</td>
							  </tr>
							   <tr>
							    <th>在首页显示位置</th>
								<td>
								<select name="pageCategoryId" id="pageCategoryId">
									<option value="">请选择</option>
									<c:forEach items="${pageCategoryList}" var="b">
									<option value="${b.categoryId }">${b.categoryName }</option>
									</c:forEach>
								</select>
								</td>
							  </tr>
							  <tr>
							    <th>关键字</th>
								<td><input type="text" name="keyWord" class="formText {required: true}" id="keyWord" size="40" value="${info.keyWord }"></td>
							  </tr>
							  <tr>
							    <th>原价</th>
								<td><input type="text" name="originalPrice" class="formText {required: true}" id="originalPrice" size="40" value="${info.originalPrice }"></td>
							  </tr>
							  <tr>
							    <th>商城售价</th>
								<td><input type="text" name="discountPrice" class="formText {required: true}" id="discountPrice" size="40" value="${info.discountPrice }"></td>
							  </tr>
							  <tr>
							    <th>重量</th>
								<td><input type="text" name="weight" class="formText {required: true}" id="weight" size="40" value="${info.weight }"></td>
							  </tr>
							  <tr>
							    <th>库存</th>
								<td><input type="text" name="leavesCount" class="formText {required: true}" id="leavesCount" size="40" value="${info.leavesCount }"></td>
							  </tr>
							  <tr>
							  <tr>
							    <th>商品描述</th>
								<td>
								<textarea name="goodsDesc" class="wysiwyg"  style="width: 90%; height: 350px;">${info.goodsDesc }</textarea></td>
							  </tr>
							  </tbody>
							</table>							
							<div class="buttonArea">
								<input type="button" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
								<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
							</div>
						</form>