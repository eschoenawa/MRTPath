package com.minecartrapidtransit;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class BasicRouteFinder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	
	private Network n;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicRouteFinder frame = new BasicRouteFinder();
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
	public BasicRouteFinder() {
		super("Testing Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(0, 132, 434, 130);
		contentPane.add(textArea);
		
		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File (Strings.network_PATH);
				if (f.exists() && !f.isDirectory()) {
					n = Network.load(Strings.network_PATH);
					String[] s = ((String) (comboBox.getSelectedItem())).split("\\:");
					String[] s2 = ((String) (comboBox_1.getSelectedItem())).split("\\:");
					textArea.setText(Pathfinder.getShortestRoute(n, s[0], s2[0]));
					ArrayList<NavNode> temp = n.getNodes();
					contentPane.remove(comboBox);
					contentPane.remove(comboBox_1);
					comboBox = new JComboBox<String>();
					comboBox.setBounds(10, 11, 414, 20);
					contentPane.add(comboBox);
					comboBox_1 = new JComboBox<String>();
					comboBox_1.setBounds(10, 67, 414, 20);
					contentPane.add(comboBox_1);
					for (int i = 0; i < temp.size(); i++) {
						comboBox.addItem(temp.get(i).getID() + ":" + temp.get(i).getName());
						comboBox_1.addItem(temp.get(i).getID() + ":" + temp.get(i).getName());
					}
				}
				else {
					textArea.setText("No valid network found!");
				}
			}
		});
		btnFind.setBounds(168, 98, 89, 23);
		contentPane.add(btnFind);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 11, 414, 20);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(10, 67, 414, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(211, 42, 46, 14);
		contentPane.add(lblTo);
		
		File f = new File (Strings.network_PATH);
		if (f.exists() && !f.isDirectory()) {
			n = Network.load(Strings.network_PATH);
			ArrayList<NavNode> temp = n.getNodes();
			contentPane.remove(comboBox);
			contentPane.remove(comboBox_1);
			comboBox = new JComboBox<String>();
			comboBox.setBounds(10, 11, 414, 20);
			contentPane.add(comboBox);
			comboBox_1 = new JComboBox<String>();
			comboBox_1.setBounds(10, 67, 414, 20);
			contentPane.add(comboBox_1);
			for (int i = 0; i < temp.size(); i++) {
				comboBox.addItem(temp.get(i).getID() + ":" + temp.get(i).getName());
				comboBox_1.addItem(temp.get(i).getID() + ":" + temp.get(i).getName());
			}
		}
		else {
			textArea.setText("No valid network found!");
		}
	}
}
