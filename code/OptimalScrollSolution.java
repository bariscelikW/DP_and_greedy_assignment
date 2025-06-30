import java.util.ArrayList;

public class OptimalScrollSolution {
    private final ArrayList<ArrayList<Integer>> safeSet;
    private final int solution;

    OptimalScrollSolution(ArrayList<ArrayList<Integer>> safeSet, int solution) {
        this.safeSet = safeSet;
        this.solution = solution;
    }

    public int getSolution() {
        return solution;
    }

    public ArrayList<ArrayList<Integer>> getSafeSet() {
        return safeSet;
    }

    public void printSolution(OptimalScrollSolution solution) {
        System.out.println("Maximum scrolls acquired: " + solution.getSolution());
        System.out.print("For the safe set of :[");

        ArrayList<ArrayList<Integer>> safes = solution.getSafeSet();

        for (int i = 0; i < safes.size(); i++) {
            ArrayList<Integer> safe = safes.get(i);
            System.out.print("[" + safe.get(0) + ", " + safe.get(1) + "]");
            if (i != safes.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
