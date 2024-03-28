package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import DAO.userDAO;
import model.user;
import view.forgotPasswordView;

public class controllerForgotPassword implements ActionListener{
	public forgotPasswordView v_forgot;
	
	public controllerForgotPassword(forgotPasswordView v_forgot) {
		this.v_forgot = v_forgot;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Get Password")) {
			String email = this.v_forgot.txtEmail.getText();
			String answer = this.v_forgot.jComboBox1.getSelectedItem() + ": " + this.v_forgot.txtAnswer.getText();
			user u = new user();
			u.setUsername(email);
			u.setAnswer(answer);
			user u1 = userDAO.getUserDAO().selectG(u);
			if(u.getUsername().equals(u1.getUsername()) && u.getAnswer().equals(u1.getAnswer())) {
				JOptionPane.showMessageDialog(this.v_forgot, "Password của bạn là: " + u1.getPassword());
			} else {
				JOptionPane.showMessageDialog(this.v_forgot, "Email hoặc câu trả lời không đúng");
			}
		}
	}
	
	public void getPassWord() {
		String email = JOptionPane.showInputDialog(this.v_forgot, "Nhập email của bạn");

		user u = new user();
		u.setUsername(email);
		if(email == null || email.equals("")) {
			
		} else {
			user u1 = userDAO.getUserDAO().selectG(u);
			if(u.getUsername().equals(u1.getUsername())) {
				Properties p = new Properties();
				p.put("mail.smtp.auth", "true");
				p.put("mail.smtp.starttls.enable", "true"); 
				p.put("mail.smtp.host", "smtp.gmail.com");
				p.put("mail.smtp.port", "587"); 
				p.put("mail.smtp.ssl.protocols", "TLSv1.2");
				
				final String emailSever = "nguyenhoahung1007@gmail.com";
				final String passSever = "miyadhnqogmurwqu";
				
				Authenticator auth = new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailSever, passSever);
					}
				};
				
				Session session = Session.getInstance(p, auth);
				Message mess = new MimeMessage(session);
				
				try {
					mess.setFrom(new InternetAddress(emailSever));
					mess.setRecipients(Message.RecipientType.TO, InternetAddress.parse(u.getUsername()));
					mess.setSubject("Password");
					mess.setText("PassWord của bạn là: " + u1.getPassword());
					
					Transport.send(mess);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				
				JOptionPane.showMessageDialog(this.v_forgot, "Password của bạn đã được gửi vào gmail\nVui lòng check");
			} else {
				JOptionPane.showMessageDialog(this.v_forgot, "Email này chưa tồn tại trong hệ thống của chúng tôi");
			}
		}
	}
}
