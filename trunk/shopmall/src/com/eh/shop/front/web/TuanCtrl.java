package com.eh.shop.front.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.dao.hibernate.Page;
import com.eh.shop.admin.logic.TuanInfoLogic;
import com.eh.shop.admin.web.qry.TuanInfoQry;
import com.eh.shop.front.cache.TuanShort;
import com.eh.shop.front.logic.FrontCacheLogic;

public class TuanCtrl extends BaseFrontCtrl {
	FrontCacheLogic frontCacheLogic;
	TuanInfoLogic tuanInfoLogic;
	/**
	 * 团购首页
	 */
	@Override
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/tuan/index");
		
		//查找当前团购信息
		TuanInfoQry qry = new TuanInfoQry();
		super.bindObject(request, qry);
		qry.setPageSize(15);
		Page page = this.tuanInfoLogic.findFrontTuanList(qry);
		
		List data = page.getResult();
		if(data!=null){
			List<TuanShort> tuanList = new ArrayList();
			for (int i = 0, size = data.size(); i < size; i++) {
				tuanList.add(this.frontCacheLogic.findTuanShort((Long)data.get(i)));				
			}
			mav.addObject("tuanList", tuanList);
		}
		
		mav.addObject("page", page);
		mav.addObject("qry", qry);
		
		return mav;
	}
	
	/**
	 * 店铺介绍
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView detail(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/shop/front/shop/detail");
		
		return mav;
	}
	
	
	public FrontCacheLogic getFrontCacheLogic() {
		return frontCacheLogic;
	}
	public void setFrontCacheLogic(FrontCacheLogic frontCacheLogic) {
		this.frontCacheLogic = frontCacheLogic;
	}

	public TuanInfoLogic getTuanInfoLogic() {
		return tuanInfoLogic;
	}

	public void setTuanInfoLogic(TuanInfoLogic tuanInfoLogic) {
		this.tuanInfoLogic = tuanInfoLogic;
	}


}
