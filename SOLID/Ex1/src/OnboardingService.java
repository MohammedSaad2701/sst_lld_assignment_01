import java.util.List;

public class OnboardingService {
    private  final Printer printer = new Printer();
    private final StudentParser parser = new StudentParser();
    private final StudentValidator validator = new StudentValidator();
    private final FakeDbI store;

    // private final FakeDb db;

    public OnboardingService(FakeDbI store) { this.store = store; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        // System.out.println("INPUT: " + raw);
        printer.printInput(raw);
        
        // Map<String,String> kv = new LinkedHashMap<>();
        // String[] parts = raw.split(";");
        // for (String p : parts) {
        //     String[] t = p.split("=", 2);
        //     if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        // }

        // String name = kv.getOrDefault("name", "");
        // String email = kv.getOrDefault("email", "");
        // String phone = kv.getOrDefault("phone", "");
        // String program = kv.getOrDefault("program", "");

        StudentInput input = parser.parse(raw);

        // validation inline, printing inline
        // List<String> errors = new ArrayList<>();
        // if (name.isBlank()) errors.add("name is required");
        // if (email.isBlank() || !email.contains("@")) errors.add("email is invalid");
        // if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        // if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) errors.add("program is invalid");

        List<String> errors = validator.validate(input);

        // if (!errors.isEmpty()) {
        //     System.out.println("ERROR: cannot register");
        //     for (String e : errors) System.out.println("- " + e);
        //     return;
        // }

        if(!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        // String id = IdUtil.nextStudentId(db.count());
        // StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        // db.save(rec);
        String id = IdUtil.nextStudentId(store.count());
        StudentRecord rec = new StudentRecord(id, input.name, input.email, input.phone, input.program);
        store.save(rec);
        printer.printSuccess(rec, store.count());

        // System.out.println("OK: created student " + id);
        // System.out.println("Saved. Total students: " + db.count());
        // System.out.println("CONFIRMATION:");
        // System.out.println(rec);
    }
}
