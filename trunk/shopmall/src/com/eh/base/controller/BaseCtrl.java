package com.eh.base.controller;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.util.WebUtils;

import com.eh.base.entity.DeptInfo;
import com.eh.base.util.Constants;
import com.eh.base.util.DateUtil;
import com.eh.base.vo.UserInfo;
import com.eh.exception.ParameterException;
import com.eh.exception.SessionLostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Multiaction Controller的基类.
 * 对Spring的MultiActionController作了少量扩展，主要是对数据绑定校验的扩展,
 * 同时增加了{@link #saveMessage(HttpServletRequest, String) }，一个{@link #rendText(HttpServletResponse,String)}
 *
 */
abstract public class BaseCtrl extends MultiActionController {
	public static final String SHOW_MSG_JSP = "/common/showMessage.jsp";
	public static final String SHOW_MSG_ATTR = "/common/showMessage.jsp";
	
	/**
     * 不设置任何action参数时的默认 Action.
     * 该函数名由xxx-servlet.xml配置文件中的 methodNameResolver节点配置.
     */
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	return null;
    }

    /**
     * 初始化binder的回调函数.
     * 默认以DateUtil中的日期格式设置DateEditor及允许Integer,Double的字符串为空.
     *
     * @see MultiActionController#createBinder(HttpServletRequest,Object)
     */
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor(DateUtil.DF_YYYY_MM_DD,DateUtil.DF_YYYY_MM_DD_HH_MM, true));
        binder.registerCustomEditor(Short.class, new CustomNumberEditor(Short.class, true));
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
    }

    /**
     * 从Request中绑定对象并进行校验.
     * Spring MVC中的Bind函数未完全符合需求,因此参考原代码进行了扩展

     *
     * @return 校验错误
     * @see #preBind(HttpServletRequest,Object,ServletRequestDataBinder)
     */
    protected BindingResult bindObject(HttpServletRequest request, Object command) throws Exception {
        Assert.notNull(command);

        //创建Binder
        ServletRequestDataBinder binder = createBinder(request, command);
        //回调函数，供子类扩展对binder做出更进一步设置,并进行不能由binder自动完成的绑定

        preBind(request, command, binder);

        //绑定
        binder.bind(request);

        //校验
        Validator[] validators = getValidators();
        if (validators != null) {
            for (int i=0;i<validators.length;i++) {
            	Validator validator=validators[i];
                if (validator.supports(command.getClass())) {
                    ValidationUtils.invokeValidator(validator, command, binder.getBindingResult());
                }
            }
        }
        return binder.getBindingResult();
    }

    /**
     * 回调函数，在BindObject的最开始调用。负责

     * 1.继续对binder进行设置
     * 2.绑定一些不能由Binder自动绑定的属性.这些属性通常是需要查询数据库来获得对象的绑定.
     * 要注意设置这些属性为disallow. eg.
     * <pre>binder.setDisallowedFields(new String[]{"image","category"});</pre>
     *
     * @see #bindObject(HttpServletRequest, Object)
     * @see org.springframework.web.bind.ServletRequestDataBinder#setDisallowedFields(String[])
     * @see org.springside.bookstore.admin.web.BookManageController#preBind(javax.servlet.http.HttpServletRequest, Object, org.springframework.web.bind.ServletRequestDataBinder)
     */
    protected void preBind(HttpServletRequest request, Object object, ServletRequestDataBinder binder) throws Exception {
        //在子类实现

    }

    /**
     * 回调函数，声明CommandName--对象的名字,默认为首字母小写的类名.
     *
     * @see #bindObject(HttpServletRequest, Object)
     */
/*    protected String getCommandName(Object command) {
        return StringUtils.uncapitalize(command.getClass().getSimpleName());
    }
*/
    /**
     * 增加validator.
     * 除了Spring配置文件注入的validators数组外,可以用此函数在子类的代码里再添加新的validator.
     */
    protected void addValidator(Validator validator) {
        ArrayUtils.add(getValidators(), validator);
    }

    /**
     * 向View层传递message时将message放入httpSession的messages变量中.
     * 放在session中能保证message即使Redirect也不会消失。需配合{@link org.springside.core.web.MessageFilter MessageFilter}使用
     */
    protected void saveMessage(HttpServletRequest request, String message) {
        if (StringUtils.isNotBlank(message)) {
            List messages = (List) WebUtils.getOrCreateSessionAttribute(request.getSession(), "messages", ArrayList.class);
            messages.add(message);
        }
    }

    /**
     * 直接向客户端返回Content字符串，不用通过View页面渲染.
     */
    protected void rendText(HttpServletResponse response, String content) throws IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println(content);
        response.getWriter().write(content);
    }
    
    protected ModelAndView getSuccessModelAndView(HttpServletRequest request){
    	String uri = request.getParameter("uri");
    	ModelAndView mav = new ModelAndView(uri);
    	return mav;
    }
    
    protected int getInt(HttpServletRequest request,String parameter,boolean allowNull)throws ParameterException{
		String value = request.getParameter(parameter);
		if(StringUtils.isBlank(value)){
			if(!allowNull){
				throw new ParameterException(parameter+"参数不能为空");
			}else{
				return -1;
			}
		}else{
			return Integer.parseInt(value);
		}
	}
    
    protected Long getLong(HttpServletRequest request,String parameter,boolean allowNull)throws ParameterException{
		String value = request.getParameter(parameter);
		if(StringUtils.isBlank(value)){
			if(!allowNull){
				throw new ParameterException(parameter+"参数不能为空");
			}else{
				return null;
			}
		}else{
			return Long.parseLong(value);
		}
	}
    
    protected Double getDouble(HttpServletRequest request,String parameter,boolean allowNull)throws ParameterException{
		String value = request.getParameter(parameter);
		if(StringUtils.isBlank(value)){
			if(!allowNull){
				throw new ParameterException(parameter+"参数不能为空");
			}else{
				return null;
			}
		}else{
			return Double.parseDouble(value);
		}
	}
    
    protected Long[] getLongs(HttpServletRequest request,String parameter,boolean allowNull)throws ParameterException{
		String[] values = request.getParameterValues(parameter);
		if(values==null){
			return null;
		}else{
			Long[] lv = new Long[values.length];
			for(int i = 0,len = values.length-1;i<=len;i++){
				lv[i] = Long.parseLong(values[i]);
			}
			return lv;
		}
	}
    
    protected String getString(HttpServletRequest request,String parameter,boolean allowNull)throws ParameterException{
		String value = request.getParameter(parameter);
		if(StringUtils.isBlank(value)){
			if(!allowNull){
				throw new ParameterException(parameter+" 参数不能为空");
			}else{
				return "";
			}
		}else{
			return value;
		}
	}
    
    protected Date getDate(HttpServletRequest request,String parameter,boolean allowNull)throws ParameterException, ParseException{
		String value = request.getParameter(parameter);		
		Date convertDate = DateUtil.getInstance().parseDate(value);		
		if(convertDate==null){
			if(!allowNull){
				throw new ParameterException(parameter+" 参数不能为空");
			}else{
				return null;
			}
		}else{
			return convertDate;
		}
	}
    
    protected String[] getStrings(HttpServletRequest request,String parameter,boolean allowNull)throws ParameterException{
    	String[] values = request.getParameterValues(parameter);
    	return values;
	}
    
    protected HttpSession getSession(HttpServletRequest request) throws SessionLostException{
    	HttpSession session = request.getSession();    	
    	if(session==null){
    		throw new SessionLostException();
    	}else{
    		return session;
    	}
    }
    
    /**
     * 获取session对象
     * @param request
     * @return
     * @throws SessionLostException
     */
    protected UserInfo getUserInfo(HttpServletRequest request)throws SessionLostException{
    	HttpSession session = this.getSession(request);
    	UserInfo umSession = (UserInfo)session.getAttribute(Constants.SESSION_NAME);
    	if(umSession==null){
    		throw new SessionLostException();
    	}else{
    		return umSession;
    	}
    }
    
    /**
     * 获取可操作的顶层机构
     * @param request
     * @return
     * @throws SessionLostException
     */
    protected DeptInfo getRootDept(UserInfo u)throws SessionLostException{
    	return u.getDept();
    }
    
    protected void addMessage(HttpServletRequest request,String message){
    	request.setAttribute("message", message);
    }
    
    public String getContextPath(HttpServletRequest request){	
		String path = request.getContextPath();
		if("/".equals(path)){
			path = "";
		}
		return path;
	}
    
    public String getRootRealPath(HttpServletRequest request) throws FileNotFoundException{
    	return WebUtils.getRealPath(request.getSession().getServletContext(), "/");
    }
    
    //-- header 常量定义 --//
    private static final String HEADER_ENCODING = "encoding";
    private static final String HEADER_NOCACHE = "no-cache";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final boolean DEFAULT_NOCACHE = true;
    /**
     * 分析并设置contentType与headers.
     */
    private void initResponseHeader(HttpServletResponse response,final String contentType, final String... headers) {
            //分析headers参数
            String encoding = DEFAULT_ENCODING;
            boolean noCache = DEFAULT_NOCACHE;
            if(headers!=null){
	            for (String header : headers) {
	                    String headerName = StringUtils.substringBefore(header, ":");
	                    String headerValue = StringUtils.substringAfter(header, ":");
	
	                    if (StringUtils.equalsIgnoreCase(headerName, HEADER_ENCODING)) {
	                            encoding = headerValue;
	                    } else if (StringUtils.equalsIgnoreCase(headerName, HEADER_NOCACHE)) {
	                            noCache = Boolean.parseBoolean(headerValue);
	                    } else {
	                            throw new IllegalArgumentException(headerName + "不是一个合法的header类型");
	                    }
	            }
            }
            //设置headers参数
            String fullContentType = contentType + ";charset=" + encoding;
            response.setContentType(fullContentType);
            if (noCache) {
                    ServletUtils.setNoCacheHeader(response);
            }
    }
    
    /**
     * 直接输出内容的简便函数.

     * eg.
     * render("text/plain", "hello", "encoding:GBK");
     * render("text/plain", "hello", "no-cache:false");
     * render("text/plain", "hello", "encoding:GBK", "no-cache:false");
     *
     * @param headers 可变的header数组，目前接受的值为"encoding:"或"no-cache:",默认值分别为UTF-8和true.
     */
    private void render(HttpServletResponse response,final String contentType, final String content, final String... headers) {
    		initResponseHeader(response,contentType, headers);
            try {
                    response.getWriter().write(content);
                    response.getWriter().flush();
            } catch (IOException e) {
                    throw new RuntimeException(e.getMessage(), e);
            }
    }
    
    /**
     * 直接输出文本.
     * @see #render(String, String, String...)
     */
    protected void renderText(HttpServletResponse response,final String text, final String... headers) {
    		System.out.println(text);
            render(response,ServletUtils.TEXT_TYPE, text, headers);
    }
    
    /**
     * 直接输出文本.
     * @see #render(String, String, String...)
     */
    protected void renderText(HttpServletResponse response,final boolean isTrue, final String... headers) {
            render(response,ServletUtils.TEXT_TYPE, isTrue?"true":"false", headers);
    }
    
    /**
     * 直接输出XML.
     * @see #render(String, String, String...)
     */
    protected void renderXml(HttpServletResponse response,final String xml, final String... headers) {
            render(response,ServletUtils.XML_TYPE, xml, headers);
    }
    
    protected void renderJson(HttpServletResponse response,final String jsonString) {
    	render(response,ServletUtils.JSON_TYPE, jsonString, null);
    }

    /**
     * 直接输出JSON.
     *
     * @param jsonString json字符串.
     * @see #render(String, String, String...)
     */
    protected void renderJson(HttpServletResponse response,final String jsonString, final String... headers) {
    		System.out.println(jsonString);
            render(response,ServletUtils.JSON_TYPE, jsonString, headers);
    }
    
    public Map<String, String> getParameterMap(HttpServletRequest request){
        Map m = new HashMap();
        Enumeration<String> e = request.getParameterNames();
        while(e.hasMoreElements()){
            String name = e.nextElement();
            m.put(name, request.getParameter(name));
            System.out.println(name+":"+request.getParameter(name));
        }
        return m;
    }
}