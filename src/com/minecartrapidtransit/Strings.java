package com.minecartrapidtransit;

/**
 * This class provides default Strings so they can be changed at one place.
 * @author minecrafter0505
 * @version 1.0
 */
public class Strings {

	//Intern
	public static final String version_id = "1.0 beta";
	
	public static final String type_FOOT = "FOOT";
	public static final String type_RAIL = "RAIL";
	public static final String type_BUS = "BUS";
	
	public static final String network_PATH = "./mrt.network";
	public static final String main_PATH = "./MRTPath.jar";
	public static final String dropbox_PATH_NETWORK = "http://dl.dropboxusercontent.com/u/44998952/MRTPath/mrt.network";
	public static final String dropbox_PATH_MAIN = "https://dl.dropboxusercontent.com/u/44998952/MRTPath/MRTPath.jar";

	//Extern
	public static final String creator_title = "Add to Network";
	public static final String creator_toplabel = "Add new Nodes to the network.";
	public static final String creator_enterid = "Enter Node's ID:";
	public static final String creator_entername = "Enter Node's Name:";
	public static final String creator_btncreate = "Create!";
	public static final String creator_lowertoplabel = "Add Connections between Nodes";
	public static final String creator_firstNode = "Select first Node:";
	public static final String creator_secondNode = "Select second Node:";
	public static final String creator_distance = "Assign a distance:";
	public static final String creator_write = "Write!";
	public static final String creator_type = "Assign a Type:";
	
	//UI
	public static final String ui_title = "MRTPath";
	public static final String ui_firstnode = "Enter start:";
	public static final String ui_secondnode = "Enter destination:";
	public static final String ui_calc = "Calculate!";
	public static final String ui_result = "Directions:";
	public static final String ui_next = "Next";
	public static final String ui_prev = "Previous";
	public static final String ui_notFound = "No matching Station found!";
	public static final String ui_same = "You are already there!";
	
	public static final String ui_seperator = ": ";
	
	//Decoding
	public static final String dec_walk = "Walk to '";
	public static final String dec_take1 = "Take the '";
	public static final String dec_take2 = "' until you arrive at '";
	public static final String dec_end = "'.";
}
