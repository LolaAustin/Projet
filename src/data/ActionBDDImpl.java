package data;

import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette class contient toutes les méthodes liées à la base de données:
 *  comme la connection; l'affichage de la table; des ajouts, modifications, suppressions. 
 * 
 *
 */
public class ActionBDDImpl implements ActionBDD{
    private Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Programmeur> listeProgrammeurs;

    public void setPreparedStatementAndResultSet(String query) throws SQLException {
        preparedStatement = con.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
         
    }

    /**
     * Permet de se connecter à la base de données. 
     * 
     */
    public void connect() throws Exception {
        
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdtpjava", "root", "emiratesA380");
    	//con = DriverManager.getConnection("jdbc:mysql://localhost/bdtpjava?useSSL=false","root","");
    	
    	connection();    	
    	
    	//con = DriverManager.getConnection("jdbc:mysql://82.124.69.153/ProjetJAVA","SOPHIE","ProjetJava2023");
    	
        if (con != null) {
            System.out.println("Connected to the database!");
        }
        
        listeProgrammeurs = new ArrayList<>();
        
        preparedStatement = con.prepareStatement("Select * From Programmeur");
        resultSet = preparedStatement.executeQuery(); 
        insertProgrammeur(); 
    }
    
    /**
     * @throws SQLException 
     * 
     */
    public void connection () throws SQLException {
    	String url = "jdbc:mysql://90.7.248.79:6368/ProjetJAVA?useSSL=false";
        String utilisateur = "NICOLAS";
        String motDePasse = "VotreMotDePasse"; // Remplacez par votre mot de passe

        Properties prop = new Properties();
        prop.setProperty("user", "SOPHIE");
        prop.setProperty("password", "ProjetJava2023");

        //this.con = null; 
        this.con = null; 
        
        this.con = DriverManager.getConnection(url, prop);

        try {
            this.con = DriverManager.getConnection(url, prop);

            if (con != null) {
                System.out.println("Connexion réussie à la base de données MySQL.");
            } else {
                System.err.println("Échec de la connexion à la base de données MySQL.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    //connexion.close();
                	System.out.println("is not Close");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Se déconnecte de la base de données. 
     */
    public void disconnect() throws Exception {
        con.close();
    }

    /**
     * Méthode qui remplit la liste des Programmeurs avec tout les résultats contenu dans la base de données, 
     * Elle est utilisé au début de la connection et à chaque modification des données (suppression, ajout, modification) 
     */
    public void insertProgrammeur() throws Exception {
    	//setPreparedStatementAndResultSet("Select * From Programmeur");
    	preparedStatement = con.prepareStatement("Select * From Programmeur" );
        resultSet  = preparedStatement.executeQuery(); 
        while (resultSet.next()) {
        	int r_id = resultSet.getInt("id"); 
    		String nom = resultSet.getString("NOM");
            String prenom = resultSet.getString("PRENOM");
            int anNaissance = resultSet.getInt("NAISSANCE");
            float salaire = resultSet.getFloat("SALAIRE");
            float prime = resultSet.getFloat("PRIME");
            String pseudo = resultSet.getString("PSEUDO");
            String responsable = resultSet.getString("RESPONSABLE"); 
            String hobby = resultSet.getString("HOBBY"); 
            String adresse = resultSet.getString("ADRESSE"); 
            
            Programmeur temp = new Programmeur(r_id, nom, prenom, anNaissance, prime, salaire, pseudo, responsable, hobby, adresse);
            listeProgrammeurs.add(temp);
        }
    }

    /**
     * Affiche à l'écran tout les programmeurs de la liste. 
     */
    public void afficher() {
        for (Programmeur programmeur : listeProgrammeurs) {
            programmeur.afficher();
        }
    }
    
    /**
     * Affiche le programmeur correspondant à l'id demandé par l'utilisateur
     * @param id correspond à celui du programmeur
     * @throws SQLException
     */
    public void afficher_id (int id ) throws SQLException {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("Select * From Programmeur WHERE id =" + id );
    		resultSet  = preparedStatement.executeQuery(); 
    		while (resultSet.next()) {
    			int r_id = resultSet.getInt("id"); 
    			String nom = resultSet.getString("NOM");
    			String prenom = resultSet.getString("PRENOM");
    			int anNaissance = resultSet.getInt("NAISSANCE");
    			float salaire = resultSet.getFloat("SALAIRE");
    			float prime = resultSet.getFloat("PRIME");
    			String pseudo = resultSet.getString("PSEUDO");
    			String responsable = resultSet.getString("RESPONSABLE"); 
    			String hobby = resultSet.getString("HOBBY"); 
    			String adresse = resultSet.getString("ADRESSE"); 
            
    			Programmeur temp = new Programmeur(r_id, nom, prenom, anNaissance, prime, salaire, pseudo, responsable, hobby, adresse);
            
    			System.out.println(temp.toString());
    		}
    	} else System.err.println("Le programmeur que vous souhaitez voir n'existe pas.");
    }
    
    /**
     * Supprime le programmeur associé à l'id donné par l'utilisateur
     * @param id
     * @throws SQLException
     */
    public void supprimer (int id ) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("DELETE FROM Programmeur WHERE id =" + id  );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
        	System.err.println("Le programmeur a bien été supprimé.");
    	}
    		//setPreparedStatementAndResultSet("DELETED FROM Programmeur WHERE id =" + id );
    	else System.err.println("Le programmeur que vous souhaitez supprimer n'existe pas");
    }
    
    /**
     * Méthode qui execute l'instruction SQL pour créer un nouveau programmeur. 
     * @param nom Le nom du nouveau programmeur (String)
     * @param prenom Le prénom du nouveau programmeur (String)
     * @param Naissance L'année de naissance du nouveau programmeur (Int)
     * @param salaire Son salaire (int)
     * @param prime Sa prime (int)
     * @param pseudo Son pseudo (String)
     * @param responsable Son responsable (String) 
     * @param hobby Ses hobby (String)
     * @param adresse Son adresse (String)
     * @throws Exception
     */
    public void ajouter (String nom, String prenom, int Naissance, float salaire, float prime, String pseudo, String responsable, String hobby, String adresse) throws Exception {
    	preparedStatement = con.prepareStatement("INSERT INTO Programmeur (nom, prenom, Naissance, salaire, prime, pseudo, responsable, hobby, adresse) "
    			+ "VALUES ('"+  nom + 
    			"', '"+prenom+
    			"'," + Naissance +
    			", "+ salaire + ", "+prime +
    			", '"+pseudo + "', '"+responsable +"', '"+hobby + "', '"+adresse +
    			"')");
    	int test = preparedStatement.executeUpdate(); 
    	
//    	setPreparedStatementAndResultSet("INSERT INTO Programmeur (nom, prenom, Naissance, salaire, prime, pseudo, responsable, hobby, adresse) "
//    			+ "VALUES ("+  nom + 
//    			", "+prenom+
//    			"," + anNaissance +
//    			", "+ salaire + ", "+prime +
//    			", "+pseudo + ", "+responsable +", "+hobby + ", "+adresse +
//    			")");
    	listeProgrammeurs = new ArrayList<>(); 
    	insertProgrammeur(); 
    }
    
    /**
     * Modifie le salaire d'un programmeur choisi
     * @param id du programmeur à qui, on modifie les informations. 
     * @param salaire son nouveau salaire
     * @throws Exception
     */
    public void modifier_salaire (int id, float salaire) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("UPDATE Programmeur SET salaire = "+ salaire + " WHERE id = " + id );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
    	}
    	else System.err.println("Le programmeur dont vous souhaitez modifier le salaire n'existe pas. ");
    }
    
    /**
     * Modifie le nom d'un programmeur choisi
     * @param id 
     * @param nom son nouveau nom
     * @throws Exception
     */
    public void modifier_nom (int id, String nom ) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("UPDATE Programmeur SET nom = '"+ nom + "' WHERE id = " + id );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
    	}
    	else System.err.println("Le programmeur dont vous souhaitez modifier le nom n'existe pas. ");
    }
    
    /**
     * Modifie le nom d'un programmeur choisi
     * @param id 
     * @param prenom son nouveau nom
     * @throws Exception
     */
    public void modifier_prenom (int id, String prenom ) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("UPDATE Programmeur SET prenom = '"+ prenom + "' WHERE id = " + id );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
    	}
    	else System.err.println("Le programmeur dont vous souhaitez modifier le prénom n'existe pas. ");
    }
    
    /**
     * Modifie le pseudo du programmeur choisi
     * @param id
     * @param pseudo
     * @throws Exception
     */
    public void modifier_pseudo (int id, String pseudo ) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("UPDATE Programmeur SET pseudo = '"+ pseudo + "' WHERE id = " + id );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
    	}
    	else System.err.println("Le programmeur dont vous souhaitez modifier le pseudo n'existe pas. ");
    }
    
    /**
     * Modifie le responsable du programmeur choisi 
     * @param id
     * @param responsable
     * @throws Exception
     */
    public void modifier_responsable (int id, String responsable ) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("UPDATE Programmeur SET responsable = '"+ responsable + "' WHERE id = " + id );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
    	}
    	else System.err.println("Le programmeur dont vous souhaitez modifier le responsable n'existe pas. ");
    }
    
    /**
     * Modifie le hobby du programmeur choisi 
     * @param id
     * @param hobby
     * @throws Exception
     */
    public void modifier_hobby (int id, String hobby ) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("UPDATE Programmeur SET hobby = '"+ hobby + "' WHERE id = " + id );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
    	}
    	else System.err.println("Le programmeur dont vous souhaitez modifier le hobby n'existe pas. ");
    }
    
    /**
     * Modifie l'adresse du programmeur choisi 
     * @param id
     * @param adresse
     * @throws Exception
     */
    public void modifier_adresse (int id, String adresse ) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("UPDATE Programmeur SET adresse = '"+ adresse + "' WHERE id = " + id );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
    	}
    	else System.err.println("Le programmeur dont vous souhaitez modifier l'adresse n'existe pas. ");
    }
    
    /**
     * Modifie l'année de naissance du programmeur choisi 
     * @param id
     * @param naissance
     * @throws Exception
     */
    public void modifier_naissance (int id, int naissance ) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("UPDATE Programmeur SET naissance = "+ naissance + " WHERE id = " + id );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
    	}
    	else System.err.println("Le programmeur dont vous souhaitez modifier l'année de naissance n'existe pas. ");
    }
    
    /**
     * Modifie la prime du programmeur choisi 
     * @param id
     * @param prime
     * @throws Exception
     */
    public void modifier_prime (int id, int prime ) throws Exception {
    	if (verification_id(id)) {
    		preparedStatement = con.prepareStatement("UPDATE Programmeur SET prime = "+ prime + " WHERE id = " + id );
        	@SuppressWarnings("unused")
    		long test = preparedStatement.executeLargeUpdate(); 
        	listeProgrammeurs = new ArrayList<>(); 
        	insertProgrammeur(); 
    	}
    	else System.err.println("Le programmeur dont vous souhaitez modifier la prime n'existe pas. ");
    }
    
    /**
     * Vérifie si l'id existe dans la table
     * @param id donné par l'utilisateur
     * @return
     */
    public boolean verification_id (int id) {
    	for (Programmeur programmeur : listeProgrammeurs) {
    		if (programmeur.id == id) return true; 
    	}
    	return false; 
    }
    

}
