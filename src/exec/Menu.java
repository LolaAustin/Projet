package exec;

import java.sql.SQLException;
import java.util.Scanner;

import data.ActionBDDImpl;

/**
 * Le menu proposé à l'utilisateur 
 *
 */
public class Menu {

    private ActionBDDImpl Action;

    /**
     * Constructeur de l'object de class Menu. 
     * @param action
     * @throws Exception
     */
    public Menu(ActionBDDImpl action) throws Exception {
        this.Action = action;
        Action.connect();
       
    }

    /**
     * 
     * @throws Exception
     */
    public void displayMenu() throws Exception {
        Scanner scan = new Scanner(System.in);
        int userInput = 0;

        System.out.println("<<<<<<<<Menu>>>>>>>>");
        System.out.println("1. Afficher tous les programmeurs");
        System.out.println("2. Afficher un programmeur");
        System.out.println("3. Supprimer un programmeur");
        System.out.println("4. Ajouter un programmeur");
        System.out.println("5. Modifier le salaire");
        System.out.println("6. Quitter le programme");
        System.out.println("Entrez votre choix : ");
        userInput = scan.nextInt();

        int id=0; 
        
        switch (userInput) {
            case 1:

            	Action.afficher();
            	displayMenu();
                break;
            case 2:
            	System.out.println("Quel programmeur voulez-vous voir ? \nSon id : ");
            	id = scan.nextInt(); 
            	Action.afficher_id(id);
            	displayMenu();
                break;
            case 3:
            	System.out.println("Quel programmeur voulez-vous supprimer ? \nSon id: ");
            	id = scan.nextInt(); 
            	Action.supprimer(id);
            	displayMenu();
                break;
            case 4:
            	System.out.println("Vous allez ajouter un nouveau programmeur");
            	
        		
        		System.out.println("Nom :");
        		String nom  = scan.next(); 
        		System.out.println("Prénom : ");
        		String prenom = scan.next();
        		System.out.println("Année de Naissance :");
        		int age = scan.nextInt(); 
        		System.out.println("Salaire");
        		float salaire = scan.nextFloat(); 
        		System.out.println("Prime :");
        		float prime = scan.nextFloat(); 
        		System.out.println("Pseudo : ");
        		String pseudo = scan.next();
        		System.out.println("Responsable : ");
        		String responsable = scan.next();
        		System.out.println("Hobby : ");
        		String hobby = scan.next();
        		System.out.println("Adresse : ");
        		String adresse = scan.nextLine();
        		
        		Action.ajouter(nom, prenom, age, salaire, prime, pseudo, responsable, hobby, adresse);
        		
            	displayMenu();
                break;
            case 5:
            	System.out.println("De quel programmeur voulez-vous modifier le salaire ? \n Son id :");
            	id = scan.nextInt(); 
            	System.out.println("Quel est son nouveau salaire ? \n Son salaire : ");
            	float salaire_2 = scan.nextFloat(); 
            	Action.modifier_salaire(id, salaire_2);
            	displayMenu();
                break;
            case 6:
            	scan.close();
            	Action.disconnect();
                break;
            default:
                break;
        }
        
    }
    
    

}
