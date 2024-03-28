package controller;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import DAO.userDAO;
import view.forgotPasswordView;
import view.loginView;
import view.quanLyKhoaHocview;
import view.registerView;
import model.user;

public class controllerLogin implements ActionListener, FocusListener, MouseListener{
	private loginView v_login;
	private String user = "";
	private String pass = "";
	private String email_login_now;
	
	public controllerLogin(loginView v_login) {
		this.v_login = v_login;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Login")) {
			String userName = this.v_login.txtxUserName.getText();
			String passWord = String.valueOf(this.v_login.txtPassWord.getPassword());
			user u = new user(userName, passWord);
			
			user uDao = userDAO.getUserDAO().selectG(u);
			
			if(u.getUsername().equals(uDao.getUsername()) && u.getPassword().equals(uDao.getPassword())) {
				this.v_login.setVisible(false);
				email_login_now = uDao.getUsername();
				quanLyKhoaHocview v = new quanLyKhoaHocview(email_login_now);
				v.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this.v_login, "Email hoặc password không đúng");
			}
			
		} 
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(this.v_login.txtxUserName.isFocusOwner()) {
			if(user.equals("") || user.equals("Nhập email")) {
				this.v_login.txtxUserName.setText("");
				this.v_login.txtxUserName.setFont(this.v_login.txtxUserName.getFont().deriveFont(Font.PLAIN));
				this.v_login.txtxUserName.setForeground(Color.BLACK);
			} 
		} else if(this.v_login.txtPassWord.isFocusOwner()){
			if(pass.equals("") || pass.equals("Nhập pass")) {
				this.v_login.txtPassWord.setText("");
				this.v_login.txtPassWord.setFont(this.v_login.txtPassWord.getFont().deriveFont(Font.PLAIN));
				this.v_login.txtPassWord.setForeground(Color.BLACK);
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		this.user = this.v_login.txtxUserName.getText();
		this.pass = String.valueOf(this.v_login.txtPassWord.getPassword());
		if(!this.v_login.txtxUserName.isFocusOwner()) {
			if(user.equals("")) {
				this.v_login.txtxUserName.setText("Nhập email");
				this.v_login.txtxUserName.setFont(this.v_login.txtxUserName.getFont().deriveFont(Font.ITALIC));
				this.v_login.txtxUserName.setForeground(Color.GRAY);
			}
		}
		if(!this.v_login.txtPassWord.isFocusOwner()) {
			if(pass.equals("")) {
				this.v_login.txtPassWord.setText("Nhập pass");
				this.v_login.txtPassWord.setFont(this.v_login.txtPassWord.getFont().deriveFont(Font.ITALIC));
				this.v_login.txtPassWord.setForeground(Color.GRAY);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Color c = new Color(89, 183, 71);
		if(this.v_login.lblForgot.getForeground().equals(c)) {
			this.v_login.setVisible(false);
			forgotPasswordView forgotPasswordView = new forgotPasswordView();
			forgotPasswordView.setVisible(true);
		}
		if(this.v_login.lblRegister.getForeground().equals(c)) {
			this.v_login.setVisible(false);
			registerView registerView = new registerView();
			registerView.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.v_login.txtxUserName.setFocusable(true);
		this.v_login.txtPassWord.setFocusable(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
