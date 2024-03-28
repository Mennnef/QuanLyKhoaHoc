package model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class khoaHoc {
	private String maKH, tenMH;

	public khoaHoc(String maKH, String tenMH) {
		this.maKH = maKH;
		this.tenMH = tenMH;
	}

	public khoaHoc() {
		super();
	}

	@Id
	public String getmaKH() {
		return maKH;
	}

	public void setmaKH(String maKH) {
		this.maKH = maKH;
	}

	public String gettenMH() {
		return tenMH;
	}

	public void settenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	@Override
	public String toString() {
		return "khoaHoc [maKH=" + maKH + ", tenMH=" + tenMH + "]";
	}
	
}
