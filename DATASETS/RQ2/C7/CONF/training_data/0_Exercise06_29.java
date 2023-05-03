public class TwinPrimes {  public static boolean isPrime(int n) {    if (n <= 1) {      return false;    }    for (int i = 2; i <= Math.sqrt(n); i++) {      if (n % i == 0) {        return false;      }    }    return true;  }  public static void main(String[] args) {    for (int i = 3; i <= 997; i++) {      if (isPrime(i) && isPrime(i + 2)) {        System.out.println("(" + i + ", " + (i + 2) + ")");      }    }  }}
