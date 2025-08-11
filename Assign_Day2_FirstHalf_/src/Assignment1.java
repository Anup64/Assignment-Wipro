import java.util.Scanner;
public class Assignment1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char repeat;
		
		do {
			System.out.println("************ MENU ************");
			System.out.println("1. Print Table of a Number");
			System.out.println("2. Calculate Factorial");
			System.out.println("3. Check Prime Number");
			System.out.println("4. Print Fibonacci Series");
			System.out.println("5. Exit");
			System.out.println("************************");
			
			System.out.println("Enter your choice: ");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the number: ");
				int table = sc.nextInt();
				for(int i=1; i<= 10; i++) {
					int table1 = table*i;
					System.out.println(table + " x " + i + " = "+ table1);
				}
				break;
				
			case 2:
				System.out.println("Enter the number: ");
				int fact = sc.nextInt();
				int factorial = 1;
				for (int i=1; i<=fact; i++) {
					factorial = factorial*i;
				}
				System.out.println("Factorial of " + fact + " is "+ factorial);
				break;
				
			case 3:
				System.out.print("Enter the number: ");
				int num = sc.nextInt();
				boolean isPrime = true;
				
				if(num <= 1) {
					isPrime = false;
				}else {
					for(int j =2; j<num; j++){
						if(num % j ==0) {
							isPrime = false;
							break;
						}
						
					}
				}
					if (isPrime) {
						System.out.println(num + " is a prime number.");
					}else {
						System.out.println(num+ " is not a prime number.");
					}
					break;
				
			case 4:
				System.out.print("Enter the number: ");
				int feb = sc.nextInt();
				int a=0, b=1, temp;
				System.out.print("Fibonacci series: ");
				for (int j=1; j <= feb;j++) {
					System.out.print(a+ " ");
					temp= a+b;
					a=b;
					b=temp;
				}
				System.out.println();
				break;
			case 5:
				System.out.print("Exit ");
				break;
			default:
				System.out.println("Invalid Choice");
			
			}
			System.out.print("\nBack to Menu? (Y/N): ");
			repeat = sc.next().charAt(0);
		}while (repeat == 'Y' || repeat == 'y');
		sc.close();
		System.out.println("Program terminated");
		}

	}
	


