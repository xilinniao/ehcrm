<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/resources/admin/css/list.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
    <script type="text/javascript">
	<!--
	var saveform_validator;
	$(document).ready(function(){
		//加载验证框架
		saveform_validator = $("form.validate").validate({
			errorClass: "validateError",
			ignore: ".ignoreValidate",
			errorPlacement:defaultErrorPlacement,
			submitHandler:defaultSubmitHandler			
		});
    	
    	$('#btnSave').click(function(){
    		//验证输入数据
    		if (saveform_validator.form()) {
    			$('#saveform').submit();
			}
    	});
    	
    	if($('#note').val()==''){
    		$('#note').val('店主已接受你的订单，感谢您的订购！');
    	}
	});
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>订单管理-&gt;接收订单<span class="right">(订单编号：${order.orderNo})</span></h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">			
				<form action="<%=path%>/shop/admin/orders.xhtml?method=onCheck" class="validate" id="saveform" name="saveform" method="post">
						<input type="hidden" name="orderId" id="orderId" value="${order.orderId }"/>
						<input type="hidden" name="qryHex" id="qryHex" value="${qryHex }"/>
						
						<%@include file="/jsp/shop/admin/order/baseinfo.jsp"%>
						
						<!--备注-->
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							<tbody>							  
							  <tr>
							    <th>备注</th>
								<td>
								<textarea name="note" class="formTextarea {required: true,messages: {required:'请输入备注'}}" id="note" style="width:500px;height:50px;">${entity.note}</textarea>
								<div class="userTip">客户可以查看到该备注</div>
								</td>
							  </tr>							  
							</tbody>
						</table>
						
						<div class="buttonArea">
							<input type="button" class="formButtonSubmit" id="btnSave" value="接收该订单" hidefocus="true"/>
							<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
						</div>
					</form>
						
    	</div>
    </div>
  </body>
</html>