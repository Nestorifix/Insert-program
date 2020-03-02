import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
public class Main {
    
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        //Variables needed to operate sql functions and connections
        Connection con;
        Statement st;
        PreparedStatement pst;
        ResultSet rs;
        
        
        //Connection of java and mysql
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename","root","");
            st = con.createStatement();
        
        String Name; //Variable for inputs in column 1
        int Age; //Variable for inputs in column 2
        String Course; //Variable for inputs in column 3
        
        
        System.out.println("Enter Name: ");
        System.out.println("Enter Age: ");
        System.out.println("Enter Course: ");
        
        System.out.println("");
        Name = scan.next();
        System.out.println("");
        Age = scan.nextInt();
        System.out.println("");
        Course = scan.next();
        
        try{
        String sql = "INSERT INTO `tablename` (`column1name`, `column2name`, `column3name`) VALUES (?, ?, ?)";//no. of "?" is equal to no. of inputs
        pst = con.prepareStatement(sql);
        pst.setString(1, Name);
        pst.setInt(2, Age);
        pst.setString(3, Course);
        pst.executeUpdate();
        
        System.out.print("Insert Successful!");
        
        }catch(Exception e){
            System.out.print("Error in insert" + e);
        }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error in MySQL Connection", WARNING_MESSAGE);
        }
    }
    
}
