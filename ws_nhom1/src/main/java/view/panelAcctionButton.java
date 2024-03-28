package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class panelAcctionButton extends JPanel {
	
	private acctionButton btnUpdate, btnDelete, btnMore;
	/**
	 * Create the panel.
	 */
	public panelAcctionButton() {
		FlowLayout fl = new FlowLayout();
		this.setSize(new Dimension(119, 35));
		setLayout(null);
		
		btnUpdate = new acctionButton();
		btnUpdate.setBounds(10, 4, 25, 25);
		btnUpdate.setIcon(new ImageIcon(Paths.get("icon\\update16.png").toAbsolutePath().toString()));
		add(btnUpdate);
		
		btnDelete = new acctionButton();
		btnDelete.setBounds(45, 4, 25, 25);
		btnDelete.setIcon(new ImageIcon(Paths.get("icon\\delete16.png").toAbsolutePath().toString()));
		add(btnDelete);
		
		btnMore = new acctionButton();
		btnMore.setBounds(79, 4, 25, 25);
		btnMore.setIcon(new ImageIcon(Paths.get("icon\\search16.png").toAbsolutePath().toString()));
		add(btnMore);
		
	}
	
	public void initEvent(final tableAcctionEvent event ,final int row) {
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				event.onUpdate(row);
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				event.onDelete(row);
			}
		});
		
		btnMore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				event.onMore(row);
			}
		});
	}
}
