package struct;

public class Switchs {
	private String DPID;
	private String IPAdress;
	private int Tenant_idTenant;
	private int Tenant_User_idUser;
	private int Profils_idProfil;
	public Switchs(String DPID,String IPAdress,int Tenant_idTenant,int Tenant_User_idUser,int Profils_idProfil){
		this.DPID=DPID;
		this.IPAdress=IPAdress;
		this.Profils_idProfil=Profils_idProfil;
		this.Tenant_idTenant=Tenant_idTenant;
		this.Tenant_User_idUser=Tenant_User_idUser;
		this.Profils_idProfil=Profils_idProfil;
	}
	public String getDPID() {
		return DPID;
	}
	public void setDPID(String dPID) {
		DPID = dPID;
	}
	public String getIPAdress() {
		return IPAdress;
	}
	public void setIPAdress(String iPAdress) {
		IPAdress = iPAdress;
	}
	public int getTenant_idTenant() {
		return Tenant_idTenant;
	}
	public void setTenant_idTenant(int tenant_idTenant) {
		Tenant_idTenant = tenant_idTenant;
	}
	public int getTenant_User_idUser() {
		return Tenant_User_idUser;
	}
	public void setTenant_User_idUser(int tenant_User_idUser) {
		Tenant_User_idUser = tenant_User_idUser;
	}
	public int getProfils_idProfil() {
		return Profils_idProfil;
	}
	public void setProfils_idProfil(int profils_idProfil) {
		Profils_idProfil = profils_idProfil;
	}
	@Override
	public String toString() {
		return "Switchs [DPID=" + DPID + ", IPAdress=" + IPAdress + ", Tenant_idTenant=" + Tenant_idTenant
				+ ", Tenant_User_idUser=" + Tenant_User_idUser + ", Profils_idProfil=" + Profils_idProfil + "]";
	}

}
