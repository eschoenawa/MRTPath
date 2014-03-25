package com.minecartrapidtransit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Downloader {

	public static void download(String iNetLoc, String saveLoc) throws IOException {
		URL url = null;
		URLConnection con = null;
		int i;
		try {
			url = new URL(iNetLoc);
			con = url.openConnection();
			File file = new File(saveLoc);
			BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName()));
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
			bos.flush();
			bis.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("No Connection!");
		}
	}

}
