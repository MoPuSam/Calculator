package jsj.tysf;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testOpration {
	Add a=null;
	@BeforeClass
	public static void BeforeClass(){
		System.out.println("在类加载之前");
	}
	@Before
	public void duiXiang(){
		System.out.println("Before执行");
		a=new Add();
	}
	@Test
	public void add(){
		System.out.println(a.operator(10, 12));
	}
	@After
	public void afterMethod(){
		System.out.println("After执行");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("在类卸载之后");
	}
}
