package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class tableTeacherCellRenderer extends DefaultTableCellRenderer{
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		panelActionButtonYesNo pYN = new panelActionButtonYesNo();
		if(isSelected) {
			pYN.setBackground(com.getBackground());
		} else {
			pYN.setBackground(Color.WHITE);
		}
		return pYN;
	}
}
