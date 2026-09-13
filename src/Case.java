public class Case {

    private int caseId;
    private String crimeType;
    private String victimName;
    private String description;
    private String status;

    private String priority;
    private int riskScore;
    private int investigatorId;


    // Constructor for new cases
    public Case(int caseId, String crimeType, String victimName,
                String description) {

        this.caseId = caseId;
        this.crimeType = crimeType;
        this.victimName = victimName;
        this.description = description;
        this.status = "Under Investigation";

        this.priority = "MEDIUM";
        this.riskScore = 50;
        this.investigatorId = -1;
    }


    // Constructor for loading old cases
    public Case(int caseId, String crimeType, String victimName,
                String description, String status) {

        this.caseId = caseId;
        this.crimeType = crimeType;
        this.victimName = victimName;
        this.description = description;
        this.status = status;

        this.priority = "MEDIUM";
        this.riskScore = 50;
        this.investigatorId = -1;
    }


    // Constructor for loading new cases
    public Case(int caseId, String crimeType, String victimName,
                String description, String status,
                String priority, int riskScore, int investigatorId) {

        this.caseId = caseId;
        this.crimeType = crimeType;
        this.victimName = victimName;
        this.description = description;
        this.status = status;

        this.priority = priority;
        this.riskScore = riskScore;
        this.investigatorId = investigatorId;
    }


    public int getCaseId() {
        return caseId;
    }


    public String getCrimeType() {
        return crimeType;
    }


    public String getVictimName() {
        return victimName;
    }


    public String getDescription() {
        return description;
    }


    public String getStatus() {
        return status;
    }


    public String getPriority() {
        return priority;
    }


    public int getRiskScore() {
        return riskScore;
    }


    public int getInvestigatorId() {
        return investigatorId;
    }


    public void updateStatus(String newStatus) {
        status = newStatus;
    }


    public void setPriority(String priority) {
        this.priority = priority;
    }


    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }


    public void setInvestigatorId(int investigatorId) {
        this.investigatorId = investigatorId;
    }


    public void showCase() {

        System.out.println("\n--------------------------------");
        System.out.println("Case ID      : " + caseId);
        System.out.println("Crime Type   : " + crimeType);
        System.out.println("Victim       : " + victimName);
        System.out.println("Description  : " + description);
        System.out.println("Status       : " + status);
        System.out.println("Priority     : " + priority);
        System.out.println("Risk Score   : " + riskScore);

        if (investigatorId == -1) {
            System.out.println("Investigator : Not Assigned");
        } else {
            System.out.println("Investigator : " + investigatorId);
        }

        System.out.println("--------------------------------");
    }


    public String toFileString() {

        return caseId + "|" + crimeType + "|" + victimName +
               "|" + description + "|" + status + "|" +
               priority + "|" + riskScore + "|" + investigatorId;
    }
}
