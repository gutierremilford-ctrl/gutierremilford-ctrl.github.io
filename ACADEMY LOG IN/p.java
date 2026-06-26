import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class p {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(3, 5, 9)); // Fixed octal color layout
        frame.setTitle("  STUDENT PORTAL");
        frame.setLocationRelativeTo(null); // Passing null centers it perfectly on your monitor
        frame.setLayout(null);

        JPanel panelheader = new JPanel();
        panelheader.setBounds(0, 0, 600, 50);
        panelheader.setBackground(Color.GRAY);
        panelheader.setLayout(null);
        frame.add(panelheader);

        JLabel iconJLabelyt = new JLabel("MILFY ACADEMY PORTAL");
        iconJLabelyt.setForeground(Color.BLACK);
        iconJLabelyt.setBounds(180, 0, 600, 50);
        iconJLabelyt.setFont(new Font("Arial", Font.BOLD, 16));
        panelheader.add(iconJLabelyt);

        JButton signOut = new JButton("Sign Out");
        signOut.setBounds(450, 10, 130, 30);
        panelheader.add(signOut);
        signOut.addActionListener(hell_nawh -> frame.dispose());

        JLabel lblProfile = new JLabel("Student Profile");
        lblProfile.setBounds(30, 60, 150, 20);
        lblProfile.setForeground(Color.WHITE);
        frame.add(lblProfile);

        JPanel Panel1 = new JPanel();
        Panel1.setBounds(30, 80, 250, 250);
        Panel1.setBackground(Color.WHITE);
        Panel1.setLayout(null);
        frame.add(Panel1);

        JLabel lblEnroll = new JLabel("Enrollment");
        lblEnroll.setBounds(300, 60, 150, 20);
        lblEnroll.setForeground(Color.WHITE);
        frame.add(lblEnroll);

        JPanel Panel2 = new JPanel();
        Panel2.setBounds(300, 80, 250, 250);
        Panel2.setBackground(Color.WHITE);
        Panel2.setLayout(null);
        frame.add(Panel2);

        // PANEL 4 (Bottom Panel)
        JPanel Panel4 = new JPanel();
        Panel4.setBounds(0, 500, 600, 100);
        Panel4.setBackground(Color.GRAY);
        Panel4.setLayout(null);
        frame.add(Panel4);

        ///// FULL NAME /////
        JTextField emaField = new JTextField();
        emaField.setBounds(90, 30, 150, 30);
        Panel1.add(emaField);

        JLabel iconJLabeleme = new JLabel("FULL NAME");
        iconJLabeleme.setForeground(Color.BLACK);
        iconJLabeleme.setBounds(20, 30, 150, 30);
        Panel1.add(iconJLabeleme);

        ///// STUDENT ID ///////
        JTextField MIField = new JTextField();
        MIField.setBounds(90, 70, 150, 30);
        Panel1.add(MIField);

        JLabel iconJLabelRT = new JLabel("STUDENT ID");
        iconJLabelRT.setForeground(Color.BLACK);
        iconJLabelRT.setBounds(20, 70, 150, 30);
        Panel1.add(iconJLabelRT);

        ////// SECTION BOX //////
        String opins[] = { "section 1A", "section 1B", "section 2A", "section 2B" };
        JComboBox combo = new JComboBox(opins);
        combo.setBounds(90, 110, 150, 30);
        combo.setSelectedIndex(-1);
        Panel1.add(combo);

        JLabel iconJLabelsec = new JLabel("SECTION");
        iconJLabelsec.setForeground(Color.BLACK);
        iconJLabelsec.setBounds(20, 110, 150, 30);
        Panel1.add(iconJLabelsec);

        ////// GENDER RADIO BUTTONS ////////
        JRadioButton jRadioButton1 = new JRadioButton("FEMALE");
        JRadioButton jRadioButton2 = new JRadioButton("MALE");
        JLabel L1 = new JLabel("GENDER");

        jRadioButton1.setBounds(90, 160, 80, 30);
        jRadioButton2.setBounds(175, 160, 66, 30);
        L1.setBounds(20, 160, 150, 30);

        Panel1.add(jRadioButton1);
        Panel1.add(jRadioButton2);
        Panel1.add(L1);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(jRadioButton1);
        genderGroup.add(jRadioButton2);

        //// STRANDS COMBO BOX ////
        String opin[] = { "ABM", "STEM", "ICT", "HUMS", "HU" };
        JComboBox combe = new JComboBox(opin);
        combe.setBounds(110, 30, 100, 30);
        combe.setSelectedIndex(-1);
        Panel2.add(combe);

        JLabel iconJLabelg = new JLabel("MAJOR STRANDS");
        iconJLabelg.setForeground(Color.BLACK);
        iconJLabelg.setBounds(5, 30, 110, 30);
        Panel2.add(iconJLabelg);

        //// ADMIN TEXT AREA ////
        JTextArea area1 = new JTextArea();
        area1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        area1.setBounds(95, 90, 150, 100);
        area1.setLineWrap(true);
        Panel2.add(area1);

        JLabel iconJLabelp = new JLabel("ADMIN TEXT");
        iconJLabelp.setForeground(Color.BLACK);
        iconJLabelp.setFont(new Font("Arial", Font.BOLD, 12));
        iconJLabelp.setBounds(5, 90, 100, 30);
        Panel2.add(iconJLabelp);

        JCheckBox confirmBox = new JCheckBox("Confirm data integrity");
        confirmBox.setBounds(95, 200, 200, 20);
        Panel2.add(confirmBox);

        // DATA TABLE SETUP
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Name", "ID", "Section", "Gender", "Strand", "Admin" }, 0);
        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(30, 350, 520, 150);
        frame.add(scroll);

        // SAVE CHANGES BUTTON
        JButton submit = new JButton("Save Changes");
        submit.setBounds(150, 20, 150, 30);
        Panel4.add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = emaField.getText();
                String id = MIField.getText();
                String section = (String) combo.getSelectedItem();
                String gender = jRadioButton1.isSelected() ? "Female"
                        : jRadioButton2.isSelected() ? "Male" : "Not Specified";
                String strand = (String) combe.getSelectedItem();
                String admin = area1.getText();

                // Validation
                if (name.trim().isEmpty() || id.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Name and ID required");
                    return;
                }

                // FIX: Successfully adds data as a row directly to your table view
                model.addRow(new Object[] { name, id, section, gender, strand, admin });

                // Optional: Clear out fields after hitting submit
                emaField.setText("");
                MIField.setText("");
                combo.setSelectedIndex(-1);
                genderGroup.clearSelection();
                combe.setSelectedIndex(-1);
                area1.setText("");
                confirmBox.setSelected(false);
            }
        });

        // RESET FORM BUTTON
        JButton reset = new JButton("Reset Form");
        reset.setBounds(360, 20, 120, 30);
        Panel4.add(reset);

        reset.addActionListener(e -> {
            emaField.setText("");
            MIField.setText("");
            combo.setSelectedIndex(-1);
            genderGroup.clearSelection();
            combe.setSelectedIndex(-1);
            area1.setText("");
            confirmBox.setSelected(false);
        });

        frame.setVisible(true);
    }
}