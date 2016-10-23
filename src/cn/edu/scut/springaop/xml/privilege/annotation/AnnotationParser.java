package cn.edu.scut.springaop.xml.privilege.annotation;

import java.lang.reflect.Method;

public class AnnotationParser {
	public static String parse(Class clazz, String methodName) throws Exception{
		String privilegeName = "";
		//Ŀ�귽��
		Method method = clazz.getMethod(methodName);
		//�ж�Ŀ�귽�����Ƿ���PrivilegeInfo
		if(method.isAnnotationPresent(PrivilegeInfo.class)){
			PrivilegeInfo privilegeInfo = (PrivilegeInfo)method.getAnnotation(PrivilegeInfo.class);
			privilegeName = privilegeInfo.name();
		}
		return privilegeName;
	}
}
