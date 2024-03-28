package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.diemChiTiet;
import model.monHocChiTiet;
import model.user;

public class diemChiTietDAO implements interfaceDAO<diemChiTiet>{
	public static diemChiTietDAO getdiemChiTietDAO() {
		return new diemChiTietDAO();
	}

	@Override
	public int insertX(diemChiTiet g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "INSERT INTO diemchitiet VALUES(?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmail());
			ps.setString(2, g.getMaMHCT());
			ps.setString(3, g.getMaDauDiem());
			ps.setDouble(4, g.getDiem());
			ps.setString(5, g.getGhiChu());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int deleteX(diemChiTiet g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "DELETE FROM diemchitiet WHERE email = ? AND maMHCT = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmail());
			ps.setString(2, g.getMaMHCT());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int updateX(diemChiTiet g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "UPDATE diemchitiet SET diem = ?, ghiChu = ? WHERE email = ? AND maMHCT = ? AND maDauDiem = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setDouble(1, g.getDiem());
			ps.setString(2, g.getGhiChu());
			ps.setString(3, g.getEmail());
			ps.setString(4, g.getMaMHCT());
			ps.setString(5, g.getMaDauDiem());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public ArrayList<diemChiTiet> selectAll() {
		ArrayList<diemChiTiet> list = new ArrayList<diemChiTiet>();
		
		return list;
	}

	@Override
	public diemChiTiet selectG(diemChiTiet g) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<diemChiTiet> selectAllTheoEmail(user u, monHocChiTiet mhct) {
		ArrayList<diemChiTiet> list = new ArrayList<diemChiTiet>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM diemchitiet AS dct INNER JOIN diemso AS ds ON dct.maDauDiem = ds.maDauDiem WHERE dct.email = ? AND dct.maMHCT = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, mhct.getMaMHCT());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				String maMHCT = rs.getString("maMHCT");
				String maDauDiem = rs.getString("maDauDiem");
				Double diem = rs.getDouble("diem");
				String ghiChu = rs.getString("ghiChu");
				diemChiTiet diemct = new diemChiTiet(email, maMHCT, maDauDiem, diem, ghiChu);
				list.add(diemct);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
