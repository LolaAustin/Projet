package exec;

import javax.swing.SwingUtilities;

import data.ActionBDDImpl;

public class Main {

	public static void main(String[] args){

        SwingUtilities.invokeLater(() -> {
                ActionBDDImpl actionDB = new ActionBDDImpl();
                try {
                        Menu menu = new Menu(actionDB);
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                MenuGUI menuGUI = new MenuGUI(actionDB);
                menuGUI.setVisible(true);
            });

	}

}
