

import java.util.Arrays;


public class LockerPuzzle{
    public static void main(String[] args) {
        boolean[] lockers = new boolean[100]; 
        for (int student = 1; student <= 100; student++) {
            for (int action = student - 1; action < lockers.length; action += student) {
                lockers[action] = !lockers[action];
            }

        }
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i])
                System.out.print("Locker " + (i+1) + " is open \n");
        }

    }
}
