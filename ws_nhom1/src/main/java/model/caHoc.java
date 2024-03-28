package model;

import java.sql.Time;

public class caHoc {
	private String maCa;
	private String timeStart, timeEnd;

	public caHoc(String maCa, String timeStart, String timeEnd) {
		this.maCa = maCa;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}

	public caHoc() {
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Override
	public String toString() {
		return "caHoc [maCa=" + maCa + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + "]";
	}
	
}
