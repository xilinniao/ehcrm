/**
 * 数据验证器
 **/
function FormValidator(cfg,errorId){
	regex_int = /^[-+]?[\d]+$/;
	reg_number = /^([+-]?)\d*\.\d+$/;
	this.config = cfg;
	this.result = true;
	this.errorId = errorId;
	this.isPass = function(){
		this.check();
		return this.result;
	}
	
	this.check = function(){
		config = this.config;
		this.result = true;
		$('#'+errorId).html('');
		for(var i=0,len=config.length;i<len;i++){
			var elm = $('#'+config[i].id);
			if(!config[i].empty){
				if($.trim(elm.val())==''){
					this.showError(i,config[i].name+'不能为空');
					continue;
				}else{
					hideError(i);
				}
			}
			if(config[i].type=='number'){
				//检验数字
				elm.val($.trim(elm.val()));
				if(!reg_number.test($.trim(elm.val()))){
					this.showError(i,'输入的'+config[i].name+'不是数字');
				}
			}else if(config[i].type=='integer'){
				//检验整数
				elm.val($.trim(elm.val()));
				if(!regex_int.test($.trim(elm.val()))){
					this.showError(i,'输入的'+config[i].name+'不是整数');
				}
			}else if(config[i].type=='date'){
				elm.val($.trim(elm.val()));
				//检验日期
				if(!isDate(elm.val())){
					this.showError(i,config[i].name+',输入的日期格式不正确，正确的日期格式如:2010-05-01');
				}
			}else{
				
			}
		}
	}

	function isDate(str)
	{
		var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
		if(r==null)return false; 
		var d= new Date(r[1], r[3]-1, r[4]); 
		return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
	}	
	
	this.showError=function(i,msg_text){
		$('#'+errorId).html($('#'+errorId).html()+msg_text+'<br/>').show();
		$('#'+errorId).addClass('error');
		$('#'+config[i].id).addClass('text_error');
		this.result = false;
	}
	function hideError(i){
		$('#msg_'+config[i].id).hide();
		$('#'+config[i].id).removeClass('text_error');
	}

}