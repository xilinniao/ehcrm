<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.tools.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path %>/resources/front/js/jquery.metadata.js"></script>
<script type="text/javascript" src="<%=path %>/resources/front/js/jquery.validate.js"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>
<script type="text/javascript">
	var addr_list_json = ${addr_json};
	function selectAddr(id_li){
		$('ul#addr_list li').removeClass("xz");
		var select_addr_id = $('#'+id_li).addClass("xz").find("input:radio").attr("checked","true").val();		
		$.each(addr_list_json,function(i, item){
			if(select_addr_id==item.addrId){
				$('#revicedName').val(item.revicedName);
				$('#revicedAddr').val(item.revicedAddr);
				$('#revicedMobile').val(item.revicedMobile);
				$('#revicedTel').val(item.revicedTel);
				$('#revicedEmail').val(item.revicedEmail);
			}
		});
	}
	jQuery(document).ready(function() {
		//第一个li设置成check状态
		var fisrt_li_id = $("ul#addr_list li:first").attr("id");		
		selectAddr(fisrt_li_id);
		
		//初始化
		var  saveform_validator = $("#checkoutform").validate({
			 errorClass: "validateError",
            ignore: ".ignoreValidate",
            errorPlacement: function(error, element) {
                var messagePosition = element.metadata().messagePosition;
                if("undefined" != typeof messagePosition && messagePosition != "") {
                    var $messagePosition = $(messagePosition);
                    if ($messagePosition.size() > 0) {
                        error.insertAfter($messagePosition).fadeOut(300).fadeIn(300);
                    } else {
                        error.insertAfter(element).fadeOut(300).fadeIn(300);
                    }
                } else {
                    error.insertAfter(element).fadeOut(300).fadeIn(300);
                }
            },
            submitHandler: function(form) {
                $(form).find(":submit").attr("disabled", true);
                form.submit();
            }
		});
	});	
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/toptop.jsp"%>

<!-- 正文开始 -->
<div class="w main">

	<div id="Top1_order_step2" class="Header_cart">
		<div id="logo">
			<a href="<%=homeUrl %>">
				<img src="<%=path %>/resources/front/images/logo.gif" alt="抚州商城" width="251" height="46">
			</a>
		</div>
		<ul class="Order_cart" id="Order_cart_S2">
			<li class="step1">1.我的购物车</li>
			<li class="step2">2.填写核对订单信息</li>
			<li class="step3">3.成功提交订单</li>
		</ul>
	</div>

	<div class="List_cart">
		<h2><strong>填写核对订单信息</strong></h2>
		<div class="cart_table">
			<form id="checkoutform" method="POST" action="<%=path %>/front/order.xhtml?method=oncheckout">
			<input type="hidden" name="shopId" value="1" >
			<input type="hidden" name="uses_score" value="1000" >
			
			<div id="part_cart">
				<div class="o_show">
				   <h1><span style="margin-right:700px;">商品清单</span><a id="backToCartBtn" href="<%=path %>/front/order.xhtml?method=shoppingcart" style="color:#0070D7">返回修改购物车</a></h1>
				   <div class="middle">
				       <table class="Table" cellpadding="0" cellspacing="0" width="100%">
				         <tbody><tr class="align_Center Thead">
				            <td width="7%">商品编号</td>
				            <td>商品名称</td>
				            <td width="10%">商城价</td>
				            <td width="8%">赠送积分</td>
				            <td width="9%">库存状态</td>
				            <td width="9%">购买数量</td>
				         </tr>
				        		        
						<c:forEach items="${productList}" var="b">
						<tr class="align_Center">
						   <td style="padding:5px 0 5px 0;">
						   ${b.goodsId }
						   <input type="hidden" name="productId" value="${b.goodsId }"/>
						   <input type="hidden" name="cnt" value="${b.cnt }"/>
						   </td>
						   <td class="align_Left">
						   <a target="_blank" href="<%=path %>/product/detail/${b.goodsId }.html" onclick="this.blur();">${b.goodsName }</a></td>
						   <td><span class="price">￥${b.discountPrice }</span></td>
						   <td>0</td>
						   <td>现货</td>
						   <td>${b.cnt }</td>
						</tr>
						</c:forEach>
				     </tbody></table>
				   </div>
				   <div class="footer"></div>
				</div>				
			</div><!-- end of part_cart -->
			
			<div id="part_consignee">
				<div class="o_show">
					<h1>收货人信息&nbsp;<a id="lbtnConsigneeWrite" href="javascript:void(0)" onclick="showForm_consignee(this)">[修改]</a></h1>					
					<div class="middle">					
						<div class="cydz">
							<b>选择常用地址</b>
							<ul id="addr_list">
								<c:forEach items="${addrList}" var="b" varStatus="status">
								<li id="addrIi${b.addrId }" class="xz">
									<table cellspacing="0" cellpadding="0" border="0" style="width:98%"><tbody>
									<tr>
										<td style="width:20px;">
											<input id="addr_1973799" type="radio" name="rbtnAddr" onclick="selectAddr('addrIi${b.addrId }');" value="${b.addrId }">
										</td>
										<td><label for="addr_1973799"><strong>${b.revicedName }</strong>&nbsp;${b.revicedAddr }</label></td>
										<td style="width:40px"> <a href="#none" class="remark" onclick="selectAddr('addrIi${b.addrId }');">[选用]</a> </td>
									</tr></tbody></table>
								</li>
								</c:forEach>
							</ul>
						</div>
						
						<table>
						<tbody><tr>
							<td style="width:80px;" align="right">收货人姓名：</td>
							<td><input type="text" name="revicedName" id="revicedName" class="text {required: true}" size="40"/></td>
						</tr>						
						<tr>
							<td align="right">送货地址：</td>
							<td><input type="text" name="revicedAddr" id="revicedAddr" class="text {required: true}" size="40"/></td>
						</tr>						
						<tr>
							<td align="right">手机号码：</td>
							<td><input type="text" name="revicedMobile" id="revicedMobile" class="text {required: true}" size="40"/></td>
						</tr>						
						<tr>
							<td align="right">固定电话：</td>
							<td><input type="text" name="revicedTel" id="revicedTel" class="text {required: true}" size="40"/></td>
						</tr>						
						<tr>
							<td align="right">电子邮件：</td>
							<td><input type="text" name="revicedEmail" id="revicedEmail" class="text {required: true}" size="40"/></td>
						</tr>				
						</tbody></table>
					</div><!-- end of middle-->
					<!-- 
					<div class="footer">
					    <input type="button" class="btn" value="添加到常用地址" onclick="savePart_consignee(this)">
					</div>
					 -->
				</div><!-- end of o_show-->
			</div><!-- part_consignee-->
			
			<div id="ware_info">                  
                  <div style="background:#fff;font-size:14px;font-weight:bold;padding-left:2px;">结算信息</div>
                  <h1></h1>
                  <div class="middle">
                    <!--订单信息-->
                    <ul id="part_info">
						<li class="info1" style="padding-bottom:5px">
						    商品金额：3585.00元 + 运费：0.00元 - 优惠券：<span id="price_coupon">0.00</span>元 - 礼品卡：<span id="price_coupon">0.00</span>元 - 返现：0.00元
						<br>
						</li>

						<li class="info2" style="width:100%;overflow:hidden;">
						     <table style="width:100%" cellpadding="0" cellspacing="0">
						        <tbody><tr>
						           
						          <td style="text-align:right;font-size:15px;"><b>应付总额：<font color="red">￥3,585.00</font> 元</b>
						          </td>
						       </tr>
						     </tbody></table>
						</li>
                    </ul>
                    <div style="clear:both"></div>                     
                  </div>
            </div><!-- end of ware_info -->
            
            <div class="o_show submit"> 
                     <div><span id="submitWaitInfo"></span></div>
                    <div id="submit_error"></div>
                    <div id="submit_btn">                      
                      <span id="ccPanel"></span>
                      <input id="submit" type="submit" class="btn_submit" value="" > 
                    </div>
            </div><!-- end of o_show submit -->
			</form>
		</div><!-- end of cart_table -->
		<div class="round"><div class="lround"></div><div class="rround"></div></div>
	</div><!-- end of list_cart-->
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>