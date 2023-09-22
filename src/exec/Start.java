package exec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.ActionBDDImpl;


/**
 * This class represents the starting point of your program.
 */
public class Start {
    
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        
        ActionBDDImpl actionDB = new ActionBDDImpl();
        Menu menu = new Menu(actionDB);
        menu.displayMenu();

        
    }


}
