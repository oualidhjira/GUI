package database;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	
	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection connection;
	
	public DataSource(String driver, String url, String user, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection(){
		connection = null;
		try {
			//	1. charger le Driver
				Class.forName(driver);
				
			//  2.Ouvrir la Connexion
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("connexion bien etablie");
			} catch (Exception e) {
				System.out.println("Erreur : "+e.getMessage());
			}
		
		
		return connection;
		
		
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
