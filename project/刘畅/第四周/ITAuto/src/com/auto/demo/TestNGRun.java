package com.auto.demo;



import org.testng.TestNG;

public class TestNGRun {
	
	public static void runTest() {
		 TestNG testNG = new TestNG();

	        /**添加需要执行的测试类数组*/
	        testNG.setTestClasses(new Class[]{Test1.class});
	        /**执行测试用例*/
	        testNG.run();
		    
		
	}

}
