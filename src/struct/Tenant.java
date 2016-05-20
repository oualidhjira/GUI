package struct;

public class Tenant {
	private String idTenant; 
	private String IPAddress; 
	private String TCPPort; 
	private int User_idUser;
	
	public Tenant(){
		
	}
	public Tenant(String idTenant, String IPAddress,String TCPPort,int User_idUser) {
		super();
		this.idTenant=idTenant;
		this.IPAddress=IPAddress;
		this.TCPPort=TCPPort;
		this.User_idUser=User_idUser;
	}
	public String getIdTenant() {
		return idTenant;
	}
	public void setIdTenant(String idTenant) {
		this.idTenant = idTenant;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
	public String getTCPPort() {
		return TCPPort;
	}
	public void setTCPPort(String tCPPort) {
		TCPPort = tCPPort;
	}
	public int getUser_idUser() {
		return User_idUser;
	}
	public void setUser_idUser(int user_idUser) {
		User_idUser = user_idUser;
	}
	@Override
	public String toString() {
		return "Tenant [idTenant=" + idTenant + ", IPAddress=" + IPAddress + ", TCPPort=" + TCPPort
				+ ", User_idUser=" + User_idUser + "]";
	}
	
}
	
