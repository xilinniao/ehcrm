<%@ page contentType="text/html; charset=utf-8"%>						
						<table class="listTable" id="listTable" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th nowrap>商品名称</th>
									<th nowrap>购买价格</th>
									<th nowrap>当前价格</th>
									<th nowrap>购买数量</th>
								</tr>
								<c:forEach items="${goodsList}" var="b">
								<tr>
									<td>${b.goodsName }</td>
									<td>${b.goodsPriceStr }</td>
									<td>${b.goods.discountPriceStr }</td>
									<td>${b.goodsCount }</td>
								</tr>
								</c:forEach>
						</table>
						
						<!--送货地址-->
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							<tbody>							  
							  <tr>
							    <th>客户名称</th>
								<td>${order.custInfo.custCode}</td>
								<th>客户昵称</th>
								<td>${order.custInfo.custName}</td>
							  </tr>
							  <tr>
							    <th>收货人姓名</th>
								<td>${order.revicedName}</td>
								<th>送货地址</th>
								<td>${order.revicedAddr}</td>
							  </tr>
							  <tr>
							    <th>联系电话</th>
								<td>${order.revicedMobile}</td>
								<th>电子邮件</th>
								<td>${order.revicedEmail}</td>
							  </tr>
							</tbody>
						</table>