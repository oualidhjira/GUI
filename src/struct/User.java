package struct;

public class User {
	private int idUser;
	private String User_Name;
	private String Password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String User_Name, String Password,int idUser) {
		super();
		
		this.User_Name = User_Name;
		this.Password = Password;
		this.idUser=idUser;
	}


	public int  getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNomUtilisateur() {
		return User_Name;
	}

	public void setNomUtilisateur(String User_Name) {
		this.User_Name = User_Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	@Override
	public String toString() {
		return "Utilisateur [nomUtilisateur=" + User_Name
				+ ", password=" + Password + "]";
	}
	
	

}


