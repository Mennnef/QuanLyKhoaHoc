package model;

public class diaDiemHoc {
	private String maKhu, tenKhu, diaChi;

	public diaDiemHoc(String maKhu, String tenKhu, String diaChi) {
		this.maKhu = maKhu;
		this.tenKhu = tenKhu;
		this.diaChi = diaChi;
	}

	public diaDiemHoc() {
	
	}

	public String getMaKhu() {
		return maKhu;
	}

	public void setMaKhu(String maKhu) {
		this.maKhu = maKhu;
	}

	public String getTenKhu() {
		return tenKhu;
	}

	public void setTenKhu(String tenKhu) {
		this.tenKhu = tenKhu;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "diaDiemHoc [maKhu=" + maKhu + ", tenKhu=" + tenKhu + ", diaChi=" + diaChi + "]";
	}
	
}
