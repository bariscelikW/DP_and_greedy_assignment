import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        /** Safe-lock Opening Algorithm Below **/
        System.out.println("##Initiate Operation Safe-lock##");

        if (args.length < 2) {
            System.out.println("Missing arguments :(");
            return;
        }

        String safesDiscoveredFile = args[0];
        String artifactsFoundFile = args[1];

        ArrayList<ArrayList<Integer>> safesDiscovered = new ArrayList<>();

        Scanner scanner = new Scanner(new File(safesDiscoveredFile));
        int numberOfSafes = Integer.parseInt(scanner.nextLine().trim());


        for (int i = 0; i < numberOfSafes; i++) {
            //read lines
            String line = scanner.nextLine().trim();
            //split by comma
            String[] parts = line.split(",");
            ArrayList<Integer> safe = new ArrayList<>();
            safe.add(Integer.parseInt(parts[0].trim())); // C
            safe.add(Integer.parseInt(parts[1].trim())); // S
            safesDiscovered.add(safe);
        }

        // Run DP algorithm
        MaxScrollsDP dpSolver = new MaxScrollsDP(safesDiscovered);
        OptimalScrollSolution solution = dpSolver.optimalSafeOpeningAlgorithm();

        // Print result
        solution.printSolution(solution);
        System.out.println("##Operation Safe-lock Completed##");

        /** Operation Artifact Algorithm Below **/
        System.out.println("##Initiate Operation Artifact##");

        ArrayList<Integer> artifactsFound = new ArrayList<>();
        Scanner artifactScanner = new Scanner(new File(artifactsFoundFile));

        String line = artifactScanner.nextLine().trim();
        String[] weights = line.split(",");
        // add weights to artifactsFound
        for (String weight : weights) {
            artifactsFound.add(Integer.parseInt(weight.trim()));
        }

        // Run Greedy algorithm
        MinShipsGP gpSolver = new MinShipsGP(artifactsFound);
        OptimalShipSolution shipSolution = gpSolver.optimalArtifactCarryingAlgorithm();
        //print solution
        shipSolution.printSolution(shipSolution);
        System.out.println("##Operation Artifact Completed##");
    }
}