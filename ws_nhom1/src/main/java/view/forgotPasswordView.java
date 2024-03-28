package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;

import controller.controllerForgotPassword;
import controller.controllerLogin;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.nio.file.Paths;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class forgotPasswordView extends JFrame {
	public JButton btnGet;
	public JComboBox<String> jComboBox1;
	public JLabel jLabel1;
	public JLabel jLabel2;
	public JTextField txtEmail;
	public JTextField txtAnswer;
	public JPanel contentPane;
	public controllerForgotPassword c = new controllerForgotPassword(this);
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotPasswordView frame = new forgotPasswordView();
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
	public forgotPasswordView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 408);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		jLabel1 = new JLabel();
        txtEmail = new JTextField();
        txtEmail.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if(txtEmail.getText().equals("") || txtEmail.getText().equals("Your Email?")) {
        			txtEmail.setText("");
        			txtEmail.setForeground(Color.BLACK);
        			txtEmail.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        		}
        	}

        	@Override
        	public void focusLost(FocusEvent e) {
        		if(txtEmail.getText().equals("") || txtEmail.getText().equals("Your Email?")) {
        			txtEmail.setText("Your Email?");
        			txtEmail.setForeground(Color.GRAY);
        			txtEmail.setFont(new Font("Segoe UI Historic", Font.ITALIC, 16));
        		}
        	}
        });
        txtEmail.setForeground(new Color(192, 192, 192));
        jLabel2 = new JLabel();
        txtAnswer = new JTextField();
        txtAnswer.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if(txtAnswer.getText().equals("") || txtAnswer.getText().equals("Your Answer?")) {
        			txtAnswer.setText("");
        			txtAnswer.setForeground(Color.BLACK);
        			txtAnswer.setFont(new Font("Segoe UI Historic", Font.PLAIN, 16));
        		}
        	}

        	@Override
        	public void focusLost(FocusEvent e) {
        		if(txtAnswer.getText().equals("") || txtAnswer.getText().equals("Your Answer?")) {
        			txtAnswer.setText("Your Answer?");
        			txtAnswer.setForeground(Color.GRAY);
        			txtAnswer.setFont(new Font("Segoe UI Historic", Font.ITALIC, 16));
        		}
        	}
        });
        txtAnswer.setForeground(new Color(192, 192, 192));
        
        txtAnswer.setFont(new Font("Segoe UI Historic", Font.ITALIC, 16));
        jComboBox1 = new JComboBox<>();
        jComboBox1.setRenderer(new CursorRenderer());
        jComboBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jComboBox1.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
        btnGet = new JButton();
        btnGet.addActionListener(c);
        btnGet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jLabel1.setFont(new Font("Segoe UI", 1, 18)); 
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("FORGOT PASSWORD");

        txtEmail.setFont(new Font("Segoe UI Historic", Font.ITALIC, 16)); 
        txtEmail.setText("Your Email?");

        jLabel2.setFont(new Font("Segoe UI Historic", Font.BOLD, 16)); 
        jLabel2.setText("Authenticator Questions");
        
        txtAnswer.setText("Your Answer?");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "What's your father name?", "What's your mother name?", "What's your first girlfriend?" }));

        
        btnGet.setBackground(new Color(0, 204, 204));
        btnGet.setFont(new Font("Microsoft PhagsPa", 1, 18)); // NOI18N
        btnGet.setForeground(new Color(255, 255, 255));
        btnGet.setText("Get Password");
        
        btnNewButton = new JButton("");
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
        btnNewButton.setOpaque(false);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		c.v_forgot.setVisible(false);
        		loginView v = new loginView();
        	}
        });
        btnNewButton.setIcon(new ImageIcon((Paths.get("icon\\back16.png")).toString()));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon((Paths.get("icon\\lock64.png")).toString()));
        
        final JLabel lblNewLabel_1 = new JLabel("Thử cách khác");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		lblNewLabel_1.setForeground(new Color(98,98,98));
        	}
        	
        	@Override
        	public void mouseExited(MouseEvent e) {
        		lblNewLabel_1.setForeground(new Color(0,0,0));
        	}
        	
        	@Override
        	public void mousePressed(MouseEvent e) {
        		c.getPassWord();
        	}
        });
        lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Arial", Font.ITALIC, 10));

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addGap(115)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(145, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(99, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel2, Alignment.LEADING)
        					.addComponent(txtEmail, Alignment.LEADING)
        					.addComponent(txtAnswer, Alignment.LEADING))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnGet, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        					.addGap(27)))
        			.addGap(89))
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(169, Short.MAX_VALUE)
        			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        			.addGap(166))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtAnswer, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnGet)
        			.addGap(10)
        			.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
	}
	static class CursorRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            return component;
        }
    }
}
