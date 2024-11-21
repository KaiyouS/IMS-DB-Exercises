package table.cell;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Custom cell editor for table actions.
 */
public class TableActionCellEditor extends DefaultCellEditor {
    private final PanelAction panelAction;
    private final TableActionEvent event;

    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
        panelAction = new PanelAction();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        TableCellRenderer defaultRenderer = table.getDefaultRenderer(Object.class);
        Component c = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, false, row, column);
        panelAction.setBackground(c.getBackground());

        // Remove existing action listeners to avoid multiple triggers
        for (var listener : panelAction.getEditButton().getActionListeners()) {
            panelAction.getEditButton().removeActionListener(listener);
        }
        for (var listener : panelAction.getDeleteButton().getActionListeners()) {
            panelAction.getDeleteButton().removeActionListener(listener);
        }
        for (var listener : panelAction.getViewButton().getActionListeners()) {
            panelAction.getViewButton().removeActionListener(listener);
        }

        // Add new action listeners
        panelAction.getEditButton().addActionListener(e -> event.onEdit(row));
        panelAction.getDeleteButton().addActionListener(e -> event.onDelete(row));
        panelAction.getViewButton().addActionListener(e -> event.onView(row));

        return panelAction;
    }
}