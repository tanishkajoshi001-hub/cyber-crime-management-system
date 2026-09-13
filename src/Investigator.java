public class Investigator extends Person {

    private int investigatorId;
    private String department;

    public Investigator(int investigatorId, String name, String phone,
                        String email, String department) {

        super(name, phone, email);
        this.investigatorId = investigatorId;
        this.department = department;
    }

    public int getInvestigatorId() {
        return investigatorId;
    }

    public String getDepartment() {
        return department;
    }

    public void showInvestigator() {

        System.out.println("\n--- Investigator Details ---");
        System.out.println("Investigator ID: " + investigatorId);
        System.out.println("Department: " + department);
        showDetails();
    }

    public String toFileString() {
        return investigatorId + "|" + name + "|" + phone + "|" +
               email + "|" + department;
    }
}
