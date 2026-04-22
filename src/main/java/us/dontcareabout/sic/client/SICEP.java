package us.dontcareabout.sic.client;

import com.google.gwt.user.client.Window;

import us.dontcareabout.gst.client.GSTEP;

public class SICEP extends GSTEP {
	public SICEP() {
		super("SIP-Key", "1NeArA5qG-OsBNvj82Z7bmkbXhul8SwdfTMxWZ_Oqa1E");
	}

	@Override
	protected String version() { return "0.0.1"; }

	@Override
	protected String defaultLocale() { return "zh_TW"; }

	@Override
	protected void featureFail() {
		Window.alert("這個瀏覽器我不尬意，不給用..... \\囧/");
	}

	@Override
	protected void start() {
	}
}
