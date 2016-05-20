package struct;

public class Profils {
	private int idProfil;
	private String Switch_Name;
	public Profils(int idProfil,String Switch_Name){
		this.idProfil=idProfil;
		this.Switch_Name=Switch_Name;
	}
	public int getIdProfil() {
		return idProfil;
	}
	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}
	public String getSwitch_Name() {
		return Switch_Name;
	}
	public void setSwitch_Name(String switch_Name) {
		Switch_Name = switch_Name;
	}
	@Override
	public String toString() {
		return "Profils [idProfil=" + idProfil + ", Switch_Name=" + Switch_Name + "]";
	}
	
}
