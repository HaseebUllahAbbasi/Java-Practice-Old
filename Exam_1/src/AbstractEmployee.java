
public abstract class AbstractEmployee {

    private String empId;
    private String name;
    private String dept;

    public AbstractEmployee(String empId, String name, String dept) {
        this.empId = empId;
        this.name = name;
        this.dept = dept;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "AbstractEmployee{" + "empId=" + empId + ", name=" + name + ", dept=" + dept + '}';
    }

    public abstract double calculateSalary();

}
