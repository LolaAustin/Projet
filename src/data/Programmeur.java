package data;
/**
 * This class represents a Programmer, extending the Person class,
 * with attributes for a bonus, salary, and a pseudonym.
 */
public class Programmeur extends Personne {
	
	
    private float prime; // The bonus amount
    private float salaire; // The base salary
    private String pseudo; // The programmer's pseudonym
    private String responsable; 

    /**
     * Default constructor that initializes prime, salary, and pseudo with default values.
     */
    public Programmeur() {
        prime = 0;
        salaire = 0;
        pseudo = "unknown";
    }

    /**
     * Constructor with prime, salary, and pseudo parameters.
     *
     * @param prime   The bonus amount.
     * @param salaire The base salary.
     * @param pseudo  The programmer's pseudonym.
     */
    public Programmeur(float prime, float salaire, String pseudo) {
        this.prime = prime;
        this.salaire = salaire;
        this.pseudo = pseudo;
    }
    
    /**
     * Constructor with prime, salary, and pseudo parameters.
     *
     * @param prime   The bonus amount.
     * @param salaire The base salary.
     * @param pseudo  The programmer's pseudonym.
     * @param responsable The programmer's responsable
     */
    public Programmeur(float prime, float salaire, String pseudo, String responsable) {
        this.prime = prime;
        this.salaire = salaire;
        this.pseudo = pseudo;
        this.responsable = responsable; 
    }

    /**
     * Constructor with prime and salary parameters, with a default pseudo.
     *
     * @param prime   The bonus amount.
     * @param salaire The base salary.
     */
    public Programmeur(float prime, float salaire) {
        this.prime = prime;
        this.salaire = salaire;
        this.pseudo = "unknown";
    }

    /**
     * Constructor with name, first name, birth year, prime, salary, and pseudo parameters.
     *
     * @param n       The last name of the programmer.
     * @param p       The first name of the programmer.
     * @param date    The birth year of the programmer.
     * @param prime   The bonus amount.
     * @param salaire The base salary.
     * @param pseudo  The programmer's pseudonym.
     */
    public Programmeur(String n, String p, int date, float prime, float salaire, String pseudo) {
        super(n, p, date);
        this.prime = prime;
        this.salaire = salaire;
        this.pseudo = pseudo;
    }
    
    /**
     * Constructor with id, name, first name, birth year, prime, salary, and pseudo parameters.
     *
     * @param n       The last name of the programmer.
     * @param p       The first name of the programmer.
     * @param date    The birth year of the programmer.
     * @param prime   The bonus amount.
     * @param salaire The base salary.
     * @param pseudo  The programmer's pseudonym.
     */
    public Programmeur(int id, String n, String p, int date, float prime, float salaire, String pseudo) {
        super(id, n, p, date);
        this.prime = prime;
        this.salaire = salaire;
        this.pseudo = pseudo;
    }
    
    /**
     * Constructor with id, name, first name, birth year, prime, salary, and pseudo parameters.
     *
     * @param n       The last name of the programmer.
     * @param p       The first name of the programmer.
     * @param date    The birth year of the programmer.
     * @param prime   The bonus amount.
     * @param salaire The base salary.
     * @param pseudo  The programmer's pseudonym.
     */
    public Programmeur(int id, String n, String p, int date, float prime, float salaire, String pseudo, String responsable, String hobby, String adresse) {
        //super(id, n, p, date);
        super(id, n, p, date,adresse, hobby ); 
        this.prime = prime;
        this.salaire = salaire;
        this.pseudo = pseudo;
        this.responsable = responsable; 
    }

    /**
     * @return float The bonus amount.
     */
    public float getPrime() {
        return prime;
    }

    /**
     * @return float The total salary, including the bonus.
     */
    public float getSalaire() {
        return salaire + prime;
    }

    /**
     * @return String The programmer's pseudonym.
     */
    public String getPseudo() {
        return pseudo;
    }
    
    
    /**
     * 
     * @return the responsable of the programmeur
     */
    public String getResponsable() {
		return responsable;
	}

    /**
     * 
     * @param responsable the responsable of the programmeur
     */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	/**
     * Gets a textual representation of the Programmeur object.
     *
     * @return A string representing the programmer.
     */
    public String toString(){
        return super.toString() + "Prime: " + getPrime() + ", Salaire: " + getSalaire() + ", Pseudo: " + getPseudo();
    }

    /**
     * Prints information about the programmer, including bonus, salary, and pseudonym.
     */
    public void afficher() {
        System.out.println(toString());
    }
}
