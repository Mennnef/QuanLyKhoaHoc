package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.user;

public class userDAO implements interfaceDAO<user>{

	public static userDAO getUserDAO() {
		return new userDAO();
	}
	
	@Override
	public int insertX(user g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql1 = "INSERT INTO user values (?,?,?,?)";
			PreparedStatement ps1 = c.prepareStatement(sql1);
			ps1.setString(1, g.getUsername());
			ps1.setString(2, g.getAnswer());
			ps1.setString(3, g.getPassword());
			ps1.setString(4, g.getRole());
			kq = ps1.executeUpdate();
			
			String sql2 = "INSERT INTO thongtincn values (?,?,?, NULL, NULL)";
			PreparedStatement ps2 = c.prepareStatement(sql2);
			int sl = thongTinCNDAO.thongTinCNDAO().selectSL();
			String addSL = "TT" + sl;
			ps2.setString(1, addSL);
			ps2.setString(2, g.getUsername());
			ps2.setString(3, g.getUsername());
			kq = ps2.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int deleteX(user g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "DELETE FROM `user` WHERE username = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getUsername());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int updateX(user g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "UPDATE user SET answer = ?, password = ?, role = ? "
					+ "WHERE username = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getAnswer());
			ps.setString(2, g.getPassword());
			ps.setString(3, g.getRole());
			ps.setString(4, g.getUsername());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public ArrayList<user> selectAll() {
		ArrayList<user> list = new ArrayList<user>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM `user`";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String answer = rs.getString("answer");
				String password = rs.getString("password");
				String role = rs.getString("role");
				user u = new user(username, password, role, answer);
				list.add(u);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public user selectG(user g) {
		user u = new user();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM user WHERE username = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getUsername());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String answer = rs.getString("answer");
				String password = rs.getString("password");
				String role = rs.getString("role");
				u.setUsername(username);
				u.setAnswer(answer);
				u.setPassword(password);
				u.setRole(role);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public int selectAllHV() {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT COUNT(username) FROM user WHERE `role` = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "hv");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				kq = Integer.valueOf(rs.getString("COUNT(username)"));
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int selectAllGV() {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT COUNT(username) FROM user WHERE `role` = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, "gv");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				kq = Integer.valueOf(rs.getString("COUNT(username)"));
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public  ArrayList<user> selectUserName(String s){
		ArrayList<user> list = new ArrayList<user>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			Statement st = c.createStatement();
			String sql = "SELECT * FROM `user` AS us INNER JOIN thongtincn AS ttcn ON us.username = ttcn.email WHERE username LIKE '%"+s+"%'";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String email = rs.getString("username");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String role = rs.getString("role");
				if(!email.equals("admin")) {
					user u = new user(email, name, role, phone);
					list.add(u);
				}
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public  ArrayList<user> selectSLGV(){
		ArrayList<user> list = new ArrayList<user>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM `user` AS us INNER JOIN thongtincn AS ttcn ON us.username = ttcn.email WHERE role = 'gv'";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String email = rs.getString("username");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String role = rs.getString("role");
				if(!email.equals("admin")) {
					user u = new user(email, name, role, phone);
					list.add(u);
				}
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public  ArrayList<user> selectSLHV(){
		ArrayList<user> list = new ArrayList<user>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM `user` AS us INNER JOIN thongtincn AS ttcn ON us.username = ttcn.email WHERE role = 'hv'";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String email = rs.getString("username");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String role = rs.getString("role");
				if(!email.equals("admin")) {
					user u = new user(email, name, role, phone);
					list.add(u);
				}
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public  ArrayList<user> selectGV(){
		ArrayList<user> list = new ArrayList<user>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM giangvien";
			PreparedStatement st = c.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String email = rs.getString("email");
				String kinhNghiem = rs.getString("kinhNghiem");
				String chuyenMon = rs.getString("chuyenMon");
				String cv = rs.getString("cv");
				user u = new user();
				u.setUsername(email);
				list.add(u);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<user> selectAllESC() {
		ArrayList<user> list = new ArrayList<user>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM `user` ORDER BY username DESC";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String answer = rs.getString("answer");
				String password = rs.getString("password");
				String role = rs.getString("role");
				user u = new user(username, password, role, answer);
				list.add(u);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
