package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.caHoc;
import model.diaDiemHoc;
import model.lopHoc;
import model.monHoc;

public class lopHocDAO implements interfaceDAO<lopHoc>{
	public static lopHocDAO getlopHocDAO() {
		return new lopHocDAO();
	}

	@Override
	public int insertX(lopHoc g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteX(lopHoc g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateX(lopHoc g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<lopHoc> selectAll() {
		ArrayList<lopHoc> list = new ArrayList<lopHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM lophoc WHERE maKhu = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public lopHoc selectG(lopHoc g) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<lopHoc> selectAllTaiDD(diaDiemHoc ddh) {
		ArrayList<lopHoc> list = new ArrayList<lopHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM lophoc WHERE maKhu = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, ddh.getMaKhu());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maLop = rs.getString("maLop");
				String maKhu = rs.getString("maKhu");
				String moTa = rs.getString("moTa");
				lopHoc lh = new lopHoc(maLop, maKhu, moTa);
				list.add(lh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
//	SELECT * FROM monhocchitiet AS ct INNER JOIN lophoc as lh on ct.maLop = lh.maLop WHERE maCa = 'Ca 1' AND lh.maKhu = 'Khu 1'
	
	public ArrayList<lopHoc> selectAllResLH(diaDiemHoc ddh, caHoc ch, monHoc mh) {
		ArrayList<lopHoc> list = new ArrayList<lopHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet AS ct INNER JOIN lophoc as lh on ct.maLop = lh.maLop WHERE maCa = ? AND lh.maKhu = ? AND ct.maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(2, ddh.getMaKhu());
			ps.setString(1, ch.getMaCa());
			ps.setString(3, mh.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maLop = rs.getString("maLop");
				String maKhu = rs.getString("maKhu");
				String moTa = rs.getString("moTa");
				lopHoc lh = new lopHoc(maLop, maKhu, moTa);
				list.add(lh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<lopHoc> selectAllResLHTheoKhu(diaDiemHoc ddh) {
		ArrayList<lopHoc> list = new ArrayList<lopHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM lophoc as lh WHERE lh.maKhu = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, ddh.getMaKhu());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maLop = rs.getString("maLop");
				String maKhu = rs.getString("maKhu");
				String moTa = rs.getString("moTa");
				lopHoc lh = new lopHoc(maLop, maKhu, moTa);
				list.add(lh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
