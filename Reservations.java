package fileödev;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Reservations extends JFrame {

	private JPanel contentPane;
	private JTextField txtResOwner;
	private JTextField textFieldDay;
	private JTextField textFieldMonth;
	private JTextField textFieldHour;
	private JTextField textFieldMin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservations frame = new Reservations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reservations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reservation Owner:");
		lblNewLabel.setBounds(21, 24, 131, 13);
		contentPane.add(lblNewLabel);
		
		txtResOwner = new JTextField();
		txtResOwner.setBounds(80, 47, 118, 19);
		contentPane.add(txtResOwner);
		txtResOwner.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Table:");
		lblNewLabel_1.setBounds(21, 95, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxTable = new JComboBox();
		comboBoxTable.setBounds(80, 91, 53, 21);
		contentPane.add(comboBoxTable);
		
		for(int i=1; i<=100; i++) {
			comboBoxTable.addItem(i);
		}
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setBounds(21, 149, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("/");
		lblNewLabel_3.setBounds(143, 149, 9, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("/");
		lblNewLabel_3_1.setBounds(221, 149, 9, 13);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("2022");
		lblNewLabel_4.setBounds(235, 149, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Time:");
		lblNewLabel_5.setBounds(21, 197, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(":");
		lblNewLabel_6.setBounds(143, 197, 9, 13);
		contentPane.add(lblNewLabel_6);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(300, 20, 85, 21);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 262, 75, 21);
		contentPane.add(btnExit);
		
		textFieldDay = new JTextField();
		textFieldDay.setBounds(80, 146, 53, 19);
		contentPane.add(textFieldDay);
		textFieldDay.setColumns(10);
		
		textFieldMonth = new JTextField();
		textFieldMonth.setColumns(10);
		textFieldMonth.setBounds(158, 146, 53, 19);
		contentPane.add(textFieldMonth);
		
		textFieldHour = new JTextField();
		textFieldHour.setColumns(10);
		textFieldHour.setBounds(80, 194, 53, 19);
		contentPane.add(textFieldHour);
		
		textFieldMin = new JTextField();
		textFieldMin.setColumns(10);
		textFieldMin.setBounds(158, 194, 53, 19);
		contentPane.add(textFieldMin);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f1 = new File("C:\\Users\\User\\Desktop\\ReservationList.txt");
				try {
					FileWriter fwrite = new FileWriter(f1,true);
					BufferedWriter bfwrite = new BufferedWriter(fwrite);
					
					bfwrite.write(txtResOwner.getText());
					bfwrite.newLine();
					bfwrite.write(String.valueOf(comboBoxTable.getSelectedItem().toString()));
					bfwrite.newLine();
					bfwrite.write(textFieldDay.getText());
					bfwrite.newLine();
					bfwrite.write(textFieldMonth.getText());
					bfwrite.newLine();
					bfwrite.write(textFieldHour.getText());
					bfwrite.newLine();
					bfwrite.write(textFieldMin.getText());
					bfwrite.newLine();
					bfwrite.close();
					JOptionPane.showMessageDialog(contentPane, "Reservation Saved.");
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(245, 236, 85, 21);
		contentPane.add(btnSave);
		
		JButton btnList = new JButton("See List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResList list = new ResList();
				list.setVisible(true);
			}
		});
		btnList.setBounds(300, 46, 85, 21);
		contentPane.add(btnList);
	}
}
