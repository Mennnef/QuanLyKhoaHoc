package model;

public class waitAccept {
	private String email, chuyenMon, cv;
	private int kinhNghiem;

	public waitAccept(String email, int kinhNghiem, String chuyenMon, String cv) {
		this.email = email;
		this.kinhNghiem = kinhNghiem;
		this.chuyenMon = chuyenMon;
		this.cv = cv;
	}

	public waitAccept() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getKinhNghiem() {
		return kinhNghiem;
	}

	public void setKinhNghiem(int kinhNghiem) {
		this.kinhNghiem = kinhNghiem;
	}

	public String getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "waitAccept [email=" + email + ", kinhNghiem=" + kinhNghiem + ", chuyenMon=" + chuyenMon + ", cv=" + cv
				+ "]";
	}
	
}
