// enum
public class matt04 {
	public static final int STOP=1;  //呼叫方法matt.stop
	public static final int UP=2;
	public static final int DOWN=3;
	public static final int LEFT=4;
	public static final int RIGHT=5;
	public static void main(String[] args) {
			Zone zone1=Zone.area2; // 與上面一次跑4個zone建構
			Zone zone2=Zone.area2;
			System.out.println(zone1.getCode());  //雖然區不一樣但都住在台中所以上面兩個住的是一樣的area
			switch (zone2) { //列舉可以swith
			case area1:
				break;
			case area2:
				break;
			case area3:
				break;
			case area4:
				break;

			}
			
		int myDir=matt04.STOP;  //呼叫方式 	 //這是第二個範例重維護忽略安全性
		//如果另外再給值 也是忽略安全性
		switch (myDir) {
		case matt04.STOP:	
			break;
		case matt04.UP:	
			break;
		case matt04.RIGHT:
			break;
		case matt04.LEFT:
			break;
		case 123 :  //沒列舉就不報錯了 少了安全
		  break;
		}

	}
}
enum Dir{ //定義只有這邊  都已經幫你new了你自己不能new //是一樣的事情 //這邊上面已經public了所以這邊不用寫
	STOP,UP,DOWN,RIGHT,LEFT
};

enum Zone{  //因為建構式所以area1後要面加參數
	area1("401"),area2("402"),area3("403"),area4("404"); //建構式要分號 列舉永遠是第一道
	private String code;
	private Zone(String code) { //建構式
		//System.out.println("zone");
		this.code=code;
	}
	public String getCode() {
		return code;
	}
}