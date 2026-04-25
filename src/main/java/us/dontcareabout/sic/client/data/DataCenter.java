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
import us.dontcareabout.sic.client.data.event.TocReadyEvent;
import us.dontcareabout.sic.client.data.event.TocReadyEvent.TocReadyHandler;
import us.dontcareabout.sic.client.vo.Metadata;
import us.dontcareabout.sic.client.vo.MetadataValidator;
import us.dontcareabout.sic.client.vo.TOC;

public class DataCenter {
	private final static SimpleEventBus eventBus = new SimpleEventBus();

	public static List<Metadata> metadataList;
	public static HashMap<Metadata, List<Throwable>> metadataErrors;

	public static List<TOC> tocList;
	public static int firstToc;
	public static int lastToc;

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

	public static HandlerRegistration addTocReady(TocReadyHandler handler) {
		return eventBus.addHandler(TocReadyEvent.TYPE, handler);
	}

	public static void wantToc() {
		new SheetDto<TOC>().key(ApiKey.jsValue())
				.sheetId(SheetIdDao.priorityValue()).tabName("TOC")
				.fetch(
			new Callback<TOC>() {
				@Override
				public void onSuccess(Sheet<TOC> result) {
					tocList = result.getRows();

					firstToc = Integer.MAX_VALUE;
					lastToc = Integer.MIN_VALUE;
					//害怕 lambda 可能炸的 bug，所以自己掃 XD
					for (TOC toc : tocList) {
						if (toc.getSerial() < firstToc) { firstToc = toc.getSerial(); }
						if (toc.getSerial() > lastToc) { lastToc = toc.getSerial(); }
					}

					eventBus.fireEvent(new TocReadyEvent());
				}
			}
		);
	}
}
