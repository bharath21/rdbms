import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Table {
    private final String name;
    private int numberOfCols;
    private List<Column> columns;
    private final List<DataRecord> records;

    public Table(String name) {
        this.name = name;
        records = new LinkedList<>();
    }

    public void setNumberOfCols(int numberOfCols) {
        this.numberOfCols = numberOfCols;
    }

    public void setColumns(Column... columns) {
        this.columns = Arrays.asList(columns);
    }

    public List<DataRecord> getRecords() {
        return records;
    }

    public boolean typeCheck(DataRecord record) {
        int itr = 0;
        for (var column : columns) {
            Object value = record.getValues()[itr];
            if (column.type == Type.String) {
                if (!(value instanceof String)) {
                    System.out.println("type check failed "+itr);
                    return false;
                }
                if (!column.type.isEligible(value, column.parameters)) {
                    System.out.println("column constraint check failed "+itr);
                    return false;
                }
            }
            if (column.type == Type.Integer) {
                if (!(value instanceof Integer)) {
                    System.out.println("type check failed "+itr);
                    return false;
                }
                if (!column.type.isEligible(value, column.parameters)) {
                    System.out.println("column constraint check failed "+itr);
                    return false;
                }
            }
            itr++;
        }
        return true;
    }

    public boolean constraintCheck(DataRecord record) {
        int itr = 0;
        for (var column : columns) {
            if (column.getConstraints() != null) {
                for (var constraint : column.getConstraints()) {
                    Object value = record.getValues()[itr];
                    if (!constraint.isEligible(value, column.parameters)) {
                        System.out.println("constraint check failed "+itr);
                        return false;
                    }
                }
                itr++;
            }
        }
        return true;
    }

    public boolean insertRecord(DataRecord record) {
        if (!typeCheck(record) || !constraintCheck(record)) {
            return false;
        }
        records.add(record);
        return true;
    }

    public int getIndexOfCol(String column) {
        int itr = 0;
        for (var col : columns) {
            if (col.equals(column)) {
                return itr;
            }
            itr++;
        }
        return -1;
    }
}
