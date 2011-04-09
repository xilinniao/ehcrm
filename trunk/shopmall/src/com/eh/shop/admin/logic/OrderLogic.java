package com.eh.shop.admin.logic;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.OrderQry;
import com.eh.shop.entity.TbOrderFlow;
import com.eh.shop.entity.TbOrderMain;

/**
 * 订单类
 * @author zhoucl
 *
 */
public interface OrderLogic extends IBaseLogic {
	/**
	 * 
	 * @param shopId 商店ID
	 * @param custId 客户ID
	 * @param productIds 商品数组
	 * @param cnt 数量数组
	 * @param usesScore 使用积分
	 * @return
	 */
	public String addOrder(TbOrderMain main,Long[] productIds,Long[] cnt);
	/**
	 * 保存订单处理结果
	 * @param main
	 * @param flow
	 * @return
	 */
	public String saveOrderAndFlow(TbOrderMain main,TbOrderFlow flow);
	/**
	 * 查找订单列表
	 * @param qry
	 * @return
	 */
	public Page findOrderList(OrderQry qry);
	/**
	 * 查找用户订单列表
	 * @param qry
	 * @return
	 */
	public Page findUserOrderList(OrderQry qry);
}
