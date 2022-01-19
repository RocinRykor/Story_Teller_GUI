package studio.rrprojects.storytellergui.gui;

import studio.rrprojects.storytellergui.Controller;

import javax.swing.*;

public class MainWindow extends JFrame {
    private final Controller controller;
    private JButton buttonTest;
    private JPanel panelMain;
    private JButton buttonConnect;
    private JTextField textFieldInput;

    public MainWindow(Controller controller) {
        super("Story Teller v0");
        this.controller = controller;

        setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);


        buttonTest.addActionListener(actionEvent -> {
            String input = textFieldInput.getText();
            if (input.isBlank()) {
                return;
            }
            controller.sendAndClose(input);
        });

        buttonConnect.addActionListener(actionEvent -> {
            controller.ping();
        });
    }
}
