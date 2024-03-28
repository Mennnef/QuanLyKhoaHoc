package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.thongTinCN;
import model.user;

public class thongTinCNDAO implements interfaceDAO<thongTinCN>{
	public static thongTinCNDAO thongTinCNDAO() {
		return new thongTinCNDAO();
	}
	
	@Override
	public int insertX(thongTinCN g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteX(thongTinCN g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "DELETE FROM thongtincn WHERE email = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmail());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int updateX(thongTinCN g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "UPDATE thongtincn SET name = ?, phone = ?, avatar = ?"
					+ "WHERE email = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getName());
			ps.setString(2, g.getSdt());
			ps.setString(3, g.getAvatar());
			ps.setString(4, g.getEmail());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public ArrayList<thongTinCN> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public thongTinCN selectG(thongTinCN g) {
		thongTinCN tt = new thongTinCN();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * "
					+ "FROM thongtincn INNER JOIN `user` AS us ON thongtincn.email = us.username "
					+ "Where thongtincn.email = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmail());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String email = rs.getString("email");
				String name = rs.getString("name");
				String sdt = rs.getString("phone");
				String avatar = rs.getString("avatar");
				String pass = rs.getString("password");
				tt = new thongTinCN(email, name, sdt, avatar, pass);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tt;
	}
	
	public int updateY(thongTinCN g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "UPDATE thongtincn SET name = ?, phone = ?"
					+ "WHERE email = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getName());
			ps.setString(2, g.getSdt());
			ps.setString(3, g.getEmail());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public thongTinCN selectN(String s) {
		thongTinCN tt = new thongTinCN();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			
			Statement st = c.createStatement();
			String sql = "SELECT * FROM thongtincn WHERE NAME = '" + s + "'";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String sdt = rs.getString("sdt");
				String avatar = rs.getString("avatar");
				String monHocDaDK = rs.getString("monHocDaDK");
				tt = new thongTinCN(email, name, sdt, avatar, null, monHocDaDK);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tt;
	}
	
	public int updateMonHocDaDK(String monHoc, String name) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			Statement st = c.createStatement();
			String sql = "UPDATE thongtincn SET monHocDaDK = CONCAT(monHocDaDK, ', " + monHoc + "') WHERE `name` = '" + name + "'";
			kq = st.executeUpdate(sql);
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int updateXX(thongTinCN g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "UPDATE thongtincn SET name = ?, phone = ?"
					+ "WHERE email = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getName());
			ps.setString(2, g.getSdt());
			ps.setString(3, g.getEmail());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	
	public int selectSL() {
		int sl = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT COUNT(*) FROM thongtincn";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				sl = rs.getInt("COUNT(*)");
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sl;
	}
	
	public thongTinCN selectTTCNTheoEmail(user g) {
		thongTinCN tt = new thongTinCN();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * "
					+ "FROM thongtincn INNER JOIN `user` AS us ON thongtincn.email = us.username "
					+ "Where us.username = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getUsername());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String email = rs.getString("email");
				String name = rs.getString("name");
				String sdt = rs.getString("phone");
				String avatar = rs.getString("avatar");
				String pass = rs.getString("password");
				tt = new thongTinCN(email, name, sdt, avatar, pass);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tt;
	}
}
