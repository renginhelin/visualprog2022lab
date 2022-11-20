package fileödev;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Orders extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orders frame = new Orders();
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
	public Orders() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Table");
		lblNewLabel.setBounds(10, 26, 45, 13);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxTable = new JComboBox();
		comboBoxTable.setBounds(65, 22, 55, 21);
		contentPane.add(comboBoxTable);
		
		for(int i=1; i<=100; i++) {
			comboBoxTable.addItem(i);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Order:");
		lblNewLabel_1.setBounds(10, 80, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(42, 105, 115, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f1 = new File("C:\\Users\\User\\Desktop\\OrderList.txt");
				try {
					FileWriter fwrite = new FileWriter(f1,true);
					BufferedWriter bfwrite = new BufferedWriter(fwrite);
					
					bfwrite.write("Table "+String.valueOf(comboBoxTable.getSelectedItem().toString()));
					bfwrite.newLine();
					bfwrite.write(textField.getText());
					bfwrite.newLine();
					
					bfwrite.close();
					JOptionPane.showMessageDialog(contentPane, "Order Saved.");
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(133, 154, 85, 21);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 232, 85, 21);
		contentPane.add(btnExit);
		
		JButton btnOrders = new JButton("See Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderList orderlist = new OrderList();
				orderlist.setVisible(true);
			}
		});
		btnOrders.setBounds(229, 53, 108, 21);
		contentPane.add(btnOrders);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(229, 22, 85, 21);
		contentPane.add(btnBack);
		
	}
}
