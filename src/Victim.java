public class Victim extends Person {

    private int caseId;

    public Victim(int caseId, String name, String phone, String email) {
        super(name, phone, email);
        this.caseId = caseId;
    }

    public void showVictim() {
        System.out.println("\n--- Victim Details ---");
        System.out.println("Case ID: " + caseId);
        showDetails();
    }
}
