package com.eh.shop.admin.logic.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.BaseLogic;
import com.eh.base.util.CriteriaUtil;
import com.eh.base.util.DateUtil;
import com.eh.shop.admin.logic.OrderLogic;
import com.eh.shop.admin.web.qry.OrderQry;
import com.eh.shop.entity.TbGoodsInfoSub;
import com.eh.shop.entity.TbOrderDetail;
import com.eh.shop.entity.TbOrderFlow;
import com.eh.shop.entity.TbOrderMain;
import com.eh.shop.entity.TbReceiptsSeq;

public class OrderLogicImpl extends BaseLogic implements OrderLogic {

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#addOrder(com.eh.shop.entity.TbOrderMain, java.lang.Long[], java.lang.Long[])
	 */
	public String addOrder(TbOrderMain main, Long[] productIds, Long[] cnt) {
		//生成订单编号
		String today = DateUtil.getInstance().formateDate(new Date(), DateUtil.DF_YYMMDD);
		//String orderNo = 
		TbReceiptsSeq seq = super.baseDao.get(TbReceiptsSeq.class,Long.valueOf(1));
		
		if(today.equals(seq.getTodayNum())){
			seq.setCurrentSeq(seq.getCurrentSeq()+1);
		}else{
			//清零
			seq.setTodayNum(today);
			seq.setCurrentSeq(Long.valueOf(1));
		}
		super.baseDao.save(seq);
		
		//补零操作
		String seqCode = seq.getCurrentSeq().toString();
		
		StringBuffer orderNo = new StringBuffer(today) ;
		for(int i = seqCode.length();i<6;i++ ){
			orderNo.append("0");
		}
		orderNo.append(seqCode);
		main.setOrderNo(orderNo.toString());
		super.save(main);
		if(productIds!=null){
			for(int i = 0 , len = productIds.length;i < len; i++){				
				TbOrderDetail detail = new TbOrderDetail();
				detail.setOrder(main);
				detail.setGoodsCount(cnt[i]);
				TbGoodsInfoSub goods = this.load(TbGoodsInfoSub.class, productIds[i]);
				detail.setGoodsName(goods.getGoods().getGoodsName()+"("+goods.getGoodsSubName()+")");
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
		CriteriaUtil.addEq(criteria, "shopInfo.shopId", qry.getShopId());
		CriteriaUtil.addFullLike(criteria, "orderNo", qry.getOrderNo());
		CriteriaUtil.addInStr(criteria, "orderStatus", qry.getOrderStatus());
		CriteriaUtil.addOrder(criteria, "orderTime", CriteriaUtil.DESC);//按时间先后顺序进行排序
		return super.baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#saveOrderAndFlow(com.eh.shop.entity.TbOrderMain, com.eh.shop.entity.TbOrderFlow)
	 */
	public String saveOrderAndFlow(TbOrderMain main, TbOrderFlow flow) {
		flow.setOrder(main);
		super.save(main);
		super.save(flow);
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#findUserOrderList(com.eh.shop.admin.web.qry.OrderQry)
	 */
	public Page findUserOrderList(OrderQry qry) {
		Criteria criteria = baseDao.createCriteria(TbOrderMain.class);
		criteria.createAlias("custInfo","c");
		CriteriaUtil.addEq(criteria, "c.custId", qry.getCustId());
		CriteriaUtil.addOrder(criteria, "orderTime", CriteriaUtil.DESC);
		return super.baseDao.pagedQuery(criteria, qry.getPageNo(), qry.getPageSize());
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#findGoodsList(com.eh.shop.entity.TbOrderMain)
	 */
	public List findOrderGoodsList(TbOrderMain orderMain) {
		return super.baseDao.find("from TbOrderDetail t where t.order = ?", orderMain);
	}

	/* (non-Javadoc)
	 * @see com.eh.shop.admin.logic.OrderLogic#findOrderFlowList(com.eh.shop.entity.TbOrderMain)
	 */
	public List findOrderFlowList(TbOrderMain orderMain) {
		return super.baseDao.find("from TbOrderFlow t where t.order = ? ", orderMain);
	}
	
}
