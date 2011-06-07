package com.eh.shop.entity;

import java.util.Date;

import com.eh.base.entity.TbAttachment;
import com.eh.base.util.DateUtil;
import com.eh.base.util.FormateUtil;


/**
 * TbTuanInfo entity. @author MyEclipse Persistence Tools
 */

public class TbTuanInfo  implements java.io.Serializable {


    // Fields    

     private Long tuanId;
     private Long applyId;
     private TbShopInfo shopInfo;
     private Long isPublish;
     private String linkTel;
     private String linkQq;
     /**
 	 * 团购图片
 	 */
 	TbAttachment faceImage;
 	
     private String topicName;
     private Date beginDate;
     private Date endDate;
     private Double price;
     private Double discountPrice;
     private Long maxQty;
     private Long currQty;
     private Long createUser;
     private Date createTime;
     private TbTuanInfoExt ext;

   
    // Property accessors

    public Long getTuanId() {
        return this.tuanId;
    }
    
    public void setTuanId(Long tuanId) {
        this.tuanId = tuanId;
    }

    public Long getApplyId() {
        return this.applyId;
    }
    
    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public TbShopInfo getShopInfo() {
        return this.shopInfo;
    }
    
    public void setShopInfo(TbShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    public Long getIsPublish() {
        return this.isPublish;
    }
    
    public void setIsPublish(Long isPublish) {
        this.isPublish = isPublish;
    }

    public String getLinkTel() {
        return this.linkTel;
    }
    
    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    public String getLinkQq() {
        return this.linkQq;
    }
    
    public void setLinkQq(String linkQq) {
        this.linkQq = linkQq;
    }
    public TbAttachment getFaceImage() {
		return faceImage;
	}

	public void setFaceImage(TbAttachment faceImage) {
		this.faceImage = faceImage;
	}


	public String getTopicName() {
        return this.topicName;
    }
    
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Date getBeginDate() {
        return this.beginDate;
    }
    
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return this.discountPrice;
    }
    
    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Long getMaxQty() {
        return this.maxQty;
    }
    
    public void setMaxQty(Long maxQty) {
        this.maxQty = maxQty;
    }

    public Long getCurrQty() {
        return this.currQty;
    }
    
    public void setCurrQty(Long currQty) {
        this.currQty = currQty;
    }

    public Long getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public TbTuanInfoExt getExt() {
        return this.ext;
    }
    
    public void setExt(TbTuanInfoExt ext) {
        this.ext = ext;
    }
   


    public String getBeginDateStr() {
		return DateUtil.getInstance().formateDate(this.beginDate);
	}

	public String getEndDateStr() {
		return DateUtil.getInstance().formateDate(this.endDate);
	}

	public String getPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.price);
	}

	public String getDiscountPriceStr() {
		return FormateUtil.getInstance().formateDouble(this.discountPrice);
	}
	
	public String getPriceBlank() {
		return FormateUtil.getInstance().formateDouble(this.price,"");
	}

	public String getDiscountPriceBlank() {
		return FormateUtil.getInstance().formateDouble(this.discountPrice,"");
	}

	public String getCreateTimeStr() {
		return DateUtil.getInstance().formateDate(this.createTime);
	}
	
	/**
	 * 获取中文描述
	 */
	public String getIsPublishStr(){
		if(this.isPublish==null){
			return "";
		}else if(this.isPublish.longValue()==Long.valueOf(0)){
			return "暂未发布";
		}else if(this.isPublish.longValue()==Long.valueOf(1)){
			return "已发布";
		}else{
			return "";
		}
	}

}