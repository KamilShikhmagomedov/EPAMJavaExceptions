import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Faculty {
    String name;
    University university;

    public Faculty(String name, University university) {
        this.name = name;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
