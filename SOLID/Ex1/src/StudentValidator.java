import java.util.ArrayList;
import java.util.List;

public class StudentValidator {
    public List<String> validate(StudentInput in) {
        List<String> errors = new ArrayList<>();

        if (in.name.isBlank()) errors.add("name is required");
        if (in.email.isBlank() || !in.email.contains("@"))
            errors.add("email is invalid");
        if (in.phone.isBlank() || !in.phone.chars().allMatch(Character::isDigit))
            errors.add("phone is invalid");
        if (!(in.program.equals("CSE")
                || in.program.equals("AI")
                || in.program.equals("SWE")))
            errors.add("program is invalid");

        return errors;
    }

}
