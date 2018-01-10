import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
	// Main method
	public static void main(String [] args)
	{
		// Initialize ArrayList for the working set in puzzleSolve method
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		// Initialize the universe of elements to be tested in puzzleSolve method
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		// Call puzzlieSolve method with size 10 and the two previous sets as arguments
		puzzleSolve(10, ans, nums);
	}
	
	/*
	 * Recursive puzzleSolve method uses recursion to test all the different combinations of 
	 * elements in a set called U. Each time we see a new possible solution, we test that by
	 * calling the evaluate() method.
	 */
	public static void puzzleSolve(int k, ArrayList<Integer> S, ArrayList<Integer> U)
	{
		for(int i=0;  i<U.size(); i++)
		{
			S.add(U.get(i));
			U.remove(i);
			if(k==1)
			{
				if(evaluate(S))
				{
					printAnswer(S);
				}
			}
			else
			{
				puzzleSolve(k-1, S, U);
			}
			//System.out.println(Arrays.toString(S.toArray()));
			U.add(S.get(0));
			S.remove(0);
		}
	}
	
	/*
	 * This method prints the solution found in puzzleSolve. It uses hard coding to
	 * assign the letters from the initial problem to their number in the set using
	 * the different indices of the ArrayList.
	 */
	private static void printAnswer(ArrayList<Integer> poss)
	{
		int F = poss.get(0);
		int O = poss.get(1);
		int R = poss.get(2);
		int T = poss.get(3);
		int Y = poss.get(4);
		int E = poss.get(5);
		int N = poss.get(6);
		int S = poss.get(7);
		int I = poss.get(8);
		int X = poss.get(9);
		
		// This uses string concatenation to print the solution equation.
		// NOTE: These statements DO NOT actually calculate the solution with the correctly assigned variables.
		System.out.print(F +""+ O +""+ R +""+ T +""+ Y + " + ");
		System.out.print(T +""+ E +""+ N + " + ");
		System.out.print(T +""+ E +""+ N + " = ");
		System.out.println(S +""+ I +""+ X +""+ T +""+ Y);
		
		//This prints the assignment of each of the different letter variables from the original problem
		System.out.println("F= " + F);
		System.out.println("O= " + O);
		System.out.println("R= " + R);
		System.out.println("T= " + T);
		System.out.println("Y= " + Y);
		System.out.println("T= " + T);
		System.out.println("E= " + E);
		System.out.println("N= " + N);
		System.out.println("T= " + T);
		System.out.println("E= " + E);
		System.out.println("N= " + N);
		System.out.println("S= " + S);
		System.out.println("I= " + I);
		System.out.println("X= " + X);
		System.out.println("T= " + T);
		System.out.println("Y= " + Y);
		System.out.println("");
	}

	/*
	 * This method uses hard coding to assign each number at the 10 indices to their respective letter variables.
	 * It then multiplies these values by the desired magnitudes and returns a Boolean of the equation from
	 * the initial problem.
	 */
	public static boolean evaluate(ArrayList<Integer> poss)
	{
		int F = poss.get(0);
		int O = poss.get(1);
		int R = poss.get(2);
		int T = poss.get(3);
		int Y = poss.get(4);
		int E = poss.get(5);
		int N = poss.get(6);
		int S = poss.get(7);
		int I = poss.get(8);
		int X = poss.get(9);
		
		// Note that I use "==", making this a Boolean statement
		return 10000*F + 1000*O + 100*R + 10*T + Y + 100*T + 10*E + N + 
				100*T + 10*E + N == 10000*S + 1000*I + 100*X + 10*T + Y;
	}
}

