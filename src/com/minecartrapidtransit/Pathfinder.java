package com.minecartrapidtransit;

import java.util.ArrayList;

public class Pathfinder {

	public static String getShortestRoute(Network n, String startID, String destID) {
		NavNode start = null;
		NavNode end = null;
		NavNode current = null;
		
		start = n.findByID(startID);
		end = n.findByID(destID);
		current = start;
		if (start == null || end == null)
			return "ERR:WrongID(s)";
		start.setDistanceToStart(0);
		
		while (current != null) {
			ArrayList<Connection> c = current.getConnections();
			for (int i = 0; i < c.size(); i++) {
				if(c.get(i).getNode().getDistanceToStart() == -1 || c.get(i).getNode().getDistanceToStart() > (current.getDistanceToStart() + c.get(i).getLength())) {
					c.get(i).getNode().setDistanceToStart(current.getDistanceToStart() + c.get(i).getLength());
					c.get(i).getNode().setPrev(current);
				}
			}
			current.setVisited(true);
			current = n.getNext();
		}
		
		current = end;
		String temp = "";
		while (current != start) {
			temp = "-" + current.getPrev().getConnectionByNavNode(current).getType() + "-" + current.getID() + temp;
			current = current.getPrev();
		}
		n.reset();
		return start.getID() + temp;
	}

}
