/**
 * HW5 for 08671.
 * This is a class to store the information of students.
 * @author Hao Wang (haow2)
 */

/**
* Student class.
*/
public class Student {
    /**
     * Instance variable for andrewId.
     */
    private String andrewId;
    /**
     * Instance variable for firstName.
     */
    private String firstName;
    /**
     * Instance variable for lastName.
     */
    private String lastName;
    /**
     * Instance variable for phoneNumber.
     */
    private String phoneNumber;

    /**
     * Constructor of Student with andrewId.
     * @param newAndrewId the new student id.
     */
    public Student(String newAndrewId) {
        andrewId = newAndrewId;
    }

    /**
     * Constructor of Student with andrewId, firstname, lastname, phonenumber.
     * @param newAndrewId the new student id.
     * @param newFirstName the new first name of the student.
     * @param newLastName the new last name of the student.
     * @param newPhoneNumber the phone number of the student.
     */
    public Student(String newAndrewId, String newFirstName, String newLastName, String newPhoneNumber) {
        andrewId = newAndrewId;
        if (newFirstName != null) {
            firstName = newFirstName;
        }
        if (newLastName != null) {
            lastName = newLastName;
        }
        if (newPhoneNumber != null) {
            phoneNumber = newPhoneNumber;
        }
    }

    /**
     * Returns the andrewId.
     * @return andrewId the student id.
     */
    public String getAndrewId() {
        return andrewId;
    }

    /**
     * Returns the first name.
     * @return firstname the student's firstname.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name.
     * @return lastName the student's lastname.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the phone number.
     * @return phoneNumber the phonenumber of the student.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setup the student's firstname.
     * @param s set the student's first name.
     */
    public void setFirstName(String s) {
        firstName = s;
    }

    /**
     * Setup the student's lastname.
     * @param s set the student's last name.
     */
    public void setLastName(String s) {
        lastName = s;
    }

    /**
     * Setup the student's phone number.
     * @param s set the student's phone number.
     */
    public void setPhoneNumber(String s) {
        phoneNumber = s;
    }

    /**
     * Returns the data of student in string.
     * @return String of student data.
     */
    public String toString() {
        String sAndrewId = getAndrewId();
        String sFirstName = getFirstName();
        String sLastName = getLastName();
        String sPhoneNumber = getPhoneNumber();

        if (sFirstName == null || sFirstName.length() == 0) {
            sFirstName = "";
        }
        if (sLastName == null || sLastName.length() == 0) {
            sLastName = "";
        }
        if (sPhoneNumber == null || sPhoneNumber.length() == 0) {
            sPhoneNumber = "";
        }

        String res = "";
        res += sFirstName + " " + sLastName + " (Andrew ID: " + sAndrewId;
        res += ", Phone Number: " + sPhoneNumber + ")";
        return res;
    }
}
