// enum
public class matt04 {
	public static final int STOP=1;  //�I�s��kmatt.stop
	public static final int UP=2;
	public static final int DOWN=3;
	public static final int LEFT=4;
	public static final int RIGHT=5;
	public static void main(String[] args) {
			Zone zone1=Zone.area2; // �P�W���@���]4��zone�غc
			Zone zone2=Zone.area2;
			System.out.println(zone1.getCode());  //���M�Ϥ��@�˦�����b�x���ҥH�W����Ӧ��O�@�˪�area
			switch (zone2) { //�C�|�i�Hswith
			case area1:
				break;
			case area2:
				break;
			case area3:
				break;
			case area4:
				break;

			}
			
		int myDir=matt04.STOP;  //�I�s�覡 	 //�o�O�ĤG�ӽd�ҭ����@�����w����
		//�p�G�t�~�A���� �]�O�����w����
		switch (myDir) {
		case matt04.STOP:	
			break;
		case matt04.UP:	
			break;
		case matt04.RIGHT:
			break;
		case matt04.LEFT:
			break;
		case 123 :  //�S�C�|�N�������F �֤F�w��
		  break;
		}

	}
}
enum Dir{ //�w�q�u���o��  ���w�g���Anew�F�A�ۤv����new //�O�@�˪��Ʊ� //�o��W���w�gpublic�F�ҥH�o�䤣�μg
	STOP,UP,DOWN,RIGHT,LEFT
};

enum Zone{  //�]���غc���ҥHarea1��n���[�Ѽ�
	area1("401"),area2("402"),area3("403"),area4("404"); //�غc���n���� �C�|�û��O�Ĥ@�D
	private String code;
	private Zone(String code) { //�غc��
		//System.out.println("zone");
		this.code=code;
	}
	public String getCode() {
		return code;
	}
}