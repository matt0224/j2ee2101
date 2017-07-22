import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class matt03 {

	public static void main(String[] args) {
	    matt031  obj1 =new matt031();  //�o��S���n
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

// marker Annotation=>�ۤv�����Ѹ�T��
//interface myanno�p�G�����g�b�U�����μgpublic�]���W���w�g���F
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
	@Debug2(value="debug2") //�]���W�����Ƿ|�ҥH�g�b�o��  //�N��sv 40�� �W�l�̦��r�ꪺ�����Oannotation�~���Ѽ�
	void m1() {	
	}
}
class matt033{   //033�� 032�@�˪�
	@Debug2("debug2")
	void m1() {	}	
}
//�ǻ��h�ӭ�
@interface Debug3{
	String[] value(); //���w�q�L�갵
}
class matt034{
	@Debug3(value= {"a1","a2","a3"})  //�ۭq�ѼƩ�̭�
	void m1() {	
	}
}

@Retention(RetentionPolicy.RUNTIME)//�ŧi�ΨӳB�zruntime�����q
@interface Debug4{
	String[] value() default"matt";  //�h�@�ӹw�]
}                                     //�o�T�榡�޲z��ƪ���� �U���i��|�a��

class matt035{ //�o��i��|�a��  //�Q�n����Dbug4����� ��annotation�]�O���� �ҭn�n���oDbug4
	@Debug4(value= {"a","b","c"}) //�]�ۤv��defalt �]�ۤv������
	public void m1() { //�o�䤣�|�Q�|�O�]��db4���w�]��
		try {           //getclass�b���O���J�ɷ|���J �����Y�B�ڭ̤]�`�����pforname �Amatt05
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

@Retention(RetentionPolicy.RUNTIME)  //�Φbruntime ���C�|����
@interface Debug5{   //�Q��ܥX �W�u �U�u
	public enum Dir{ //�w�q�u���o��
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
	
		try {           //getclass�b���O���J�ɷ|���J �����Y�B�ڭ̤]�`�����pforname �Amatt05
			 
			
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