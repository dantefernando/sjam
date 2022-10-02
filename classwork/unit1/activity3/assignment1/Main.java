import java.util.Scanner;  

class Main {

    public static void main(String[] args) {

      Scanner keyedInput = new Scanner(System.in);  
      String inputAmount = "";  
      double inputAmountDouble;
      int totalCents, totalToonies, totalLoonies, totalQuarters, totalDimes, totalNickels, totalPennies;
      int leftoverCents = 0;
      
      System.out.println("Enter the amount of money: ");
      
      inputAmount = keyedInput.nextLine();
      
      inputAmountDouble = Double.parseDouble(inputAmount);
      totalCents = (int)(inputAmountDouble * 100);

      totalToonies = totalCents/200;
      leftoverCents = totalCents%200;

      totalLoonies = leftoverCents/100;
      leftoverCents = leftoverCents%100;
      
      totalQuarters = leftoverCents/25;
      leftoverCents = leftoverCents%25;
      
      totalDimes = leftoverCents/10;
      leftoverCents = leftoverCents%10;
      
      totalNickels = leftoverCents/5;
      totalPennies = leftoverCents%5;
      
      System.out.println("$" + inputAmount +" is the same as: ");
      System.out.println(totalToonies + " toonies,");
      System.out.println(totalLoonies + " loonies,");
      System.out.println(totalQuarters + " quarters,");
      System.out.println(totalDimes + " dimes,");
      System.out.println(totalNickels + " nickels, and"); 
      System.out.println(totalPennies + " pennies."); 

    }
}

