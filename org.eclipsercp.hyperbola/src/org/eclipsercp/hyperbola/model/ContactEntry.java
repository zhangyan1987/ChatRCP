package org.eclipsercp.hyperbola.model;

public class ContactEntry extends Contact {

	private String name;

	private ContactsGroup parent;

	private String nickName;

	private String server;

	private Presence presence;

	private ContactsGroup group;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Presence getPresence() {
		return presence;
	}

	public void setPresence(Presence presence) {
		this.presence = presence;
	}

	public ContactsGroup getGroup() {
		return group;
	}

	public void setGroup(ContactsGroup group) {
		this.group = group;
	}

	public ContactEntry(String name, String nickName, String server,
			Presence presence, ContactsGroup group) {
		this.name = name;
		this.nickName = nickName;
		this.server = server;
		this.presence = presence;
		this.group = group;

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
