import java.util.GregorianCalendar;

public class Contact {
	private String firstName, lastName;
	private String[] phoneNo;
	private String Affiliation;
	private String Occupation;
	private String Note = "";
	private GregorianCalendar dob;
	private boolean blocked = false;//= false;//Eager initialization
	
	
	// the constructor
	 public Contact(String firstName, String lastName, String[] phoneNo, String affiliation, String occupation,
             String note, GregorianCalendar dob, boolean blocked) {
  this.setFirstName(firstName);
  this.setLastName(lastName);
  this.setPhoneNo(phoneNo);
  this.setAffiliation(affiliation);
  this.setOccupation(occupation);
  this.setNote(note);
  this.setDob(dob);
  this.setBlocked(blocked);
}

	// the setters and getters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String[] getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String[] phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAffiliation() {
		return Affiliation;
	}

	public void setAffiliation(String affiliation) {
		Affiliation = affiliation;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public GregorianCalendar getDob() {
		return dob;
	}

	public void setDob(GregorianCalendar dob) {
		this.dob = dob;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	// the overload method
	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void replaceNumber(String oldNumber, String newNumber) {
		for (int i = 0; i <phoneNo.length; i++) {
			if (phoneNo[i] !=null && phoneNo[i].equals(oldNumber)) {
				phoneNo[i] = newNumber;
			}
		}
	}
	
	@Override
	public String toString() {
	    String result = "Name: " + firstName + " " + lastName + "\n";
	    for (String number : phoneNo) {
	        if (number != null) {
	            result += number + " ";
	        }
	    }
	    result += "\nAffiliation: " + Affiliation;
	    result += "\nOccupation: " + Occupation;
	    result += "\nNote: " + Note;
	    result += "\nDOB: " + dob.getTime();
	    result += "\nBlocked: " + blocked;
	    return result;
	}


	
}