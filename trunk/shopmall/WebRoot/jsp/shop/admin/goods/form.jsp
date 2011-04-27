<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/shop/admin/goodsInfo.xhtml?method=onEditGoods" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="goodsId" id="goodsId" value="${info.goodsId }"/>
						<input type="hidden" name="categoryId" id="id_category_id" value="${info.category.categoryId }"/>	
						<input type="hidden" name="siteCategoryId" id="id_siteCategoryId" value="${info.siteCategory.categoryId }"/>	
						<ul class="tab">
							<li><input type="button" value="基本信息" hidefocus="true" /></li>
							<li><input type="button" value="规格价格" hidefocus="true" /></li>
							<li><input type="button" value="商品描述" hidefocus="true" /></li>
							<li><input type="button" value="相关图片" hidefocus="true" /></li>
						</ul>
			
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
							    <th>所属网站分类</th>
								<td>
								<input type="text" name="categoryName" class="formText ro {required: true}" readonly id="id_category_name"  value="${info.category.categoryName }">					
								<input type="button" class="formButton" id="site_category_select" value="选择" hidefocus="true"/>
								</td>
							  </tr>						  
							  <tr>
							    <th>商品名称</th>
								<td><input type="text" name="goodsName" class="formTextLL {required: true}" id="goodsName"  value="${info.goodsName }"></td>
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
								<td><input type="text" name="goodNo" class="formText {required: true}" id="goodNo"  value="${info.goodNo }"></td>
							  </tr>
							  <tr>
							    <th>所属分类</th>
								<td>								
								<select name="categoryId" id="id_category_id">
									<option value="">请选择</option>
									<c:forEach items="${categoryList}" var="b">
									<option value="${b.categoryId }">${b.categoryName }</option>
									</c:forEach>
								</select>
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
								<td><input type="text" name="keyWord" class="formText {required: true}" id="keyWord" value="${info.keyWord }"></td>
							  </tr>
							  <tr>
							    <th>重量</th>
								<td><input type="text" name="weight" class="formTextSS {required: true}" id="weight"  value="${info.weight }">&nbsp;千克</td>
							  </tr>
							  <tr>
							    <th>库存</th>
								<td><input type="text" name="leavesCount" class="formTextSS {required: true}" id="leavesCount" value="${info.leavesCount }">&nbsp;件</td>
							  </tr>
							  <tr>
							  </tbody>
							</table>

							<!-- 价格规格 -->
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <c:forEach items="${subList }" var="b">
							  <tr>
								<td>规格：<input type="text" name="goodsSubName" class="formTextS {required: true}" value="${b.goodsSubName }">&nbsp;
								市场价：<input type="text" name="marketPrice" class="formTextSS {required: true}" value="${b.marketPrice }">&nbsp;
								商城售价:<input type="text" name="discountPrice" class="formTextSS {required: true}" value="${b.discountPrice }">
								<input type="button" class="formButtonSubmit" id="btnAddNewPrice" value="新增规格" hidefocus="true"/></td>
							  </tr>
							  </c:forEach>
							  </tbody>
							</table>
														
							<!-- 商品描述 -->
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
								<td>
								<textarea name="goodsDesc" class="wysiwyg"  style="width: 100%; height: 450px;">${info.goodsDesc }</textarea></td>
							  </tr>
							  </tbody>
							</table>
							
							<!-- 相关图排尿 -->
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
								<td></td>
							  </tr>
							  </tbody>
							</table>
													
							<div class="buttonArea">
								<input type="button" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
								<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
							</div>
						</form>