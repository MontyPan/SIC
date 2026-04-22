package us.dontcareabout.sic.client.vo;

import java.util.List;

import com.google.common.collect.Lists;

import us.dontcareabout.gwt.client.google.sheet.Validator;

public class MetadataValidator implements Validator<Metadata> {
	@Override
	public List<Throwable> validate(Metadata meta) {
		List<Throwable> result = Lists.newArrayList();
		try { meta.getSerial(); } catch (Throwable e) { result.add(new Throwable("刊數")); }
		try { meta.getImgAmount(); } catch (Throwable e) { result.add(new Throwable("圖片數量")); }
		return result;
	}
}