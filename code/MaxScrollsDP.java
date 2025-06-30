import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxScrollsDP {
    private ArrayList<ArrayList<Integer>> safesDiscovered = new ArrayList<>();
    public MaxScrollsDP(ArrayList<ArrayList<Integer>> safesDiscovered) {
        this.safesDiscovered = safesDiscovered;
    }

    public ArrayList<ArrayList<Integer>> getSafesDiscovered() {
        return safesDiscovered;
    }

    public OptimalScrollSolution optimalSafeOpeningAlgorithm() throws FileNotFoundException {

        int n =  safesDiscovered.size();
        int ans = 0;

        // 2D dp array is DP
        ArrayList<ArrayList<Integer>> DP = new ArrayList<ArrayList<Integer>>();
        // DP array looks different because of my DP solution.
        // Columns number increases by 1 for each row, not the same (exact) number for all rows

        /* if n = 3
         * 0
         * 0 0
         * 0 0 0
         * 0 0 0 0
         * */
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(0); // initialize with 0
            }
            DP.add(row);
        }
        // my dp solution
        for (int i = 0; i < DP.size(); i++){
            for (int j = 0; j <= i; j++){
                //base case
                if ( i == 0){
                    DP.get(i).set(j, 0);
                    break;
                }
                int generateKnowledge = 0;
                int openSafe = 0;
                int maintain = 0;
                // we have just three options to pick
                // generateKnowledge
                if (i - 1 >= 0 && j - 1 >= 0 && j - 1 < DP.get(i - 1).size()){
                    generateKnowledge = DP.get(i - 1).get(j - 1);
                }
                // openSafe
                if ((i - 1 >= 0) && (j + (int)(safesDiscovered.get(i - 1).get(0) / 5)) < DP.get(i - 1).size()){
                    openSafe = DP.get(i - 1).get(j + (int)(safesDiscovered.get(i - 1).get(0) / 5)) + safesDiscovered.get(i-1).get(1);
                }
                // maintain
                if (i - 1 >= 0 && j < DP.get(i - 1).size()){
                    maintain = DP.get(i - 1).get(j);
                }
                // pick the max value to get max result
                int max = Math.max(generateKnowledge, Math.max(openSafe, maintain));
                DP.get(i).set(j, max);
            }
        }
        // DP[n][0] is the maximum scroll
        ans = DP.get(n).get(0);
        OptimalScrollSolution ansObj = new OptimalScrollSolution(safesDiscovered, ans);
        return ansObj;
    }
}