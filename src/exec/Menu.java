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
    private Scanner scan; 

    /**
     * Constructeur de l'object de class Menu. 
     * @param action
     * @throws Exception
     */
    public Menu(ActionBDDImpl action) throws Exception {
        this.Action = action;
        Action.connect();
        this.scan = new Scanner(System.in);
       
    }

    /**
     * 
     * @throws Exception
     */
    public void displayMenu() throws Exception {
        int userInput = 0;

        System.out.println("<<<<<<<<Menu>>>>>>>>");
        System.out.println("1. Afficher tous les programmeurs");
        System.out.println("2. Afficher un programmeur");
        System.out.println("3. Supprimer un programmeur");
        System.out.println("4. Ajouter un programmeur");
        System.out.println("5. Modifier les informations d'un programmeur");
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
        		String adresse = scan.next();
        		
        		Action.ajouter(nom, prenom, age, salaire, prime, pseudo, responsable, hobby, adresse);
        		
            	displayMenu();
                break;
            case 5:
            	System.out.println("Vous avez choisi de modifier les informations d'un programmeur");
            	displayMenu_Modification();
            	displayMenu();
                break;
            case 6:
            	Action.disconnect();
            	scan.close();
                break;
            default:
                break;
        }
        
    }
    
    public void displayMenu_Modification () throws Exception {
        int userInput = 0;

        System.out.println("<<<<<<<<Menu des Modifications>>>>>>>>");
        System.out.println("1. Modifier le salaire");
        System.out.println("2. Modifier le nom");
        System.out.println("3. Modifier le prénom");
        System.out.println("4. Modifier l'année de Naissance");
        System.out.println("5. Modifier le prime");
        System.out.println("6. Modifier le pseudo");
        System.out.println("7. Modifier le responsable");
        System.out.println("8. Modifier le hobby");
        System.out.println("9. Modifier l'adresse");
        System.out.println("10. Quitter le programme");
        System.out.println("Entrez votre choix : ");
        userInput = scan.nextInt();

        int id=0; 
        
        if ((0<userInput)&&(userInput<10)) {
        	System.out.println("De quel programmeur voulez-vous modifier des informations ? \n Son id :");
        	id = scan.nextInt();
        }
        
        switch (userInput) {
			case 1: 
            	System.out.println("Quel est son nouveau salaire ? \n Son salaire : ");
            	float salaire_2 = scan.nextFloat(); 
            	Action.modifier_salaire(id, salaire_2);
            	displayMenu();
				break; 
			case 2: 
				System.out.println("Quel est son nouveau nom ? \n Son nouveau nom : ");
            	String nom = scan.next(); 
            	Action.modifier_nom(id, nom);
            	displayMenu();
				break; 
			case 3: 
				System.out.println("Quel est son nouveau prénom ? \n Son nouveau prénom : ");
            	String prenom = scan.next(); 
            	Action.modifier_prenom(id, prenom);
            	displayMenu();
				break;
			case 4: 
				System.out.println("Quel est son année de Naissance ? \n La nouvelle année : ");
            	int annee = scan.nextInt(); 
            	Action.modifier_naissance(id, annee);;
            	displayMenu();
				break;
			case 5: 
				System.out.println("Quel est sa nouvelle prime ? \n La prime : ");
            	int prime = scan.nextInt(); 
            	Action.modifier_prime(id, prime);;
            	displayMenu();
				break;
			case 6: 
				System.out.println("Quel est son nouveau pseudo ? \n Le pseudo : ");
            	String pseudo = scan.next(); 
            	Action.modifier_pseudo(id, pseudo);
            	displayMenu();
				break;
			case 7: 
				System.out.println("Quel est son nouveau responsable ? \n Le responsable : ");
            	String responsable = scan.next(); 
            	Action.modifier_responsable(id, responsable);
            	displayMenu();
				break;
			case 8: 
				System.out.println("Quel est son nouveau hobby ? \n L'hobby : ");
            	String hobby = scan.next(); 
            	Action.modifier_hobby(id, hobby);
            	displayMenu();
				break;
			case 9: 
				System.out.println("Quel est sa nouvelle adresse ? \n L'adresse : ");
            	String adresse = scan.next(); 
            	Action.modifier_adresse(id, adresse);
            	displayMenu();
				break;
			default:
				break; 
		}
    }

}
