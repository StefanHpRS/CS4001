// Class representing a full-time staff hire, which extends the StaffHire class
public class FullTimeStaffHire extends StaffHire 
{
    // Fields specific to full-time staff
    private double salary;
    private int weeklyFractionalHours;

    // Constructor for initializing both inherited and full-time-specific fields
    public FullTimeStaffHire(
    int vacancyNumber,
    String designation, 
    String jobType,
    String staffName,
    String joiningDate, 
    String qualification, 
    String appointedBy, 
    boolean joined,
    double salary, 
    int weeklyFractionalHours) 
    {
        // Call to the superclass constructor to initialize common staff attributes
        super(vacancyNumber,
            designation,
            jobType, 
            staffName, 
            joiningDate, 
            qualification, 
            appointedBy, 
            joined);

        // Initialize full-time-specific attributes
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Getter method for salary
    public double getSalary() {
        return this.salary;
    }

    // Setter method to update the salary
    public void setSalary(double newSalary) 
    { 
        this.salary = newSalary;
    }

    // Getter method for weekly fractional hours
    public int getWeeklyFractionalHours() 
    {
        return this.weeklyFractionalHours;
    }

    // Setter method to update weekly fractional hours
    public void setWeeklyFractionalHours(int weeklyFractionalHours)
    {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Method to display full-time staff details (only if the staff has joined)
    public void displayFT() 
    { 
        if (isJoined()) // Check if the staff is marked as joined
        {
            super.display(); // Display common staff information from the superclass
            System.out.println("Salary: " + salary +"$"); // Display the salary
            System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours); // Display weekly hours
            System.out.println("******************************"); // Separator line
        }
    }
}
