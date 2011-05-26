<%@ page contentType="text/html; charset=utf-8"%>
<link href="<%=path %>/resources/front/css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />
<!-- scripts (jquery) -->
<script src="<%=path %>/resources/js/jquery/jquery-1.4.3.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.lazyload.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/dialog.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path %>/resources/common/js/jquery.qtip.js"></script>
<script type="text/javascript" src="<%=path %>/resources/common/js/jquery.hoverIntent.js"></script>
<script src="<%=path %>/resources/front/js/jquery.autocomplete.js" type="text/javascript"></script>
<script type="text/javascript">
shop_constant = {
	sysName: "<%=projName%>",
	base: "<%=path %>",
	currencySign: "￥",
	currencyUnit: "元",
	priceScale: "2",
	priceRoundType: "roundHalfUp",
	orderScale: "2",
	orderRoundType: "roundHalfUp",
	cookie_days: 60,
	cookie_path:'/',
	index:"/"
}
</script>