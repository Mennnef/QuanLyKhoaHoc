package model;

public class danhGiaMH {
	private String maDG, emailUser, maMH, noiDung;

	public danhGiaMH(String maDG, String emailUser, String maMH, String noiDung) {
		this.maDG = maDG;
		this.emailUser = emailUser;
		this.maMH = maMH;
		this.noiDung = noiDung;
	}

	public danhGiaMH() {

	}

	public String getMaDG() {
		return maDG;
	}

	public void setMaDG(String maDG) {
		this.maDG = maDG;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	@Override
	public String toString() {
		return "danhGiaMH [maDG=" + maDG + ", emailUser=" + emailUser + ", maMH=" + maMH + ", noiDung=" + noiDung + "]";
	}
	
}
