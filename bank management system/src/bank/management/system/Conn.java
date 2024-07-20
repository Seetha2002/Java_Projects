
package bank.management.system;
import java.sql.*;

//JDBC connection has five steps
//first one is Register the driver
//second one create connection
//Third one create statement
//Fourth one Execute query
//fifth one Close Connection
public class Conn {
    Connection c; //creating an object for Connection class
    Statement s;
    public Conn(){
        try{  //mysql is an external entity therfore there are chances of getting an error in run time, so we should catch the exceptions
           // Class.forName(com.mysql.cj.jdbc.Driver);//This is the step for registering a driver. There is a class named Class and a static method in it called forName we use that method to register the driver and the driver name is com.mysql.cj.jdbc.Driver
            //now we added the mysql connector in the library therfore there is no need of externally registering the driver
           c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Seetha@2002");// step for creating connection
            s=c.createStatement();//statement creation
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
        
    
}
