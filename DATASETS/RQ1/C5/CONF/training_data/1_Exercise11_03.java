

import ch_09.exercise09_07.Account;



public class 0_Exercise10_03.java{
    public static void main(String[] args) {

        Account testAcct = new Account(1, 100);

        SavingsAccount testSaves = new SavingsAccount(2, 500);

        CheckingAccount testCheck = new CheckingAccount(3, 1000);

        System.out.println(testAcct.toString());
        System.out.println(testSaves.toString());
        System.out.println(testCheck.toString());

    }

}