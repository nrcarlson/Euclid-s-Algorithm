
//package line only needed by netbeans
//package euclidean;

import java.util.*;

/*
 * @author Nick Carlson
 */

public class Euclidean {

    //main driver of the program
    public static void main(String[] args) {
        //get A and B from the user and compute both GCDs
        getInputAndFindGCDs();
    }
    
    //get user input and, if acceptable, find GCDs
    public static void getInputAndFindGCDs(){
        int A = 0;
        int B = 0;
        boolean flag = true;
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        
        //user inputs A
        System.out.println("Please enter an integer A greater than 0:");
        try{
        A = input1.nextInt();
        }catch(InputMismatchException e){
            flag = false;
            System.out.println("You must enter an integer greater than 0!");
            System.exit(0);
        }
        
        //user inputs B
        System.out.println("Please enter an integer B greater than 0:");
        try{
        B = input2.nextInt();
        }catch(InputMismatchException e){
            flag = false;
            System.out.println("You must enter an integer greater than 0!");
        }
        
        //if inputs are integers > 0, compute GCDs
        if(flag == true){
            if((A > 0) && (B > 0)){
                System.out.println("");
                runEuclideanGCD(A,B);
                System.out.println("");
                runAltEuclideanGCD(A,B);
            }else{
                //else, quit
                System.out.println("Both inputs must be greater than 0!");
                System.exit(0);
            }
        }
    }
    
    //find Euclidean GCD using remainders, report # of iterations and execution time
    public static void runEuclideanGCD(int A, int B){
        int count = 1;
        
        long startTime = System.nanoTime();
        int gcd[] = euclideanGCD(A,B,count);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double elapsedTime = (double)duration/1000000.0;
        
        System.out.println("Euclidean GCD (modular method) = " + gcd[0]);
        System.out.println(gcd[1] + " iterations performed by modular method");
        System.out.println("GCD computed in " + elapsedTime + " milliseconds");
    }
    
    //find Euclidean GCD (modular method)
    public static int[] euclideanGCD(int A, int B, int count){
        int a = A;
        int b = B;
        count = 1;
        int[] returns = new int[2];
        
        //while neither a nor b is 0
        while((a != 0) && (b != 0)){
            if(a > b){
                //a = a mod b
                a = a % b;
            }else{
                //b = b mod a
                b = b % a;
            }
            count++;
        }
        //use non-zero value as GCD
        returns[0] =  Math.max(a,b);
        //record # of iterations
        returns[1] = count;
        //return both values for output
        return returns;
    }
    
    //find Euclidean GCD using subtraction, report # of iterations and execution time
    public static void runAltEuclideanGCD(int A, int B){
        int count = 1;
        
        long startTime = System.nanoTime();
        int gcd[] = altEuclideanGCD(A,B,count);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double elapsedTime = (double)duration/1000000.0;
        
        System.out.println("Euclidean GCD (subtraction method) = " + gcd[0]);
        System.out.println(gcd[1] + " iterations performed by subtraction method");
        System.out.println("GCD computed in " + elapsedTime + " milliseconds");
    }
    
    //find Euclidean GCD (subtraction method)
    public static int[] altEuclideanGCD(int A, int B, int count){
        int a = A;
        int b = B;
        count = 1;
        int[] returns = new int[2];
        
        //while a and b are unequal
        while(a != b){
            if(a > b){
                //subtract b from a
                a = a - b;
            }else{
                //subtract a from b
                b = b - a;
            }
            count++;
        }
        //use a as GCD
        returns[0] = a;
        //record # of iterations
        returns[1] = count;
        //return both values for output
        return returns;
    }
    
}
