package cn.edu.scut.springaop.xml.privilege.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import cn.edu.scut.springaop.xml.privilege.annotation.AnnotationParser;
import cn.edu.scut.springaop.xml.privilege.bean.Privilege;

public class PrivilegeAspect {
	/**
	 * 该用户能够访问到的权限
	 */
	private List<Privilege> privileges = new ArrayList<Privilege>();
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	/**
	 * 环绕通知
	 */
	public void controlTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		/**
		 * 1、获取用户能够访问到的权限
		 * 2、获取访问目标方法的权限
		 * 3、检查用户的权限中是否包含目标方法的权限
		 *      如果包含
		 *          则访问目标方法
		 *      如果不包含
		 *       	则提示不能访问
		 */
		Class targetClass = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		String privilegeName = AnnotationParser.parse(targetClass, methodName);
		boolean flag = false;
		for(Privilege privilege: this.privileges){
			if(privilege.getName().equals(privilegeName)){
				flag = true;
				break;
			}
		}
		if(flag){
			joinPoint.proceed();
		}else{
			System.out.println("权限不足...");
		}
		
		
		
		
	}
	
}
