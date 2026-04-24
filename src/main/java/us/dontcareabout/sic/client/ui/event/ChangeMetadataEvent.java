package us.dontcareabout.sic.client.ui.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import us.dontcareabout.sic.client.ui.event.ChangeMetadataEvent.ChangeMetadataHandler;

public class ChangeMetadataEvent extends GwtEvent<ChangeMetadataHandler> {
	public static final Type<ChangeMetadataHandler> TYPE = new Type<ChangeMetadataHandler>();

	@Override
	public Type<ChangeMetadataHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ChangeMetadataHandler handler) {
		handler.onChangeMetadata(this);
	}

	public interface ChangeMetadataHandler extends EventHandler{
		public void onChangeMetadata(ChangeMetadataEvent event);
	}
}
