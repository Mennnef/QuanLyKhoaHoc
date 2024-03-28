package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;

import controller.controllerRegister;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;


public class registerView extends JFrame {
	
    public JButton btnSignUp;
    public JButton btnCancel;
    public JCheckBox ckbYesNo;
    public JComboBox<String> jComboBox1;
    public JLabel jLabel2;
    public JLabel jLabel3;
    public JLabel jLabel4;
    public JLabel jLabel5;
    public JLabel jLabel6;
    public JTextField txtEmail;
    public JTextField txtAnswer;
	public JPanel contentPane;
	public controllerRegister c = new controllerRegister(this);
	public JPasswordField txtPassword1;
	public JPasswordField txtPassword2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerView frame = new registerView();
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
	public registerView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 536);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		txtAnswer = new JTextField();
		txtAnswer.setForeground(new Color(192, 192, 192));
		txtAnswer.addFocusListener(c);
		txtAnswer.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 14));
	    ckbYesNo = new JCheckBox();
	    ckbYesNo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    ckbYesNo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
	    jComboBox1 = new JComboBox<>();
	    jComboBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    jComboBox1.setForeground(new Color(0, 0, 0));
	    jComboBox1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
	    jLabel2 = new JLabel();
	    jLabel3 = new JLabel();
	    btnSignUp = new JButton();
	    btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnSignUp.setOpaque(false);
	    btnSignUp.setFocusPainted(false);
	    btnSignUp.addActionListener(c);
	    btnSignUp.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
	    jLabel4 = new JLabel();
	    btnCancel = new JButton();
	    btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    btnCancel.setOpaque(false);
	    btnCancel.setFocusPainted(false);
	    btnCancel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));
	    btnCancel.addActionListener(c);
	    jLabel5 = new JLabel();
	    jLabel6 = new JLabel();
	    jLabel6.setIcon(new ImageIcon((Paths.get("icon\\signup64.png").toString())));
	    jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
	    txtEmail = new JTextField();
	    
	    txtAnswer.setText("Your Answer?");

        ckbYesNo.setText("I Agree to the Term of User");
        
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "What's your father name?", "What's your mother name?", "What's your first girlfriend?" }));

        jLabel2.setFont(new Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel2.setText("Authenticator Questions");

        jLabel3.setFont(new Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel3.setText("Email");

        btnSignUp.setText("SIGN UP");

        jLabel4.setFont(new Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel4.setText("Password");

        btnCancel.setText("CANCEL");

        jLabel5.setFont(new Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setText("Repeat Password");

        jLabel6.setFont(new Font("Segoe Print", 1, 24)); // NOI18N
        jLabel6.setText(" SIGN UP");

        txtEmail.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14)); // NOI18N
        txtEmail.setForeground(new Color(0, 0, 0));
        
        txtPassword1 = new JPasswordField();
        
        txtPassword2 = new JPasswordField();

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(110)
        			.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        			.addGap(117))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addGap(119)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(txtPassword2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
        				.addComponent(ckbYesNo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jLabel2, Alignment.LEADING)
        				.addComponent(jLabel5, Alignment.LEADING)
        				.addComponent(jLabel4, Alignment.LEADING)
        				.addComponent(jLabel3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jComboBox1, Alignment.LEADING, 0, 199, Short.MAX_VALUE)
        				.addComponent(txtAnswer, Alignment.LEADING, 199, 199, Short.MAX_VALUE)
        				.addComponent(txtPassword1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        				.addComponent(txtEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        			.addGap(108))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel6)
        			.addGap(18)
        			.addComponent(jLabel3)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel4)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtPassword1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel5)
        			.addGap(8)
        			.addComponent(txtPassword2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtAnswer, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(ckbYesNo)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
		
	}

}
