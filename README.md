# Dynamic Programming and Greedy Algorithm

 Used dynamic programming technics and greedy algorithm to solve fun problem.
 
 Please read description.pdf to get a full idea.

 # BBM204 Programming Assignment 2: Finding Diamond in Search of Gold

This assignment is written in Java and covers two algorithmic approaches: **Dynamic Programming** and **Greedy Programming**, inspired by a sci-fi problem scenario involving treasure retrieval and resource optimization.

## 🚀 Overview

Humanity, in its quest for survival on Kepler-452b, uncovers a dungeon filled with encrypted scrolls and powerful artifacts. The goal is to:
1. **Maximize the number of scrolls unlocked** before oxygen runs out (using dynamic programming).
2. **Minimize the number of spaceships** needed to retrieve heavy artifacts (using greedy programming).

---

## 🧠 Part 1: Opening the Scrolls

**Objective**: Maximize the number of scrolls unlocked within a limited number of minutes.

- Each safe-lock requires `C` knowledge to open.
- Every minute, the team can either generate 5 knowledge or attempt to open a safe-lock.
- The decision-making is handled using a **dynamic programming** approach.
- Data Source: `SafesDiscovered.dat`

### Output Example:
##Initiate Operation Safe-lock##
Maximum scrolls acquired: 32
For the safe set of :[[5,12],[5,7],[10,16],[15,24],[5,16]]
##Operation Safe-lock Completed##


## 🛰️ Part 2: Gathering the Artifacts

**Objective**: Load all discovered artifacts into the **minimum number of spaceships**, each with a weight capacity of 100 units.

- Artifacts are sorted in descending order.
- The heaviest artifacts are loaded first.
- This is solved using a **greedy algorithm**.
- Data Source: `ArtifactsFound.dat`

### Output Example:

##Initiate Operation Artifact##
Minimum spaceships required: 3
For the artifact set of :[20,90,80,10,100]
##Operation Artifact Completed##


## 🛠️ How to Compile and Run

Ensure Java 11 (OpenJDK) is installed.

### Compile:
```bash
javac *.java -d .
java Main <MaxScrollsDP> <MinShipsGP>
```

bariscelikw
 
