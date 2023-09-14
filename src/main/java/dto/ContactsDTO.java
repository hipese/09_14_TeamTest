package dto;

public class ContactsDTO {
	private String seq;
	private String name;
	private String contact;

	public ContactsDTO() {}

	public ContactsDTO(String seq, String name, String contact) {
		super();
		this.seq = seq;
		this.name = name;
		this.contact = contact;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
