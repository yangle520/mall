package com.yangle.utils;

import java.math.BigDecimal;

public class NumberUtil {

	public static <T extends Comparable<T>> T max(T a, T b) {
		if (a.compareTo(b) > 0) {
			return a;
		} else {
			return b;
		}
	}

	public static <T extends Comparable<T>> T min(T a, T b) {
		if (a.compareTo(b) < 0) {
			return a;
		} else {
			return b;
		}
	}

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		String aa = "aa";
		String bb = "bb";
		BigDecimal d = BigDecimal.ZERO;
		BigDecimal f = BigDecimal.ONE;
		System.out.println(NumberUtil.max(aa, bb));
		System.out.println(NumberUtil.max(a, b));
		System.out.println(NumberUtil.max(d, f));

		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program" + "ming";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s1.intern());
	}
}
