package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.diemMon;
import model.monHoc;

public class diemMonDAO implements interfaceDAO<diemMon>{
	public static diemMonDAO diemMonDAO() {
		return new diemMonDAO();
	}
	
	@Override
	public int insertX(diemMon g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteX(diemMon g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateX(diemMon g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<diemMon> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public diemMon selectG(diemMon g) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<diemMon> selectX(String s) {
		ArrayList<diemMon> list = new ArrayList<diemMon>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			Statement st = c.createStatement();
			String sql = "SELECT * "
					+ "FROM diemmon INNER JOIN thongtincn ON diemmon.email = thongtincn.email "
					+ "INNER JOIN monhoc ON diemmon.maMH = monhoc.maMH "
					+ "WHERE diemmon.email = '" + s +"'";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String email = rs.getString("email");
				String maMH = rs.getString("maMH");
				String tenDD = rs.getString("tenDD");
				Double trongSo = rs.getDouble("trongSo");
				Double diem = rs.getDouble("diem");
				String ghiChu = rs.getString("ghiChu");
				diemMon diemMon = new diemMon(email, maMH, tenDD, trongSo, diem, ghiChu);
				list.add(diemMon);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<monHoc> selectTenMon(String s) {
		ArrayList<monHoc> list = new ArrayList<monHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			/**
			SELECT `name`, diemmon.maMH, tenMH 
			FROM diemmon INNER JOIN thongtincn ON diemmon.email = thongtincn.email 
			INNER JOIN monhoc ON diemmon.maMH = monhoc.maMH 
			WHERE `name` = 'Hung3Sung' 
			GROUP BY diemmon.maMH
			*/
			Statement st = c.createStatement();
			String sql = "SELECT `name`, diemmon.maMH, tenMH "
					+ "FROM diemmon INNER JOIN thongtincn ON diemmon.email = thongtincn.email "
					+ "INNER JOIN monhoc ON diemmon.maMH = monhoc.maMH "
					+ "WHERE `name` = '" + s +"' "
					+ "GROUP BY diemmon.maMH";
			ResultSet rs = st.executeQuery(sql);
			int count = 1;
			while(rs.next()) {
				String tenMH = rs.getString("tenMH");
				monHoc mh = new monHoc(count+"", tenMH, null);
				list.add(mh);
				count++;
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<diemMon> selectDiem(String tenMH){
		ArrayList<diemMon> list = new ArrayList<diemMon>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			Statement st = c.createStatement();
			String sql = "SELECT tenMH, tenDD, trongSo, diem, ghiChu "
					+ "FROM diemmon INNER JOIN monhoc ON diemmon.maMH = monhoc.maMH "
					+ "WHERE tenMH = '" + tenMH + "'" ;
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String tenDD = rs.getString("tenDD");
				Double trongSo = rs.getDouble("trongSo");
				Double diem = rs.getDouble("diem");
				String ghiChu = rs.getString("ghiChu");
				diemMon diemMon = new diemMon(null, null, tenDD, trongSo, diem, ghiChu);
				list.add(diemMon);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
