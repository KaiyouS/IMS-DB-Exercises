package table.cell;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class AlternatingRowColorRenderer extends DefaultTableCellRenderer {
    private final Color lightColor;
    private final Color darkColor;

    public AlternatingRowColorRenderer() {
        int c1 = 255;
        int c2 = 247;
        this.lightColor = new Color(c1,c1,c1);
        this.darkColor = new Color(c2,c2,c2);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!isSelected) {
            c.setBackground(row % 2 == 0 ? darkColor : lightColor);
        } else {
            c.setBackground(table.getSelectionBackground());
        }
        return c;
    }
}