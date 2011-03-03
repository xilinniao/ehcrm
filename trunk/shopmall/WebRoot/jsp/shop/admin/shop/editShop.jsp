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
	
  </head>
  <body  class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>编辑店铺信息</h1>
	</div>
	
	<form id="inputForm" class="validate" action="" method="post">
	<table class="inputTable tabContent" style="display: table;">
				<tbody>
				<tr>
					<th>
						 店铺名称
					</th>
					<td>
						<input type="text" name="shopName" id="shopName" class="formText {required: true}" value="${shop.shopName}" >
						<label class="requireField">*</label>
					</td>
				</tr>				
				<tr>
					<th>
						 身份证
					</th>
					<td>
						<input type="text" name="idNo" id="idNo" class="formText {required: true}" value="${shop.idNo}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 地址
					</th>
					<td>
						<input type="text" name="shopAddr" id="shopAddr" class="formText {required: true}" value="${shop.shopAddr}">
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
						<input type="text" name="linkTel" id="linkTel" class="formText {required: true}" value="${shop.linkTel}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 电子邮件
					</th>
					<td>
						<input type="text" name="email" id="email" class="formText {required: true}" value="${shop.email}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 店标
					</th>
					<td>
						<input type="text" name="imgLogo" id="imgLogo" class="formText {required: true}" value="${shop.imgLogo}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 店铺条幅
					</th>
					<td>
						<input type="text" name="imgoAd" id="imgoAd" class="formText {required: true}" value="${shop.imgoAd}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 店铺描述
					</th>
					<td>
						<input type="text" name="shopDesc" id="shopDesc" class="formText {required: true}" value="${shop.shopDesc}">
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr>
					<th>
						 成立时间
					</th>
					<td>
						<input type="text" name="foundDate" id="foundDate" class="formText {required: true}" value="${shop.foundDate}">
						<label class="requireField">*</label>
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