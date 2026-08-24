import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    public static int invalidLines = 0;
    public static void main(String[] args) {
        // Step 1: read scores from file
        // Step 2: calculate statistics
        // Step 3: write and print report

        String inputFile = "scores.txt";
        String outputFile = "report.txt";

        ArrayList<Integer> scores = readScores(inputFile);

        double avg = calculateAverage(scores);

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for (int score: scores) {
            if (score > high) {
                high = score;
            }
            if (score < low) {
                low = score;
            }
        }

        writeReport(scores, avg, high, low, outputFile);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Warning: Invalid score skipped -> " + line);
                    invalidLines++;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error Reading File" + e.getMessage());
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here

        if (scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0;

        for (int score: scores) {
            sum += score;
        }

        return sum / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        // your code here
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score: scores) {
            if (score >= 90) {
                countA++;
            }
            else if (score >= 80) {
                countB++;
            }
            else if (score >= 70) {
                countC++;
            }
            else if (score >= 60) {
                countD++;
            }
            else {
                countF++;
            }
        }
        StringBuilder report = new StringBuilder();
        report.append(String.format("=== Grade Analysis Report ===%n"));
        report.append(String.format("Total scores processed:  %d%n", scores.size()));
        report.append(String.format("Invalid lines skipped:   %d%n%n", invalidLines));
        report.append(String.format("Average score:   %.2f%n", avg));
        report.append(String.format("Highest score:   %d%n", high));
        report.append(String.format("Lowest score:    %d%n%n", low));
        report.append(String.format("Grade distribution:%n"));
        report.append(String.format("  A (90-100):   %d%n", countA));
        report.append(String.format("  B (80-89):    %d%n", countB));
        report.append(String.format("  C (70-79):    %d%n", countC));
        report.append(String.format("  D (60-69):    %d%n", countD));
        report.append(String.format("  F (below 60):  %d%n", countF));

        System.out.print(report.toString());

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(report.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
} 