package com.selenium_framework.common;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class AbstractSelenium {

	@DataProvider(name="CSVData")
	public String[][] getCSVData() throws IOException {
		File fp=new File("C:\\Users\\Komal\\Desktop\\LoginData.txt");
		String[][] myData = new String[3][2];
		FileReader fr= new FileReader(fp);
		BufferedReader br= new BufferedReader(fr);
		String line = "";
		int i=0;
		while((line=br.readLine())!=null){
		
			myData[i]=line.split(",");
			i=i+1;	
		} 
		return myData;
	}
	
	@DataProvider(name="ExcelData")
	public String[][] getExcelData(Method m) throws Throwable {
		System.out.println("*****Running method is -"+m.getName());
			return ExcelReader.getExcelTableArray("E:\\Selenium Project\\selenium-framework\\src\\test\\java\\com\\orangehrm\\test\\LoginTest.xlsx", m.getName());
		
	}
	
	@BeforeTest
	public void callCreateWebDriverInstance(){
		WebDriverFactory.createWebdriverInstance();
	}
	
	@DataProvider(name="LoginData")
	public String[][] getLoginData(){
		String myData[][]={{"admin","admmin"},{"swapnil","swapnil"},{"amit","amit"}};
		return myData;
	}
	
	private static String getFilePath(Class<?> cls){
		System.out.println("******** getFilePath for class "+cls.getName());
		String strSourceClassName = cls.getResource(cls.getSimpleName()+".class").getPath();
		System.out.println("*************** resource path is "+strSourceClassName);
		try {
			strSourceClassName = URLDecoder.decode(strSourceClassName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer strFilePath = new StringBuffer();
		strFilePath.append(strSourceClassName.subSequence(1, strSourceClassName.indexOf("com")));
		strFilePath.append(cls.getName().replace(".","/"));
		strFilePath.append(".xlsx");
		System.out.println("Class path is - "+strFilePath);
		//return strFilePath.toString();
		return strSourceClassName.replace(".class", ".xlsx");
	}
	
}
