


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;





//javaBean  rule
//1.  Implement Serializable
//2.  Public class
//3.  field member can not a public
//4.  getter & serrter  ==>getXxx ,setXxx=>field xx
//5. none argument Constructor(default Constructor)

public class MemberV2 {	
	private String account, passwd, realname;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public MemberV2() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:9487/matt01", "root", "root");
	}
	public void setAccount(String account) {this.account=account;}
	public void setPasswd(String passwd) {this.passwd=passwd;}
	public void setRealname(String realname) {this.realname=realname;}
	public String getAccount() {return account;}
	public String getPasswd() {return passwd;}
	public String getRealname() {return realname;}

	public boolean newInsert() throws Exception {
		pstmt = conn.prepareStatement(
			"INSERT INTO member (account,passwd,realname) VALUES (?,?,?)");
		pstmt.setString(1, account);
		pstmt.setString(2, passwd);
		pstmt.setString(3, realname);
		int n = pstmt.executeUpdate();
		return n > 0;
	}
	
}
