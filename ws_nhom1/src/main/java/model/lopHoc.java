package model;

public class lopHoc {
	private String maLop, maKhu, moTa;

	public lopHoc(String maLop, String maKhu, String moTa) {
		this.maLop = maLop;
		this.maKhu = maKhu;
		this.moTa = moTa;
	}

	public lopHoc() {
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getMaKhu() {
		return maKhu;
	}

	public void setMaKhu(String maKhu) {
		this.maKhu = maKhu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "lopHoc [maLop=" + maLop + ", maKhu=" + maKhu + ", moTa=" + moTa + "]";
	}
	
}
