
public class TripCostCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the driving distance: ");
        double distance = input.nextDouble();
        System.out.print("Enter the fuel efficiency of the car in miles per gallon: ");
        double mpg = input.nextDouble();
        System.out.print("Enter the price per gallon of fuel: ");
        double pricePerGallon = input.nextDouble();
        
        
        double gallonsUsed = distance / mpg;
        double tripCost = gallonsUsed * pricePerGallon;
        
        
        System.out.printf("The cost of driving %.2f miles at %.2f miles per gallon and $%.2f per gallon is $%.2f.%n",
            distance, mpg, pricePerGallon, tripCost);
    }
}
