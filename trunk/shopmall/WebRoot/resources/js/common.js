function ajaxSuccess(respText) {
 	if(respText=='OK'){
		alert('数据保存成功');
	}else{
		alert('数据保存失败');
	}
}

function ajaxMaskSuccess(respText) {
	var respTexts = respText.split("$");
 	if(respTexts[0]=='OK'){
		$('body').unmask();
		if($("#msg_info").length>0){
			$('#msg_info').html(respTexts[1]);
			$('#msg_info').show();
		}
	}else{
		$('body').unmask();
		alert('数据保存失败');		
	}
}

function ajaxError(xhr, ajaxOptions, thrownError){
	alert('xhr请求失败');		
}