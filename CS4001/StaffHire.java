// Base class representing general staff hire information
public class StaffHire {

    // Common attributes for any staff hire
    private int vacancyNumber;
    private String designation;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    // Constructor to initialize the staff hire details
    public StaffHire(int NewVacancyNumber,
    String NewDesignation,
    String NewJobType,
    String newName, 
    String newJoinDate,
    String newQualification,
    String newAppointedBy,
    boolean joining) 
    { 
        this.vacancyNumber = NewVacancyNumber;     // Unique ID for the job vacancy
        this.designation = NewDesignation;         // Job title or role
        this.jobType = NewJobType;                 // Type of job (e.g., Part-time, Full-time)
        this.staffName = newName;                  // Name of the staff member
        this.joiningDate = newJoinDate;            // Date the staff member joins
        this.qualification = newQualification;     // Academic/professional qualification
        this.appointedBy = newAppointedBy;         // Name of the person who appointed the staff
        this.joined = false;                       // Default to false; set to true when staff is officially joined
    }

    // Getter method for vacancy number
    public int getVacancyNumber() {
        return this.vacancyNumber;
    }

    // Setter method for vacancy number
    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }

    // Getter method for designation
    public String getDesignation() {
        return this.designation;
    }

    // Setter method for designation
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Getter method for job type
    public String getJobType() {
        return this.jobType;
    }

    // Setter method for job type
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    // Getter method for staff name
    public String getStaffName() {
        return this.staffName;
    }

    // Setter method for staff name
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    // Getter method for joining date
    public String getJoiningDate() {
        return this.joiningDate;
    }

    // Setter method for joining date
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    // Getter method for qualification
    public String getQualification() {
        return this.qualification;
    }

    // Setter method for qualification
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    // Getter method for appointedBy
    public String getAppointedBy() {
        return this.appointedBy;
    }

    // Setter method for appointedBy
    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }

    // Method to check if the staff has joined
    public boolean isJoined() {
        return this.joined;
    }

    // Method to set the joined status
    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    // Method to display all the staff details
    public void display() {
        System.out.println("******************************");
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designation);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Qualification: " + qualification);
        System.out.println("Appointed By: " + appointedBy);
        System.out.println("Joined: " + joined);
    }
}
