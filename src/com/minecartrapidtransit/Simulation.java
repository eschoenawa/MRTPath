package com.minecartrapidtransit;

import java.util.ArrayList;

public class Simulation {

	public static String getShortestRoute (String startID, String endID) {
		ArrayList<NavNode> n = new ArrayList<NavNode>();
		n.add(new NavNode("RVM1-1", "Ocelot Bay"));
		n.add(new NavNode("RVM1-2", "RV Transit HUB Platforms A+B"));
		n.add(new NavNode("RVM1-3", "Main street"));
		n.add(new NavNode("RVM1-4", "Fountain District"));
		
		n.add(new NavNode("RVM2-1", "RV Transit HUB Platforms E+F"));
		n.add(new NavNode("RVM2-2", "City Hall"));
		
		
		n.get(0).addFollower(n.get(1), 50, Strings.type_RAIL);
		
		n.get(1).addFollower(n.get(2), 20, Strings.type_RAIL);
		n.get(1).addFollower(n.get(4), 10, Strings.type_FOOT);
		n.get(1).addFollower(n.get(0), 50, Strings.type_RAIL);
		
		n.get(2).addFollower(n.get(3), 25, Strings.type_RAIL);
		n.get(2).addFollower(n.get(1), 20, Strings.type_RAIL);
		
		n.get(3).addFollower(n.get(2), 25, Strings.type_RAIL);
		
		
		n.get(4).addFollower(n.get(1), 10, Strings.type_FOOT);
		n.get(4).addFollower(n.get(5), 30, Strings.type_RAIL);
		
		n.get(5).addFollower(n.get(4), 30, Strings.type_RAIL);
		
		Network net = new Network();
		net.replaceNodes(n);
		
		return Pathfinder.getShortestRoute(net, startID, endID);
	}

}
