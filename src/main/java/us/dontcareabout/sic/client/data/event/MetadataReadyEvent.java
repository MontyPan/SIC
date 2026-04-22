package us.dontcareabout.sic.client.data.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import us.dontcareabout.sic.client.data.event.MetadataReadyEvent.MetadataReadyHandler;

public class MetadataReadyEvent extends GwtEvent<MetadataReadyHandler> {
	public static final Type<MetadataReadyHandler> TYPE = new Type<MetadataReadyHandler>();

	@Override
	public Type<MetadataReadyHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(MetadataReadyHandler handler) {
		handler.onMetadataReady(this);
	}

	public interface MetadataReadyHandler extends EventHandler{
		public void onMetadataReady(MetadataReadyEvent event);
	}
}
