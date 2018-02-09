package com.shaunz.framework.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shaunz.framework.authority.authority.service.AuthorityService;
import com.shaunz.framework.authority.role.entity.Role;
import com.shaunz.framework.authority.role.service.RoleService;
import com.shaunz.framework.authority.user.entity.User;
import com.shaunz.framework.authority.user.service.UserService;
import com.shaunz.framework.common.utils.IStringUtil;

@Component
public class ShaunzRealm extends AuthorizingRealm{
	
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	AuthorityService authorityService;
	
	
	@Autowired
    public ShaunzRealm(@Qualifier("shiroEncacheManager") CacheManager cacheManager) {
        super(cacheManager);
    }

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo autoInfo = null;
		String inputUsrNm = principals.getPrimaryPrincipal().toString();
		User user = findUsrByNm(inputUsrNm);
		if(IStringUtil.notBlank(user.getId())){
			generateAuthorizationInfo(autoInfo,user);
		} else {
			user = findusrByEmail(inputUsrNm);
			if(IStringUtil.notBlank(user.getId())){
				generateAuthorizationInfo(autoInfo,user);
			}
		}
		return autoInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		if(token == null || token.getPrincipal() == null)
			return null;
		String inputUsrNm = token.getPrincipal().toString();
		User user = findUsrByNm(inputUsrNm);
		if(user == null){
			user = findusrByEmail(inputUsrNm);
			if(user == null){
				throw new UnknownAccountException();
			}
		}
		if("lock".equals(user.getLockUp())){
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(
				user.getLoginName(),
                user.getPassword(),
                getName() 
        );
		return authInfo;
	}
	
	private User findUsrByNm(String usrNm){
		if(IStringUtil.notBlank(usrNm)){
			User user = userService.findUserByNm(usrNm);
			return user;
		}
		return null;
	}
	
	private User findusrByEmail(String email){
		if(IStringUtil.notBlank(email)){
			User user = userService.findUserByEmail(email);
			return user;
		}
		return null;
	}
	
	private void generateAuthorizationInfo(SimpleAuthorizationInfo autoInfo,User user){
		autoInfo = new SimpleAuthorizationInfo();
		autoInfo.setRoles(findRolesByUsrId(user.getId()));
		autoInfo.setStringPermissions(findPermissionByUsrId(user.getId()));
	}
	
	private Set<String> findRolesByUsrId(String usrId){
		Set<String> roleNmSet = new HashSet<String>();
		List<Role> roles = roleService.getRolesByUsrId(usrId);
		if(notEmptyLst(roles)){
			for (int i = 0; i < roles.size(); i++) {
				roleNmSet.add(roles.get(i).getName());
			}
		}
		return roleNmSet;
	}
	
	private Set<String> findPermissionByUsrId(String usrId){
		Set<String> permissionSet = new HashSet<String>();
		List<String> functionPermissionLst = 
				authorityService.findFunctionPermissionByUsrId(usrId);
		if(notEmptyLst(functionPermissionLst)){
			
		}
		return permissionSet;
	}
	
	private boolean notEmptyLst(List<?> list){
		if(list != null && list.size() > 0){
			return true;
		}
		return false;
	}

}
