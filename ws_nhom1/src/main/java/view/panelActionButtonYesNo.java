package view;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class panelActionButtonYesNo extends JPanel {
	private acctionButton btnYes, btnNo, btnXemCV;

	/**
	 * Create the panel.
	 */
	public panelActionButtonYesNo() {
		this.setSize(119, 31);
		setLayout(null);

		btnYes = new acctionButton();
		btnYes.setIcon(new ImageIcon(Paths.get("icon\\tick16.png").toAbsolutePath().toString()));
		btnYes.setBounds(2, 6, 25, 20);
		add(btnYes);

		btnNo = new acctionButton();
		btnNo.setIcon(new ImageIcon(Paths.get("icon\\exit16.png").toAbsolutePath().toString()));
		btnNo.setBounds(27, 6, 25, 20);
		add(btnNo);
		
		btnXemCV = new acctionButton();
		btnXemCV.setIcon(new ImageIcon(Paths.get("icon\\cv16.png").toAbsolutePath().toString()));
		btnXemCV.setBounds(52, 6, 25, 20);
		add(btnXemCV);
	}

	public void initEvent(final tableAcctionEvent event, final int row) {
		btnYes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				event.onUpdate(row);
			}
		});

		btnNo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				event.onDelete(row);
			}
		});
		
		btnXemCV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				event.onMore(row);
			}
		});
	}
}
