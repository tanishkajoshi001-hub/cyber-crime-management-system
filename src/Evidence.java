public class Evidence {

    private int evidenceId;
    private int caseId;
    private String type;
    private String description;

    public Evidence(int evidenceId, int caseId, String type,
                    String description) {

        this.evidenceId = evidenceId;
        this.caseId = caseId;
        this.type = type;
        this.description = description;
    }

    public int getEvidenceId() {
        return evidenceId;
    }

    public int getCaseId() {
        return caseId;
    }

    public void showEvidence() {

        System.out.println("\n--- Evidence Details ---");
        System.out.println("Evidence ID: " + evidenceId);
        System.out.println("Case ID: " + caseId);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
    }

    public String toFileString() {
        return evidenceId + "|" + caseId + "|" + type + "|" + description;
    }
}
