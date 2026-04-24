package us.dontcareabout.sic.client.ui;

import java.util.List;

import com.google.common.collect.Lists;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.GridView;
import com.sencha.gxt.widget.core.client.grid.GroupingView;

import us.dontcareabout.gxt.client.component.Grid2;
import us.dontcareabout.gxt.client.model.GetValueProvider;
import us.dontcareabout.gxt.client.util.ColumnConfigBuilder;
import us.dontcareabout.sic.client.data.DataCenter;
import us.dontcareabout.sic.client.vo.Metadata;

public class MetadataGrid extends Grid2<Metadata> {
	private ColumnConfig<Metadata, Integer> serialCC = new ColumnConfigBuilder<Metadata, Integer> (
		new GetValueProvider<Metadata, Integer>() {
			@Override
			public Integer getValue(Metadata object) {
				return object.getSerial();
			}

			@Override
			public String getPath() { return ""; }	//XXX 等 GF 改版後刪除
		}
	).setHeader("刊數").build();

	public MetadataGrid() {
		init();
	}

	@Override
	protected ListStore<Metadata> genListStore() {
		ListStore<Metadata> result = new ListStore<>(m -> m.getId());
		return result;
	}

	@Override
	protected ColumnModel<Metadata> genColumnModel() {
		List<ColumnConfig<Metadata, ?>> result = Lists.newArrayList();
		result.add(serialCC);
		result.add(
			new ColumnConfigBuilder<Metadata, String>(
				new GetValueProvider<Metadata, String>() {
					@Override
					public String getValue(Metadata object) {
						return object.getPage();
					}
				}
			).setHeader("頁數").setWidth(50).build()
		);
		result.add(
			new ColumnConfigBuilder<Metadata, String>(
				new GetValueProvider<Metadata, String>() {
					@Override
					public String getValue(Metadata object) {
						return object.getName();
					}
				}
			).setHeader("文章標題").setWidth(200).build()
		);
		return new ColumnModel<>(result);
	}

	@Override
	protected GridView<Metadata> genGridView() {
		GroupingView<Metadata> result = new GroupingView<>();
		result.setForceFit(true);
		result.setShowGroupedColumn(false);
		result.groupBy(serialCC);
		return result;
	}

	public void refresh() {
		getStore().replaceAll(DataCenter.metadataList);
	}
}
