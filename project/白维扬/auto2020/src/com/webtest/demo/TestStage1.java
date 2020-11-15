package com.webtest.demo;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebTestListener;

@Listeners(WebTestListener.class)
public class TestStage1 {
	@Test
	public void test1() {
		assertEquals(1, 1);
	}

	@Test
	public void test2() {
		assertEquals(1, 2);
	}

	@Test
	public void test3() {
		assertEquals(2, 1);
	}

	@Test
	public void test4() {
		assertEquals(2, 2);
	}

	@Test
	public void test5() {
		assertEquals(5, 5);
	}
	@Test
	public void test6() {
		int[] arr = new int[3];
		System.out.println(arr[4]);
	}
}
