

//Annotation =key,value =>metadata ²�满 �޲z��ƪ����
//1.compile Time
//2.�o��
//3.run time
//4.�榡:@Entity
//@Author(name="matt".data="2019/07/22")
//@Xxx(value="default")
//@Xxx("default")
//�H�U�i�h�ӦP��
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
	 void m11() {} // ����m11()�N�|�����F�p�G�S��@Override �b�s�@�ɴ����ѷ|���A���O
	 @Override
	void m1() {}
}
