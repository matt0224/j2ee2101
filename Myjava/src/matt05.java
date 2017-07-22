import java.lang.reflect.Constructor;

public class matt05 {
 //���O���^��
	public static void main(String[] args) {
		String[] name= {"matt"};
		Class nameClass=name.getClass();
		System.out.println(nameClass.getName()); //�Ǧ^java.lang.String
		System.out.println(nameClass.isInterface());
		System.out.println(nameClass.isPrimitive());
		System.out.println(nameClass.isArray()); //���լO�_�}�C
		System.out.println(nameClass.getSuperclass().getName()); //�ݥL����
		System.out.println("-------------");
		
		Class strClass=String.class; //���hstring���O �èS���ᤩ���󫬧O�٬O���Oobject�٬O�n�j���૬  �ǲĤ@��class���F�� �|�ۤvnew
		System.out.println(strClass.getName()); 
		System.out.println(strClass.isInterface());
		System.out.println(strClass.isPrimitive());
		System.out.println(strClass.isArray()); 
		System.out.println(strClass.getSuperclass().getName()); 
		System.out.println("-------------");
		
		try {                  //tw.matt.app01.matt051 //package name�]�n�g
		Class c1= Class.forName("matt051");  //���J�ӦC�Omatt051 �ä�������
		c1.newInstance(); //�۷��new�X�������
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("-------------");
		try {
			Class c2=Class.forName("tw.matt.app01.matt01");
			System.out.println(c2.getName()); //�������W��
			System.out.println(c2.getPackage().getName());//package�W
			  Constructor[] cs=c2.getConstructors();
			  
			  System.out.println(cs.length); //�o��n��4�� �غc��
			  for(Constructor cc:cs) {
				  Class[] types=cc.getParameterTypes();
				   for(Class type:types) {
					   System.out.println(type.getName());
				   }
					System.out.println("-------------");
			  }
			  
			  c2.getEnclosingMethod(); //�޲z��k����k
			  
			  System.out.println("-------------");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}

class matt051{  //�ۭq���O
	static {
		System.out.println("load matt051");
	}
	{
		System.out.println("matt051 matt obj");
	}
}
