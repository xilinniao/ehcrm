<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<%@include file="/common/meta.jsp"%>
    <title><%=projName %></title>
	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready( function() {

	});
	</script>
  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>编辑店铺信息</h1>
	</div>
	<form id="validateForm" action="shopInfo.xhtml?method=onEditShop" method="post">
	<table class="inputTable tabContent" style="display: table;">
				<tbody>
				<tr>
					<th>
						 店铺名称
					</th>
					<td>
						<input type="text" name="shopName" id="shopName" class="formTextL {required: true}" value="${shop.shopName}" >
						<label class="requireField">*</label>
					</td>
				</tr>				
				<tr>
					<th>
						 身份证
					</th>
					<td>
						<input type="text" name="idNo" id="idNo" class="formTextL {required: true}" value="${shop.idNo}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 地址
					</th>
					<td>
						<input type="text" name="shopAddr" id="shopAddr" class="formTextLL {required: true}" value="${shop.shopAddr}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 联系人
					</th>
					<td>
						<input type="text" name="linkerMan" id="linkerMan" class="formText {required: true}" value="${shop.linkerMan}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 手机
					</th>
					<td>
						<input type="text" name="linkerMobile" id="linkerMobile" class="formText {required: true}" value="${shop.linkerMobile}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 固定电话
					</th>
					<td>
						<input type="text" name="linkTel" id="linkTel" class="formText" value="${shop.linkTel}">
					</td>
				</tr>
				<tr>
					<th>
						 电子邮件
					</th>
					<td>
						<input type="text" name="email" id="email" class="formText" value="${shop.email}">
					</td>
				</tr>
				<tr>
					<th>
						 店铺公告：
					</th>
					<td>
						<textarea name="pubNote" class="formTextarea" id="pubNote" style="width: 500px; height: 100px;">${shop.pubNote }</textarea>
						<div class="userTip">改内容会在店铺首页滚动显示</div>
					</td>
				</tr>
				<tr>
					<th>
						 店铺关键字
					</th>
					<td>
					<input type="text" name="keyword" id="keyword" class="formTextLL {required: true}" value="${shop.keyword}"><label class="requireField">*</label>
					<div class="userTip">店铺关键字能更好的推广您的网站，请认真填写该项内容,多个关键字用空格分开</div>
					</td>
				</tr>				
				<tr>
					<th>
						 店铺描述
					</th>
					<td>
					<textarea name="shopDesc" class="formTextarea" id="shopDesc" style="width: 500px; height: 100px;">${shop.shopDesc }</textarea>
					<div class="userTip">店铺描述能更好的推广您的网站，请认真填写该项内容</div>
					</td>
				</tr>		
			</tbody></table>
			<div class="buttonArea">
				<input type="submit" class="formButton" value="确  定" hidefocus="true" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
			</div>
			</form>
  </body>
</html>