/**
 * HW6 for 08671.
 * This is a class for the directory of students.
 * @author Hao Wang (haow2)
 */
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
* Directory class.
*/
public class Directory {
    /**
     * Instance variable, Key is andrewId, value is Student.
     */
    private Map<String, Student> mapId;
    /**
     * Instance variable, Key is firstName, value is a list of students.
     */
    private Map<String, List<Student>> mapFirstName;
    /**
     * Instance variable, Key is lastName, value is a list of students.
     */
    private Map<String, List<Student>> mapLastName;

    /**
     * Constructor of Directory.
     */
    public Directory() {
        mapId = new HashMap<String, Student>();
        mapFirstName = new HashMap<String, List<Student>>();
        mapLastName = new HashMap<String, List<Student>>();
    }

    /**
     * Add a student to the directory.
     * @param s the student needed to be added to the directory
     */
    public void addStudent(Student s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        String sAndrewId = s.getAndrewId();
        String sFirstName = s.getFirstName();
        String sLastName = s.getLastName();
        String sPhoneNumber = s.getPhoneNumber();

        Student ss = new Student(sAndrewId);
        ss.setFirstName(sFirstName);
        ss.setLastName(sLastName);
        ss.setPhoneNumber(sPhoneNumber);

        Student sSearchRes = searchByAndrewIdPrivate(sAndrewId);
        if (sSearchRes == null) {
            mapId.put(sAndrewId, ss);
        } else {
            throw new IllegalArgumentException();
        }

        if (sFirstName != null) {
            List<Student> listFirstName = searchByFirstNamePrivate(sFirstName);
            listFirstName.add(ss);
            mapFirstName.put(sFirstName, listFirstName);
        }

        if (sLastName != null) {
            List<Student> listLastName = searchByLastNamePrivate(sLastName);
            listLastName.add(ss);
            mapLastName.put(sLastName, listLastName);
        }
    }

    /**
     * Delete a student from the directory.
     * @param andrewId the student needed to be added to the directory
     */
    public void deleteStudent(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        }

        Student sSearchRes = searchByAndrewIdPrivate(andrewId);
        if (sSearchRes == null) {
            throw new IllegalArgumentException();
        }

        String sFirstName = sSearchRes.getFirstName();
        String sLastName = sSearchRes.getLastName();

        if (sFirstName != null) {
            List<Student> listFirstName = searchByFirstNamePrivate(sFirstName);
            for (int i = 0; i < listFirstName.size(); i++) {
                Student tempS = listFirstName.get(i);
                if (andrewId.equals(tempS.getAndrewId())) {
                    listFirstName.remove(tempS);
                }
            }
            mapFirstName.put(sFirstName, listFirstName);
        }

        if (sLastName != null) {
            List<Student> listLastName = searchByLastNamePrivate(sLastName);
            for (int i = 0; i < listLastName.size(); i++) {
                Student tempS = listLastName.get(i);
                if (andrewId.equals(tempS.getAndrewId())) {
                    listLastName.remove(tempS);
                }
            }
            mapLastName.put(sLastName, listLastName);
        }

        mapId.remove(andrewId);
    }

    /**
     * Search a student by andrewId.
     * @param andrewId the student id.
     * @return Student.
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        }
        return mapId.get(andrewId);
    }

    /**
     * Search a student by firstname.
     * @param firstName the firstname of student.
     * @return List of students.
     */
    public List<Student> searchByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException();
        }
        final List<Student> res;
        if (mapFirstName.containsKey(firstName)) {
            // System.out.println(mapFirstName.get(firstName));
            res = copyList(mapFirstName.get(firstName));
        } else {
            res = new ArrayList<Student>();
        }
        // System.out.println(res);
        return res;
    }

    /**
     * Search a student by lastname.
     * @param lastName the lastname of student.
     * @return List of students
     */
    public List<Student> searchByLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException();
        }
        final List<Student> res;
        if (mapLastName.containsKey(lastName)) {
            res = copyList(mapLastName.get(lastName));
        } else {
            res = new ArrayList<Student>();
        }
        return res;
    }

    /**
     * Get the number of students in the directory.
     * @return size of the directory.
     */
    public int size() {
        return mapId.size();
    }

    /**
     * Copy a list of students into a new list.
     * @param list1 the list needed to be copied.
     * @return the new list.
     */
    private List<Student> copyList(List<Student> list1) {
        List<Student> list2 = new ArrayList<Student>();
        for (int i = 0; i < list1.size(); i++) {
            Student s = list1.get(i);
            String sAndrewId = s.getAndrewId();
            String sFirstName = s.getFirstName();
            String sLastName = s.getLastName();
            String sPhoneNumber = s.getPhoneNumber();
            Student tempS = new Student(sAndrewId, sFirstName, sLastName, sPhoneNumber);
            list2.add(tempS);
        }
        return list2;
    }

    /**
     * Search a student by andrewId, usedInternally.
     * @param andrewId the student id,
     * @return Student.
     */
    private Student searchByAndrewIdPrivate(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        }
        return mapId.get(andrewId);
    }

    /**
     * Search a student by firstname, used internally.
     * @param firstName the firstname of student.
     * @return List of students.
     */
    private List<Student> searchByFirstNamePrivate(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException();
        }
        if (mapFirstName.containsKey(firstName)) {
            return mapFirstName.get(firstName);
        }
        return new ArrayList<Student>();
    }

    /**
     * Search a student by lastname, used internally.
     * @param lastName the lastname of student.
     * @return List of students.
     */
    private List<Student> searchByLastNamePrivate(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException();
        }
        if (mapLastName.containsKey(lastName)) {
            return mapLastName.get(lastName);
        }
        return new ArrayList<Student>();
    }
}
