package controller;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.caHocDAO;
import DAO.dangKyMHDAO;
import DAO.danhGiaMHDAO;
import DAO.diemChiTietDAO;
import DAO.diemMonDAO;
import DAO.diemSoDAO;
import DAO.khoaHocDAO;
import DAO.monHocChiTietDAO;
import DAO.monHocDAO;
import DAO.thongTinCNDAO;
import DAO.userDAO;
import DAO.waitAcceptDAO;
import model.caHoc;
import model.dangKyMH;
import model.danhGiaMH;
import model.diaDiemHoc;
import model.diemChiTiet;
import model.diemMon;
import model.diemSo;
import model.khoaHoc;
import model.lopHoc;
import model.monHoc;
import model.monHocChiTiet;
import model.thongTinCN;
import model.user;
import model.waitAccept;
import view.loginView;
import view.quanLyKhoaHocview;

public class controllerKhoaHoc implements MouseListener, ActionListener{
	private quanLyKhoaHocview v_kh;
	private String fileName = "";
	
	public controllerKhoaHoc(quanLyKhoaHocview v_kh) {
		this.v_kh = v_kh;
	}
	
	public void logout() {
		String s[] = {"YES", "CANCEL"};
		int i = JOptionPane.showOptionDialog(this.v_kh, "Bạn có chắc chán muốn đăng xuất?", "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, s, s[0]);
		if(i == 0) {
			loginView v_login = new loginView();
			this.v_kh.setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.v_kh.lblTTCN.getForeground().equals(new Color(255,144,0))) {
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.xemTTCN(this.v_kh.nameLogin));
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
		} else
		if(this.v_kh.lblDSKH.getForeground().equals(new Color(255,144,0))) {
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.xemDSKH());
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
		} else
		if(this.v_kh.lblQLKH.getForeground().equals(new Color(255,144,0))) {
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.qlKH());
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
		} else 
		if(this.v_kh.lblQLND.getForeground().equals(new Color(255,144,0))) {
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.qlUser());
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
		} else 
		if(this.v_kh.lblMHCT.getForeground().equals(new Color(255,144,0))) {
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.monHocCuaToi());
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
		} else 
		if(this.v_kh.lblXemDiemCT.getForeground().equals(new Color(255,144,0))) {
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.xemDiem());
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		String src = e.getActionCommand();
		if(src.equals("SUBMIT")) {
			String sdt = this.v_kh.txtSdt.getText();
			String sdt_test = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
			String email = this.v_kh.txtEmail.getText();
			String name = this.v_kh.txtName.getText();
			String avatar = null;
			if(this.v_kh.avatar.getImage() == null) {
				avatar = "NULL";
			} else {
				avatar = this.v_kh.avatar.getImage().toString().substring(this.v_kh.avatar.getImage().toString().lastIndexOf("\\") + 1);
			}
			String pass = this.v_kh.txtPass.getText();
			thongTinCN tt = new thongTinCN(email, name, sdt, avatar, pass);
			user u = new user(email, pass);
			user uDao = userDAO.getUserDAO().selectG(u);
			
			if(sdt.matches(sdt_test) || sdt.equals("") && !pass.equals("")) {
				if(!u.getPassword().equals(uDao.getPassword())) {
					String s = JOptionPane.showInputDialog(this.v_kh, "Vui lòng nhập password cũ để tiến hành thay đổi");
					if(s.equals(uDao.getPassword())) {
						uDao.setPassword(pass);
						userDAO.getUserDAO().updateX(uDao);
						thongTinCNDAO.thongTinCNDAO().updateX(tt);
						this.v_kh.lblName.setText(name);
						this.v_kh.imgLogin.setImage(new javax.swing.ImageIcon((Paths.get("icon\\" + avatar)).toAbsolutePath().toString()));
						JOptionPane.showMessageDialog(this.v_kh, "Thay đổi thông tin hoàn tất");
					} else {
						JOptionPane.showMessageDialog(this.v_kh, "Password không hợp lệ\nThay đổi thông tin thất bại");
					}
				} else {
					String s = JOptionPane.showInputDialog(this.v_kh, "Vui lòng nhập password để tiến hành thay đổi");
					if(s != null) {
						if(s.equals(uDao.getPassword())){
							thongTinCNDAO.thongTinCNDAO().updateX(tt);
							this.v_kh.lblName.setText(name);
							this.v_kh.imgLogin.setImage(new javax.swing.ImageIcon((Paths.get("icon\\" + avatar)).toAbsolutePath().toString()));
							JOptionPane.showMessageDialog(this.v_kh, "Thay đổi thông tin hoàn tất");
						} else {
							JOptionPane.showMessageDialog(this.v_kh, "Password không hợp lệ\nThay đổi thông tin thất bại");
						}
					} 
				}
			} else {
				if(pass.equals("")) {
					JOptionPane.showMessageDialog(this.v_kh, "Password không được để trống");
				} else {
					JOptionPane.showMessageDialog(this.v_kh, "Số điện thoại không đúng định dạng");
				}
			}
			
		} else if(src.equals("Xem thêm")){
			ArrayList<monHoc> list = monHocDAO.monHocDAO().selectAll();
			
			for (monHoc monHoc : list) {
				if(((JPanel)((JButton)e.getSource()).getParent()).toString().indexOf(monHoc.getTenMH()) >= 0) {
					this.v_kh.xemThemMH = monHoc.getMaMH();
				}
			}
			
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.xemTTKH());
			
			
			user u = new user(this.v_kh.nameLogin, "");
			monHoc mh = new monHoc(this.v_kh.xemThemMH, "", "");
			
			dangKyMH dkmh = dangKyMHDAO.getdangKyMHDAO().selectDK(u, mh);
			if(dkmh.getMaDK() != null) {
				System.out.println("zo");
				caHoc ch = dangKyMHDAO.getdangKyMHDAO().selectDKCH(dkmh);
				this.v_kh.cbThoiGian.setSelectedItem(ch.getTimeStart() + " - " + ch.getTimeEnd());
				this.v_kh.cbThoiGian.setEnabled(false);
				
				lopHoc lh = dangKyMHDAO.getdangKyMHDAO().selectDKLH(dkmh);
				
				diaDiemHoc ddh = dangKyMHDAO.getdangKyMHDAO().selectDKDCH(lh);
				this.v_kh.cbDiaDiem.setSelectedItem(ddh.getDiaChi());
				this.v_kh.cbDiaDiem.setEnabled(false);
				
				this.v_kh.cbLopHoc.setSelectedItem(lh.getMaLop());
				this.v_kh.cbLopHoc.setEnabled(false);
				
				this.v_kh.btnDangky.setText("Hủy đăng ký");
			}
			
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
			
		} else if(src.equals("Đăng ký")) {
			if(Integer.valueOf(this.v_kh.lblSoLuongHV.getText().substring(0, this.v_kh.lblSoLuongHV.getText().lastIndexOf(" người"))) < 100) {
				this.v_kh.lblSoLuongHV.setText(Integer.valueOf(this.v_kh.lblSoLuongHV.getText().substring(0, this.v_kh.lblSoLuongHV.getText().lastIndexOf(" người"))) + 1 + " người");
				
				DefaultComboBoxModel<String> cbtg_model = (DefaultComboBoxModel<String>) this.v_kh.cbThoiGian.getModel();
				String timeStart = cbtg_model.getSelectedItem().toString().substring(0, cbtg_model.getSelectedItem().toString().indexOf(" - "));
				String timeEnd = cbtg_model.getSelectedItem().toString().substring(cbtg_model.getSelectedItem().toString().indexOf("- ") + 2);
				caHoc ch = new caHoc(null, timeStart.trim(), timeEnd.trim());
				caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
				
				lopHoc lh = new lopHoc();
				lh.setMaLop(this.v_kh.cbLopHoc.getSelectedItem().toString());
				
				monHocChiTiet mhct = monHocChiTietDAO.getmonHocChiTietDAO().selectMaMHCT(lh, chDAO);
				
				
				DefaultComboBoxModel<String> cbLH_model = (DefaultComboBoxModel<String>) this.v_kh.cbLopHoc.getModel();
				
				int sl = monHocDAO.monHocDAO().selectSLHVCTAll();
				
				dangKyMH dkmh = new dangKyMH("DK" + sl, this.v_kh.nameLogin, mhct.getMaMHCT());
				dangKyMHDAO.getdangKyMHDAO().insertX(dkmh);
				
				
				JOptionPane.showMessageDialog(this.v_kh, "Đăng ký thành công");
				this.v_kh.btnDangky.setText("Hủy đăng ký");
				
				ArrayList<diemSo> list = diemSoDAO.getdiemSoDAO().selectAll();
				for (diemSo diemSo : list) {
					diemChiTiet dct = new diemChiTiet(dkmh.getEmailUser(), mhct.getMaMHCT(), diemSo.getMaDD(), -1.0, null);
					diemChiTietDAO.getdiemChiTietDAO().insertX(dct);
				}
				
				 // them ngay day
				
				this.v_kh.contentPane.removeAll();
				this.v_kh.contentPane.add(this.v_kh.lblXemThem);
				this.v_kh.contentPane.add(this.v_kh.panel_left);
				this.v_kh.contentPane.add(this.v_kh.panel_top);
				this.v_kh.contentPane.add(this.v_kh.xemTTKH());
				
				
				user u1 = new user(this.v_kh.nameLogin, "");
				monHoc mh1 = new monHoc(this.v_kh.xemThemMH, "", "");
				
				dangKyMH dkmh1 = dangKyMHDAO.getdangKyMHDAO().selectDK(u1, mh1);
				if(dkmh1.getMaDK() != null) {
					caHoc ch1 = dangKyMHDAO.getdangKyMHDAO().selectDKCH(dkmh1);
					this.v_kh.cbThoiGian.setSelectedItem(ch1.getTimeStart() + " - " + ch1.getTimeEnd());
					this.v_kh.cbThoiGian.setEnabled(false);
					
					lopHoc lh1 = dangKyMHDAO.getdangKyMHDAO().selectDKLH(dkmh1);
					
					diaDiemHoc ddh1 = dangKyMHDAO.getdangKyMHDAO().selectDKDCH(lh1);
					this.v_kh.cbDiaDiem.setSelectedItem(ddh1.getDiaChi());
					this.v_kh.cbDiaDiem.setEnabled(false);
					
					this.v_kh.cbLopHoc.setSelectedItem(lh1.getMaLop());
					this.v_kh.cbLopHoc.setEnabled(false);
					
					this.v_kh.btnDangky.setText("Hủy đăng ký");
				}
				
				this.v_kh.contentPane.repaint();
				this.v_kh.contentPane.revalidate();
				
				
			} else {
				JOptionPane.showMessageDialog(this.v_kh, "Lớp học đã đủ học viên");
			}
		} else if(src.equals("Đánh giá")) {
//			if(this.v_kh.txtDanhGia.getText().equals("")) {
//				JOptionPane.showMessageDialog(this.v_kh, "Vui lòng nếu cảm nghĩ của bạn về khóa học");
//			} else {
//				int sl = danhGiaMHDAO.getdanhGiaMHDAO().selectCount();
//				danhGiaMH dgmh = new danhGiaMH("DG" + sl, this.v_kh.nameLogin, this.v_kh.xemThemMH, this.v_kh.txtDanhGia.getText());
//				danhGiaMHDAO.getdanhGiaMHDAO().insertX(dgmh);
//				
//				this.v_kh.txtDanhGia.setText("");
//				JOptionPane.showMessageDialog(this.v_kh, "Đánh giá của bạn đã được ghi nhận");
//			}
		} else if(src.equals("Xem Đánh giá")) {
//			danhGiaMH dgmh = new danhGiaMH();
//			dgmh.setMaMH(this.v_kh.xemThemMH);
//			ArrayList<danhGiaMH> list = danhGiaMHDAO.getdanhGiaMHDAO().selectAllDGMH(dgmh);
//		
//			if(list.isEmpty()) {
//				JOptionPane.showMessageDialog(this.v_kh, "Hiện chưa có bất cứ đánh giá nào");
//			} else {
//				this.v_kh.txtDanhGia.setText("");
//				for (danhGiaMH danhGiaMH : list) {
//					if(!this.v_kh.txtDanhGia.getText().equals("")) {
//						this.v_kh.txtDanhGia.setText(this.v_kh.txtDanhGia.getText() + "\n" + danhGiaMH.getEmailUser() + ": " + danhGiaMH.getNoiDung());
//					} else {
//						this.v_kh.txtDanhGia.setText(danhGiaMH.getEmailUser() + ": " + danhGiaMH.getNoiDung());
//		
//					}
//				}
//			}
		} else if(src.equals("Đăng ký giảng viên")) {
			this.v_kh.panelTTCN.removeAll();
			this.v_kh.panelTTCN.add(this.v_kh.setPanel_TTSP());
			this.v_kh.panelTTCN.add(this.v_kh.btnSubmit);
			this.v_kh.btnSubmit.setText(" SUBMIT ");
			this.v_kh.panelTTCN.add(this.v_kh.btnDKGV);
			this.v_kh.btnDKGV.setText("Quay lại");
			this.v_kh.panelTTCN.add(this.v_kh.lblBottom);
			this.v_kh.panelTTCN.repaint();
			this.v_kh.panelTTCN.validate();
			
		} else if (src.equals("Quay lại")) {
			this.v_kh.panelTTCN.removeAll();
			this.v_kh.panelTTCN.add(this.v_kh.setPanel_TTCN());
			this.v_kh.panelTTCN.add(this.v_kh.btnSubmit);
			this.v_kh.btnSubmit.setText("SUBMIT");
			this.v_kh.panelTTCN.add(this.v_kh.btnDKGV);
			this.v_kh.btnDKGV.setText("Đăng ký giảng viên");
			this.v_kh.panelTTCN.add(this.v_kh.lblBottom);
			this.v_kh.panelTTCN.repaint();
			this.v_kh.panelTTCN.validate();
		} else if (src.equals(" SUBMIT ")) {
			int kq = JOptionPane.showConfirmDialog(this.v_kh, "Bạn cam kết những điều trên là hoàn toàn đúng sự thật?", "", JOptionPane.YES_NO_OPTION);
			if(kq == JOptionPane.YES_OPTION) {
				waitAccept wa = new waitAccept(this.v_kh.nameLogin, Integer.valueOf(this.v_kh.txtKN.getText()), this.v_kh.txtCM.getText(), this.v_kh.lblCV.getText());
				waitAcceptDAO.getwaitAcceptDAO().insertX(wa);
				JOptionPane.showMessageDialog(this.v_kh, "Đăng ký thành công\nKết quả sẽ thông báo qua email của bạn sau vài ngày");
			}
			
		} else if(src.equals("Trở về")) {
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.xemDSKH());
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
		} else if (src.equals("Hủy đăng ký")) {
			String maMH = this.v_kh.lblTitleKH.getText().substring(0, 3);
			monHoc mh = new monHoc();
			mh.setMaMH(maMH);
			
			String time = this.v_kh.cbThoiGian.getSelectedItem().toString();
			String timeStart = time.substring(0, time.indexOf(" - "));
			String timeEnd = time.substring(time.indexOf(" - ")+3);
			caHoc ch = new caHoc(null, timeStart.trim(), timeEnd.trim());
			caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
			
			String maLop = this.v_kh.cbLopHoc.getSelectedItem().toString();
			lopHoc lh = new lopHoc();
			lh.setMaLop(maLop);

			String giangVien = this.v_kh.lblEmailGV.getText();
			user u = new user();
			u.setUsername(giangVien);
			
			monHocChiTiet ttMhct = monHocChiTietDAO.getmonHocChiTietDAO().selectMaMHCTTheoMH(mh, chDAO, lh, u);
			
			dangKyMH dk = new dangKyMH();
			dk.setEmailUser(this.v_kh.nameLogin);
			dk.setMaMH(ttMhct.getMaMHCT());
			dangKyMHDAO.getdangKyMHDAO().deleteX(dk);
			
			diemChiTiet dct = new diemChiTiet();
			dct.setEmail(dk.getEmailUser());
			dct.setMaMHCT(dk.getMaMH());
			diemChiTietDAO.getdiemChiTietDAO().deleteX(dct);
			
			JOptionPane.showMessageDialog(this.v_kh, "Hủy đăng ký thành công");
			
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.xemTTKH());
			
			
			this.v_kh.btnDangky.setText("Đăng ký");
			
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
			
		}
	}
	
	public void chageAvatar() {
		Object obj[] = {"Xóa Avatar", "Đổi Avatar", "CANCEL"};
		int i = JOptionPane.showOptionDialog(this.v_kh, "Vui lòng chọn chức năng", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[0]);
		if(i == 0) {
			this.v_kh.avatar.setImage(null);
		} else if(i == 1) {
			JFileChooser fc = new JFileChooser();
			int j = fc.showOpenDialog(this.v_kh);
			if(j == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				if(f.getName().endsWith(".png") || f.getName().endsWith(".jpg")) {
					String duoi = f.getName().endsWith(".png")? "png" : "jpg";
					String nameFl = f.toString().substring(f.toString().lastIndexOf("\\")+1);
					try {
						BufferedImage bi = ImageIO.read(f);
						ImageIO.write(bi, duoi, new File((Paths.get("icon\\" + nameFl)).toAbsolutePath().toString()));
						this.v_kh.avatar.setImage(new javax.swing.ImageIcon((Paths.get("icon\\" + nameFl)).toAbsolutePath().toString()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void filter() {
		ArrayList<khoaHoc> listKH = khoaHocDAO.khoaHocDAO().selectAll();
		ArrayList<JCheckBox> listxx = new ArrayList<>();
		
		
		for (khoaHoc khoaHoc : listKH) {
			JCheckBox cbx = new JCheckBox(khoaHoc.gettenMH());
			cbx.setBackground(null);
			listxx.add(cbx);
		}
		JCheckBox dsmhdk = new JCheckBox("Đã đăng ký");
		listxx.add(dsmhdk);
		Object obj1[] = listxx.toArray();
		
		
		int i = JOptionPane.showConfirmDialog(this.v_kh, obj1, "Title", JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			this.v_kh.panel_2.setLayout(new GridLayout(0, 3, 25, 25));
			this.v_kh.panel_2.removeAll();
			int temp = -1;
			int xx = 0;
			
			this.v_kh.panel_2.setPreferredSize(new Dimension(1116, 698));
			
			
			ArrayList<monHoc> list = monHocDAO.monHocDAO().selectAll();
			int count = 0;
			for (Object object : obj1) {
				if(((JCheckBox)object).isSelected()) {
					if(((JCheckBox)object).getText().equals("Đã đăng ký")) {
						dangKyMH dk = new dangKyMH();
						dk.setEmailUser(this.v_kh.nameLogin);
						dangKyMH dkDAO = dangKyMHDAO.getdangKyMHDAO().selectMaMHCT(dk);
						
						ArrayList<monHocChiTiet> listMHDK = monHocChiTietDAO.getmonHocChiTietDAO().selectAllMHCTTheoEmail(dkDAO);
						ArrayList<monHoc> listAll = monHocDAO.monHocDAO().selectAll();
						
						for (monHoc monHoc : list) {
							for (monHocChiTiet mhct : listMHDK) {
								if(monHoc.getMaMH().equals(mhct.getMaMH())) {
									temp++;
									if(temp > 8 && temp % 3 == 0) {
										xx++;
										this.v_kh.panel_2.setPreferredSize(new Dimension(this.v_kh.scrollPanel_centerDSKH.getWidth() - 22, this.v_kh.scrollPanel_centerDSKH.getHeight() + 220*xx + 52));
									}
									JPanel panel10 = new JPanel();
									panel10.setBackground(new Color(255, 255, 255));
									panel10.setForeground(new Color(255, 255, 255));
									panel10.setLayout(null);
									panel10.setBorder(new EmptyBorder(0, 0, 0, 0));
									this.v_kh.panel_2.add(panel10);
									
									JLabel lblTitle10 = new JLabel(monHoc.getMaMH() + ": " +monHoc.getTenMH());
									lblTitle10.setHorizontalAlignment(SwingConstants.CENTER);
									lblTitle10.setFont(new Font("Arial", Font.PLAIN, 18));
									lblTitle10.setBounds(20, 129, 289, 33);
									panel10.add(lblTitle10);
									
									JButton btn10 = new JButton("Xem thêm");
									btn10.setBackground(new Color(255, 255, 255));
									btn10.setFont(new Font("Arial", Font.BOLD, 14));
									btn10.setBounds(111, 168, 111, 21);
									btn10.setFocusPainted(false);
									btn10.setOpaque(false);
									btn10.addActionListener(this);
									panel10.add(btn10);
									
									JLabel lblImage10 = new JLabel("");
									lblImage10.setHorizontalAlignment(SwingConstants.CENTER);
									lblImage10.setBorder(new EmptyBorder(0, 0, 0, 0));
									lblImage10.setBounds(0, 0, 338, 119);
									ImageIcon ic10 = new ImageIcon((Paths.get("icon\\" + monHoc.getHinhMH())).toString());
									Image icon10 = ic10.getImage();
									Image da10 = icon10.getScaledInstance(lblImage10.getWidth(), lblImage10.getHeight(), Image.SCALE_SMOOTH);
									ImageIcon ne10 = new ImageIcon(da10);
									lblImage10.setIcon(ne10);
									panel10.add(lblImage10);
									panel10.setName(lblTitle10.getText());
									
									count++;
									break;
								}
							}
						}
					} else {
						String tenKH = ((JCheckBox)object).getText();
						khoaHoc kh = new khoaHoc(tenKH, tenKH);
						khoaHoc khDAO = khoaHocDAO.khoaHocDAO().selectX(kh);
						
						ArrayList<monHoc> listAll = monHocDAO.monHocDAO().selectAll();
						for (monHoc monHoc : listAll) {
							if(monHoc.getMaKH().equals(khDAO.getmaKH())) {
								temp++;
								if(temp > 8 && temp % 3 == 0) {
									xx++;
									this.v_kh.panel_2.setPreferredSize(new Dimension(this.v_kh.scrollPanel_centerDSKH.getWidth() - 22, this.v_kh.scrollPanel_centerDSKH.getHeight() + 220*xx + 52));
								}
								JPanel panel10 = new JPanel();
								panel10.setBackground(new Color(255, 255, 255));
								panel10.setForeground(new Color(255, 255, 255));
								panel10.setLayout(null);
								panel10.setBorder(new EmptyBorder(0, 0, 0, 0));
								this.v_kh.panel_2.add(panel10);
								
								JLabel lblTitle10 = new JLabel(monHoc.getMaMH() + ": " +monHoc.getTenMH());
								lblTitle10.setHorizontalAlignment(SwingConstants.CENTER);
								lblTitle10.setFont(new Font("Arial", Font.PLAIN, 18));
								lblTitle10.setBounds(20, 129, 289, 33);
								panel10.add(lblTitle10);
								
								JButton btn10 = new JButton("Xem thêm");
								btn10.setBackground(new Color(255, 255, 255));
								btn10.setFont(new Font("Arial", Font.BOLD, 14));
								btn10.setBounds(111, 168, 111, 21);
								btn10.setFocusPainted(false);
								btn10.setOpaque(false);
								btn10.addActionListener(this);
								panel10.add(btn10);
									
								JLabel lblImage10 = new JLabel("");
								lblImage10.setHorizontalAlignment(SwingConstants.CENTER);
								lblImage10.setBorder(new EmptyBorder(0, 0, 0, 0));
								lblImage10.setBounds(0, 0, 338, 119);
								ImageIcon ic10 = new ImageIcon((Paths.get("icon\\" + monHoc.getHinhMH())).toString());
								Image icon10 = ic10.getImage();
								Image da10 = icon10.getScaledInstance(lblImage10.getWidth(), lblImage10.getHeight(), Image.SCALE_SMOOTH);
								ImageIcon ne10 = new ImageIcon(da10);
								lblImage10.setIcon(ne10);
								panel10.add(lblImage10);
								panel10.setName(lblTitle10.getText());
								
								count++;
							}
						}
					}
				}
			}
			int max = 9;
			if(xx == 1) {				
				max = 9;
			} else if (xx > 1){
				max += xx*3;
			}
			
			ArrayList<JPanel> listPanel = new ArrayList<JPanel>();
			for(int j = 0; j < max - count; j++) {
				listPanel.add(new JPanel());
			}
			
			for (JPanel panel : listPanel) {
				this.v_kh.panel_2.add(panel);
				panel.setVisible(false);
			}
			
			this.v_kh.contentPane.revalidate();
			this.v_kh.contentPane.repaint();
			
		}
	}
	
	public void search() {
		Object obj[] = {"OK", "CANCEL"};
		JTextField jTextField = new JTextField();
		Object ss[] = {"Nhập tên môn học cần tìm",jTextField};
		int i = JOptionPane.showOptionDialog(this.v_kh, ss, null, JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, obj, obj[0]);
		if(i == 0) {
			this.v_kh.panel_2.removeAll();
			
			ArrayList<monHoc> list = monHocDAO.monHocDAO().selectMH(jTextField.getText());
			int count = 0;
			int temp = -1;
			int xx = 0;
			this.v_kh.panel_2.setPreferredSize(new Dimension(1116, 698));
			
			if(list.isEmpty()) {
				this.v_kh.panel_2.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel jLabel = new JLabel("Không tìm thấy môn học này", JLabel.CENTER);
				jLabel.setFont(new Font("Arial", Font.BOLD, 46));
				this.v_kh.panel_2.add(jLabel);
			} else {
				this.v_kh.panel_2.setLayout(new GridLayout(0, 3, 25, 25));
				
				for (monHoc monHoc : list) {
					temp++;
					if(temp > 8 && temp % 3 == 0) {
						xx++;
						this.v_kh.panel_2.setPreferredSize(new Dimension(this.v_kh.scrollPanel_centerDSKH.getWidth() - 22, this.v_kh.scrollPanel_centerDSKH.getHeight() + 220*xx + 52));
					}
					JPanel panel10 = new JPanel();
					panel10.setBackground(new Color(255, 255, 255));
					panel10.setForeground(new Color(255, 255, 255));
					panel10.setLayout(null);
					panel10.setBorder(new EmptyBorder(0, 0, 0, 0));
					this.v_kh.panel_2.add(panel10);
					
					JLabel lblTitle10 = new JLabel(monHoc.getMaMH() + ": " +monHoc.getTenMH());
					lblTitle10.setHorizontalAlignment(SwingConstants.CENTER);
					lblTitle10.setFont(new Font("Arial", Font.PLAIN, 18));
					lblTitle10.setBounds(20, 129, 289, 33);
					panel10.add(lblTitle10);
					
					JButton btn10 = new JButton("Xem thêm");
					btn10.setBackground(new Color(255, 255, 255));
					btn10.setFont(new Font("Arial", Font.BOLD, 14));
					btn10.setBounds(111, 168, 111, 21);
					btn10.setFocusPainted(false);
					btn10.setOpaque(false);
					btn10.addActionListener(this);
					panel10.add(btn10);
					
					JLabel lblImage10 = new JLabel("");
					lblImage10.setHorizontalAlignment(SwingConstants.CENTER);
					lblImage10.setBorder(new EmptyBorder(0, 0, 0, 0));
					lblImage10.setBounds(0, 0, 338, 119);
					ImageIcon ic10 = new ImageIcon((Paths.get("icon\\" + monHoc.getHinhMH())).toString());
					Image icon10 = ic10.getImage();
					Image da10 = icon10.getScaledInstance(lblImage10.getWidth(), lblImage10.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon ne10 = new ImageIcon(da10);
					lblImage10.setIcon(ne10);
					panel10.add(lblImage10);
					panel10.setName(lblTitle10.getText());
					
					count++;
				}
				
				int max = 9;
				if(xx == 1) {				
					max = 9;
				} else if (xx > 1){
					max += xx*3;
				}
				
				ArrayList<JPanel> listPanel = new ArrayList<JPanel>();
				for(int j = 0; j < max - count; j++) {
					listPanel.add(new JPanel());
				}
				
				for (JPanel panel : listPanel) {
					this.v_kh.panel_2.add(panel);
					panel.setVisible(false);
				}
				
				JOptionPane.showMessageDialog(this.v_kh, "Tìm kiếm hoàn tất");
			}
			this.v_kh.contentPane.revalidate();
			this.v_kh.contentPane.repaint();
		}
	}

	public void newKH() {
		this.v_kh.txtMaKH.setText("");
		this.v_kh.txtTenKH.setText("");
		this.v_kh.txtMaKH.requestFocus(true);
		this.v_kh.txtMaKH.setEditable(true);
	}
	
	public void newMH() {
		this.v_kh.txt_MaMH.setText("");
		this.v_kh.txt_MaMH.setEditable(true);
		this.v_kh.txt_MaMH.requestFocus(true);
		this.v_kh.txt_TenMH.setText("");
		this.v_kh.txt_TongGioHoc.setText("");
//		this.v_kh.txt_SoHocVien.setText("");
		this.v_kh.lbl_imgMH.setText("Hình môn học");
		this.v_kh.lbl_imgMH.setIcon(null);
//		this.v_kh.cbx_GiangVien.setSelectedIndex(0);
		this.v_kh.cbx_MaKH_MH.setSelectedIndex(0);
	}
	
	public void setAvateImgMH() {
		JFileChooser fc = new JFileChooser();
		int i = fc.showOpenDialog(this.v_kh);
		if(i == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			System.out.println();
			if(f.getName().endsWith(".png") || f.getName().endsWith(".jpg")) {
				try {
					//tao anh
					BufferedImage bi = ImageIO.read(f);
					fileName = f.getAbsolutePath().toString().substring(f.getAbsolutePath().toString().lastIndexOf("\\") + 1);
					ImageIO.write(bi, "png", new File((Paths.get("icon\\" + fileName)).toAbsolutePath().toString()));

					//chinh anh
					ImageIcon ii = new ImageIcon((Paths.get("icon\\" + fileName)).toAbsolutePath().toString());
					Image i1 = ii.getImage();
					Image i2 = i1.getScaledInstance(this.v_kh.lbl_imgMH.getWidth(), this.v_kh.lbl_imgMH.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon iii = new ImageIcon(i2);
					
					//set Anh
					this.v_kh.lbl_imgMH.setIcon(iii);
					this.v_kh.lbl_imgMH.setText("");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this.v_kh, "Đây không phải là hình ảnh\nVui lòng chọn lại");
			}
		}
	}

	public void loadTable() {
		ArrayList<monHoc> list = monHocDAO.monHocDAO().selectAll1();
		DefaultTableModel table_model = (DefaultTableModel) this.v_kh.table.getModel();
		for (monHoc monHoc : list) {
//			int slhv = monHocDAO.monHocDAO().selectSLHV(monHoc);
			monHocChiTiet mhct = new monHocChiTiet();
			mhct.setMaMH(monHoc.getMaMH());
			monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG(mhct);
			table_model.addRow(new Object[] {monHoc.getMaKH(), monHoc.getMaMH(), monHoc.getTenMH(), monHoc.getSoGioHoc() + " Hours"});
		}
	}
	
	public void focusTable() {
		DefaultTableModel table_model = (DefaultTableModel) this.v_kh.table.getModel();
		this.v_kh.txtMaKH.setEditable(false);
		this.v_kh.txt_MaMH.setEditable(false);
		int i = this.v_kh.table.getSelectedRow();
		
		khoaHoc kh = new khoaHoc();
		kh.setmaKH(this.v_kh.table.getValueAt(i, 0)+"");
		khoaHoc khDAO = khoaHocDAO.khoaHocDAO().selectG(kh);
		
		this.v_kh.txtMaKH.setText(khDAO.getmaKH());
		this.v_kh.txtTenKH.setText(khDAO.gettenMH());
		
		monHoc mh = new monHoc();
		mh.setMaMH(this.v_kh.table.getValueAt(i, 1)+"");
		monHoc mhDAO = monHocDAO.monHocDAO().selectG(mh);
		
		this.v_kh.txt_MaMH.setText(mhDAO.getMaMH());
		this.v_kh.txt_TenMH.setText(mhDAO.getTenMH());
		this.v_kh.txt_TongGioHoc.setText(mhDAO.getSoGioHoc()+"");
		Object obj = khDAO.getmaKH() + ": " + khDAO.gettenMH();
		this.v_kh.cbx_MaKH_MH.setSelectedItem(obj);
		
//		int slhv = monHocDAO.monHocDAO().selectSLHV(mhDAO);
//		this.v_kh.txt_SoHocVien.setText(slhv + "");
		
//		monHocChiTiet mhct = new monHocChiTiet();
//		mhct.setMaMH(mhDAO.getMaMH());
//		monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG(mhct);
//		this.v_kh.cbx_GiangVien.setSelectedItem(mhctDAO.getMaGiangVien());
		
		
		if(mhDAO.getHinhMH() != null || this.v_kh.lbl_imgMH.getText().equals("Hình môn học")) {
			//chinh anh
			fileName = mhDAO.getHinhMH();
			ImageIcon ii = new ImageIcon((Paths.get("icon\\" + mhDAO.getHinhMH())).toAbsolutePath().toString());
			Image i1 = ii.getImage();
			Image i2 = i1.getScaledInstance(this.v_kh.lbl_imgMH.getWidth(), this.v_kh.lbl_imgMH.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon iii = new ImageIcon(i2);
			
			//set Anh
			this.v_kh.lbl_imgMH.setIcon(iii);
			this.v_kh.lbl_imgMH.setText("");
		} else {
			this.v_kh.lbl_imgMH.setText("Hình môn học");
		}
		
	}
	
	public void saveKH() {
		if(this.v_kh.txtMaKH.getText().equals("") || this.v_kh.txtTenKH.getText().equals("")) {
			JOptionPane.showMessageDialog(this.v_kh, "Vui lòng nhập đầy đủ thông tin");
		} else {
			khoaHoc kh = new khoaHoc(this.v_kh.txtMaKH.getText(), this.v_kh.txtTenKH.getText());
			khoaHoc khDAO = khoaHocDAO.khoaHocDAO().selectG(kh);
			if(kh.getmaKH().equals(khDAO.getmaKH())) {
				if(kh.gettenMH().equals(khDAO.gettenMH())) {
					JOptionPane.showMessageDialog(this.v_kh, "Không có sự thay đổi để update");
				} else {
					khoaHocDAO.khoaHocDAO().updateX(kh);
					JOptionPane.showMessageDialog(this.v_kh, "Cập nhật thành công");
				}
			} else {
				khoaHocDAO.khoaHocDAO().insertX(kh);
				JOptionPane.showMessageDialog(this.v_kh, "Thêm mới thành công");
			}
			this.updateCBX_KH();
			Object obj = kh.getmaKH() + ": " + kh.gettenMH();
			this.v_kh.cbx_MaKH_MH.setSelectedItem(obj);
		}
	}
	
	public void updateCBX_KH() {
		this.v_kh.cbx_MaKH_MH.removeAllItems();
		final DefaultComboBoxModel cbm2 = (DefaultComboBoxModel) this.v_kh.cbx_MaKH_MH.getModel();
		ArrayList<khoaHoc> list1 = khoaHocDAO.khoaHocDAO().selectAll();
		for (khoaHoc khoaHoc : list1) {
			cbm2.addElement(khoaHoc.getmaKH() + ": " + khoaHoc.gettenMH());
		}
		
		this.v_kh.cbx_MaKH_MH.repaint();
		this.v_kh.cbx_MaKH_MH.revalidate();
	}
	
	public void deleteKH() {
		if(this.v_kh.txtMaKH.getText().equals("")) {
			JOptionPane.showMessageDialog(this.v_kh, "Vui lòng nhập mã khóa học cần xóa");
		} else {
			khoaHoc kh = new khoaHoc(this.v_kh.txtMaKH.getText(), this.v_kh.txtTenKH.getText());
			khoaHoc khDAO = khoaHocDAO.khoaHocDAO().selectG(kh);
			if(kh.getmaKH().equals(khDAO.getmaKH())) {
				int i = JOptionPane.showConfirmDialog(this.v_kh, "Bạn có chắn chắn muốn xóa khóa học này?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION) {
					khoaHocDAO.khoaHocDAO().deleteX(kh);
					JOptionPane.showMessageDialog(this.v_kh, "Delete thành công");
					this.updateCBX_KH();
					DefaultTableModel table_model = (DefaultTableModel) this.v_kh.table.getModel();
					table_model.setRowCount(0);
					this.loadTable();
					this.newMH();
					this.newKH();
				}
			} else {
				JOptionPane.showMessageDialog(this.v_kh, "Khóa học này chưa tồn tại");
			}
		}
	}
	
	public void saveMH() {
		try {
			DefaultTableModel table_model = (DefaultTableModel) this.v_kh.table.getModel();
			Double tongGioHoc = Double.valueOf(this.v_kh.txt_TongGioHoc.getText());
			Integer soHocVien = 0;
			String maMH = this.v_kh.txt_MaMH.getText();
			String tenMH = this.v_kh.txt_TenMH.getText();
			
//			String giangVien = this.v_kh.cbx_GiangVien.getSelectedItem().toString();
			String khoaHoc = this.v_kh.cbx_MaKH_MH.getSelectedItem().toString().substring(0,this.v_kh.cbx_MaKH_MH.getSelectedItem().toString().indexOf(": "));
			if(this.v_kh.lbl_imgMH.getText().equals("Hình môn học")) {
				fileName = "";
			} 
			String hinhMh = fileName;
			if(hinhMh.equals("") || maMH.equals("") || tenMH.equals("") || khoaHoc.equals("")) {
				System.out.println(hinhMh.equals(""));
				JOptionPane.showMessageDialog(this.v_kh, "Vui lòng nhập đầy đủ thông tin");
			} else {
				monHoc mh = new monHoc(maMH, tenMH, khoaHoc, hinhMh, tongGioHoc, soHocVien, null, "") ;
				monHoc mhDAO = monHocDAO.monHocDAO().selectG(mh);
				
				if(mh.getMaMH().equals(mhDAO.getMaMH())) {
					if(mh.getTenMH().equals(mhDAO.getTenMH()) && mh.getSoGioHoc().equals(mhDAO.getSoGioHoc()) && mh.getEmailGV().equals(mhDAO.getEmailGV()) && mh.getMaKH().equals(mhDAO.getMaKH()) && mh.getHinhMH().equals(mhDAO.getHinhMH())) {
						JOptionPane.showMessageDialog(this.v_kh, "Không có sự thay đổi để update");
					} else {
						monHocDAO.monHocDAO().updateVL(mh);
						
						monHocChiTiet mhct = new monHocChiTiet(mh.getMaMH(), mh.getEmailGV());
						monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG(mhct);
//						if((mhctDAO.getMaGiangVien() == null || mhctDAO.getMaGiangVien().equals("")) && (mhctDAO.getMaMH() == null || mhctDAO.getMaMH().equals(""))) {
//							monHocChiTietDAO.getmonHocChiTietDAO().insertX(mhct);
//						} else {
//							monHocChiTietDAO.getmonHocChiTietDAO().updateX(mhct);
//						}
						JOptionPane.showMessageDialog(this.v_kh, "Cập nhật thành công");
						
						for(int i = 0; i < this.v_kh.table.getRowCount(); i++) {
							if((this.v_kh.table.getValueAt(i, 1)+"").equals(mh.getMaMH())) {
								this.v_kh.table.setValueAt(mh.getMaKH(), i, 0);
								this.v_kh.table.setValueAt(mh.getTenMH(), i, 2);
								this.v_kh.table.setValueAt(mh.getSoGioHoc() +" Hours", i, 3);
//								this.v_kh.table.setValueAt(mh.getSoLuongHV(), i, 4);
//								this.v_kh.table.setValueAt(mh.getEmailGV(), i, 5);
							}
						}
					}
				} else {
					monHocDAO.monHocDAO().insertX(mh);
					monHocChiTiet mhct = new monHocChiTiet(mh.getMaMH(), mh.getEmailGV());
					monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG(mhct);
//					monHocChiTietDAO.getmonHocChiTietDAO().insertX(mhct);
					JOptionPane.showMessageDialog(this.v_kh, "Thêm mới thành công");
					
					table_model.addRow(new Object[] {mh.getMaKH(), mh.getMaMH(), mh.getTenMH(), mh.getSoGioHoc() +" Hours", mh.getSoLuongHV(), mh.getEmailGV()});
					this.v_kh.table.setRowSelectionInterval(this.v_kh.table.getRowCount()-1, this.v_kh.table.getRowCount()-1);
					
				}
			}
			
			
		} catch (Exception e) {
			if(this.v_kh.txt_TongGioHoc.getText().equals("")) {
				JOptionPane.showMessageDialog(this.v_kh, "Vui lòng nhập đầy đủ thông tin");
			} else {
				JOptionPane.showMessageDialog(this.v_kh, "Tổng giờ học phải là số");
				e.printStackTrace();
			}
		}
	}
	
	public void deleteMH() {
		if(this.v_kh.txt_MaMH.getText().equals("")) {
			JOptionPane.showMessageDialog(this.v_kh, "Vui lòng nhập mã môn học cần xóa");
		} else {
			monHoc mh = new monHoc();
			mh.setMaMH(this.v_kh.txt_MaMH.getText());
			monHoc mhDAO = monHocDAO.monHocDAO().selectG(mh);
			if(mh.getMaMH().equals(mhDAO.getMaMH())) {
				int i = JOptionPane.showConfirmDialog(this.v_kh, "Bạn có chắn chắn muốn xóa khóa học này?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION) {
					monHocDAO.monHocDAO().deleteX(mh);
					int i_row = this.v_kh.table.getSelectedRow();
					DefaultTableModel table_model = (DefaultTableModel)this.v_kh.table.getModel();
					table_model.removeRow(i_row);
					JOptionPane.showMessageDialog(this.v_kh, "Delete thành công");

					if(i_row > this.v_kh.table.getRowCount() - 1) {
						this.v_kh.table.setRowSelectionInterval(this.v_kh.table.getRowCount() - 1, this.v_kh.table.getRowCount() - 1);
						this.focusTable();
					} else {
						this.v_kh.table.setRowSelectionInterval(i_row, i_row);
						this.focusTable();
					}
					
				}
			} else {
				JOptionPane.showMessageDialog(this.v_kh, "Khóa học này chưa tồn tại");
			}
		}
	}
	
	public void filterTableQLKH() {
		ArrayList<khoaHoc> listKH = khoaHocDAO.khoaHocDAO().selectAll();
		ArrayList<JCheckBox> listxx = new ArrayList<>();
		
		
		for (khoaHoc khoaHoc : listKH) {
			JCheckBox cbx = new JCheckBox(khoaHoc.gettenMH());
			cbx.setBackground(null);
			listxx.add(cbx);
		}
		Object obj1[] = listxx.toArray();
		
		
		int i = JOptionPane.showConfirmDialog(this.v_kh, obj1, "Title", JOptionPane.YES_NO_OPTION);
		if(i == JOptionPane.YES_OPTION) {
			DefaultTableModel table_model = (DefaultTableModel) this.v_kh.table.getModel();
			table_model.setRowCount(0);
			for (Object object : obj1) {
				if(((JCheckBox)object).isSelected()) {
					String tenKH = ((JCheckBox)object).getText();
					khoaHoc kh = new khoaHoc(tenKH, tenKH);
					ArrayList<monHoc> list = monHocDAO.monHocDAO().selectKH(kh);
					for (monHoc monHoc : list) {
//						int slhv = monHocDAO.monHocDAO().selectSLHV(monHoc);
						monHocChiTiet mhct = new monHocChiTiet();
						mhct.setMaMH(monHoc.getMaMH());
						monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG(mhct);
						table_model.addRow(new Object[] {monHoc.getMaKH(), monHoc.getMaMH(), monHoc.getTenMH(), monHoc.getSoGioHoc() + " Hours"});
					}
				}
			}
		}
	}
	
	public void xemDiem() {
		this.v_kh.contentPane.removeAll();
		this.v_kh.contentPane.add(this.v_kh.lblXemThem);
		this.v_kh.contentPane.add(this.v_kh.panel_left);
		this.v_kh.contentPane.add(this.v_kh.panel_top);
		this.v_kh.contentPane.add(this.v_kh.xemDiem());
		this.v_kh.contentPane.repaint();
		this.v_kh.contentPane.revalidate();
		
		String s = this.v_kh.lblName.getText();
		
		thongTinCN tt = thongTinCNDAO.thongTinCNDAO().selectN(s);
		
		ArrayList<monHoc> test = diemMonDAO.diemMonDAO().selectTenMon(s);
		for (monHoc monHoc : test) {
			if(monHoc.getMaMH().equals("1")) {
				
				this.v_kh.lblTenMon1.setText(monHoc.getTenMH());
				
				String tenMH = monHoc.getTenMH();
				
				ArrayList<diemMon> list = diemMonDAO.diemMonDAO().selectDiem(tenMH);
				DefaultTableModel table_model = (DefaultTableModel)this.v_kh.tblMon1.getModel();
				int i = 1;
				for (diemMon diemMon : list) {
					table_model.addRow(new Object[] {i, diemMon.getTenDD(), diemMon.getTrongSo(), diemMon.getDiem(), diemMon.getGhiChu()});
					i++;
					if(diemMon.getTenDD().equals("Assignment")) {
						if(diemMon.getDiem() <= 0) {
							this.v_kh.lbltt1.setText("Đang theo học");
						} else if(diemMon.getDiem() < 5) {
							this.v_kh.lbltt1.setText("Đã rớt môn");
						} else {
							this.v_kh.lbltt1.setText("Đã hoàn thành");
						}
					}
				}
				
			} else if(monHoc.getMaMH().equals("2")) {

				this.v_kh.lblTenMon2.setText(monHoc.getTenMH());
				
				String tenMH = monHoc.getTenMH();
				
				ArrayList<diemMon> list = diemMonDAO.diemMonDAO().selectDiem(tenMH);
				DefaultTableModel table_model = (DefaultTableModel)this.v_kh.tblMon2.getModel();
				int i = 1;
				for (diemMon diemMon : list) {
					table_model.addRow(new Object[] {i, diemMon.getTenDD(), diemMon.getTrongSo(), diemMon.getDiem(), diemMon.getGhiChu()});
					i++;
					if(diemMon.getTenDD().equals("Assignment")) {
						if(diemMon.getDiem() <= 0) {
							this.v_kh.lbltt2.setText("Đang theo học");
						} else if(diemMon.getDiem() < 5) {
							this.v_kh.lbltt2.setText("Đã rớt môn");
						} else {
							this.v_kh.lbltt2.setText("Đã hoàn thành");
						}
					}
				}
				
			} else if(monHoc.getMaMH().equals("3")) {

				this.v_kh.lblTenMon3.setText(monHoc.getTenMH());
				
				String tenMH = monHoc.getTenMH();
				
				ArrayList<diemMon> list = diemMonDAO.diemMonDAO().selectDiem(tenMH);
				DefaultTableModel table_model = (DefaultTableModel)this.v_kh.tblMon3.getModel();
				int i = 1;
				for (diemMon diemMon : list) {
					table_model.addRow(new Object[] {i, diemMon.getTenDD(), diemMon.getTrongSo(), diemMon.getDiem(), diemMon.getGhiChu()});
					i++;
					if(diemMon.getTenDD().equals("Assignment")) {
						if(diemMon.getDiem() <= 0) {
							this.v_kh.lbltt3.setText("Đang theo học");
						} else if(diemMon.getDiem() < 5) {
							this.v_kh.lbltt3.setText("Đã rớt môn");
						} else {
							this.v_kh.lbltt3.setText("Đã hoàn thành");
						}
					}
				}
				
				
			}
		}
		
		
//		ArrayList<diemMon> list = diemMonDAO.diemMonDAO().selectX(tt.getEmail());
//		for (diemMon diemMon : list) {
//			System.out.println(diemMon.toString());
//		}
	}
	
	public void goToMonHocCuaToi() {
		if(!this.v_kh.txt_MaMH.getText().equals("")) {
			this.v_kh.contentPane.removeAll();
			this.v_kh.contentPane.add(this.v_kh.lblXemThem);
			this.v_kh.contentPane.add(this.v_kh.panel_left);
			this.v_kh.contentPane.add(this.v_kh.panel_top);
			this.v_kh.contentPane.add(this.v_kh.monHocCuaToi());
			this.v_kh.contentPane.repaint();
			this.v_kh.contentPane.revalidate();
			
			for(int i = 0; i < this.v_kh.table_MH.getRowCount(); i++) {
				if(this.v_kh.txt_MaMH.getText().equals(this.v_kh.table_MH.getValueAt(i, 1))) {
					this.v_kh.table_MH.setRowSelectionInterval(i, i);
					this.v_kh.clickTableMH();
				}
			}
			
		}
	}
}
