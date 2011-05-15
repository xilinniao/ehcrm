/**
 * 
 */
package com.eh.shop.admin.logic;

import java.util.List;

import com.eh.base.dao.hibernate.Page;
import com.eh.base.logic.IBaseLogic;
import com.eh.shop.admin.web.qry.GoodsInfoQry;
import com.eh.shop.entity.TbGoodsInfo;
import com.eh.shop.entity.TbGoodsInfoSub;
import com.eh.shop.entity.TbSiteCategory;

/**
 * @author zhoucl
 *
 */
public interface GoodsLogic extends IBaseLogic {
	/**
	 * 查找商品列表
	 * @param qry
	 * @return
	 */
	public Page findGoodsList(GoodsInfoQry qry);
	/**
	 * 查找商品列表用于栏目商品选择
	 * @param qry
	 * @return
	 */
	public Page findGoodsListForPage(GoodsInfoQry qry);
	
	public Page findGoodsListForJingdong(GoodsInfoQry qry);
	/**
	 * 保存商品信息
	 * @param info
	 * @param imageIds 附件
	 * @return
	 */
	public String saveGoodsInfo(TbGoodsInfo info,TbSiteCategory siteCategory,TbGoodsInfoSub[] subs,Long[] imageIds);
	/**
	 * 根据物品ID查询图片列表
	 * @param goodsId
	 * @return
	 */
	public List findImageList(Long goodsId);
	/**
	 * 查找商品子列表
	 * @param goodsId
	 * @return
	 */
	public List findGoodSubList(Long goodsId);
	/**
	 * 查找商品列表
	 * @param productId
	 * @return
	 */
	public List findGoodsForPrice(String productId);
	
	/**
	 * 查找自动建议部门
	 * @param q
	 * @return
	 */
	public List findAutoSuggest(String q);
}
