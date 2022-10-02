import java.util.Scanner;


public class Main {

    static void canRide(String[] riderInfo) {

        // Cast height from riderInfo (str) to int
        int height = Integer.parseInt(riderInfo[0]);



        if ((height > 188) || (height < 122)) {
            System.out.println("Rider CANNOT RIDE!!");
        }
        else if ((riderInfo[1].toLowerCase().equals("y")) || (riderInfo[2].toLowerCase().equals("y"))) {
            System.out.println("Rider CANNOT RIDE!!");
        }
        else {
            System.out.println("Rider can ride the rollercoaster! :)");
        }
    }
    

    // Get Rider info from user input and return array of info
    static String[] getRiderInfo() {

        Scanner sc = new Scanner(System.in);

        // Array to put rider info in to return later
        String[] riderInfo = new String[3];
        
        // Get rider height
        System.out.println("Enter rider height (in cm)");
        riderInfo[0] = new String(sc.nextLine());

        // Get rider back trouble
        System.out.println("Does rider have back trouble? (\"Y\" or \"N\")");
        riderInfo[1] = new String(sc.nextLine());

        // Get rider heart trouble
        System.out.println("Does rider have heart trouble? (\"Y\" or \"N\")");
        riderInfo[2] = new String(sc.nextLine());

        return riderInfo;
    }

    public static void main(String[] args) {

        String[] riderInfo = getRiderInfo();  // Store rider info
        canRide(riderInfo); // Determine if rider can ride or not

    }
}
