
import java.util.*;

public class RationalTester {

/**
* @param args
*/
public static void main(String[] args) {


Scanner keyboard = new Scanner(System.in);

int a = 0;
int b = 0;
int c = 0;
int d = 0;

System.out.print("Please enter two numbers for the first rational number, separated by a space: ");
a = keyboard.nextInt();
b = keyboard.nextInt();
System.out.print("Please enter two numbers for the second rational number, separated by a space: ");
c = keyboard.nextInt();
d = keyboard.nextInt();
	
RationalNumber r1 = new RationalNumber(a, b);
RationalNumber r2 = new RationalNumber(c, d);
RationalNumber r3, r4, r5, r6, r7, r8;

System.out.println("First rational number: " + r1);
System.out.println("Second rational number: " + r2);

if (r1.isLike(r2)) {
System.out.println("r1 and r2 are equal");
} else {
System.out.println("r1 and r2 are NOT equal");
}

r3 = r1.reciprocal();
r8 = r2.reciprocal();
System.out.println("The reciprocal of r1 is: " + r3);
System.out.println("The reciprocal of r2 is:  " +r8);

r4 = r1.add(r2);
r5 = r1.subtract(r2);
r6 = r1.multiply(r2);
r7 = r1.divide(r2);

System.out.println("r1 + r2: " + r4);
System.out.println("r1 - r2: " + r5);
System.out.println("r1 * r2: " + r6);
System.out.println("r1 / r2: " + r7);
}

}
