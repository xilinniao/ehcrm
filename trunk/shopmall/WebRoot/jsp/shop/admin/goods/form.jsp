<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/shop/admin/goodsInfo.xhtml?method=onEditGoods" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="goodsId" id="goodsId" value="${info.goodsId }"/>
						<input type="hidden" name="siteCategoryId" id="id_category_id" value="${info.siteCategory.categoryId }"/>	
						<ul class="tab">
							<li><input type="button" value="基本信息" hidefocus="true" /></li>
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
								<div class="userTip">正确选择网站所属分类能够增加产品的知名度</div><label class="requireField">*</label>
								</td>
							  </tr>			  
							  <tr>
							    <th>商品名称</th>
								<td><input type="text" name="goodsName" class="formTextLL {required: true,messages: {required:'请输入商品名称'}}" id="goodsName"  value="${info.goodsName }"><label class="requireField">*</label></td>
							  </tr>
							  <tr>
							    <th>品牌</th>
								<td>
								<select name="brandId" id="brandId" class="formSelect">
									<option value="">请选择</option>
									<c:forEach items="${brandList}" var="b">
									<option value="${b.brandId }">${b.name }</option>
									</c:forEach>
								</select>
								</td>
							  </tr>
							  <tr>
							    <th>商品编号</th>
								<td><input type="text" name="goodNo" class="formText" id="goodNo"  value="${info.goodNo }"></td>
							  </tr>
							  <tr>
							    <th>商品分类</th>
								<td>								
								<select name="categoryId" id="id_shop_category" class="formSelect {required: true,messages: {required:'请选择商品分类'}}">
									<option value=""></option>
									<c:forEach items="${categoryList}" var="b">
									<option value="${b.categoryId }">${b.categoryNameFormate }</option>
									</c:forEach>
								</select>
								<label class="requireField">*</label>
								</td>
							  </tr>
							  
							  <th>是否为推荐商品</th>
								<td>
								<select name="isRecommend" id="isRecommend" class="formSelectS">
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
								<div class="userTip">推荐商品将在店铺首页推荐区域显示，建议设置为推荐商品的数量不超过8个</div>
								</td>
							  </tr>
							  
							  <tr>
							    <th>关键字</th>
								<td><input type="text" name="keyWord" class="formTextLL" id="keyWord" value="${info.keyWord }"></td>
							  </tr>
							  <tr>
							    <th>重量</th>
								<td><input type="text" name="weight" class="formTextSS {required: true,number:true,messages: {required:'请输入重量'}}" id="weight"  value="${info.weight }">&nbsp;克</td>
							  </tr>
							  <c:forEach items="${subList }" var="b" varStatus="idx">
							  <tr>
							  	<th>价格规格</th>
								<td>
								<input type="hidden" name="sub_id" value="${b.goodsSubId }">
								<!--规格：--><input type="hidden" name="goodsSubName" id="goodsSubName${idx.index }" class="formTextS {required: true}" value="${b.goodsSubName }"/>&nbsp;
								市场价：<input type="text" name="marketPrice" id="marketPrice${idx.index }" class="formTextSS {required: true,number:true,messages: {required:'请输入市场价',number:'请输入正确的市场价'}}" value="${b.marketPrice }"/>&nbsp;
								商城售价:<input type="text" name="discountPrice" id="discountPrice${idx.index }" class="formTextSS {required: true,number:true,messages: {required:'请输入商城售价',number:'请输入正确的商城售价'}}" value="${b.discountPrice }"/>&nbsp;
								<!--库存:--><input type="hidden" name="leavesCount" id="leavesCount${idx.index }" class="formTextSS {required: true,integer:true}" value="0"/>
								<c:if test="${idx.index == 0 }">
								<!--<input type="button" class="formButtonSubmit" id="btnAddNewSub" value="新增规格" hidefocus="true"/>-->
								</c:if>
								</td>
							  </tr>
							  </c:forEach>
							  </tbody>
							</table>

							
														
							<!-- 商品描述 -->
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
								<td>
								<textarea name="goodsDesc" class="wysiwyg"  style="width: 100%; height: 450px;">${info.ext.goodsDesc }</textarea></td>
							  </tr>
							  </tbody>
							</table>
							
							<!-- 相关图 -->
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
								<td>								
								<input type="file" id="upload" name="upload" />
								<input type="button" id="uploadButton" class="formButtonSubmit" value="上传图片"/>
								<span id="id_upload_ajax_tip" class="ajaxtip">图片正在上传,请稍候...</span>
								<div class="userTipTitle">上传图片格式必须为JPG,JPEG,PNG,GIF，最大上传图片大小为300K</div>
								<ul id="goods_images">
									<c:forEach items="${imageList }" var="b">
										<li>
											<input type="hidden" name="imagesId" value="${b.recId }"/><img src="${b.filePathC }">
										</li>
									</c:forEach>
								</ul>
								</td>
							  </tr>
							  </tbody>
							</table>
													
							<div class="buttonArea">
								<input type="submit" class="formButtonSubmit" id="btnSave" value="保存商品信息" hidefocus="true"/>
								<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
							</div>
						</form>