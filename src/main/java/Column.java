import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Column {
    private String name;

    public List<Constraint> getConstraints() {
        return constraints;
    }

    private List<Constraint> constraints;
    public List<Integer> parameters;
    Type type;

    public Column(String name, List<Constraint> constraints, Type type,List<Integer> params) {
        this.name = name;
        this.constraints = constraints;
        this.type = type;
        this.parameters=params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return Objects.equals(name, column.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
