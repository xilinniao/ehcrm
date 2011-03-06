<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<%@include file="/common/meta.jsp"%>
    <title><%=projName %></title>
	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/resources/admin/css/datatables.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready( function() {
		 $('#example').dataTable({
 			"sPaginationType": "full_numbers", 	
 			"oLanguage":oLanguage_cn,		
			"bInfo": false
		 });
	});
	</script>
  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>编辑店铺信息</h1>
	</div>
	
	
<table class="display stylized" id="example">

						<thead>

							<tr>

					<th class="check">

						<input type="checkbox" class="allCheck" />

					</th>

					<th>

						<span class="sort" name="name">商品名称</span>

					</th>

					<th>

						<span class="sort" name="productSn">货号</span>

					</th>

					<th>

						<span class="sort" name="productCategory">分类</span>

					</th>

					<th>

						<span class="sort" name="price">本店价格</span>

					</th>

					<th>

						<span class="sort" name="isMarketable">上架</span>

					</th>

					<th>

						<span class="sort" name="isBest">精品</span>

					</th>

					<th>

						<span class="sort" name="isNew">新品</span>

					</th>

					<th>

						<span class="sort" name="isHot">热销</span>

					</th>

					<th>

						<span class="sort" name="store">库存</span>

					</th>

					<th>

						操作

					</th>

				</tr>

						</thead>

						<tbody>

							

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881862bee2228012bee40a24d0008" />

						</td>

						<td>

								<span title="韩版新秋装 男童装 热卖 牛仔裤">韩版新秋装 男童装 热卖 牛仔裤</span>

						</td>

						<td>

							SN_45890F82AEBC

						</td>

						<td>

							童装

						</td>

						<td>

							￥65.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881862bee2228012bee40a24d0008" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/6c838d1223ce426d992b264ffebb5010.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bbdfe19012bbe1472430003" />

						</td>

						<td>

								<span title="保暖内拉绒 男士家居服套装 长袖长裤 睡衣套装 晨练装">保暖内拉绒 男士家居服套装 长袖长裤 睡衣...</span>

						</td>

						<td>

							SN_9858E06A64DC

						</td>

						<td>

							睡衣

						</td>

						<td>

							￥68.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 1">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bbdfe19012bbe1472430003" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/fdf9304db1684e59af51aa46ffbf9af5.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bbdfe19012bbe0f12880002" />

						</td>

						<td>

								<span title="竹纤维男式内裤 平角内裤 透气抗菌">竹纤维男式内裤 平角内裤 透气抗菌</span>

						</td>

						<td>

							SN_11A3ABE3C1F8

						</td>

						<td>

							内裤

						</td>

						<td>

							￥36.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 2">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bbdfe19012bbe0f12880002" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/d1692a20d3e0414dbfca30e4088941f2.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bbdfe19012bbe080cdd0001" />

						</td>

						<td>

								<span title="正品南极人 羊毛暖护贴护膝 男士保暖内衣套装！NX9021">正品南极人 羊毛暖护贴护膝 男士保暖内衣套...</span>

						</td>

						<td>

							SN_DA3754B17808

						</td>

						<td>

							内衣

						</td>

						<td>

							￥188.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 2">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bbdfe19012bbe080cdd0001" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/62f2fadcefdd40bd88e73620a48d8b77.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bbcd2f4012bbd826374000e" />

						</td>

						<td>

								<span title="欧蒂爱 竹炭纤维运动男袜 防臭 保护脚踝 防扭伤 秋冬厚款">欧蒂爱 竹炭纤维运动男袜 防臭 保护脚踝 ...</span>

						</td>

						<td>

							SN_92C8BF4146A3

						</td>

						<td>

							袜类

						</td>

						<td>

							￥8.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 1">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bbcd2f4012bbd826374000e" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/c71b9d0e0e1643f089dda97fa6442ac6.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bbcd2f4012bbd7d0e48000c" />

						</td>

						<td>

								<span title="新款 韩版西裤 休闲西裤 修身西裤 男装西裤">新款 韩版西裤 休闲西裤 修身西裤 男装西...</span>

						</td>

						<td>

							SN_0A79E9F1E619

						</td>

						<td>

							西裤

						</td>

						<td>

							￥158.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 1">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bbcd2f4012bbd7d0e48000c" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/37a29387674e471d93a434d3309ee9ed.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bbcd2f4012bbd7840ba000a" />

						</td>

						<td>

								<span title="2010秋装款play川久保玲潮牌直筒 时尚休闲牛仔裤">2010秋装款play川久保玲潮牌直筒 时...</span>

						</td>

						<td>

							SN_5B85C0BFCF97

						</td>

						<td>

							牛仔裤

						</td>

						<td>

							￥95.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 2">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bbcd2f4012bbd7840ba000a" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/e21cd4464c854db3bd2355b9c31d565b.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bbcd2f4012bbd6dae2f0008" />

						</td>

						<td>

								<span title="2010秋季韩版热卖新款酷感个性帅气格纹长袖翻领修身休闲女衬衫">2010秋季韩版热卖新款酷感个性帅气格纹长...</span>

						</td>

						<td>

							SN_6DE9971C46A7

						</td>

						<td>

							衬衫

						</td>

						<td>

							￥35.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bbcd2f4012bbd6dae2f0008" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/a57b6df1e1454bc0872d29c5d983dcf3.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bbcd2f4012bbd689a710007" />

						</td>

						<td>

								<span title="巴黎街头 秋装新款 超赞细节 极具质感 厚质型格时装裤">巴黎街头 秋装新款 超赞细节 极具质感 厚...</span>

						</td>

						<td>

							SN_5E3A0529E1D3

						</td>

						<td>

							时装裤

						</td>

						<td>

							￥189.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bbcd2f4012bbd689a710007" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/2fb8d7ff55b64525809779394697556a.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bbcd2f4012bbd63d1480005" />

						</td>

						<td>

								<span title="2010秋冬新款韩版毛呢/花苞/半身裙/短裙/毛呢裙">2010秋冬新款韩版毛呢/花苞/半身裙/短...</span>

						</td>

						<td>

							SN_13F2395C7875

						</td>

						<td>

							短裙

						</td>

						<td>

							￥78.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bbcd2f4012bbd63d1480005" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/8823782b7578485bafd3399f9c3b02d6.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882bb2c00c012bb3a47a950011" />

						</td>

						<td>

								<span title="2010秋季新款 kappa靠背 女 运动套装 开衫长袖 运动服">2010秋季新款 kappa靠背 女 运动...</span>

						</td>

						<td>

							SN_1BA426043294

						</td>

						<td>

							运动套装

						</td>

						<td>

							￥245.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 2">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882bb2c00c012bb3a47a950011" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/975fcae6a1ab42ef98e4a9c8072d13f2.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882badb4ed012baeece5b6004d" />

						</td>

						<td>

								<span title="韩版可爱甜美双排扣短外套">韩版可爱甜美双排扣短外套</span>

						</td>

						<td>

							SN_0B6B1CD446F7

						</td>

						<td>

							风衣

						</td>

						<td>

							￥138.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882badb4ed012baeece5b6004d" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/d6133758f03e4c119c368b47aff4b2a1.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882badb4ed012baee78acd004c" />

						</td>

						<td>

								<span title="新款小礼服连衣裙公主小礼服晚装礼服">新款小礼服连衣裙公主小礼服晚装礼服</span>

						</td>

						<td>

							SN_5938359D366A

						</td>

						<td>

							连衣裙

						</td>

						<td>

							￥138.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 2">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882badb4ed012baee78acd004c" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/3ba4738e316d4ad3a74fd3183b74fa1f.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882badb4ed012baee0c141004b" />

						</td>

						<td>

								<span title="羊毛竹炭黄金绒南极人女士 保暖 内衣套装加厚NY9068">羊毛竹炭黄金绒南极人女士 保暖 内衣套装加...</span>

						</td>

						<td>

							SN_D2155CC2A32C

						</td>

						<td>

							内衣

						</td>

						<td>

							￥228.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882badb4ed012baee0c141004b" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/b6b3158e252c439fbc557189d04bfe93.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882badb4ed012baedb8c5e004a" />

						</td>

						<td>

								<span title="紧身提臀女牛仔小脚裤 显瘦女小腿裤铅笔裤 蓝色黑色女牛仔裤">紧身提臀女牛仔小脚裤 显瘦女小腿裤铅笔裤 ...</span>

						</td>

						<td>

							SN_38F84312F1EB

						</td>

						<td>

							牛仔裤

						</td>

						<td>

							￥76.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882badb4ed012baedb8c5e004a" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/83372e892b524299bd318ab528c4bfc3.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882badb4ed012baed755b10049" />

						</td>

						<td>

								<span title="七匹狼 男士 皮带 男 正品 男士腰带 真皮 自动扣 时尚精品">七匹狼 男士 皮带 男 正品 男士腰带 真...</span>

						</td>

						<td>

							SN_AF73CABEFA61

						</td>

						<td>

							精美配饰

						</td>

						<td>

							￥59.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882badb4ed012baed755b10049" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/bf555983d1cf4b1fbb1fb55e82dccabe.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882badb4ed012baed16d5d0048" />

						</td>

						<td>

								<span title="女士钱包可爱/卡通/时尚韩版长款女式钱夹">女士钱包可爱/卡通/时尚韩版长款女式钱夹</span>

						</td>

						<td>

							SN_D0EA2489EFB2

						</td>

						<td>

							钱包

						</td>

						<td>

							￥78.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 1">99</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882badb4ed012baed16d5d0048" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/076dc53d2514416dafd189c6a5ac3b61.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882badb4ed012baebc0d220045" />

						</td>

						<td>

								<span title="歌瑞尔品牌女士内裤新品 永恒之塔 时尚个性内裤">歌瑞尔品牌女士内裤新品 永恒之塔 时尚个性...</span>

						</td>

						<td>

							SN_A2B3CE88910E

						</td>

						<td>

							内裤

						</td>

						<td>

							￥45.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882badb4ed012baebc0d220045" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/8a76c725d273444d92a3293d2ffdaf76.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882badb4ed012baeb7de840044" />

						</td>

						<td>

								<span title="黛安芬 黑色妖姬 高档银丝设计抹胸式聚拢文胸">黛安芬 黑色妖姬 高档银丝设计抹胸式聚拢文...</span>

						</td>

						<td>

							SN_ABFB103AFE1D

						</td>

						<td>

							内衣

						</td>

						<td>

							￥68.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 0">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882badb4ed012baeb7de840044" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/51b9223c405b43bd868c9697c2007452.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>

					<tr>

						<td>

							<input type="checkbox" name="ids" value="402881882badb4ed012baeb177c90043" />

						</td>

						<td>

								<span title="时尚高级兔毛 线衫 套头衫">时尚高级兔毛 线衫 套头衫</span>

						</td>

						<td>

							SN_430D15C3F74A

						</td>

						<td>

							针织衫

						</td>

						<td>

							￥135.00

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_true_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

								<img src="/shop/template/admin/images/list_false_icon.gif" />

						</td>

						<td>

							<span title="被占用数: 3">100</span>

						</td>

						<td>

							<a href="product!edit.action?id=402881882badb4ed012baeb177c90043" title="编辑">[编辑]</a>

								<a href="/shop/html/product_content/201010/07bfa8affbe643f388e619d831c3148c.html" target="_blank" title="浏览">[浏览]</a>

						</td>

					</tr>
							

						</tbody>


					</table>


<div class="tab-footer clear fl">
							<div class="fl">

								<input type="button" class="formButton" onclick="window.history.back(); return false;" value="删 除" hidefocus="true" />

							</div>

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