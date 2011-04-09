package com.eh.shop.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.eh.base.controller.BaseCtrl;
import com.eh.shop.admin.logic.GoodsCatLogic;
import com.eh.shop.entity.TbGoodsCategory;

public class AppCtrl extends BaseCtrl {
	
	GoodsCatLogic goodsCatLogic;
	
}
