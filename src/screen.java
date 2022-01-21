import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class screen extends JFrame {

	private JPanel contentPane;
	static screen frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

	public screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("BASLA");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gamescreen gs=new gamescreen(20,20,0.2,0.1,1);
				frame.setBounds(100,100,660,660);
				setContentPane(gs.contentPane);
			}
		});
		btnNewButton.setBounds(384, 157, 194, 68);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Degistir ve Basla");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changescreen cs=new changescreen();
				cs.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(cs.contentPane);
			}
		});
		btnNewButton_1.setBounds(407, 238, 142, 44);
		contentPane.add(btnNewButton_1);
	}
}