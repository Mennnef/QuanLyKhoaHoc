package model;

public class diemMon {
	private String email, maMH, tenDD;
	private Double trongSo, diem;
	private String ghiChu;
	
	public diemMon(String email, String maMH, String tenDD, Double trongSo, Double diem, String ghiChu) {
		this.email = email;
		this.maMH = maMH;
		this.tenDD = tenDD;
		this.trongSo = trongSo;
		this.diem = diem;
		this.ghiChu = ghiChu;
	}

	public diemMon() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenDD() {
		return tenDD;
	}

	public void setTenDD(String tenDD) {
		this.tenDD = tenDD;
	}

	public Double getTrongSo() {
		return trongSo;
	}

	public void setTrongSo(Double trongSo) {
		this.trongSo = trongSo;
	}

	public Double getDiem() {
		return diem;
	}

	public void setDiem(Double diem) {
		this.diem = diem;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "diemMon [email=" + email + ", maMH=" + maMH + ", tenDD=" + tenDD + ", trongSo=" + trongSo + ", diem="
				+ diem + ", ghiChu=" + ghiChu + "]";
	}
	
}
