import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;


public class MinShipsGP {
    private final ArrayList<Integer> artifactsFound = new ArrayList<>();

    public ArrayList<Integer> getArtifactsFound() {
        return artifactsFound;
    }

    MinShipsGP(ArrayList<Integer> artifactsFound) {
        this.artifactsFound.addAll(artifactsFound);
    }

    public OptimalShipSolution optimalArtifactCarryingAlgorithm() throws FileNotFoundException {
        int shipSize = 100;
        ArrayList<Integer> artifactsFoundCopy = new ArrayList<>(artifactsFound);
        // sort the artifactsFoundCopy
        Collections.sort(artifactsFoundCopy, Collections.reverseOrder());
        // min-heap
        PriorityQueue<Integer> ships = new PriorityQueue<>();
        int minShip = 0;

        for (int artifact : artifactsFoundCopy) {
            ArrayList<Integer> temp = new ArrayList<>();
            boolean changed = false;

            while (!ships.isEmpty()) {
                int minAvailableVal = ships.poll();
                if (minAvailableVal >= artifact) {
                    ships.add(minAvailableVal - artifact);
                    changed = true;
                    break;
                } else {
                    // not enough space for this ship, but we can think about it later
                    temp.add(minAvailableVal);
                }
            }

            // If there is no space for new artifact
            if (!changed) {
                ships.add(shipSize - artifact);
                minShip++;
            }

            // put all untouched ships back to the heap
            ships.addAll(temp);
        }

        OptimalShipSolution shipAns = new OptimalShipSolution(artifactsFound, minShip);
        return shipAns;
    }
}

/*
*
* Brute force solution without using priority queue:
*
* for (int i = 0; i < n; i++){
            int j = 0;
            int m = ships.size();
            while (j < m){
                // there is enough space
                if(ships.get(j) >= artifactsFoundCopy.get(i)){
                    int temp = ships.get(j) - artifactsFoundCopy.get(i);
                    ships.set(j, temp);
                    break;
                } else if (j == m - 1 && ships.get(j) < artifactsFoundCopy.get(i)) {
                    // we visited all ships and there is no space for new artifact
                    ships.add(100 - artifactsFoundCopy.get(i));
                }
                j++;
            }
        }
*
*
* */