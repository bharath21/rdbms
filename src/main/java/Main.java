public class Main {
    public static void main(String[] args) {
        Database db1=new Database("employeeDB");
        db1.createTable("employees");
        db1.test_table("employees");
        db1.selectAllRecords("employees");
    }
}
