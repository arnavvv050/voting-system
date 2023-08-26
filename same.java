import java.util.ArrayList;
import java.util.Scanner;

public class VotingSystem {
    public static void main(String[] args) {
        ArrayList<String> leaders = new ArrayList<>();
        ArrayList<Integer> voters = new ArrayList<>();
        int numLeaders = 5; // Number of leaders
        int numVoters = 0;  // Number of voters
        int[] leaderVotes = new int[numLeaders]; // Array to store leader votes

        Scanner scanner = new Scanner(System.in);

        // Register leaders
        for (int i = 0; i < numLeaders; i++) {
            System.out.print("Enter leader " + (i + 1) + " name: ");
            String leaderName = scanner.nextLine();
            leaders.add(leaderName);
            System.out.println("You have been successfully registered.");
            if (i == numLeaders - 1) {
                System.out.println("Maximum candidates have been enrolled.");
                System.out.print("Enter total number of voters: ");
                numVoters = scanner.nextInt();
            }
        }

        // Register voters
        for (int i = 1; i <= numVoters; i++) {
            System.out.print("Enter voter ID number: ");
            int voterId = scanner.nextInt();
            voters.add(voterId);
        }

        // Voting session
        while (!voters.isEmpty()) {
            System.out.println("Here are the list of leader names:");
            for (int i = 0; i < numLeaders; i++) {
                System.out.println((i + 1) + ". Leader-" + (i + 1) + ": " + leaders.get(i));
            }

            System.out.print("Cast your vote for Leader 1 to " + numLeaders + ": ");
            int vote = scanner.nextInt();

            if (vote >= 1 && vote <= numLeaders) {
                int leaderIndex = vote - 1;
                leaderVotes[leaderIndex]++;

                System.out.println("Thank you for casting your vote.");
                int voterId = voters.get(0);
                voters.remove(0);
            } else {
                System.out.println("Invalid leader number. Please enter a correct leader number.");
            }
        }

        // Calculate and print the winner
        int maxVotes = leaderVotes[0];
        int winningLeader = 0;

        for (int i = 1; i < numLeaders; i++) {
            if (leaderVotes[i] > maxVotes) {
                maxVotes = leaderVotes[i];
                winningLeader = i;
            }
        }

        double percent = (double) maxVotes / numVoters * 100;
        System.out.println(leaders.get(winningLeader) + " has won with " + percent + "% votes.");
    }
}
