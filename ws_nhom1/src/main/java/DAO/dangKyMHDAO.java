package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import model.caHoc;
import model.dangKyMH;
import model.diaDiemHoc;
import model.lopHoc;
import model.monHoc;
import model.monHocChiTiet;
import model.thongTinCN;
import model.user;

public class dangKyMHDAO implements interfaceDAO<dangKyMH>{
	public static dangKyMHDAO getdangKyMHDAO() {
		return new dangKyMHDAO();
	}

	@Override
	public int insertX(dangKyMH g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "INSERT INTO `dangky` VALUES(?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaDK());
			ps.setString(2, g.getEmailUser());
			ps.setString(3, g.getMaMH());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteX(dangKyMH g) {
		int kq = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "DELETE FROM `dangky` WHERE emailUser = ? AND maMHCT = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmailUser());
			ps.setString(2, g.getMaMH());
			kq = ps.executeUpdate();
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateX(dangKyMH g) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<dangKyMH> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dangKyMH selectG(dangKyMH g) {
		dangKyMH dkmh = new dangKyMH();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM dangky WHERE emailUser = ? AND maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmailUser());
			ps.setString(2, g.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maDK = rs.getString("maDK");
				String emailUser = rs.getString("emailUser");
				String maMHCT = rs.getString("maMH");
				dkmh = new dangKyMH(maDK, emailUser, maMHCT);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dkmh;
	}
	
	public int selectSL() {
		int sl = 0;
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT COUNT(*) FROM dangky";
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
	
	public dangKyMH selectDK(user u, monHoc mh) {
		dangKyMH dkmh = new dangKyMH();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM dangky AS dk INNER JOIN monhocchitiet AS ct ON dk.maMHCT = ct.maMHCT WHERE dk.emailUser = ? AND ct.maMH = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, mh.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maDK = rs.getString("maDK");
				String emailUser = rs.getString("emailUser");
				String maMHCT = rs.getString("maMHCT");
				dkmh = new dangKyMH(maDK, emailUser, maMHCT);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dkmh;
	}
	
	public caHoc selectDKCH(dangKyMH dk) {
		caHoc ch = new caHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet AS ct INNER JOIN cahoc AS ch ON ct.maCa = ch.maCa WHERE ct.maMHCT = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, dk.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maCa = rs.getString("maCa");
				String thoiGianBatDau = rs.getString("thoiGianBatDau");
				String thoiGianKetThuc = rs.getString("thoiGianKetThuc");
				ch = new caHoc(maCa, thoiGianBatDau, thoiGianKetThuc);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ch;
	}
	
	public lopHoc selectDKLH(dangKyMH dk) {
		lopHoc ch = new lopHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM monhocchitiet AS ct INNER JOIN lophoc AS lh ON ct.maLop = lh.maLop WHERE ct.maMHCT = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, dk.getMaMH());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maLop = rs.getString("maLop");
				String maKhu = rs.getString("maKhu");
				String moTa = rs.getString("moTa");
				ch = new lopHoc(maLop, maKhu, moTa);
				
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ch;
	}
	
	public diaDiemHoc selectDKDCH(lopHoc lh) {
		diaDiemHoc ch = new diaDiemHoc();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT DISTINCT * FROM lophoc AS lh INNER JOIN khuvuc AS kv ON kv.maKhu = lh.maKhu WHERE lh.maLop = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, lh.getMaLop());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maKhu = rs.getString("maKhu");
				String tenKhu = rs.getString("tenKhu");
				String diaChi = rs.getString("diaChi");
				ch = new diaDiemHoc(maKhu, tenKhu, diaChi);
				
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ch;
	}
	
	public ArrayList<thongTinCN> selectNgDK(monHocChiTiet g) {
		
		ArrayList<thongTinCN> list = new ArrayList<thongTinCN>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM dangky AS dk INNER JOIN thongtincn AS tt on dk.emailUser = tt.email WHERE dk.maMHCT = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMHCT());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				thongTinCN ttcn = new thongTinCN();
				ttcn.setEmail(email);
				ttcn.setSdt(phone);
				ttcn.setName(name);
				list.add(ttcn);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<thongTinCN> select1NgDK(monHocChiTiet g, user u) {
		
		ArrayList<thongTinCN> list = new ArrayList<thongTinCN>();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM dangky AS dk INNER JOIN thongtincn AS tt on dk.emailUser = tt.email WHERE dk.maMHCT = ? AND dk.emailUser = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getMaMHCT());
			ps.setString(2, u.getUsername());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				thongTinCN ttcn = new thongTinCN();
				ttcn.setEmail(email);
				ttcn.setSdt(phone);
				ttcn.setName(name);
				list.add(ttcn);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public dangKyMH selectMaMHCT(dangKyMH g) {
		dangKyMH dkmh = new dangKyMH();
		
		try {
			Connection c = JDBCUtil.connectJDBC();
			
			String sql = "SELECT * FROM dangky WHERE emailUser = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, g.getEmailUser());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String maDK = rs.getString("maDK");
				String emailUser = rs.getString("emailUser");
				String maMHCT = rs.getString("maMHCT");
				dkmh = new dangKyMH(maDK, emailUser, maMHCT);
			}
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dkmh;
	}
}
