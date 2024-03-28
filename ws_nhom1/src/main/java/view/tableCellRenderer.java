package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class tableCellRenderer extends DefaultTableCellRenderer{
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		panelAcctionButton pab = new panelAcctionButton();
		if(isSelected == false) {
			pab.setBackground(Color.WHITE);
		} else {
			pab.setBackground(com.getBackground());
		}
		return pab;
	}
}
