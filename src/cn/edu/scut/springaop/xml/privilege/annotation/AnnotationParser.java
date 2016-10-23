package cn.edu.scut.springaop.xml.privilege.annotation;

import java.lang.reflect.Method;

public class AnnotationParser {
	public static String parse(Class clazz, String methodName) throws Exception{
		String privilegeName = "";
		//目标方法
		Method method = clazz.getMethod(methodName);
		//判断目标方法上是否有PrivilegeInfo
		if(method.isAnnotationPresent(PrivilegeInfo.class)){
			PrivilegeInfo privilegeInfo = (PrivilegeInfo)method.getAnnotation(PrivilegeInfo.class);
			privilegeName = privilegeInfo.name();
		}
		return privilegeName;
	}
}
