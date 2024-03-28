package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.caHoc;
import model.dangKyMH;
import model.lopHoc;
import model.monHoc;
import model.monHocChiTiet;
import model.user;

public class monHocChiTietDAO implements interfaceDAO<monHocChiTiet>{
	
	public static monHocChiTietDAO getmonHocChiTietDAO() {
		return new monHocChiTietDAO();
	}
	
	@Override
	public int insertX(monHocChiTiet g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "INSERT INTO monhocchitiet VALUES(?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMHCT());
			ps.setString(2, g.getMaMH());
			ps.setString(3, g.getMaLop());
			ps.setString(4, g.getMaCa());
			ps.setString(5, g.getMaGiangVien());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int deleteX(monHocChiTiet g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "DELETE FROM monhocchitiet WHERE maMHCT = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMHCT());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int updateX(monHocChiTiet g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "UPDATE monhocchitiet SET maGiangVien = ?, maMH = ?, maLop = ?, maCa = ? WHERE maMHCT = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaGiangVien());
			ps.setString(2, g.getMaMH());
			ps.setString(3, g.getMaLop());
			ps.setString(4, g.getMaCa());
			ps.setString(5, g.getMaMHCT());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public ArrayList<monHocChiTiet> selectAll() {
		ArrayList<monHocChiTiet> list = new ArrayList<monHocChiTiet>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMHCT = rs.getString("maMHCT");
				String maMH = rs.getString("maMH");
				String maLop = rs.getString("maLop");
				String maCa = rs.getString("maCa");
				String maGiangVien = rs.getString("maGiangVien");
				monHocChiTiet mhct = new monHocChiTiet();
				mhct.setMaMH(maMH);
				mhct.setMaLop(maLop);
				mhct.setMaCa(maCa);
				mhct.setMaGiangVien(maGiangVien);
				mhct.setMaMHCT(maMHCT);
				list.add(mhct);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public monHocChiTiet selectG(monHocChiTiet g) {
		monHocChiTiet mhct = new monHocChiTiet();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet AS mhct INNER JOIN `user` AS us ON mhct.maGiangVien = us.username WHERE mhct.maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMH());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maGiangVien = rs.getString("maGiangVien");
				mhct.setMaGiangVien(maGiangVien);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mhct;
	}
	
	public monHocChiTiet selectG1(monHocChiTiet g) {
		monHocChiTiet mhct = new monHocChiTiet();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet AS mhct INNER JOIN `user` AS us ON mhct.maGiangVien = us.username WHERE mhct.maMH = ? AND mhct.maLop = ? AND mhct.maCa = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMH());
			ps.setString(2, g.getMaLop());
			ps.setString(3, g.getMaCa());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maGiangVien = rs.getString("maGiangVien");
				mhct.setMaGiangVien(maGiangVien);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mhct;
	}
	
	public monHocChiTiet selectMaMHCT(lopHoc g, caHoc ch) {
		monHocChiTiet mhct = new monHocChiTiet();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet AS ct INNER JOIN cahoc AS ch ON ct.maCa = ch.maCa WHERE ch.thoiGianBatDau = ? AND ch.thoiGianKetThuc = ? AND ct.maLop = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, ch.getTimeStart());
			ps.setString(2, ch.getTimeEnd());
			ps.setString(3, g.getMaLop());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMHCT = rs.getString("maMHCT");
				String maLop = rs.getString("maLop");
				String maMH = rs.getString("maMH");
				String maCa = rs.getString("maCa");
				mhct.setMaMHCT(maMHCT);
				mhct.setMaLop(maLop);
				mhct.setMaCa(maCa);
				mhct.setMaMH(maMH);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mhct;
	}
	
	public ArrayList<monHocChiTiet> selectAllTheoMH(monHoc mh) {
		ArrayList<monHocChiTiet> list = new ArrayList<monHocChiTiet>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet WHERE maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, mh.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMHCT = rs.getString("maMHCT");
				String maMH = rs.getString("maMH");
				String maLop = rs.getString("maLop");
				String maCa = rs.getString("maCa");
				String maGiangVien = rs.getString("maGiangVien");
				monHocChiTiet mhct = new monHocChiTiet();
				mhct.setMaMH(maMH);
				mhct.setMaLop(maLop);
				mhct.setMaCa(maCa);
				mhct.setMaGiangVien(maGiangVien);
				mhct.setMaMHCT(maMHCT);
				list.add(mhct);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public monHocChiTiet selectMaMHCTTheoMH(monHoc mh, caHoc ch, lopHoc lh, user gv) {
		monHocChiTiet mhct = new monHocChiTiet();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet AS ct INNER JOIN dangky AS dk ON ct.maMHCT = dk.maMHCT INNER JOIN thongtincn AS tt ON dk.emailUser = tt.email WHERE ct.maMH = ? AND ct.maCa = ? AND ct.maLop = ? AND ct.maGiangVien = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, mh.getMaMH());
			ps.setString(2, ch.getMaCa());
			ps.setString(3, lh.getMaLop());
			ps.setString(4, gv.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMHCT = rs.getString("maMHCT");
				String maLop = rs.getString("maLop");
				String maMH = rs.getString("maMH");
				String maCa = rs.getString("maCa");
				mhct.setMaMHCT(maMHCT);
				mhct.setMaLop(maLop);
				mhct.setMaCa(maCa);
				mhct.setMaMH(maMH);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mhct;
	}
	
	public monHocChiTiet selectMaMHCT(monHocChiTiet g) {
		monHocChiTiet mhct = new monHocChiTiet();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet WHERE maMH = ? AND maLop = ? AND maCa = ? AND maGiangVien = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMH());
			ps.setString(2, g.getMaLop());
			ps.setString(3, g.getMaCa());
			ps.setString(4, g.getMaGiangVien());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMHCT = rs.getString("maMHCT");
				mhct.setMaMHCT(maMHCT);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mhct;
	}
	
	public ArrayList<monHocChiTiet> selectAllMHCTTheoEmail(dangKyMH dk) {
		ArrayList<monHocChiTiet> list = new ArrayList<monHocChiTiet>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM dangky AS dk INNER JOIN monhocchitiet AS mhct ON dk.maMHCT = mhct.maMHCT WHERE dk.emailUser = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, dk.getEmailUser());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMHCT = rs.getString("maMHCT");
				String maMH = rs.getString("maMH");
				String maLop = rs.getString("maLop");
				String maCa = rs.getString("maCa");
				String maGiangVien = rs.getString("maGiangVien");
				monHocChiTiet mhct = new monHocChiTiet();
				mhct.setMaMH(maMH);
				mhct.setMaLop(maLop);
				mhct.setMaCa(maCa);
				mhct.setMaGiangVien(maGiangVien);
				mhct.setMaMHCT(maMHCT);
				list.add(mhct);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<monHocChiTiet> selectAllMHCTTheoEmailGV(dangKyMH dk) {
		ArrayList<monHocChiTiet> list = new ArrayList<monHocChiTiet>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet AS mhct WHERE mhct.maGiangVien = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, dk.getEmailUser());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maMHCT = rs.getString("maMHCT");
				String maMH = rs.getString("maMH");
				String maLop = rs.getString("maLop");
				String maCa = rs.getString("maCa");
				String maGiangVien = rs.getString("maGiangVien");
				monHocChiTiet mhct = new monHocChiTiet();
				mhct.setMaMH(maMH);
				mhct.setMaLop(maLop);
				mhct.setMaCa(maCa);
				mhct.setMaGiangVien(maGiangVien);
				mhct.setMaMHCT(maMHCT);
				list.add(mhct);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
