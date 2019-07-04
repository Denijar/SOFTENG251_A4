package spaceshapes.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;

public class Task1 implements TreeModel {
	
	private ShapeModel _adaptee;
	
	// List of TreeModelListeners.
	protected List<TreeModelListener> _listeners = new ArrayList<TreeModelListener>();
	
	public Task1(ShapeModel model) {
		_adaptee = model;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		_listeners.add(l);
		System.out.println(l);
	}
	
	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		_listeners.remove(l);
	}

	/**
	 * Implemented, passes test
	 */
	@Override
	public Object getChild(Object parent, int index) {
		Shape child = null;
		if(parent instanceof CarrierShape) {
			try {
				child = ((CarrierShape) parent).shapeAt(index);
			}
			catch(IndexOutOfBoundsException e) {
			}
		}
		return child;
	}

	/**
	 * Implemented, passes test
	 */
	@Override
	public int getChildCount(Object parent) {
		int result = 0;
		if(parent instanceof CarrierShape) {
			result = ((CarrierShape) parent).shapeCount();
		}
		return result;
	}

	/**
	 * Implemented, passes test
	 */
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		int index = -1;
		if(parent instanceof CarrierShape && child instanceof Shape) {
			index = ((CarrierShape) parent).indexOf((Shape) child);
		}
		return index;
	}

	/**
	 * Implemented, passes test
	 */
	@Override
	public Object getRoot() {
		return _adaptee.root();
	}

	/**
	 * Implemented, passes test
	 */
	@Override
	public boolean isLeaf(Object node) {
		boolean isLeaf = true;
		if(node instanceof CarrierShape) {
			isLeaf = false;
		}
		return isLeaf;
	}

	/**
	 * Implemented as needed
	 */
	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		//Empty implementation
	}

}
