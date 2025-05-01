import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame {
    private final SortedList sortedList;
    private final JTextArea displayArea;
    private final JTextField inputField;
    private final JTextField searchField;

    public SortedListGUI() {
        sortedList = new SortedList();
        setTitle("Sorted List Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 2, 5, 5));
        inputField = new JTextField();
        JButton addButton = new JButton("Add to List");
        searchField = new JTextField();
        JButton searchButton = new JButton("Search");

        topPanel.add(new JLabel("Enter String:"));
        topPanel.add(inputField);
        topPanel.add(new JLabel("Search String:"));
        topPanel.add(searchField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);

        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText().trim();
                if (!text.isEmpty()) {
                    sortedList.add(text);
                    displayArea.append("Added: " + text + "\n");
                    displayArea.append("List: " + sortedList + "\n\n");
                    inputField.setText("");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = searchField.getText().trim();
                if (!text.isEmpty()) {
                    int result = sortedList.binarySearch(text);
                    if (result >= 0) {
                        displayArea.append("Found '" + text + "' at index: " + result + "\n\n");
                    } else {
                        int insertIndex = -result - 1;
                        displayArea.append("'" + text + "' not found. Would be at index: " + insertIndex + "\n\n");
                    }
                    searchField.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortedListGUI gui = new SortedListGUI();
            gui.setVisible(true);
        });
    }
}
