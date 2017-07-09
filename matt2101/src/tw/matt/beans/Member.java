package tw.matt.beans;

import java.io.Serializable;

//javaBean  rule
//1.  Implement Serializable
//2.  Public class
//3.  field member can not a public
//4.  getter & serrter  ==>getXxx ,setXxx=>field xx
//5. none argument Constructor(default Constructor)

public class Member implements Serializable {
    private String id,name; //3.
    public Member() {
    	System.out.println("Member()");
    }  //沒有會自己 寫
    
    public Member(String id ,String name) {
    	System.out.println("Member(string,string)");
    	this.id=id ; this.name=name;
    }
    
    public void setId(String id) {this.id=id;}
    public void setName(String name) {this.name=name;}
    public String getId() {return id;}
    public String getName() {return name;}
    
    public void m1() {  //後面這邊邏輯比較多 所以字串
    	System.out.println("Member01()");
    }
    
    @Override
    public String toString() {
    	
    	return id+":"+name;
    }
}
