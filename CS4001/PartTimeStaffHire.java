// Class representing a part-time staff hire, inheriting from the StaffHire class
public class PartTimeStaffHire extends StaffHire
{
    // Instance variables specific to part-time staff
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    // Constructor for initializing all fields, including inherited and specific ones
    public PartTimeStaffHire(int vacancyNumber,
                             String designation, 
                             String jobType,
                             String staffName,
                             String joiningDate, 
                             String qualification, 
                             String appointedBy, 
                             boolean joined,
                             int workingHour, 
                             double wagesPerHour,
                             String shifts,
                             boolean terminated)
    {
        // Call to superclass constructor to initialize common staff details
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        
        // Initialize part-time-specific attributes
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;

        // Regardless of the value passed in, terminated is initially set to false
        this.terminated = false;  
    }

    // Accessor (getter) method for working hours
    public int getWorkingHour()
    {
        return this.workingHour;
    }

    // Accessor method for wages per hour
    public double getWagesPerHour() 
    {
        return this.wagesPerHour;
    }

    // Accessor method for shift type (e.g., morning/evening)
    public String getShifts()
    {
        return this.shifts;
    }

    // Accessor method to check if the staff has been terminated
    public boolean getTerminated() 
    {
        return this.terminated;
    }

    // Mutator (setter) method for working hours
    public void setWorkingHour(int workingHour)
    {
        this.workingHour = workingHour;
    }

    // Mutator method for wages per hour (note: parameter should ideally be double, not int)
    public void setWagesPerHour(int wagesPerHour)
    {
        this.wagesPerHour = wagesPerHour;
    }

    // Mutator method for updating shift type
    public void setShift(String newShifts)
    {
        this.shifts = newShifts;
    }

    // Method to handle staff termination process
    public void terminatedS()
    {
        if (terminated) {
            // Message shown if already terminated
            System.out.println("Staff is already terminated");
        } else {
            // Reset all key fields to represent termination
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setJoined(false);
            this.terminated = true;
        }
    }

    // Method to display part-time staff information (only if joined)
    public void displayPT()
    {
        if (isJoined()) {
            super.display(); // Display common staff info
            System.out.println("Working Hour: " + workingHour + "hours");
            System.out.println("Wages Per Hour: " + wagesPerHour + "$");
            System.out.println("Shifts: " + shifts);
            System.out.println("Terminated: " + terminated);
            System.out.println("******************************");
        }
    }
}
