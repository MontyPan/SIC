package us.dontcareabout.sic.client.vo;

import us.dontcareabout.gwt.client.google.sheet.Row;

public final class Metadata extends Row {
	protected Metadata() {}

	public int getSerial() {
		return intField("刊數");
	}

	public String getName() {
		return stringField("文章名稱");
	}

	public String getPage() {
		return stringField("文章頁數");
	}

	public int getImgAmount() {
		return intField("圖片數量");
	}
}
