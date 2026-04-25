package us.dontcareabout.sic.client.util;

import us.dontcareabout.sic.client.vo.Metadata;

public class ImageHost {
	//XXX 沒時間了，先寫死
	public static final String HOST = "https://montypan.github.io/SIC";
	public static final String TOC = "/toc";
	public static final String PAGE = "/page";

	public static String toc(int serial, int index) {
		return HOST + TOC + "/" + serial + "-" + index + ".jpg";
	}

	public static String page(Metadata md, int index) {
		return HOST + PAGE + "/" + md.getId() + "/" + index + ".jpg";
	}
}
