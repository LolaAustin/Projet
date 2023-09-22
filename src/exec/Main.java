package exec;

import data.ActionBDDImpl;

public class Main {

	public static void main(String[] args) throws Exception{
        
        ActionBDDImpl actionDB = new ActionBDDImpl();
        Menu menu = new Menu(actionDB);
        menu.displayMenu();

	}
}
