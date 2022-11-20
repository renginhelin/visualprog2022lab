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
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderList extends JFrame {

	private JPanel contentPane;
	static ArrayList<Order> orders = new ArrayList<Order>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderList frame = new OrderList();
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
	public OrderList() {
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
		
		orders.clear();
		File f1 = new File("C:\\Users\\User\\Desktop\\OrderList.txt");
		try {
			Scanner scan = new Scanner(f1);
			while(scan.hasNextLine()) {
				
				Order order = new Order();
				order.table = scan.nextLine();
				order.order = scan.nextLine();
				orders.add(order);
				
				list_model.removeAllElements();
				for(Order ordr : orders) {
					list_model.addElement(ordr.table);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Details:");
		lblNewLabel.setBounds(200, 50, 45, 13);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(200, 80, 218, 158);
		contentPane.add(textArea);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(328, 20, 85, 21);
		contentPane.add(btnBack);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Order order : orders) {
					if(list.getSelectedValue().toString().equals(order.table)) {
						textArea.setText("Order: \n"+order.order);
					}
			    }
			}
		});
	}
}
