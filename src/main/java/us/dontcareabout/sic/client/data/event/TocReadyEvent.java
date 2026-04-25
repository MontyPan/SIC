package us.dontcareabout.sic.client.data.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import us.dontcareabout.sic.client.data.event.TocReadyEvent.TocReadyHandler;

public class TocReadyEvent extends GwtEvent<TocReadyHandler> {
	public static final Type<TocReadyHandler> TYPE = new Type<TocReadyHandler>();

	@Override
	public Type<TocReadyHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(TocReadyHandler handler) {
		handler.onTocReady(this);
	}

	public interface TocReadyHandler extends EventHandler{
		public void onTocReady(TocReadyEvent event);
	}
}
