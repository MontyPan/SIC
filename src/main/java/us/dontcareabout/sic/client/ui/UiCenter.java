package us.dontcareabout.sic.client.ui;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

import us.dontcareabout.sic.client.ui.event.ChangeMetadataEvent;
import us.dontcareabout.sic.client.ui.event.ChangeMetadataEvent.ChangeMetadataHandler;
import us.dontcareabout.sic.client.ui.event.ChangeTocEvent;
import us.dontcareabout.sic.client.ui.event.ChangeTocEvent.ChangeTocHandler;
import us.dontcareabout.sic.client.vo.Metadata;

public class UiCenter {
	private final static SimpleEventBus eventBus = new SimpleEventBus();

	public static int selectToc;
	public static Metadata selectMetadata;

	public static void change(int toc) {
		selectToc = toc;
		eventBus.fireEvent(new ChangeTocEvent());
	}

	public static HandlerRegistration addChangeToc(ChangeTocHandler handler) {
		return eventBus.addHandler(ChangeTocEvent.TYPE, handler);
	}

	public static void change(Metadata metadata) {
		selectMetadata = metadata;
		eventBus.fireEvent(new ChangeMetadataEvent());
	}

	public static HandlerRegistration addChangeMetadata(ChangeMetadataHandler handler) {
		return eventBus.addHandler(ChangeMetadataEvent.TYPE, handler);
	}
}
