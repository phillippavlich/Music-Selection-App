import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;


public class FinalProject_SwingDesigner {

	private JFrame frmTrackr;
	private JTextField txtWelcomeToTrackr;
	private JButton btnPlaySong_1;

	private JLabel lblBroughtToYou;
	private JLabel lblPhillipPavlich;
	private JLabel lblMattShortt;
	private JLabel lblNikNovak;
	private JLabel lblJoshMitchell;
	private JLabel lblErinVarey;
	private JLabel lblxbFinalProject;

	/**
	 * Launch the application.
	 */
	public static void Opening() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalProject_SwingDesigner window = new FinalProject_SwingDesigner();
					window.frmTrackr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinalProject_SwingDesigner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrackr = new JFrame();
		frmTrackr.setTitle("trackR");
		frmTrackr.setBackground(new Color(255, 255, 255));
		frmTrackr.setBounds(100, 100, 685, 564);
		frmTrackr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrackr.getContentPane().setLayout(null);
		
		lblxbFinalProject = new JLabel("2XB3 Final Project");
		lblxbFinalProject.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblxbFinalProject.setForeground(new Color(255, 140, 0));
		lblxbFinalProject.setBounds(12, 13, 127, 36);
		frmTrackr.getContentPane().add(lblxbFinalProject);
		
		lblErinVarey = new JLabel("Erin Varey");
		lblErinVarey.setForeground(new Color(255, 255, 0));
		lblErinVarey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblErinVarey.setBounds(449, 345, 73, 29);
		frmTrackr.getContentPane().add(lblErinVarey);
		
		lblJoshMitchell = new JLabel("Josh Mitchell");
		lblJoshMitchell.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJoshMitchell.setForeground(new Color(255, 255, 0));
		lblJoshMitchell.setBounds(449, 317, 117, 29);
		frmTrackr.getContentPane().add(lblJoshMitchell);
		
		lblNikNovak = new JLabel("Nik Novak");
		lblNikNovak.setForeground(new Color(255, 255, 0));
		lblNikNovak.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNikNovak.setBounds(449, 288, 117, 29);
		frmTrackr.getContentPane().add(lblNikNovak);
		
		lblMattShortt = new JLabel("Matt Shortt");
		lblMattShortt.setForeground(new Color(255, 255, 0));
		lblMattShortt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMattShortt.setBounds(449, 259, 117, 29);
		frmTrackr.getContentPane().add(lblMattShortt);
		
		lblPhillipPavlich = new JLabel("Phillip Pavlich");
		lblPhillipPavlich.setForeground(new Color(255, 255, 0));
		lblPhillipPavlich.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhillipPavlich.setBounds(449, 230, 117, 29);
		frmTrackr.getContentPane().add(lblPhillipPavlich);
		
		lblBroughtToYou = new JLabel("Brought to you by: ");
		lblBroughtToYou.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBroughtToYou.setForeground(new Color(0, 255, 127));
		lblBroughtToYou.setBounds(293, 201, 166, 47);
		frmTrackr.getContentPane().add(lblBroughtToYou);
		
		JButton btnPlaySong = newBtnPlaySong();
		frmTrackr.getContentPane().add(btnPlaySong);
		
		txtWelcomeToTrackr = new JTextField();
		txtWelcomeToTrackr.setBackground(SystemColor.inactiveCaptionBorder);
		txtWelcomeToTrackr.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtWelcomeToTrackr.setEditable(false);
		txtWelcomeToTrackr.setText("Welcome To trackR");
		txtWelcomeToTrackr.setBounds(246, 125, 186, 29);
		frmTrackr.getContentPane().add(txtWelcomeToTrackr);
		txtWelcomeToTrackr.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		Image musicPNG = new ImageIcon(this.getClass().getResource("/music-wallpaper.jpg")).getImage();
		label.setBounds(0, 0, 667, 517);
		label.setIcon(new ImageIcon(musicPNG));
		frmTrackr.getContentPane().add(label);
		
		
	}

	private JButton newBtnPlaySong() {
		btnPlaySong_1 = new JButton("Play Song");
		btnPlaySong_1.setBackground(SystemColor.activeCaption);
		btnPlaySong_1.setBounds(277, 368, 117, 29);
		btnPlaySong_1.setToolTipText("Click To Play Song");
		
		//niks code
		btnPlaySong_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTrackr.dispose();
				
				List<Song> allSongs = computeSimilarSongs.allSongs();
				int count=0;
				while(!MusicPlayer.getMP3(allSongs.get(count++).getTrack_7digitalid()));
				count--;
				
				System.out.println(allSongs.get(count).getArtist_name());
				MusicPlayer newPlayer = new MusicPlayer(allSongs.get(count));
				
				newPlayer.addExitListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						continued(allSongs);
					}
				});
					
				
				
			}
		});
		btnPlaySong_1.setForeground(new Color(204, 0, 102));
		return btnPlaySong_1;
	}
	
	private void continued(List<Song> allSongs){
		
		WindowsBuilderPractice run=new WindowsBuilderPractice(allSongs);
		run.QA(allSongs);
	}
	
	
}