package com.eh.shop.admin.logic.impl;

import java.util.List;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.CriteriaUtil;
import com.eh.shop.admin.logic.OrderLogic;
import com.eh.shop.admin.web.qry.OrderQry;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbOrderDetail;
import com.eh.shop.entity.TbOrderFlow;
import com.eh.shop.entity.TbOrderMain;

public class OrderLogicImpl extends BaseLogic implements OrderLogic {

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#addOrder(com.eh.shop.entity.TbOrderMain, java.lang.Long[], java.lang.Long[])
	 */
	public String addOrder(TbOrderMain main, Long[] productIds, Long[] cnt) {
		super.save(main);
		if(productIds!=null){
			for(int i = 0 , len = productIds.length;i < len; i++){				
				TbOrderDetail detail = new TbOrderDetail();
				detail.setOrder(main);
				detail.setGoodsCount(cnt[i]);
				TbGoodsInfo goods = this.load(TbGoodsInfo.class, productIds[i]);
				detail.setGoodsPrice(goods.getDiscountPrice());
				detail.setGoods(goods);
				//detail.setGoodsScore(goods.get)
				super.save(detail);
			}
		}
		//添加一条
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#findOrderList(com.eh.shop.admin.web.qry.OrderQry)
	 */
	public Page findOrderList(OrderQry qry) {
		Criteria criteria = baseDao.createCriteria(TbOrderMain.class);
		criteria.createAlias("custInfo","c");
		criteria.createAlias("shopInfo", "s");
		CriteriaUtil.addEq(criteria, "s.shopId", qry.getShopId());
		CriteriaUtil.addOrder(criteria, "orderTime", CriteriaUtil.DESC);//按时间先后顺序进行排序
		return super.baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#saveOrderAndFlow(com.eh.shop.entity.TbOrderMain, com.eh.shop.entity.TbOrderFlow)
	 */
	public String saveOrderAndFlow(TbOrderMain main, TbOrderFlow flow) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#findUserOrderList(com.eh.shop.admin.web.qry.OrderQry)
	 */
	public Page findUserOrderList(OrderQry qry) {
		Criteria criteria = baseDao.createCriteria(TbOrderMain.class);
		criteria.createAlias("custInfo","c");
		CriteriaUtil.addEq(criteria, "c.custId", qry.getCustId());
		return super.baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#findGoodsList(com.eh.shop.entity.TbOrderMain)
	 */
	public List findOrderGoodsList(TbOrderMain orderMain) {
		return super.baseDao.find("from TbOrderDetail t where t.order = ? ", orderMain);
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#findOrderFlowList(com.eh.shop.entity.TbOrderMain)
	 */
	public List findOrderFlowList(TbOrderMain orderMain) {
		return super.baseDao.find("from TbOrderFlow t where t.order = ? ", orderMain);
	}
	
	
	
}
