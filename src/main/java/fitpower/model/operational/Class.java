package fitpower.model.operational;

import java.util.HashMap;

public class Class extends Meeting {

    public final HashMap<String, Class> classMap = new HashMap<>();

    private String classId;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
