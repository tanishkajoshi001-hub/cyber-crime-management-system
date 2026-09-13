import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));


    static ArrayList<Case> cases =
            FileManager.loadCases();

    static ArrayList<Evidence> evidenceList =
            FileManager.loadEvidence();

    static ArrayList<Investigator> investigators =
            FileManager.loadInvestigators();


    static CaseManager caseManager =
            new CaseManager(cases);



    public static void main(String[] args) throws Exception {

        System.out.println("==========================================");
        System.out.println("       CYBER CRIME CASE MANAGEMENT");
        System.out.println("==========================================");


        if (login()) {

            dashboard();
        }
    }



    // ================= LOGIN =================

    public static boolean login() throws Exception {

        System.out.println("\n------------- LOGIN -------------");

        System.out.print("Username: ");
        String username = input.readLine();

        System.out.print("Password: ");
        String password = input.readLine();


        if (username.equals("admin")
                && password.equals("1234")) {

            System.out.println("\nLogin successful!");

            return true;
        }


        System.out.println("\nWrong username or password.");

        return false;
    }



    // ================= DASHBOARD =================

    public static void dashboard() throws Exception {

        while (true) {

            System.out.println("\n==========================================");
            System.out.println("                 DASHBOARD");
            System.out.println("==========================================");

            System.out.println("1. Register New Case");
            System.out.println("2. View All Cases");
            System.out.println("3. Search Case");
            System.out.println("4. Update Case Status");
            System.out.println("5. Add Evidence");
            System.out.println("6. View Evidence");
            System.out.println("7. Add Investigator");
            System.out.println("8. View Investigators");
            System.out.println("9. Case Statistics");
            System.out.println("10. View Critical Cases");
            System.out.println("11. Exit");


            System.out.print("\nEnter your choice: ");

            String choice = input.readLine();


            switch (choice) {

                case "1":
                    registerCase();
                    break;


                case "2":
                    caseManager.showAllCases();
                    break;


                case "3":
                    searchCase();
                    break;


                case "4":
                    updateStatus();
                    break;


                case "5":
                    addEvidence();
                    break;


                case "6":
                    viewEvidence();
                    break;


                case "7":
                    addInvestigator();
                    break;


                case "8":
                    viewInvestigators();
                    break;


                case "9":
                    showStatistics();
                    break;


                case "10":

                    System.out.println(
                            "\n========== CRITICAL CASES ==========");

                    caseManager.showCriticalCases();

                    break;


                case "11":

                    System.out.println(
                            "\nThank you for using the system.");

                    return;


                default:

                    System.out.println(
                            "\nPlease enter a number from 1 to 11.");
            }
        }
    }



    // ================= REGISTER CASE =================

    public static void registerCase() throws Exception {

        System.out.println(
                "\n========== REGISTER NEW CASE ==========");


        System.out.print("Enter Case ID: ");

        int id =
                Integer.parseInt(input.readLine());


        if (caseManager.findCase(id) != null) {

            System.out.println(
                    "A case with this ID already exists.");

            return;
        }



        // Crime Type

        System.out.println("\nCrime Types:");

        System.out.println("1. Online Fraud");
        System.out.println("2. Phishing");
        System.out.println("3. Account Hacking");
        System.out.println("4. Identity Theft");
        System.out.println("5. Cyberbullying");
        System.out.println("6. Data Theft");
        System.out.println("7. Other");


        System.out.print("Choose crime type: ");

        String type =
                input.readLine();


        String crimeType;


        switch (type) {

            case "1":
                crimeType = "Online Fraud";
                break;

            case "2":
                crimeType = "Phishing";
                break;

            case "3":
                crimeType = "Account Hacking";
                break;

            case "4":
                crimeType = "Identity Theft";
                break;

            case "5":
                crimeType = "Cyberbullying";
                break;

            case "6":
                crimeType = "Data Theft";
                break;

            default:
                crimeType = "Other";
        }



        // Victim

        System.out.print("Enter Victim Name: ");

        String victimName =
                input.readLine();



        // Description

        System.out.print("Enter Case Description: ");

        String description =
                input.readLine();



        // ================= PRIORITY =================

        System.out.println(
                "\n========== CASE PRIORITY ==========");

        System.out.println("1. Low");
        System.out.println("2. Medium");
        System.out.println("3. High");
        System.out.println("4. Critical");


        System.out.print("Choose priority: ");

        String priorityChoice =
                input.readLine();


        String priority;

        int riskScore;


        switch (priorityChoice) {

            case "1":

                priority = "LOW";
                riskScore = 25;

                break;


            case "2":

                priority = "MEDIUM";
                riskScore = 50;

                break;


            case "3":

                priority = "HIGH";
                riskScore = 75;

                break;


            case "4":

                priority = "CRITICAL";
                riskScore = 90;

                break;


            default:

                priority = "MEDIUM";
                riskScore = 50;

                System.out.println(
                        "Invalid choice. Medium priority assigned.");
        }



        // Create new case

        Case newCase =
                new Case(
                        id,
                        crimeType,
                        victimName,
                        description
                );


        newCase.setPriority(priority);

        newCase.setRiskScore(riskScore);



        // ================= INVESTIGATOR =================

        if (!investigators.isEmpty()) {

            System.out.println(
                    "\n========== ASSIGN INVESTIGATOR ==========");

            System.out.println("Available Investigators:");


            for (Investigator investigator :
                    investigators) {

                System.out.println(
                        investigator.getInvestigatorId()
                        + " - "
                        + investigator.getDepartment()
                );
            }


            System.out.print(
                    "Enter Investigator ID (0 for none): ");


            int investigatorId =
                    Integer.parseInt(input.readLine());


            if (investigatorId != 0) {

                boolean found = false;


                for (Investigator investigator :
                        investigators) {

                    if (investigator.getInvestigatorId()
                            == investigatorId) {

                        newCase.setInvestigatorId(
                                investigatorId);

                        found = true;

                        break;
                    }
                }


                if (!found) {

                    System.out.println(
                            "Investigator not found.");
                }
            }
        }



        // Save case

        caseManager.addCase(newCase);


        System.out.println(
                "\nCase registered successfully!");
    }



    // ================= SEARCH CASE =================

    public static void searchCase() throws Exception {

        System.out.print("\nEnter Case ID: ");

        int id =
                Integer.parseInt(input.readLine());


        Case foundCase =
                caseManager.findCase(id);


        if (foundCase != null) {

            foundCase.showCase();

        } else {

            System.out.println("\nCase not found.");
        }
    }



    // ================= UPDATE STATUS =================

    public static void updateStatus() throws Exception {

        System.out.print("\nEnter Case ID: ");

        int id =
                Integer.parseInt(input.readLine());


        if (caseManager.findCase(id) == null) {

            System.out.println("Case not found.");

            return;
        }


        System.out.println("\n1. Under Investigation");
        System.out.println("2. Evidence Collected");
        System.out.println("3. Suspect Identified");
        System.out.println("4. Case Solved");
        System.out.println("5. Case Closed");


        System.out.print("Choose new status: ");

        String choice =
                input.readLine();


        String status;


        switch (choice) {

            case "1":

                status = "Under Investigation";

                break;


            case "2":

                status = "Evidence Collected";

                break;


            case "3":

                status = "Suspect Identified";

                break;


            case "4":

                status = "Case Solved";

                break;


            case "5":

                status = "Case Closed";

                break;


            default:

                System.out.println(
                        "Invalid status choice.");

                return;
        }


        caseManager.changeStatus(
                id,
                status
        );


        System.out.println(
                "\nCase status updated successfully.");
    }



    // ================= ADD EVIDENCE =================

    public static void addEvidence() throws Exception {

        System.out.println(
                "\n========== ADD EVIDENCE ==========");


        System.out.print("Evidence ID: ");

        int evidenceId =
                Integer.parseInt(input.readLine());


        System.out.print("Case ID: ");

        int caseId =
                Integer.parseInt(input.readLine());


        if (caseManager.findCase(caseId) == null) {

            System.out.println(
                    "Case does not exist.");

            return;
        }


        System.out.print("Evidence Type: ");

        String type =
                input.readLine();


        System.out.print("Evidence Description: ");

        String description =
                input.readLine();


        Evidence evidence =
                new Evidence(
                        evidenceId,
                        caseId,
                        type,
                        description
                );


        evidenceList.add(evidence);


        FileManager.saveEvidence(
                evidenceList);


        System.out.println(
                "\nEvidence added successfully.");
    }



    // ================= VIEW EVIDENCE =================

    public static void viewEvidence() {

        if (evidenceList.isEmpty()) {

            System.out.println(
                    "\nNo evidence has been added.");

            return;
        }


        System.out.println(
                "\n========== EVIDENCE ==========");


        for (Evidence evidence :
                evidenceList) {

            evidence.showEvidence();
        }
    }



    // ================= ADD INVESTIGATOR =================

    public static void addInvestigator() throws Exception {

        System.out.println(
                "\n========== ADD INVESTIGATOR ==========");


        System.out.print("Investigator ID: ");

        int id =
                Integer.parseInt(input.readLine());


        System.out.print("Name: ");

        String name =
                input.readLine();


        System.out.print("Phone: ");

        String phone =
                input.readLine();


        System.out.print("Email: ");

        String email =
                input.readLine();


        System.out.print("Department: ");

        String department =
                input.readLine();


        Investigator investigator =
                new Investigator(
                        id,
                        name,
                        phone,
                        email,
                        department
                );


        investigators.add(investigator);


        FileManager.saveInvestigators(
                investigators);


        System.out.println(
                "\nInvestigator added successfully.");
    }



    // ================= VIEW INVESTIGATORS =================

    public static void viewInvestigators() {

        if (investigators.isEmpty()) {

            System.out.println(
                    "\nNo investigators have been added.");

            return;
        }


        System.out.println(
                "\n========== INVESTIGATORS ==========");


        for (Investigator investigator :
                investigators) {

            investigator.showInvestigator();
        }
    }



    // ================= STATISTICS =================

    public static void showStatistics() {

        System.out.println(
                "\n========== CASE STATISTICS ==========");


        System.out.println(
                "Total Cases: "
                + caseManager.getTotalCases());


        System.out.println(
                "Under Investigation: "
                + caseManager.countByStatus(
                        "Under Investigation"));


        System.out.println(
                "Evidence Collected: "
                + caseManager.countByStatus(
                        "Evidence Collected"));


        System.out.println(
                "Suspect Identified: "
                + caseManager.countByStatus(
                        "Suspect Identified"));


        System.out.println(
                "Cases Solved: "
                + caseManager.countByStatus(
                        "Case Solved"));


        System.out.println(
                "Cases Closed: "
                + caseManager.countByStatus(
                        "Case Closed"));



        // Priority statistics

        System.out.println(
                "\n---------- PRIORITY ----------");


        int low =
                caseManager.countByPriority("LOW");

        int medium =
                caseManager.countByPriority("MEDIUM");

        int high =
                caseManager.countByPriority("HIGH");

        int critical =
                caseManager.countByPriority("CRITICAL");


        System.out.println(
                "Low      : " + low);

        System.out.println(
                "Medium   : " + medium);

        System.out.println(
                "High     : " + high);

        System.out.println(
                "Critical : " + critical);



        // ASCII Graph

        System.out.println(
                "\n---------- PRIORITY GRAPH ----------");


        System.out.print("Low      : ");

        printGraph(low);


        System.out.print("Medium   : ");

        printGraph(medium);


        System.out.print("High     : ");

        printGraph(high);


        System.out.print("Critical : ");

        printGraph(critical);
    }



    // ================= GRAPH =================

    public static void printGraph(int count) {

        for (int i = 0; i < count; i++) {

            System.out.print("█");
        }

        System.out.println();
    }
}
