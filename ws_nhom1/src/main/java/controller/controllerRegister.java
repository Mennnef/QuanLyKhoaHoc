package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import DAO.userDAO;
import model.user;
import view.loginView;
import view.registerView;

public class controllerRegister implements ActionListener, FocusListener{
	private registerView v_reg;
	
	public controllerRegister(registerView v_reg) {
		this.v_reg = v_reg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("CANCEL")) {
			this.v_reg.setVisible(false);
			loginView loginView = new loginView();
		} else {
			String email_test = "^[A-Za-z0-9-\\+]+([A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			if(this.v_reg.txtEmail.getText().equals("") 
					|| String.valueOf(this.v_reg.txtPassword1.getPassword()).equals("") 
					|| String.valueOf(this.v_reg.txtPassword2.getPassword()).equals("") 
					|| this.v_reg.txtAnswer.getText().equals("")
					|| this.v_reg.txtAnswer.getText().equals("Your Answer?")) 
			{
				JOptionPane.showMessageDialog(this.v_reg, "Phải nhập đầy đủ thông tin");
			} else {
				String userName = this.v_reg.txtEmail.getText();
				String password = "";
				String answer = this.v_reg.jComboBox1.getSelectedItem() + ": " + this.v_reg.txtAnswer.getText();
				if(userName.matches(email_test)) {
					
					if(String.valueOf(this.v_reg.txtPassword1.getPassword()).equals(String.valueOf(this.v_reg.txtPassword2.getPassword()))) {
						password = String.valueOf(this.v_reg.txtPassword1.getPassword());
						
						if(this.v_reg.ckbYesNo.isSelected()) {
							
							try {
								user u = new user(userName, password, answer);
								u.setRole("hv");
								user u1 = userDAO.getUserDAO().selectG(u);
								if(u1.getUsername().equals(u.getUsername())) {
									JOptionPane.showMessageDialog(this.v_reg, "Email này đã tồn tại");
								} else {
									long maBV = Math.round((Math.random() * 8999) + 1000);
									
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
										mess.setSubject("Mã đăng ký: ");
										mess.setText("Mã đăng ký của bạn là: " + maBV);
										
										Transport.send(mess);
									} catch (Exception e1) {
										e1.printStackTrace();
									} 
									
									String ma = JOptionPane.showInputDialog(this.v_reg, "Vui lòng nhập mã đăng ký");
									try {
										if(Long.valueOf(ma) == maBV) {
											userDAO.getUserDAO().insertX(u);
											JOptionPane.showMessageDialog(this.v_reg, "Đăng ký hoàn tất");
										} else {
											JOptionPane.showMessageDialog(this.v_reg, "Mã đăng ký không đúng\nĐăng ký thất bại");
										}
									} catch (NumberFormatException e1) {
										if(ma.equals("")) {
											JOptionPane.showMessageDialog(this.v_reg, "Vui lòng nhập mã đăng ký");
										} else {
											JOptionPane.showMessageDialog(this.v_reg, "Nhập sai định dạng");
										}
									}
								}
							} catch (HeadlessException e1) {
								e1.printStackTrace();
							}
							
							
						} else {
							JOptionPane.showMessageDialog(this.v_reg, "Vui lòng đọc qua điều khoản và đồng ý với chúng tôi");
						}
						
					} else {
						JOptionPane.showMessageDialog(this.v_reg, "Password không khớp");
					}
					
				} else {
					JOptionPane.showMessageDialog(this.v_reg, "Email phải đúng định dạng");
				}
			}

			
		}
	}
	
//	Your Answer?
	
	@Override
	public void focusGained(FocusEvent e) {
		if(this.v_reg.txtAnswer.getText().equals("") || this.v_reg.txtAnswer.getText().equals("Your Answer?")) {
			this.v_reg.txtAnswer.setText("");
			this.v_reg.txtAnswer.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
			this.v_reg.txtAnswer.setForeground(Color.BLACK);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(this.v_reg.txtAnswer.getText().equals("") || this.v_reg.txtAnswer.getText().equals("Your Answer?")) {
			this.v_reg.txtAnswer.setText("Your Answer?");
			this.v_reg.txtAnswer.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 14));
			this.v_reg.txtAnswer.setForeground(Color.GRAY);
		}
	}
	
	
}
