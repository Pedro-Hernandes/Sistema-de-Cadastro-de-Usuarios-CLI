package usermanagement;

public class User {
	
	private int id;
	private String name;
	private String email;
	
	/**
	 * Modelo de Usuario
	*/
	
	
	public User() {}
	
	public User(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
		
	}

	// Getters e Setters
	
	public int getId() {
		this.id = id;
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Email: %s", id, name, email);
    }
}
