package utils;

public class Constantes {

        public static final String URL = "jdbc:derby://localhost:1527/APTN61_BD";
        public static final String USER = "adm";
        public static final String PASSWORD = "adm";
    
        public static final String SELECT_PROG = "SELECT * FROM Programmeur";
        public static final String REMOVE_PROG = "DELETE FROM Programmeur WHERE id = ?";
        public static final String INSERT_PROG = "INSERT INTO Programmeur (nom, prenom, anNaissance, salaire, prime) VALUES (?, ?, ?, ?, ?)";
        public static final String EDIT_PROG = "UPDATE Programmeur SET nom = ?, prenom = ?, anNaissance = ?, salaire = ?, prime = ? WHERE id = ?";
    
}
