package data;

/**
 * This class represents a person with attributes for name, first name, and birth year.
 */
public class Personne {

	protected int id; 
    protected String nom; // The last name of the person
    protected String prenom; // The first name of the person
    protected int anNaissance; // The birth year of the person
    protected String adresse; 
    protected String hobby; 

    /**
     * Constructor for the Person class.
     *
     * @param n     The last name of the person.
     * @param p     The first name of the person.
     * @param date  The birth year of the person.
     */
    public Personne(String n, String p, int date) {
        setPrenom(p);
        setNom(n);
        setAnNaissance(date);
    }
    
    /**
     * Constructor for the Person class.
     *
     * @param n     The last name of the person.
     * @param p     The first name of the person.
     * @param date  The birth year of the person.
     */
    public Personne(int id, String n, String p, int date) {
    	setId(id);
        setPrenom(p);
        setNom(n);
        setAnNaissance(date);
    }

    /**
     * Constructor for the Person class.
     *
     * @param n     The last name of the person.
     * @param p     The first name of the person.
     * @param date  The birth year of the person.
     */
    public Personne(int id, String n, String p, int date, String adresse, String Hobby) {
    	setId(id);
        setPrenom(p);
        setNom(n);
        setAnNaissance(date);
        setAdresse(adresse);
        setHobby(Hobby);
    }
    
    /**
     * Default constructor that initializes attributes with default values.
     */
    public Personne() {
        setPrenom("unknown");
        setNom("unknown");
        setAnNaissance(2000);
    }

    /**
     * @return The last name of the person.
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom The last name to set.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return The first name of the person.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom The first name to set.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return The birth year of the person.
     */
    public int getAnNaissance() {
        return anNaissance;
    }

    /**
     * @param anNaissance The birth year to set.
     */
    public void setAnNaissance(int anNaissance) {
        this.anNaissance = anNaissance;
    }
    
    /**
     * 
     * @return The id of the person
     */
    public int getId() {
		return id;
	}

    
    /**
     * 
     * @return the adresse of the person
     */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * 
	 * @param adresse The adress of the person
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * 
	 * @return the Hobby of the person
	 */
	public String getHobby() {
		return hobby;
	}

	/**
	 * 
	 * @param hobby The hobby of the person 
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	/**
	 * 
	 * @param hobby The hobby of the person 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
     * Calculates the age of the person by subtracting the birth year from the current year (2023).
     *
     * @return The age of the person.
     */
    public int calculerAge() {
        return 2023 - anNaissance;
    }

    /**
     * Gets a textual representation of the Person object.
     *
     * @return A string representing the person.
     */
    public String toString() {
        return "Id : " + this.id+  ", Last Name: " + this.nom + ", First Name: " + this.prenom + ", Age: " + calculerAge() + " , ";
    }

    /**
     * Prints the person's information to the console.
     */
    public void print() {
        System.out.println(toString());
    }
}
