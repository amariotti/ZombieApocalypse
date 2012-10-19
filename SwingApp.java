package ZombieApocalypse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class SwingApp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static JTextArea textArea;
	
	static ArrayList<Person> alPerson = new ArrayList<Person>();
	static ArrayList<Person> alZombie = new ArrayList<Person>();
	
	public static void createIndividuals(int count, boolean infected)
    {
    	for (int i = 0; i < count; i++)
        {
    		Person individual = new Person(infected);
    		
    		if (infected == true)
    			alZombie.add(individual);
    		else
    			alPerson.add(individual);
		}
    }
    
    public static void outputIndividuals()
    {
    	System.out.println(); //Temporary hard return
    	for(Person d:alPerson) {
    		textArea.append("Zombie: -- Health: " + d.getHealth() + ", Strength: " + d.getStrength() + ", Fatigue: " + d.getFatigue() + ", Hunger: " + d.getHunger() + "\n");
    	}
    	
    	System.out.println(); //Temporary hard return
    	
        for(Person d:alZombie) {
        	textArea.append("Person: -- Health: " + d.getHealth() + ", Strength: " + d.getStrength() + ", Fatigue: " + d.getFatigue() + ", Hunger: " + d.getHunger() + "\n");
        }
    }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApp window = new SwingApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToZombie = new JLabel("Welcome to Zombie Apocalypse\u00AE");
		lblWelcomeToZombie.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToZombie.setBounds(20, 14, 407, 29);
		frame.getContentPane().add(lblWelcomeToZombie);
		
		JLabel lblFirstTellMe = new JLabel("First, tell me how many civilians you'd like to create:");
		lblFirstTellMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstTellMe.setBounds(20, 57, 407, 16);
		frame.getContentPane().add(lblFirstTellMe);
		
		JLabel lblNextTellMe = new JLabel("Next, tell me how many zombies you'd like to create:");
		lblNextTellMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNextTellMe.setBounds(21, 117, 407, 16);
		frame.getContentPane().add(lblNextTellMe);
		
		textField = new JTextField();
		textField.setBounds(154, 79, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(154, 141, 134, 28);
		frame.getContentPane().add(textField_1);
		
		textArea = new JTextArea();
		textArea.setBounds(27, 215, 383, 177);
		frame.getContentPane().add(textArea);
		
		JButton btnGo = new JButton("GO!");
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				createIndividuals(Integer.parseInt(textField.getText()), true);
				createIndividuals(Integer.parseInt(textField_1.getText()), false);
		        
				outputIndividuals();
			}
		});
		btnGo.setBounds(162, 175, 117, 29);
		frame.getContentPane().add(btnGo);
	}
}
