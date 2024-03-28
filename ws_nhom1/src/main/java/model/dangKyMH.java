package model;

public class dangKyMH {
	private String maDK, emailUser, maMH;

	public dangKyMH(String maDK, String emailUser, String maMH) {
		this.maDK = maDK;
		this.emailUser = emailUser;
		this.maMH = maMH;
	}

	public dangKyMH() {

	}

	public String getMaDK() {
		return maDK;
	}

	public void setMaDK(String maDK) {
		this.maDK = maDK;
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

	@Override
	public String toString() {
		return "dangKyMH [maDK=" + maDK + ", emailUser=" + emailUser + ", maMH=" + maMH + "]";
	}
	
}
