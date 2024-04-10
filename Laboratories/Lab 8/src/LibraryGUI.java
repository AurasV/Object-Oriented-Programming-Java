import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class LibraryGUI {
    private JFrame frame;
    private JTextField titleField, authorField, genreField, isbnField, descriptionField;
    private JTextArea displayArea;
    private JButton addButton, viewButton, findButton, editButton, saveEditButton;
    private Book currentEditingBook;
    private List<Book> books;

    public LibraryGUI() {
        books = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Library Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Initialize fields
        titleField = new JTextField(20);
        authorField = new JTextField(20);
        genreField = new JTextField(20);
        isbnField = new JTextField(20);
        descriptionField = new JTextField(20);

        // Initialize buttons
        addButton = new JButton("Add Book");
        viewButton = new JButton("View Books");
        findButton = new JButton("Find Book");
        editButton = new JButton("Edit Book");
        saveEditButton = new JButton("Save Edits");
        saveEditButton.setEnabled(false); // Initially disabled

        // Layout for input fields and buttons
        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreField);
        inputPanel.add(new JLabel("ISBN:"));
        inputPanel.add(isbnField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);

        // Adding buttons to the panel
        inputPanel.add(addButton);
        inputPanel.add(viewButton);
        inputPanel.add(findButton);
        inputPanel.add(editButton);
        inputPanel.add(saveEditButton);

        // Text area for displaying books
        displayArea = new JTextArea(10, 50);
        displayArea.setEditable(false);

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Action Listeners for buttons
        addButton.addActionListener(this::addBook);
        viewButton.addActionListener(this::viewBooks);
        findButton.addActionListener(this::findBook);
        editButton.addActionListener(this::editBook);
        saveEditButton.addActionListener(this::saveEditedBook);

        frame.pack();
        frame.setVisible(true);
    }

    private void addBook(ActionEvent e) {
        Book book = new Book(titleField.getText(), authorField.getText(), genreField.getText(), isbnField.getText(), descriptionField.getText());
        CSVHandler.writeBook(book);
        clearFields();
        JOptionPane.showMessageDialog(frame, "Book added successfully!");
    }

    private void viewBooks(ActionEvent e) {
        books = CSVHandler.readBooks();
        displayArea.setText("");
        for (Book book : books) {
            displayArea.append(book.getTitle() + " - " + book.getAuthor() + "\n");
        }
    }

    private void findBook(ActionEvent e) {
        String searchTerm = JOptionPane.showInputDialog(frame, "Enter title or author to search:");
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            displayArea.setText("");
            for (Book book : books) {
                if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) || book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase())) {
                    displayArea.append(book.getTitle() + " - " + book.getAuthor() + "\n");
                }
            }
        }
    }

    private void editBook(ActionEvent e) {
        String searchTerm = JOptionPane.showInputDialog(frame, "Enter the title of the book to edit:");
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(searchTerm)) {
                    currentEditingBook = book;
                    titleField.setText(book.getTitle());
                    authorField.setText(book.getAuthor());
                    genreField.setText(book.getGenre());
                    isbnField.setText(book.getIsbn());
                    descriptionField.setText(book.getDescription());
                    saveEditButton.setEnabled(true);
                    break;
                }
            }
        }
    }

    private void saveEditedBook(ActionEvent e) {
        if (currentEditingBook != null) {
            currentEditingBook.setTitle(titleField.getText());
            currentEditingBook.setAuthor(authorField.getText());
            currentEditingBook.setGenre(genreField.getText());
            currentEditingBook.setIsbn(isbnField.getText());
            currentEditingBook.setDescription(descriptionField.getText());

            // Update the book in the list and CSV
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getTitle().equalsIgnoreCase(currentEditingBook.getTitle())) {
                    books.set(i, currentEditingBook);
                    break;
                }
            }

            CSVHandler.overwriteCSV(books);
            clearFields();
            saveEditButton.setEnabled(false);
            JOptionPane.showMessageDialog(frame, "Book updated successfully!");
        }
    }

    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        genreField.setText("");
        isbnField.setText("");
        descriptionField.setText("");
    }

}
