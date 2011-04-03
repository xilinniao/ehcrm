<%@ page contentType="text/html; charset=utf-8"%>
<!-- 顶部信息 -->

<%@include file="/jsp/shop/front/common/toptop.jsp"%>

    
    
<div class="w" id="header">
	<div id="logo">
		<a href="<%=homeUrl %>">
			<img src="<%=path %>/resources/front/images/logo.gif" alt="抚州商城" width="251" height="46">
		</a>
	</div>
	<!-- 导航开始 -->
	<div id="nav">
		<ul id="topnav"> 
    	<li> 
        	<a href="<%=homeUrl %>" class="home">首页</a> 
        </li>
        <li> 
        	<a href="#" class="products curr">手机数码</a>
            <div class="sub"> 
            	<dl>
			        <dt><a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12004,12005,12006&amp;nLevel=2" title="运动鞋靴">运动鞋靴</a></dt>
			        <dd>
			           <a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12004003,12005003&amp;nLevel=3" title="跑步鞋">跑步鞋</a>
			           <a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12005012,12002001&amp;nLevel=3" title="休闲鞋 ">休闲鞋 </a>
			           <a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12004008,12005008&amp;nLevel=3" title="板鞋 ">板鞋 </a>
			           <a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12004010&amp;nLevel=3" title="户外鞋">户外鞋</a>
			        </dd>
			      </dl>
			      <dl>
			        <dt><a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12004,12005,12006&amp;nLevel=2" title="运动鞋靴">运动鞋靴</a></dt>
			        <dd>
			           <a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12004003,12005003&amp;nLevel=3" title="跑步鞋">跑步鞋</a>
			           <a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12005012,12002001&amp;nLevel=3" title="休闲鞋 ">休闲鞋 </a>
			           <a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12004008,12005008&amp;nLevel=3" title="板鞋 ">板鞋 </a>
			           <a href="http://mall.woyo.com/getCounterGoodsList.html?lCategoryId=12004010&amp;nLevel=3" title="户外鞋">户外鞋</a>
			        </dd>
			      </dl>
            </div>
        </li>
        <li> 
        	<a href="index.xhtml?method=tuan" class="products">团购</a>
        </li>
        <li> 
        	<a href="index.xhtml?method=food" class="products">乡村特产</a> 
        	 <div class="sub"> 
            	${digital}          
            </div> 
        </li> 
        <li> 
        	<a href="index.xhtml?method=electronic" class="products">家用电器</a>
        	<div class="sub"> 
            	${digital }          
            </div> 
        </li>
        <li>
        	<a href="index.xhtml?method=digital" class="products">电脑数码</a>
        	<div class="sub"> 
            	${digital }          
            </div> 
        </li>        
        <li> 
        	<a href="index.xhtml?method=clothing" class="products">家居家纺</a>
        	<div class="sub"> 
            	${clothing }
            </div>  
        </li>
        <li> 
        	<a href="index.xhtml?method=baby" class="products">母婴用品</a>
        	<div class="sub"> 
            	${digital }          
            </div>  
        </li>
        
    </ul>
    
	</div>
	<span class="clr"></span>
	<!-- end of 导航开始 -->
	<!-- 搜索开始 -->
	<div id="o-search">
		<div class="allsort">
		</div>		
		<div id="search" class="form">
			<div id="i-search">
				<input type="text" id="key" value="" autocomplete="off" onkeydown="javascript:if(event.keyCode==13) search('key');">
				<ul id="tie" class="hide"></ul>
			</div>
			<input type="submit" value="搜&nbsp;索" id="btn-search" onclick="search('key');return false;">
		</div>
		<div id="hotwords">
			<strong>热门搜索：</strong>
			<a href="http://search.360buy.com/Search?keyword=华硕笔记本" target="_blank">华硕笔记本</a>
			<a href="http://search.360buy.com/Search?keyword=优恩" target="_blank">优恩</a>
			<a href="http://search.360buy.com/Search?keyword=吸油烟机" target="_blank">吸油烟机</a>
			<a href="http://search.360buy.com/Search?keyword=折叠自行车" target="_blank">折叠自行车</a>
			<a href="http://search.360buy.com/Search?keyword=纽曼GPS" target="_blank">纽曼GPS</a>
			<a href="http://search.360buy.com/Search?keyword=DELL笔记本" target="_blank">DELL笔记本</a>
			<a href="http://search.360buy.com/Search?keyword=方正笔记本" target="_blank">方正笔记本</a>
			<a href="http://search.360buy.com/Search?keyword=%B7%BD%D5%FD%B1%CA%BC%C7%B1%BE" target="_blank">方正笔记本</a>
			<a href="http://search.360buy.com/Search?keyword=%CF%A3%BD%DD%D2%C6%B6%AF%D3%B2%C5%CC&amp;cid=693&amp;page=1" target="_blank">希捷移动硬盘</a>
		</div>
		<ul id="mycart">
			<li class="fore1" id="i-mycart" load="true">
				<a href="<%=path %>/front/order.xhtml?method=shoppingcart">购物车<b id="mycart-amount">0</b>件</a>
				<div id="o-mycart-list" class="hide" style="display: none; ">
					<div id="mycart-list">
<!-- 
						<div class="item"><dl><dt class="p-img"><a href="http://www.360buy.com/product/334965.html" target="_blank"><img src="http://img10.360buyimg.com/n5/1127/0c8148e5-dfb1-4dae-9b4c-408ebce2b2ce.jpg" alt="和瓷富贵满堂盘HCQ7031青花" onerror="this.src='http://www.360buy.com/images/none/none_50.gif'"></a></dt><dd class="p-name"><a href="http://www.360buy.com/product/334965.html">和瓷富贵满堂盘HCQ7031青花</a></dd><dd class="extra"><strong>￥199.00×1</strong><br><a id="334965" name="RemoveProduct" href="#none">删除</a></dd></dl></div>
						<div class="item"><dl><dt class="p-img"><a href="http://www.360buy.com/product/334965.html" target="_blank"><img src="http://img10.360buyimg.com/n5/1127/0c8148e5-dfb1-4dae-9b4c-408ebce2b2ce.jpg" alt="和瓷富贵满堂盘HCQ7031青花" onerror="this.src='http://www.360buy.com/images/none/none_50.gif'"></a></dt><dd class="p-name"><a href="http://www.360buy.com/product/334965.html">和瓷富贵满堂盘HCQ7031青花</a></dd><dd class="extra"><strong>￥199.00×1</strong><br><a id="334965" name="RemoveProduct" href="#none">删除</a></dd></dl></div>
						<div class="norecode ac">您的购物车中暂无商品，赶快选择心爱的商品吧！</div>
-->
					</div>
				</div>
			</li>
			<li class="fore2">
				<a href="<%=path %>/front/order.xhtml?method=shoppingcart">去结算</a>
			</li>
		</ul>
	</div>
	<!-- 搜索结束 -->
</div>
<!-- 头部结束 -->