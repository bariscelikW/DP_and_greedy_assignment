import java.util.ArrayList;

public class OptimalShipSolution {
    private final ArrayList<Integer> artifactSet;
    private final int solution;

    OptimalShipSolution(ArrayList<Integer> artifactSet, int solution) {
        this.artifactSet = artifactSet;
        this.solution = solution;
    }

    public int getSolution() {
        return solution;
    }

    public ArrayList<Integer> getArtifactSet() {
        return artifactSet;
    }

    public void printSolution(OptimalShipSolution solution) {

        System.out.println("Minimum spaceships required: " + solution.getSolution());
        System.out.print("For the artifact set of :[");

        ArrayList<Integer> artifacts = solution.getArtifactSet();
        for (int i = 0; i < artifacts.size(); i++) {
            System.out.print(artifacts.get(i));
            if (i != artifacts.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

    }
}
