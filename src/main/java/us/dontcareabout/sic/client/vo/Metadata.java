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

	/**
	 * 以 {@link #getSerial()} 跟 {@link #getPage()} 的組合來作為 id。
	 * 就商業邏輯來說是不會重複的，有的話是 sheet 維護的責任不是程式的責任 XD
	 */
	public String getId() {
		return getSerial() + "_" + getPage();
	}
}
