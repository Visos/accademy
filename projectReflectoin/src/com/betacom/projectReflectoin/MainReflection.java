package com.betacom.projectReflectoin;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class MainReflection {
	
	public static void main(String args[]) {
		String packagename = "com.betacom.projectReflectoin";
		String className = "MyClassReflection";

		
		
		try {
			Class cl = Class.forName(packagename + "." + className);			
			Constructor [] ctors=  cl.getConstructors();
			Object myClass = null;
			Constructor ctorSelected = null;
			
			for(Constructor ctor: ctors) {
				System.out.println("parameters lenght: " + ctor.getGenericParameterTypes().length);
				if ( ctor.getGenericParameterTypes().length > 0) {
					Type[] type = ctor.getGenericParameterTypes();
					for(Type t : type) {
						System.out.println(type.toString());

					}
				}else {
					ctorSelected = ctor;
				}
			}
			myClass = ctorSelected.newInstance();
			System.out.println("after new sitance");
			
			Method[] metods = myClass.getClass().getMethods();
			Method toString = myClass.getClass().getMethod(className, null);
			
			for(Method m : metods) {
				System.out.println("method found: " + m.getName());
				
				if("seId".equals(m.getName()) ) {
					m.invoke(myClass, 10);
					
					System.out.println("after setId");
				}
			}
			
			
			String methodNmae = "toString";
			toString = myClass.getClass().getMethod(methodNmae);
			
			String msg = null;
			msg = (String) toString.invoke(myClass);
			Method m = myClass.getClass().getMethod(methodNmae, Integer.class);
			m.invoke(m,999);
			
			
			
			msg = (String)toString.invoke(myClass);
			System.out.println(msg);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			System.out.println("class not found" + e.getMessage());	
		}
		
		 
	}

}
