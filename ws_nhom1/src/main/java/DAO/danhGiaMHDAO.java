package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.danhGiaMH;

public class danhGiaMHDAO implements interfaceDAO<danhGiaMH>{
	public static danhGiaMHDAO getdanhGiaMHDAO() {
		return new danhGiaMHDAO();
	}

	@Override
	public int insertX(danhGiaMH g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "INSERT INTO danhgia VALUES(?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaDG());
			ps.setString(2, g.getEmailUser());
			ps.setString(3, g.getMaMH());
			ps.setString(4, g.getNoiDung());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int deleteX(danhGiaMH g) {
		return 0;
	}

	@Override
	public int updateX(danhGiaMH g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<danhGiaMH> selectAll() {
		return null;
	}

	@Override
	public danhGiaMH selectG(danhGiaMH g) {
		return null;
	}
	
	public int selectCount() {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT COUNT(*) FROM danhgia";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				kq = rs.getInt("COUNT(*)");
			}
			
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public ArrayList<danhGiaMH> selectAllDGMH(danhGiaMH g) {
		ArrayList<danhGiaMH> list = new ArrayList<danhGiaMH>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM danhgia WHERE maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maDG = rs.getString("maDG");
				String emailUser = rs.getString("emailUser");
				String maMH = rs.getString("maMH");
				String noiDung = rs.getString("noiDung");
				danhGiaMH dgmh = new danhGiaMH(maDG, emailUser, maMH, noiDung);
				list.add(dgmh);
			}
			
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
