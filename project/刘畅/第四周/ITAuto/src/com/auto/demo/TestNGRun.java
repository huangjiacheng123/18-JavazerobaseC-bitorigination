package com.auto.demo;



import org.testng.TestNG;

public class TestNGRun {
	
	public static void runTest() {
		 TestNG testNG = new TestNG();

	        /**�����Ҫִ�еĲ���������*/
	        testNG.setTestClasses(new Class[]{Test1.class});
	        /**ִ�в�������*/
	        testNG.run();
		    
		
	}

}
