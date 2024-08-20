package sokoban;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;




import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainGame extends javax.swing.JFrame {
	Maps maps;
	File file;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGame frame = new MainGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public MainGame() throws IOException {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 28, 332, 511);
		getContentPane().add(panel);
		panel.setLayout(null);
		
	
		panel.setBackground(Color.CYAN);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		JPanel panel_1 = new JPanel();
		panel_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
					maps.PrintMotion("r");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
					maps.PrintMotion("l");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_UP){
					maps.PrintMotion("u");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
					maps.PrintMotion("d");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_ALT){
					maps.restartLevel();
				}
			}
		});
		panel_1.setBackground(Color.lightGray);
		panel_1.setBounds(379, 28, 703, 511);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SOKOBAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(91, 61, 147, 69);
		panel.add(lblNewLabel);
		
		JLabel lblPerintah = new JLabel("ctr");
		lblPerintah.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPerintah.setBounds(250, 239, 24, 16);
		panel.add(lblPerintah);
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
					}
				else if(arg0.getKeyCode()==KeyEvent.VK_CONTROL){
					JFileChooser fileChooser_1 = new JFileChooser();
					fileChooser_1.setCurrentDirectory(new File(System.getProperty("user.home")));
					int result = fileChooser_1.showOpenDialog(panel_1);
					if (result == JFileChooser.APPROVE_OPTION) {
					    File file = fileChooser_1.getSelectedFile();
					    panel_1.removeAll();
					    panel_1.revalidate();
					    panel_1.repaint();
					    maps=new Maps (file);
						panel_1.add(maps);
						maps.setSize(maps.getWidth(),maps.getHigh());
						
						int width = panel_1.getWidth();
						int high = panel_1.getHeight();
						
						int x=(width - maps.getWidth())/2;
						int y = (high - maps.getHigh())/2;
						maps.setLocation(x, y);
					
					}
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
					maps.PrintMotion("r");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
					maps.PrintMotion("l");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_UP){
					maps.PrintMotion("u");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
					maps.PrintMotion("d");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_ALT){
					maps.restartLevel();
				}
				
			}
		});
		
		JLabel lblOutput = new JLabel("alt");
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOutput.setBounds(250, 359, 17, 16);
		panel.add(lblOutput);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				maps.restartLevel();
			}
		});
		btnRestart.setFocusable(true);
		btnRestart.requestFocusInWindow();
		btnRestart.setBounds(91, 290, 147, 85);
		panel.add(btnRestart);
		
		btnRestart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
					}
				else if(arg0.getKeyCode()==KeyEvent.VK_CONTROL){
					JFileChooser fileChooser_1 = new JFileChooser();
					fileChooser_1.setCurrentDirectory(new File(System.getProperty("user.home")));
					int result = fileChooser_1.showOpenDialog(panel_1);
					if (result == JFileChooser.APPROVE_OPTION) {
					    File file = fileChooser_1.getSelectedFile();
					    panel_1.removeAll();
					    panel_1.revalidate();
					    panel_1.repaint();
					    maps=new Maps (file);
						panel_1.add(maps);
						maps.setSize(maps.getWidth(),maps.getHigh());
						
						int width = panel_1.getWidth();
						int high = panel_1.getHeight();
						
						int x=(width - maps.getWidth())/2;
						int y = (high - maps.getHigh())/2;
						maps.setLocation(x, y);
					
					}
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
					maps.PrintMotion("r");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
					maps.PrintMotion("l");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_UP){
					maps.PrintMotion("u");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
					maps.PrintMotion("d");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_ALT){
					maps.restartLevel();
				}
				
			}
		});
		
		
		JButton btnOpenNewGame = new JButton("Open level");
		btnOpenNewGame.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnOpenNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser_1 = new JFileChooser();
				fileChooser_1.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser_1.showOpenDialog(panel_1);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File file = fileChooser_1.getSelectedFile();
				    panel_1.removeAll();
				    panel_1.revalidate();
				    panel_1.repaint();
				    maps=new Maps (file);
					panel_1.add(maps);
					maps.setSize(maps.getWidth(),maps.getHigh());
					
					int width = panel_1.getWidth();
					int high = panel_1.getHeight();
					
					int x=(width - maps.getWidth())/2;
					int y = (high - maps.getHigh())/2;
					maps.setLocation(x, y);
				}
				
				
				
			}
		});
		btnOpenNewGame.setFocusable(true);
		btnOpenNewGame.requestFocusInWindow();
		btnOpenNewGame.setBounds(87, 170, 151, 85);
		panel.add(btnOpenNewGame);
		
		JLabel lblEscForExit = new JLabel("Esc for exit");
		lblEscForExit.setBounds(12, 482, 70, 16);
		panel.add(lblEscForExit);
		
		btnOpenNewGame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
					}
				else if(arg0.getKeyCode()==KeyEvent.VK_CONTROL){
					JFileChooser fileChooser_1 = new JFileChooser();
					fileChooser_1.setCurrentDirectory(new File(System.getProperty("user.home")));
					int result = fileChooser_1.showOpenDialog(panel_1);
					if (result == JFileChooser.APPROVE_OPTION) {
					    File file = fileChooser_1.getSelectedFile();
					    panel_1.removeAll();
					    panel_1.revalidate();
					    panel_1.repaint();
					    maps=new Maps (file);
						panel_1.add(maps);
						maps.setSize(maps.getWidth(),maps.getHigh());
						
						int width = panel_1.getWidth();
						int high = panel_1.getHeight();
						
						int x=(width - maps.getWidth())/2;
						int y = (high - maps.getHigh())/2;
						maps.setLocation(x, y);
					
					}
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
					maps.PrintMotion("r");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
					maps.PrintMotion("l");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_UP){
					maps.PrintMotion("u");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
					maps.PrintMotion("d");
				}
				else if(arg0.getKeyCode()==KeyEvent.VK_ALT){
					maps.restartLevel();
				}
				
			}
		});
		
	
	
		
	}
}
