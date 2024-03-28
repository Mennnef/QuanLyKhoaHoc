package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class monHoc {
	private String maMH, tenMH, maKH, hinhMH;
	private Double soGioHoc;
	private Integer soLuongHV;
	private String emailGV, danhGia;
	private String taiLieuMon;
	
	
	
	public monHoc(String maMH, String tenMH, String maKH, String hinhMH, Double soGioHoc, String taiLieuMon) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.maKH = maKH;
		this.hinhMH = hinhMH;
		this.soGioHoc = soGioHoc;
		this.taiLieuMon = taiLieuMon;
	}

	public monHoc(String maMH, String tenMH, String maKH) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.maKH = maKH;
	}
	
	public monHoc(String maMH, String tenMH, String maKH, String hinhMH) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.maKH = maKH;
		this.hinhMH = hinhMH;
	}

	public monHoc(String maMH, String tenMH, String maKH, String hinhMH, Double soGioHoc, Integer soLuongHV,
			String emailGV, String danhGia) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.maKH = maKH;
		this.hinhMH = hinhMH;
		this.soGioHoc = soGioHoc;
		this.soLuongHV = soLuongHV;
		this.emailGV = emailGV;
		this.danhGia = danhGia;
	}

	public monHoc() {
	
	}
	
	@Id
	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getHinhMH() {
		return hinhMH;
	}

	public void setHinhMH(String hinhMH) {
		this.hinhMH = hinhMH;
	}

	public Double getSoGioHoc() {
		return soGioHoc;
	}

	public void setSoGioHoc(Double soGioHoc) {
		this.soGioHoc = soGioHoc;
	}

	public Integer getSoLuongHV() {
		return soLuongHV;
	}

	public void setSoLuongHV(Integer soLuongHV) {
		this.soLuongHV = soLuongHV;
	}

	public String getEmailGV() {
		return emailGV;
	}

	public void setEmailGV(String emailGV) {
		this.emailGV = emailGV;
	}

	public String getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}

	public String getTaiLieuMon() {
		return taiLieuMon;
	}

	public void setTaiLieuMon(String taiLieuMon) {
		this.taiLieuMon = taiLieuMon;
	}

	@Override
	public String toString() {
		return "monHoc [maMH=" + maMH + ", tenMH=" + tenMH + ", maKH=" + maKH + ", hinhMH=" + hinhMH + ", soGioHoc="
				+ soGioHoc + ", soLuongHV=" + soLuongHV + ", emailGV=" + emailGV + ", danhGia=" + danhGia + "]";
	}

	
	
}
