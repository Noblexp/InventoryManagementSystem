package view;

import controller.AuthController;

import javax.swing.*;

public class IMDP extends JFrame {
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton btnLogin, btnRegister;
    private AuthController controller;

    public IMDP() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        controller = new AuthController();

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, 30, 80, 25);
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(120, 30, 130, 25);
        add(tfUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 70, 80, 25);
        add(lblPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(120, 70, 130, 25);
        add(tfPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(30, 110, 100, 30);
        add(btnLogin);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(150, 110, 100, 30);
        add(btnRegister);

        btnLogin.addActionListener(e -> {
            String user = tfUsername.getText();
            String pass = String.valueOf(tfPassword.getPassword());
            if (controller.login(user, pass)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                this.dispose();
                new InventoryForm(); // After login, open inventory
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials.");
            }
        });

        btnRegister.addActionListener(e -> {
            String user = tfUsername.getText();
            String pass = String.valueOf(tfPassword.getPassword());
            if (controller.register(user, pass)) {
                JOptionPane.showMessageDialog(this, "Registered successfully. Now login.");
            } else {
                JOptionPane.showMessageDialog(this, "Username may already exist.");
            }
        });

        setVisible(true);
    }
}
