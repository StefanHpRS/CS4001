import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Frame;

public class RecruitmentSystem  implements ActionListener {
    //Fields for general information about the staff
    private JTextField vacancyNumberField, designationField, staffNameField, joiningDateField, 
    qualificationField, appointedByField;
    //Fields for fulltime staff
    private JTextField salaryField, weeklyFractionalHoursField;
    //Fields for parttime staff
    private JTextField wagesPerHourField,  shiftsField, workingHourField, terminatedField;
    // Button Panell Field
    private JTextField displayNumberField;
    //Buttons
    private JButton addFullTimeStaffButton, 
    addPartTimeStaffButton, 
    setSalaryButton, setShiftsButton, terminateButton, displayButton, clearButton;
    //ComboBox
    private JComboBox shiftsVariety, jobTypeComboBox;
    //CheckBox
    private JCheckBox joinedCheckBox;
    //
    private final ArrayList <StaffHire> staffList = new ArrayList<StaffHire>();
    //Frame 
    private JFrame frame, introFrame;
    // Text Area
    private JTextArea Output;

    public RecruitmentSystem() 
    {
        // Initialize the main frame with title
        frame = new JFrame("Staff Hiring System");
        Container contentPane = frame.getContentPane();

        // Use GridBagLayout for overall layout to allow flexible component placement
        contentPane.setLayout(new GridBagLayout());

        // Layout constraints with padding between components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30);

        // ------------------- Left Panel: General Staff Information -------------------
        JPanel leftPanel = new JPanel(new GridLayout(10, 10, 10, 10));
        leftPanel.setBorder(BorderFactory.createTitledBorder("General Staff Information"));

        // Input for vacancy number
        leftPanel.add(new JLabel("Vacancy Number:"));
        vacancyNumberField = new JTextField(15);
        vacancyNumberField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        leftPanel.add(vacancyNumberField);

        // Input for staff designation
        leftPanel.add(new JLabel("Designation:"));
        designationField = new JTextField(15);
        designationField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        leftPanel.add(designationField);

        leftPanel.add(new JLabel("Job Type:"));
        // Dropdown for selecting job type
        String[] jobTypeOptions = {"Internship", "Freelance", "Contract"};
        jobTypeComboBox = new JComboBox<>(jobTypeOptions);
        leftPanel.add(jobTypeComboBox); // ComboBoxes do not have the option to change the background

        // Input for staff name
        leftPanel.add(new JLabel("Staff Name:"));
        staffNameField = new JTextField(15);
        staffNameField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        leftPanel.add(staffNameField);

        // Input for joining date
        leftPanel.add(new JLabel("Joining Date:"));
        joiningDateField = new JTextField(15);
        joiningDateField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        leftPanel.add(joiningDateField);

        // Input for qualification
        leftPanel.add(new JLabel("Qualification:"));
        qualificationField = new JTextField(15);
        qualificationField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        leftPanel.add(qualificationField);

        // Input for who appointed the staff
        leftPanel.add(new JLabel("Appointed By:"));
        appointedByField = new JTextField(15);
        appointedByField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        leftPanel.add(appointedByField);

        // Checkbox to indicate if the staff has joined
        leftPanel.add(new JLabel("Joined"));
        joinedCheckBox = new JCheckBox();
        leftPanel.add(joinedCheckBox);

        // ------------------- Right Panel: Employment Details -------------------
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Employment Details"));

        GridBagConstraints gbd = new GridBagConstraints();
        gbd.insets = new Insets(5, 5, 5, 5);
        gbd.fill = GridBagConstraints.HORIZONTAL;

        // -------- Full-Time Employment Section --------
        JPanel fullTimePanel = new JPanel(new GridBagLayout());
        fullTimePanel.setBorder(BorderFactory.createTitledBorder("Full Time Employment Details"));

        // Weekly fractional hours input
        gbd.gridx = 0;
        gbd.gridy = 0;
        fullTimePanel.add(new JLabel("Weekly Fractional Hours:"), gbd);

        gbd.gridx = 1;
        weeklyFractionalHoursField = new JTextField(15);
        weeklyFractionalHoursField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        fullTimePanel.add(weeklyFractionalHoursField, gbd);

        // Salary input
        gbd.gridx = 0;
        gbd.gridy = 1;
        fullTimePanel.add(new JLabel("Salary:"), gbd);

        gbd.gridx = 1;
        salaryField = new JTextField(15);
        salaryField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        fullTimePanel.add(salaryField, gbd);

        // Button to set salary for full-time staff
        gbd.gridx = 2;
        setSalaryButton = new JButton("Set Salary");
        fullTimePanel.add(setSalaryButton, gbd);
        setSalaryButton.addActionListener(this);

        // Button to add a new full-time staff member
        gbd.gridx = 1;
        gbd.gridy = 3;
        addFullTimeStaffButton = new JButton("Add Full Time Staff");
        fullTimePanel.add(addFullTimeStaffButton, gbd);
        addFullTimeStaffButton.addActionListener(this);

        // -------- Part-Time Employment Section --------
        JPanel partTimePanel = new JPanel(new GridBagLayout());
        partTimePanel.setBorder(BorderFactory.createTitledBorder("Part Time Employment Details"));

        GridBagConstraints gbs = new GridBagConstraints();
        gbs.insets = new Insets(5, 5, 5, 5);
        gbs.fill = GridBagConstraints.HORIZONTAL;

        // Input for part-time working hours
        gbs.gridx = 0;
        gbs.gridy = 0;
        partTimePanel.add(new JLabel("Working Hour:"), gbs);

        gbs.gridx = 1;
        workingHourField = new JTextField(15);
        workingHourField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        partTimePanel.add(workingHourField, gbs);

        // Input for wage per hour
        gbs.gridx = 0;
        gbs.gridy = 1;
        partTimePanel.add(new JLabel("Wage Per Hour:"), gbs);

        gbs.gridx = 1;
        wagesPerHourField = new JTextField(15);
        wagesPerHourField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        partTimePanel.add(wagesPerHourField, gbs);

        // Dropdown to select shift times
        gbs.gridx = 0;
        gbs.gridy = 2;
        partTimePanel.add(new JLabel("Shifts:"), gbs);

        String[] shift = {"08:00-11:00", "08:00-14:00", "11:00-14:00", "11:00-17:00", "14:00-17:00"};
        shiftsVariety = new JComboBox<>(shift);
        gbs.gridx = 1;
        partTimePanel.add(shiftsVariety, gbs);

        // Button to set the selected shift
        gbs.gridx = 2;
        setShiftsButton = new JButton("Set Shift");
        partTimePanel.add(setShiftsButton, gbs);
        setShiftsButton.addActionListener(this);

        // Button to add new part-time staff
        gbs.gridx = 1;
        gbs.gridy = 3;
        addPartTimeStaffButton = new JButton("Add Part Time Staff");
        partTimePanel.add(addPartTimeStaffButton, gbs);
        addPartTimeStaffButton.addActionListener(this);

        // Input and button to terminate a part-time staff by vacancy number
        gbs.gridx = 0;
        gbs.gridy = 4;
        partTimePanel.add(new JLabel("Terminate Part Time Staff:"), gbs);

        gbs.gridx = 1;
        terminatedField = new JTextField(10);
        terminatedField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        partTimePanel.add(terminatedField, gbs);

        gbs.gridx = 2;
        terminateButton = new JButton("Terminate Part Time Staff");
        partTimePanel.add(terminateButton, gbs);
        terminateButton.addActionListener(this);

        // Add full-time and part-time panels to right panel structure
        gbd.gridx = 0;
        gbd.gridy = 0;
        gbd.gridwidth = 3;
        rightPanel.add(fullTimePanel, gbd);

        gbs.gridy = 1;
        gbs.gridwidth = 3;
        rightPanel.add(partTimePanel, gbs);

        // ------------------- Bottom Panel: Display and Clear Operations -------------------
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Display & Cleanup Operation"));
        GridBagConstraints gbm = new GridBagConstraints();
        gbm.insets = new Insets(5, 5, 5, 5);
        gbm.fill = GridBagConstraints.HORIZONTAL;

        // Input for entering vacancy number to display details
        gbm.gridx = 0;
        gbm.gridy = 0;
        buttonPanel.add(new JLabel("Display Staff:"), gbm);

        gbm.gridx = 1;
        displayNumberField = new JTextField(15);
        displayNumberField.setBackground(new Color(173, 216, 230)); //Set LightBlue background
        buttonPanel.add(displayNumberField);

        // Button to display staff info
        gbm.gridx = 2;
        displayButton = new JButton("Display Details");
        buttonPanel.add(displayButton, gbm);
        displayButton.addActionListener(this);

        // Button to clear input fields
        gbm.gridx = 1;
        gbm.gridy = 1;
        clearButton = new JButton("Clean Fields");
        buttonPanel.add(clearButton, gbm);
        clearButton.addActionListener(this);

        // ------------------- Bottom Panel: Output Display Area -------------------
        JPanel buttonPanel1 = new JPanel(new GridBagLayout());
        buttonPanel1.setBorder(BorderFactory.createTitledBorder("Display Window"));
        GridBagConstraints gbp = new GridBagConstraints();
        gbp.insets = new Insets(5, 5, 5, 5);
        gbp.fill = GridBagConstraints.BOTH;

        // Output area for displaying staff details
        Output = new JTextArea(10, 30);
        Output.setLineWrap(true);
        Output.setWrapStyleWord(true);
        Output.setEditable(false);

        // Add scrolling functionality for the respective windiw
        JScrollPane scrollPane = new JScrollPane(Output);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        buttonPanel1.add(scrollPane, gbm);

        // ------------------- Add All Panels to Main Frame -------------------
        // Add left top panel (general info)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        contentPane.add(leftPanel, gbc);
        // Add right top panel (employment details)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        contentPane.add(rightPanel, gbc);
        // Add display/cleanup button panel (bottom-left)
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(buttonPanel, gbc);
        // Add output panel (bottom-right)
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(buttonPanel1, gbc);

        // Finalize frame: pack, close operation, and show
        frame.pack(); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //This method manages all button click actions within the GUI
    @Override
    public void actionPerformed(ActionEvent event)
    {
        // Get the command string from the event (usually the button label)
        String command = event.getActionCommand();
        // If the "Set Salary" button is clicked, update the salary of a full-time staff
        if (command.equals("Set Salary")) { setSalary();}
        // If the "Add Full Time Staff" button is clicked, register a new full-time staff
        if (command.equals("Add Full Time Staff")) { addFullTimeStaff(); }
        // If the "Set Shift" button is clicked, update the shift for a part-time staff
        if (command.equals("Set Shift")) {setShift();}
        // If the "Add Part Time Staff" button is clicked, register a new part-time staff
        if (command.equals("Add Part Time Staff")) {addPartTimeStaff(); }
        // If the "Terminate Part Time Staff" button is clicked, remove the part-time staff
        if (command.equals("Terminate Part Time Staff")) {terminatePartTimeStaff(); }
        // If the "Display Details" button is clicked,the staff information will be displayed in the text area
        if (command.equals("Display Details")) {getDisplayNumber();}
        // If the "Clean Fields" button is clicked, all the fields are cleaned
        if (command.equals("Clean Fields")) {clearFields();}
    }

    public void setSalary() {
        // Retrieve input from text fields
        String vacancyInput = vacancyNumberField.getText().trim();
        String staffName = staffNameField.getText().trim();
        String newSalaryInput = salaryField.getText().trim();

        // Check if any required field is empty
        if (vacancyInput.isEmpty() || staffName.isEmpty() || newSalaryInput.isEmpty()) {
            JOptionPane.showMessageDialog(frame, 
                "Please enter a vacancy number, name, and salary.", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        int vacancy;
        double newSalary;
        // Validate that the vacancy number is an integer
        try {
            vacancy = Integer.parseInt(vacancyInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, 
                "Vacancy number must be a valid integer.", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validate that the salary is a proper numeric value
        try {
            newSalary = Double.parseDouble(newSalaryInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, 
                "Salary must be a valid number.", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean found = false;
        // Search for the staff member in the staffList
        for (StaffHire staff : staffList) {
            if (staff.getVacancyNumber() == vacancy && staff.getStaffName().equalsIgnoreCase(staffName)) {
                found = true;
                // Check if the staff is of FullTimeStaffHire type
                if (staff instanceof FullTimeStaffHire) {
                    FullTimeStaffHire fullTime = (FullTimeStaffHire) staff;
                    // Update salary
                    fullTime.setSalary(newSalary);
                    // Output confirmation in area of GUI
                    Output.append("------------------------------\n");
                    Output.append("Salary updated for Full-time Staff:\n");
                    Output.append("Vacancy Number: " + fullTime.getVacancyNumber() + "\n");
                    Output.append("Staff Name: " + fullTime.getStaffName() + "\n");
                    Output.append("New Salary: £" + fullTime.getSalary() + "\n");
                    Output.append("------------------------------\n");

                    System.out.print("------------------------------\n");
                    System.out.print("Salary updated for Full-time Staff:\n");
                    System.out.print("Vacancy Number: " + fullTime.getVacancyNumber() + "\n");
                    System.out.print("Staff Name: " + fullTime.getStaffName() + "\n");
                    System.out.print("New Salary: £" + fullTime.getSalary() + "\n");
                    System.out.print("------------------------------\n");

                    // Show confirmation dialog
                    JOptionPane.showMessageDialog(
                        frame,
                        "Salary updated to "+"£"+ newSalary +" for vacancy number " + vacancy + ".",
                        "Salary Updated",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Error message if the staff is not full-time
                    JOptionPane.showMessageDialog(frame, 
                        "The staff is not a full-time staff member. Cannot update salary.", 
                        "Update Error", 
                        JOptionPane.WARNING_MESSAGE);
                }
                return; // Exit after processing the matched staff
            }
        }

        // If no the staff member is not found at all
        if (!found) {
            JOptionPane.showMessageDialog(frame, 
                "Full-time staff with vacancy number '" + vacancyInput + 
                "' and name '" + staffName + "' not found.", 
                "Search Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addFullTimeStaff() {
        try {
            // Retrieve user input from GUI components
            String vacancyNumber = vacancyNumberField.getText().trim();  // Getting vacancy number input from the user (trimmed to remove extra spaces)
            String designation = designationField.getText().trim();  // Getting designation of the staff member (trimmed to remove spaces)
            String jobType = (String) jobTypeComboBox.getSelectedItem();  // Fetching selected job type from the combo box
            String staffName = staffNameField.getText().trim();  // Staff name input (trimmed to remove any leading/trailing spaces)
            String joiningDate = joiningDateField.getText().trim();  // Joining date input (to be validated and converted later)
            String qualification = qualificationField.getText().trim();  // Staff qualification input (trimmed)
            String appointedBy = appointedByField.getText().trim();  // Appointed by field (trimmed)
            boolean joined = joinedCheckBox.isSelected();  // Boolean for 'Joined' checkbox status (true if checked, false if unchecked)
            String weeklyFractionalHours = weeklyFractionalHoursField.getText().trim();  // Weekly fractional hours input (trimmed)
            String salary = salaryField.getText().trim();  // Salary input (trimmed)

            // Validate that all required fields are filled and the staff has joined
            if (vacancyNumber.isEmpty() || designation.isEmpty() || jobType.isEmpty() || 
            staffName.isEmpty() || joiningDate.isEmpty() || qualification.isEmpty() || 
            appointedBy.isEmpty() || weeklyFractionalHours.isEmpty() || salary.isEmpty() || !joined) {
                // If any of the required fields is empty or the 'joined' checkbox is unchecked, show an error message
                JOptionPane.showMessageDialog(frame, 
                    "Please fill in all fields for full-time staff and check the 'Joined' box.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;  // Return early as we cannot proceed with incomplete data
            }

            // Declaring variables to store the parsed values from the input strings
            int vacancyNum, workingHours;
            double salaryAmount;

            try {
                // Convert the string inputs to appropriate data types (integer for vacancy number and working hours, double for salary)
                vacancyNum = Integer.parseInt(vacancyNumber);  // Convert the vacancy number to an integer
                workingHours = Integer.parseInt(weeklyFractionalHours);  // Convert weekly fractional hours to an integer
                salaryAmount = Double.parseDouble(salary);  // Convert salary to a double

                // Ensure that all parsed values are positive (vacancy number, salary, and working hours can't be negative or zero)
                if (vacancyNum <= 0 || workingHours <= 0 || salaryAmount <= 0) {
                    JOptionPane.showMessageDialog(frame, 
                        "Vacancy number, salary, and working hours must be positive numbers.",
                        "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;  // Return early as invalid values were found
                }
            } catch (NumberFormatException e) {
                // Catch any errors that occur while parsing the numbers (e.g., if a non-numeric value is entered for salary or vacancy number)
                JOptionPane.showMessageDialog(frame, 
                    "Vacancy number, salary, and weekly hours must be valid numeric values.",
                    "Format Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further execution if parsing fails
            }

            // Check if the vacancy number already exists in the staff list
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNum) {
                    // If the vacancy number already exists, show a warning message
                    JOptionPane.showMessageDialog(frame, 
                        "A full-time staff member with vacancy number " + vacancyNum + " already exists.",
                        "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                    return;  // Return early as we cannot add a staff member with a duplicate vacancy number
                }
            }

            // Now that all inputs are validated, we can proceed with creating a new FullTimeStaffHire object
            FullTimeStaffHire fullTime = new FullTimeStaffHire(
                    vacancyNum, designation, jobType, staffName, 
                    joiningDate, qualification, appointedBy, joined, 
                    salaryAmount, workingHours);  // Creating a new FullTimeStaffHire object

            // Add the new full-time staff object to the staff list
            staffList.add(fullTime);  // Add the newly created staff member to the list

            // Output the details of the newly added full-time staff to the display area (this could be a text area or a console)
            Output.append("------------------------------\n");
            Output.append("Full-Time Staff Added:\n");
            Output.append("------------------------------\n");
            Output.append("Vacancy Number     : " + fullTime.getVacancyNumber() + "\n");
            Output.append("Designation        : " + fullTime.getDesignation() + "\n");
            Output.append("Job Type           : " + fullTime.getJobType() + "\n");
            Output.append("Staff Name         : " + fullTime.getStaffName() + "\n");
            Output.append("Joining Date       : " + fullTime.getJoiningDate() + "\n");
            Output.append("Qualification      : " + fullTime.getQualification() + "\n");
            Output.append("Appointed By       : " + fullTime.getAppointedBy() + "\n");
            Output.append("Salary: £" + fullTime.getSalary() + "\n");
            Output.append("Working Hours/week : " + fullTime.getWeeklyFractionalHours() + "\n\n");
            Output.append("------------------------------\n");

            System.out.print("------------------------------\n");
            System.out.print("Full-Time Staff Added:\n");
            System.out.print("------------------------------\n");
            System.out.print("Vacancy Number     : " + fullTime.getVacancyNumber() + "\n");
            System.out.print("Designation        : " + fullTime.getDesignation() + "\n");
            System.out.print("Job Type           : " + fullTime.getJobType() + "\n");
            System.out.print("Staff Name         : " + fullTime.getStaffName() + "\n");
            System.out.print("Joining Date       : " + fullTime.getJoiningDate() + "\n");
            System.out.print("Qualification      : " + fullTime.getQualification() + "\n");
            System.out.print("Appointed By       : " + fullTime.getAppointedBy() + "\n");
            System.out.print("Salary: £" + fullTime.getSalary() + "\n");
            System.out.print("Working Hours/week : " + fullTime.getWeeklyFractionalHours() + "\n\n");
            System.out.print("------------------------------\n");
            // Show a success confirmation dialog to the user
            JOptionPane.showMessageDialog(frame,  
                "Full-time staff added successfully:\n" +
                "- Vacancy Number: " + vacancyNum + "\n" +
                "- Name          : " + staffName,
                "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            // Catch any unexpected errors that occur during the execution of the method
            JOptionPane.showMessageDialog(frame, 
                "An unexpected error occurred while processing the input fields.\nDetails: " + e.getMessage(),
                "Runtime Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setShift() {
        // Get the input values from the respective text fields and comboboxes
        String vacancyInput = vacancyNumberField.getText().trim();  // Get the input for the vacancy number
        String staffName = staffNameField.getText().trim();  // Get the input for the staff name
        String newShift = (String) shiftsVariety.getSelectedItem();  // Get the selected shift from the combo box
        String newHoursInput = workingHourField.getText().trim();  // Get the input for new working hours

        // Validate if any of the required fields are empty or unselected
        if (vacancyInput.isEmpty() || staffName.isEmpty() || newShift == null || newHoursInput.isEmpty()) {
            // Show an error message if any of the required fields are missing
            JOptionPane.showMessageDialog(frame, "Please enter a vacancy number, name, shift, and working hours.",
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // Exit method if validation fails
        }

        int vacancy;
        int newHours;

        try {
            // Try to parse the vacancy number and working hours from string to integer
            vacancy = Integer.parseInt(vacancyInput);  // Convert vacancy number to integer
            newHours = Integer.parseInt(newHoursInput);  // Convert working hours to integer

            // Check if the working hours are a valid positive number
            if (newHours <= 0) {
                JOptionPane.showMessageDialog(frame, "Working hours must be a positive number.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;  // Exit method if the working hours are invalid
            }
        } catch (NumberFormatException e) {
            // Catch exception if vacancy or working hours cannot be parsed as integers
            JOptionPane.showMessageDialog(frame, "Vacancy number and working hours must be valid numbers.",
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // Exit method if there's a format error in the input
        }

        boolean found = false;  // Flag to track if matching staff is found

        // Iterate through the staff list to find the matching staff with the given vacancy number and name
        for (StaffHire staff : staffList) {
            // Check if the vacancy number and staff name match
            if (staff.getVacancyNumber() == vacancy && staff.getStaffName().equalsIgnoreCase(staffName)) {
                found = true;  // Set the found flag to true when a match is found

                // Check if the staff is part-time
                if (staff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire partStaff = (PartTimeStaffHire) staff;  // Cast staff to PartTimeStaffHire

                    String oldShift = partStaff.getShifts();  // Store the current shift for display
                    int oldHours = partStaff.getWorkingHour();  // Store the current working hours for display

                    // Update the staff's shift and working hours with the new input
                    partStaff.setShift(newShift);  // Set the new shift
                    partStaff.setWorkingHour(newHours);  // Set the new working hours

                    // Display the updated information in the output area
                    Output.append("------------------------------\n");
                    Output.append("Updated Part-time Staff Info:\n");
                    Output.append("Old Shift: " + oldShift + "\n");
                    Output.append("Old Hours: " + oldHours + " hours\n");
                    Output.append("Vacancy Number: " + partStaff.getVacancyNumber() + "\n");
                    Output.append("Staff Name: " + partStaff.getStaffName() + "\n");
                    Output.append("New Shift: " + partStaff.getShifts() + "\n");
                    Output.append("New Hours: " + partStaff.getWorkingHour() + " hours\n");
                    Output.append("------------------------------\n");

                    System.out.print("------------------------------\n");
                    System.out.print("Updated Part-time Staff Info:\n");
                    System.out.print("Old Shift: " + oldShift + "\n");
                    System.out.print("Old Hours: " + oldHours + " hours\n");
                    System.out.print("Vacancy Number: " + partStaff.getVacancyNumber() + "\n");
                    System.out.print("Staff Name: " + partStaff.getStaffName() + "\n");
                    System.out.print("New Shift: " + partStaff.getShifts() + "\n");
                    System.out.print("New Hours: " + partStaff.getWorkingHour() + " hours\n");
                    System.out.print("------------------------------\n");

                    // Show a message to the user indicating success
                    JOptionPane.showMessageDialog(frame, "Shift and working hours updated successfully.");
                } else {
                    // If the staff is not part-time, show an error message
                    JOptionPane.showMessageDialog(frame, "This staff member is not part-time.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
                return;  // Exit method after processing the matched staff
            }
        }

        // If no matching staff is found, show an error message
        if (!found) {
            JOptionPane.showMessageDialog(frame, "Part-time staff with vacancy number '" + vacancyInput +
                "' not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addPartTimeStaff() {
        try {
            // Getting the text from each input field and trimming the extra white spaces just to make sure
            String vacancyNumberStr = vacancyNumberField.getText().trim();  // Vacancy number input from the field, remove spaces
            String designation = designationField.getText().trim(); // The designation input field trimmed
            String jobType = (String) jobTypeComboBox.getSelectedItem(); // Getting the selected item from the jobType ComboBox
            String staffName = staffNameField.getText().trim();  // Getting the staff name input, trimmed
            String joiningDate = joiningDateField.getText().trim(); // Joining date as string (important for date validation later)
            String qualification = qualificationField.getText().trim();  // Qualification of the staff member
            String appointedBy = appointedByField.getText().trim();  // Appointed by field - who appointed the staff member
            String workingHoursStr = workingHourField.getText().trim(); // Hours worked per week (String to be converted to int)
            String wagesPerHourStr = wagesPerHourField.getText().trim(); // Wages per hour input field (String to double)
            String shifts = (String) shiftsVariety.getSelectedItem(); // Shifts selected from combo box
            boolean joined = joinedCheckBox.isSelected();  // Boolean that checks if the "joined" checkbox is ticked

            // Now, I need to validate that all fields have been filled and the checkbox is checked
            if (vacancyNumberStr.isEmpty() || designation.isEmpty() || jobType.isEmpty() || staffName.isEmpty()
            || joiningDate.isEmpty() || qualification.isEmpty() || appointedBy.isEmpty()
            || workingHoursStr.isEmpty() || wagesPerHourStr.isEmpty() || shifts.isEmpty() || !joined) {

                // If even one of the fields is empty or checkbox is not ticked, show a message to the user
                JOptionPane.showMessageDialog(frame, 
                    "Please fill all fields for the part-time staff and check the 'Joined' box.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // No need to continue if validation failed
            }

            // Declaring variables to store the parsed integer values from string inputs
            int vacancyNum, workingH;
            double wagesPH;

            try {
                // Parsing string values into integers and double to perform calculations and validations
                vacancyNum = Integer.parseInt(vacancyNumberStr);  // Convert vacancy number to integer
                workingH = Integer.parseInt(workingHoursStr);  // Convert working hours to integer
                wagesPH = Double.parseDouble(wagesPerHourStr);  // Convert wages per hour to double

                // Check that all parsed values are positive, because vacancy number, working hours, and wages can't be zero or negative
                if (vacancyNum <= 0 || workingH <= 0 || wagesPH <= 0) {
                    JOptionPane.showMessageDialog(frame, 
                        "Vacancy number, wages per hour, and working hours must be positive numbers.","Input Error"
                    , JOptionPane.ERROR_MESSAGE);
                    return; // Stop further processing if invalid values are found
                }
            } catch (NumberFormatException e) {
                // This block will handle any errors when parsing the number fields
                JOptionPane.showMessageDialog(frame, 
                    "Vacancy number, wages per hour, and working hours need to be valid numbers.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop the execution if number parsing fails
            }
            // Check if the vacancy number already exists in the staff list
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNum) {
                    // Show a message if the vacancy number already exists in the system
                    JOptionPane.showMessageDialog(frame, "Staff with vacancy number:" + " " + vacancyNum +" " + " already exists.",
                        "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                    return;  // Stop further processing if a duplicate vacancy number is found
                }
            }
            // Now, the input has been validated and parsed, so we can proceed with the actual logic.
            // Create a new PartTimeStaffHire object with the validated fields
            PartTimeStaffHire partTime = new PartTimeStaffHire(vacancyNum,designation, 
                    jobType,staffName,joiningDate, qualification,appointedBy, 
                    joined, workingH, wagesPH,shifts,false);

            // Setting the additional information (joiningDate, qualification, appointedBy) using setters
            partTime.setJoiningDate(joiningDate);  // Assigning the joining date
            partTime.setQualification(qualification);  // Assigning the qualification
            partTime.setAppointedBy(appointedBy);  // Assigning who appointed the staff member

            // Adding the newly created staff member to the staff list (which holds all staff objects)
            staffList.add(partTime);

            // Display the details of the newly added part-time staff in the output panel
            Output.append("------------------------------\n");
            Output.append("Part-Time Staff Added:\n");
            Output.append("------------------------------\n");
            Output.append("Vacancy Number: " + partTime.getVacancyNumber() + "\n");  // Showing the vacancy number
            Output.append("Designation: " + partTime.getDesignation() + "\n");  // Showing the designation
            Output.append("Job Type: " + partTime.getJobType() + "\n");  // Showing the job type (full-time/part-time)
            Output.append("Staff Name: " + staffName + "\n");  // Showing the staff member's name
            Output.append("Joining Date: " + partTime.getJoiningDate() + "\n");  // Showing the joining date
            Output.append("Qualification: " + partTime.getQualification() + "\n");  // Showing the qualification
            Output.append("Appointed By: " + partTime.getAppointedBy() + "\n");  // Showing who appointed them
            Output.append("Wages Per Hour: £" + partTime.getWagesPerHour() + "\n");  // Showing the wages per hour
            Output.append("Working Hours: " + partTime.getWorkingHour() + " hours\n");  // Showing working hours per week
            Output.append("Shift: " + partTime.getShifts() + "\n\n");  // Showing the shift assigned
            Output.append("------------------------------\n");

            System.out.print("------------------------------\n");
            System.out.print("Part-Time Staff Added:\n");
            System.out.print("------------------------------\n");
            System.out.print("Vacancy Number: " + partTime.getVacancyNumber() + "\n");  // Showing the vacancy number
            System.out.print("Designation: " + partTime.getDesignation() + "\n");  // Showing the designation
            System.out.print("Job Type: " + partTime.getJobType() + "\n");  // Showing the job type (full-time/part-time)
            System.out.print("Staff Name: " + staffName + "\n");  // Showing the staff member's name
            System.out.print("Joining Date: " + partTime.getJoiningDate() + "\n");  // Showing the joining date
            System.out.print("Qualification: " + partTime.getQualification() + "\n");  // Showing the qualification
            System.out.print("Appointed By: " + partTime.getAppointedBy() + "\n");  // Showing who appointed them
            System.out.print("Wages Per Hour: £" + partTime.getWagesPerHour() + "\n");  // Showing the wages per hour
            System.out.print("Working Hours: " + partTime.getWorkingHour() + " hours\n");  // Showing working hours per week
            System.out.print("Shift: " + partTime.getShifts() + "\n\n");  // Showing the shift assigned
            System.out.print("------------------------------\n");

            // Notify the user via a success message once the part-time staff has been successfully added
            JOptionPane.showMessageDialog(frame,  
                "Part-time staff added successfully:\n" +
                "- Vacancy Number: " + vacancyNum + "\n" +
                "- Name          : " + staffName,
                "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            // Catch any unexpected errors and provide feedback to the user
            JOptionPane.showMessageDialog(frame, 
                "An unexpected error occurred while processing the input fields.\nDetails: " + e.getMessage(),
                "Runtime Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void terminatePartTimeStaff() {
        // Get the text input from the field where the user enters the vacancy number, and remove any surrounding spaces
        String vacancyText = terminatedField.getText().trim(); 

        // If the field is empty, show an error message and exit the method
        if (vacancyText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a vacancy number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Convert the input into an integer
            int vacancyNumber = Integer.parseInt(vacancyText);
            boolean found = false; // This will track whether we found a matching part-time staff

            // Go through every staff member in the list
            for (int i = 0; i < staffList.size(); i++) {
                StaffHire staff = staffList.get(i);

                // We only want to process part-time staff, so skip any full-time staff
                if (staff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire partTime = (PartTimeStaffHire) staff;

                    // If the vacancy number matches the one provided
                    if (partTime.getVacancyNumber() == vacancyNumber) {
                        // Check if the staff is not already marked as terminated
                        if (!partTime.getTerminated()) {
                            // Terminate the staff by updating internal state
                            partTime.terminatedS();
                            // Remove this staff member from the main list so they're no longer tracked
                            staffList.remove(i);
                            // Get the current text shown in the output display
                            String outputText = Output.getText();
                            // Try to locate the section of the output corresponding to this staff member
                            String blockStart = "Part-time staff added:\nVacancy Number: " + vacancyNumber;
                            int startIndex = outputText.indexOf(blockStart);
                            // If we found their section, figure out where it ends
                            if (startIndex != -1) {
                                int endIndex = outputText.indexOf("Part-time staff added:", startIndex + 1);
                                // If there's no next staff block, just take the text to the end
                                if (endIndex == -1) {
                                    endIndex = outputText.length();
                                }
                                // Remove the block of text that belongs to this staff
                                String toRemove = outputText.substring(startIndex, endIndex);
                                Output.setText(outputText.replace(toRemove, ""));
                            }
                            // Inform the user that the staff has been successfully terminated
                            JOptionPane.showMessageDialog(frame, "Part-time staff terminated and removed.");
                            // Clear the input field after the process is done
                            terminatedField.setText(""); 
                            // Clear the text area after the process is done
                            Output.setText(""); 
                            System.out.println("");
                        } else {
                            // If the staff was already terminated earlier, show a notice
                            JOptionPane.showMessageDialog(frame, "Staff already terminated.", "Notice",
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                        found = true; // Mark that we found the correct staff
                        break; // No need to keep looking in the list 
                    }
                }
            }
            // If we went through the list and found no matching staff, show a warning
            if (!found) {
                JOptionPane.showMessageDialog(frame, "No part-time staff with that vacancy number"+" "+ vacancyNumber,
                    "Not Found", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            // If the vacancy number was not a valid integer, show an error message
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for the vacancy.", 
                "Error", JOptionPane.ERROR_MESSAGE);
            // Clear the input field after the process is done
            terminatedField.setText(""); 
        }
    }

    public void getDisplayNumber() {
        // Get the user input from the display field and trim extra spaces
        String input = displayNumberField.getText().trim();

        // Check if the input field is empty
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a vacancy number.",
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop further execution if input is empty
        }

        int vacancyNumber;
        try {
            // Try to convert the input into an integer
            vacancyNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // If input is not a valid number, show an error message
            JOptionPane.showMessageDialog(frame, "Vacancy number must be a valid number.",
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean found = false; // Flag to track if matching staff is found
        // Loop through the staff list to find a match by vacancy number
        for (StaffHire staff : staffList) {
            if (staff.getVacancyNumber() == vacancyNumber) {
                found = true; // Staff found

                // If the staff is full-time, display relevant details
                if (staff instanceof FullTimeStaffHire) {
                    FullTimeStaffHire ft = (FullTimeStaffHire) staff;
                    Output.append("------------------------------\n");
                    Output.append("Full-time Staff Details:\n");
                    Output.append("Vacancy Number: " + ft.getVacancyNumber() + "\n");
                    Output.append("Designation: " + ft.getDesignation() + "\n");
                    Output.append("Job Type: " + ft.getJobType() + "\n");
                    Output.append("Staff Name: " + ft.getStaffName() + "\n");
                    Output.append("Joining Date: " + ft.getJoiningDate() + "\n");
                    Output.append("Qualification: " + ft.getQualification() + "\n");
                    Output.append("Appointed By: " + ft.getAppointedBy() + "\n");
                    Output.append("Weekly Fractional Hours:" + ft.getWeeklyFractionalHours() + " hours\n\n");
                    Output.append("Salary: £" + ft.getSalary() + "\n");
                    Output.append("------------------------------\n");

                    System.out.print("------------------------------\n");
                    System.out.print("Full-time Staff Details:\n");
                    System.out.print("Vacancy Number: " + ft.getVacancyNumber() + "\n");
                    System.out.print("Designation: " + ft.getDesignation() + "\n");
                    System.out.print("Job Type: " + ft.getJobType() + "\n");
                    System.out.print("Staff Name: " + ft.getStaffName() + "\n");
                    System.out.print("Joining Date: " + ft.getJoiningDate() + "\n");
                    System.out.print("Qualification: " + ft.getQualification() + "\n");
                    System.out.print("Appointed By: " + ft.getAppointedBy() + "\n");
                    System.out.print("Weekly Fractional Hours:" + ft.getWeeklyFractionalHours() + " hours\n\n");
                    System.out.print("Salary: £" + ft.getSalary() + "\n");
                    System.out.print("------------------------------\n");

                    // Show a message that Full-time staff details are displayed
                    JOptionPane.showMessageDialog(frame, "Full-time staff details displayed for Vacancy Number: " + vacancyNumber);
                    break;  // Stop after finding and displaying the full-time staff
                }

                // If the staff is part-time, display additional info
                else if (staff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire pt = (PartTimeStaffHire) staff;
                    Output.append("------------------------------\n");
                    Output.append("Part-time Staff Details:\n");
                    Output.append("Vacancy Number: " + pt.getVacancyNumber() + "\n");
                    Output.append("Designation: " + pt.getDesignation() + "\n");
                    Output.append("Job Type: " + pt.getJobType() + "\n");
                    Output.append("Staff Name: " + pt.getStaffName() + "\n");
                    Output.append("Joining Date: " + pt.getJoiningDate() + "\n");
                    Output.append("Qualification: " + pt.getQualification() + "\n");
                    Output.append("Appointed By: " + pt.getAppointedBy() + "\n");
                    Output.append("Wages Per Hour: £" + pt.getWagesPerHour() + "\n");
                    Output.append("Working Hours: " + pt.getWorkingHour() + "\n");
                    Output.append("Shift: " + pt.getShifts() + "\n");
                    Output.append("------------------------------\n");

                    System.out.print("------------------------------\n");
                    System.out.print("Part-time Staff Details:\n");
                    System.out.print("Vacancy Number: " + pt.getVacancyNumber() + "\n");
                    System.out.print("Designation: " + pt.getDesignation() + "\n");
                    System.out.print("Job Type: " + pt.getJobType() + "\n");
                    System.out.print("Staff Name: " + pt.getStaffName() + "\n");
                    System.out.print("Joining Date: " + pt.getJoiningDate() + "\n");
                    System.out.print("Qualification: " + pt.getQualification() + "\n");
                    System.out.print("Appointed By: " + pt.getAppointedBy() + "\n");
                    System.out.print("Wages Per Hour: £" + pt.getWagesPerHour() + "\n");
                    System.out.print("Working Hours: " + pt.getWorkingHour() + "\n");
                    System.out.print("Shift: " + pt.getShifts() + "\n");
                    System.out.print("------------------------------\n");

                    // Show a message that Part-time staff details are displayed
                    JOptionPane.showMessageDialog(frame, "Part-time staff details displayed for Vacancy Number: " + vacancyNumber);
                    break;  // Stop after finding and displaying the part-time staff
                }
            }
        }

        // If no matching staff is found, show an error message
        if (!found) {
            JOptionPane.showMessageDialog(frame, "No staff found with Vacancy Number: " + vacancyNumber,
                "Staff Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() 
    {
        try {
            // Clear text fields related to staff input
            vacancyNumberField.setText("");        // Clear the vacancy number input
            designationField.setText("");          // Clear the designation input
            staffNameField.setText("");            // Clear the staff name input
            joiningDateField.setText("");          // Clear the joining date input
            qualificationField.setText("");        // Clear the qualification input
            appointedByField.setText("");          // Clear the appointed by input
            // Reset job type combo box selection if items are present
            if (jobTypeComboBox.getItemCount() > 0) {
                jobTypeComboBox.setSelectedIndex(-1);  // Deselect any selected job type
            }
            // Clear numeric or wage-related fields
            salaryField.setText("");                  // Clear the salary input (likely for full-time)
            weeklyFractionalHoursField.setText("");   // Clear the weekly fractional hours input
            workingHourField.setText("");             // Clear the working hours input
            wagesPerHourField.setText("");            // Clear the wages per hour input

            // Reset shift selection if available
            if (shiftsVariety.getItemCount() > 0) {
                shiftsVariety.setSelectedIndex(-1);   // Deselect any selected shift
            }
            // Clear the field used to terminate staff by vacancy number
            terminatedField.setText("");
            // Uncheck the 'Joined' checkbox
            joinedCheckBox.setSelected(false);
            // Clear the display field used to search or filter by vacancy number
            displayNumberField.setText("");
        } catch (Exception e) {
            // If any error occurs during clearing, print it and show an error dialog
            System.err.println("An error occurred while clearing fields: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Failed to clear form fields. Please try again.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) 
    {
        new RecruitmentSystem();
    }
}
