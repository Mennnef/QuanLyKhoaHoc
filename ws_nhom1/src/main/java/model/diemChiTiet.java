package model;

public class diemChiTiet {
	private String email, maMHCT, maDauDiem;
	private Double diem;
	private String ghiChu;

	public diemChiTiet(String email, String maMHCT, String maDauDiem, Double diem) {
		super();
		this.email = email;
		this.maMHCT = maMHCT;
		this.maDauDiem = maDauDiem;
		this.diem = diem;
	}

	public diemChiTiet(String email, String maMHCT, String maDauDiem, Double diem, String ghiChu) {
		super();
		this.email = email;
		this.maMHCT = maMHCT;
		this.maDauDiem = maDauDiem;
		this.diem = diem;
		this.ghiChu = ghiChu;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public diemChiTiet() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaMHCT() {
		return maMHCT;
	}

	public void setMaMHCT(String maMHCT) {
		this.maMHCT = maMHCT;
	}

	public String getMaDauDiem() {
		return maDauDiem;
	}

	public void setMaDauDiem(String maDauDiem) {
		this.maDauDiem = maDauDiem;
	}

	public Double getDiem() {
		return diem;
	}

	public void setDiem(Double diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "diemChiTiet [email=" + email + ", maMHCT=" + maMHCT + ", maDauDiem=" + maDauDiem + ", diem=" + diem
				+ ", ghiChu=" + ghiChu + "]";
	}

}
