package org.eclipsercp.hyperbola.views;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipsercp.hyperbola.model.Contact;
import org.eclipsercp.hyperbola.model.ContactEntry;
import org.eclipsercp.hyperbola.model.ContactsGroup;
import org.eclipsercp.hyperbola.model.IContactsListener;
import org.eclipsercp.hyperbola.model.Presence;
import org.eclipsercp.hyperbola.model.Session;
import org.eclipsercp.hyperbola.util.IImageConstants;
import org.eclipsercp.hyperbola.util.ImageUtil;

public class ContactView extends ViewPart {

	@Override
	public void dispose() {
		ImageUtil.dispose(this);
	}

	private Session session;

	private TreeViewer treeViewer;

	public static final String ID = "org.eclipsercp.hyperbola.views.contacts";

	public ContactView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		initSession();
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL);

		treeViewer.setContentProvider(new ContactViewContentProvider());
		treeViewer.setLabelProvider(new LabelProvider() {

			@Override
			public Image getImage(Object element) {
				return ImageUtil.getImage(IImageConstants.AWAY, ContactView.this);
			}

			@Override
			public String getText(Object element) {
				if (element instanceof Contact) {
					Contact c = (Contact) element;
					return c.getName();
				}
				return super.getText(element);
			}

		});
		treeViewer.setInput(session.getRootGroup());
	}

	@Override
	public void setFocus() {

	}

	private void initSession() {

		session = new Session();
		ContactsGroup root = session.getRootGroup();

		ContactsGroup friends = new ContactsGroup("friends", root);
		root.addEntry(friends);
		friends.addEntry(new ContactEntry("tester1", "test1", "localhost",
				Presence.ONLINE, friends));
		friends.addEntry(new ContactEntry("tester2", "test2", "localhost",
				Presence.ONLINE, friends));

		friends.addContactsListener(new IContactsListener() {

			@Override
			public void contactsChanged(ContactsGroup group, ContactEntry entry) {
				treeViewer.refresh();
			}
		});

	}
	
}
