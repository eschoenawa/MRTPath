package com.minecartrapidtransit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Network implements Serializable {

	private ArrayList<NavNode> nodes;
	private static final long serialVersionUID = 1L;
	
	public Network() {
		nodes = new ArrayList<NavNode>();
	}

	public void replaceNodes(ArrayList<NavNode> pNodes) {
		nodes = pNodes;
	}

	public ArrayList<NavNode> getNodes() {
		return nodes;
	}
	
	public NavNode getNext() {
		NavNode temp = null;
		for (int i = 0; i < nodes.size(); i++) {
			if (!nodes.get(i).isVisited() && nodes.get(i).getDistanceToStart() != -1) {
				if (temp == null)
					temp = nodes.get(i);
				else if (temp.getDistanceToStart() >= nodes.get(i).getDistanceToStart())
					temp = nodes.get(i);
			}
		}
		return temp;
	}
	
	public NavNode findByID (String ID) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).getID().equals(ID))
				return nodes.get(i);
		}
		return null;
	}
	
	public void reset() {
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).setPrev(null);
			nodes.get(i).setDistanceToStart(-1);
			nodes.get(i).setVisited(false);
		}
	}
	
	public void save(String filename) {
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(this);
			oos.close();
		}
		catch (Exception ex) {
			   ex.printStackTrace();
		}
	}
	
	public static Network load(String filename) {
		FileInputStream fin;
		try {
			fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			Network loaded = (Network) ois.readObject();
			fin.close();
			return loaded;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
