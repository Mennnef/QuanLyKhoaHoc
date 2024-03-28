package view;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class tableTeacherCellEditor extends DefaultCellEditor{

	private tableAcctionEvent event;
	
	public tableTeacherCellEditor(tableAcctionEvent event) {
		super(new JCheckBox());
		this.event = event;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		Component com = super.getTableCellEditorComponent(table, value, isSelected, row, column);
		panelActionButtonYesNo pYN = new panelActionButtonYesNo();
		pYN.setBackground(table.getSelectionBackground());
		pYN.initEvent(event, row);
		return pYN;
	}
}
