package render;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> entities;

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, new Comparator<IRenderable>() {

			@Override
			public int compare(IRenderable arg0, IRenderable arg1) {
				if (arg0.getZ() > arg1.getZ())
					return 1;
				return -1;
			}
		});
		if(entities.size() != 0){
		for(IRenderable entityq : entities){
			if(entityq.isDestroyed()){
				entities.remove(entityq);
			}
		}
		}
	}

	public List<IRenderable> getRenderableList() {
		return entities;
	}
}
