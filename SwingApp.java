package ZombieApocalypse;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SwingApp {

	private JFrame frame;
	private JTextField tfPersonCount;
	private JTextField tfZombieCount;
	private static JTextArea textArea;
	
	static ArrayList<Person> alPerson = new ArrayList<Person>();
	static ArrayList<Person> alZombie = new ArrayList<Person>();
	private JTextField tfRounds;
	
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
    
    public static void outputIndividuals(int r)
    {
    	textArea.append("End of Round: " + (r+1) + ". There are " + alPerson.size() + " people alive, and " + alZombie.size() + " zombies.\n");
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
		textArea.setText("");
		
		tfRounds = new JTextField();
		tfRounds.setColumns(10);
		tfRounds.setBounds(154, 201, 134, 28);
		frame.getContentPane().add(tfRounds);
		
		JLabel lblHowManyDays = new JLabel("How many rounds would you like the battle to last?");
		lblHowManyDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowManyDays.setBounds(20, 181, 407, 16);
		frame.getContentPane().add(lblHowManyDays);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToZombie = new JLabel("Welcome to Zombie Apocalypse\u00AE");
		lblWelcomeToZombie.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToZombie.setBounds(20, 14, 407, 29);
		frame.getContentPane().add(lblWelcomeToZombie);
		
		JLabel lblFirstTellMe = new JLabel("How many civilians would you like to create?");
		lblFirstTellMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstTellMe.setBounds(20, 57, 407, 16);
		frame.getContentPane().add(lblFirstTellMe);
		
		JLabel lblNextTellMe = new JLabel("How many zombies would you like me to create?");
		lblNextTellMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNextTellMe.setBounds(21, 117, 407, 16);
		frame.getContentPane().add(lblNextTellMe);
		
		tfPersonCount = new JTextField();
		tfPersonCount.setBounds(154, 77, 134, 28);
		frame.getContentPane().add(tfPersonCount);
		tfPersonCount.setColumns(10);
		
		tfZombieCount = new JTextField();
		tfZombieCount.setColumns(10);
		tfZombieCount.setBounds(154, 137, 134, 28);
		frame.getContentPane().add(tfZombieCount);
		
		textArea = new JTextArea();
		textArea.setBounds(31, 283, 383, 421);
		frame.getContentPane().add(textArea);
		
		JButton btnGo = new JButton("FIGHT!");
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Clears the text inputs as well as the ArrayLists
				textArea.setText("");
				alPerson.clear();
				alZombie.clear();
				
				//Creates people based on the count given by the user
				createIndividuals(Integer.parseInt(tfPersonCount.getText()), true);
				
				//Creates zombies based on the count given by the user
				createIndividuals(Integer.parseInt(tfZombieCount.getText()), false);
				
				//Runs the encounter based on the rounds given by the user
				for(int i=0;i<Integer.parseInt(tfRounds.getText());i++)
				{
					//Run the encounter method and passes in both arraylists
					Encounter.encounter(alPerson, alZombie);		        
					
					//Outputs the round counts to the console
					outputIndividuals(i);			
				}
				
			}
		});
		btnGo.setBounds(158, 246, 117, 29);
		frame.getContentPane().add(btnGo);
	}
}
