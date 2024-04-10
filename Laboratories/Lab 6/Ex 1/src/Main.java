import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class PersonForm extends Frame {
    private TextField nameTextField;
    private CheckboxGroup genderGroup;
    private Checkbox maleCheckbox;
    private Checkbox femaleCheckbox;
    private TextArea jobDescriptionTextArea;
    private Scrollbar experienceScrollbar;
    private TextField experienceValueTextField;
    private Choice locationChoice;
    private Button addButton;
    private Button showAllButton;
    private Button saveAllButton;

    private ArrayList<Person> personList = new ArrayList<>();

    public PersonForm() {
        setLayout(new GridLayout(0, 2));

        nameTextField = new TextField();
        genderGroup = new CheckboxGroup();
        maleCheckbox = new Checkbox("Male", genderGroup, false);
        femaleCheckbox = new Checkbox("Female", genderGroup, false);
        jobDescriptionTextArea = new TextArea();
        experienceScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        experienceValueTextField = new TextField("0", 2);
        locationChoice = new Choice();


        locationChoice.add("Bucuresti");
        locationChoice.add("Braila");
        locationChoice.add("Targoviste");
        locationChoice.add("Maracineni");
        locationChoice.add("Buzau");


        addButton = new Button("Add");
        showAllButton = new Button("Show All");
        saveAllButton = new Button("Save All");

        add(new Label("Name"));
        add(nameTextField);
        add(new Label("Gender"));
        Panel genderPanel = new Panel(new FlowLayout());
        genderPanel.add(maleCheckbox);
        genderPanel.add(femaleCheckbox);
        add(genderPanel);
        add(new Label("Job Description"));
        add(jobDescriptionTextArea);
        add(new Label("Experience in years"));
        Panel experiencePanel = new Panel(new FlowLayout());
        experiencePanel.add(experienceScrollbar);
        experiencePanel.add(experienceValueTextField);
        add(experiencePanel);
        add(new Label("Location"));
        add(locationChoice);
        add(addButton);
        add(showAllButton);
        add(saveAllButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPerson();
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllPersons();
            }
        });

        saveAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveAllPersons();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        experienceScrollbar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                experienceValueTextField.setText(String.valueOf(experienceScrollbar.getValue()));
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setSize(400, 300);
        setVisible(true);
    }

    private void addPerson() {
        String name = nameTextField.getText();
        String gender = genderGroup.getSelectedCheckbox().getLabel();
        String jobDescription = jobDescriptionTextArea.getText();
        int experience = experienceScrollbar.getValue();
        String location = locationChoice.getSelectedItem();

        Person person = new Person(name, gender, jobDescription, experience, location);
        personList.add(person);

        nameTextField.setText("");
        jobDescriptionTextArea.setText("");
        experienceScrollbar.setValue(0);
        experienceValueTextField.setText("0");
    }

    private void showAllPersons() {
        JFrame frame = new JFrame("List of Persons");
        JTextArea textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        for (Person person : personList) {
            textArea.append(person.toString() + "\n");
        }

        frame.add(new JScrollPane(textArea));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void saveAllPersons() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("persons.txt"));
        writer.write(Arrays.toString(personList.toArray())  );
        writer.close();
    }

    public static void main(String[] args) {
        new PersonForm();
    }
}

class Person {
    private String name;
    private String gender;
    private String jobDescription;
    private int experience;
    private String location;

    public Person(String name, String gender, String jobDescription, int experience, String location) {
        this.name = name;
        this.gender = gender;
        this.jobDescription = jobDescription;
        this.experience = experience;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", experience=" + experience +
                ", location='" + location + '\'' +
                '}';
    }
}
