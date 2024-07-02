package TeamMenuApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamMenuApp {
    static Scanner sc = new Scanner(System.in);
    static List<Team> teams = new ArrayList<Team>();

    public static void main(String[] args) {
        int decision = 0;

        while (true) {
            printOptions();
            decision = sc.nextInt();
            if (decision == 1) {
                teams.add(createNewTeam());
            } else if (decision == 2) {
                addPlayerToTeam();
            } else if (decision == 3) {
                removePlayerFromTeam();
            } else if (decision == 4) {
                describeTeam();
            } else {
                System.out.println("Invalid option");
            }
        }
    }
    private static void printOptions() {
        System.out.println("1. Create New Team");
        System.out.println("2. Add Player");
        System.out.println("3. Remove Player");
        System.out.println("4. View Team Information");
    }

    private static void describeTeam() {
        printTeamNames();
        System.out.print("Which Team Would you like to See? ");
        String teamName = sc.next();
        try {
            Team foundTeam = findTeamByName(teamName);
            foundTeam.describe();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static Team createNewTeam() {
        System.out.println("Enter the name of the team");
        String name = sc.next();
        return new Team(name);
    }
    private static void addPlayerToTeam() {
        printTeamNames();
        System.out.print("Enter the name of the player");
        String teamName = sc.next();
        try {
            Team foundTeam = findTeamByName(teamName);
            foundTeam.addPlayer(createNewPlayer());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static Player createNewPlayer() {
        System.out.print("Enter the name of the player: ");
        String name = sc.next();
        System.out.print("Enter Player Position: ");
        String position = sc.next();
        System.out.print("Enter Player Specialty: ");
        String specialty = sc.next();
        return new Player(name, position, specialty);
    }

    private static void removePlayerFromTeam() {
        printTeamNames();
        System.out.print("Enter the name of the player to remove: ");
        String teamName = sc.next();
        try {
            Team foundTeam = findTeamByName(teamName);
            foundTeam.describe();
            System.out.print("Enter Player You Want To Remove: ");
            String playerName = sc.next();
            foundTeam.removePlayer(playerName);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void printTeamNames() {
        for (Team team : teams) {
            System.out.println(team.getName());
        }
    }
    private static Team findTeamByName(String name) throws Exception {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        throw new Exception("Team Not Found" + name);
    }
}
