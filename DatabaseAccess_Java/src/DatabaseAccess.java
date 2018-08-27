/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author shireen
 */
public class DatabaseAccess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            System.out.println("Welcome to the Library Database");
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
        while(true){
        System.out.println("Query 1: Select 1 for the highest rated books");
        System.out.println("Query 2: Select 2 for the author that customers most commonly read");
        System.out.println("Query 3: Select 3 for books that have been borrowed in March");
        System.out.println("Query 4: Select 4 for devices that have been borrowed in March");
        System.out.println("Query 5: Select 5 for devices that customers most commonly use");
        System.out.println("Query 6: Select 6 for the employee with highest salary");
        System.out.println("Query 7: Select 7 for the most commonly read genre");
        System.out.println("Query 8: Select 8 for the customer with the highest fine");
        System.out.println("Query 9: Select 9 for the customer that borrows same author's books often");
        System.out.println("Query 10: Select 10 for the customer that reads the most");

        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 1){
            ResultSet rs = stmt.executeQuery("SELECT Title FROM Books WHERE Rating = (SELECT max(Rating) FROM Books);");
                                while(rs.next())
                                {
                                    String Titl = rs.getString("Title");
                                    System.out.println(String.format("\t%-10s" , Titl));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 2){
            ResultSet rs = stmt.executeQuery("SELECT Author FROM Books\n" +
            "GROUP BY Author\n" +
            "HAVING COUNT(*) = (SELECT MAX (Count)\n" +
            "FROM (SELECT COUNT(*) as Count FROM Books GROUP BY Author) \n" +
            "tmp);");
                                while(rs.next())
                                {
                                    String Auth = rs.getString("Author");
                                    System.out.println(String.format("\t%-10s" , Auth));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 3){
            ResultSet rs = stmt.executeQuery("SELECT bookTitle FROM IssueStatus WHERE issueDate = 'March' AND bookISBN NOT LIKE 'Not Applicable';");
                                while(rs.next())
                                {
                                    
                                    String bkTitle = rs.getString("bookTitle");
                                    System.out.println(String.format("\t%-10s" , bkTitle));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 4){
            ResultSet rs = stmt.executeQuery("SELECT deviceName FROM IssueStatus\n" +
            "WHERE issueDate = 'March' AND deviceName NOT LIKE 'Not Applicable';");
                                while(rs.next())
                                {
                                    String deviName = rs.getString("deviceName");
                                    System.out.println(String.format("\t%-10s" , deviName));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 5){
            ResultSet rs = stmt.executeQuery("SELECT devName FROM Devices\n" +
            "GROUP BY devName\n" +
            "HAVING COUNT(*) = (SELECT MAX (Count)\n" +
            "FROM (SELECT COUNT(*) as Count FROM Devices GROUP BY devName) \n" +
            "tmp);");
                                while(rs.next())
                                {
                                    String devNam = rs.getString("devName");
                                    System.out.println(String.format("\t%-10s" , devNam));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 6){
            ResultSet rs = stmt.executeQuery("SELECT empName FROM Employee\n" +
            "WHERE Salary = (SELECT max(Salary) FROM Employee);");
                                while(rs.next())
                                {
                                    String empNam = rs.getString("empName");
                                    System.out.println(String.format("\t%-10s" , empNam));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 7){
            ResultSet rs = stmt.executeQuery("SELECT Genre FROM Books\n" +
            "GROUP BY Genre\n" +
            "HAVING COUNT(*) = (SELECT MAX (Count)\n" +
            "FROM (SELECT COUNT(*) as Count FROM Books GROUP BY Genre) \n" +
            "tmp) AND bkStatus NOT LIKE 'Available';");
                                while(rs.next())
                                {
                                    String Genr = rs.getString("Genre");
                                    System.out.println(String.format("\t%-10s" , Genr));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 8){
            ResultSet rs = stmt.executeQuery("SELECT cusName FROM Customer\n" +
            "WHERE fineFee = (SELECT max(fineFee) FROM Customer);");
                                while(rs.next())
                                {
                                    String cusNam = rs.getString("cusName");
                                    System.out.println(String.format("\t%-10s" , cusNam));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 9){
            ResultSet rs = stmt.executeQuery("SELECT Customer.cusName FROM Customer INNER JOIN Books ON Customer.cusID = Books.cusID\n" +
            "GROUP BY Author\n" +
            "HAVING COUNT(*) = (SELECT MAX (Count)\n" +
            "FROM (SELECT COUNT(*) as Count FROM Books GROUP BY Author) \n" +
            "tmp) AND (SELECT DISTINCT cusID FROM Books);");
                                while(rs.next())
                                {
                                    String custNam = rs.getString("cusName");
                                    System.out.println(String.format("\t%-10s" , custNam));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {  
            Class.forName("org.sqlite.JDBC");  
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:/Users/shireen/library.db"); 
            Statement stmt = c.createStatement();
            if (in == 10){
            ResultSet rs = stmt.executeQuery("SELECT Customer.cusName FROM Customer INNER JOIN Books ON Customer.cusID = Books.cusID\n" +
            "GROUP BY Books.cusID\n" +
            "HAVING COUNT(*) = (SELECT MAX (Count)\n" +
            "FROM (SELECT COUNT(*) as Count FROM Books GROUP BY cusID) \n" +
            "tmp) AND bkStatus NOT LIKE 'Available';");
                                while(rs.next())
                                {
                                    String custName = rs.getString("cusName");
                                    System.out.println(String.format("\t%-10s" , custName));
                                }
                                rs.close();
                                c.close();
            }
                    }catch ( ClassNotFoundException e ) {      
                        e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        }        
    }     
}
    
