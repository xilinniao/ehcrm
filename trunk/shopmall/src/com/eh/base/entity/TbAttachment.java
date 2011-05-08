package com.eh.base.entity;

import java.util.Date;


/**
 * TbAttachment entity. @author MyEclipse Persistence Tools
 */

public class TbAttachment  implements java.io.Serializable {


    // Fields    

     private Long recId;
     private String fileName;
     private String fileExtension;
     private String attactType;
     private String fileSize;
     private String filePathA;
     private String filePathB;
     private String filePathC;
     private String filePathD;
     private String filePathE;
     private String filePathF;
     private Long userId;
     private Date createDate;


    // Constructors

    /** default constructor */
    public TbAttachment() {
    }

    
    /** full constructor */
    public TbAttachment(String fileName, String fileExtension, String attactType, String fileSize, String filePathA, String filePathB, String filePathC, String filePathD, String filePathE, String filePathF, Long userId, Date createDate) {
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.attactType = attactType;
        this.fileSize = fileSize;
        this.filePathA = filePathA;
        this.filePathB = filePathB;
        this.filePathC = filePathC;
        this.filePathD = filePathD;
        this.filePathE = filePathE;
        this.filePathF = filePathF;
        this.userId = userId;
        this.createDate = createDate;
    }

   
    // Property accessors

    public Long getRecId() {
        return this.recId;
    }
    
    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }
    
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getAttactType() {
        return this.attactType;
    }
    
    public void setAttactType(String attactType) {
        this.attactType = attactType;
    }

    public String getFileSize() {
        return this.fileSize;
    }
    
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePathA() {
        return this.filePathA;
    }
    
    public void setFilePathA(String filePathA) {
        this.filePathA = filePathA;
    }

    public String getFilePathB() {
        return this.filePathB;
    }
    
    public void setFilePathB(String filePathB) {
        this.filePathB = filePathB;
    }

    public String getFilePathC() {
        return this.filePathC;
    }
    
    public void setFilePathC(String filePathC) {
        this.filePathC = filePathC;
    }

    public String getFilePathD() {
        return this.filePathD;
    }
    
    public void setFilePathD(String filePathD) {
        this.filePathD = filePathD;
    }

    public String getFilePathE() {
        return this.filePathE;
    }
    
    public void setFilePathE(String filePathE) {
        this.filePathE = filePathE;
    }

    public String getFilePathF() {
        return this.filePathF;
    }
    
    public void setFilePathF(String filePathF) {
        this.filePathF = filePathF;
    }

    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
   








}