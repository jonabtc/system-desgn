
import java.io.Serializable;
import java.util.HashMap;

public interface Technician extends Serializable, ExpertiseAreas {

    public static final String SPACE = " ";

    public String getFirstName();

    public String getLastName();

    public String getExpertise();

    public void setFirstName(String newFirstName);

    public void setLastName(String newLastName);

    public void setTitle(String newTitle);


}
