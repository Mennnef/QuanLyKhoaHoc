package model;

public class diemSo {
	private String maDD, tenDD;
	private int trongSo;
	
	public diemSo(String maDD, String tenDD, int trongSo) {
		super();
		this.maDD = maDD;
		this.tenDD = tenDD;
		this.trongSo = trongSo;
	}

	public diemSo() {

	}

	public String getMaDD() {
		return maDD;
	}

	public void setMaDD(String maDD) {
		this.maDD = maDD;
	}

	public String getTenDD() {
		return tenDD;
	}

	public void setTenDD(String tenDD) {
		this.tenDD = tenDD;
	}

	public int getTrongSo() {
		return trongSo;
	}

	public void setTrongSo(int trongSo) {
		this.trongSo = trongSo;
	}

	@Override
	public String toString() {
		return "diemSo [maDD=" + maDD + ", tenDD=" + tenDD + ", trongSo=" + trongSo + "]";
	}
	
}
