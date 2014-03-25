package com.minecartrapidtransit;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Creator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
	private JLabel label_1;
	private JLabel lblNewLabel_2;
	private JLabel label_2;
	private JComboBox<String> comboBox_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JButton button;
	private JButton btnNewButton_1;
	
	private Network n;
	private JComboBox<String> comboBox;
	private JLabel label_3;
	private JTextField textField_3;
	private JCheckBox chckbxDoubleWay;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JCheckBox chckbxRemoveConnection;
	private JComboBox<String> comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creator frame = new Creator();
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
	public Creator() {
		super(Strings.creator_title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.requestFocus();
			}
		});
		textField.setBounds(30, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(Strings.creator_toplabel);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		label = new JLabel(Strings.creator_enterid);
		label.setBounds(30, 38, 318, 14);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNode();
				textField.requestFocus();
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(30, 119, 318, 20);
		contentPane.add(textField_1);
		
		label_1 = new JLabel(Strings.creator_entername);
		label_1.setBounds(30, 94, 318, 14);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton(Strings.creator_btncreate);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNode();
			}
		});
		btnNewButton.setBounds(10, 150, 89, 23);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.requestFocus();
			}
		});
		comboBox.setBounds(30, 246, 318, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel(Strings.creator_lowertoplabel);
		lblNewLabel_1.setBounds(10, 184, 338, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(Strings.creator_firstNode);
		lblNewLabel_2.setBounds(30, 221, 318, 14);
		contentPane.add(lblNewLabel_2);
		
		label_2 = new JLabel(Strings.creator_secondNode);
		label_2.setBounds(30, 282, 318, 14);
		contentPane.add(label_2);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.requestFocus();
			}
		});
		comboBox_1.setBounds(30, 307, 318, 20);
		contentPane.add(comboBox_1);
		
		lblNewLabel_3 = new JLabel(Strings.creator_distance);
		lblNewLabel_3.setBounds(30, 338, 318, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createConnection();
				textField_2.requestFocus();
				//textField_3.requestFocus();
			}
		});
		textField_2.setBounds(30, 363, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		button = new JButton(Strings.creator_btncreate);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createConnection();
			}
		});
		button.setBounds(10, 394, 89, 23);
		contentPane.add(button);
		
		btnNewButton_1 = new JButton(Strings.creator_write);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n.save(Strings.network_PATH);
			}
		});
		btnNewButton_1.setBounds(10, 628, 89, 23);
		contentPane.add(btnNewButton_1);
		
		label_3 = new JLabel(Strings.creator_type);
		label_3.setBounds(208, 338, 226, 14);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createConnection();
				comboBox.requestFocus();
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(208, 363, 140, 20);
		contentPane.add(textField_3);
		
		chckbxDoubleWay = new JCheckBox("Double way");
		chckbxDoubleWay.setBounds(208, 428, 97, 23);
		contentPane.add(chckbxDoubleWay);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(208, 395, 140, 20);
		contentPane.add(textField_4);
		
		JLabel lblReversed = new JLabel("Reversed");
		lblReversed.setBounds(137, 398, 61, 14);
		contentPane.add(lblReversed);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(30, 458, 318, 20);
		contentPane.add(comboBox_2);
		
		chckbxRemoveConnection = new JCheckBox("Remove Connections");
		chckbxRemoveConnection.setBounds(158, 541, 165, 23);
		contentPane.add(chckbxRemoveConnection);
		
		textField_5 = new JTextField();
		textField_5.setBounds(30, 514, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(30, 568, 318, 20);
		contentPane.add(textField_6);
		
		JLabel label_4 = new JLabel("Enter Node's ID:");
		label_4.setBounds(30, 489, 318, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Enter Node's Name:");
		label_5.setBounds(30, 545, 318, 14);
		contentPane.add(label_5);
		
		JButton btnRecreate = new JButton("Recreate!");
		btnRecreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recreate();
			}
		});
		btnRecreate.setBounds(259, 599, 89, 23);
		contentPane.add(btnRecreate);
		
		JButton btnRebuild = new JButton("Rebuild");
		btnRebuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rebuild();
			}
		});
		btnRebuild.setBounds(335, 150, 89, 23);
		contentPane.add(btnRebuild);
		
		reload();
	}
	
	public void reload() {
		File f = new File (Strings.network_PATH);
		if (f.exists() && !f.isDirectory()) {
			n = Network.load(Strings.network_PATH);
			ArrayList<NavNode> temp = n.getNodes();
			contentPane.remove(comboBox);
			contentPane.remove(comboBox_1);
			contentPane.remove(comboBox_2);
			comboBox = new JComboBox<String>();
			comboBox.setBounds(30, 246, 318, 20);
			contentPane.add(comboBox);
			comboBox_1 = new JComboBox<String>();
			comboBox_1.setBounds(30, 307, 318, 20);
			contentPane.add(comboBox_1);
			comboBox_2 = new JComboBox<String>();
			comboBox_2.setBounds(30, 458, 318, 20);
			contentPane.add(comboBox_2);
			for (int i = 0; i < temp.size(); i++) {
				comboBox.addItem(temp.get(i).getID() + ":" + temp.get(i).getName());
				comboBox_1.addItem(temp.get(i).getID() + ":" + temp.get(i).getName());
				comboBox_2.addItem(temp.get(i).getID() + ":" + temp.get(i).getName());
			}
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
		}
		else {
			n = new Network();
		}
		
	}
	
	public void createNode() {
		NavNode nn = new NavNode(textField.getText(), textField_1.getText());
		ArrayList<NavNode> nnl = n.getNodes();
		nnl.add(nn);
		n.replaceNodes(nnl);
		n.save(Strings.network_PATH);
		reload();
	}
	
	public void createConnection() {
		String[] s = ((String) (comboBox.getSelectedItem())).split("\\:");
		String[] s2 = ((String) (comboBox_1.getSelectedItem())).split("\\:");
		NavNode nn1 = n.findByID(s[0]);
		NavNode nn2 = n.findByID(s2[0]);
		if (nn1 == null || nn2 == null) {
			textField.setText("ERR:WrongStation");
		}
		else {
			nn1.addFollower(nn2, Integer.parseInt(textField_2.getText()), textField_3.getText());
			if (chckbxDoubleWay.isSelected()) {
				nn2.addFollower(nn1, Integer.parseInt(textField_2.getText()), textField_4.getText());
			}
		}
		n.save(Strings.network_PATH);
		textField_2.setText("");
		if (comboBox.getItemCount() > comboBox.getSelectedIndex()) {
			textField.setText(Integer.toString(comboBox.getItemCount()));
			comboBox.setSelectedIndex(comboBox.getSelectedIndex() + 1);
		}
		if (comboBox_1.getItemCount() > comboBox_1.getSelectedIndex()) {


		}
		//reload();
	}
	
	public void recreate() {
		int currentPos = comboBox_2.getSelectedIndex();
		if (!this.chckbxRemoveConnection.isSelected()) {
			n.findByID((String) (((String) comboBox_2.getSelectedItem()).split("\\:") [0])).setName(textField_6.getText());
			n.findByID((String) (((String) comboBox_2.getSelectedItem()).split("\\:") [0])).setID(textField_5.getText());
		}
		else if (this.chckbxRemoveConnection.isSelected()) {
			n.findByID((String) (((String) comboBox_2.getSelectedItem()).split("\\:") [0])).setName(textField_6.getText());
			n.findByID((String) (((String) comboBox_2.getSelectedItem()).split("\\:") [0])).setConnections(new ArrayList<Connection>());
			n.findByID((String) (((String) comboBox_2.getSelectedItem()).split("\\:") [0])).setID(textField_5.getText());
		}
		n.save(Strings.network_PATH);
		reload();
		comboBox_2.setSelectedIndex(currentPos + 1);
		textField_5.setText((((String) comboBox_2.getSelectedItem()).split("\\:") [0]));
		textField_6.setText((((String) comboBox_2.getSelectedItem()).split("\\:") [1]));
	}
	
	public void rebuild() {
		ArrayList<NavNode> nl = n.getNodes();
		for (int i = 0; i < nl.size(); i++) {
			ArrayList<Connection> temp = nl.get(i).getConnections();
			for (int j = 0; j < temp.size(); j++) {
				if (temp.get(j).getType().equals(Strings.type_FOOT)) {
					Connection old = temp.get(j);
					temp.remove(j);
					temp.add(j, new Connection(100, old.getNode(), old.getType()));
				}
			}
		}
	}
}
