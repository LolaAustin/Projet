package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionBDDImpl implements ActionBDD{
    private Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Programmeur> listeProgrammeurs;

    public void setPreparedStatementAndResultSet(String query) throws SQLException {
        preparedStatement = con.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
         
    }

    public void connect() throws Exception {
        
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdtpjava", "root", "emiratesA380");
    	con = DriverManager.getConnection("jdbc:mysql://localhost/bdtpjava?useSSL=false","root",""); 
        if (con != null) {
            System.out.println("Connected to the database!");
        }
        
        listeProgrammeurs = new ArrayList<>();
        
        preparedStatement = con.prepareStatement("Select * From Programmeur");
        resultSet = preparedStatement.executeQuery(); 
        insertProgrammeur(); 
    }

    public void disconnect() throws Exception {
        con.close();
    }

    
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

    public void afficher() {
        for (Programmeur programmeur : listeProgrammeurs) {
            programmeur.afficher();
        }
    }
    
    public void afficher_id (int id ) throws SQLException {
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
    }
    
    public void supprimer (int id ) throws SQLException {
    	setPreparedStatementAndResultSet("DELETED FROM Programmeur WHERE id =" + id );
    }
    
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
    
    public void modifier_salaire (int id, float salaire) throws Exception {
    	preparedStatement = con.prepareStatement("UPDATE Programmeur SET salaire = "+ salaire + " WHERE id = " + id );
    	@SuppressWarnings("unused")
		long test = preparedStatement.executeLargeUpdate(); 
    	listeProgrammeurs = new ArrayList<>(); 
    	insertProgrammeur(); 
    }

}
