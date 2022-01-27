package studio.rrprojects.storytellergui.gui;

import studio.rrprojects.storytellergui.Controller;

import javax.swing.*;

public class MainWindow extends JFrame {
    private final Controller controller;
    private JButton buttonSubmit;
    private JPanel panelMain;
    private JButton buttonConnect;
    private JComboBox comboBoxChannel;
    private JComboBox comboBoxProfile;
    private JTextArea textAreaMessage;

    public MainWindow(Controller controller) {
        super("Story Teller v0");
        this.controller = controller;

        setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);


        //TODO Disable all components until a successful connection has been established

        buttonSubmit.addActionListener(actionEvent -> {
            String input = textAreaMessage.getText();
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
