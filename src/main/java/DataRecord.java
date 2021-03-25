import java.util.Arrays;

public class DataRecord {
    private final Object[] values;

    public DataRecord(Object[] values) {
        this.values = values;
    }

    public Object[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
