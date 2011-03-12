<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/shop/admin/goodsInfo.do?method=onEditGoods" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="goodsId" id="goodsId" value="${info.goodsId }"/>
						<input type="hidden" name="categoryId" id="id_category_id" value="${info.category.categoryId }"/>			
			<ul class="tab">
				<li>
					<input type="button" value="基本信息" hidefocus="true" />
				</li>
				<li>
					<input type="button" value="商品描述" hidefocus="true" />
				</li>
				<li>
					<input type="button" value="商品属性" hidefocus="true" />
				</li>
			</ul>
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>							  
							  <tr>
							    <th>商品名称</th>
								<td><input type="text" name="goodsName" class="formText {required: true}" id="goodsName" size="40" value="${info.goodsName }"></td>
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
							  </tbody>
							</table>
							
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
								<td>
								<textarea name="goodsDesc" class="wysiwyg"  style="width: 100%; height: 450px;">${info.goodsDesc }</textarea></td>
							  </tr>
							  </tbody>
							</table>
							
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
							    <th>商品描述</th>
								<td>
								dsd</td>
							  </tr>
							  </tbody>
							</table>
							
							<div class="buttonArea">
								<input type="button" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
								<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
							</div>
						</form>