package com.shaunz.framework.authority.signin.controller;

import java.util.Locale;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shaunz.framework.authority.user.entity.User;
import com.shaunz.framework.common.utils.IStringUtil;
import com.shaunz.framework.web.base.BaseController;

@Controller
public class SignInController extends BaseController{
	@RequestMapping(value="/signIn.html",method=RequestMethod.GET)
	public String signInPage(){
		return "SignIn";
	}
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public String doSignIn(User user,Model model,Locale locale){
		String msg = "";
		UsernamePasswordToken token = new UsernamePasswordToken(user.getInputUserNM(), user.getInputPwd());
		token.setRememberMe(IStringUtil.notBlank(user.getRememberMe()));
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			if(subject.isAuthenticated()){
				session.setAttribute("user", user);
				/*SavedRequest savedRequest = WebUtils.getSavedRequest(request);
				if(savedRequest == null || savedRequest.getRequestUrl() == null){
					return FORWARD_TO + "managePlant.html";
				} else {
					return FORWARD_TO + savedRequest.getRequestUrl();
				}*/
				return FORWARD_TO + "managePlant.html";
			} else {
				return "SignIn";
			}
		} catch (IncorrectCredentialsException e) {
			msg = messageSource.getMessage("signin.pwdIncorrect", new Object[]{user.getInputUserNM()},locale);
            model.addAttribute("message", msg);
        } catch (ExcessiveAttemptsException e) {
        	msg = messageSource.getMessage("signin.signinTimesLimit", null,locale);
            model.addAttribute("message", msg);
        } catch (LockedAccountException e) {
        	msg = messageSource.getMessage("signin.accountLocked", new Object[]{user.getInputUserNM()},locale);
            model.addAttribute("message", msg);
        } catch (DisabledAccountException e) {
        	msg = messageSource.getMessage("signin.accountDisabled", new Object[]{user.getInputUserNM()},locale);
            model.addAttribute("message", msg);
        } catch (ExpiredCredentialsException e) {
        	msg = messageSource.getMessage("signin.accountExpired", new Object[]{user.getInputUserNM()},locale);
            model.addAttribute("message", msg);
        } catch (UnknownAccountException e) {
        	msg = messageSource.getMessage("signin.unkownAccount", new Object[]{user.getInputUserNM()},locale);
            model.addAttribute("message", msg);
        } catch (UnauthorizedException e) {
        	msg = messageSource.getMessage("signin.unauthorized", null,locale);
            model.addAttribute("message", msg);
        } catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
        	Locale currentLocale = LocaleContextHolder.getLocale();
        	model.addAttribute("locale", currentLocale);
		}
		return "SignIn";
	}
	
	@RequestMapping(value="/signout")
	public String signOut(){
		SecurityUtils.getSubject().logout();
		return REDIRECT_TO + "SignIn";
	}
}
