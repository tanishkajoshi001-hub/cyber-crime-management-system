public class Suspect extends Person {

    private int caseId;

    public Suspect(int caseId, String name, String phone, String email) {
        super(name, phone, email);
        this.caseId = caseId;
    }

    public void showSuspect() {
        System.out.println("\n--- Suspect Details ---");
        System.out.println("Case ID: " + caseId);
        showDetails();
    }
}
