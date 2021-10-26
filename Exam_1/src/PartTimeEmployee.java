
public class PartTimeEmployee extends AbstractEmployee{

    int hoursWoked;
    double hourlyRate;
    double transportAllowance;

    public PartTimeEmployee(String empId, String name, String dept, int hoursWoked, double hourlyRate, double transportAllowance) {
        super(empId, name, dept);
        this.hoursWoked = hoursWoked;
        this.hourlyRate = hourlyRate;
        this.transportAllowance = transportAllowance;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "hoursWoked=" + hoursWoked +
                ", hourlyRate=" + hourlyRate +
                ", transportAllowance=" + transportAllowance +
                '}';
    }

    @Override
    public double calculateSalary() {
        return  (hourlyRate*hoursWoked)+  transportAllowance;
    }



    public int getHoursWoked() {
        return hoursWoked;
    }

    public void setHoursWoked(int hoursWoked) {
        this.hoursWoked = hoursWoked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getTransportAllowance() {
        return transportAllowance;
    }

    public void setTransportAllowance(double transportAllowance) {
        this.transportAllowance = transportAllowance;
    }
}
