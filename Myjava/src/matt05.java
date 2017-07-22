import java.lang.reflect.Constructor;

public class matt05 {
 //類別的回覆
	public static void main(String[] args) {
		String[] name= {"matt"};
		Class nameClass=name.getClass();
		System.out.println(nameClass.getName()); //傳回java.lang.String
		System.out.println(nameClass.isInterface());
		System.out.println(nameClass.isPrimitive());
		System.out.println(nameClass.isArray()); //測試是否陣列
		System.out.println(nameClass.getSuperclass().getName()); //看他爸爸
		System.out.println("-------------");
		
		Class strClass=String.class; //跳去string類別 並沒有賦予任何型別還是都是object還是要強制轉型  傳第一個class的東西 會自己new
		System.out.println(strClass.getName()); 
		System.out.println(strClass.isInterface());
		System.out.println(strClass.isPrimitive());
		System.out.println(strClass.isArray()); 
		System.out.println(strClass.getSuperclass().getName()); 
		System.out.println("-------------");
		
		try {                  //tw.matt.app01.matt051 //package name也要寫
		Class c1= Class.forName("matt051");  //載入該列別matt051 並不做任何
		c1.newInstance(); //相當於new出物件實體
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("-------------");
		try {
			Class c2=Class.forName("tw.matt.app01.matt01");
			System.out.println(c2.getName()); //本身的名稱
			System.out.println(c2.getPackage().getName());//package名
			  Constructor[] cs=c2.getConstructors();
			  
			  System.out.println(cs.length); //這邊要有4條 建構式
			  for(Constructor cc:cs) {
				  Class[] types=cc.getParameterTypes();
				   for(Class type:types) {
					   System.out.println(type.getName());
				   }
					System.out.println("-------------");
			  }
			  
			  c2.getEnclosingMethod(); //管理辦法的辦法
			  
			  System.out.println("-------------");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}

class matt051{  //自訂類別
	static {
		System.out.println("load matt051");
	}
	{
		System.out.println("matt051 matt obj");
	}
}
