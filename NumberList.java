import java.util.Scanner;

public class NumberList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
     System.out.println("Input the number of elements:");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        
        System.out.println("Input " + n + " numbers:");
        for (int i = 0; i < n; i++) 
        {
            numbers[i] = scanner.nextInt();  
        }
        
        System.out.println("The numbers you input are:");
        for (int i = 0; i < n; i++) 
        {
            System.out.print(numbers[i] + " ");
        }
        scanner.close(); }
}