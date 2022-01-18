package studio.rrprojects.storytellergui.gui;

import studio.rrprojects.storytellergui.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private final Controller controller;
    private JButton buttonTest;
    private JPanel panelMain;

    public MainWindow(Controller controller) {
        super("Story Teller v0");
        this.controller = controller;

        setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);


        buttonTest.addActionListener(actionEvent -> {
            controller.testPing();
        });
    }
}
