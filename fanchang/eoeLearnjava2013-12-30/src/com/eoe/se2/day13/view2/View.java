package com.eoe.se2.day13.view2;

import java.lang.reflect.Field;
import java.util.Arrays;

public class View {

	/**
	 * @param args
	 */
	private String id;
	private String layout_width;
	private String layout_height;
	private String backgorund;

	public View() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLayout_width() {
		return layout_width;
	}

	public void setLayout_width(String layout_width) {
		this.layout_width = layout_width;
	}

	public String getLayout_height() {
		return layout_height;
	}

	public void setLayout_height(String layout_height) {
		this.layout_height = layout_height;
	}

	public String getBackgorund() {
		return backgorund;
	}

	public void setBackgorund(String backgorund) {
		this.backgorund = backgorund;
	}

	/*
	 * 负责显示子类中所有属性值，包括子类中没有直接定义 的属性(父类中定义)
	 */

	@Override
	public String toString() {
		//显示以下样式
				/*
				 * <Button
				 *    andrid:id="@+id/btnLogin"
				 *    android:layout_width="wrap_content"
				 *    android:layout_height="wrap_content"
				 *    android:text="登陆"
				 * />
				 */
		StringBuffer sb = new StringBuffer("<");
		sb.append(this.getClass().getSimpleName()).append("\n");
		// 定义一个存放所有属性的空数组
		Field[] fields = {};
		/*
		 * 遍历当前类及其所有父类(Object除外)，取出这些 类中有值的属性,拼接到sb字符串变量中。
		 */
		for (Class clazz = this.getClass(); clazz != Object.class; clazz = clazz
				.getSuperclass()) {
			// 获取当前类的所有属性
			Field[] f = clazz.getDeclaredFields();
			// fields数组扩容，数组容量=fields.length+f.length
			fields = Arrays.copyOf(fields, fields.length + f.length);
			// 将f数组所有属性添加至fields中
			System.arraycopy(f, 0, fields, fields.length - f.length, f.length);
		}

		for (Field field : fields) {
			try {
				field.setAccessible(true);
				if (field == null || field.get(this) == null) {
					continue;
				}
				sb.append("    android:").append(field.getName()).append("=\"")
						.append(field.get(this).toString()).append("\"\n");
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("/>");

		return sb.toString();
	}
	public static void main(String[] args) {
		View view=new View();
		view.setBackgorund("black");
		view.setId("view");
		view.setLayout_height("44dp");
		view.setLayout_width("67dp");
		System.out.println(view);
	}
}
