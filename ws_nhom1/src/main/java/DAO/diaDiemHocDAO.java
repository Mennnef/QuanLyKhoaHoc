package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.diaDiemHoc;
import model.monHoc;
import model.monHocChiTiet;

public class diaDiemHocDAO implements interfaceDAO<diaDiemHoc>{
	public static diaDiemHocDAO getdiaDiemHocDAO() {
		return new diaDiemHocDAO();
	}

	@Override
	public int insertX(diaDiemHoc g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteX(diaDiemHoc g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateX(diaDiemHoc g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<diaDiemHoc> selectAll() {
		ArrayList<diaDiemHoc> list = new ArrayList<diaDiemHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM khuvuc";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maKhu = rs.getString("maKhu");
				String tenKhu = rs.getString("tenKhu");
				String diaChi = rs.getString("diaChi");
				diaDiemHoc ddh = new diaDiemHoc(maKhu, tenKhu, diaChi);
				list.add(ddh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public diaDiemHoc selectG(diaDiemHoc g) {
		diaDiemHoc ddh = new diaDiemHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM khuvuc WHERE khuvuc.diaChi = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getDiaChi());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maKhu = rs.getString("maKhu");
				String tenKhu = rs.getString("tenKhu");
				String diaChi = rs.getString("diaChi");
				ddh = new diaDiemHoc(maKhu, tenKhu, diaChi);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ddh;
	}
	
	public ArrayList<diaDiemHoc> selectAllTheoMH(monHoc mh) {
		ArrayList<diaDiemHoc> list = new ArrayList<diaDiemHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT DISTINCT kv.* FROM monhocchitiet as ct INNER JOIN lophoc  AS lh ON ct.maLop = lh.maLop INNER JOIN khuvuc AS kv ON lh.maKhu = kv.maKhu WHERE ct.maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, mh.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maKhu = rs.getString("maKhu");
				String tenKhu = rs.getString("tenKhu");
				String diaChi = rs.getString("diaChi");
				diaDiemHoc ddh = new diaDiemHoc(maKhu, tenKhu, diaChi);
				list.add(ddh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<diaDiemHoc> selectAllTheoMHCH(monHocChiTiet mh) {
		ArrayList<diaDiemHoc> list = new ArrayList<diaDiemHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT DISTINCT kv.* FROM monhocchitiet as ct INNER JOIN lophoc  AS lh ON ct.maLop = lh.maLop INNER JOIN khuvuc AS kv ON lh.maKhu = kv.maKhu WHERE ct.maMH = ? AND ct.maCa = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, mh.getMaMH());
			ps.setString(2, mh.getMaCa());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maKhu = rs.getString("maKhu");
				String tenKhu = rs.getString("tenKhu");
				String diaChi = rs.getString("diaChi");
				diaDiemHoc ddh = new diaDiemHoc(maKhu, tenKhu, diaChi);
				list.add(ddh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
