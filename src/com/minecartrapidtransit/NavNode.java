package com.minecartrapidtransit;

import java.io.Serializable;
import java.util.ArrayList;

public class NavNode implements Serializable {
	private String ID;
	private String name;
	private ArrayList<Connection> connections;
	private boolean visited;
	private int distanceToStart;
	private NavNode prev;
	private static final long serialVersionUID = 1L;
	
	public NavNode(String pID, String pName) {
		super();
		ID = pID;
		this.name = pName;
		this.connections = new ArrayList<Connection>();
		visited = false;
		distanceToStart = -1;
		prev = null;
	}
	
	public NavNode(String pID, String pName, ArrayList<Connection> pConnections) {
		super();
		ID = pID;
		this.name = pName;
		this.connections = pConnections;
		visited = false;
		distanceToStart = -1;
		prev = null;
	}

	public void addFollower(NavNode pFollower, int pDistance, String pType) {
		this.connections.add(new Connection(pDistance, pFollower, pType));
	}
	
	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Connection> getConnections() {
		return connections;
	}
	
	public void setVisited(boolean pVisit) {
		visited = pVisit;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public int getDistanceToStart() {
		return distanceToStart;
	}

	public void setDistanceToStart(int distanceToStart) {
		this.distanceToStart = distanceToStart;
	}

	public NavNode getPrev() {
		return prev;
	}

	public void setPrev(NavNode prev) {
		this.prev = prev;
	}
	
	public Connection getConnectionByNavNode(NavNode nn) {
		for (int i = 0; i < connections.size(); i++) {
			if (connections.get(i).getNode() == nn)
				return connections.get(i);
		}
		return null;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setConnections(ArrayList<Connection> connections) {
		this.connections = connections;
	}
}
