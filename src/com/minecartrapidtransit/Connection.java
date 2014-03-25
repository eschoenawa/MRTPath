package com.minecartrapidtransit;

import java.io.Serializable;

public class Connection implements Serializable {

	private int length;
	private NavNode node;
	private String type;
	private static final long serialVersionUID = 1L;
	
	public Connection(int pLength, NavNode pNode, String pType) {
		length = pLength;
		node = pNode;
		type = pType;
	}

	public int getLength() {
		return length;
	}

	public NavNode getNode() {
		return node;
	}

	public String getType() {
		return type;
	}
}

