<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/shop/admin/goodsInfo.xhtml?method=onEditGoods" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="goodsId" id="goodsId" value="${info.goodsId }"/>
						<input type="hidden" name="siteCategoryId" id="id_category_id" value="${info.siteCategory.categoryId }"/>	
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
								<input type="text" name="categoryName" class="formTextL ro {required: true}" readonly id="id_category_name"  value="${info.siteCategory.categoryName }">					
								<input type="button" class="formButton" id="site_category_select" value="选择" hidefocus="true"/>
								<div class="userTip">正确选择网站所属分类能够增加产品的知名度</div>
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
								<select name="categoryId" id="id_shop_category" class="{required: true}">
									<option value="">请选择</option>
									<c:forEach items="${categoryList}" var="b">
									<option value="${b.categoryId }">${b.categoryNameFormate }</option>
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
							  </tbody>
							</table>

							<!-- 价格规格 -->
							<table border="0" cellspacing="0" cellpadding="0" id="goods_sub" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <c:forEach items="${subList }" var="b" varStatus="idx">
							  <tr>
								<td>
								<input type="hidden" name="sub_id" value="${b.goodsSubId }">
								规格：<input type="text" name="goodsSubName" id="goodsSubName${idx.index }" class="formTextS {required: true}" value="${b.goodsSubName }"/>&nbsp;
								市场价：<input type="text" name="marketPrice" id="marketPrice${idx.index }" class="formTextSS {required: true,number:true}" value="${b.marketPrice }"/>&nbsp;
								商城售价:<input type="text" name="discountPrice" id="discountPrice${idx.index }" class="formTextSS {required: true,number:true}" value="${b.discountPrice }"/>&nbsp;
								库存:<input type="text" name="leavesCount" id="leavesCount${idx.index }" class="formTextSS {required: true,integer:true}" value="${b.leavesCount }"/>
								<c:if test="${idx.index == 0 }">
								<input type="button" class="formButtonSubmit" id="btnAddNewSub" value="新增规格" hidefocus="true"/></td>
								</c:if>
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
							
							<!-- 相关图 -->
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
								<td>
								<input type="file" id="upload" name="upload" />
								<input type="button" id="uploadButton" class="formButtonSubmit" value="上传"/>
								<ul id="goods_images">
									<c:forEach items="${imageList }" var="b">
										<li>
											<input type="hidden" name="good_attach_id">
											<input type="hidden" name="imagesId" value="${b.recId }"/><img src="${b.fileLoaction }_s.${b.fileExtension }">
										</li>
									</c:forEach>
								</ul>
								</td>
							  </tr>
							  </tbody>
							</table>
													
							<div class="buttonArea">
								<input type="submit" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
								<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
							</div>
						</form>