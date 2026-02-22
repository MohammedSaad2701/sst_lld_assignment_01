import java.util.*;

public class StudentParser {

    public StudentInput parse(String raw) {
        Map<String, String> kv = new LinkedHashMap<>();

        String[] parts = raw.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) {
                kv.put(t[0].trim(), t[1].trim());
            }
        }

        StudentInput in = new StudentInput();
        in.name = kv.getOrDefault("name", "");
        in.email = kv.getOrDefault("email", "");
        in.phone = kv.getOrDefault("phone", "");
        in.program = kv.getOrDefault("program", "");
        return in;
    }
}