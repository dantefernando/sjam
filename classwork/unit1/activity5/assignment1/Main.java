
class Main {

    public static void main(String[] args) {

        int myNum = 11;
        int mySum = 0;

        while (myNum >= 0) {
             myNum--;
             mySum += myNum * 5;
             System.out.println("loop: myNum: "+ myNum);
             System.out.println("loop: mySum: "+ mySum + "\n");
        }

        System.out.println ("myNum: " + myNum);
        System.out.println ("mySum: " + mySum);

    }
}
