package model;

public class thongTinCN {
	private String maThongTin, email, name, sdt, avatar, pass, monHocDaDK;

	public thongTinCN(String email, String name, String sdt, String avatar, String pass) {
		this.email = email;
		this.name = name;
		this.sdt = sdt;
		this.avatar = avatar;
		this.pass = pass;
	}
	
	public thongTinCN(String email, String name, String sdt, String avatar, String pass, String monHocDaDK) {
		this.email = email;
		this.name = name;
		this.sdt = sdt;
		this.avatar = avatar;
		this.pass = pass;
		this.monHocDaDK = monHocDaDK;
	}

	public thongTinCN() {

	}
	
	public thongTinCN(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMonHocDaDK() {
		return monHocDaDK;
	}

	public void setMonHocDaDK(String monHocDaDK) {
		this.monHocDaDK = monHocDaDK;
	}

	public String getMaThongTin() {
		return maThongTin;
	}

	public void setMaThongTin(String maThongTin) {
		this.maThongTin = maThongTin;
	}

	@Override
	public String toString() {
		return "thongTinCN [maThongTin=" + maThongTin + ", email=" + email + ", name=" + name + ", sdt=" + sdt
				+ ", avatar=" + avatar + ", pass=" + pass + ", monHocDaDK=" + monHocDaDK + "]";
	}

}
