/**
 * @title LoginScreen Class
 * @author Nick Fulton & Drew Howell
 * @date 050517
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginScreen 
{
    private JFrame frame;
    private Dimension screenSize;
    private Icon LOGO = new ImageIcon("OyeaLogo.png");
    
    //input fields
    private JTextField usernameField = new JTextField("Username", 20);
    private JPasswordField passwordField = new JPasswordField("Password", 20);
    private JButton loginButton = new JButton("Login");
    
    //info being read
    private String username;
    private String password;
    
    /**
     * @title LoginScreen() Constructor
     * @desc Creates the JFrame and all of it's contents.
     */
    public LoginScreen()
    {
        username = "";
        password = "";
        loginButton.setActionCommand("login");
        createFrame();
        packFrame();
    }
    
    /**
     * @title createFrame() method
     * @desc Builds the frame
     */
    private void createFrame()
    {        
        Container content;
        JLabel logo = new JLabel(LOGO, JLabel.CENTER);
        JLabel instructions = new JLabel("Please Login Below", JLabel.CENTER);

        
        JPanel login = new JPanel();
        login.setLayout(new FlowLayout());
        
        instructions.setBounds(100, 10, 100, 25);
        usernameField.setBounds(100, 10, 100, 25);
        passwordField.setBounds(100, 10, 100, 25);

        usernameField.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                usernameField.setText("");
            }
        });
        
        passwordField.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                passwordField.setText("");
            }
        });
        
        loginButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                readInfo();
            }
        });

        // Frame Stuff
        frame = new JFrame("Oyea - Login");
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 250));
        frame.setMinimumSize(new Dimension(300, 250));
        frame.setMaximumSize(new Dimension(300, 250));
        frame.setLocation(screenSize.width / 2 - 150, screenSize.height / 2 - 250);
        content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        
        // Add to the "Login" pane
        login.add(instructions);
        login.add(usernameField);
        login.add(passwordField);
        login.add(loginButton);
        
        // Start adding panels
        content.add(logo, BorderLayout.NORTH);
        content.add(login, BorderLayout.CENTER);
        
    }
    
    /**
     * @title packFrame() method
     * @desc Creates an instance of the frame and makes it visible.
     */
    private void packFrame()
    {
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * @title processFrame() method
     * @desc Gets the info entered into the text fields when the login button is pressed.
     */
    public void readInfo()
    {
        //System.out.println("Nice");
        username = usernameField.getText();
        password = passwordField.getText();
        System.out.println(username + "\n" + password);
    }
}
