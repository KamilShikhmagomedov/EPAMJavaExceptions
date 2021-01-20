import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create university
        University university = new University("Университет им.Лобачевского");
        // Create faculty
        Faculty facultyEco = new Faculty("Экономический", university);
        Faculty facultyEngin = new Faculty("Строительный", university);
        Faculty facultyJur = new Faculty("Юридический", university);
        // Create groups
        Group group1201 = new Group("1201", facultyEco);
        Group group1202 = new Group("1202", facultyEco);
        Group group1203 = new Group("1203", facultyEngin);
        Group group1204 = new Group("1204", facultyEngin);
        Group group1205 = new Group("1205", facultyJur);
        Group group1206 = new Group("1206", facultyJur);
        // Создаем оценки для экономистов (Разные предметы для интереса)
        Map<String, Integer> ratingStudentEco1 = new HashMap<>();
        ratingStudentEco1.put("Математика", 10);
        ratingStudentEco1.put("История", 7);
        ratingStudentEco1.put("Теория вероятности", 6);
        Map<String, Integer> ratingStudentEco2 = new HashMap<>();
        ratingStudentEco2.put("Математика", 7);
        ratingStudentEco2.put("История", 8);
        ratingStudentEco2.put("Теория вероятности", 8);
        // Создаем оценки для инженеров (Разные предметы для интереса)
        Map<String, Integer> ratingStudentEngin1 = new HashMap<>();
        ratingStudentEngin1.put("Математика", 9);
        ratingStudentEngin1.put("Графика", 5);
        ratingStudentEngin1.put("Проектирование", 6);
        Map<String, Integer> ratingStudentEngin2 = new HashMap<>();
        ratingStudentEngin2.put("Математика", 8);
        ratingStudentEngin2.put("Графика", 9);
        ratingStudentEngin2.put("Проектирование", 10);
        // Создаем оценки для юристов (Разные предметы для интереса)
        Map<String, Integer> ratingStudentJur1 = new HashMap<>();
        ratingStudentJur1.put("Математика", 10);
        ratingStudentJur1.put("Графика", 5);
        ratingStudentJur1.put("Проектирование", 7);
        Map<String, Integer> ratingStudentJur2 = new HashMap<>();
        ratingStudentJur2.put("Математика", 7);
        ratingStudentJur2.put("Графика", 8);
        ratingStudentJur2.put("Проектирование", 10);

        Student student = new Student("Вова Зябкин", 'M', ratingStudentEco1, group1201);
        Student student2 = new Student("Оксана Федорина", 'F', ratingStudentEco2, group1201);
        Student student3 = new Student("Дмитрий Самкин", 'M', ratingStudentEco2, group1202);
        Student student4 = new Student("Василиса Прекрасная", 'F', ratingStudentEco1, group1202);
        Student student5 = new Student("Дмитрий Белоусов", 'M', ratingStudentEngin1, group1203);
        Student student6 = new Student("Дмитрий Бевз", 'M', ratingStudentEngin2, group1203);
        Student student7 = new Student("Алексей Наверняшкин", 'M', ratingStudentEngin2, group1204);
        Student student8 = new Student("Дарья Везучкина", 'F', ratingStudentEngin1, group1204);
        Student student9 = new Student("Василиса Краснова", 'F', ratingStudentJur1, group1205);
        Student student10 = new Student("Валентин Грозный", 'M', ratingStudentJur2, group1205);
        Student student11 = new Student("Александр Македонский", 'M', ratingStudentJur1, group1206);
        Student student12 = new Student("Мурад Набиев", 'M', ratingStudentJur1, group1206);

        List<Student> allStudens = new ArrayList<>();
        allStudens.add(student);
        allStudens.add(student2);
        allStudens.add(student3);
        allStudens.add(student4);
        allStudens.add(student5);
        allStudens.add(student6);
        allStudens.add(student7);
        allStudens.add(student8);
        allStudens.add(student9);
        allStudens.add(student10);
        allStudens.add(student11);
        allStudens.add(student12);

        // TASK 1. Посчитать средний балл по всем предметам студента.
        try {
            System.out.println("Средний балл по всем предметам студента - " + absBall(student));
        } catch (PrepositionLimitsBallException e) {
            System.err.println("Оценки выходят за диапазон от 0 до 10");
        } catch (DoesntHaveLessonException e){
            System.err.println("Отсутствуют предметы у студента");
        }
        // TASK 2. Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        try {
            System.out.println("Посчитать средний балл по математике, в группе 1201, Экономического факультета - " + absBallLesson(allStudens, group1201, facultyEco));
        } catch (PrepositionLimitsBallException e) {
            System.err.println("Оценки выходят за диапазон от 0 до 10");
        } catch (AbsenceStudentsException e){
            System.err.println("Отсутствие студентов в группе");
        } catch (NoGroupsAvailableException e){
            System.err.println("Отсутствие групп на факультете");
        } catch (NoFacultetsAvailableException e){
            System.err.println("Отсутствие факультетов в университете");
        }

        // TASK 3. Посчитать средний балл по предмету для всего университета
        try {
            System.out.println("Средний балл по всему университету по математике - " + absBallUniversity(allStudens));
        } catch (PrepositionLimitsBallException e) {
            System.err.println("Оценки выходят за диапазон от 0 до 10");
        } catch (AbsenceStudentsException e){
            System.err.println("Отсутствие студентов в группе");
        }
    }

    public static double absBall (Student student) throws PrepositionLimitsBallException, DoesntHaveLessonException {
        double absRating = 0.0;
        int countLessons = 0;
        for (Map.Entry<String, Integer> k : student.lessonRatings.entrySet()){
            if (k.getValue() > 10 || k.getValue() < 0){
                throw new PrepositionLimitsBallException();
            }
            if (k.getKey().isEmpty()){
                throw new DoesntHaveLessonException();
            }
            absRating += k.getValue();
            countLessons++;
        }
        absRating = absRating / countLessons;
        return absRating;
    }

    public static double absBallLesson(List<Student> student, Group group, Faculty faculty) throws PrepositionLimitsBallException, AbsenceStudentsException, NoGroupsAvailableException, NoFacultetsAvailableException {
        double absRating = 0.0;
        int countLessons = 0;
        if (faculty.name.equals("Экономический")){
            if (group.getName().isEmpty()){
                throw new NoGroupsAvailableException();
            }
            if (group.name.equals("1201")){
                for (Student k : student) {
                    for (Map.Entry<String, Integer> st : k.lessonRatings.entrySet()){
                        if (st.getKey().isEmpty()){
                            throw new AbsenceStudentsException();
                        }
                        if (st.getKey().equals("Математика")){
                            if (st.getValue() > 10 || st.getValue() < 0){
                                throw new PrepositionLimitsBallException();
                            }
                            absRating += st.getValue();
                            countLessons++;
                        }
                    }
                }
            }
        }
        absRating = absRating / countLessons;
        return absRating;
    }

    public static double absBallUniversity (List<Student> students) throws AbsenceStudentsException, PrepositionLimitsBallException {
        double absRating = 0.0;
        int countLessons = 0;
        if (students.isEmpty()){
            throw new AbsenceStudentsException();
        }
        for (Student k : students) {
            for (Map.Entry<String, Integer> st : k.lessonRatings.entrySet()){
                if (st.getKey().equals("Математика")) {
                    if (st.getValue() > 10 || st.getValue() < 0) {
                        throw new PrepositionLimitsBallException();
                    }
                    absRating += st.getValue();
                    countLessons++;
                }
            }
        }
        absRating = absRating / countLessons;
        return absRating;
    }
}