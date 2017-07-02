package tw.matt.j2ee;

public class mattAPI {
//這邊主要是在給matt13用主要是抓黨名,不同伺服器用
	public static String getHeaderFileName (String header) {
      int start =header.indexOf("filename");
      String temp = header.substring(start+10);
    		  String filename = temp.substring(0,temp.lastIndexOf("\"")); //抓雙影號
    		  int s1 = filename.lastIndexOf("\\");
    		  String sfile =null;
    		  if (s1>=0) {
    		  sfile = filename.substring(filename.lastIndexOf("\\")+1);
    		  }else {
    			  sfile=filename;
    		  }
             return sfile; 
	}

}
