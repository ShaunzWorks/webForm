package com.shaunz.framework.authority.user.entity;

import java.util.Date;

import org.apache.log4j.Logger;

import com.shaunz.framework.common.utils.IStringUtil;

public class User implements Cloneable{
	Logger logger = Logger.getLogger(User.class);
	
    private String id;

    private String loginName;

    private String password;

    private String orgPath;

    private String aliasNm;

    private String gender;

    private String email;

    private String closeFlg;

    private String lockUp;

    private Date startTime;

    private Date endTime;
    
    private String rememberMe;
    
    private String inputUserNM;
    
    private String inputPwd;
    
    private String attemptSignTimes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath == null ? null : orgPath.trim();
    }

    public String getAliasNm() {
        return aliasNm;
    }

    public void setAliasNm(String aliasNm) {
        this.aliasNm = aliasNm == null ? null : aliasNm.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCloseFlg() {
        return closeFlg;
    }

    public void setCloseFlg(String closeFlg) {
        this.closeFlg = closeFlg == null ? null : closeFlg.trim();
    }

    public String getLockUp() {
        return lockUp;
    }

    public void setLockUp(String lockUp) {
        this.lockUp = lockUp == null ? null : lockUp.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getInputUserNM() {
		return inputUserNM;
	}

	public void setInputUserNM(String inputUserNM) {
		this.inputUserNM = inputUserNM;
	}

	public String getInputPwd() {
		return inputPwd;
	}

	public void setInputPwd(String inputPwd) {
		this.inputPwd = inputPwd;
	}

	public String getAttemptSignTimes() {
		return attemptSignTimes;
	}

	public void setAttemptSignTimes(String attemptSignTimes) {
		this.attemptSignTimes = attemptSignTimes;
	}
	
	public void attmptSignTimesPlusOne(){
		if(IStringUtil.isBlank(attemptSignTimes)){
			attemptSignTimes = "0";
		}
		int times = 0;
		try {
			times = Integer.valueOf(attemptSignTimes) +1;
		} catch (Exception e) {
			logger.error(e);
			times = 0;
		}
		attemptSignTimes = ""+times;
	}
	
	public void deSensitive(){
	    this.id = null;
	    this.loginName = null;
	    this.orgPath = null;
		this.password = null;
		this.email = null;
		this.inputPwd = null;
		this.lockUp = null;
		this.closeFlg = null;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}