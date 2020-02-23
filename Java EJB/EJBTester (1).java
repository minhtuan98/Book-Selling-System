package edu.tdt.test;
import edu.tdt.persistence.Taikhoan;
import edu.tdt.persistence.ShopBean;
import edu.tdt.persistence.ShopBeanRemote;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class EJBTester {
private Properties props;
private InitialContext ctx;
    
    public EJBTester()
    {
    readJNDI();
    }
/**
* Read the JNDI properties file
*/
    private void readJNDI()
    {
    props = new Properties();
        try
        {
            props.load(new FileInputStream("jndi.properties"));
        } catch(IOException e)
        {
            System.err.println(e.toString());
        }
            try
        {
            ctx = new InitialContext(props);
            //ctx.close();
        } catch (NamingException ex)
        {
            ex.getMessage();
        }
    }
/**
* Construct and return the JNDI address of called class
* @return String
*/
    private String getJNDI()
    {
    String appName = "";
    String moduleName = "SampleEJB1";
    String distinctName = "";
    String sessionBeanName = ShopBean.class.getSimpleName();
    String viewClassName = ShopBeanRemote.class.getName()+ "?stateful";
    return "ejb:"+appName+"/"+moduleName+"/"+distinctName+"/"+sessionBeanName+"!"+viewClassName;
    }
/**
* Show the GUI in console window
*/
    private void showGUI()
    {
        System.out.println("\n=========================");
        System.out.println("Welcome to TDTU Bookstore");
        System.out.println("=========================");
        System.out.print("Options: \n1. Add Book \n2. List All Books (Current Session) \n3. List AllBooks (New Session) \n4. Exit \nEnter Choice: ");
    }
/**
* Declare a bean to invoke getBooks() method in LibrarySessionBeanRemote
*/
    
/**
* Test the Stateless EJB
*/
    public void testEntityEJB()
    {
    try
    {
    // Scanner definition
        Scanner sc = new Scanner(System.in);
    // Lookup the LibrarySessionBeanRemote
        ShopBeanRemote libBean = (ShopBeanRemote) ctx.lookup(getJNDI());
        int choice = 0;
        System.out.println("Hello");
    
        sc.close();
    } catch (NamingException ex)
    {
        ex.getMessage();
    }
}
}