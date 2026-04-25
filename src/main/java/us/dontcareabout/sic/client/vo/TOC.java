package us.dontcareabout.sic.client.vo;

import us.dontcareabout.gwt.client.google.sheet.Row;

public final class TOC extends Row {
	protected TOC() {}

	public int getSerial() {
		return intField("刊數");
	}

	public int getImgAmount() {
		return stringField("圖片數量").isEmpty() ? 1 : intField("圖片數量");
	}
}
