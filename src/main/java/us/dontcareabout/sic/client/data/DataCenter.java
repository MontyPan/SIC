package us.dontcareabout.sic.client.data;

import java.util.HashMap;
import java.util.List;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

import us.dontcareabout.gst.client.data.ApiKey;
import us.dontcareabout.gst.client.data.SheetIdDao;
import us.dontcareabout.gwt.client.google.sheet.Sheet;
import us.dontcareabout.gwt.client.google.sheet.SheetDto;
import us.dontcareabout.gwt.client.google.sheet.SheetDto.Callback;
import us.dontcareabout.sic.client.data.event.MetadataReadyEvent;
import us.dontcareabout.sic.client.data.event.MetadataReadyEvent.MetadataReadyHandler;
import us.dontcareabout.sic.client.vo.Metadata;
import us.dontcareabout.sic.client.vo.MetadataValidator;

public class DataCenter {
	private final static SimpleEventBus eventBus = new SimpleEventBus();

	public static List<Metadata> metadataList;
	public static HashMap<Metadata, List<Throwable>> metadataErrors;

	public static HandlerRegistration addMetadataReady(MetadataReadyHandler handler) {
		return eventBus.addHandler(MetadataReadyEvent.TYPE, handler);
	}

	public static void wantMetadata() {
		new SheetDto<Metadata>().key(ApiKey.jsValue())
				.sheetId(SheetIdDao.priorityValue()).tabName("Metadata")
				.validator(new MetadataValidator())
				.fetch(
			new Callback<Metadata>() {
				@Override
				public void onSuccess(Sheet<Metadata> result) {
					metadataList = result.getRows();
					metadataErrors = result.getErrors();
					eventBus.fireEvent(new MetadataReadyEvent());
				}
		});
	}
}
