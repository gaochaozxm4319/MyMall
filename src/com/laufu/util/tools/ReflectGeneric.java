package com.laufu.util.tools;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laufu.blogbeans.Blog;
import com.laufu.dao.impl.MybatisBaseGenericDAOImpl;
import com.laufu.domain.User;

/**
 * 反射泛型类型工具类 (例如：ObjectClass<String,Integer>，String为索引0，Integer为索引1)
 * 
 * @author Samsung
 *
 */
public class ReflectGeneric {
	/**
	 * 获得参数化类型的泛型类型，取第一个参数的泛型类型，（默认去的第一个）
	 * 
	 * @param clazz
	 *            参数化类型
	 * @return 泛型类型
	 */
	@SuppressWarnings("rawtypes")
	public static Class getClassGenricType(final Class clazz) {
		return getClassGenricType(clazz, 0);
	}

	/**
	 * 根据参数索引获得参数化类型的泛型类型，（通过索引取得）
	 * 
	 * @param clazz
	 *            参数化类型
	 * @param index
	 *            参数索引
	 * @return 泛型类型
	 */
	@SuppressWarnings("rawtypes")
	public static Class getClassGenricType(final Class clazz, final int index) {
		// getGenericSuperclass()返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
		/*
		 * 如果超类是参数化类型，则返回的 Type
		 * 对象必须准确反映源代码中所使用的实际类型参数。如果以前未曾创建表示超类的参数化类型
		 * 则创建这个类型。有关参数化类型创建过程的语义，请参阅
		 * ParameterizedType 声明。如果此 Class 表示 Object 类、接口、基本类型或 void，则返回
		 * null。如果此对象表示一个数组类，则返回表示 Object 类的 Class 对象。
		 */
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	public static void main(String[] args) {
		MybatisBaseGenericDAOImpl<User,String> list = new TestPage();
		String class1 = list.getSqlNamespace();
//		HashMap<User, Blog> map = new HashMap<User, Blog>();
		TestHa<User,Blog > testHa = new TestSon();
		
		System.out.println(class1);
		System.out.println(getClassGenricType(list.getClass()).getName());
		System.out.println(getClassGenricType(testHa.getClass()).getName());
	}
}

class TestPage extends MybatisBaseGenericDAOImpl<User, String>{
	
}


class TestHa<T,o>{
	
}

class TestSon extends TestHa<User ,Blog>{
	
}