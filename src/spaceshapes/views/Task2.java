package spaceshapes.views;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelEvent.EventType;
import spaceshapes.ShapeModelListener;

public class Task2 extends Task1 implements ShapeModelListener {

	public Task2(ShapeModel model) {
		super(model);
	}

	@Override
	public void update(ShapeModelEvent event) {
		
		//Get the required info from the event object
		ShapeModel source = event.source();
		
		Object[] path = new Object[0];
		if(event.parent() != null) { //The operand does have a parent
			path = event.parent().path().toArray();
		}
		
		int[] childIndices = new int[1];
		childIndices[0] = event.index();
		
		Object[] children = new Object[1];
		children[0] = event.operand();

		for (TreeModelListener listener: _listeners) {
			//Determine event type and call corresponding method
			if(event.eventType() == EventType.ShapeAdded) {
				TreeModelEvent treeModelEvent = new TreeModelEvent(source,path,childIndices,children);
				listener.treeNodesInserted(treeModelEvent);
			}
			else if(event.eventType() == EventType.ShapeRemoved){
				TreeModelEvent treeModelEvent = new TreeModelEvent(source,path,childIndices,children);
				listener.treeNodesRemoved(treeModelEvent);
			}		
		}
	}

}
