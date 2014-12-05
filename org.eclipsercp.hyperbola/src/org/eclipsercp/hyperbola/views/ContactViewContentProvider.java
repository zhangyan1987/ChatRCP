package org.eclipsercp.hyperbola.views;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipsercp.hyperbola.model.ContactsGroup;

public class ContactViewContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ContactsGroup) {
			ContactsGroup contactsGroup = (ContactsGroup) inputElement;
			return contactsGroup.getEntries().toArray();
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		if (parentElement instanceof ContactsGroup) {
			ContactsGroup group = (ContactsGroup) parentElement;
			return group.getEntries().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof ContactsGroup) {
			return true;
		}
		return false;
	}

}
