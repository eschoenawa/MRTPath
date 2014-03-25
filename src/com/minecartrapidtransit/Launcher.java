package com.minecartrapidtransit;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Launcher {
	
	public static void main(String[] args) {
		try {
			Downloader.download(Strings.dropbox_PATH_MAIN, Strings.main_PATH);
			Downloader.download(Strings.dropbox_PATH_NETWORK, Strings.network_PATH);
		} catch (Exception e) {
			e.printStackTrace();
			File f1 = new File(Strings.main_PATH);
			File f2 = new File(Strings.network_PATH);
			if(f1.exists() && !f1.isDirectory() && f2.exists() && !f2.isDirectory()) {
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Cannot find important files! Please connect to the internet so they can be downloaded!");
			}
		}
		
		try {
			Runtime.getRuntime().exec(" java -jar " + Strings.main_PATH);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Impossible Error! Punch your PC!");
			ex.printStackTrace();
		}
	}

}
