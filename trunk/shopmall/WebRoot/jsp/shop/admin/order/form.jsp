<%@ page contentType="text/html; charset=utf-8"%>
			<form action="<%=path%>/shop/admin/goodsInfo.do?method=onEditGoods" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="goodsId" id="goodsId" value="${info.goodsId }"/>
						<input type="hidden" name="categoryId" id="id_category_id" value="${info.category.categoryId }"/>			
			<ul class="tab">
				<li>
					<input type="button" value="订单基本信息" hidefocus="true" />
				</li>
				<li>
					<input type="button" value="商品列表" hidefocus="true" />
				</li>
				<li>
					<input type="button" value="处理结果" hidefocus="true" />
				</li>
			</ul>
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>							  
							  <tr>
							    <th>客户名称:</th>
								<td>${order.orderNo}</td>
							  </tr>
							  <tr>
							    <th>收货人姓名:</th>
								<td>${order.revicedName }</td>
							  </tr>
							  <tr>
							    <th>送货地址：</th>
								<td>${order.revicedAddr }</td>
							  </tr>
							  <tr>
							    <th>手机号码：</th>
								<td>${order.revicedMobile }</td>
							  </tr>
							  <tr>
							    <th>固定电话：</th>
								<td>${order.revicedTel }</td>
							  </tr>
							  <tr>
							    <th>电子邮件：</th>
								<td>${order.revicedEmail }</td>
							  </tr>					  				
							  <tr>
							    <th>客户备注：</th>
								<td>${order.orderRemark }</td>
							  </tr>
							  </tbody>
							</table>
							
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
							  	<td>商品编号</td>
					            <td>商品名称</td>
								<td>市场价</td>
					            <td>商城价</td>
					            <td>赠送积分</td>
					            <td>库存状态</td>
					            <td>购买数量</td>
							  </tr>
							  <c:forEach items="${goodsList}" var="b">
							  <tr>
							  	<td>${b.goods. }</td>
							  	<td>${b.goods. }</td>
							  	<td>${b.goods. }</td>
							  	<td>${b.goods. }</td>
							  	<td>${b.goods. }</td>
							  	<td>${b.goods. }</td>
							  	<td>${b.goodsCount }</td>
							  </tr>
							  </c:forEach>
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