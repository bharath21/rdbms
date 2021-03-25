import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private final String name;
    private final Map<String, Table> tableMap;

    public Database(String name) {
        this.name = name;
        tableMap = new HashMap<>();
    }

    public boolean createTable(String name) {
        Table table = new Table(name);
        table.setNumberOfCols(4);
        List<Constraint> constraints = Arrays.asList(Constraint.REQUIRED);
        List<Constraint> constraints2 = Arrays.asList(Constraint.MIN);

        List<Integer> params = null;
        Column column1 = new Column("id", constraints, Type.Integer, params);
        Column column2 = new Column("first_name", null, Type.String, params);
        Column column3 = new Column("last_name", null, Type.String, params);
        // min, max,length
        List<Integer> params2 = Arrays.asList(100);

        Column column4 = new Column("phone", constraints2, Type.Integer, params2);
        table.setColumns(column1, column2, column3, column4);
        tableMap.put(name, table);
        System.out.println(tableMap);
        return true;
    }

    public boolean test_table(String name) {
        Table table = tableMap.get(name);
        Object[] values = {1, "shubham", "as", 999};
        DataRecord record1 = new DataRecord(values);
        if (!table.insertRecord(record1)) {
            return false;
        }

        Object[] values2 = {2, "bharatbharatbharatbharatbharatbharatbharatbharat", "asdsd", 99};
        DataRecord record2 = new DataRecord(values2);
        table.insertRecord(record2);

        Object[] values3 = {3, "sdasds", "asdsd", 99};
        DataRecord record3 = new DataRecord(values2);
        table.insertRecord(record3);

        Object[] values4 = {4, "sdasds", "asdsd", 999};
        DataRecord record4 = new DataRecord(values2);
        return table.insertRecord(record4);
    }

    public void selectAllRecords(String name) {
        Table table = tableMap.get(name);
        for (var record : table.getRecords()) {
            System.out.println(record);
        }
    }

    public void filterAndDisplay(String name, String column, Object value) {
        Table table = tableMap.get(name);
        int idx = table.getIndexOfCol(column);
        if (idx == -1) {
            return;
        }
        for (var record : table.getRecords()) {
            if (record.getValues()[idx].equals(value)) {
                System.out.println(record);
            }
        }
    }
}
