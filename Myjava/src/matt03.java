import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class matt03 {

	public static void main(String[] args) {
	    matt031  obj1 =new matt031();  //這邊沒打好
	    obj1.m1();
	    matt032 obj2 =new matt032();
	    obj2.m1();
	    matt033 obj3 =new matt033();
	    obj3.m1();
	    matt035 obj4 =new matt035();
	    obj4.m1();
	    matt036  obj5=new matt036();
	    obj5.m1();
	}

}

// marker Annotation=>自己有提供資訊的
//interface myanno如果直接寫在下面不用寫public因為上面已經有了
@interface Debug{}

class matt031{
	@Debug
	void m1() {		
	}
}

@interface  Debug2{
	String value() ;
}

class matt032{
	@Debug2(value="debug2") //因為上面有傳會所以寫在這邊  //代表sv 40號 名子裡有字串的父類別annotation才能船參數
	void m1() {	
	}
}
class matt033{   //033跟 032一樣的
	@Debug2("debug2")
	void m1() {	}	
}
//傳遞多個值
@interface Debug3{
	String[] value(); //有定義無實做
}
class matt034{
	@Debug3(value= {"a1","a2","a3"})  //自訂參數放裡面
	void m1() {	
	}
}

@Retention(RetentionPolicy.RUNTIME)//宣告用來處理runtime的階段
@interface Debug4{
	String[] value() default"matt";  //多一個預設
}                                     //這三行式管理資料的資料 下面可能會帶值

class matt035{ //這邊可能會帶值  //想要拿到Dbug4的資料 但annotation也是物件 所要要取得Dbug4
	@Debug4(value= {"a","b","c"}) //跑自己的defalt 跑自己的註解
	public void m1() { //這邊不會被罵是因為db4有預設值
		try {           //getclass在類別載入時會載入 但偷吃步我們也常用類如forname 再matt05
		 Debug4  dbug4=getClass().getMethod("m1", null).getAnnotation(Debug4.class);
		 String[] values=dbug4.value();
		 for (String value : values) {
			System.out.println(value);
		}
		}catch (Exception e) {
		System.out.println(e.toString());
		}
	} 
	}

@Retention(RetentionPolicy.RUNTIME)  //用在runtime 有列舉概念
@interface Debug5{   //想表示出 上線 下線
	public enum Dir{ //定義只有這邊
		STOP,UP,DOWN,RIGHT,LEFT
	};
	
	Dir dir() default Dir.STOP;
	String[] names() default {"guest"};
	boolean isWinner() default false;
}

class matt036{
	@Debug5(
			dir=Debug5.Dir.LEFT,
			names= {"matt1","matt2"}
			
			)
	public void m1() {
	
		try {           //getclass在類別載入時會載入 但偷吃步我們也常用類如forname 再matt05
			 
			
			Debug5 debug5=getClass().getMethod("m1",null).getAnnotation(Debug5.class);
			
			
			 Enum dir2  =debug5.dir();
			System.out.println(dir2);
			
			
			 String[] names1=debug5.names();
			 for (String names : names1) {
				System.out.println(names);
			}
			}catch (Exception e) {
			System.out.println(e.toString());
			}
		
	}
}