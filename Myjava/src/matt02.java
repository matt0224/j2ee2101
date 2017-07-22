

//Annotation =key,value =>metadata 簡單說 管理資料的資料
//1.compile Time
//2.發布
//3.run time
//4.格式:@Entity
//@Author(name="matt".data="2019/07/22")
//@Xxx(value="default")
//@Xxx("default")
//以下可多個同時
//@Author(matt1)
//@Author(matt2)
//@Author(matt3)
public class matt02 {

	public static void main(String[] args) {
            Test1 obj1=new Test1();
            obj1.m1();
            obj1.m2();
	}

}

class Test1 {
	void m1() {}
		@Deprecated
	void m2() {}	
	
}
class Test2 extends Test1{
	 //@Override
	 void m11() {} // 打成m11()就會提醒了如果沒有@Override 在編一時期註解會幫你註記
	 @Override
	void m1() {}
}
