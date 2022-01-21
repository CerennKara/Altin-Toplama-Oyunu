import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class changescreen extends JPanel {

	public JPanel contentPane= new JPanel(); 
	public static JTextField targetA,targetB,targetC,targetD,moveA,moveB,moveC,moveD,goldRate,goldNumber,step;
	private JTextField width;
	private JTextField length;
	private JTextField hiddenGoldRate;
	private JLabel lblKareSays,lblAltnOran,lblKulancAltnSays,lblAdmSays,lblXEkseniUzunlugu,lblGizliAltnOran;
	public changescreen() {
		setLayout(null);
		contentPane.setLayout(null);
		contentPane.setBounds(0,0,979,530);
		
		targetA = new JTextField();
		targetA.setText("5");
		targetA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				targetA.setText("");
			}
		});
		targetA.setBounds(112, 146, 60, 22);
		contentPane.add(targetA);
		targetA.setColumns(10);
		
		moveA = new JTextField();
		moveA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				moveA.setText("");
			}
		});
		moveA.setText("5");
		moveA.setBounds(112, 187, 60, 22);
		contentPane.add(moveA);
		moveA.setColumns(10);
		
		JLabel lblAOyuncusuIin = new JLabel("A OYUNCUSU \u0130\u00C7\u0130N");
		lblAOyuncusuIin.setBounds(93, 114, 130, 22);
		contentPane.add(lblAOyuncusuIin);
		
		JLabel lblHedefMaliyet = new JLabel("Hedef Maliyet  : ");
		lblHedefMaliyet.setBounds(12, 149, 94, 16);
		contentPane.add(lblHedefMaliyet);
		
		JLabel lblAdmMaliyet = new JLabel("Hamle Maliyet  :");
		lblAdmMaliyet.setBounds(12, 190, 94, 16);
		contentPane.add(lblAdmMaliyet);
		
		JLabel lblBOyuncusuIin = new JLabel("B OYUNCUSU \u0130\u00C7\u0130N");
		lblBOyuncusuIin.setBounds(235, 114, 130, 22);
		contentPane.add(lblBOyuncusuIin);
		
		JLabel lblCOyuncusuIin = new JLabel("C OYUNCUSU \u0130\u00C7\u0130N");
		lblCOyuncusuIin.setBounds(399, 114, 130, 22);
		contentPane.add(lblCOyuncusuIin);
		
		JLabel lblDOyuncusuIin = new JLabel("D OYUNCUSU \u0130\u00C7\u0130N");
		lblDOyuncusuIin.setBounds(564, 114, 130, 22);
		contentPane.add(lblDOyuncusuIin);
		
		targetB = new JTextField();
		targetB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				targetB.setText("");
			}
		});
		targetB.setText("10");
		targetB.setBounds(245, 146, 60, 22);
		contentPane.add(targetB);
		targetB.setColumns(10);
		
		moveB = new JTextField();
		moveB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				moveB.setText("");
			}
		});
		moveB.setText("5");
		moveB.setBounds(245, 187, 60, 22);
		contentPane.add(moveB);
		moveB.setColumns(10);
		
		targetC = new JTextField();
		targetC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				targetC.setText("");
			}
		});
		targetC.setText("15");
		targetC.setBounds(409, 146, 60, 22);
		contentPane.add(targetC);
		targetC.setColumns(10);
		
		moveC = new JTextField();
		moveC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				moveC.setText("");
			}
		});
		moveC.setText("5");
		moveC.setBounds(409, 187, 60, 22);
		contentPane.add(moveC);
		moveC.setColumns(10);
		
		targetD = new JTextField();
		targetD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				targetD.setText("");
			}
		});
		targetD.setText("20");
		targetD.setBounds(574, 146, 60, 22);
		contentPane.add(targetD);
		targetD.setColumns(10);
		
		moveD = new JTextField();
		moveD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				moveD.setText("");
			}
		});
		moveD.setText("5");
		moveD.setBounds(574, 187, 60, 22);
		contentPane.add(moveD);
		moveD.setColumns(10);
		
		lblKareSays = new JLabel("Genislik  :");
		lblKareSays.setBounds(30, 273, 66, 16);
		contentPane.add(lblKareSays);
		
		lblAltnOran = new JLabel("Alt\u0131n Oran\u0131  :");
		lblAltnOran.setBounds(453, 273, 76, 16);
		contentPane.add(lblAltnOran);
		
		goldRate = new JTextField();
		goldRate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				goldRate.setText("");
			}
		});
		goldRate.setText("0.2");
		goldRate.setBounds(541, 270, 60, 22);
		contentPane.add(goldRate);
		goldRate.setColumns(10);
		
		lblKulancAltnSays = new JLabel("Alt\u0131n Say\u0131s\u0131  :");
		lblKulancAltnSays.setBounds(229, 273, 76, 16);
		contentPane.add(lblKulancAltnSays);
		
		goldNumber = new JTextField();
		goldNumber.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				goldNumber.setText("");
			}
		});
		goldNumber.setText("200");
		goldNumber.setBounds(338, 270, 60, 22);
		contentPane.add(goldNumber);
		goldNumber.setColumns(10);
		
		lblAdmSays = new JLabel("Ad\u0131m Say\u0131s\u0131  :");
		lblAdmSays.setBounds(224, 308, 94, 16);
		contentPane.add(lblAdmSays);
		
		step = new JTextField();
		step.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				step.setText("");
			}
		});
		step.setText("3");
		step.setBounds(338, 305, 60, 22);
		contentPane.add(step);
		step.setColumns(10);

		lblXEkseniUzunlugu = new JLabel("Uzunluk  :");
		lblXEkseniUzunlugu.setBounds(30, 308, 60, 16);
		contentPane.add(lblXEkseniUzunlugu);
		
		width = new JTextField();
		width.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				width.setText("");
			}
		});
		width.setText("20");
		width.setBounds(112, 270, 60, 22);
		contentPane.add(width);
		width.setColumns(10);
		
		length = new JTextField();
		length.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				length.setText("");
			}
		});
		length.setText("20");
		length.setBounds(112, 305, 60, 22);
		contentPane.add(length);
		length.setColumns(10);
		
		lblGizliAltnOran = new JLabel("Gizli Alt\u0131n Oran\u0131 :");
		lblGizliAltnOran.setBounds(430, 308, 94, 22);
		contentPane.add(lblGizliAltnOran);
		
		hiddenGoldRate = new JTextField();
		hiddenGoldRate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hiddenGoldRate.setText("");
			}
		});
		hiddenGoldRate.setText("0.1");
		hiddenGoldRate.setBounds(541, 308, 60, 22);
		contentPane.add(hiddenGoldRate);
		hiddenGoldRate.setColumns(10);
		
		JButton btnNewButton = new JButton("BASLA");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				gamescreen gs=new gamescreen(Integer.parseInt(width.getText()),Integer.parseInt(length.getText()),Double.parseDouble(goldRate.getText()),Double.parseDouble(hiddenGoldRate.getText()),2);
				screen.frame.setBounds(10,10,Integer.parseInt(width.getText())*34,Integer.parseInt(length.getText())*34);
				gamescreen.contentPane.setBounds(0,0,Integer.parseInt(width.getText())*34,Integer.parseInt(length.getText())*34);
				contentPane.add(gamescreen.contentPane);
				contentPane.revalidate(); 
				contentPane.repaint();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(564, 361, 239, 107);
		contentPane.add(btnNewButton);
	}
}
