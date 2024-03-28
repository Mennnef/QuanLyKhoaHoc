package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import Util.JDBCUtil;
import model.caHoc;
import model.khoaHoc;
import model.lopHoc;
import model.monHoc;
import model.monHocChiTiet;

public class monHocDAO implements interfaceDAO<monHoc>{
	public static monHocDAO monHocDAO() {
		return new monHocDAO();
	}

	@Override
	public int insertX(monHoc g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "INSERT INTO monhoc values (?,?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMH());
			ps.setString(2, g.getMaKH());
			ps.setString(3, g.getTenMH());
			ps.setString(4, g.getHinhMH());
			ps.setDouble(5, g.getSoGioHoc());
			ps.setString(6, g.getTaiLieuMon());
			kq = ps.executeUpdate();
			
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int deleteX(monHoc g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "DELETE FROM monhoc WHERE maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMH());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int updateX(monHoc g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "UPDATE monhoc SET soLuongHV = soLuongHV + 1 WHERE tenMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getTenMH());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public ArrayList<monHoc> selectAll() {
		ArrayList<monHoc> list = new ArrayList<monHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();

			String sql = "SELECT * FROM monhoc";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMH = rs.getString("maMH");
				String tenMH = rs.getString("tenMH");
				String maKH = rs.getString("maKH");
				String hinhMH = rs.getString("hinhMH");
				monHoc mh = new monHoc(maMH, tenMH, maKH, hinhMH);
				list.add(mh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public monHoc selectG(monHoc g) {
		monHoc mh = new monHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhoc WHERE maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMH = rs.getString("maMH");
				String maKH = rs.getString("maKH");
				String tenMH = rs.getString("tenMH");
				String hinhMH = rs.getString("hinhMH");
				Double soGioHoc = rs.getDouble("soGioHoc");
				String taiLieuMon = rs.getString("taiLieuMon");
				mh = new monHoc(maMH, tenMH, maKH, hinhMH, soGioHoc, taiLieuMon);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return mh;
	}

	public ArrayList<monHoc> selectKH(khoaHoc kh) {
		ArrayList<monHoc> list = new ArrayList<monHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhoc INNER JOIN khoahoc on monhoc.maKH = khoahoc.maKH WHERE tenKH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, kh.gettenMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMH = rs.getString("maMH");
				String tenMH = rs.getString("tenMH");
				String maKH = rs.getString("maKH");
				Double soGioHoc = rs.getDouble("soGioHoc");
				monHoc mh = new monHoc(maMH, tenMH, maKH);
				mh.setSoGioHoc(soGioHoc);
				list.add(mh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	public ArrayList<monHoc> selectMH(String s) {
		ArrayList<monHoc> list = new ArrayList<monHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			Statement ps = c.createStatement();
			String sql = "SELECT * FROM monhoc INNER JOIN khoahoc on monhoc.maKH = khoahoc.maKH WHERE tenMH like '%" + s + "%'";
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				String maMH = rs.getString("maMH");
				String maKH = rs.getString("maKH");
				String tenMH = rs.getString("tenMH");
				String hinhMH = rs.getString("hinhMH");
				Double soGioHoc = rs.getDouble("soGioHoc");
				monHoc mh = new monHoc(maMH, tenMH, maKH, hinhMH);
				mh.setSoGioHoc(soGioHoc);
				list.add(mh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public monHoc selectName(String s) {
		monHoc mh = new monHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			Statement st = c.createStatement();
			String sql = "SELECT * FROM monhoc WHERE tenMH = '" + s + "'";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String maMH = rs.getString("maMH");
				String tenMH = rs.getString("tenMH");
				String hinhMH = rs.getString("hinhMH");
				Double soGioHoc = rs.getDouble("soGioHoc");
				Integer soLuongHV = rs.getInt("soLuongHV");
				String emailGV = rs.getString("emailGV");
				String danhGia = rs.getString("danhGia");
				mh = new monHoc(maMH, tenMH, null, hinhMH, soGioHoc, soLuongHV, emailGV, danhGia);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mh;
	}
	
	public int insertDanhGia(monHoc mh) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			Statement ps = c.createStatement();
			String sql = "UPDATE monhoc SET danhGia = CONCAT(danhGia, '\n" + mh.getDanhGia() + "') WHERE tenMH = '" + mh.getTenMH() + "'";
//			System.out.println(sql);
			kq = ps.executeUpdate(sql);
			
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public ArrayList<monHoc> selectAll1() {
		ArrayList<monHoc> list = new ArrayList<monHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();

			String sql = "SELECT * FROM monhoc";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMH = rs.getString("maMH");
				String maKH = rs.getString("maKH");
				String tenMH = rs.getString("tenMH");
				String hinhMH = rs.getString("hinhMH");
				Double soGioHoc = rs.getDouble("soGioHoc");
				String taiLieuMon = rs.getString("taiLieuMon");
				monHoc mh = new monHoc(maMH, tenMH, maKH, hinhMH, soGioHoc, taiLieuMon);
				list.add(mh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<monHoc> selectAll11() {
		ArrayList<monHoc> list = new ArrayList<monHoc>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();

			String sql = "SELECT * FROM monhoc";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMH = rs.getString("maMH");
				String maKH = rs.getString("maKH");
				String tenMH = rs.getString("tenMH");
				String hinhMH = rs.getString("hinhMH");
				Double soGioHoc = rs.getDouble("soGioHoc");
				Integer soLuongHV = rs.getInt("soLuongHV");
				String emailGV = rs.getString("emailGV");
				String danhGia = rs.getString("danhGia");
				monHoc mh = new monHoc(maMH, tenMH, maKH, hinhMH, soGioHoc, soLuongHV, emailGV, danhGia);
				list.add(mh);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public int updateVL(monHoc g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "UPDATE monhoc SET maKH = ?, tenMH = ?, hinhMH = ?, soGioHoc = ?, taiLieuMon = ? WHERE maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(6, g.getMaMH());
			ps.setString(1, g.getMaKH());
			ps.setString(2, g.getTenMH());
			ps.setString(3, g.getHinhMH());
			ps.setDouble(4, g.getSoGioHoc());
			ps.setString(5, g.getTaiLieuMon());
			kq = ps.executeUpdate();
			
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int selectSLHV(monHoc g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT COUNT(*) AS slhv FROM dangky as dk INNER JOIN monhocchitiet AS mh ON dk.maMH = mh.maMH WHERE dk.maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				kq = rs.getInt("slhv");
			}
			
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int selectSLHVCT(monHocChiTiet mhct) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT COUNT(*) as slhv FROM dangky AS dk INNER JOIN monhocchitiet AS ct ON dk.maMHCT = ct.maMHCT WHERE ct.maLop = ? AND ct.maCa = ? AND ct.maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, mhct.getMaLop());
			ps.setString(2, mhct.getMaCa());
			ps.setString(3, mhct.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				kq = rs.getInt("slhv");
			}
			
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public int selectSLHVCTAll() {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT COUNT(*) as slhv FROM dangky";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				kq = rs.getInt("slhv");
			}
			
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public monHoc selectMHCTQuaMaMH(monHocChiTiet mhct) {
		monHoc mh = new monHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT DISTINCT mh.tenMH FROM monhocchitiet AS ct INNER JOIN monhoc AS mh ON ct.maMH = mh.maMH WHERE ct.maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, mhct.getMaMH());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String tenMH = rs.getString("tenMH");
				mh.setTenMH(tenMH);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mh;
	}
}
