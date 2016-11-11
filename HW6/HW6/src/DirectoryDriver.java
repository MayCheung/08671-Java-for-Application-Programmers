/**
 * HW6 for 08671.
 * This is a class to store the information of students.
 * @author Hao Wang (haow2)
 */
//import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
* Directory Driver class.
*/
public class DirectoryDriver {
    /**
     * Instance variable, Button to add a student.
     */
    private JButton addStudentButton;
    /**
     * Instance variable, Button to delete a student.
     */
    private JButton deleteStudentButton;
    /**
     * Instance variable, Button to search by Andrew Id.
     */
    private JButton searchByAndrewIdButton;
    /**
     * Instance variable, Button to search by first name.
     */
    private JButton searchByFirstNameButton;
    /**
     * Instance variable, Button to search by last name.
     */
    private JButton searchByLastNameButton;
    /**
     * Instance variable, text area for results.
     */
    private JTextArea textArea;
    /**
     * Instance variable, text area for adding first name.
     */
    private JTextArea firstNameAddArea;
    /**
     * Instance variable, text area for adding last name.
     */
    private JTextArea lastNameAddArea;
    /**
     * Instance variable, text area for adding Andrew Id.
     */
    private JTextArea andrewIdAddArea;
    /**
     * Instance variable, text area for adding phone number.
     */
    private JTextArea phoneNumberAddArea;
    /**
     * Instance variable, text area for deleting student.
     */
    private JTextArea andrewIdDeleteArea;
    /**
     * Instance variable, text area for searching the result.
     */
    private JTextArea searchKeyArea;
    /**
     * Instance variable, Directory for all students.
     */
    private Directory directory = new Directory();

    /**
     * The GUI of the app.
     */
    private void quoteGUIAction() {
        JFrame frame = new JFrame("Swing for Student Directory");
        frame.setSize(940, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Default, focus on searchKeyArea
        frame.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                searchKeyArea.requestFocus();
            }
        });

//        Font font = new Font(Font.SERIF, Font.BOLD, 10);
        JPanel pane = new JPanel();
        JPanel pane1 = new JPanel();
        JPanel pane2 = new JPanel();
        JPanel pane3 = new JPanel();
        JPanel pane4 = new JPanel();

        // Add panes to pane
        pane.add(pane1);
        pane.add(pane2);
        pane.add(pane3);
        pane.add(pane4);

// Set layout
        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
        pane1.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane2.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane3.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane4.setLayout(new FlowLayout(FlowLayout.LEFT));

// Set border
        pane1.setBorder(BorderFactory.createTitledBorder("Add a new student"));
        pane2.setBorder(BorderFactory.createTitledBorder("Delete student"));
        pane3.setBorder(BorderFactory.createTitledBorder("Search student(s)"));
        pane4.setBorder(BorderFactory.createTitledBorder("Results"));

// Generate First Row
// First Name
        JLabel label = new JLabel("First Name: ");
//        label.setFont(font);
        firstNameAddArea = new JTextArea(1, 10);
        pane1.add(label);
        pane1.add(firstNameAddArea);

// Last Name
        label = new JLabel("Last Name: ");
//        label.setFont(font);
        lastNameAddArea = new JTextArea(1, 10);
        pane1.add(label);
        pane1.add(lastNameAddArea);

// Andrew Id
        label = new JLabel("Andrew ID: ");
//        label.setFont(font);
        andrewIdAddArea = new JTextArea(1, 10);
        pane1.add(label);
        pane1.add(andrewIdAddArea);

// Phone Number
        label = new JLabel("Phone Number: ");
//        label.setFont(font);
        phoneNumberAddArea = new JTextArea(1, 10);
        pane1.add(label);
        pane1.add(phoneNumberAddArea);

// Add student button
        addStudentButton = new JButton("Add");
        pane1.add(addStudentButton);

// Generate Second Row
// Andrew Id
        label = new JLabel("Andrew ID: ");
        andrewIdDeleteArea = new JTextArea(1, 10);
        pane2.add(label);
        pane2.add(andrewIdDeleteArea);

        deleteStudentButton = new JButton("Delete");
        pane2.add(deleteStudentButton);

// Generate Third Row
// Search Key
        label = new JLabel("Search key: ");
//        label.setFont(font);
        searchKeyArea = new JTextArea(1, 10);
        pane3.add(label);
        pane3.add(searchKeyArea);

        searchByAndrewIdButton = new JButton("By Andrew ID");
        pane3.add(searchByAndrewIdButton);

        searchByFirstNameButton = new JButton("By First Name");
        pane3.add(searchByFirstNameButton);

        searchByLastNameButton = new JButton("By Last Name");
        pane3.add(searchByLastNameButton);

// Results Line
        textArea = new JTextArea(30, 76);
        textArea.setText("");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scroller = new JScrollPane(textArea);
        pane4.add(scroller);

// Listen to all buttons and the key for searchByAndrewId
        addStudentButton.addActionListener(new AddActionListener());
        deleteStudentButton.addActionListener(new DeleteActionListener());
        searchByAndrewIdButton.addActionListener(new SearchByAndrewIdActionListener());
        searchByFirstNameButton.addActionListener(new SearchByFirstNameActionListener());
        searchByLastNameButton.addActionListener(new SearchByLastNameActionListener());
        searchKeyArea.addKeyListener(new SearchKeyListener());

// Show the pane
        frame.setContentPane(pane);
        frame.setVisible(true);
    }

    /**
     * Load the data from CSV.
     * @param fileName the path to the input file.
     * @throws IOException throws IOException.
     */
    private void loadData(String fileName) throws IOException {
        File inFile = new File(fileName);

// If file doesnt exists, then create it
        if (!inFile.exists()) {
            System.err.println("No file called: " + fileName);
            System.exit(-1);
        }

        BufferedReader br = null;

// Read string from the input file
        String currLine;

        br = new BufferedReader(new FileReader(inFile));

// Throw the first line to ignore the name of attributes
        br.readLine();

        while ((currLine = br.readLine()) != null) {
            String[] attributes = currLine.split(",");
            if (attributes.length != 4) {
// Illegal line
                continue;
            }
            String tempFirstName = attributes[0];
            String tempLastName = attributes[1];
            String tempAndrewId = attributes[2];
            String tempPhoneNumber = attributes[3];

            Student tempStudent = new Student(tempAndrewId, tempFirstName, tempLastName, tempPhoneNumber);
            directory.addStudent(tempStudent);
        }
    }

    /**
     * Class for searchKeyListener.
     */
    private class SearchKeyListener implements KeyListener {
        /**
         * Listen to the typed key.
         * @param e key event.
         */
        public void keyTyped(KeyEvent e) {
        }

        /**
         * Listen to the pressed key.
         * @param e key event.
         */
        public void keyPressed(KeyEvent e) {
// If focus not in this area
            if (e.getSource() != searchKeyArea) {
                return;
            }

// If pressed Enter
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                System.out.println("Former: " + searchKeyArea.getText() + "!");
                String keyAndrewId = searchKeyArea.getText().trim();
                searchKeyArea.setText(keyAndrewId);
//                System.out.println("Latter: " + searchKeyArea.getText() + "!");

// Check errors
                if (keyAndrewId == null || keyAndrewId.length() == 0) {
                    textArea.append("Search key (Andrew ID) Missing\n");
                    return;
                }

                Student tempStudent = directory.searchByAndrewId(keyAndrewId);
                if (tempStudent == null) {
                    textArea.append("No matches for search key (Andew ID): " + keyAndrewId + "\n");
                    return;
                }
                searchKeyArea.setText(null);
                textArea.append("The entry was found by search key (Andrew ID): " + tempStudent + "\n");
            }
        }

        /**
         * Listen to the released key.
         * @param e key event.
         */
        public void keyReleased(KeyEvent e) {
            if (e.getSource() != searchKeyArea) {
                return;
            }

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                System.out.println("Former: " + searchKeyArea.getText() + "!");
                String keyAndrewId = searchKeyArea.getText().trim();
                searchKeyArea.setText(keyAndrewId);
//                System.out.println("Latter: " + searchKeyArea.getText() + "!");
            }
        }
    }

    /**
     * Class for addActionListener.
     */
    private class AddActionListener implements ActionListener {
        /**
         * Listen to the performed action.
         * @param event action event.
         */
        public void actionPerformed(ActionEvent event) {
//            area.append("Now begin to add a student\n");
            String tempFirstName = firstNameAddArea.getText().trim();
            String tempLastName = lastNameAddArea.getText().trim();
            String tempAndrewId = andrewIdAddArea.getText().trim();
            String tempPhoneNumber = phoneNumberAddArea.getText().trim();

            firstNameAddArea.setText(tempFirstName);
            lastNameAddArea.setText(tempLastName);
            andrewIdAddArea.setText(tempAndrewId);
            if (tempPhoneNumber == null) {
                tempPhoneNumber = "";
            }
            phoneNumberAddArea.setText(tempPhoneNumber);

// Check errors
            if (tempFirstName == null || tempFirstName.length() == 0) {
                textArea.append("First Name Missing\n");
                return;
            }
            if (tempLastName == null || tempLastName.length() == 0) {
                textArea.append("Last Name Missing\n");
                return;
            }
            if (tempAndrewId == null || tempAndrewId.length() == 0) {
                textArea.append("Andrew ID Missing\n");
                return;
            }
            if (directory.searchByAndrewId(tempAndrewId) != null) {
                textArea.append("Data already contains an entry for this Andrew ID\n");
                return;
            }

            firstNameAddArea.setText(null);
            lastNameAddArea.setText(null);
            andrewIdAddArea.setText(null);
            phoneNumberAddArea.setText(null);

// Create student
            Student tempStudent = new Student(tempAndrewId, tempFirstName, tempLastName, tempPhoneNumber);
            directory.addStudent(tempStudent);

            textArea.append("A new entry was added: " + tempStudent + "\n");
        }
    }

    /**
     * Class for deleteActionListener.
     */
    private class DeleteActionListener implements ActionListener {
        /**
         * Listen to the performed action.
         * @param event action event.
         */
        public void actionPerformed(ActionEvent event) {
//            area.append("Now begin to delete a student\n");
            String tempAndrewId = andrewIdDeleteArea.getText();
            andrewIdDeleteArea.setText(tempAndrewId.trim());

// Check errors
            if (tempAndrewId == null || tempAndrewId.length() == 0) {
                textArea.append("Andrew ID Missing\n");
                return;
            }
            Student tempStudent = directory.searchByAndrewId(tempAndrewId);
            if (tempStudent == null) {
                textArea.append("No matches for this Andrew ID: " + tempAndrewId + "\n");
                return;
            }
            andrewIdDeleteArea.setText(null);

            String studentStr = tempStudent.toString();
            directory.deleteStudent(tempAndrewId);
            textArea.append("Thew entry was deleted: " + studentStr + "\n");
        }
    }

    /**
     * Class for searchByAndrewIdActionListener.
     */
    private class SearchByAndrewIdActionListener implements ActionListener {
        /**
         * Listen to the performed action.
         * @param event action event.
         */
        public void actionPerformed(ActionEvent event) {
//            area.append("Now begin to search by Andrew Id\n");
//            System.out.println("Former: " + searchKeyArea.getText() + "!");
            String keyAndrewId = searchKeyArea.getText().trim();
            searchKeyArea.setText(keyAndrewId);
//            System.out.println("Latter: " + searchKeyArea.getText() + "!");

// Check errors
            if (keyAndrewId == null || keyAndrewId.length() == 0) {
                textArea.append("Search key (Andrew ID) Missing\n");
                return;
            }

            Student tempStudent = directory.searchByAndrewId(keyAndrewId);
            if (tempStudent == null) {
                textArea.append("No matches for search key (Andew ID): " + keyAndrewId + "\n");
                return;
            }
            searchKeyArea.setText(null);
            textArea.append("The entry was found by search key (Andrew ID): " + tempStudent + "\n");
        }
    }

    /**
     * Class for searchByFirstNameActionListener.
     */
    private class SearchByFirstNameActionListener implements ActionListener {
        /**
         * Listen to the performed action.
         * @param event action event.
         */
        public void actionPerformed(ActionEvent event) {
//            area.append("Now begin to search by first name\n");
            String keyFirstName = searchKeyArea.getText().trim();
            searchKeyArea.setText(keyFirstName);

// Check errors
            if (keyFirstName == null || keyFirstName.length() == 0) {
                textArea.append("Search key (first name) Missing\n");
                return;
            }
            List<Student> searchRes = directory.searchByFirstName(keyFirstName);
            if (searchRes == null || searchRes.size() == 0) {
                textArea.append("No matches for search key (first name): " + keyFirstName + "\n");
                return;
            }
            searchKeyArea.setText(null);

// One match
            if (searchRes.size() == 1) {
                textArea.append(searchRes.get(0) + "\n");
                return;
            }

// Multiple matches
            textArea.append("Found " + searchRes.size() + " entries search key (first name):\n");
            for (int i = 0; i < searchRes.size(); i++) {
                textArea.append(searchRes.get(i).toString() + "\n");
            }
        }
    }

    /**
     * Class for LastNameActionListener.
     */
    private class SearchByLastNameActionListener implements ActionListener {
        /**
         * Listen to the performed action.
         * @param event action event.
         */
        public void actionPerformed(ActionEvent event) {
//            area.append("Now begin to search by last name\n");
            String keyLastName = searchKeyArea.getText().trim();
            searchKeyArea.setText(keyLastName);

// Check errors
            if (keyLastName == null || keyLastName.length() == 0) {
                textArea.append("Search key (last name) Missing\n");
                return;
            }
            List<Student> searchRes = directory.searchByLastName(keyLastName);
            if (searchRes == null || searchRes.size() == 0) {
                textArea.append("No matches for search key (last name): " + keyLastName + "\n");
                return;
            }
            searchKeyArea.setText(null);

// One match
            if (searchRes.size() == 1) {
                textArea.append(searchRes.get(0) + "\n");
                return;
            }

// Multiple matches
            textArea.append("Found " + searchRes.size() + " entries search key (last name):\n");
            for (int i = 0; i < searchRes.size(); i++) {
                textArea.append(searchRes.get(i).toString() + "\n");
            }
        }
    }

    /**
     * Main function.
     * @param args the input String.
     * @throws IOException throws IOException.
     */
    public static void main(String[] args) throws IOException {
        DirectoryDriver dicDriver = new DirectoryDriver();

        if (args == null || args.length == 1) {
// Read training data
            String fileName = args[0];
            dicDriver.loadData(fileName);
        } else if (args.length != 0) {
            System.out.println("Illegal input arguments");
        }

        dicDriver.quoteGUIAction();
    }
}
