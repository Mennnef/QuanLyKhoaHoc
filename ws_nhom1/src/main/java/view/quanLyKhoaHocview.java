package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ImageIcon;

import DAO.caHocDAO;
import DAO.dangKyMHDAO;
import DAO.diaDiemHocDAO;
import DAO.diemChiTietDAO;
import DAO.diemSoDAO;
import DAO.khoaHocDAO;
import DAO.lopHocDAO;
import DAO.monHocChiTietDAO;
import DAO.monHocDAO;
import DAO.thongTinCNDAO;
import DAO.userDAO;
import DAO.waitAcceptDAO;
import Util.JDBCUtil;
import controller.controllerKhoaHoc;
import model.caHoc;
import model.dangKyMH;
import model.diaDiemHoc;
import model.diemChiTiet;
import model.diemSo;
import model.khoaHoc;
import model.lopHoc;
import model.monHoc;
import model.monHocChiTiet;
import model.thongTinCN;
import model.user;
import model.waitAccept;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class quanLyKhoaHocview extends JFrame {
	public String nameLogin, nameLoginTemp;
	public String xemThemMH;
	public String nameKH;
	
	public JLabel lblXemDiemCT;
	
	public controllerKhoaHoc c = new controllerKhoaHoc(this);
	public JPanel contentPane;
	public Font customFont;
	public JTextField textField;
	public JLabel lblTTCN;
	public JLabel lblXemThem;
	public JPanel panel_top;
	public JPanel panel_left;
	public JLabel lblDSKH;
	public JLabel lblName;
	public ImageAvatar avatar;
	public ImageAvatar imgLogin;
	public JPanel panel1;
	public JPanel panel2;
	public JPanel panel3;
	public JPanel panel4;
	public JPanel panel5;
	public JPanel panel6;
	public JPanel panel7;
	public JPanel panel8;
	public JPanel panel9;
	public JPanel panel_2;
	public JLabel lblImage1;
	
	public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel lblMonHoc1;
//    public javax.swing.JPanel pnlXemDiem;
    public javax.swing.JTable tblMon1;
    public javax.swing.JTable tblMon2;
    public javax.swing.JTable tblMon3;
    public JLabel lblTenMon2;
    public JLabel lblMonHoc2;
    public JLabel lblTenMon3;
    public JLabel lblMonHoc3;
	public JLabel lblTenMon1;
	public JLabel lblTrangThaiMon3;
	public JLabel lblTrangThaiMon1;
	public JLabel lblTrangThaiMon2;
	public JLabel lbltt1;
	public JLabel lbltt2;
	public JLabel lbltt3;
	public JButton btnDangky;
	public JLabel lblSoLuongHV;
	public JLabel lblTitleKH;
	public JButton btnTroVe;
	public String roleLogin = "", roleLoginTemp = "";
	public JTable table;
	public JLabel lblQLKH;
	public JLabel lblMHCT;
	
	public RoundedBorder rb1 = new RoundedBorder(null, 1, 16);
	public JTextField txtMaKH;
	public JTextField txtTenKH;
	public JTextField txt_MaMH;
	public JTextField txt_TenMH;
	public JTextField txt_TongGioHoc;
	public JComboBox cbx_MaKH_MH;
	public JLabel lbl_imgMH;
	public JLabel lblQLND;
	public JScrollPane scrollPanel_centerDSKH;
	public JTable table_User;
	public JTable table_teacher;
	public JLabel lbl_numSLHV;
	public JLabel lbl_numSLGV;
	public JLabel lbl_numSLWait;
	
	public JPanel panelDSKH;
	public JTextField txtSearchCourch;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JTextField txtXxxx;
	public JTextField txtEmail;
	public JTextField txtName;
	public JTextField txtSdt;
	public JPasswordField txtPass;
	
	public JPanel panelTTCN;
	public JTextField txtKN;
	public JTextField txtCM;
	public JButton btnDKGV;
	public JButton btnSubmit;
	public JLabel lblBottom;
	
	public JComboBox cbThoiGian;
	public JComboBox cbDiaDiem;
	public JComboBox cbLopHoc;
	
	public JLabel lblAvataGV;
	public JLabel lblTenGV;
	public JLabel lblEmailGV;
	public JLabel lblSDTGV;
	public JLabel lblSoGioHoc;
	public JTextField txtDuKienHoc;
	public JTable table_MH;
	public JTable table_MHCT;
	public JTable table_HV;
	public JLabel lblNewLabel_4;
	public JLabel lblNewLabel_5;
	public JLabel lblNewLabel_6;
	public JTextField txtTKTK;
	public JLabel lblNewLabel_7;
	public JLabel lblNewLabel_8;
	public JComboBox cbTTMH_TG;
	public JLabel lblNewLabel_9;
	public JComboBox cbTTMH_DD;
	public JLabel lblNewLabel_10;
	public JLabel lblNewLabel_13;
	public JTextField txtMaTTMH;
	public JLabel btnDeleteMH;
	public JComboBox cbTTMH_LH;
	public JLabel lblNewLabel_12;
	public JLabel lblNewLabel_15;
	public JTextField txtTTHV_TenHV;
	public JLabel lblNewLabel_16;
	public JTextField txtTTHV_Email;
	public JLabel lblNewLabel_17;
	public JTextField txtTTHV_Phone;
	public JLabel btnXemThemTTHV;
	public JLabel btnTimMH;
	public JLabel btnSaveTTMH;
	
	public JComboBox cbTTMH_EmailGV, cbTimTheo;
	public JLabel btnResetMH;
	public String maMHPublic;
	public String maLopPublic;
	public String maGiangVienPublic;
	public String timeStartPublic;
	public String timeEndPublic;
	public JLabel lblCV;
	private JTable tableMH_UserCT;
	private JTable table_DSLH;
	private JTable table_DSHV;
	private JTable table_DSCT;
	private JTextField lblEmailUserCT;
	private JTextField lblNameUserCT;
	private JTextField lblPhoneUserCT;
	private JTextField lblRoleUserCT;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
					quanLyKhoaHocview frame = new quanLyKhoaHocview("admin");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public quanLyKhoaHocview(String name) {
		try {
		    //create the font to use. Specify the size!
		    customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\Admin\\Downloads\\New folder\\Lato-Light.ttf")).deriveFont(20f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(customFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		this.nameLogin = name;
		user uLogin = new user();
		uLogin.setUsername(nameLogin);
		user uLoginDAO = userDAO.getUserDAO().selectG(uLogin);
		this.roleLogin = uLoginDAO.getRole();
		
		this.roleLoginTemp = this.roleLogin;
		this.nameLoginTemp = this.nameLogin;
		
		thongTinCN tt = new thongTinCN(name);
		thongTinCN ttcn = thongTinCNDAO.thongTinCNDAO().selectG(tt);
		setAutoRequestFocus(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1403, 816);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 226, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_left = new JPanel();
		panel_left.setBackground(new Color(45, 45, 82));
		panel_left.setBounds(0, 92, 264, 700);
		panel_left.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panel_left);
		panel_left.setLayout(null);
		
		imgLogin = new ImageAvatar();
		imgLogin.setLocation(16, 20);
		imgLogin.setSize(90, 90);
		imgLogin.setBackground(new java.awt.Color(102, 51, 255));
        imgLogin.setGradientColor1(new Color(71, 61, 255));
        imgLogin.setGradientColor2(new Color(211, 236, 6));
        imgLogin.setImage(new javax.swing.ImageIcon((Paths.get("icon\\" + ttcn.getAvatar()).toAbsolutePath().toString())));
        panel_left.add(imgLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(0, 610, 264, 2);
		panel_left.add(separator);
		
		lblName = new JLabel("");
		
		
		lblName.setText(ttcn.getName());
		
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBackground(new Color(45, 45, 82));
		lblName.setOpaque(true);
		lblName.setBounds(128, 52, 117, 46);
		lblName.setForeground(new Color(255, 255, 255));
		panel_left.add(lblName);
		
		ImageIcon ii1 = new ImageIcon((Paths.get("icon\\xemTT.png")).toString());
		Image im1 = ii1.getImage();
		Image image1 = im1.getScaledInstance(128, 110, Image.SCALE_SMOOTH);
		ImageIcon imageIcon1 = new ImageIcon(image1);
		ImageIcon ii2 = new ImageIcon((Paths.get("icon\\qlkh.png")).toString());
		Image im2_1 = ii2.getImage();
		Image image2 = im2_1.getScaledInstance(128, 110, Image.SCALE_SMOOTH);
		ImageIcon imageIcon2 = new ImageIcon(image2);
		ImageIcon ii3 = new ImageIcon((Paths.get("icon\\qlttAll.png")).toString());
		Image im3 = ii3.getImage();
		Image image3 = im3.getScaledInstance(128, 113, Image.SCALE_SMOOTH);
		ImageIcon imageIcon3 = new ImageIcon(image3);
		ImageIcon ii4 = new ImageIcon((Paths.get("icon\\thongke.png")).toString());
		Image im4 = ii4.getImage();
		Image image4 = im4.getScaledInstance(128, 110, Image.SCALE_SMOOTH);
		ImageIcon imageIcon4 = new ImageIcon(image4);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.logout();
			}
		});
		btnExit.setBackground(new Color(34, 44, 50));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setOpaque(false);
		btnExit.setFocusPainted(false);
		btnExit.setIcon(new ImageIcon((Paths.get("icon\\logout24.png")).toString()));
		btnExit.setBounds(199, 627, 55, 55);
		panel_left.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("   HEADER");
		lblNewLabel.setBackground(new Color(25, 38, 41));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(54, 65, 70));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 120, 264, 46);
		panel_left.add(lblNewLabel);
		
		
		lblDSKH = new JLabel("  Danh sách khóa học");
		lblDSKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDSKH.addMouseListener(c);
		lblDSKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDSKH.setForeground(new Color(255,144,0));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblDSKH.setForeground(new Color(255,255,255));
			}
		});
		ImageIcon ii = new ImageIcon((Paths.get("icon\\tableW32.png").toAbsolutePath().toString()));
		lblDSKH.setIcon(ii);
		lblDSKH.setForeground(new Color(255, 255, 255));
		lblDSKH.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDSKH.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblDSKH.setBounds(0, 176, 264, 54);
		
		panel_left.add(lblDSKH);
		
		lblTTCN = new JLabel(" Thông tin cá nhân");
		lblTTCN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTTCN.setForeground(new Color(255, 255, 255));
		lblTTCN.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTTCN.setBorder(new EmptyBorder(10, 5, 10, 10));
		lblTTCN.setBounds(0, 240, 264, 54);
		ImageIcon icc2 = new ImageIcon((Paths.get("icon\\qlttW.png").toAbsolutePath().toString()));
		Image imm2 = icc2.getImage();
		Image ima2 = imm2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		ImageIcon imaIcon2 = new ImageIcon(ima2);
		lblTTCN.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblTTCN.setForeground(new Color(255, 255, 255));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTTCN.setForeground(new Color(255,144,0));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblTTCN.setIcon(imaIcon2);
		lblTTCN.addMouseListener(c);
		panel_left.add(lblTTCN);
		
		lblQLKH = new JLabel(" Quản lý khóa học");
		lblQLKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblQLKH.addMouseListener(c);
		lblQLKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblQLKH.setForeground(new Color(255, 255, 255));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblQLKH.setForeground(new Color(255,144,0));
			}
		});
		lblQLKH.setForeground(new Color(255, 255, 255));
		lblQLKH.setFont(new Font("Arial", Font.PLAIN, 16));
		lblQLKH.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblQLKH.setBounds(0, 432, 264, 54);
		ImageIcon icc4 = new ImageIcon((Paths.get("icon\\qtkhW.png").toAbsolutePath().toString()));
		Image img4 = icc4.getImage();
		Image ima4 = img4.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon imaIcon4 = new ImageIcon(ima4);
		lblQLKH.setIcon(imaIcon4);
		
		if(this.roleLogin.equals("admin")) {
			panel_left.add(lblQLKH);
		}
		
		lblQLND = new JLabel(" Quản lý người dùng");
		lblQLND.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblQLND.addMouseListener(c);
		lblQLND.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblQLND.setForeground(new Color(255, 255, 255));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblQLND.setForeground(new Color(255,144,0));
			}
		});
		lblQLND.setForeground(new Color(255, 255, 255));
		lblQLND.setFont(new Font("Arial", Font.PLAIN, 16));
		lblQLND.setBorder(new EmptyBorder(10, 7, 10, 10));
		lblQLND.setBounds(0, 496, 264, 54);
		ImageIcon icc3 = new ImageIcon((Paths.get("icon\\zzz.png").toAbsolutePath().toString()));
		Image img3 = icc3.getImage();
		Image ima3 = img3.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon imaIcon3 = new ImageIcon(ima3);
		lblQLND.setIcon(imaIcon3);
		
		if(this.roleLogin.equals("admin")) {
			panel_left.add(lblQLND);
		}
		
		
		lblXemDiemCT = new JLabel(" Xem điểm");
		lblXemDiemCT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblXemDiemCT.setForeground(new Color(255, 255, 255));
		lblXemDiemCT.setFont(new Font("Arial", Font.PLAIN, 16));
		lblXemDiemCT.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblXemDiemCT.setBounds(0, 304, 264, 54);
		ImageIcon ico4 = new ImageIcon((Paths.get("icon\\diemCT.jpg").toAbsolutePath().toString()));
		Image imge4 = ico4.getImage();
		Image imag4 = imge4.getScaledInstance(30, 24, Image.SCALE_SMOOTH);
		ImageIcon imagIcon4 = new ImageIcon(imag4);
		lblXemDiemCT.setIcon(imagIcon4);
		lblXemDiemCT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblXemDiemCT.setForeground(new Color(255, 255, 255));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblXemDiemCT.setForeground(new Color(255,144,0));
			}
		});
		lblXemDiemCT.addMouseListener(c);
		panel_left.add(lblXemDiemCT);
		
		lblMHCT = new JLabel(" Môn học của tôi");
		lblMHCT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMHCT.setForeground(Color.WHITE);
		lblMHCT.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMHCT.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblMHCT.setBounds(0, 368, 264, 54);
		ImageIcon ico5 = new ImageIcon((Paths.get("icon\\caigido.jpg").toAbsolutePath().toString()));
		Image imge5 = ico5.getImage();
		Image imag5 = imge5.getScaledInstance(30, 24, Image.SCALE_SMOOTH);
		ImageIcon imagIcon5 = new ImageIcon(imag5);
		lblMHCT.setIcon(imagIcon5);
		lblMHCT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblMHCT.setForeground(new Color(255, 255, 255));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMHCT.setForeground(new Color(255,144,0));
			}
		});
		lblMHCT.addMouseListener(c);
		
		if(this.roleLogin.equals("admin")) {
			panel_left.add(lblMHCT);
		}
		
//		JLabel lblOnline = new JLabel(" Online");
//		lblOnline.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblOnline.setIcon(new ImageIcon((Paths.get("icon\\online16.png")).toAbsolutePath().toString()));
//		lblOnline.setForeground(new Color(255, 255, 255));
//		lblOnline.setFont(new Font("Arial", Font.PLAIN, 18));
//		lblOnline.setBounds(180, 10, 80, 22);
//		panel_left.add(lblOnline);
		
		panel_top = new JPanel(); 
		panel_top.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_top.setBackground(new Color(64, 64, 116));
		panel_top.setBounds(0, 0, 264, 94);
		contentPane.add(panel_top);
		panel_top.setLayout(null);
		
		JLabel lblTitle = new JLabel("Phần mềm quản lý khóa học");
		lblTitle.setBackground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 19));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(10, 10, 249, 74);
		panel_top.add(lblTitle);
		
		lblXemThem = new JLabel("");
		lblXemThem.setIcon(new ImageIcon((Paths.get("icon\\xemThem.jpg")).toAbsolutePath().toString()));
		lblXemThem.setBounds(1312, 15, 66, 54);
		contentPane.add(lblXemThem);
		
		// Ao ma atenta
		
		
		// zo	
		contentPane.add(xemDSKH());
		
	}
	
	public void loadDSKH() {
			ArrayList<monHoc> list = monHocDAO.monHocDAO().selectMH(txtSearchCourch.getText());
			int count = 0;
			int temp = -1;
			int xx = 0;
			panel_2.setPreferredSize(new Dimension(1116, 696));
			
			if(list.isEmpty() && !txtSearchCourch.getText().equals("") && !txtSearchCourch.getText().equals("Search Courses")) {
				panel_2.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel jLabel = new JLabel("Không tìm thấy môn học này", JLabel.CENTER);
				jLabel.setFont(new Font("Arial", Font.BOLD, 46));
				panel_2.add(jLabel);
			} else {
				if(txtSearchCourch.getText().equals("Search Courses") || txtSearchCourch.getText().equals("")) {
					list = monHocDAO.monHocDAO().selectAll();
				}
				panel_2.setLayout(new GridLayout(0, 3, 25, 25));
				
				for (monHoc monHoc : list) {
					temp++;
					if(temp > 8 && temp % 3 == 0) {
						xx++;
						panel_2.setPreferredSize(new Dimension(scrollPanel_centerDSKH.getWidth() - 22, scrollPanel_centerDSKH.getHeight() + 220*xx + 52));
					} else if(temp <= 8){
						panel_2.setPreferredSize(new Dimension(scrollPanel_centerDSKH.getWidth() - 22, scrollPanel_centerDSKH.getHeight() + 52));
					}
					
					JPanel panel10 = new JPanel();
					panel10.setBackground(new Color(255, 255, 255));
					panel10.setForeground(new Color(255, 255, 255));
					panel10.setLayout(null);
					panel10.setBorder(new EmptyBorder(0, 0, 0, 0));
					panel_2.add(panel10);
					
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
					btn10.addActionListener(c);
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
					panel_2.add(panel);
					panel.setVisible(false);
				}
				
			}
			contentPane.revalidate();
			contentPane.repaint();
	}
	
	public void chage() {
		panel_2.removeAll();
		loadDSKH();
	}
	
	public JPanel xemDSKH() {
		scrollPanel_centerDSKH = new JScrollPane();
		scrollPanel_centerDSKH.setBounds(1, 64, 1138, 636);
		scrollPanel_centerDSKH.setBorder(new EmptyBorder(0,0,0,0));
		panelDSKH = new JPanel();
		panelDSKH.setBounds(263, 92, 1138, 698);
		panel_2 = new JPanel();
		scrollPanel_centerDSKH.setViewportView(panel_2);
		panel_2.setBorder(new EmptyBorder(25, 38, 25, 38));
		panel_2.setBackground(new Color(195, 209, 226));
		panel_2.setLayout(new GridLayout(0, 3, 25, 25));
		
		lblNewLabel_3 = new JLabel("Category:");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBackground(SystemColor.menu);
		lblNewLabel_3.setBounds(433, 20, 99, 34);
		panelDSKH.add(lblNewLabel_3);
		
		JButton btnFilter = new JButton("");
		btnFilter.setBounds(533, 19, 32, 36);
		panelDSKH.add(btnFilter);
		btnFilter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.filter();
			}
		});
		btnFilter.setIcon(new ImageIcon((Paths.get("icon\\filter24.png")).toString()));
		btnFilter.setOpaque(false);
		btnFilter.setFocusPainted(false);
		btnFilter.setBackground(new Color(218, 218, 218));
		
		lblNewLabel_2 = new JLabel("Sort By:");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(745, 20, 84, 34);
		panelDSKH.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Release date (newest first)", "Release date (oldest first)"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(839, 18, 242, 38);
		panelDSKH.add(comboBox);
		
		txtSearchCourch = new JTextField();
		txtSearchCourch.setEnabled(false);
		txtSearchCourch.setEditable(false);
		txtSearchCourch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtSearchCourch.setEditable(true);
				txtSearchCourch.setEnabled(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				txtSearchCourch.setEditable(false);
				txtSearchCourch.setEnabled(false);
			}
		});
		txtSearchCourch.setForeground(new Color(128, 128, 128));
		txtSearchCourch.setText("Search Courses");
		txtSearchCourch.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSearchCourch.setBounds(40, 20, 180, 34);
		panelDSKH.add(txtSearchCourch);
		txtSearchCourch.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setBounds(221, 20, 32, 34);
		panelDSKH.add(btnSearch);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.search();
			}
		});
		btnSearch.setIcon(new ImageIcon((Paths.get("icon\\search24.png")).toString()));
		btnSearch.setOpaque(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setBackground(new Color(218, 218, 218));
		
		txtSearchCourch.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearchCourch.getText().equals("") || txtSearchCourch.getText().equals("Search Courses")) {
					txtSearchCourch.setText("");
					txtSearchCourch.setFont(new Font("Arial", Font.PLAIN, 16));
					txtSearchCourch.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtSearchCourch.getText().equals("") || txtSearchCourch.getText().equals("Search Courses")) {
					txtSearchCourch.setText("Search Courses");
					txtSearchCourch.setFont(new Font("Arial", Font.PLAIN, 16));
					txtSearchCourch.setForeground(Color.GRAY);
				}
			}
		});
		txtSearchCourch.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				chage();
			} 
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				chage();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				chage();
			}
		});
		
		
		int temp = -1;
		int xx = 0;
		
		ArrayList<monHoc> list = monHocDAO.monHocDAO().selectAll();
		
		for (monHoc monHoc : list) {
			temp++;
			if(temp > 8 && temp % 3 == 0) {
				xx++;
				panel_2.setPreferredSize(new Dimension(scrollPanel_centerDSKH.getWidth() - 22, scrollPanel_centerDSKH.getHeight() + 220*xx + 52));
			} else if(temp <= 8){
				panel_2.setPreferredSize(new Dimension(scrollPanel_centerDSKH.getWidth() - 22, scrollPanel_centerDSKH.getHeight() + 52));
			}
			JPanel panel10 = new JPanel();
			panel10.setBackground(new Color(255, 255, 255));
			panel10.setForeground(new Color(255, 255, 255));
			panel10.setLayout(null);
			panel10.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel_2.add(panel10);
			
			JLabel lblTitle10 = new JLabel(monHoc.getMaMH() + ": " +monHoc.getTenMH());
			lblTitle10.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle10.setFont(new Font("Arial", Font.PLAIN, 18));
			lblTitle10.setBounds(20, 129, 289, 33);
			panel10.add(lblTitle10);
			
			
			JButton btn10 = new JButton("Xem thêm");
			btn10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn10.setBackground(new Color(255, 255, 255));
			btn10.setFont(new Font("Arial", Font.BOLD, 14));
			btn10.setBounds(111, 168, 111, 21);
			btn10.setFocusPainted(false);
			btn10.setOpaque(false);
			btn10.addActionListener(c);
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
		}
		panelDSKH.setLayout(null);
		
		panelDSKH.add(scrollPanel_centerDSKH);
		panelDSKH.setBackground(new Color(195, 209, 226));
		
		return panelDSKH;
	}

	public JScrollPane xemTTCN(String name) {
		JPanel panel_center = new JPanel();
//		panel_2.setVisible(false);
		panel_center.setBorder(new EmptyBorder(25, 35, 25, 35));
//		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_center.setBackground(new Color(195, 209, 226));
		final JScrollPane scrollPanel_center = new JScrollPane(panel_center);
		panel_center.setLayout(null);
		
		JPanel panelAll = new JPanel();
		panelAll.setBounds(320, 70, 496, 554);
		panel_center.add(panelAll);
		panelAll.setLayout(null);
		
		panelTTCN = new JPanel();
		panelTTCN.setBounds(0, 175, 496, 379);
		panelAll.add(panelTTCN);
		panelTTCN.setLayout(null);
		
		
		
		panelTTCN.add(setPanel_TTCN());
		
		
		
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setBackground(new Color(230, 59, 59));
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 30));
		btnSubmit.setBounds(143, 299, 202, 52);
		btnSubmit.setFocusPainted(false);
		btnSubmit.addActionListener(c);
		panelTTCN.add(btnSubmit);
		
		thongTinCN tt = new thongTinCN(name);
		thongTinCN ttcn = thongTinCNDAO.thongTinCNDAO().selectG(tt);
		
		btnDKGV = new JButton("Đăng ký giảng viên");
		btnDKGV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDKGV.setForeground(new Color(255, 255, 255));
		btnDKGV.setBackground(new Color(80, 184, 182));
		btnDKGV.setFont(new Font("Arial", Font.BOLD, 13));
		btnDKGV.setBounds(31, 194, 154, 37);
		btnDKGV.setOpaque(false);
		btnDKGV.setFocusPainted(false);
		
		btnDKGV.addActionListener(c);
		
		panelTTCN.add(btnDKGV);
		
		//PANEL
		lblBottom = new JLabel("");
		lblBottom.setBounds(0, 0, 496, 379);
		ImageIcon bg_panel = new ImageIcon((Paths.get("icon\\panelttcn.jpg")).toAbsolutePath().toString()); 
		Image set_bgpanel = bg_panel.getImage();
		Image setSize_bgpanel = set_bgpanel.getScaledInstance(496, 379, Image.SCALE_SMOOTH);
		ImageIcon bg_panelSize = new ImageIcon(setSize_bgpanel);
		lblBottom.setIcon(bg_panelSize);
		
		avatar = new ImageAvatar();
		avatar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		avatar.setGradientColor2(new Color(255, 255, 255));
		avatar.setGradientColor1(new Color(255, 255, 255));
		avatar.setBackground(Color.WHITE);
		avatar.setOpaque(true);
		avatar.setBounds(165, 10, 160, 155);
		avatar.setImage(new javax.swing.ImageIcon((Paths.get("icon\\" + ttcn.getAvatar()).toAbsolutePath().toString())));
		avatar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				c.chageAvatar();
			}
		});
		panelAll.add(avatar);
		panelTTCN.add(lblBottom);
		
		
		JLabel lblTop = new JLabel("");
		lblTop.setBounds(0, 0, 496, 177);
		panelAll.add(lblTop); //avatarttcn
		ImageIcon avt_panel = new ImageIcon((Paths.get("icon\\avatarttcn.jpg")).toAbsolutePath().toString()); 
		Image set_avtpanel = avt_panel.getImage();
		Image setSize_avtpanel = set_avtpanel.getScaledInstance(496, 177, Image.SCALE_SMOOTH);
		ImageIcon avt_panelSize = new ImageIcon(setSize_avtpanel);
		lblTop.setIcon(avt_panelSize);
	
		
		scrollPanel_center.setBounds(263, 92, 1138, 698);
		
		return scrollPanel_center;
	}

	public JPanel xemDiem() {
		JPanel panel_center = new JPanel();
		panel_center.setBackground(new Color(195, 209, 226));
		panel_center.setBounds(263, 92, 1149, 700);
		panel_center.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(51, 48, 641, 213);
		panel_center.add(scrollPane_1);
		
		table_DSLH = new JTable();
		table_DSLH.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clickTableDSLH();
			}
		});
		table_DSLH.setFont(new Font("Arial", Font.PLAIN, 14));
		table_DSLH.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 m\u00F4n", "T\u00EAn m\u00F4n", "M\u00E3 l\u1EDBp", "Ca h\u1ECDc", "Gi\u1EA3ng vi\u00EAn"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_DSLH.setRowHeight(26);
		table_DSLH.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_DSLH.getColumnModel().getColumn(1).setPreferredWidth(98);
		table_DSLH.getColumnModel().getColumn(2).setPreferredWidth(20);
		
		DefaultTableModel tableModel_DSLH = (DefaultTableModel) table_DSLH.getModel();
		
		
		scrollPane_1.setViewportView(table_DSLH);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		
		scrollPane_1_1.setBounds(733, 48, 344, 213);
		panel_center.add(scrollPane_1_1);
		
		table_DSHV = new JTable();
		table_DSHV.setFont(new Font("Arial", Font.PLAIN, 14));
		table_DSHV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email h\u1ECDc vi\u00EAn", "T\u00EAn h\u1ECDc vi\u00EAn"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_DSHV.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String maMH = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 0) + "";
				String maLop = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 2) + "";
				String giangVien = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 4) + "";
				String time = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 3) + "";
				String timeStart = time.substring(0, time.indexOf(" - "));
				String timeEnd = time.substring(time.indexOf(" - ")+3);
				
				monHoc mh = new monHoc();
				mh.setMaMH(maMH);
				
				caHoc ch = new caHoc(null, timeStart, timeEnd);
				caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
				
				lopHoc lh = new lopHoc();
				lh.setMaLop(maLop);
				
				user u = new user();
				u.setUsername(giangVien);
				
				monHocChiTiet ttMhct = monHocChiTietDAO.getmonHocChiTietDAO().selectMaMHCTTheoMH(mh, chDAO, lh, u);
				clickTableDSHV(ttMhct);
			}
		});
		table_DSHV.setRowHeight(26);
		table_DSHV.getColumnModel().getColumn(0).setPreferredWidth(136);;
		
		scrollPane_1_1.setViewportView(table_DSHV);
		
		JScrollPane scrollPane_1_1_1 = new JScrollPane();
		scrollPane_1_1_1.setBounds(51, 326, 1026, 281);
		panel_center.add(scrollPane_1_1_1);
		
		table_DSCT = new JTable();
		table_DSCT.setFont(new Font("Arial", Font.PLAIN, 18));
		table_DSCT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "T\u00EAn \u0111\u1EA7u \u0111i\u1EC3m", "Tr\u1ECDng s\u1ED1", "\u0110i\u1EC3m", "Ghi ch\u00FA", "Trạng thái"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_DSCT.setRowHeight(26);
		table_DSCT.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_DSCT.getColumnModel().getColumn(2).setPreferredWidth(50);
		table_DSCT.getColumnModel().getColumn(4).setPreferredWidth(150);
		
		scrollPane_1_1_1.setViewportView(table_DSCT);
		
		JLabel lblNewLabel_18 = new JLabel("Danh sách lớp học:");
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_18.setBounds(51, 10, 180, 28);
		panel_center.add(lblNewLabel_18);
		
		JLabel lblNewLabel_18_1 = new JLabel("Danh sách học viên:");
		lblNewLabel_18_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_18_1.setBounds(733, 10, 190, 28);
		panel_center.add(lblNewLabel_18_1);
		
		JLabel lblNewLabel_18_1_1 = new JLabel("Điểm số chi tiết:");
		lblNewLabel_18_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_18_1_1.setBounds(51, 288, 157, 28);
		panel_center.add(lblNewLabel_18_1_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickSaveTableDSCT();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(504, 626, 123, 36);
		
		
		if(this.roleLoginTemp.equals("admin")) {
			ArrayList<monHocChiTiet> listMHCT = monHocChiTietDAO.getmonHocChiTietDAO().selectAll();
			for (monHocChiTiet mhct : listMHCT) {
				monHoc mh = monHocDAO.monHocDAO().selectMHCTQuaMaMH(mhct);
				caHoc ch = caHocDAO.getcaHocDAO().selectTGQuaMaCa(mhct);
				tableModel_DSLH.addRow(new Object[] {mhct.getMaMH(), mh.getTenMH(), mhct.getMaLop(), ch.getTimeStart() + " - " + ch.getTimeEnd(), mhct.getMaGiangVien()});
			}
			panel_center.add(btnNewButton);
		} else if (this.roleLoginTemp.equals("gv")) {
			dangKyMH dk = new dangKyMH();
			dk.setEmailUser(this.nameLoginTemp);
			ArrayList<monHocChiTiet> listMHCT = monHocChiTietDAO.getmonHocChiTietDAO().selectAllMHCTTheoEmailGV(dk);
			for (monHocChiTiet mhct : listMHCT) {
				monHoc mh = monHocDAO.monHocDAO().selectMHCTQuaMaMH(mhct);
				caHoc ch = caHocDAO.getcaHocDAO().selectTGQuaMaCa(mhct);
				tableModel_DSLH.addRow(new Object[] {mhct.getMaMH(), mh.getTenMH(), mhct.getMaLop(), ch.getTimeStart() + " - " + ch.getTimeEnd(), mhct.getMaGiangVien()});
			}
			panel_center.add(btnNewButton);
		} else if (this.roleLoginTemp.equals("hv")){
			dangKyMH dk = new dangKyMH();
			dk.setEmailUser(this.nameLoginTemp);
			ArrayList<monHocChiTiet> listMHCT = monHocChiTietDAO.getmonHocChiTietDAO().selectAllMHCTTheoEmail(dk);
			for (monHocChiTiet mhct : listMHCT) {
				monHoc mh = monHocDAO.monHocDAO().selectMHCTQuaMaMH(mhct);
				caHoc ch = caHocDAO.getcaHocDAO().selectTGQuaMaCa(mhct);
				tableModel_DSLH.addRow(new Object[] {mhct.getMaMH(), mh.getTenMH(), mhct.getMaLop(), ch.getTimeStart() + " - " + ch.getTimeEnd(), mhct.getMaGiangVien()});
			}
			table_DSCT.setEnabled(false);
		}
		
		
		
		if(table_DSLH.getRowCount() > 0) {
			table_DSLH.setRowSelectionInterval(0, 0);
			clickTableDSLH();
		}
		
		return panel_center;
	}
	
	public JPanel xemDiemChoHV() {
		JPanel panel_center = new JPanel();
		panel_center.setBackground(new Color(195, 209, 226));
		panel_center.setBounds(263, 92, 1149, 700);
		panel_center.setLayout(null);
		
		return panel_center;
	}

	public JScrollPane xemTTKH() {
		monHoc mhh = new monHoc();
		mhh.setMaMH(xemThemMH);
		
		monHocChiTiet mhct = new monHocChiTiet();
		mhct.setMaMH(xemThemMH);
		
		monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG(mhct);
		
		monHoc mh = monHocDAO.monHocDAO().selectG(mhh);
		thongTinCN tt = new thongTinCN();
		tt.setEmail(mhctDAO.getMaGiangVien());
		thongTinCN ttDAO = thongTinCNDAO.thongTinCNDAO().selectG(tt);
//		System.out.println(ttDAO.toString());
		panel_2 = new JPanel();
//		panel_2.setVisible(false);
		panel_2.setBorder(new EmptyBorder(25, 35, 25, 35));
//		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBackground(new Color(195, 209, 226));
		final JScrollPane scrollPanel_center = new JScrollPane(panel_2);
		panel_2.setLayout(null);
		
		lblTitleKH = new JLabel(mh.getMaMH() + ": " + mh.getTenMH());
		lblTitleKH.setFont(new Font("Arial", Font.BOLD, 34));
		lblTitleKH.setBounds(20, 10, 614, 59);
		panel_2.add(lblTitleKH);
		
		JLabel lblImageHinh = new JLabel();
		lblImageHinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageHinh.setFont(new Font("Tahoma", Font.BOLD, 47));
		lblImageHinh.setBounds(89, 79, 623, 173);
		ImageIcon ii = new ImageIcon((Paths.get("icon\\" + mh.getHinhMH())).toString());
		Image i = ii.getImage();
		Image ig = i.getScaledInstance(lblImageHinh.getWidth(), lblImageHinh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iic = new ImageIcon(ig);
		lblImageHinh.setIcon(iic);
		panel_2.add(lblImageHinh);
		
		JLabel lblTitleHocVien = new JLabel("Tổng số học viên:");
		lblTitleHocVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleHocVien.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitleHocVien.setBounds(171, 307, 148, 29);
		panel_2.add(lblTitleHocVien);
		
		lblSoLuongHV = new JLabel("");
		lblSoLuongHV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoLuongHV.setFont(new Font("Arial", Font.BOLD, 16));
		lblSoLuongHV.setBounds(171, 355, 148, 29);
		panel_2.add(lblSoLuongHV);
		
		JLabel lblImageHocVien = new JLabel();
		lblImageHocVien.setFont(new Font("Arial", Font.BOLD, 16));
		lblImageHocVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageHocVien.setBounds(89, 262, 304, 173);
		ImageIcon ii1 = new ImageIcon((Paths.get("icon\\soLuonghv.jpg")).toString());
		Image i1 = ii1.getImage();
		Image ig1 = i1.getScaledInstance(lblImageHocVien.getWidth(), lblImageHocVien.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iic1 = new ImageIcon(ig1);
		lblImageHocVien.setIcon(iic1);
		panel_2.add(lblImageHocVien);
		
		JLabel lblTitleGioHoc = new JLabel("Tổng số giờ học:");
		lblTitleGioHoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleGioHoc.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitleGioHoc.setBounds(486, 280, 148, 29);
		panel_2.add(lblTitleGioHoc);
		
		lblSoGioHoc = new JLabel(mh.getSoGioHoc()+" giờ");
		lblSoGioHoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoGioHoc.setFont(new Font("Arial", Font.BOLD, 16));
		lblSoGioHoc.setBounds(486, 318, 148, 29);
		panel_2.add(lblSoGioHoc);
		
		JLabel lblImageGioHoc = new JLabel();
		lblImageGioHoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageGioHoc.setFont(new Font("Arial", Font.BOLD, 16));
		lblImageGioHoc.setBounds(408, 262, 304, 173);
		ImageIcon ii2 = new ImageIcon((Paths.get("icon\\soGiohoc.jpg")).toString());
		Image i2 = ii2.getImage();
		Image ig2 = i2.getScaledInstance(lblImageHocVien.getWidth(), lblImageHocVien.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iic2 = new ImageIcon(ig2);
		lblImageGioHoc.setIcon(iic2);
		panel_2.add(lblImageGioHoc);
		
		btnTroVe = new JButton("Trở về");
		btnTroVe.setBounds(268, 177, 103, 32);
		btnTroVe.setFocusPainted(false);
		btnTroVe.setOpaque(false);
		btnTroVe.addActionListener(c);
		
		lblAvataGV = new JLabel();
		lblAvataGV.setBounds(748, 99, 85, 76);
		ImageIcon ii21 = new ImageIcon((Paths.get("icon\\" + ttDAO.getAvatar()).toAbsolutePath().toString()));
		Image i21 = ii21.getImage();
		Image ig21 = i21.getScaledInstance(lblAvataGV.getWidth(), lblAvataGV.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iic21 = new ImageIcon(ig21);
		lblAvataGV.setIcon(iic21);
		panel_2.add(lblAvataGV);
		
		lblEmailGV = new JLabel(ttDAO.getEmail());
		lblEmailGV.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmailGV.setBounds(837, 185, 175, 21);
		panel_2.add(lblEmailGV);
		
		lblSDTGV = new JLabel(ttDAO.getSdt());
		lblSDTGV.setFont(new Font("Arial", Font.BOLD, 14));
		lblSDTGV.setBounds(837, 214, 175, 21);
		panel_2.add(lblSDTGV);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(748, 185, 85, 21);
		panel_2.add(lblEmail);
		
		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Arial", Font.BOLD, 14));
		lblSDT.setBounds(748, 214, 85, 21);
		panel_2.add(lblSDT);
		
		lblTenGV = new JLabel(ttDAO.getName());
		lblTenGV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenGV.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTenGV.setBounds(837, 136, 193, 21);
		panel_2.add(lblTenGV);
		
		JLabel lblNewLabel_14 = new JLabel("Giảng viên:");
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_14.setBounds(886, 106, 85, 21);
		panel_2.add(lblNewLabel_14);
		
		JLabel lblGiangVien = new JLabel("");
		lblGiangVien.setBackground(new Color(255, 255, 255));
		lblGiangVien.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblGiangVien.setFont(new Font("Arial", Font.BOLD, 16));
		lblGiangVien.setBounds(722, 79, 314, 173);
		lblGiangVien.setOpaque(true);
		panel_2.add(lblGiangVien);
		
		JLabel lblNewLabel_11 = new JLabel("CƠ BẢN");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_11.setBounds(765, 432, 73, 29);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_3 = new JLabel("NÂNG CAO");
		lblNewLabel_11_3.setForeground(Color.WHITE);
		lblNewLabel_11_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_11_3.setBounds(898, 385, 85, 29);
		panel_2.add(lblNewLabel_11_3);
		
		JLabel lblNewLabel_11_1 = new JLabel("THỰC HÀNH");
		lblNewLabel_11_1.setForeground(Color.WHITE);
		lblNewLabel_11_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_11_1.setBounds(927, 475, 85, 29);
		panel_2.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_3_1 = new JLabel("DỰ ÁN");
		lblNewLabel_11_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_3_1.setForeground(Color.WHITE);
		lblNewLabel_11_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_11_3_1.setBounds(848, 518, 85, 29);
		panel_2.add(lblNewLabel_11_3_1);
		
		JTextArea txtMotaLotrinh = new JTextArea();
		txtMotaLotrinh.setEditable(false);
		txtMotaLotrinh.setText("      Ở khóa học này các bạn sẽ được đi lần lượt từ\r\n\tcơ bản đến nâng cao\r\n    Sau đó sẽ có các bài thực hành mẫu để các bạn\r\n\tcủng cố thêm kiến thức\r\nCuối cùng các bạn sẽ được tiếp cận với dự án thực tế\r\n");
		txtMotaLotrinh.setForeground(new Color(128, 128, 128));
		txtMotaLotrinh.setFont(new Font("Arial", Font.PLAIN, 12));
		txtMotaLotrinh.setBounds(734, 597, 300, 72);
		txtMotaLotrinh.setOpaque(true);
		panel_2.add(txtMotaLotrinh);
		
		JLabel lblImageLotrinh = new JLabel("");
		lblImageLotrinh.setBounds(726, 317, 304, 274);
		ImageIcon ii3 = new ImageIcon((Paths.get("icon\\vongtron.jpg")).toString());
//		ImageIcon ii3 = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ws_nhom1\\icon\\vongtron.jpg");
//		C:\Users\Admin\eclipse-workspace\ws_nhom1\icon
		Image i3 = ii3.getImage();
		Image ig3 = i3.getScaledInstance(lblImageLotrinh.getWidth(), lblImageLotrinh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iic3 = new ImageIcon(ig3);
		lblImageLotrinh.setIcon(iic3);
		panel_2.add(lblImageLotrinh);
		
		JLabel lblTitleLotrinh = new JLabel("Lộ trình môn học:");
		lblTitleLotrinh.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitleLotrinh.setBounds(732, 269, 157, 29);
		panel_2.add(lblTitleLotrinh);
		
		JLabel lblLotrinh = new JLabel("");
		lblLotrinh.setBackground(new Color(255, 255, 255));
		lblLotrinh.setBounds(722, 262, 314, 411);
		lblLotrinh.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblLotrinh.setOpaque(true);
		panel_2.add(lblLotrinh);
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(89, 445, 623, 228);
		panel.setLayout(null);
		panel.add(btnTroVe);
		panel_2.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(-2, -2, 626, 158);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblThoiGian = new JLabel("Thời gian:");
		lblThoiGian.setFont(new Font("Arial", Font.BOLD, 16));
		lblThoiGian.setBounds(24, 30, 95, 29);
		panel_1.add(lblThoiGian);
		
		JLabel lblDiaDiem = new JLabel("Địa điểm:");
		lblDiaDiem.setFont(new Font("Arial", Font.BOLD, 16));
		lblDiaDiem.setBounds(24, 97, 95, 29);
		panel_1.add(lblDiaDiem);
		
		JLabel lblLopHoc = new JLabel("Lớp học:");
		lblLopHoc.setFont(new Font("Arial", Font.BOLD, 16));
		lblLopHoc.setBounds(360, 30, 95, 29);
		panel_1.add(lblLopHoc);
		
		txtDuKienHoc = new JTextField();
		txtDuKienHoc.setEditable(false);
		txtDuKienHoc.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDuKienHoc.setBounds(465, 97, 148, 29);
		panel_1.add(txtDuKienHoc);
		txtDuKienHoc.setColumns(10);
		
		JLabel lblNewLabel_4_2 = new JLabel("Dự kiến học:");
		lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_2.setBounds(360, 97, 107, 29);
		panel_1.add(lblNewLabel_4_2);
		
		ButtonGroup bg = new ButtonGroup();
		
		cbThoiGian = new JComboBox();
		DefaultComboBoxModel<String> cbtg_model = (DefaultComboBoxModel<String>) cbThoiGian.getModel();
		monHoc cbxMH = new monHoc();
		cbxMH.setMaMH(xemThemMH);
		ArrayList<caHoc> listCH = caHocDAO.getcaHocDAO().selectAllTheoMH(cbxMH);
		for (caHoc caHoc : listCH) {
			cbtg_model.addElement(caHoc.getTimeStart() + " - " + caHoc.getTimeEnd());
		}
		
		cbThoiGian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeDD();
			}
		});
		
		cbThoiGian.setMaximumRowCount(3);
		cbThoiGian.setFont(new Font("Arial", Font.PLAIN, 14));
		cbThoiGian.setBounds(129, 30, 178, 29);
		panel_1.add(cbThoiGian);
		cbDiaDiem = new JComboBox();
//		DefaultComboBoxModel<String> cbDD_model = (DefaultComboBoxModel<String>) cbDiaDiem.getModel();
//		ArrayList<diaDiemHoc> listDDH = diaDiemHocDAO.getdiaDiemHocDAO().selectAllTheoMH(cbxMH);
//		for (diaDiemHoc diaDiemHoc : listDDH) {
//			cbDD_model.addElement(diaDiemHoc.getDiaChi());
//		}
//		
		cbDiaDiem.setMaximumRowCount(3);
		cbDiaDiem.setFont(new Font("Arial", Font.PLAIN, 14));
		cbDiaDiem.setBounds(129, 97, 178, 29);
		panel_1.add(cbDiaDiem);
		
		this.changeDD();
		
		cbLopHoc = new JComboBox();
		cbLopHoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeGV();
			}
		});
//		DefaultComboBoxModel<String> cbLH_model = (DefaultComboBoxModel<String>) cbLopHoc.getModel();
//		String maKhu = null;
//		for (diaDiemHoc diaDiemHoc : listDDH) {
//			if(cbDD_model.getSelectedItem().toString().equals(diaDiemHoc.getDiaChi())) {
//				maKhu = diaDiemHoc.getMaKhu();
//			}
//		}
//		diaDiemHoc ddhMH = new diaDiemHoc();
//		ddhMH.setMaKhu(maKhu);
//		ArrayList<lopHoc> listLH = lopHocDAO.getlopHocDAO().selectAllTaiDD(ddhMH);
//		for (lopHoc lopHoc : listLH) {
//			cbLH_model.addElement(lopHoc.getMaLop());
//		}
		
		cbDiaDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeLH();
			}
		});
		
		cbLopHoc.setMaximumRowCount(3);
		cbLopHoc.setFont(new Font("Arial", Font.PLAIN, 14));
		cbLopHoc.setBounds(465, 31, 148, 29);
		panel_1.add(cbLopHoc);
		
		
		
		this.changeLH();
		this.changeGV();
		
		btnDangky = new JButton("Đăng ký");
		btnDangky.setFont(new Font("Arial", Font.BOLD, 20));
		btnDangky.setBounds(960, 20, 141, 37);
		btnDangky.setFocusPainted(false);
		btnDangky.setOpaque(false);
		btnDangky.addActionListener(c);
		panel_2.add(btnDangky);
		
		user u = new user();
		u.setUsername(nameLogin);
		user uDAO = userDAO.getUserDAO().selectG(u);
		this.roleLogin = uDAO.getRole();
		
		if(this.roleLogin.equals("gv")) {
			btnDangky.setEnabled(false);
		}
//		
//		if(role.equals("admin")) {
//			btnXemDanhGia.setEnabled(true);
//			btnDanhGia.setEnabled(true);
//		}
		

		
		scrollPanel_center.setBounds(263, 92, 1138, 698);
		contentPane.add(scrollPanel_center);
		return scrollPanel_center;
	}

	public JScrollPane qlKH() {
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(25, 35, 25, 35));
		panel_2.setBackground(new Color(195, 209, 226));
		final JScrollPane scrollPanel_center = new JScrollPane(panel_2);
		panel_2.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 80, 682, 590);
		panel_2.add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(52, 20, 180, 34);
		panel_2.add(textField);
		textField.setColumns(10);
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				searchQLKH();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchQLKH();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				searchQLKH();
			}
		});
		JButton btnSearch = new JButton("");
		btnSearch.setBounds(232, 20, 32, 34);
		panel_2.add(btnSearch);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setIcon(new ImageIcon((Paths.get("icon\\search24.png")).toString()));
		btnSearch.setOpaque(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setBackground(new Color(218, 218, 218));
		
		
		lblNewLabel_3 = new JLabel("Category:");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBackground(SystemColor.menu);
		lblNewLabel_3.setBounds(433, 20, 99, 34);
		panel_2.add(lblNewLabel_3);
		
		JButton btnFilter = new JButton("");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.filterTableQLKH();
			}
		});
		btnFilter.setBounds(533, 19, 32, 36);
		panel_2.add(btnFilter);
		btnFilter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFilter.setIcon(new ImageIcon((Paths.get("icon\\filter24.png")).toString()));
		btnFilter.setOpaque(false);
		btnFilter.setFocusPainted(false);
		btnFilter.setBackground(new Color(218, 218, 218));
		
		
		lblNewLabel_2 = new JLabel("Sort By:");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(745, 20, 84, 34);
		panel_2.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Release date (newest first)", "Release date (oldest first)"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setBounds(839, 18, 242, 38);
		panel_2.add(comboBox);
		
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				c.focusTable();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 kh\u00F3a h\u1ECDc", "M\u00E3 m\u00F4n h\u1ECDc", "T\u00EAn m\u00F4n h\u1ECDc", "T\u1ED5ng s\u1ED1 gi\u1EDD h\u1ECDc"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(35);
//		table.getColumnModel().getColumn(4).setPreferredWidth(35);
//		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.setRowHeight(26);
		scrollPane.setViewportView(table);
		
		this.c.loadTable();
		
		JPanel panel_khoaHoc = new JPanel();
		panel_khoaHoc.setBackground(new Color(255, 255, 255));
		panel_khoaHoc.setBounds(761, 80, 324, 176);
		panel_2.add(panel_khoaHoc);
		scrollPanel_center.setBounds(263, 92, 1138, 698);
		panel_khoaHoc.setLayout(null);
		
		JLabel lbl_TitleKH = new JLabel("KHÓA HỌC");
		lbl_TitleKH.setFont(new Font("Arial", Font.BOLD, 18));
		lbl_TitleKH.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TitleKH.setBounds(101, 10, 123, 36);
		panel_khoaHoc.add(lbl_TitleKH);
		
		JLabel lblMaKH = new JLabel("Mã khóa học : ");
		lblMaKH.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaKH.setBounds(10, 56, 97, 28);
		panel_khoaHoc.add(lblMaKH);
		
		JLabel lblTenKH = new JLabel("Tên khóa học: ");
		lblTenKH.setFont(new Font("Arial", Font.BOLD, 13));
		lblTenKH.setBounds(10, 96, 97, 28);
		panel_khoaHoc.add(lblTenKH);
		
		JButton btn_NewKH = new JButton("New");
		btn_NewKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_NewKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.newKH();
			}
		});
		btn_NewKH.setFont(new Font("Arial", Font.BOLD, 14));
		btn_NewKH.setBounds(10, 140, 85, 23);
		panel_khoaHoc.add(btn_NewKH);
		
		JButton btn_SaveKH = new JButton("Save");
		btn_SaveKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_SaveKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.saveKH();
			}
		});
		btn_SaveKH.setFont(new Font("Arial", Font.BOLD, 14));
		btn_SaveKH.setBounds(120, 140, 85, 23);
		panel_khoaHoc.add(btn_SaveKH);
		
		JButton btn_DeleteKH = new JButton("Delete");
		btn_DeleteKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_DeleteKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.deleteKH();
			}
		});
		btn_DeleteKH.setFont(new Font("Arial", Font.BOLD, 14));
		btn_DeleteKH.setBounds(229, 140, 85, 23);
		panel_khoaHoc.add(btn_DeleteKH);
		
		txtMaKH = new JTextField();
		txtMaKH.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				khoaHoc kh = new khoaHoc(txtMaKH.getText(), null);
				khoaHoc khDAO = khoaHocDAO.khoaHocDAO().selectG(kh);
				if(khDAO.gettenMH() == null || khDAO.gettenMH().equals("")) {
					txtTenKH.setText("");
				} else {
					txtTenKH.setText(khDAO.gettenMH());
				}
			}
		});
		txtMaKH.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMaKH.setBounds(111, 56, 203, 28);
		panel_khoaHoc.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(111, 96, 203, 28);
		panel_khoaHoc.add(txtTenKH);
		
		JPanel panel_monHoc = new JPanel();
		panel_monHoc.setLayout(null);
		panel_monHoc.setBackground(Color.WHITE);
		panel_monHoc.setBounds(761, 269, 324, 403);
		panel_2.add(panel_monHoc);
		
		JLabel lbl_TitleMH = new JLabel("MÔN HỌC");
		lbl_TitleMH.setBounds(101, 10, 123, 36);
		panel_monHoc.add(lbl_TitleMH);
		lbl_TitleMH.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TitleMH.setFont(new Font("Arial", Font.BOLD, 18));
		
		JButton btn_NewMH = new JButton("New");
		btn_NewMH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_NewMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.newMH();
			}
		});
		btn_NewMH.setFont(new Font("Arial", Font.BOLD, 14));
		btn_NewMH.setBounds(10, 368, 85, 23);
		panel_monHoc.add(btn_NewMH);
		
		JButton btn_SaveMH = new JButton("Save");
		btn_SaveMH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_SaveMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.saveMH();
			}
		});
		btn_SaveMH.setFont(new Font("Arial", Font.BOLD, 14));
		btn_SaveMH.setBounds(120, 368, 85, 23);
		panel_monHoc.add(btn_SaveMH);
		
		JButton btn_DeleteMH = new JButton("Delete");
		btn_DeleteMH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_DeleteMH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.deleteMH();
			}
		});
		btn_DeleteMH.setFont(new Font("Arial", Font.BOLD, 14));
		btn_DeleteMH.setBounds(229, 368, 85, 23);
		panel_monHoc.add(btn_DeleteMH);
		
		JLabel lbl_MaMH = new JLabel("Mã môn học : ");
		lbl_MaMH.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_MaMH.setBounds(10, 56, 97, 28);
		panel_monHoc.add(lbl_MaMH);
		
		txt_MaMH = new JTextField();
		txt_MaMH.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				monHoc mh =  new monHoc();
				mh.setMaMH(txt_MaMH.getText());
				monHoc mhDAO = monHocDAO.monHocDAO().selectG(mh);
				
				
				if(mh.getMaMH().equals(mhDAO.getMaMH())) {
					khoaHoc kh = new khoaHoc();
					kh.setmaKH(mhDAO.getMaKH());
					khoaHoc khDAO = khoaHocDAO.khoaHocDAO().selectG(kh);
					
					txt_TenMH.setText(mhDAO.getTenMH());
//					txt_SoHocVien.setText(mhDAO.getSoLuongHV()+"");
					txt_TongGioHoc.setText(mhDAO.getSoGioHoc()+"");
//					cbx_GiangVien.setSelectedItem(mhDAO.getEmailGV());
					Object obj = khDAO.getmaKH() + ": " + khDAO.gettenMH();
					cbx_MaKH_MH.setSelectedItem(obj);
					
//					int slhv = monHocDAO.monHocDAO().selectSLHV(mhDAO);
//					txt_SoHocVien.setText(slhv + "");
					
					monHocChiTiet mhct = new monHocChiTiet();
					mhct.setMaMH(mhDAO.getMaMH());
					monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG(mhct);
//					cbx_GiangVien.setSelectedItem(mhctDAO.getMaGiangVien());
					
					
					if(mhDAO.getHinhMH() != null || lbl_imgMH.getText().equals("Hình môn học")) {
						//chinh anh
						ImageIcon ii = new ImageIcon((Paths.get("icon\\" + mhDAO.getHinhMH())).toAbsolutePath().toString());
						Image i1 = ii.getImage();
						Image i2 = i1.getScaledInstance(lbl_imgMH.getWidth(), lbl_imgMH.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon iii = new ImageIcon(i2);
						
						//set Anh
						lbl_imgMH.setIcon(iii);
						lbl_imgMH.setText("");
					} else {
						lbl_imgMH.setText("Hình môn học");
					}
					
					for(int i = 0; i < table.getRowCount(); i++) {
						if(table.getValueAt(i, 1).equals(mhDAO.getMaMH())) {
							table.setRowSelectionInterval(i, i);
						}
					}
				}
			}
		});
		txt_MaMH.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_MaMH.setColumns(10);
		txt_MaMH.setBounds(111, 56, 203, 28);
		panel_monHoc.add(txt_MaMH);
		
		JLabel lbl_TenMH = new JLabel("Tên môn học: ");
		lbl_TenMH.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_TenMH.setBounds(10, 94, 97, 28);
		panel_monHoc.add(lbl_TenMH);
		
		txt_TenMH = new JTextField();
		txt_TenMH.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_TenMH.setColumns(10);
		txt_TenMH.setBounds(111, 94, 203, 28);
		panel_monHoc.add(txt_TenMH);
		
		JLabel lbl_TongGioHoc = new JLabel("Tổng giờ học: ");
		lbl_TongGioHoc.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_TongGioHoc.setBounds(10, 132, 97, 28);
		panel_monHoc.add(lbl_TongGioHoc);
		
		txt_TongGioHoc = new JTextField();
		txt_TongGioHoc.setFont(new Font("Arial", Font.PLAIN, 13));
		txt_TongGioHoc.setColumns(10);
		txt_TongGioHoc.setBounds(111, 132, 203, 28);
		panel_monHoc.add(txt_TongGioHoc);
		
		lbl_imgMH = new JLabel("Hình môn học");
		lbl_imgMH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_imgMH.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				c.setAvateImgMH();
			}
		});
		
		lbl_imgMH.setBorder(rb1);
		lbl_imgMH.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_imgMH.setFont(new Font("Arial", Font.BOLD, 24));
		lbl_imgMH.setBounds(8, 218, 306, 99);
		panel_monHoc.add(lbl_imgMH);
		
		JLabel lbl_MaKH_MH = new JLabel("Mã khóa học :");
		lbl_MaKH_MH.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_MaKH_MH.setBounds(10, 170, 97, 28);
		panel_monHoc.add(lbl_MaKH_MH);
		
		cbx_MaKH_MH = new JComboBox();
		final DefaultComboBoxModel cbm2 = (DefaultComboBoxModel) cbx_MaKH_MH.getModel();
		cbx_MaKH_MH.setMaximumRowCount(4);
		cbx_MaKH_MH.setFont(new Font("Arial", Font.PLAIN, 13));
		cbx_MaKH_MH.setBounds(111, 170, 203, 28);
		panel_monHoc.add(cbx_MaKH_MH);
		
		JButton btn_SaveMH_1 = new JButton("Xem Thêm");
		btn_SaveMH_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.goToMonHocCuaToi();
			}
		});
		btn_SaveMH_1.setFont(new Font("Arial", Font.BOLD, 14));
		btn_SaveMH_1.setBounds(101, 327, 123, 31);
		panel_monHoc.add(btn_SaveMH_1);
		
		contentPane.add(scrollPanel_center);
//		ArrayList<user> list = userDAO.getUserDAO().selectAll();
//		for (user user : list) {
//			if(user.getRole().equals("gv")) {
//				cbm1.addElement(user.getUsername());
//			}
//		}
		
		ArrayList<khoaHoc> list1 = khoaHocDAO.khoaHocDAO().selectAll();
		for (khoaHoc khoaHoc : list1) {
			cbm2.addElement(khoaHoc.getmaKH() + ": " + khoaHoc.gettenMH());
			
		}
//		Runnable r = new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true) {
//					ArrayList<monHoc> list = monHocDAO.monHocDAO().selectAll();
//					for (monHoc monHoc : list) {
//						cbm1.addElement(monHoc.getEmailGV());
//					}
//				}
//			}
//		};
//		
//		Thread t = new Thread(r);
//		t.start();
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
			
		return scrollPanel_center;
	}

	public JScrollPane qlUser() {
		ArrayList<user> list = userDAO.getUserDAO().selectAll();
		
		JPanel panel_center = new JPanel();
		panel_center.setBorder(new EmptyBorder(25, 35, 25, 35));
		panel_center.setBackground(new Color(195, 209, 226));
		final JScrollPane scrollPanel_center = new JScrollPane(panel_center);
		panel_center.setLayout(null);
		
		JPanel panel_user = new JPanel();
		panel_user.setBackground(new Color(255, 255, 255));
		panel_user.setBounds(72, 215, 607, 432);
		panel_center.add(panel_user);
		panel_user.setLayout(null);
		

		txtXxxx = new JTextField();
		txtXxxx.setFont(new Font("Arial", Font.PLAIN, 14));
		txtXxxx.setBounds(360, 10, 204, 24);
		panel_user.add(txtXxxx);
		txtXxxx.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				chageTableQLUS();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				chageTableQLUS();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				chageTableQLUS();
			}
		});
		txtXxxx.setColumns(10);
		
		JButton btnFilter = new JButton("");
		btnFilter.setBounds(570, 10, 30, 24);
		btnFilter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFilter.setIcon(new ImageIcon((Paths.get("icon\\search24.png")).toString()));
		btnFilter.setOpaque(false);
		btnFilter.setFocusPainted(false);
		btnFilter.setBackground(new Color(218, 218, 218));
		panel_user.add(btnFilter);
		
		JScrollPane scrollPane_User = new JScrollPane();
		scrollPane_User.setBounds(-1, 40, 609, 392);
		scrollPane_User.setBackground(Color.WHITE);
		scrollPane_User.setOpaque(true);
		panel_user.add(scrollPane_User);
		
		table_User = new JTable();
		table_User.setShowVerticalLines(false);
		table_User.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "Name", "Phone", "Role", "Action"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_User.setSelectionBackground(new Color(56, 138, 112));
		table_User.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_User.getColumnModel().getColumn(1).setPreferredWidth(92);
		table_User.getColumnModel().getColumn(2).setPreferredWidth(60);
		table_User.getColumnModel().getColumn(3).setPreferredWidth(40);
		table_User.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		table_User.setRowHeight(32);
		table_User.getColumnModel().getColumn(4).setCellRenderer(new tableCellRenderer());
		
		tableAcctionEvent event = new tableAcctionEvent() {
			
			@Override
			public void onUpdate(int row) {
				int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa thông tin của user này?", "", JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION) {
					Object obj[] = {"OK", "CANCEL"};
					JTextField txtName = new JTextField();
					JTextField txtPhone = new JTextField();
					Object o[] = {"Name:", txtName,"\n","Phone:",txtPhone};
					while(true) {
						int j = JOptionPane.showOptionDialog(quanLyKhoaHocview.this, o, "", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, obj, obj[0]);
						if(j == 0) {
							thongTinCN ttcn = new thongTinCN();
							ttcn.setEmail(table_User.getValueAt(row, 0)+"");
							if(txtName.getText().equals("")) {
								ttcn.setName(ttcn.getEmail());
								txtName.setText(ttcn.getEmail());
							} else {
								ttcn.setName(txtName.getText());
							}
							String sdt_test = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
							ttcn.setSdt(txtPhone.getText());
							if(ttcn.getSdt().matches(sdt_test)||ttcn.getSdt().equals("")) {
								thongTinCNDAO.thongTinCNDAO().updateXX(ttcn);
								table_User.setValueAt(txtName.getText(), row, 1);
								table_User.setValueAt(txtPhone.getText(), row, 2);
								JOptionPane.showMessageDialog(quanLyKhoaHocview.this, "Cập nhật User thành công");
								break;
							}
							JOptionPane.showMessageDialog(quanLyKhoaHocview.this, "Số điện thoại không hợp lệ");
						} else {
							break;
						}
					} 
				}
			}
			
			@Override
			public void onMore(int row) {
				if(table_User.isEditing()) {
					table_User.getCellEditor().stopCellEditing();
				}
				user user = new user();
				user.setUsername(table_User.getValueAt(row, 0)+"");
				user.setRole(table_User.getValueAt(row, 3)+"");
				contentPane.removeAll();
				contentPane.add(lblXemThem);
				contentPane.add(panel_left);
				contentPane.add(panel_top);
				contentPane.add(xemTTCTUser(user));
				contentPane.repaint();
				contentPane.revalidate();
			}
			
			@Override
			public void onDelete(int row) {
				if(table_User.isEditing()) {
					table_User.getCellEditor().stopCellEditing();
				}
				
				DefaultTableModel table_model = (DefaultTableModel) table_User.getModel();
				String s = table_User.getValueAt(row, 0)+"";
				user u = new user();
				u.setUsername(s);

				int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa user này?", "", JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION) {
					table_model.removeRow(row);
					userDAO.getUserDAO().deleteX(u);
					updateMember();
					JOptionPane.showMessageDialog(null, "Xóa User thành công");
				}
			}
		};
		
		table_User.getColumnModel().getColumn(4).setCellEditor(new tableCellEditor(event));
		
		DefaultTableModel table_model = (DefaultTableModel) this.table_User.getModel();
		
		for (user user : list) {
			thongTinCN ttcn = new thongTinCN();
			ttcn.setEmail(user.getUsername());
			thongTinCN ttcnDAO = thongTinCNDAO.thongTinCNDAO().selectG(ttcn);
			if(ttcnDAO.getEmail() != null && !ttcnDAO.getEmail().equals("admin")) {
				table_model.addRow(new Object[] {user.getUsername(), ttcnDAO.getName(), ttcnDAO.getSdt(), user.getRole(), null, "More"});
			}
		}
		
		scrollPane_User.setViewportView(table_User);
		
		JLabel lblTitle_tableDateUser = new JLabel("Data User");
		lblTitle_tableDateUser.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitle_tableDateUser.setBounds(6, 6, 96, 30);
		panel_user.add(lblTitle_tableDateUser);
		
		JPanel panel_teacher = new JPanel();
		panel_teacher.setBackground(new Color(255, 255, 255));
		panel_teacher.setBounds(711, 215, 347, 432);
		panel_center.add(panel_teacher);
		panel_teacher.setLayout(null);
		
		JScrollPane scrollPane_Teacher = new JScrollPane();
		scrollPane_Teacher.setBounds(-1, 40, 348, 392);
		panel_teacher.add(scrollPane_Teacher);
		
		table_teacher = new JTable();
		table_teacher.setShowVerticalLines(false);
		table_teacher.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Email", "Kinh nghi\u1EC7m", "Chuy\u00EAn m\u00F4n", "Action"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		table_teacher.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_teacher.setSelectionBackground(new Color(56, 138, 112));
		table_teacher.setRowHeight(31);
		table_teacher.getColumnModel().getColumn(3).setCellRenderer(new tableTeacherCellRenderer());
		
		tableAcctionEvent eventYN = new tableAcctionEvent() {
			
			@Override
			public void onUpdate(int row) {
				// TODO Auto-generated method stub
				int i = JOptionPane.showConfirmDialog(quanLyKhoaHocview.this, "Bạn có chắc chắn muốn để User này làm giảng viên?", "",JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION) {
					if(table_teacher.isEditing()) {
						table_teacher.getCellEditor().stopCellEditing();
					}
					
					user u = new user();
					u.setUsername(table_teacher.getValueAt(row, 0)+"");
					u.setRole("gv");
					
					userDAO.getUserDAO().updateX(u);
					
					DefaultTableModel table_model = (DefaultTableModel) table_User.getModel();
					table_model.setRowCount(0);
					ArrayList<user> list = userDAO.getUserDAO().selectAll();
					for (user user : list) {
						thongTinCN ttcn = new thongTinCN();
						ttcn.setEmail(user.getUsername());
						thongTinCN ttcnDAO = thongTinCNDAO.thongTinCNDAO().selectG(ttcn);
						if(!ttcnDAO.getEmail().equals("admin")) {
							table_model.addRow(new Object[] {user.getUsername(), ttcnDAO.getName(), ttcnDAO.getSdt(), user.getRole(), null, "More"});
						}
					}
					
					((DefaultTableModel)table_teacher.getModel()).removeRow(row);
					waitAccept wa = new waitAccept();
					wa.setEmail(u.getUsername());
					
					waitAccept waDAO = waitAcceptDAO.getwaitAcceptDAO().selectG(wa);
					waitAcceptDAO.getwaitAcceptDAO().insertGV(waDAO);
					waitAcceptDAO.getwaitAcceptDAO().deleteX(wa);
					
					updateMember();
					JOptionPane.showMessageDialog(quanLyKhoaHocview.this, "Accept thành công");
				}
			}
			
			@Override
			public void onMore(int row) {
				// TODO Auto-generated method stub
				String email = table_teacher.getValueAt(row, 0)+"";
				waitAccept wa = new waitAccept();
				wa.setEmail(email);
				
				waitAccept waDAO = waitAcceptDAO.getwaitAcceptDAO().selectG(wa);
				String cv = Paths.get("icon\\"+waDAO.getCv()).toAbsolutePath().toString();
				openPngFile(cv);
			}
			
			@Override
			public void onDelete(int row) {
				// TODO Auto-generated method stub
				int i = JOptionPane.showConfirmDialog(quanLyKhoaHocview.this, "Bạn có chắc chắn từ chối yêu cầu của User này?", "",JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION) {
					if(table_teacher.isEditing()) {
						table_teacher.getCellEditor().stopCellEditing();
					}
					
					waitAccept ttcn1 = new waitAccept();
					ttcn1.setEmail(table_teacher.getValueAt(row, 0)+"");
					
					waitAcceptDAO.getwaitAcceptDAO().deleteX(ttcn1);
					
					((DefaultTableModel)table_teacher.getModel()).removeRow(row);
					updateMember();
					JOptionPane.showMessageDialog(quanLyKhoaHocview.this, "Đã từ chối yêu cầu");
				}
			}
		};
		
		table_teacher.getColumnModel().getColumn(3).setCellEditor(new tableTeacherCellEditor(eventYN));
		
		DefaultTableModel table_tacher_model = (DefaultTableModel)table_teacher.getModel();
		ArrayList<waitAccept> list_accept = waitAcceptDAO.getwaitAcceptDAO().selectAll();
		
		for (waitAccept ttcn : list_accept) {
			table_tacher_model.addRow(new Object[] {ttcn.getEmail(), ttcn.getKinhNghiem(), ttcn.getChuyenMon(), null});
		}
		
		scrollPane_Teacher.setViewportView(table_teacher);
		
		JLabel lblTitle_tableAccpetTeacher = new JLabel("Accept Teacher");
		lblTitle_tableAccpetTeacher.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitle_tableAccpetTeacher.setBounds(6, 6, 124, 30);
		panel_teacher.add(lblTitle_tableAccpetTeacher);
		
		
		JLabel lbl_SLHV = new JLabel("Số lượng học viên");
		lbl_SLHV.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SLHV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SLHV.setBounds(118, 54, 166, 20);
		panel_center.add(lbl_SLHV);
		
		JLabel lbl_SLGV = new JLabel("Số lượng giảng viên");
		lbl_SLGV.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SLGV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SLGV.setBounds(485, 54, 166, 20);
		panel_center.add(lbl_SLGV);
		
		JLabel lbl_SLWait = new JLabel("Số lượng đang chờ");
		lbl_SLWait.setFont(new Font("Arial", Font.BOLD, 16));
		lbl_SLWait.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SLWait.setBounds(846, 54, 166, 20);
		panel_center.add(lbl_SLWait);
		
		lbl_numSLHV = new JLabel("...");
		lbl_numSLHV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_numSLHV.setFont(new Font("Arial", Font.PLAIN, 22));
		lbl_numSLHV.setBounds(118, 84, 166, 30);
		
		panel_center.add(lbl_numSLHV);
		
		lbl_numSLGV = new JLabel("...");
		lbl_numSLGV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_numSLGV.setFont(new Font("Arial", Font.PLAIN, 22));
		lbl_numSLGV.setBounds(485, 84, 166, 30);
		
		panel_center.add(lbl_numSLGV);
		
		lbl_numSLWait = new JLabel("...");
		lbl_numSLWait.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_numSLWait.setFont(new Font("Arial", Font.PLAIN, 22));
		lbl_numSLWait.setBounds(846, 84, 166, 30);

		panel_center.add(lbl_numSLWait);
		
		updateMember();
		
		JLabel lbl_imgSLHV = new JLabel("");
		lbl_imgSLHV.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				filterSLHV();
			}
		});
		lbl_imgSLHV.setBounds(72, 48, 256, 140);
		ImageIcon ic10 = new ImageIcon((Paths.get("icon\\blue.jpg")).toAbsolutePath().toString());
//		Image icon10 = ic10.getImage();
//		Image da10 = icon10.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
//		ImageIcon ne10 = new ImageIcon(da10);
//		lblNewLabel_2.setIcon(ne10);
		
		
//		C:\Users\Admin\eclipse-workspace\ws_nhom1\icon
//		ImageIcon ic10 = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ws_nhom1\\icon\\blue.jpg");
		Image icon10 = ic10.getImage();
		Image da10 = icon10.getScaledInstance(lbl_imgSLHV.getWidth(), lbl_imgSLHV.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ne10 = new ImageIcon(da10);
		lbl_imgSLHV.setIcon(ne10);
		panel_center.add(lbl_imgSLHV);
		
		JLabel lbl_imgSLGV = new JLabel("");
		lbl_imgSLGV.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				filterSLGV();
			}
		});
		lbl_imgSLGV.setBounds(438, 48, 256, 140);
		ImageIcon ic11 = new ImageIcon((Paths.get("icon\\yelow.jpg")).toAbsolutePath().toString());
//		Image icon11 = ic11.getImage();
//		Image da11 = icon11.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
//		ImageIcon ne11 = new ImageIcon(da11);
//		lblNewLabel_3.setIcon(ne11);
		
//		ImageIcon ic11 = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ws_nhom1\\icon\\yelow.jpg");
		Image icon11 = ic11.getImage();
		Image da11 = icon11.getScaledInstance(lbl_imgSLGV.getWidth(), lbl_imgSLGV.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ne11 = new ImageIcon(da11);
		lbl_imgSLGV.setIcon(ne11);
		
		panel_center.add(lbl_imgSLGV);
		
		JLabel lbl_imgSLWait = new JLabel("");
		lbl_imgSLWait.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				refesQLU();
			}
		});
		lbl_imgSLWait.setBounds(802, 48, 256, 140);
		ImageIcon ic12 = new ImageIcon((Paths.get("icon\\red.jpg")).toAbsolutePath().toString());
//		Image icon12 = ic12.getImage();
//		Image da12 = icon12.getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH);
//		ImageIcon ne12 = new ImageIcon(da12);
//		lblNewLabel_4.setIcon(ne12);

//		ImageIcon ic12 = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\ws_nhom1\\icon\\red.jpg");
		Image icon12 = ic12.getImage();
		Image da12 = icon12.getScaledInstance(lbl_imgSLWait.getWidth(), lbl_imgSLWait.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon ne12 = new ImageIcon(da12);
		lbl_imgSLWait.setIcon(ne12);
		
		panel_center.add(lbl_imgSLWait);
		
		
		scrollPanel_center.setBounds(263, 92, 1149, 700);
		return scrollPanel_center;
	}
	
	public void updateMember() {
		lbl_numSLHV.setText(userDAO.getUserDAO().selectAllHV() + " Member");
		lbl_numSLGV.setText(userDAO.getUserDAO().selectAllGV() + " Member");
		lbl_numSLWait.setText(waitAcceptDAO.getwaitAcceptDAO().selectCount() + " Member");
	}
	
	public void searchQLKH() {
		DefaultTableModel table_model = (DefaultTableModel) this.table.getModel();
		table_model.setRowCount(0);
		ArrayList<monHoc> list = monHocDAO.monHocDAO().selectMH(textField.getText());
		for (monHoc monHoc : list) {
//			int slhv = monHocDAO.monHocDAO().selectSLHV(monHoc);
			monHocChiTiet mhct = new monHocChiTiet();
			mhct.setMaMH(monHoc.getMaMH());
			monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG(mhct);
			table_model.addRow(new Object[] {monHoc.getMaKH(), monHoc.getMaMH(), monHoc.getTenMH(), monHoc.getSoGioHoc() + " Hours"});
		}
	}
	
	public void chageTableQLUS() {
		DefaultTableModel table_model = (DefaultTableModel) this.table_User.getModel();
		table_model.setRowCount(0);
		ArrayList<user> list = userDAO.getUserDAO().selectUserName(this.txtXxxx.getText());
		for (user user : list) {
			table_model.addRow(new Object[] {user.getUsername(), user.getPassword(), user.getAnswer(), user.getRole()});
		}
	}
	
	public void filterSLGV() {
		DefaultTableModel table_model = (DefaultTableModel) this.table_User.getModel();
		table_model.setRowCount(0);
		ArrayList<user> list = userDAO.getUserDAO().selectSLGV();
		for (user user : list) {
			table_model.addRow(new Object[] {user.getUsername(), user.getPassword(), user.getAnswer(), user.getRole()});
		}
	}
	
	public void filterSLHV() {
		DefaultTableModel table_model = (DefaultTableModel) this.table_User.getModel();
		table_model.setRowCount(0);
		ArrayList<user> list = userDAO.getUserDAO().selectSLHV();
		for (user user : list) {
			table_model.addRow(new Object[] {user.getUsername(), user.getPassword(), user.getAnswer(), user.getRole()});
		}
	}
	
	public void refesQLU() {
		DefaultTableModel table_model = (DefaultTableModel) this.table_User.getModel();
		table_model.setRowCount(0);
		ArrayList<user> list = userDAO.getUserDAO().selectAll();
		for (user user : list) {
			thongTinCN ttcn = new thongTinCN();
			ttcn.setEmail(user.getUsername());
			thongTinCN ttcnDAO = thongTinCNDAO.thongTinCNDAO().selectG(ttcn);
			if(ttcnDAO.getEmail() != null && !ttcnDAO.getEmail().equals("admin")) {
				table_model.addRow(new Object[] {user.getUsername(), ttcnDAO.getName(), ttcnDAO.getSdt(), user.getRole(), null, "More"});
			}
		}
	}

	public JPanel setPanel_TTCN() {
		thongTinCN ttcn = new thongTinCN();
		ttcn.setEmail(this.nameLogin);
		thongTinCN ttcnDAO = thongTinCNDAO.thongTinCNDAO().selectG(ttcn);
		JPanel panel_TTCN = new JPanel();
		panel_TTCN.setBackground(new Color(255, 255, 255));
		panel_TTCN.setBounds(0, 0, 496, 190);
		panel_TTCN.setLayout(null);
		
		JLabel lblTitleTTCN = new JLabel("THÔNG TIN CÁ NHÂN");
		lblTitleTTCN.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleTTCN.setForeground(new Color(139, 143, 140));
		lblTitleTTCN.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitleTTCN.setBounds(10, 0, 476, 52);
		panel_TTCN.add(lblTitleTTCN);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setBounds(20, 57, 45, 13);
		panel_TTCN.add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setText(ttcnDAO.getEmail());
		txtEmail.setForeground(new Color(139, 143, 140));
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		txtEmail.setFocusable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(20, 72, 180, 37);
		panel_TTCN.add(txtEmail);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Name:");
		lblNewLabel_1_1_1_1.setBounds(295, 57, 45, 13);
		panel_TTCN.add(lblNewLabel_1_1_1_1);
		
		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtName.getText().equals("")) {
					txtName.setText(txtEmail.getText());
				}
			}
		});
		txtName.setText(ttcnDAO.getName());
		txtName.setForeground(new Color(139, 143, 140));
		txtName.setFont(new Font("Arial", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(295, 72, 180, 37);
		panel_TTCN.add(txtName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SDT:");
		lblNewLabel_1_1_1.setBounds(295, 126, 45, 13);
		panel_TTCN.add(lblNewLabel_1_1_1);
		
		txtSdt = new JTextField();
		txtSdt.setText(ttcnDAO.getSdt());
		txtSdt.setForeground(new Color(139, 143, 140));
		txtSdt.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSdt.setColumns(10);
		txtSdt.setBounds(295, 142, 180, 37);
		panel_TTCN.add(txtSdt);
		
		txtPass = new JPasswordField();
		txtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPass.getText().equals("")) {
					user u = new user();
					u.setUsername(txtEmail.getText());
					user uDAO = userDAO.getUserDAO().selectG(u);
					txtPass.setText(uDAO.getPassword());
				}
			}
		});
		txtPass.setText(ttcnDAO.getPass());
		txtPass.setForeground(new Color(139, 143, 140));
		txtPass.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPass.setColumns(10);
		txtPass.setBounds(20, 142, 180, 37);
		panel_TTCN.add(txtPass);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setBounds(20, 126, 70, 13);
		panel_TTCN.add(lblNewLabel_1_1);
		
		return panel_TTCN;
	}
	
	public JPanel setPanel_TTSP() {
		JPanel setPanel_TTSP = new JPanel();
		setPanel_TTSP.setBackground(new Color(255, 255, 255));
		setPanel_TTSP.setBounds(0, 0, 496, 190);
		setPanel_TTSP.setLayout(null);
		
		JLabel lblTitleTTSP = new JLabel("THÔNG TIN SƯ PHẠM");
		lblTitleTTSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleTTSP.setForeground(new Color(139, 143, 140));
		lblTitleTTSP.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitleTTSP.setBounds(10, 0, 476, 52);
		setPanel_TTSP.add(lblTitleTTSP);
		
		JLabel lblNewLabel_1 = new JLabel("Kinh nghiệm:");
		lblNewLabel_1.setBounds(20, 57, 70, 16);
		setPanel_TTSP.add(lblNewLabel_1);
		
			
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Chuyên môn:");
		lblNewLabel_1_1_1_1.setBounds(295, 57, 70, 16);
		setPanel_TTSP.add(lblNewLabel_1_1_1_1);
				
				
		JLabel lblNewLabel_1_1 = new JLabel("CV đính kèm:");
		lblNewLabel_1_1.setBounds(89, 126, 70, 16);
		setPanel_TTSP.add(lblNewLabel_1_1);
		
		lblCV = new JLabel("");
		lblCV.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCV.setHorizontalAlignment(SwingConstants.CENTER);
		lblCV.setBorder(new TitledBorder(""));
		lblCV.setBounds(89, 149, 244, 31);
		setPanel_TTSP.add(lblCV);
		
		txtKN = new JTextField();
		txtKN.setBounds(20, 80, 180, 31);
		setPanel_TTSP.add(txtKN);
		txtKN.setColumns(10);
		
		txtCM = new JTextField();
		txtCM.setColumns(10);
		txtCM.setBounds(295, 80, 180, 31);
		setPanel_TTSP.add(txtCM);
		
		JButton btnTaiCV = new JButton("New button");
		btnTaiCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadCV();
			}
		});
		btnTaiCV.setBounds(338, 149, 37, 31);
		setPanel_TTSP.add(btnTaiCV);
		
		JButton btnXoaCV = new JButton("New button");
		btnXoaCV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCV.setText("");
			}
		});
		btnXoaCV.setBounds(380, 149, 37, 31);
		setPanel_TTSP.add(btnXoaCV);
		
		return setPanel_TTSP;
	}
	
	public void changeLH() {
		try {
			DefaultComboBoxModel<String> cbtg_model = (DefaultComboBoxModel<String>) cbThoiGian.getModel();
			String timeStart = cbtg_model.getSelectedItem().toString().substring(0, cbtg_model.getSelectedItem().toString().indexOf(" - "));
			String timeEnd = cbtg_model.getSelectedItem().toString().substring(cbtg_model.getSelectedItem().toString().indexOf("- ") + 2);
			caHoc ch = new caHoc(null, timeStart.trim(), timeEnd.trim());
			caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
			
			
			DefaultComboBoxModel<String> cbDD_model = (DefaultComboBoxModel<String>) cbDiaDiem.getModel();
			diaDiemHoc ddh = new diaDiemHoc();
			if(cbDD_model.getSelectedItem() == null) {
				ddh.setDiaChi("");
			} else {
				ddh.setDiaChi(cbDD_model.getSelectedItem().toString());
			}
			monHocChiTiet mhct = new monHocChiTiet();
			mhct.setMaMH(xemThemMH);
			mhct.setMaCa(chDAO.getMaCa());
			diaDiemHoc ddhDAO = diaDiemHocDAO.getdiaDiemHocDAO().selectG(ddh);
			
			monHoc mh = new monHoc();
			mh.setMaMH(xemThemMH);
			
			DefaultComboBoxModel<String> cbLH_model = (DefaultComboBoxModel<String>) cbLopHoc.getModel();
			cbLH_model.removeAllElements();
			ArrayList<lopHoc> list = lopHocDAO.getlopHocDAO().selectAllResLH(ddhDAO, chDAO, mh);
			for (lopHoc lopHoc : list) {
				cbLH_model.addElement(lopHoc.getMaLop());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeGV() {
		try {
			DefaultComboBoxModel<String> cbtg_model = (DefaultComboBoxModel<String>) cbThoiGian.getModel();
			String timeStart = cbtg_model.getSelectedItem().toString().substring(0, cbtg_model.getSelectedItem().toString().indexOf(" - "));
			String timeEnd = cbtg_model.getSelectedItem().toString().substring(cbtg_model.getSelectedItem().toString().indexOf("- ") + 2);
			caHoc ch = new caHoc(null, timeStart.trim(), timeEnd.trim());
			caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
			DefaultComboBoxModel<String> cbLH_model = (DefaultComboBoxModel<String>) cbLopHoc.getModel();
			
			if(cbLH_model.getSelectedItem() == null) {
				lblTenGV.setText("");
				lblEmailGV.setText("");
				lblSDTGV.setText("");
				lblAvataGV.setIcon(null);
				lblSoLuongHV.setText("Null");
				lblSoGioHoc.setText("Null");
			} else {
				monHocChiTiet mhct = new monHocChiTiet(xemThemMH, null, cbLH_model.getSelectedItem().toString(), chDAO.getMaCa());
				monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG1(mhct);
				thongTinCN tt = new thongTinCN();
				tt.setEmail(mhctDAO.getMaGiangVien());
				thongTinCN ttDAO = thongTinCNDAO.thongTinCNDAO().selectG(tt);
				
				ImageIcon ii21 = new ImageIcon((Paths.get("icon\\" + ttDAO.getAvatar()).toAbsolutePath().toString()));
				Image i21 = ii21.getImage();
				Image ig21 = i21.getScaledInstance(lblAvataGV.getWidth(), lblAvataGV.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon iic21 = new ImageIcon(ig21);
				lblAvataGV.setIcon(iic21);
				
				lblTenGV.setText(ttDAO.getName());
				lblEmailGV.setText(ttDAO.getEmail());
				lblSDTGV.setText(ttDAO.getSdt());
				
				monHoc mhh = new monHoc();
				mhh.setMaMH(xemThemMH);
				monHoc mh = monHocDAO.monHocDAO().selectG(mhh);
				lblSoGioHoc.setText(mh.getSoGioHoc()+" giờ");
				
				int slhv = monHocDAO.monHocDAO().selectSLHVCT(mhct);
				lblSoLuongHV.setText(slhv + " người");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeDD() {
		try {
			DefaultComboBoxModel<String> cbtg_model = (DefaultComboBoxModel<String>) cbThoiGian.getModel();
			String timeStart = cbtg_model.getSelectedItem().toString().substring(0, cbtg_model.getSelectedItem().toString().indexOf(" - "));
			String timeEnd = cbtg_model.getSelectedItem().toString().substring(cbtg_model.getSelectedItem().toString().indexOf("- ") + 2);
			caHoc ch = new caHoc(null, timeStart.trim(), timeEnd.trim());
			caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
			monHocChiTiet mhct = new monHocChiTiet();
			mhct.setMaMH(xemThemMH);
			mhct.setMaCa(chDAO.getMaCa());
			DefaultComboBoxModel<String> cbDD_model = (DefaultComboBoxModel<String>) cbDiaDiem.getModel();
			cbDD_model.removeAllElements();
			ArrayList<diaDiemHoc> listDD = diaDiemHocDAO.getdiaDiemHocDAO().selectAllTheoMHCH(mhct);
			System.out.println(listDD.size());
			for (diaDiemHoc diaDiemHoc : listDD) {
				cbDD_model.addElement(diaDiemHoc.getDiaChi());
			}
		} catch (Exception e) {
			
		}
	}

	public JPanel monHocCuaToi() {
		JPanel panelMHCT = new JPanel();
		panelMHCT.setBounds(263, 92, 1138, 698);
		
		
		panelMHCT.setLayout(null);
		panelMHCT.setBackground(new Color(195, 209, 226));
		
		JScrollPane scrollPane_MH = new JScrollPane();
		scrollPane_MH.setBounds(33, 15, 703, 209);
		panelMHCT.add(scrollPane_MH);
		
		table_MH = new JTable();
		table_MH.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clickTableMH();
			}
		});
		table_MH.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã khóa học", "Mã môn học", "Tên môn học", "Tổng số giờ học"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		table_MH.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_MH.getColumnModel().getColumn(1).setPreferredWidth(30);
		table_MH.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_MH.getColumnModel().getColumn(3).setPreferredWidth(35);
		
		table_MH.setRowHeight(26);
		
		ArrayList<monHoc> list = monHocDAO.monHocDAO().selectAll1();
		DefaultTableModel table_model = (DefaultTableModel) table_MH.getModel();
		for (monHoc monHoc : list) {
			monHocChiTiet mhct = new monHocChiTiet();
			mhct.setMaMH(monHoc.getMaMH());
			monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectG(mhct);
			table_model.addRow(new Object[] {monHoc.getMaKH(), monHoc.getMaMH(), monHoc.getTenMH(), monHoc.getSoGioHoc() + " Hours"});
		}
		
		table_MH.setRowSelectionInterval(0, 0);
		
		scrollPane_MH.setViewportView(table_MH);
		
		JScrollPane scrollPane_MHCT = new JScrollPane();
		scrollPane_MHCT.setBounds(33, 234, 703, 233);
		panelMHCT.add(scrollPane_MHCT);
		
		table_MHCT = new JTable();
		table_MHCT.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clickTableMHCT();
			}
		});
		table_MHCT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã môn học", "Lớp học", "Thời gian", "Địa điểm", "Giảng viên"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_MHCT.setRowHeight(22);
		
		
		
		scrollPane_MHCT.setViewportView(table_MHCT);
		
		JScrollPane scrollPane_HV = new JScrollPane();
		scrollPane_HV.setBounds(33, 477, 703, 209);
		panelMHCT.add(scrollPane_HV);
		
		table_HV = new JTable();
		table_HV.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clickTableHV();
			}
		});
		table_HV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên học viên", "Email", "Số điện thoại", "Trạng thái"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPane_HV.setViewportView(table_HV);
		
		JPanel panel_Search = new JPanel();
		panel_Search.setBackground(new Color(255, 255, 255));
		panel_Search.setBounds(776, 15, 334, 209);
		panelMHCT.add(panel_Search);
		panel_Search.setLayout(null);
		
		lblNewLabel_4 = new JLabel("TÌM KIẾM");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(109, 10, 117, 29);
		panel_Search.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Từ khóa:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 66, 93, 29);
		panel_Search.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Tìm theo:");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_6.setBounds(10, 117, 93, 29);
		panel_Search.add(lblNewLabel_6);
		
		txtTKTK = new JTextField();
		txtTKTK.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTKTK.setBounds(113, 66, 211, 29);
		panel_Search.add(txtTKTK);
		txtTKTK.setColumns(10);
		
		cbTimTheo = new JComboBox();
		cbTimTheo.setModel(new DefaultComboBoxModel(new String[] {"Tên môn học", "Lớp học", "Giảng viên", "Email học viên", "Tên học viên", "Trạng thái học viên"}));
		cbTimTheo.setMaximumRowCount(4);
		cbTimTheo.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTimTheo.setBounds(113, 117, 211, 29);
		panel_Search.add(cbTimTheo);
		
		btnTimMH = new JLabel("Tìm");
		btnTimMH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTimMH.setBackground(new Color(229,229,229));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnTimMH.setBackground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				timMHCT();
			}
		});
		btnTimMH.setBorder(new TitledBorder(""));
		btnTimMH.setBackground(Color.WHITE);
		btnTimMH.setOpaque(true);
		btnTimMH.setHorizontalAlignment(SwingConstants.CENTER);
		btnTimMH.setFont(new Font("Arial", Font.BOLD, 16));
		btnTimMH.setBounds(60, 162, 93, 29);
		panel_Search.add(btnTimMH);
		
		btnResetMH = new JLabel("Reset");
		btnResetMH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnResetMH.setBackground(new Color(229,229,229));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnResetMH.setBackground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(lblXemThem);
				contentPane.add(panel_left);
				contentPane.add(panel_top);
				contentPane.add(monHocCuaToi());
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnResetMH.setOpaque(true);
		btnResetMH.setHorizontalAlignment(SwingConstants.CENTER);
		btnResetMH.setFont(new Font("Arial", Font.BOLD, 16));
		btnResetMH.setBorder(new TitledBorder(""));
		btnResetMH.setBackground(Color.WHITE);
		btnResetMH.setBounds(188, 162, 93, 29);
		panel_Search.add(btnResetMH);
		
		JPanel panel_MHCT = new JPanel();
		panel_MHCT.setBackground(new Color(255, 255, 255));
		panel_MHCT.setBounds(776, 234, 334, 233);
		panelMHCT.add(panel_MHCT);
		panel_MHCT.setLayout(null);
		
		lblNewLabel_7 = new JLabel("THÔNG TIN MÔN HỌC");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_7.setBounds(54, 10, 227, 29);
		panel_MHCT.add(lblNewLabel_7);
		
		cbTTMH_TG = new JComboBox();
		cbTTMH_TG.setMaximumRowCount(4);
		cbTTMH_TG.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTTMH_TG.setBounds(113, 92, 211, 24);
		panel_MHCT.add(cbTTMH_TG);
		
		lblNewLabel_9 = new JLabel("Thời gian:");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_9.setBounds(10, 92, 93, 24);
		panel_MHCT.add(lblNewLabel_9);
		
		cbTTMH_DD = new JComboBox();
		cbTTMH_DD.setMaximumRowCount(4);
		cbTTMH_DD.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTTMH_DD.setBounds(113, 126, 211, 24);
		panel_MHCT.add(cbTTMH_DD);
		
		lblNewLabel_10 = new JLabel("Địa điểm:");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_10.setBounds(10, 126, 93, 24);
		panel_MHCT.add(lblNewLabel_10);
		
		lblNewLabel_13 = new JLabel("Mã môn:");
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_13.setBounds(10, 58, 65, 24);
		panel_MHCT.add(lblNewLabel_13);
		
		txtMaTTMH = new JTextField();
		txtMaTTMH.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMaTTMH.setEditable(false);
		txtMaTTMH.setColumns(10);
		txtMaTTMH.setBounds(84, 57, 63, 24);
		panel_MHCT.add(txtMaTTMH);
		
		
		btnDeleteMH = new JLabel("Delete");
		btnDeleteMH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDeleteMH.setBackground(new Color(229,229,229));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnDeleteMH.setBackground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				deleteTTMHCT();
			}
		});
		btnDeleteMH.setBorder(new TitledBorder(""));
		btnDeleteMH.setOpaque(true);
		btnDeleteMH.setHorizontalAlignment(SwingConstants.CENTER);
		btnDeleteMH.setFont(new Font("Arial", Font.BOLD, 16));
		btnDeleteMH.setBackground(Color.WHITE);
		btnDeleteMH.setBounds(231, 196, 93, 26);
		panel_MHCT.add(btnDeleteMH);
		
		cbTTMH_LH = new JComboBox();
		cbTTMH_LH.setMaximumRowCount(4);
		cbTTMH_LH.setFont(new Font("Arial", Font.PLAIN, 15));
		cbTTMH_LH.setBounds(241, 57, 83, 24);
		panel_MHCT.add(cbTTMH_LH);
		
		lblNewLabel_12 = new JLabel("Lớp học:");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_12.setBounds(166, 58, 68, 24);
		panel_MHCT.add(lblNewLabel_12);
		
		JLabel lblNewLabel_10_1 = new JLabel("Giảng viên:");
		lblNewLabel_10_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_10_1.setBounds(10, 160, 93, 24);
		panel_MHCT.add(lblNewLabel_10_1);
		
		cbTTMH_EmailGV = new JComboBox();
		cbTTMH_EmailGV.setMaximumRowCount(4);
		cbTTMH_EmailGV.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTTMH_EmailGV.setBounds(113, 160, 211, 24);
		panel_MHCT.add(cbTTMH_EmailGV);
		
		btnSaveTTMH = new JLabel("Save");
		btnSaveTTMH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSaveTTMH.setBackground(new Color(229,229,229));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnSaveTTMH.setBackground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				saveTTMHCT();
			}
		});
		btnSaveTTMH.setOpaque(true);
		btnSaveTTMH.setHorizontalAlignment(SwingConstants.CENTER);
		btnSaveTTMH.setFont(new Font("Arial", Font.BOLD, 16));
		btnSaveTTMH.setBorder(new TitledBorder(""));
		btnSaveTTMH.setBackground(Color.WHITE);
		btnSaveTTMH.setBounds(121, 196, 93, 26);
		panel_MHCT.add(btnSaveTTMH);
		
		JLabel btnUpdate = new JLabel("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				updateTTMHCT();
			}
		});
		btnUpdate.setOpaque(true);
		btnUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 16));
		btnUpdate.setBorder(new TitledBorder(""));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(10, 196, 93, 26);
		panel_MHCT.add(btnUpdate);
		
		JPanel panel_HV = new JPanel();
		panel_HV.setBackground(new Color(255, 255, 255));
		panel_HV.setBounds(776, 477, 334, 209);
		panelMHCT.add(panel_HV);
		panel_HV.setLayout(null);
		
		lblNewLabel_8 = new JLabel("THÔNG TIN HỌC VIÊN");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_8.setBounds(54, 10, 227, 29);
		panel_HV.add(lblNewLabel_8);
		
		lblNewLabel_15 = new JLabel("Tên:");
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_15.setBounds(10, 49, 93, 29);
		panel_HV.add(lblNewLabel_15);
		
		txtTTHV_TenHV = new JTextField();
		txtTTHV_TenHV.setEditable(false);
		txtTTHV_TenHV.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTTHV_TenHV.setColumns(10);
		txtTTHV_TenHV.setBounds(113, 49, 211, 29);
		panel_HV.add(txtTTHV_TenHV);
		
		lblNewLabel_16 = new JLabel("Email:");
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_16.setBounds(10, 88, 93, 29);
		panel_HV.add(lblNewLabel_16);
		
		txtTTHV_Email = new JTextField();
		txtTTHV_Email.setEditable(false);
		txtTTHV_Email.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTTHV_Email.setColumns(10);
		txtTTHV_Email.setBounds(113, 88, 211, 29);
		panel_HV.add(txtTTHV_Email);
		
		lblNewLabel_17 = new JLabel("Phone: ");
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_17.setBounds(10, 127, 93, 29);
		panel_HV.add(lblNewLabel_17);
		
		txtTTHV_Phone = new JTextField();
		txtTTHV_Phone.setEditable(false);
		txtTTHV_Phone.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTTHV_Phone.setColumns(10);
		txtTTHV_Phone.setBounds(113, 127, 211, 29);
		panel_HV.add(txtTTHV_Phone);
		
		btnXemThemTTHV = new JLabel("Xem thêm");
		btnXemThemTTHV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnXemThemTTHV.setBackground(new Color(229,229,229));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnXemThemTTHV.setBackground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(lblXemThem);
				contentPane.add(panel_left);
				contentPane.add(panel_top);
				contentPane.add(qlUser());
				contentPane.repaint();
				contentPane.revalidate();
				for(int i = 0; i < table_User.getRowCount(); i ++) {
					if(table_User.getValueAt(i, 0).toString().equals(table_HV.getValueAt(table_HV.getSelectedRow(), 1))) {
						table_User.setRowSelectionInterval(i, i);
						break;
					}
				}
			}
		});
		btnXemThemTTHV.setBorder(new TitledBorder(""));
		btnXemThemTTHV.setOpaque(true);
		btnXemThemTTHV.setHorizontalAlignment(SwingConstants.CENTER);
		btnXemThemTTHV.setFont(new Font("Arial", Font.BOLD, 16));
		btnXemThemTTHV.setBackground(Color.WHITE);
		btnXemThemTTHV.setBounds(124, 170, 93, 29);
		panel_HV.add(btnXemThemTTHV);
		
		
		this.clickTableMH();
		table_MHCT.setRowSelectionInterval(0, 0);
		this.clickTableMHCT();
		table_HV.setRowSelectionInterval(0, 0);
		thayDoiLHTheoDD();
		
		cbTTMH_DD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> cbModel_DD = (DefaultComboBoxModel<String>) cbTTMH_DD.getModel();
				if(cbModel_DD.getSelectedItem() != null) {
					thayDoiLHTheoDD();
				}
			}
		});
		
		return panelMHCT;
	}
	
	public void clickTableMH() {
		DefaultTableModel table_model1 = (DefaultTableModel) table_MHCT.getModel();
		if(table_HV != null) {
			DefaultTableModel table_modelHV = (DefaultTableModel) table_HV.getModel();
			table_modelHV.setRowCount(0);
		}
		table_model1.setRowCount(0);
		monHoc mh = new monHoc();
		mh.setMaMH(table_MH.getValueAt(table_MH.getSelectedRow(), 1).toString());
		ArrayList<monHocChiTiet> listLH = monHocChiTietDAO.getmonHocChiTietDAO().selectAllTheoMH(mh);
		for (monHocChiTiet monHocChiTiet : listLH) {
			lopHoc lh = new lopHoc();
			lh.setMaLop(monHocChiTiet.getMaLop());
			diaDiemHoc dd = dangKyMHDAO.getdangKyMHDAO().selectDKDCH(lh);
			
			dangKyMH dk = new dangKyMH();
			dk.setMaMH(monHocChiTiet.getMaMHCT());
			caHoc ch = dangKyMHDAO.getdangKyMHDAO().selectDKCH(dk);
			
			table_model1.addRow(new Object[] {monHocChiTiet.getMaMH(), monHocChiTiet.getMaLop(), ch.getTimeStart() + " - " + ch.getTimeEnd(), dd.getDiaChi(), monHocChiTiet.getMaGiangVien()});
		}
		if(table_MHCT.getRowCount() > 0) {
			table_MHCT.setRowSelectionInterval(0, 0);
		}
		
		this.txtMaTTMH.setText(mh.getMaMH());
		
		clickTableMHCT();
	}
	
	public void clickTableMHCT() {
		DefaultTableModel table_modelHV = (DefaultTableModel) table_HV.getModel();
		table_modelHV.setRowCount(0);
		String time = table_MHCT.getValueAt(table_MHCT.getSelectedRow(), 2)+"";
		String timeStart = time.substring(0, time.indexOf(" - "));
		String timeEnd = time.substring(time.indexOf(" - ") + 2);
		caHoc ch = new caHoc(null, timeStart.trim(), timeEnd.trim());
		caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
		monHoc mhCT = new monHoc();
		mhCT.setMaMH(table_MHCT.getValueAt(table_MHCT.getSelectedRow(), 0)+"");
		lopHoc lh = new lopHoc();
		lh.setMaLop(table_MHCT.getValueAt(table_MHCT.getSelectedRow(), 1)+"");
		user u = new user();
		u.setUsername(table_MHCT.getValueAt(table_MHCT.getSelectedRow(), 4)+"");
		monHocChiTiet mhct = monHocChiTietDAO.getmonHocChiTietDAO().selectMaMHCTTheoMH(mhCT, chDAO, lh, u);
		ArrayList<thongTinCN> listHV = dangKyMHDAO.getdangKyMHDAO().selectNgDK(mhct);
		for (thongTinCN ttcn : listHV) {
			table_modelHV.addRow(new Object[] {ttcn.getName(), ttcn.getEmail(), ttcn.getSdt(), null});
		}
		if(table_HV.getRowCount() != 0) {
			table_HV.setRowSelectionInterval(0, 0);
		}
		
		
		DefaultComboBoxModel<String> cbModel_GV = (DefaultComboBoxModel<String>) cbTTMH_EmailGV.getModel();
		ArrayList<user> listGV = userDAO.getUserDAO().selectGV();
		cbModel_GV.removeAllElements();
		for (user user : listGV) {
			cbModel_GV.addElement(user.getUsername());
		}
		cbModel_GV.setSelectedItem(u.getUsername());
		
		
		DefaultComboBoxModel<String> cbModel_TG = (DefaultComboBoxModel<String>) cbTTMH_TG.getModel();
		cbModel_TG.removeAllElements();
		ArrayList<caHoc> listTG = caHocDAO.getcaHocDAO().selectAll();
		for (caHoc caHoc : listTG) {
			cbModel_TG.addElement(caHoc.getTimeStart() + " - " + caHoc.getTimeEnd());
		}
		cbModel_TG.setSelectedItem(time);
		
		
		DefaultComboBoxModel<String> cbModel_DD = (DefaultComboBoxModel<String>) cbTTMH_DD.getModel();
		cbModel_DD.removeAllElements();
		ArrayList<diaDiemHoc> listDD = diaDiemHocDAO.getdiaDiemHocDAO().selectAll();
		for (diaDiemHoc diaDiemHoc : listDD) {
			cbModel_DD.addElement(diaDiemHoc.getDiaChi());
		}
		cbModel_DD.setSelectedItem(table_MHCT.getValueAt(table_MHCT.getSelectedRow(), 3)+"");

		
		DefaultComboBoxModel<String> cbModel_LH = (DefaultComboBoxModel<String>) cbTTMH_LH.getModel();
		cbModel_LH.setSelectedItem(table_MHCT.getValueAt(table_MHCT.getSelectedRow(), 1)+"");
//		cbTTMH_LH
//		thayDoiLHTheoDD();
		if(this.table_HV != null) {
			if(((DefaultTableModel)this.table_HV.getModel()).getRowCount() != 0) {
				clickTableHV();
			} else {
				this.txtTTHV_TenHV.setText("");
				this.txtTTHV_Email.setText("");
				this.txtTTHV_Phone.setText("");
			}
		}
		maMHPublic = txtMaTTMH.getText();
		maLopPublic = cbTTMH_LH.getSelectedItem().toString();
		maGiangVienPublic = cbTTMH_EmailGV.getSelectedItem().toString();
		timeStartPublic = cbTTMH_TG.getSelectedItem().toString().substring(0, cbTTMH_TG.getSelectedItem().toString().indexOf(" - "));
		timeEndPublic = cbTTMH_TG.getSelectedItem().toString().substring(cbTTMH_TG.getSelectedItem().toString().indexOf(" - ")+3);
		
	}
	
	public void clickTableHV() {
		this.txtTTHV_TenHV.setText(this.table_HV.getValueAt(this.table_HV.getSelectedRow(), 0)+"");
		this.txtTTHV_Email.setText("" + this.table_HV.getValueAt(this.table_HV.getSelectedRow(), 1));
		this.txtTTHV_Phone.setText(this.table_HV.getValueAt(this.table_HV.getSelectedRow(), 2)+"");
	}
	
	public void thayDoiLHTheoDD() {
		try {
			DefaultComboBoxModel<String> cbModel_DD = (DefaultComboBoxModel<String>) cbTTMH_DD.getModel();
			diaDiemHoc ddhTTMHCT = new diaDiemHoc();
			ddhTTMHCT.setDiaChi(cbModel_DD.getSelectedItem().toString());
			diaDiemHoc ddhTTMHCTDAO = diaDiemHocDAO.getdiaDiemHocDAO().selectG(ddhTTMHCT);
			DefaultComboBoxModel<String> cbModel_LH = (DefaultComboBoxModel<String>) cbTTMH_LH.getModel();
			cbModel_LH.removeAllElements();
			ArrayList<lopHoc> list = lopHocDAO.getlopHocDAO().selectAllResLHTheoKhu(ddhTTMHCTDAO);
			for (lopHoc lopHoc : list) {
				cbModel_LH.addElement(lopHoc.getMaLop());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void timMHCT() {
		try {
			Connection c = JDBCUtil.connectJDBC();
			Statement st = c.createStatement();
			String sql = "";
			ResultSet rs;
			
			DefaultTableModel tableModel_MH = (DefaultTableModel) this.table_MH.getModel();
			DefaultTableModel tableModel_MHCT = (DefaultTableModel) this.table_MHCT.getModel();
			DefaultTableModel tableModel_HV = (DefaultTableModel) this.table_HV.getModel();
			
			DefaultComboBoxModel<String> cbModel_Tim = (DefaultComboBoxModel<String>) cbTimTheo.getModel();
			switch (cbModel_Tim.getSelectedItem().toString()) {
			
				case "Tên môn học":
					
					sql = "SELECT * FROM monhoc WHERE tenMH LIKE '%"+ txtTKTK.getText() +"%'";
					rs = st.executeQuery(sql);
					tableModel_MH.setRowCount(0);
					tableModel_MHCT.setRowCount(0);
					tableModel_HV.setRowCount(0);
					while (rs.next()) {
						String maKH = rs.getString("maKH");
						String maMH = rs.getString("maMH");
						String tenMH = rs.getString("tenMH");
						Double soGioHoc = rs.getDouble("soGioHoc");
						tableModel_MH.addRow(new Object[] {maKH, maMH, tenMH, soGioHoc + " Hours"});
					}
					if(this.table_MH.getRowCount() != 0) {
						this.table_MH.setRowSelectionInterval(0, 0);
						this.clickTableMH();
					}
					break;
					
				case "Lớp học":
					
					tableModel_MHCT.setRowCount(0);
					tableModel_HV.setRowCount(0);
					sql = "SELECT ct.maMH, ct.maLop, ch.thoiGianBatDau, ch.thoiGianKetThuc, kv.diaChi, ct.maGiangVien FROM monhocchitiet AS ct INNER JOIN cahoc AS ch ON ct.maCa = ch.maCa INNER JOIN lophoc AS lh ON ct.maLop = lh.maLop INNER JOIN khuvuc AS kv ON lh.maKhu = kv.maKhu WHERE ct.maMH = '"+txtMaTTMH.getText()+"'	AND ct.maLop LIKE '%"+ txtTKTK.getText() +"%'";
					rs = st.executeQuery(sql);
					
					while (rs.next()) {
						String maMH = rs.getString("maMH");
						String maLop = rs.getString("maLop");
						String thoiGianBatDau = rs.getString("thoiGianBatDau");
						String thoiGianKetThuc = rs.getString("thoiGianKetThuc");
						String diaChi = rs.getString("diaChi");
						String maGiangVien = rs.getString("maGiangVien");
						tableModel_MHCT.addRow(new Object[] {maMH, maLop, thoiGianBatDau + " - " + thoiGianKetThuc, diaChi, maGiangVien});
					}
					this.table_MHCT.setRowSelectionInterval(0, 0);
					this.clickTableMHCT();
					break;
					
				case "Giảng viên":
					
					tableModel_MHCT.setRowCount(0);
					tableModel_HV.setRowCount(0);
					sql = "SELECT ct.maMH, ct.maLop, ch.thoiGianBatDau, ch.thoiGianKetThuc, kv.diaChi, ct.maGiangVien FROM monhocchitiet AS ct INNER JOIN cahoc AS ch ON ct.maCa = ch.maCa INNER JOIN lophoc AS lh ON ct.maLop = lh.maLop INNER JOIN khuvuc AS kv ON lh.maKhu = kv.maKhu WHERE ct.maMH = '"+txtMaTTMH.getText()+"'	AND ct.maGiangVien LIKE '%"+ txtTKTK.getText() +"%'";
					rs = st.executeQuery(sql);
					
					while (rs.next()) {
						String maMH = rs.getString("maMH");
						String maLop = rs.getString("maLop");
						String thoiGianBatDau = rs.getString("thoiGianBatDau");
						String thoiGianKetThuc = rs.getString("thoiGianKetThuc");
						String diaChi = rs.getString("diaChi");
						String maGiangVien = rs.getString("maGiangVien");
						tableModel_MHCT.addRow(new Object[] {maMH, maLop, thoiGianBatDau + " - " + thoiGianKetThuc, diaChi, maGiangVien});
					}
					this.table_MHCT.setRowSelectionInterval(0, 0);
					this.clickTableMHCT();
					break;
					
				case "Email học viên":
					
					tableModel_HV.setRowCount(0);
					sql = "SELECT dk.emailUser, ttcn.name, ttcn.phone FROM monhocchitiet AS ct  INNER JOIN cahoc AS ch ON ct.maCa = ch.maCa INNER JOIN lophoc AS lh ON ct.maLop = lh.maLop INNER JOIN khuvuc AS kv ON lh.maKhu = kv.maKhu INNER JOIN dangky AS dk ON dk.maMHCT = ct.maMHCT INNER JOIN thongtincn AS ttcn ON dk.emailUser = ttcn.email WHERE ct.maMH = '"+txtMaTTMH.getText()+"' AND ct.maLop = '"+cbTTMH_LH.getSelectedItem().toString()+"' AND ch.thoiGianBatDau = '"+cbTTMH_TG.getSelectedItem().toString().substring(0,cbTTMH_TG.getSelectedItem().toString().indexOf(" - "))+"' AND ch.thoiGianKetThuc = '"+cbTTMH_TG.getSelectedItem().toString().substring(cbTTMH_TG.getSelectedItem().toString().indexOf(" - ")+3)+"' AND ttcn.email LIKE '%"+txtTKTK.getText()+"%'";
					rs = st.executeQuery(sql);
					
					while(rs.next()){
						String emailUser = rs.getString("emailUser");
						String name = rs.getString("name");
						String phone = rs.getString("phone");
//						String trangThai = rs.getString("");
						tableModel_HV.addRow(new Object[] {emailUser, name, phone, null});
					}
					if(this.table_HV.getRowCount() != 0) {
						this.table_HV.setRowSelectionInterval(0, 0);
						this.clickTableHV();
					}
					
					break;
					
				case "Tên học viên":
					
					
					tableModel_HV.setRowCount(0);
					sql = "SELECT dk.emailUser, ttcn.name, ttcn.phone FROM monhocchitiet AS ct  INNER JOIN cahoc AS ch ON ct.maCa = ch.maCa INNER JOIN lophoc AS lh ON ct.maLop = lh.maLop INNER JOIN khuvuc AS kv ON lh.maKhu = kv.maKhu INNER JOIN dangky AS dk ON dk.maMHCT = ct.maMHCT INNER JOIN thongtincn AS ttcn ON dk.emailUser = ttcn.email WHERE ct.maMH = '"+txtMaTTMH.getText()+"' AND ct.maLop = '"+cbTTMH_LH.getSelectedItem().toString()+"' AND ch.thoiGianBatDau = '"+cbTTMH_TG.getSelectedItem().toString().substring(0,cbTTMH_TG.getSelectedItem().toString().indexOf(" - "))+"' AND ch.thoiGianKetThuc = '"+cbTTMH_TG.getSelectedItem().toString().substring(cbTTMH_TG.getSelectedItem().toString().indexOf(" - ")+3)+"' AND ttcn.name LIKE '%"+txtTKTK.getText()+"%'";
					rs = st.executeQuery(sql);
					
					while(rs.next()){
						String emailUser = rs.getString("emailUser");
						String name = rs.getString("name");
						String phone = rs.getString("phone");
//						String trangThai = rs.getString("");
						tableModel_HV.addRow(new Object[] {emailUser, name, phone, null});
					}
					if(this.table_HV.getRowCount() != 0) {
						this.table_HV.setRowSelectionInterval(0, 0);
						this.clickTableHV();
					}
					break;
				case "Trạng thái học viên":
					
					
					sql = "";
					rs = st.executeQuery(sql);
					
					while(rs.next()){
						
					}
					break;
				default:
					break;
			}
			
			
			JDBCUtil.disConnecJDBC(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTTMHCT() {
		int kq = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa lớp học này?", "", JOptionPane.YES_NO_OPTION);
		if(kq == JOptionPane.YES_OPTION) {
			String maMH = txtMaTTMH.getText();
			String maLop = cbTTMH_LH.getSelectedItem().toString();
			String maGiangVien = cbTTMH_EmailGV.getSelectedItem().toString();
			String timeStart = cbTTMH_TG.getSelectedItem().toString().substring(0, cbTTMH_TG.getSelectedItem().toString().indexOf(" - "));
			String timeEnd = cbTTMH_TG.getSelectedItem().toString().substring(cbTTMH_TG.getSelectedItem().toString().indexOf(" - ")+3);
			
			caHoc ch = new caHoc(null, timeStart, timeEnd);
			caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
			
			monHocChiTiet mhct = new monHocChiTiet(null, maMH, maGiangVien, maLop, chDAO.getMaCa());
			monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectMaMHCT(mhct);
			
			monHocChiTietDAO.getmonHocChiTietDAO().deleteX(mhctDAO);
			DefaultTableModel tableModel_MHCT =  (DefaultTableModel) this.table_MHCT.getModel();
			int row_select = this.table_MHCT.getSelectedRow();
			tableModel_MHCT.removeRow(row_select);
			int row_max = this.table_MHCT.getRowCount();
			System.out.println(row_select + " - " + row_max);
			if(row_select >=  row_max) {
				if(row_max != 0)
					this.table_MHCT.setRowSelectionInterval(row_max - 1, row_max - 1);
			} else {
				this.table_MHCT.setRowSelectionInterval(row_select,row_select);
			}
			this.clickTableMHCT();
			JOptionPane.showMessageDialog(this, "Delete thành công");
		}
	}

	public void saveTTMHCT() {
		String maMH = txtMaTTMH.getText();
		String maLop = cbTTMH_LH.getSelectedItem().toString();
		String maGiangVien = cbTTMH_EmailGV.getSelectedItem().toString();
		String timeStart = cbTTMH_TG.getSelectedItem().toString().substring(0, cbTTMH_TG.getSelectedItem().toString().indexOf(" - "));
		String timeEnd = cbTTMH_TG.getSelectedItem().toString().substring(cbTTMH_TG.getSelectedItem().toString().indexOf(" - ")+3);
		
		caHoc ch = new caHoc(null, timeStart, timeEnd);
		caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
		
		monHocChiTiet mhct = new monHocChiTiet(null, maMH, maGiangVien, maLop, chDAO.getMaCa());
		monHocChiTiet mhctDAO = monHocChiTietDAO.getmonHocChiTietDAO().selectMaMHCT(mhct);
		
		if(mhctDAO.getMaMHCT() == null) {
			
			ArrayList<monHocChiTiet> listAllMHCT = monHocChiTietDAO.getmonHocChiTietDAO().selectAll();
			Collections.sort(listAllMHCT, new Comparator<monHocChiTiet>() {
				@Override
				public int compare(monHocChiTiet o1, monHocChiTiet o2) {
					if(Integer.valueOf(o1.getMaMHCT().substring(4)) > Integer.valueOf(o2.getMaMHCT().substring(4))) {
						return 1;
					} else if(Integer.valueOf(o1.getMaMHCT().substring(4)) < Integer.valueOf(o2.getMaMHCT().substring(4))) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			
			int i = 0;
			for (monHocChiTiet monHocChiTiet : listAllMHCT) {
				int j = Integer.valueOf(monHocChiTiet.getMaMHCT().substring(4));
				if(j != i) {
					break;
				}
				i++;
			}
			mhct.setMaMHCT("MHCT" + i);
			monHocChiTietDAO.getmonHocChiTietDAO().insertX(mhct);
			DefaultTableModel tableModel_MHCT = (DefaultTableModel) this.table_MHCT.getModel();
			tableModel_MHCT.addRow(new Object[] {maMH, maLop, cbTTMH_TG.getSelectedItem().toString(), cbTTMH_DD.getSelectedItem().toString(), maGiangVien});
			this.table_MHCT.setRowSelectionInterval(this.table_MHCT.getRowCount()-1, this.table_MHCT.getRowCount()-1);
			this.clickTableMHCT();
			
			JOptionPane.showMessageDialog(this, "Save thành công");
		} else {
			JOptionPane.showMessageDialog(this, "Save thất bại\nVui lòng kiểm tra lại lớp học, thời gian học và giảng viên để tránh bị trùng lặp");
		}
	}
	
	public void updateTTMHCT() {
		caHoc chPublic = new caHoc(null, timeStartPublic, timeEndPublic);
		caHoc chDAOPublic = caHocDAO.getcaHocDAO().selectG(chPublic);
		
		monHocChiTiet mhctPublic = new monHocChiTiet(null, maMHPublic, maGiangVienPublic, maLopPublic, chDAOPublic.getMaCa());
		monHocChiTiet mhctDAOPublic = monHocChiTietDAO.getmonHocChiTietDAO().selectMaMHCT(mhctPublic);
		
		String maMH = txtMaTTMH.getText();
		String maLop = cbTTMH_LH.getSelectedItem().toString();
		String maGiangVien = cbTTMH_EmailGV.getSelectedItem().toString();
		String timeStart = cbTTMH_TG.getSelectedItem().toString().substring(0, cbTTMH_TG.getSelectedItem().toString().indexOf(" - "));
		String timeEnd = cbTTMH_TG.getSelectedItem().toString().substring(cbTTMH_TG.getSelectedItem().toString().indexOf(" - ")+3);
		caHoc ch = new caHoc(null, timeStart, timeEnd);
		caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
		monHocChiTiet mhct = new monHocChiTiet(mhctDAOPublic.getMaMHCT(), maMH, maGiangVien, maLop, chDAO.getMaCa());
		
		monHocChiTietDAO.getmonHocChiTietDAO().updateX(mhct);
		
		this.table_MHCT.setValueAt(mhct.getMaMH(), this.table_MHCT.getSelectedRow(), 0);
		this.table_MHCT.setValueAt(mhct.getMaLop(), this.table_MHCT.getSelectedRow(), 1);
		this.table_MHCT.setValueAt(timeStart + " - " + timeEnd, this.table_MHCT.getSelectedRow(), 2);
		this.table_MHCT.setValueAt(cbTTMH_DD.getSelectedItem(), this.table_MHCT.getSelectedRow(), 3);
		this.table_MHCT.setValueAt(mhct.getMaGiangVien(), this.table_MHCT.getSelectedRow(), 4);
		
		JOptionPane.showMessageDialog(this, "Update thành công");
	}

	public void loadCV() {
		JFileChooser fc = new JFileChooser();
		int kq = fc.showOpenDialog(this);
		if(kq == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			if(f.getName().endsWith(".png") || f.getName().endsWith(".jpg")) {
				this.lblCV.setText(f.getName());
				String duoi = f.getName().endsWith(".png")? "png" : "jpg";
				String nameFl = f.toString().substring(f.toString().lastIndexOf("\\")+1);
				try {
					BufferedImage bi = ImageIO.read(f);
					ImageIO.write(bi, duoi, new File((Paths.get("icon\\" + nameFl)).toAbsolutePath().toString()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void openPngFile(String filePath) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                File pngFile = new File(filePath);
                desktop.open(pngFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Desktop is not supported on this platform.");
        }
    }

	public JPanel xemTTCTUser(user u) {
		thongTinCN ttcn = thongTinCNDAO.thongTinCNDAO().selectTTCNTheoEmail(u);
		
		
		JPanel xemTTCTUser = new JPanel();
		xemTTCTUser.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		xemTTCTUser.setBounds(263, 92, 1138, 698);
		xemTTCTUser.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(881, 0, 257, 698);
		xemTTCTUser.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitleCN = new JLabel("Chức năng:");
		lblTitleCN.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitleCN.setBounds(10, 10, 112, 45);
		panel.add(lblTitleCN);
		
		JButton btnSuaUserCT = new JButton("Cập nhật");
		btnSuaUserCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongTinCN tt = new thongTinCN();
				tt.setEmail(lblEmailUserCT.getText());
				tt.setName(lblNameUserCT.getText());
				tt.setSdt(lblPhoneUserCT.getText());
				
				thongTinCNDAO.thongTinCNDAO().updateY(tt);
				JOptionPane.showMessageDialog(quanLyKhoaHocview.this, "Cập nhật thành công");
			}
		});
		btnSuaUserCT.setFocusPainted(false);
		btnSuaUserCT.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSuaUserCT.setBounds(16, 59, 98, 37);
		panel.add(btnSuaUserCT);
		
		JButton btnXoaUserCT = new JButton("Xóa");
		btnXoaUserCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongTinCN tt = new thongTinCN();
				tt.setEmail(lblEmailUserCT.getText());
				tt.setName(lblNameUserCT.getText());
				tt.setSdt(lblPhoneUserCT.getText());
				
				thongTinCNDAO.thongTinCNDAO().deleteX(tt);
				user u = new user();
				u.setUsername(tt.getEmail());
				userDAO.getUserDAO().deleteX(u);
				
				JOptionPane.showMessageDialog(quanLyKhoaHocview.this, "Xóa thành công");
				clickBackUser();
			}
		});
		btnXoaUserCT.setFocusPainted(false);
		btnXoaUserCT.setFont(new Font("Arial", Font.PLAIN, 14));
		btnXoaUserCT.setBounds(144, 59, 98, 37);
		panel.add(btnXoaUserCT);
		
		JButton btnXemDiemUserCT = new JButton("Xem điểm");
		btnXemDiemUserCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xemDiemUserCT();
			}
		});
		btnXemDiemUserCT.setFocusPainted(false);
		btnXemDiemUserCT.setFont(new Font("Arial", Font.PLAIN, 14));
		btnXemDiemUserCT.setBounds(80, 109, 98, 37);
		panel.add(btnXemDiemUserCT);
		
		JLabel lblTitleTK = new JLabel("Thống kê:");
		lblTitleTK.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitleTK.setBounds(10, 174, 112, 45);
		panel.add(lblTitleTK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(18, 222, 222, 114);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_19 = new JLabel("Tổng môn học");
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(45, 10, 132, 27);
		panel_1.add(lblNewLabel_19);
		
		JLabel lblNewLabel_19_1 = new JLabel("đã đăng ký:");
		lblNewLabel_19_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19_1.setBounds(45, 30, 132, 27);
		panel_1.add(lblNewLabel_19_1);
		
		JLabel lblMHDK = new JLabel("0 Môn");
		lblMHDK.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMHDK.setHorizontalAlignment(SwingConstants.CENTER);
		lblMHDK.setBounds(61, 67, 98, 27);
		panel_1.add(lblMHDK);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(18, 346, 222, 114);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_19_1_1 = new JLabel("đã hoàn thành:");
		lblNewLabel_19_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19_1_1.setBounds(45, 30, 132, 27);
		panel_1_1.add(lblNewLabel_19_1_1);
		
		JLabel lblNewLabel_19_2 = new JLabel("Tổng môn học");
		lblNewLabel_19_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19_2.setBounds(45, 10, 132, 27);
		panel_1_1.add(lblNewLabel_19_2);
		
		JLabel lblMHHT = new JLabel("0 Môn");
		lblMHHT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMHHT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMHHT.setBounds(61, 67, 98, 27);
		panel_1_1.add(lblMHHT);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBounds(18, 470, 222, 114);
		panel.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_19_1_1_1 = new JLabel("đang theo học:");
		lblNewLabel_19_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19_1_1_1.setBounds(45, 30, 132, 27);
		panel_1_1_1.add(lblNewLabel_19_1_1_1);
		
		JLabel lblNewLabel_19_2_1 = new JLabel("Tổng môn học");
		lblNewLabel_19_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19_2_1.setBounds(45, 10, 132, 27);
		panel_1_1_1.add(lblNewLabel_19_2_1);
		
		JLabel lblMHDT = new JLabel("0 Môn");
		lblMHDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMHDT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMHDT.setBounds(61, 67, 98, 27);
		panel_1_1_1.add(lblMHDT);
		
		JLabel btnBack = new JLabel("New label");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clickBackUser();
			}
		});
		btnBack.setBorder(new TitledBorder(""));
		btnBack.setBounds(50, 605, 45, 37);
		panel.add(btnBack);
		
		JLabel btnNext = new JLabel("New label");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clickNextUser();
			}
		});
		btnNext.setBorder(new TitledBorder(""));
		btnNext.setBounds(162, 605, 45, 37);
		panel.add(btnNext);
		
		JButton btnQuayLaiUserCT = new JButton("Quay lại");
		btnQuayLaiUserCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(lblXemThem);
				contentPane.add(panel_left);
				contentPane.add(panel_top);
				contentPane.add(qlUser());
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		btnQuayLaiUserCT.setFocusPainted(false);
		btnQuayLaiUserCT.setFont(new Font("Arial", Font.PLAIN, 14));
		btnQuayLaiUserCT.setBounds(84, 656, 92, 30);
		panel.add(btnQuayLaiUserCT);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(0, 168, 257, 2);
		panel.add(separator);
		
		xemTTCTUser.setBackground(new Color(195, 209, 226));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(160, 45, 561, 194);
		xemTTCTUser.add(panel_3);
		panel_3.setLayout(null);
		
		ImageAvatar imgUserCT = new ImageAvatar();
		imgUserCT.setGradientColor2(new Color(211, 236, 6));
		imgUserCT.setGradientColor1(new Color(71, 61, 255));
		imgUserCT.setBackground(new Color(102, 51, 255));
		imgUserCT.setBounds(16, 29, 189, 139);
		
		imgUserCT.setImage(new javax.swing.ImageIcon((Paths.get("icon\\" + ttcn.getAvatar()).toAbsolutePath().toString())));
		panel_3.add(imgUserCT);
		
		JLabel lblNewLabel_19_2_2 = new JLabel("Email:");
//		lblNewLabel_19_2_2.setBackground(new Color(255, 255, 255));
//		lblNewLabel_19_2_2.setOpaque(true);
//		lblNewLabel_19_2_2.setBorder(new TitledBorder(""));
		lblNewLabel_19_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_19_2_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19_2_2.setBounds(227, 29, 78, 27);
		panel_3.add(lblNewLabel_19_2_2);
		
		JLabel lblNewLabel_19_2_3 = new JLabel("Name:");
//		lblNewLabel_19_2_3.setBackground(new Color(255, 255, 255));
//		lblNewLabel_19_2_3.setOpaque(true);
//		lblNewLabel_19_2_3.setBorder(new TitledBorder(""));
		lblNewLabel_19_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_19_2_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19_2_3.setBounds(227, 66, 78, 27);
		panel_3.add(lblNewLabel_19_2_3);
		
		JLabel lblNewLabel_19_2_3_1 = new JLabel("Phone:");
//		lblNewLabel_19_2_3_1.setBackground(new Color(255, 255, 255));
//		lblNewLabel_19_2_3_1.setOpaque(true);
//		lblNewLabel_19_2_3_1.setBorder(new TitledBorder(""));
		lblNewLabel_19_2_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_19_2_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19_2_3_1.setBounds(227, 102, 78, 27);
		panel_3.add(lblNewLabel_19_2_3_1);
		
		JLabel lblNewLabel_19_2_3_1_1 = new JLabel("Role:");
//		lblNewLabel_19_2_3_1_1.setBackground(new Color(255, 255, 255));
//		lblNewLabel_19_2_3_1_1.setOpaque(true);
//		lblNewLabel_19_2_3_1_1.setBorder(new TitledBorder(""));
		lblNewLabel_19_2_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_19_2_3_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_19_2_3_1_1.setBounds(227, 141, 78, 27);
		panel_3.add(lblNewLabel_19_2_3_1_1);
		
		lblEmailUserCT = new JTextField(ttcn.getEmail());
		lblEmailUserCT.setEditable(false);
		lblEmailUserCT.setBackground(new Color(255, 255, 255));
		lblEmailUserCT.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailUserCT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmailUserCT.setBounds(315, 29, 221, 27);
		panel_3.add(lblEmailUserCT);
		
		lblNameUserCT = new JTextField(ttcn.getName());
		lblNameUserCT.setBackground(new Color(255, 255, 255));
		lblNameUserCT.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameUserCT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNameUserCT.setBounds(315, 66, 221, 27);
		panel_3.add(lblNameUserCT);
		
		lblPhoneUserCT = new JTextField(ttcn.getSdt());
		lblPhoneUserCT.setBackground(new Color(255, 255, 255));
		lblPhoneUserCT.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneUserCT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPhoneUserCT.setBounds(315, 102, 221, 27);
		panel_3.add(lblPhoneUserCT);
		
		lblRoleUserCT = new JTextField(u.getRole());
		lblRoleUserCT.setEditable(false);
		lblRoleUserCT.setBackground(new Color(255, 255, 255));
		lblRoleUserCT.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoleUserCT.setFont(new Font("Arial", Font.PLAIN, 18));
		lblRoleUserCT.setBounds(315, 141, 221, 27);
		panel_3.add(lblRoleUserCT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 283, 772, 390);
		xemTTCTUser.add(scrollPane);
		
		tableMH_UserCT = new JTable();
		tableMH_UserCT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 m\u00F4n", "T\u00EAn m\u00F4n", "M\u00E3 L\u1EDBp", "Ca học", "Giảng viên", "Tr\u1EA1ng th\u00E1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableMH_UserCT.setFont(new Font("Arial", Font.PLAIN, 16));
		tableMH_UserCT.setRowHeight(25);
		scrollPane.setViewportView(tableMH_UserCT);
		DefaultTableModel tableModel_UserCT = (DefaultTableModel) tableMH_UserCT.getModel();
		
		dangKyMH dk = new dangKyMH();
		dk.setEmailUser(u.getUsername());
		
		user uDAO = userDAO.getUserDAO().selectG(u);
		if(uDAO.getRole().equals("gv")) {
			ArrayList<monHocChiTiet> list = monHocChiTietDAO.getmonHocChiTietDAO().selectAllMHCTTheoEmailGV(dk);
			for (monHocChiTiet mhct : list) {
				monHoc mh = new monHoc();
				mh.setMaMH(mhct.getMaMH());
				monHoc mhDAO = monHocDAO.monHocDAO().selectG(mh);
				
				caHoc ch = caHocDAO.getcaHocDAO().selectTGQuaMaCa(mhct);
				
				tableModel_UserCT.addRow(new Object[] {mhct.getMaMH(), mhDAO.getTenMH(), mhct.getMaLop(), ch.getTimeEnd() + " - " + ch.getTimeEnd(), mhct.getMaGiangVien(), null});
			}
		} else {
			ArrayList<monHocChiTiet> list = monHocChiTietDAO.getmonHocChiTietDAO().selectAllMHCTTheoEmail(dk);
			for (monHocChiTiet mhct : list) {
				monHoc mh = new monHoc();
				mh.setMaMH(mhct.getMaMH());
				monHoc mhDAO = monHocDAO.monHocDAO().selectG(mh);
				
				caHoc ch = caHocDAO.getcaHocDAO().selectTGQuaMaCa(mhct);
				
				tableModel_UserCT.addRow(new Object[] {mhct.getMaMH(), mhDAO.getTenMH(), mhct.getMaLop(), ch.getTimeEnd() + " - " + ch.getTimeEnd(), mhct.getMaGiangVien(), null});
			}
		}
		
		
		lblMHDK.setText(tableMH_UserCT.getRowCount() + " Môn");
		 
		
		return xemTTCTUser;
	}

	public void clickTableDSLH() {
		DefaultTableModel tableModel_DSHV = (DefaultTableModel) table_DSHV.getModel();
		tableModel_DSHV.setRowCount(0);
		
		String maMH = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 0) + "";
		String maLop = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 2) + "";
		String giangVien = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 4) + "";
		String time = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 3) + "";
		String timeStart = time.substring(0, time.indexOf(" - "));
		String timeEnd = time.substring(time.indexOf(" - ")+3);
		
		monHoc mh = new monHoc();
		mh.setMaMH(maMH);
		
		caHoc ch = new caHoc(null, timeStart, timeEnd);
		caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
		
		lopHoc lh = new lopHoc();
		lh.setMaLop(maLop);
		
		user u = new user();
		u.setUsername(giangVien);
		
		monHocChiTiet ttMhct = monHocChiTietDAO.getmonHocChiTietDAO().selectMaMHCTTheoMH(mh, chDAO, lh, u);
		
		if(this.roleLoginTemp.equals("hv")) {
			user uHv = new user();
			uHv.setUsername(this.nameLoginTemp);
			ArrayList<thongTinCN> listHV = dangKyMHDAO.getdangKyMHDAO().select1NgDK(ttMhct, uHv);
			for (thongTinCN thongTinCN : listHV) {
				tableModel_DSHV.addRow(new Object[] {thongTinCN.getEmail(), thongTinCN.getName()});
			}
		} else {
			ArrayList<thongTinCN> listHV = dangKyMHDAO.getdangKyMHDAO().selectNgDK(ttMhct);
			for (thongTinCN thongTinCN : listHV) {
				tableModel_DSHV.addRow(new Object[] {thongTinCN.getEmail(), thongTinCN.getName()});
			}
		}
		
		
		if(tableModel_DSHV.getRowCount() > 0) {
			table_DSHV.setRowSelectionInterval(0, 0);
			clickTableDSHV(ttMhct);
		} else {
			DefaultTableModel tableModel_DSCT = (DefaultTableModel) table_DSCT.getModel();
			tableModel_DSCT.setRowCount(0);
		}
	}
		
	public void clickTableDSHV(monHocChiTiet ttMhct) {
		DefaultTableModel tableModel_DSCT = (DefaultTableModel) table_DSCT.getModel();
		tableModel_DSCT.setRowCount(0);
		user diemUser = new user();
		diemUser.setUsername(table_DSHV.getValueAt(table_DSHV.getSelectedRow(), 0)+"");
		int i = 1;
		ArrayList<diemChiTiet> listDiemct = diemChiTietDAO.getdiemChiTietDAO().selectAllTheoEmail(diemUser, ttMhct);
		for (diemChiTiet diemChiTiet : listDiemct) {
			diemSo ds = new diemSo();
			ds.setMaDD(diemChiTiet.getMaDauDiem());
			diemSo dsDAO = diemSoDAO.getdiemSoDAO().selectG(ds);
			tableModel_DSCT.addRow(new Object[] {i, dsDAO.getTenDD(), dsDAO.getTrongSo(), diemChiTiet.getDiem() < 0 ? "" : diemChiTiet.getDiem(), diemChiTiet.getGhiChu(), null});
			i++;
		}
	}
	
	public void clickSaveTableDSCT() {
		DefaultTableModel tableModel_DSCT = (DefaultTableModel) table_DSCT.getModel();
		
		diemChiTiet dsct = new diemChiTiet();
		dsct.setEmail(table_DSHV.getValueAt(table_DSHV.getSelectedRow(), 0)+"");
		
		DefaultTableModel tableModel_DSHV = (DefaultTableModel) table_DSHV.getModel();
		
		String maMH = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 0) + "";
		String maLop = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 2) + "";
		String giangVien = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 4) + "";
		String time = table_DSLH.getValueAt(table_DSLH.getSelectedRow(), 3) + "";
		String timeStart = time.substring(0, time.indexOf(" - "));
		String timeEnd = time.substring(time.indexOf(" - ")+3);
		
		monHoc mh = new monHoc();
		mh.setMaMH(maMH);
		
		caHoc ch = new caHoc(null, timeStart, timeEnd);
		caHoc chDAO = caHocDAO.getcaHocDAO().selectG(ch);
		
		lopHoc lh = new lopHoc();
		lh.setMaLop(maLop);
		
		user u = new user();
		u.setUsername(giangVien);
		
		monHocChiTiet ttMhct = monHocChiTietDAO.getmonHocChiTietDAO().selectMaMHCTTheoMH(mh, chDAO, lh, u);
		
		dsct.setMaMHCT(ttMhct.getMaMHCT());
		
		for (int i = 0; i < table_DSCT.getRowCount(); i++) {
			diemSo ds = new diemSo();
			ds.setTenDD(table_DSCT.getValueAt(i, 1)+"");
			ds.setTrongSo(Integer.valueOf(table_DSCT.getValueAt(i, 2)+""));
			diemSo dsDAO = diemSoDAO.getdiemSoDAO().selectMaDD(ds);
			dsct.setMaDauDiem(dsDAO.getMaDD());
			
			if((table_DSCT.getValueAt(i, 3)+"").isEmpty()) {
				dsct.setDiem(-1.0);
				dsct.setGhiChu(table_DSCT.getValueAt(i, 4)+"");
				
				diemChiTietDAO.getdiemChiTietDAO().updateX(dsct);
			} else {
				if(Double.valueOf(table_DSCT.getValueAt(i, 3)+"") < 0 || Double.valueOf(table_DSCT.getValueAt(i, 3)+"") > 10) {
					JOptionPane.showMessageDialog(this, "Điểm phải trong khoảng từ 0 - 10");
				} else {
					dsct.setDiem(Double.valueOf(table_DSCT.getValueAt(i, 3)+""));
					dsct.setGhiChu(table_DSCT.getValueAt(i, 4)+"");
					
					diemChiTietDAO.getdiemChiTietDAO().updateX(dsct);
				}
			}
			
			
		}
	}

	
	public void xemDiemUserCT() {
		this.nameLoginTemp = this.lblEmailUserCT.getText();
		this.roleLoginTemp = this.lblRoleUserCT.getText();
		contentPane.removeAll();
		contentPane.add(lblXemThem);
		contentPane.add(panel_left);
		contentPane.add(panel_top);
		contentPane.add(xemDiem());
		contentPane.repaint();
		contentPane.revalidate();
		this.nameLoginTemp = this.nameLogin;
		this.roleLoginTemp = this.roleLogin;
	}
	
	public void clickBackUser() {
		ArrayList<user> listUser = userDAO.getUserDAO().selectAll();
		user uTemp = new user();
		int i = 0;
		for (user user : listUser) {
			if(user.getUsername().equals("admin")) {
				continue;
			}
			if(user.getUsername().equals(lblEmailUserCT.getText()) && i != 0) {
				user userX = new user();
				userX.setUsername(uTemp.getUsername());
				userX.setRole(uTemp.getRole());
				contentPane.removeAll();
				contentPane.add(lblXemThem);
				contentPane.add(panel_left);
				contentPane.add(panel_top);
				contentPane.add(xemTTCTUser(userX));
				contentPane.repaint();
				contentPane.revalidate();
				break;
			}
			
			uTemp = user;
			i++;
			if(i == listUser.size() - 1) {
				user userX = new user();
				userX.setUsername(uTemp.getUsername());
				userX.setRole(uTemp.getRole());
				contentPane.removeAll();
				contentPane.add(lblXemThem);
				contentPane.add(panel_left);
				contentPane.add(panel_top);
				contentPane.add(xemTTCTUser(userX));
				contentPane.repaint();
				contentPane.revalidate();
			}
		}
	}
	
	public void clickNextUser() {
		ArrayList<user> listUser = userDAO.getUserDAO().selectAllESC();
		user uTemp = new user();
		int i = 0;
		for (user user : listUser) {
			if(user.getUsername().equals("admin")) {
				continue;
			}
			if(user.getUsername().equals(lblEmailUserCT.getText()) && i != 0) {
				user userX = new user();
				userX.setUsername(uTemp.getUsername());
				userX.setRole(uTemp.getRole());
				contentPane.removeAll();
				contentPane.add(lblXemThem);
				contentPane.add(panel_left);
				contentPane.add(panel_top);
				contentPane.add(xemTTCTUser(userX));
				contentPane.repaint();
				contentPane.revalidate();
				break;
			}
			
			uTemp = user;
			i++;
			if(i == listUser.size() - 1) {
				user userX = new user();
				userX.setUsername(uTemp.getUsername());
				userX.setRole(uTemp.getRole());
				contentPane.removeAll();
				contentPane.add(lblXemThem);
				contentPane.add(panel_left);
				contentPane.add(panel_top);
				contentPane.add(xemTTCTUser(userX));
				contentPane.repaint();
				contentPane.revalidate();
			}
		}
	}


}
