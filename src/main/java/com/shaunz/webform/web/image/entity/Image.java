package com.shaunz.webform.web.image.entity;

import javax.persistence.Entity;

import com.shaunz.framework.core.BaseEntity;

@Entity
public class Image extends BaseEntity{
    private String name;

    private String url;

    private String cssClass;
    
    private String closeFlg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass == null ? null : cssClass.trim();
    }

	public String getCloseFlg() {
		return closeFlg;
	}

	public void setCloseFlg(String closeFlg) {
		this.closeFlg = closeFlg;
	}

}