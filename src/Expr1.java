import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;


public class Expr1 {
	public static void main(String[] args) {
		String str = "expr 6 = 5" ;
		executeExpr(str);  
		str = "expr 6 > 50" ;
		executeExpr(str);  
		
		str = "expr '6' > 50" ;
		executeExpr(str);  
		 System.out.println("---------------if one of them is string,compare with string");  
		 str = "expr 6 > '50'" ;
	      executeExpr(str);  
	System.out.println("---------------if one of them is string,compare with string");  
	
	 str = "expr '6' > '50'" ;
     executeExpr(str);

	 str = "expr 6a > 50a" ;
     executeExpr(str);  
     
     System.out.println("---------------check and");  
     
     str = "expr 6a > 50a & 7 > 2" ;
     executeExpr(str);  
     str = "expr 6a > 50a & 7 > 12" ;
     executeExpr(str);  
     str = "expr 6a > 70a & 7 > 2" ;
     executeExpr(str);  		 		 
     System.out.println("---------------check and  ok"); 
     
 System.out.println("---------------check or");  
     
     str = "expr 6a > 50a | 7 > 2" ;
     executeExpr(str);  
     str = "expr 6a > 50a | 7 > 12" ;
     executeExpr(str);  
     str = "expr 6a > 70a | 7 > 2" ;
     executeExpr(str);  
     str = "expr 6a > 70a | 7 > 12" ;
     executeExpr(str);  
     
     System.out.println("---------------check or  ok"); 
     
     System.out.println("---------------check regex"); 
     str = "expr 123qwe567 : '.*(qwa).*'" ;
     executeExpr(str);  
     str = "expr `123qwe567 : '.*(qw).*'`" ;
     executeExpr(str);  
     str = "expr `123qwe567 : 'qw'`" ;
     executeExpr(str);  
     str = "expr 123qwe567 : .*qw.*" ;
     executeExpr(str);  
     
     str = "expr 123qwe567 : 123qw.*" ;
     executeExpr(str);  
     
     str = "expr 123qwe567 : 123qw.*" ;
     executeExpr(str);  
     str = "expr 123qwe567 : .*567" ;
     executeExpr(str);  
     str = "expr 123qwe567 : .*467" ;
     executeExpr(str);  
     str = "expr 123qwe567 : *67" ;
     executeExpr(str);  
     System.out.println("---------------check regex OK * must work with ."); 
     
     System.out.println("---------------check regex and normal"); 
     str = "expr 123qwe567 : .*67 & 6 > 10" ;
     executeExpr(str);  
     
     str = "expr 123qwe567 : .*67 | 123qwe567 : .*67 | 60 > 10" ;
     executeExpr(str);  
     str = "expr 60 > 10 | 123qwe567 : .*67 " ;
     executeExpr(str);  
     str = "expr 60 > 10 & 123qwe567 : .*67 " ;
     executeExpr(str);  
     str = "expr 60 > 10 & 123qwe567 : .*67 " ;
     executeExpr(str);  
     System.out.println("---------------check regex and normal ok  if all ok return first result"); 
     
     String expr = " &1 > '6' ";
     String var1 = "50" ;
     String var2 ="";
     String reprNew = "expr "+StringUtils.replace(expr,"&1",var1);
     executeExpr(reprNew);  
     
      expr = " &1 > 6 ";
      var1 = "50" ;
      reprNew = "expr "+StringUtils.replace(expr,"&1",var1);
     executeExpr(reprNew);  
     

     reprNew = "&1 > 6 & &2 : .*67 ";
     var1 = "50" ;
     var2 = "123qwe567" ;
     reprNew = StringUtils.replace(reprNew,"&1",var1);
    System.out.println(reprNew);
     reprNew = StringUtils.replace(reprNew,"&2",var2);
     System.out.println(reprNew);
//     reprNew = "expr"+reprNew
     executeOnlyExpr(reprNew);  

     reprNew = "&1 > 60 & &2 : .*67 ";
     var1 = "50" ;
     var2 = "123qwe567" ;
     reprNew = StringUtils.replace(reprNew,"&1",var1);
    System.out.println(reprNew);
     reprNew = StringUtils.replace(reprNew,"&2",var2);
     System.out.println(reprNew);
//     reprNew = "expr"+reprNew
     executeOnlyExpr(reprNew);  
     System.out.println("=======================");
     String substr = "expr substr 'Goodnight Ladies' 11 6";
     executeExpr(substr);  
     
	}

	private static void executeExpr(String cmdstr) {
//		String cmdstr = "expr 6 = 5";
		 Process process = null;  
		
	        List<String> processList = new ArrayList<String>();  
	        try {  
	            process = Runtime.getRuntime().exec(cmdstr);  
	            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));  
	            String line = "";  
	            while ((line = input.readLine()) != null) {  
	                processList.add(line);  
	            }  
	            input.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	  
	        for (String line : processList) {  
	            System.out.println(cmdstr+"  result:"+line);  
	        }
	}
	
	private static void executeOnlyExpr(String cmdstr) {
		cmdstr = "expr "+cmdstr;
		 Process process = null;  
		
	        List<String> processList = new ArrayList<String>();  
	        try {  
	            process = Runtime.getRuntime().exec(cmdstr);  
	            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));  
	            String line = "";  
	            while ((line = input.readLine()) != null) {  
	                processList.add(line);  
	            }  
	            input.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	  
	        for (String line : processList) {  
	            System.out.println(cmdstr+"  result:"+line);  
	        }
	}
	
}
