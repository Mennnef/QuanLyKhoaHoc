package view;
//import org.apache.commons.io.FilenameUtils;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.controllerLogin;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;

public class loginView extends JFrame {
	
	private controllerLogin c = new controllerLogin(this);
	public JPasswordField txtPassWord;
	public JTextField txtxUserName;
	public JLabel lblForgot;
	public JLabel lblRegister;
	
	public loginView(){
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassWord.setFocusable(false);
				txtxUserName.setFocusable(false);
			}
		});
		this.setResizable(false);
		getContentPane().setLayout(null);
		this.login();
		this.setVisible(true);
	}
	
	public void login() {
		this.setTitle("Login");
		this.setSize(621, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Path p = Paths.get("src\\main\\resources\\Employee.png");
		File f = new File("C:\\Users\\Admin\\eclipse-workspace\\ws_nhom1\\src\\main\\resources\\Employee.png");
		System.out.println(f.getPath());
		
		ImageAvatar imgLogin = new ImageAvatar();
		imgLogin.setLocation(32, 34);
		imgLogin.setSize(200, 200);
		imgLogin.setBackground(new java.awt.Color(102, 51, 255));
        imgLogin.setGradientColor1(new Color(0, 0, 0));
        imgLogin.setGradientColor2(new Color(0, 0, 0));
        imgLogin.setImage(new javax.swing.ImageIcon("src/main/resources/Employee.png")); // NOI18N
        getContentPane().add(imgLogin);
        
        JLabel lblUserLogin = new JLabel("User Login");
        lblUserLogin.setForeground(new Color(0, 0, 0));
        lblUserLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserLogin.setFont(new Font("Arial", Font.BOLD, 24));
        lblUserLogin.setBounds(370, 34, 150, 28);
        getContentPane().add(lblUserLogin);
        
        txtxUserName = new RoundJTextField(15);
        txtxUserName.setForeground(new Color(192, 192, 192));
        txtxUserName.setToolTipText("Email");
        txtxUserName.setText("Nhập email");
        txtxUserName.setFont(new Font("Arial", Font.ITALIC, 16));
        txtxUserName.setColumns(10);
        txtxUserName.setBounds(351, 72, 191, 32);
        txtxUserName.addFocusListener(c);
        txtxUserName.setFocusable(false);
        txtxUserName.addMouseListener(c);
        getContentPane().add(txtxUserName);
        
        txtPassWord = new RoundJPassWordField(15);
        txtPassWord.setToolTipText("PassWord");
        txtPassWord.setText("Nhập pass");
        txtPassWord.setFont(new Font("Arial", Font.ITALIC, 16));
        txtPassWord.setForeground(new Color(192, 192, 192));
        txtPassWord.setColumns(10);
        txtPassWord.setBounds(351, 123, 191, 32);
        txtPassWord.addFocusListener(c);
        txtPassWord.addMouseListener(c);
        txtPassWord.setFocusable(false);
        getContentPane().add(txtPassWord);
        
        
        try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
        JButton btnLogin = new JButton("Login");
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.addActionListener(c);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setOpaque(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(new Color(89, 183, 71, 1));
        btnLogin.setBounds(383, 174, 131, 41);
        
        getContentPane().add(btnLogin);
        
        lblForgot = new JLabel("Forgot Password");
        lblForgot.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblForgot.setForeground(new Color(89, 183, 71));
        	}
        	
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblForgot.setForeground(Color.BLACK);
        	}
        });
        lblForgot.addMouseListener(c);
        lblForgot.setFont(new Font("Arial", Font.ITALIC, 14));
        lblForgot.setBounds(351, 225, 116, 28);
        lblForgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        getContentPane().add(lblForgot);
        
        JLabel lblNewLabel_1 = new JLabel("/");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Arial", Font.ITALIC, 14));
        lblNewLabel_1.setBounds(463, 233, 11, 13);
        getContentPane().add(lblNewLabel_1);
        
        lblRegister = new JLabel("Register");
        lblRegister.setFont(new Font("Arial", Font.ITALIC, 14));
        lblRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblRegister.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblRegister.setForeground(new Color(89, 183, 71));
        	}
        	
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblRegister.setForeground(Color.BLACK);
        	}
        });
        lblRegister.addMouseListener(c);
        lblRegister.setBounds(477, 225, 65, 28);
        getContentPane().add(lblRegister);
        
	}
}
