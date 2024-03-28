package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.caHoc;
import model.lopHoc;
import model.monHoc;
import model.monHocChiTiet;

public class caHocDAO implements interfaceDAO<caHoc>{
	public static caHocDAO getcaHocDAO() {
		return new caHocDAO();
	}

	@Override
	public int insertX(caHoc g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteX(caHoc g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateX(caHoc g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<caHoc> selectAll() {
		ArrayList<caHoc> list = new ArrayList<caHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM cahoc";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maCa = rs.getString("maCa");
				String tStart = rs.getString("thoiGianBatDau");
				String tEnd = rs.getString("thoiGianKetThuc");
				caHoc ch = new caHoc(maCa, tStart, tEnd);
				list.add(ch);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public caHoc selectG(caHoc g) {
		caHoc ch = new caHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM cahoc WHERE thoiGianBatDau = ? AND thoiGianKetThuc = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getTimeStart());
			ps.setString(2, g.getTimeEnd());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maCa = rs.getString("maCa");
				String tStart = rs.getString("thoiGianBatDau");
				String tEnd = rs.getString("thoiGianKetThuc");
				ch = new caHoc(maCa, tStart, tEnd);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ch;
	}
	
	public ArrayList<caHoc> selectAllTheoMH(monHoc mh) {
		ArrayList<caHoc> list = new ArrayList<caHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT DISTINCT ct.maCa, ch.thoiGianBatDau, ch.thoiGianKetThuc FROM monhocchitiet as ct INNER JOIN cahoc AS ch ON ct.maCa = ch.maCa WHERE ct.maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, mh.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maCa = rs.getString("maCa");
				String tStart = rs.getString("thoiGianBatDau");
				String tEnd = rs.getString("thoiGianKetThuc");
				caHoc ch = new caHoc(maCa, tStart, tEnd);
				list.add(ch);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<caHoc> selectAllTheoMHCH(monHocChiTiet mh, lopHoc lh) {
		ArrayList<caHoc> list = new ArrayList<caHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT DISTINCT ct.maCa, ch.thoiGianBatDau, ch.thoiGianKetThuc FROM monhocchitiet as ct INNER JOIN cahoc AS ch ON ct.maCa = ch.maCa INNER JOIN lophoc AS lh ON lh.maLop = ct.maLop WHERE ct.maMH = ? AND lh.maKhu = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, mh.getMaMH());
			ps.setString(2, lh.getMaKhu());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maCa = rs.getString("maCa");
				String tStart = rs.getString("thoiGianBatDau");
				String tEnd = rs.getString("thoiGianKetThuc");
				caHoc ch = new caHoc(maCa, tStart, tEnd);
				list.add(ch);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public caHoc selectTGQuaMaCa(monHocChiTiet mhct) {
		caHoc ch = new caHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT DISTINCT ch.thoiGianBatDau, ch.thoiGianKetThuc FROM monhocchitiet AS ct INNER JOIN cahoc AS ch ON ct.maCa = ch.maCa WHERE ct.maCa = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, mhct.getMaCa());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String tStart = rs.getString("thoiGianBatDau");
				String tEnd = rs.getString("thoiGianKetThuc");
				ch = new caHoc(null, tStart, tEnd);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ch;
	}
}
