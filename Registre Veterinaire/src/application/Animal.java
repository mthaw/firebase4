package application;

public class Animal {
	//Les attributs de l'objet Animal
	String id, nom, user, passe, addresse, phone, age, comportement;
	
	//Constructeur vide
	public Animal() {}

	//Constructeur avec tous les arguments - pour initializer tous les attributs lors de la creation d'un objet Animal
	public Animal(String id, String nom, String user, String passe, String addresse, String phone, String age,
			String comportement) {
		this.id = id;
		this.nom = nom;
		this.user = user;
		this.passe = passe;
		this.addresse = addresse;
		this.phone = phone;
		this.age = age;
		this.comportement = comportement;
	}
	
	//Les getters et setters pour chaque attribut de l'Animal.
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasse() {
		return passe;
	}

	public void setPasse(String passe) {
		this.passe = passe;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getComportement() {
		return comportement;
	}

	public void setComportement(String comportement) {
		this.comportement = comportement;
	}
}
