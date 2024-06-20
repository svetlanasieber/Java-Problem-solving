package mergeSort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);;

		String input = scanner.nextLine();
	
		scanner.close();
		
		if (input.isEmpty()) {
			return;
		}
		
		Integer[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
		Mergesort.sort(arr);
		
		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
	}
}
