import java.util.ArrayList;

public class CaseManager {

    private ArrayList<Case> cases;


    public CaseManager(ArrayList<Case> cases) {
        this.cases = cases;
    }


    public void addCase(Case newCase) {

        cases.add(newCase);

        FileManager.saveCases(cases);
    }


    public void showAllCases() {

        if (cases.isEmpty()) {

            System.out.println("\nNo cases have been registered yet.");
            return;
        }

        System.out.println("\n========== ALL CASES ==========");

        for (Case c : cases) {

            c.showCase();
        }
    }


    public Case findCase(int id) {

        for (Case c : cases) {

            if (c.getCaseId() == id) {

                return c;
            }
        }

        return null;
    }


    public boolean changeStatus(int id, String newStatus) {

        Case c = findCase(id);

        if (c != null) {

            c.updateStatus(newStatus);

            FileManager.saveCases(cases);

            return true;
        }

        return false;
    }


    public int getTotalCases() {

        return cases.size();
    }


    public int countByStatus(String status) {

        int count = 0;

        for (Case c : cases) {

            if (c.getStatus().equalsIgnoreCase(status)) {

                count++;
            }
        }

        return count;
    }


    // Count cases according to priority
    public int countByPriority(String priority) {

        int count = 0;

        for (Case c : cases) {

            if (c.getPriority().equalsIgnoreCase(priority)) {

                count++;
            }
        }

        return count;
    }


    // Show only critical cases
    public void showCriticalCases() {

        boolean found = false;

        for (Case c : cases) {

            if (c.getPriority().equalsIgnoreCase("CRITICAL")) {

                c.showCase();

                found = true;
            }
        }

        if (!found) {

            System.out.println("\nNo critical cases found.");
        }
    }
}
