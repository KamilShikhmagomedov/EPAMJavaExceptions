import java.util.List;
import java.util.Map;

public class Student {
    String name;
    char male;
    Map<String, Integer> lessonRatings;
    Group group;

    public Student(String name, char male, Map<String, Integer> lessonRatings, Group group) {
        this.name = name;
        this.male = male;
        this.lessonRatings = lessonRatings;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getMale() {
        return male;
    }

    public void setMale(char male) {
        this.male = male;
    }

    public Map<String, Integer> getLessonRatings() {
        return lessonRatings;
    }

    public void setLessonRatings(Map<String, Integer> lessonRatings) {
        this.lessonRatings = lessonRatings;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
