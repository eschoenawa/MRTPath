package com.minecartrapidtransit;

import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Network n;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JLabel label_1;
	private JLabel lblERR_1;
	private JLabel lblERR_2;
	
	private boolean set1;
	private boolean set2;
	
	private int pos;
	
	private ArrayList<String> directions;
	private JButton button;
	private JButton button_1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
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
	public UserInterface() {
		super(Strings.ui_title);
		set1 = false;
		set2 = false;
		directions = null;
		pos = 0;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
				textField_1.requestFocus();
			}
		});
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				reload();
			}
			@Override
			public void focusGained(FocusEvent e) {
				set1 = false;
			}
		});
		textField.setBounds(10, 46, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel(Strings.ui_firstnode);
		lblNewLabel.setBounds(10, 21, 414, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reload();
				calc();
			}
		});
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				reload();
			}
			@Override
			public void focusGained(FocusEvent e) {
				set2 = false;
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(10, 174, 414, 20);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel(Strings.ui_secondnode);
		label.setBounds(10, 149, 414, 14);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton(Strings.ui_calc);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calc();
			}
		});
		btnNewButton.setBounds(10, 277, 100, 23);
		contentPane.add(btnNewButton);
		
		label_1 = new JLabel(Strings.ui_result);
		label_1.setBounds(10, 332, 414, 14);
		contentPane.add(label_1);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(10, 357, 414, 56);
		contentPane.add(textArea);
		
		button = new JButton(Strings.ui_next);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos++;
				reload();
			}
		});
		button.setEnabled(false);
		button.setBounds(324, 424, 100, 23);
		contentPane.add(button);
		
		button_1 = new JButton(Strings.ui_prev);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos--;
				reload();
			}
		});
		button_1.setEnabled(false);
		button_1.setBounds(214, 424, 100, 23);
		contentPane.add(button_1);
		
		lblERR_1 = new JLabel("");
		lblERR_1.setForeground(Color.RED);
		lblERR_1.setBounds(10, 77, 414, 14);
		contentPane.add(lblERR_1);
		
		lblERR_2 = new JLabel("");
		lblERR_2.setForeground(Color.RED);
		lblERR_2.setBounds(10, 205, 414, 14);
		contentPane.add(lblERR_2);
		
		try {
			Downloader.download(Strings.dropbox_PATH_NETWORK, Strings.network_PATH);
		} catch (IOException e1) {
			this.setTitle(Strings.ui_title + " (offline)");
			e1.printStackTrace();
		}
		
		reload();
	}
	
	private void reload() {
		n = Network.load(Strings.network_PATH);
		if (!textField.getText().equals("")) {
			boolean found = false;
			ArrayList<NavNode> temp = n.getNodes();
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).getID().equals(textField.getText()) || temp.get(i).getName().startsWith(textField.getText()) || (temp.get(i).getID() + Strings.ui_seperator + temp.get(i).getName()).startsWith(textField.getText())) {
					textField.setText(temp.get(i).getID() + Strings.ui_seperator + temp.get(i).getName());
					found = true;
					set1 = true;
					lblERR_1.setText("");
				}
			}
			if (!found) {
				set1 = false;
				lblERR_1.setText(Strings.ui_notFound);
			}
		}
		if (!textField_1.getText().equals("")) {
			boolean found = false;
			ArrayList<NavNode> temp = n.getNodes();
			for (int i = 0; i < temp.size(); i++) {
				if (temp.get(i).getID().equals(textField_1.getText()) || temp.get(i).getName().startsWith(textField_1.getText()) || (temp.get(i).getID() + Strings.ui_seperator + temp.get(i).getName()).startsWith(textField_1.getText())) {
					textField_1.setText(temp.get(i).getID() + Strings.ui_seperator + temp.get(i).getName());
					found = true;
					set2 = true;
					lblERR_2.setText("");
				}
			}
			if (!found) {
				set2 = false;
				lblERR_2.setText(Strings.ui_notFound);
			}
		}
		if (button.isEnabled() || button_1.isEnabled()) {
			textArea.setText(directions.get(pos));
			button.setEnabled(true);
			button_1.setEnabled(true);
			if (pos == 0) {
				button_1.setEnabled(false);
			}
			else if (pos == directions.size() - 1) {
				button.setEnabled(false);
			}
		}
	}
	
	private void calc() {
		if (set1 && set2) {
			directions = Decoder.getRoute(n, textField.getText().split("\\:") [0], textField_1.getText().split("\\:") [0]);
			pos = 0;
			try {
				textArea.setText(directions.get(pos));
			}
			catch (Exception e) {
				textArea.setText(Strings.ui_same);
			}
			button.setEnabled(true);
			button_1.setEnabled(true);
			if (directions.size() <= 1) {
				button.setEnabled(false);
				button_1.setEnabled(false);
			}
			reload();
		}
	}
}
