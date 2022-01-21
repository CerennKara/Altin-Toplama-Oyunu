import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class endscreen extends JPanel {
	public JLabel lblTa,lblTb,lblTc,lblTd,lblCga,lblCgb,lblCgc,lblCgd,lblSa,lblSb,lblSc,lblSd,lblCa,lblCb,lblCc,lblCd;
	public JPanel contentPane= new JPanel();
	public endscreen() {
		setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBounds(0,0,979,530);
		
		JLabel lblPlayerA = new JLabel("PLAYER A");
		lblPlayerA.setBounds(58, 118, 74, 16);
		contentPane.add(lblPlayerA);
		
		JLabel lblPlayerB = new JLabel("PLAYER B");
		lblPlayerB.setBounds(58, 158, 74, 16);
		contentPane.add(lblPlayerB);
		
		JLabel lblNewLabel = new JLabel("PLAYER C");
		lblNewLabel.setBounds(58, 197, 74, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPlayerD = new JLabel("PLAYER D");
		lblPlayerD.setBounds(58, 237, 74, 16);
		contentPane.add(lblPlayerD);
		
		JLabel lblNewLabel_1 = new JLabel("ADIM SAYISI");
		lblNewLabel_1.setBounds(137, 70, 83, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HARCANAN ALTIN");
		lblNewLabel_2.setBounds(230, 70, 92, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblCaseGold = new JLabel("KASADAK\u0130 ALTIN");
		lblCaseGold.setBounds(332, 70, 99, 16);
		contentPane.add(lblCaseGold);
		
		JLabel lblCollectedGold = new JLabel("TOPLANAN ALTIN");
		lblCollectedGold.setBounds(441, 70, 119, 16);
		contentPane.add(lblCollectedGold);
		
		lblTa = new JLabel("T*A");
		lblTa.setBounds(166, 118, 34, 16);
		contentPane.add(lblTa);
		
		lblTb = new JLabel("T*B");
		lblTb.setBounds(166, 158, 34, 16);
		contentPane.add(lblTb);
		
		lblTc = new JLabel("T*C");
		lblTc.setBounds(166, 197, 34, 16);
		contentPane.add(lblTc);
		
		lblTd = new JLabel("T*D");
		lblTd.setBounds(166, 237, 34, 16);
		contentPane.add(lblTd);
		
		lblSa = new JLabel("S*A");
		lblSa.setBounds(266, 118, 56, 16);
		contentPane.add(lblSa);
		
		lblSb = new JLabel("S*B");
		lblSb.setBounds(266, 158, 56, 16);
		contentPane.add(lblSb);
		
		lblSc = new JLabel("S*C");
		lblSc.setBounds(266, 197, 56, 16);
		contentPane.add(lblSc);
		
		lblSd = new JLabel("S*D");
		lblSd.setBounds(266, 237, 56, 16);
		contentPane.add(lblSd);
		
		lblCa = new JLabel("C*A");
		lblCa.setBounds(363, 118, 34, 16);
		contentPane.add(lblCa);
		
		lblCb = new JLabel("C*B");
		lblCb.setBounds(363, 158, 34, 16);
		contentPane.add(lblCb);
		
		lblCc = new JLabel("C*C");
		lblCc.setBounds(363, 197, 34, 16);
		contentPane.add(lblCc);
		
		lblCd = new JLabel("C*D");
		lblCd.setBounds(363, 237, 34, 16);
		contentPane.add(lblCd);
		
		lblCga = new JLabel("CG*A");
		lblCga.setBounds(455, 118, 56, 16);
		contentPane.add(lblCga);
		
		lblCgb = new JLabel("CG*B");
		lblCgb.setBounds(455, 158, 56, 16);
		contentPane.add(lblCgb);
		
		lblCgc = new JLabel("CG*C");
		lblCgc.setBounds(455, 197, 56, 16);
		contentPane.add(lblCgc);
		
		lblCgd = new JLabel("CG*D");
		lblCgd.setBounds(455, 237, 56, 16);
		contentPane.add(lblCgd);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(1);
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 61));
		btnNewButton.setBounds(618, 308, 219, 103);
		contentPane.add(btnNewButton);
		
	}
}
