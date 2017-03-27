package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

/**
 * Created by Alex on 27/03/2017.
 */
public class SampleView extends JFrame {

    private static final String TITLE = "Sample View";
    private final JTextField fieldA;
    private final JTextField fieldB;
    private final JButton btnUpdate;

    public SampleView() throws HeadlessException {
        super(TITLE);
        fieldA = new JTextField();
        fieldB = new JTextField();
        btnUpdate = new JButton("Update");
        initializeView();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeView() {
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(fieldA);
        add(fieldB);
        add(btnUpdate);
        setSize(300, 300);
        setLocationRelativeTo(null);
    }

    public String getFieldAText() {
        return fieldA.getText();
    }

    public String getFieldBText() {
        return fieldB.getText();
    }

    public void addUpdateButtonListener(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }

    public void updateFieldB(String fieldBText) {
        this.fieldB.setText(fieldBText);
    }

}
