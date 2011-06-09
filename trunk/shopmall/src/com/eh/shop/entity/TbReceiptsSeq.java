package com.eh.shop.entity;

public class TbReceiptsSeq implements java.io.Serializable {
		/**
		 * pk
		 * 记录编号
		 **/
		Long recId;
		/**
		 * 单据类型
		 **/
		String seqType;
		/**
		 * 单据当前流水
		 **/
		Long currentSeq;
		/**
		 * 当前日期
		 **/
		String todayNum;
	
		public Long getRecId(){
			return this.recId;
		}		
		public void setRecId(Long recId){
			this.recId = recId;
		}
		public String getSeqType(){
			return this.seqType;
		}		
		public void setSeqType(String seqType){
			this.seqType = seqType;
		}
		public Long getCurrentSeq(){
			return this.currentSeq;
		}		
		public void setCurrentSeq(Long currentSeq){
			this.currentSeq = currentSeq;
		}
		public String getTodayNum() {
			return todayNum;
		}
		public void setTodayNum(String todayNum) {
			this.todayNum = todayNum;
		}
}