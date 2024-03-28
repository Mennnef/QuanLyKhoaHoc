package view;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class tableCellEditor extends DefaultCellEditor{

	private tableAcctionEvent event;
	
	public tableCellEditor(tableAcctionEvent event) {
		super(new JCheckBox());
		this.event = event;
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		Component com = super.getTableCellEditorComponent(table, value, isSelected, row, column);
		panelAcctionButton pab = new panelAcctionButton();
		pab.setBackground(table.getSelectionBackground());
		pab.initEvent(event, row);
		return pab;
	}
}
