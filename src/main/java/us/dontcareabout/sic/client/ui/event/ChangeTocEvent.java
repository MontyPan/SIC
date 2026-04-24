package us.dontcareabout.sic.client.ui.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

import us.dontcareabout.sic.client.ui.event.ChangeTocEvent.ChangeTocHandler;

public class ChangeTocEvent extends GwtEvent<ChangeTocHandler> {
	public static final Type<ChangeTocHandler> TYPE = new Type<ChangeTocHandler>();

	@Override
	public Type<ChangeTocHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ChangeTocHandler handler) {
		handler.onChangeToc(this);
	}

	public interface ChangeTocHandler extends EventHandler{
		public void onChangeToc(ChangeTocEvent event);
	}
}
