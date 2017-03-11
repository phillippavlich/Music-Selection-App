import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import javax.swing.JSlider;

import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.SystemColor;


public class WindowsBuilderPractice {
	
	private JFrame frmTrackr;
	private JTextField txtStrongly;
	private JTextField txtDisagree;
	private JTextField txtMaybe;
	private JTextField txtAgree;
	private JTextField txtStrongly_1;
	private JTextField txtI;
	private int count =0;
	
	private static int numOfQuestions=5;
	protected static int [] questionResponses=new int[numOfQuestions];
	private JSlider slider;
	public List<Song> DATA;
	public int valueChecker;
	/**
	 * Launch the application.
	 */
	public WindowsBuilderPractice(List<Song> DATA) {
		this.DATA=DATA;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void QA(List<Song> DATA) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsBuilderPractice window = new WindowsBuilderPractice(DATA);
					window.frmTrackr.setVisible(true);
					System.out.println(DATA.get(0).getArtist_name());
					System.out.println(DATA.get(0).getTitle());
					System.out.println(DATA.get(0).getArtist_7digitalid());
					System.out.println(DATA.get(0).getTrack_7digitalid());
					System.out.println(" ");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	private void initialize() {
		frmTrackr = new JFrame();
		frmTrackr.setTitle("TrackR");
		frmTrackr.getContentPane().setBackground(new Color(255, 255, 255));
		frmTrackr.setBounds(100, 100, 700, 500);
		frmTrackr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrackr.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Click Here to Begin!");
		btnNewButton.addActionListener(new ActionListener() {//when button begin is clicked
			public void actionPerformed(ActionEvent arg0) {
				frmTrackr.getContentPane().removeAll();///this is how to remove stuff
				frmTrackr.getContentPane().repaint();
				
				questionNumber();	
			}
		});
		btnNewButton.setToolTipText("Start!");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(467, 350, 191, 63);
		frmTrackr.getContentPane().add(btnNewButton);
		
		txtStrongly_1 = new JTextField();
		txtStrongly_1.setEditable(false);
		txtStrongly_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStrongly_1.setText("5 = Strongly Agree");
		txtStrongly_1.setBounds(231, 366, 191, 38);
		frmTrackr.getContentPane().add(txtStrongly_1);
		txtStrongly_1.setColumns(10);
		
		txtAgree = new JTextField();
		txtAgree.setEditable(false);
		txtAgree.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAgree.setText("4 = Agree");
		txtAgree.setBounds(231, 328, 191, 38);
		frmTrackr.getContentPane().add(txtAgree);
		txtAgree.setColumns(10);
		
		txtMaybe = new JTextField();
		txtMaybe.setEditable(false);
		txtMaybe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaybe.setText("3 = Neutral");
		txtMaybe.setBounds(231, 290, 191, 38);
		frmTrackr.getContentPane().add(txtMaybe);
		txtMaybe.setColumns(10);
		
		txtDisagree = new JTextField();
		txtDisagree.setEditable(false);
		txtDisagree.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDisagree.setText("2 = Disagree");
		txtDisagree.setBounds(231, 252, 191, 38);
		frmTrackr.getContentPane().add(txtDisagree);
		txtDisagree.setColumns(10);
		
		txtStrongly = new JTextField();
		txtStrongly.setEditable(false);
		txtStrongly.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStrongly.setText("1 = Strongly Disagree");
		txtStrongly.setBounds(231, 214, 191, 38);
		frmTrackr.getContentPane().add(txtStrongly);
		txtStrongly.setColumns(10);
		
		txtI = new JTextField();
		txtI.setEditable(false);
		txtI.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtI.setText("0 = Irrelevant Category");
		txtI.setBounds(231, 176, 191, 38);
		frmTrackr.getContentPane().add(txtI);
		txtI.setColumns(10);
	
		JTextArea txtrAfterListeningTo = new JTextArea();
		txtrAfterListeningTo.setBackground(SystemColor.info);
		txtrAfterListeningTo.setEditable(false);
		txtrAfterListeningTo.setWrapStyleWord(true);
		txtrAfterListeningTo.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtrAfterListeningTo.setLineWrap(true);
		txtrAfterListeningTo.setText("Now that you have listened to this song, we will ask you a series of questions to help pick a song that fits your interests. Please answer the following questions honestly based on the numbering system below.");
		txtrAfterListeningTo.setBounds(79, 65, 500, 91);
		frmTrackr.getContentPane().add(txtrAfterListeningTo);
		
		
		JLabel lblHello = new JLabel("");
		Image musicPNG = new ImageIcon(this.getClass().getResource("/music1.png")).getImage();
		lblHello.setBounds(0, 0, 682, 453);
		
		lblHello.setIcon(new ImageIcon(musicPNG));
		frmTrackr.getContentPane().add(lblHello);
	
		
	}
	private void questionNumber(){
		if(count<numOfQuestions){
			checkQ(count);
			count++;
		}
		else{
			end();
		}
	}
	private void checkQ(int i){
		switch (i){
			case 0:
				String a="I liked the artist's voice!";
				questions(a);
				break;
				
			case 1:
				String b="I liked the tempo of this song!";
				questions(b);
				break;
			
			case 2:
				String d="I liked the loudness of the song!";
				questions(d);
				break;
			case 3:
				String e="I can dance to this song!";
				questions(e);
				break;
				
			case 4:
				String f="Overall, I liked the song";
				questions(f);
				break;
					
			default:
				System.out.println("There was an error!");
		}
	}
	private void questions(String question){
		JTextField txtStrongly_2 = new JTextField();
		txtStrongly_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStrongly_2.setBackground(new Color(255, 255, 0));
		Border redline1 = BorderFactory.createLineBorder(Color.red,3);
		txtStrongly_2.setBorder(redline1);
		txtStrongly_2.setEditable(false);
		txtStrongly_2.setText("Q"+(count+1));
		txtStrongly_2.setBounds(625, 25, 30, 30);
		frmTrackr.getContentPane().add(txtStrongly_2);
		
		//JSlider slider = new JSlider();
		slider = new JSlider();
		slider.setBounds(190, 240, 300, 62);
		Border blueline = BorderFactory.createLineBorder(Color.blue,3);
		slider.setBorder(blueline);
		
		//this next part is unique for phil's
		slider.setBackground(Color.YELLOW);
		
	    slider.setMajorTickSpacing(1);
	    slider.setMinorTickSpacing(1);
	    slider.setMinimum(0);
	    slider.setMaximum(5);
	    slider.setValue(3);
	    slider.setPaintLabels(true);
	    slider.setPaintTicks(true);
	    slider.setSnapToTicks(true);
	    frmTrackr.getContentPane().add(slider,BorderLayout.SOUTH);
	    
	    //this next part is unique to matts
	    /*
	    JTextField sliderBackground = new JTextField();
		sliderBackground.setBackground(new Color(255, 255, 0));
		sliderBackground.setBounds(190, 240, 300, 62);
		frmTrackr.getContentPane().add(sliderBackground);
		*/
	    
		JButton btnNewButton = new JButton("Next Question");
		btnNewButton.addActionListener(new ActionListener() {//when button begin is clicked
			public void actionPerformed(ActionEvent arg0) {
				questionResponses[count-1]=slider.getValue()-3;
				
				frmTrackr.getContentPane().removeAll();///this is how to remove stuff
				frmTrackr.getContentPane().repaint();
				
				questionNumber();
			}
		});
		btnNewButton.setToolTipText("Next");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(467, 350, 191, 63);
		frmTrackr.getContentPane().add(btnNewButton);
		
		txtStrongly_1 = new JTextField();
		txtStrongly_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStrongly_1.setEditable(false);
		txtStrongly_1.setText(question);
		Border redline = BorderFactory.createLineBorder(Color.red,3);
		txtStrongly_1.setBorder(redline);
		txtStrongly_1.setBackground(new Color(255, 255, 0));
		txtStrongly_1.setBounds(201, 160, 278, 37);
		frmTrackr.getContentPane().add(txtStrongly_1);
		
	
		
		JLabel lblHello = new JLabel("");
		Image musicPNG = new ImageIcon(this.getClass().getResource("/music4.png")).getImage();
		lblHello.setBounds(0, 0, 682, 453);
		
		lblHello.setIcon(new ImageIcon(musicPNG));
		frmTrackr.getContentPane().add(lblHello);
		
	} 
	private void end(){//DONT USE
		frmTrackr.dispose();
		computeSimilarSongs.test(this.DATA);
		
	}
	
}
