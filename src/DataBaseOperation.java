import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataBaseOperation {
       
   
public static void InsertCliData() {
  // TODO Auto-generated method stub
    String sql="insert into customeritem(id,name,sex,age,singleprice,sale,profit) "
      + "values (?,?,?,?,?, ?, ?)";  
          Connection conn=null;  
        PreparedStatement pstmt=null;  
       
        try{  
          Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","root");
            //׼��ִ��sql���
            pstmt=conn.prepareStatement(sql);          
            //��ȡxml�ļ�  
            Document doc=new SAXReader().read(new InputStreamReader(new FileInputStream(new File("client.xml")),"utf-8"));  
            //ѡ��xml�ļ��Ľڵ�  
           // Element node = doc.getRootElement(); 
            List itemList=doc.selectNodes("class/client");  
            //����������xml�еĽڵ�   
            for(Iterator iter=itemList.iterator();iter.hasNext();){  
                Element el=(Element)iter.next();  
                //��ȡ�ڵ�����  
                String id=el.elementText("id");                    
                String name = el.elementText("name");  
                String sex = el.elementText("sex");  
                String age = el.elementText("age");
                String singleprice = el.elementText("singleprice");
                String sale = el.elementText("sale");
                String profit = el.elementText("profit");                            
         
                //Ϊsql��丳ֵ  
                pstmt.setString(1, id);  
                pstmt.setString(2, name);  
                pstmt.setString(3, sex);  
                pstmt.setString(4, age);  
                pstmt.setString(5, singleprice);  
                pstmt.setString(6, sale);  
                pstmt.setString(7, profit);  
           
                pstmt.addBatch();  
            }   
            pstmt.executeBatch();  
            pstmt.close();
           conn.close();
        }
        //����������������쳣  
        catch ( ClassNotFoundException cnfex ) {  
            System.err.println(  
            "װ�� JDBC/ODBC ��������ʧ�ܡ�" );  
            cnfex.printStackTrace();   
        }   
        //�����������ݿ��쳣  
        catch ( SQLException sqlex ) {  
            System.err.println( "�޷��������ݿ�" );  
            sqlex.printStackTrace();   
        }  
        catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            
        }           
 }

 
 
 public static void InsertProData() {
	  // TODO Auto-generated method stub
	    String sql="insert into productitem(id,name,specification,stock,singleprice,purchaseprice,currentsale) " + "values (?,?,?,?,?, ?,?)";  
	        Connection conn=null;  
	        PreparedStatement pstmt=null;  
	    
	        try{  
	          Class.forName("com.mysql.jdbc.Driver");
	            conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/crm","root","root");
	            //׼��ִ��sql���
	            pstmt=conn.prepareStatement(sql);          
	            //��ȡxml�ļ�  
	            Document doc=new SAXReader().read(new InputStreamReader(
	              new FileInputStream(new File("product.xml")),"utf-8"));  
	            //ѡ��xml�ļ��Ľڵ�  
	           // Element node = doc.getRootElement(); 
	            List itemList=doc.selectNodes("class/product");  
	            //����������xml�еĽڵ�  
	            for(Iterator iter=itemList.iterator();iter.hasNext();){  
	                Element el=(Element)iter.next();  
	                //��ȡ�ڵ�����  
	                String id =el.elementText("id");                    
	                String name = el.elementText("name");  
	                String specification = el.elementText("specification");  
	                String stock = el.elementText("stock");
	                String singleprice = el.elementText("singleprice");
	                String purchaseprice = el.elementText("purchaseprice");
	                String currentsale = el.elementText("currentsale");
	                 	            
	                //Ϊsql��丳ֵ  
	                pstmt.setString(1, id);  
	                pstmt.setString(2, name);  
	                pstmt.setString(3, specification);  
	                pstmt.setString(4, stock);  
	                pstmt.setString(5, singleprice);  
	                pstmt.setString(6, purchaseprice);  
	                pstmt.setString(7, currentsale); 
	                pstmt.addBatch();  
	            }   
	            pstmt.executeBatch();  
	            pstmt.close();
	           conn.close();
	        }
	        //����������������쳣  
	        catch ( ClassNotFoundException cnfex ) {  
	            System.err.println(  
	            "װ�� JDBC/ODBC ��������ʧ�ܡ�" );  
	            cnfex.printStackTrace();   
	        }   
	        //�����������ݿ��쳣  
	        catch ( SQLException sqlex ) {  
	            System.err.println( "�޷��������ݿ�" );  
	            sqlex.printStackTrace();   
	        }  
	        catch(Exception e){  
	            e.printStackTrace();  
	        }finally{  
	            
	        }           
	 }
 public static void InsertTradeData() {
	  // TODO Auto-generated method stub
	    String sql="insert into tradeitem(id,name,product,num,singleprice,Totalprice,Profit) " + "values (?,?,?,?,?, ?, ?)";  
	        Connection conn=null;  
	        PreparedStatement pstmt=null;  
	        
	        try{  
	          Class.forName("com.mysql.jdbc.Driver");
	            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","root");
	            //׼��ִ��sql���
	            pstmt=conn.prepareStatement(sql);          
	            //��ȡxml�ļ�  
	            Document doc=new SAXReader().read(new InputStreamReader(
	              new FileInputStream(new File("Trade.xml")),"utf-8"));  
	            //ѡ��xml�ļ��Ľڵ�  
	           // Element node = doc.getRootElement(); 
	            List itemList=doc.selectNodes("class/record");  
	            //����������xml�еĽڵ�   	      
	            for(Iterator iter=itemList.iterator();iter.hasNext();){  
	                Element el=(Element)iter.next();  
	                //��ȡ�ڵ�����  
	                String id =el.elementText("id");                    
	                String name = el.elementText("name");  
	                String product = el.elementText("product");  
	                String num = el.elementText("num");
	                String singleprice = el.elementText("singleprice");
	                String Totalprice = el.elementText("Totalprice");
	                String Profit = el.elementText("Profit");
	                 	            
	                //Ϊsql��丳ֵ  
	                pstmt.setString(1, id);  
	                pstmt.setString(2, name);  
	                pstmt.setString(3, product);  
	                pstmt.setString(4, num);  
	                pstmt.setString(5, singleprice);  
	                pstmt.setString(6, Totalprice);  
	                pstmt.setString(7, Profit);  
	                pstmt.addBatch();  
	            }   
	            pstmt.executeBatch();  
	            pstmt.close();
	           conn.close();
	        }
	        //����������������쳣  
	        catch ( ClassNotFoundException cnfex ) {  
	            System.err.println(  
	            "װ�� JDBC/ODBC ��������ʧ�ܡ�" );  
	            cnfex.printStackTrace();   
	        }   
	        //�����������ݿ��쳣  
	        catch ( SQLException sqlex ) {  
	            System.err.println( "�޷��������ݿ�" );  
	            sqlex.printStackTrace();   
	        }  
	        catch(Exception e){  
	            e.printStackTrace();  
	        }finally{  
	            
	        }           
	 }
 
 public static void DeleteCliData() {
	 String god ="delete from customeritem";
	 Connection conn=null;  
     
     try{  
       Class.forName("com.mysql.jdbc.Driver");
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","root");
         //׼��ִ��sql���
        Statement stmt =conn.createStatement();
        stmt.executeUpdate(god);

        conn.close();
     }
     catch( ClassNotFoundException cnfex ) {  
         System.err.println(  
         "װ�� JDBC/ODBC ��������ʧ�ܡ�" );  
         cnfex.printStackTrace();   
     }   
     //�����������ݿ��쳣  
     catch ( SQLException sqlex ) {  
         System.err.println( "�޷��������ݿ�" );  
         sqlex.printStackTrace();   
     }  
     catch(Exception e){  
         e.printStackTrace();  
     }finally{  
         
     }     
         
 }
 public static void DeleteProData() {
	 String god ="delete from productitem";
	 Connection conn=null; 
	 try{  
	       Class.forName("com.mysql.jdbc.Driver");
	         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","root");
	         //׼��ִ��sql���
	        Statement stmt =conn.createStatement();
	        stmt.executeUpdate(god);

	        conn.close();
	     }
	     catch( ClassNotFoundException cnfex ) {  
	         System.err.println(  
	         "װ�� JDBC/ODBC ��������ʧ�ܡ�" );  
	         cnfex.printStackTrace();   
	     }   
	     //�����������ݿ��쳣  
	     catch ( SQLException sqlex ) {  
	         System.err.println( "�޷��������ݿ�" );  
	         sqlex.printStackTrace();   
	     }  
	     catch(Exception e){  
	         e.printStackTrace();  
	     }finally{  
	         
	     }     
 }
 public static void DeleteTradeData() {
	 String god ="delete from tradeitem";
	 Connection conn=null; 
	 try{  
	       Class.forName("com.mysql.jdbc.Driver");
	         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","root");
	         //׼��ִ��sql���
	        Statement stmt =conn.createStatement();
	        stmt.executeUpdate(god);
	        conn.close();
	     }
	     catch( ClassNotFoundException cnfex ) {  
	         System.err.println(  
	         "װ�� JDBC/ODBC ��������ʧ�ܡ�" );  
	         cnfex.printStackTrace();   
	     }   
	     //�����������ݿ��쳣  
	     catch ( SQLException sqlex ) {  
	         System.err.println( "�޷��������ݿ�" );  
	         sqlex.printStackTrace();   
	     }  
	     catch(Exception e){  
	         e.printStackTrace();  
	     }finally{  
	         
	     }     
 }
}


