
public class Employee implements  Cloneable
{
    String empId;
    String name;
    Office office;

    public Employee(String empId, String name, Office office) {
        this.empId = empId;
        this.name = name;
        this.office = office;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", office='" + office + '\'' +
                '}';

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee employee = (Employee) super.clone();
        employee.empId = (String) this.empId;
        employee.name = (String) this.name;
        employee.office = (Office) this.office;
        return employee;
    }
}
class Office implements  Cloneable
{
    String roomNo;
    String building;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Office office = (Office) super.clone();
        office.roomNo = (String) this.roomNo;
        office.building = (String) this.building;
        return office;
    }

    @Override
    public String toString() {
        return "Office{" +
                "roomNo='" + roomNo + '\'' +
                ", building='" + building + '\'' +
                '}';
    }

    public Office(String roomNo, String building) {

        this.roomNo = roomNo;
        this.building = building;
    }
}