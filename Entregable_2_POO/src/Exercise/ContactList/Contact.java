package Exercise.ContactList;

public class Contact {

    private String contactName;
    private String telNumber;
    private String email;

    public Contact(String contactName, String telNumber, String email) {
        this.contactName = contactName;
        this.telNumber = telNumber;
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact: " + contactName + ", Number: " + telNumber + ", Email: " + email;
    }

}
