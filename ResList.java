package fileödev;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fileJFrame.Student;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResList extends JFrame {

	private JPanel contentPane;
	static ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResList frame = new ResList();
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
	public ResList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> list_model = new DefaultListModel<String>();
		
		JList list = new JList(list_model);
		list.setBounds(23, 23, 168, 213);
		contentPane.add(list);
		
		reservations.clear();
		File f1 = new File("C:\\Users\\User\\Desktop\\ReservationList.txt");
		try {
			Scanner scan = new Scanner(f1);
			while(scan.hasNextLine()) {
				
				Reservation res = new Reservation();
				res.name = scan.nextLine();
				res.table = Integer.parseInt(scan.nextLine());
				res.day = Integer.parseInt(scan.nextLine());
				res.month = Integer.parseInt(scan.nextLine());
				res.hour = Integer.parseInt(scan.nextLine());
				res.min = Integer.parseInt(scan.nextLine());
				reservations.add(res);
				
				list_model.removeAllElements();
				for(Reservation rs : reservations) {
					list_model.addElement(rs.name);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(201, 74, 218, 158);
		contentPane.add(textArea);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Reservation res : reservations) {
					if(list.getSelectedValue().toString().equals(res.name)) {
						textArea.setText(res.name+"\nTable:"+res.table+" Date:"+res.day+"/"+res.month+"/2022 "+res.hour+":"+res.min);
					}
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Details:");
		lblNewLabel.setBounds(201, 55, 45, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(334, 20, 85, 21);
		contentPane.add(btnBack);
	}
}
