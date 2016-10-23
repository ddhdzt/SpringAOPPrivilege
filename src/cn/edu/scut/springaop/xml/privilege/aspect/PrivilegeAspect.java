package cn.edu.scut.springaop.xml.privilege.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import cn.edu.scut.springaop.xml.privilege.annotation.AnnotationParser;
import cn.edu.scut.springaop.xml.privilege.bean.Privilege;

public class PrivilegeAspect {
	/**
	 * ���û��ܹ����ʵ���Ȩ��
	 */
	private List<Privilege> privileges = new ArrayList<Privilege>();
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	/**
	 * ����֪ͨ
	 */
	public void controlTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		/**
		 * 1����ȡ�û��ܹ����ʵ���Ȩ��
		 * 2����ȡ����Ŀ�귽����Ȩ��
		 * 3������û���Ȩ�����Ƿ����Ŀ�귽����Ȩ��
		 *      �������
		 *          �����Ŀ�귽��
		 *      ���������
		 *       	����ʾ���ܷ���
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
			System.out.println("Ȩ�޲���...");
		}
		
		
		
		
	}
	
}
