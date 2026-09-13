import java.io.*;
import java.util.ArrayList;

public class FileManager {


    private static File getFile(String fileName) {

        // First check the current folder
        File file = new File(fileName);

        if (file.exists()) {

            return file;
        }


        // If program is running from src folder,
        // check the parent folder
        File parentFile = new File("..", fileName);

        if (parentFile.exists()) {

            return parentFile;
        }


        // If file does not exist, create it in parent folder
        return parentFile;
    }



    // ================= CASES =================

    public static ArrayList<Case> loadCases() {

        ArrayList<Case> cases = new ArrayList<>();

        File file = getFile("cases.txt");

        try {

            if (!file.exists()) {

                file.createNewFile();

                return cases;
            }


            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;


            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {

                    continue;
                }


                String[] data = line.split("\\|");


                // Old format
                if (data.length == 5) {

                    int id = Integer.parseInt(data[0]);

                    Case c = new Case(
                            id,
                            data[1],
                            data[2],
                            data[3],
                            data[4]
                    );

                    cases.add(c);
                }


                // New format
                else if (data.length == 8) {

                    int id = Integer.parseInt(data[0]);

                    String priority = data[5];

                    int riskScore =
                            Integer.parseInt(data[6]);

                    int investigatorId =
                            Integer.parseInt(data[7]);


                    Case c = new Case(
                            id,
                            data[1],
                            data[2],
                            data[3],
                            data[4],
                            priority,
                            riskScore,
                            investigatorId
                    );

                    cases.add(c);
                }
            }


            reader.close();

        } catch (Exception e) {

            System.out.println("Error reading cases.txt");

            System.out.println(e.getMessage());
        }


        return cases;
    }



    public static void saveCases(ArrayList<Case> cases) {

        File file = getFile("cases.txt");

        try {

            PrintWriter writer =
                    new PrintWriter(new FileWriter(file));


            for (Case c : cases) {

                writer.println(c.toFileString());
            }


            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving cases.");
        }
    }



    // ================= EVIDENCE =================

    public static ArrayList<Evidence> loadEvidence() {

        ArrayList<Evidence> evidenceList =
                new ArrayList<>();

        File file = getFile("evidence.txt");


        try {

            if (!file.exists()) {

                file.createNewFile();

                return evidenceList;
            }


            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;


            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {

                    continue;
                }


                String[] data = line.split("\\|");


                if (data.length == 4) {

                    Evidence evidence =
                            new Evidence(
                                    Integer.parseInt(data[0]),
                                    Integer.parseInt(data[1]),
                                    data[2],
                                    data[3]
                            );

                    evidenceList.add(evidence);
                }
            }


            reader.close();

        } catch (Exception e) {

            System.out.println("Error reading evidence.txt");
        }


        return evidenceList;
    }



    public static void saveEvidence(
            ArrayList<Evidence> evidenceList) {

        File file = getFile("evidence.txt");


        try {

            PrintWriter writer =
                    new PrintWriter(new FileWriter(file));


            for (Evidence e : evidenceList) {

                writer.println(e.toFileString());
            }


            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving evidence.");
        }
    }



    // ================= INVESTIGATORS =================

    public static ArrayList<Investigator>
    loadInvestigators() {

        ArrayList<Investigator> investigators =
                new ArrayList<>();

        File file = getFile("investigators.txt");


        try {

            if (!file.exists()) {

                file.createNewFile();

                return investigators;
            }


            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;


            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {

                    continue;
                }


                String[] data = line.split("\\|");


                if (data.length == 5) {

                    Investigator investigator =
                            new Investigator(
                                    Integer.parseInt(data[0]),
                                    data[1],
                                    data[2],
                                    data[3],
                                    data[4]
                            );

                    investigators.add(investigator);
                }
            }


            reader.close();

        } catch (Exception e) {

            System.out.println(
                    "Error reading investigators.txt");
        }


        return investigators;
    }



    public static void saveInvestigators(
            ArrayList<Investigator> investigators) {

        File file = getFile("investigators.txt");


        try {

            PrintWriter writer =
                    new PrintWriter(new FileWriter(file));


            for (Investigator i : investigators) {

                writer.println(i.toFileString());
            }


            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving investigators.");
        }
    }
}
