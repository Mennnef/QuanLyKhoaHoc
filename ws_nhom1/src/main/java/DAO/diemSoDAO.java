package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.diemSo;

public class diemSoDAO implements interfaceDAO<diemSo>{
	public static diemSoDAO getdiemSoDAO() {
		return new diemSoDAO();
	}

	@Override
	public int insertX(diemSo g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteX(diemSo g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateX(diemSo g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<diemSo> selectAll() {
		ArrayList<diemSo> list = new ArrayList<diemSo>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM diemso";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maDauDiem = rs.getString("maDauDiem");
				String tenDauDiem = rs.getString("tenDauDiem");
				int trongSo = rs.getInt("trongSo");
				diemSo ds = new diemSo(maDauDiem, tenDauDiem, trongSo);
				list.add(ds);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public diemSo selectG(diemSo g) {
		diemSo ds = new diemSo();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM diemso WHERE maDauDiem = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaDD());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maDauDiem = rs.getString("maDauDiem");
				String tenDauDiem = rs.getString("tenDauDiem");
				int trongSo = rs.getInt("trongSo");
				ds = new diemSo(maDauDiem, tenDauDiem, trongSo);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	
	public diemSo selectMaDD(diemSo g) {
		diemSo ds = new diemSo();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM diemso WHERE tenDauDiem = ? AND trongSo = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getTenDD());
			ps.setInt(2, g.getTrongSo());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maDauDiem = rs.getString("maDauDiem");
				String tenDauDiem = rs.getString("tenDauDiem");
				int trongSo = rs.getInt("trongSo");
				ds = new diemSo(maDauDiem, tenDauDiem, trongSo);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ds;
	}
}
