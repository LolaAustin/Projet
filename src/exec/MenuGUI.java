package exec;

import data.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * This class represents a graphical user interface for interacting with a database of programmers.
 */
public class MenuGUI extends JFrame {
    private ActionBDDImpl actionDB;
    private JTextField idField;
    private JTextArea displayArea;
    private JScrollPane scroll;

    /**
     * Constructor for the MenuGUI class.
     *
     * @param actionDB An instance of the ActionBDDImpl class for performing database actions.
     */
    public MenuGUI(ActionBDDImpl actionDB) {
        this.actionDB = actionDB;
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLayout(new BorderLayout());
        displayArea = new JTextArea(1000, 500);
        displayArea.setEditable(false);

        // Create a scroll pane for the text area
        this.scroll = new JScrollPane(displayArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        idField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JLabel idLabel = new JLabel("Programmer ID:");
        JButton displayAllButton = new JButton("Display All");
        JButton displayButton = new JButton("Display by ID");
        JButton addButton = new JButton("Add Entry");
        JButton modifyButton = new JButton("Modify Entry");
        JButton deleteButton = new JButton("Delete Entry");

        // ActionListener for displaying data by ID
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String result = actionDB.afficher_id(id);
                    // Display the results in the JTextArea
                    displayArea.setText(result);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Enter a valid ID", "Error", JOptionPane.ERROR_MESSAGE);
                };
            }
        });

        // ActionListener for displaying all data
        displayAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = actionDB.afficher();
                // Display the results in the JTextArea
                displayArea.setText(result);
            }
        });

        // ActionListener for adding a new entry
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame for adding entries
                JFrame addFrame = new JFrame("Add Entry");
                addFrame.setLayout(new FlowLayout());

                // Add input fields for the new entry
                JTextField nomField = new JTextField(20);
                JTextField prenomField = new JTextField(20);
                JTextField ageField = new JTextField(5);
                JTextField salaireField = new JTextField(10);
                JTextField primeField = new JTextField(10);
                JTextField pseudoField = new JTextField(20);
                JTextField responsableField = new JTextField(20);
                JTextField hobbyField = new JTextField(50);
                JTextField adresseField = new JTextField(50);

                JButton submitButton = new JButton("Submit");

                // ActionListener for submitting the new entry
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Get user input
                        String nom = nomField.getText();
                        String prenom = prenomField.getText();
                        int age = Integer.parseInt(ageField.getText());
                        float salaire = Float.parseFloat(salaireField.getText());
                        float prime = Float.parseFloat(primeField.getText());
                        String pseudo = pseudoField.getText();
                        String responsable = responsableField.getText();
                        String hobby = hobbyField.getText();
                        String adresse = adresseField.getText();

                        // Call the actionDB.ajouter method with user input
                        try {
                            actionDB.ajouter(nom, prenom, age, salaire, prime, pseudo, responsable, hobby, adresse);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        // Update the UI or provide a confirmation message
                        JOptionPane.showMessageDialog(null, "Entry added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        addFrame.dispose(); // Close the addFrame
                    }
                });

                // Add components to the addFrame
                addFrame.add(new JLabel("Nom: "));
                addFrame.add(nomField);
                addFrame.add(new JLabel("Prénom: "));
                addFrame.add(prenomField);
                addFrame.add(new JLabel("Année de Naissance: "));
                addFrame.add(ageField);
                addFrame.add(new JLabel("Salaire: "));
                addFrame.add(salaireField);
                addFrame.add(new JLabel("Prime: "));
                addFrame.add(primeField);
                addFrame.add(new JLabel("Pseudo: "));
                addFrame.add(pseudoField);
                addFrame.add(new JLabel("Responsable: "));
                addFrame.add(responsableField);
                addFrame.add(new JLabel("Hobby: "));
                addFrame.add(hobbyField);
                addFrame.add(new JLabel("Adresse: "));
                addFrame.add(adresseField);
                addFrame.add(submitButton);

                // Configure the addFrame
                addFrame.pack();
                addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addFrame.setLocationRelativeTo(null);
                addFrame.setVisible(true);
            }
        });

        // ActionListener for modifying an entry
        modifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame for modifying entries
                JFrame modifyFrame = new JFrame("Modify Entry");
                modifyFrame.setLayout(new FlowLayout());

                // Add input fields for the modification
                JTextField idField = new JTextField(5);
                JTextField newValueField = new JTextField(20);

                JComboBox<String> modificationType = new JComboBox<>(new String[] {
                    "Salaire", "Nom", "Prénom", "Année de Naissance", "Prime",
                    "Pseudo", "Responsable", "Hobby", "Adresse"
                });

                JButton submitButton = new JButton("Submit");

                // ActionListener for submitting the modified entry
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Get user input
                        int id = Integer.parseInt(idField.getText());
                        String newValue = newValueField.getText();
                        String selectedModificationType = (String) modificationType.getSelectedItem();

                        if (!actionDB.verification_id(id)) {
                            JOptionPane.showMessageDialog(null, "ID does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                            return; // Exit the actionPerformed method
                        }

                        try {
                            switch (selectedModificationType) {
                                case "Salaire":
                                    float newSalaire = Float.parseFloat(newValue);
                                    actionDB.modifier_salaire(id, newSalaire);
                                    break;
                                case "Nom":
                                    actionDB.modifier_nom(id, newValue);
                                    break;
                                case "Prénom":
                                    actionDB.modifier_prenom(id, newValue);
                                    break;
                                case "Année de Naissance":
                                    int newAnnee = Integer.parseInt(newValue);
                                    actionDB.modifier_naissance(id, newAnnee);
                                    break;
                                case "Prime":
                                    float newPrime = Float.parseFloat(newValue);
                                    actionDB.modifier_prime(id, (int) newPrime);
                                    break;
                                case "Pseudo":
                                    actionDB.modifier_pseudo(id, newValue);
                                    break;
                                case "Responsable":
                                    actionDB.modifier_responsable(id, newValue);
                                    break;
                                case "Hobby":
                                    actionDB.modifier_hobby(id, newValue);
                                    break;
                                case "Adresse":
                                    actionDB.modifier_adresse(id, newValue);
                                    break;
                            }
        
                            // Update the UI or provide a confirmation message
                            JOptionPane.showMessageDialog(null, "Entry modified successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                            modifyFrame.dispose(); // Close the modifyFrame
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
        
                // Add components to the modifyFrame
                modifyFrame.add(new JLabel("Program ID to Modify: "));
                modifyFrame.add(idField);
                modifyFrame.add(new JLabel("Select Attribute to Modify: "));
                modifyFrame.add(modificationType);
                modifyFrame.add(new JLabel("New Value: "));
                modifyFrame.add(newValueField);
                modifyFrame.add(submitButton);
        
                // Configure the modifyFrame
                modifyFrame.pack();
                modifyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                modifyFrame.setLocationRelativeTo(null);
                modifyFrame.setVisible(true);
            }
        });

        // ActionListener for deleting an entry
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());

                    if (!actionDB.verification_id(id)) {
                        JOptionPane.showMessageDialog(null, "ID does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the actionPerformed method
                    }

                    actionDB.supprimer(id);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "Enter a valid ID", "Error", JOptionPane.ERROR_MESSAGE);
                };
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(displayAllButton);
        panel.add(displayButton);
        panel.add(addButton);
        panel.add(modifyButton);
        panel.add(deleteButton);        
        panel.add(scroll);

        add(panel, BorderLayout.CENTER);
    }
}
