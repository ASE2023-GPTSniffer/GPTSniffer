public class Population {
    public static void main(String[] args) {
        final int SECONDS_PER_YEAR = 365 * 24 * 60 * 60; 
        final int BIRTHS_PER_YEAR = SECONDS_PER_YEAR / 7; 
        final int DEATHS_PER_YEAR = SECONDS_PER_YEAR / 13; 
        final int IMMIGRANTS_PER_YEAR = SECONDS_PER_YEAR / 45; 
        int currentPopulation = 312032486; 
        int year = 1; 

        
        for (int i = 0; i < 5; i++) {
            currentPopulation += BIRTHS_PER_YEAR + IMMIGRANTS_PER_YEAR - DEATHS_PER_YEAR;
            System.out.println("Year " + year + ": " + currentPopulation);
            year++;
        }
    }
}
