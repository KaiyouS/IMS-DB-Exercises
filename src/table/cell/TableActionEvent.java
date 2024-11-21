package table.cell;

/**
 * Interface for handling table action events.
 */
public interface TableActionEvent {
    void onEdit(int row);
    void onDelete(int row);
    void onView(int row);
}