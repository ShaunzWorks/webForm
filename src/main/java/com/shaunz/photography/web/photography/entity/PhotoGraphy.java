package com.shaunz.photography.web.photography.entity;

import java.util.Date;

public class PhotoGraphy {
    private String vchPhotoId;

    private String vchPhotoName;

    private String vchPhotoGroup;
    
    private String vchPhotoUrl;

    private String vchPhotoTakeplace;

    private String vchPhotoCamera;

    private String vchPhotoFocalLength;

    private String vchPhotoAperture;

    private String vchPhotoExposureTime;

    private String vchPhotoIso;

    private String vchPhotoOwner;

    private String vchCloseFlg;

    private String vchAddUsr;

    private Date dtAddDate;

    private String vchModUsr;

    private Date dtModDate;

    public String getVchPhotoId() {
        return vchPhotoId;
    }

    public void setVchPhotoId(String vchPhotoId) {
        this.vchPhotoId = vchPhotoId == null ? null : vchPhotoId.trim();
    }

    public String getVchPhotoName() {
        return vchPhotoName;
    }

    public void setVchPhotoName(String vchPhotoName) {
        this.vchPhotoName = vchPhotoName == null ? null : vchPhotoName.trim();
    }

    public String getVchPhotoGroup() {
        return vchPhotoGroup;
    }

    public void setVchPhotoGroup(String vchPhotoGroup) {
        this.vchPhotoGroup = vchPhotoGroup == null ? null : vchPhotoGroup.trim();
    }
    
    public String getVchPhotoUrl() {
		return vchPhotoUrl;
	}

	public void setVchPhotoUrl(String vchPhotoUrl) {
		this.vchPhotoUrl = vchPhotoUrl;
	}

	public String getVchPhotoTakeplace() {
        return vchPhotoTakeplace;
    }

    public void setVchPhotoTakeplace(String vchPhotoTakeplace) {
        this.vchPhotoTakeplace = vchPhotoTakeplace == null ? null : vchPhotoTakeplace.trim();
    }

    public String getVchPhotoCamera() {
        return vchPhotoCamera;
    }

    public void setVchPhotoCamera(String vchPhotoCamera) {
        this.vchPhotoCamera = vchPhotoCamera == null ? null : vchPhotoCamera.trim();
    }

    public String getVchPhotoFocalLength() {
        return vchPhotoFocalLength;
    }

    public void setVchPhotoFocalLength(String vchPhotoFocalLength) {
        this.vchPhotoFocalLength = vchPhotoFocalLength == null ? null : vchPhotoFocalLength.trim();
    }

    public String getVchPhotoAperture() {
        return vchPhotoAperture;
    }

    public void setVchPhotoAperture(String vchPhotoAperture) {
        this.vchPhotoAperture = vchPhotoAperture == null ? null : vchPhotoAperture.trim();
    }

    public String getVchPhotoExposureTime() {
        return vchPhotoExposureTime;
    }

    public void setVchPhotoExposureTime(String vchPhotoExposureTime) {
        this.vchPhotoExposureTime = vchPhotoExposureTime == null ? null : vchPhotoExposureTime.trim();
    }

    public String getVchPhotoIso() {
        return vchPhotoIso;
    }

    public void setVchPhotoIso(String vchPhotoIso) {
        this.vchPhotoIso = vchPhotoIso == null ? null : vchPhotoIso.trim();
    }

    public String getVchPhotoOwner() {
        return vchPhotoOwner;
    }

    public void setVchPhotoOwner(String vchPhotoOwner) {
        this.vchPhotoOwner = vchPhotoOwner == null ? null : vchPhotoOwner.trim();
    }

    public String getVchCloseFlg() {
        return vchCloseFlg;
    }

    public void setVchCloseFlg(String vchCloseFlg) {
        this.vchCloseFlg = vchCloseFlg == null ? null : vchCloseFlg.trim();
    }

    public String getVchAddUsr() {
        return vchAddUsr;
    }

    public void setVchAddUsr(String vchAddUsr) {
        this.vchAddUsr = vchAddUsr == null ? null : vchAddUsr.trim();
    }

    public Date getDtAddDate() {
        return dtAddDate;
    }

    public void setDtAddDate(Date dtAddDate) {
        this.dtAddDate = dtAddDate;
    }

    public String getVchModUsr() {
        return vchModUsr;
    }

    public void setVchModUsr(String vchModUsr) {
        this.vchModUsr = vchModUsr == null ? null : vchModUsr.trim();
    }

    public Date getDtModDate() {
        return dtModDate;
    }

    public void setDtModDate(Date dtModDate) {
        this.dtModDate = dtModDate;
    }
}