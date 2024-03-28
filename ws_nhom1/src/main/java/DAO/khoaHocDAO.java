package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.khoaHoc;

public class khoaHocDAO implements interfaceDAO<khoaHoc>{
	public static khoaHocDAO khoaHocDAO() {
		return new khoaHocDAO();
	}
	
	
	@Override
	public int insertX(khoaHoc g) {
		int kq = 0 ;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "INSERT INTO khoahoc values (?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getmaKH());
			ps.setString(2, g.gettenMH());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int deleteX(khoaHoc g) {
		int kq = 0 ;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "DELETE FROM khoahoc WHERE maKH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getmaKH());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int updateX(khoaHoc g) {
		int kq = 0 ;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "UPDATE khoahoc SET tenKH = ? WHERE maKH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.gettenMH());
			ps.setString(2, g.getmaKH());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public ArrayList<khoaHoc> selectAll() {
		ArrayList<khoaHoc> list = new ArrayList<khoaHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM khoahoc";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maKH = rs.getString("maKH");
				String tenKH = rs.getString("tenKH");
				khoaHoc  kh = new khoaHoc(maKH, tenKH);
				list.add(kh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public khoaHoc selectG(khoaHoc g) {
		khoaHoc kh = new khoaHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM khoahoc WHERE maKH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getmaKH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maKH = rs.getString("maKH");
				String tenKH = rs.getString("tenKH");
				kh = new khoaHoc(maKH, tenKH);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kh;
	}
	
	public khoaHoc selectX(khoaHoc g) {
		khoaHoc kh = new khoaHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM khoahoc WHERE tenKH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.gettenMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maKH = rs.getString("maKH");
				String tenKH = rs.getString("tenKH");
				kh = new khoaHoc(maKH, tenKH);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kh;
	}
}
