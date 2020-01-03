
import java.util.HashMap;

public class TechnicianImpl implements Technician, ExpertiseAreas {

	private String firstName;
	private String lastName;
	private String expertiseArea;

	private static HashMap<String, Integer> avTechExpertise = null;

	private boolean ocupado = false;

	public TechnicianImpl() {

	}

	public TechnicianImpl(String newFirstName, String newLastName, String newExpertiseArea) {
		this();
		firstName = newFirstName;
		lastName = newLastName;
		expertiseArea = newExpertiseArea;
	}

	public static HashMap<String, Integer> getAvTechExpertise() {
		return avTechExpertise;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getExpertise() {
		return expertiseArea;
	}

	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	public void setLastName(String newLastName) {
		lastName = newLastName;
	}

	public void setTitle(String newTitle) {
		expertiseArea = newTitle;
	}

	public String toString() {
		return firstName + SPACE + lastName;
	}

	public void setEstado(boolean a) {
		ocupado = a;
	}

	public boolean getEstado() {
		return ocupado;
	}

}
