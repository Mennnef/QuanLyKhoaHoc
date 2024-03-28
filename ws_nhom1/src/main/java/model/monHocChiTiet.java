package model;

public class monHocChiTiet {
	private String maMHCT, maMH, maGiangVien;
	private String maLop, maCa;
	
	public monHocChiTiet(String maMHCT, String maMH, String maGiangVien, String maLop, String maCa) {
		super();
		this.maMHCT = maMHCT;
		this.maMH = maMH;
		this.maGiangVien = maGiangVien;
		this.maLop = maLop;
		this.maCa = maCa;
	}

	public monHocChiTiet(String maMH, String maGiangVien, String maLop, String maCa) {
		this.maMH = maMH;
		this.maGiangVien = maGiangVien;
		this.maLop = maLop;
		this.maCa = maCa;
	}

	public monHocChiTiet(String maMH, String maGiangVien) {
		this.maMH = maMH;
		this.maGiangVien = maGiangVien;
	}

	public monHocChiTiet() {

	}

	
	
	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getMaGiangVien() {
		return maGiangVien;
	}

	public void setMaGiangVien(String maGiangVien) {
		this.maGiangVien = maGiangVien;
	}

	public String getMaMHCT() {
		return maMHCT;
	}

	public void setMaMHCT(String maMHCT) {
		this.maMHCT = maMHCT;
	}

	@Override
	public String toString() {
		return "monHocChiTiet [maMHCT=" + maMHCT + ", maMH=" + maMH + ", maGiangVien=" + maGiangVien + ", maLop="
				+ maLop + ", maCa=" + maCa + "]";
	}

}
