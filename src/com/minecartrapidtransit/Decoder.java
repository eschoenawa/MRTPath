package com.minecartrapidtransit;

import java.util.ArrayList;

public class Decoder {

	public static ArrayList<String> getRoute(Network n, String startID, String destID) {
		String[] raw = Pathfinder.getShortestRoute(n, startID, destID).split("\\-");
		ArrayList<String> s = new ArrayList<String>();
		String end = raw[raw.length - 1];
		String prev = "";
		for (int i = 0; i < raw.length; i++) {
			if (raw[i] == end) {
				break;
			}
			else {
				if (raw [i+1].equals(Strings.type_FOOT)) {
					prev = "";
					s.add(Strings.dec_walk + raw [i+2] + Strings.ui_seperator + n.findByID(raw [i+2]).getName() + Strings.dec_end);
				}
				else {
					if (!prev.equals(raw [i+1])) {
						s.add(Strings.dec_take1 + raw [i+1] + Strings.dec_take2 + raw [i+2] + Strings.ui_seperator + n.findByID(raw [i+2]).getName() + Strings.dec_end);
						prev = raw [i+1];
					}
					else {
						s.remove(s.size() - 1);
						s.add(Strings.dec_take1 + prev + Strings.dec_take2 + raw [i+2] + Strings.ui_seperator + n.findByID(raw [i+2]).getName() + Strings.dec_end);
					}
				}
				i++;
			}
		}
		return s;
	}

}
