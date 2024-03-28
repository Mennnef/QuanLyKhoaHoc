package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.waitAccept;
import model.user;

public class waitAcceptDAO implements interfaceDAO<waitAccept>{
	
	public static waitAcceptDAO getwaitAcceptDAO() {
		return new waitAcceptDAO();
	}
	
	@Override
	public int insertX(waitAccept g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "INSERT INTO waitaccept VALUES(?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmail());
			ps.setInt(2, g.getKinhNghiem());
			ps.setString(3, g.getChuyenMon());
			ps.setString(4, g.getCv());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int deleteX(waitAccept g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "DELETE FROM waitaccept WHERE `Email` = ?";
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
	public int updateX(waitAccept g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<waitAccept> selectAll() {
		ArrayList<waitAccept> list = new ArrayList<waitAccept>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM waitaccept";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				waitAccept ttcn = new waitAccept();
				ttcn.setEmail(rs.getString("Email"));
				ttcn.setKinhNghiem(rs.getInt("kinhNghiem"));
				ttcn.setChuyenMon(rs.getString("chuyenMon"));
				ttcn.setCv(rs.getString("cv"));
				list.add(ttcn);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public waitAccept selectG(waitAccept g) {
		waitAccept wa = new waitAccept();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM waitaccept WHERE `email` = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmail());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				wa.setEmail(rs.getString("Email"));
				wa.setKinhNghiem(rs.getInt("kinhNghiem"));
				wa.setChuyenMon(rs.getString("chuyenMon"));
				wa.setCv(rs.getString("cv"));
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return wa;
	}
	
	public int selectCount() {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT COUNT(Email) FROM waitaccept ";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				kq = Integer.valueOf(rs.getString("COUNT(Email)"));
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int insertGV(waitAccept g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "INSERT INTO giangvien VALUES(?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmail());
			ps.setInt(2, g.getKinhNghiem());
			ps.setString(3, g.getChuyenMon());
			ps.setString(4, g.getCv());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
}
