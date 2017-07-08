package tw.matt.j2ee;

public class Member {
    private String name;
    private int age;
    public Member(String name,int age) {
    	this.name=name; this.age=age;
    }
    public String getname() {
    	return name;
    	
    }
    public int getage() {
    	return age;
    }
}
