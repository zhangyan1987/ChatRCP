package org.eclipsercp.hyperbola.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactsGroup extends Contact {

	private String name;

	private List<Contact> entries;

	private List<IContactsListener> listeners;

	private ContactsGroup parent;

	public ContactsGroup() {

	}

	public ContactsGroup(String name, ContactsGroup parent) {
		this.name = name;
		this.parent = parent;
	}

	public List<Contact> getEntries() {
		return Collections.unmodifiableList(entries);
	}

	public void rename(String newName) {
		this.name = newName;
	}

	public void addEntry(Contact entry) {
		if (entries == null) {
			entries = new ArrayList<Contact>();
		}
		this.entries.add(entry);
	}

	public void removeEntry(Contact entry) {
		this.entries.remove(entry);
	}

	public void addContactsListener(IContactsListener listener) {
		if (listeners == null) {
			listeners = new ArrayList<IContactsListener>();
		}
		this.listeners.add(listener);
	}

	public void removeContactsListener(IContactsListener listener) {
		this.listeners.remove(listener);
	}

	protected void fireContactsChanged(ContactEntry entry) {
		if (listeners != null) {
			for (IContactsListener listener : listeners) {
				listener.contactsChanged(this, entry);
			}
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Contact getParent() {
		return parent;
	}

}
