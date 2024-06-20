package mergeSort;

@SuppressWarnings("rawtypes")
public class Mergesort {
	public static void sort(Comparable[] arr) {
		Comparable[] aux = new Comparable[arr.length];
		sort(aux, arr, 0, arr.length - 1);
	}
	
	private static void sort(Comparable[] aux, Comparable[] arr, int right, int left) {
		if (right >= left) {
			return;
		}
		
		int mid = right + (left - right) / 2;
		
		sort(aux, arr, right, mid);
		sort(aux, arr, mid + 1, left);
		merge(aux, arr, right, mid, left);
	}

	private static void merge(Comparable[] aux, Comparable[] arr, int left, int mid, int right) {
		if (isLess(arr[mid], arr[mid + 1])) {
			return;
		}
		
		for (int index = left; index < right + 1; index++) {
			aux[index] = arr[index];
		}
		
		int i = left; // left array start index
		int j = mid + 1; // right array start index
		
		for (int k = left; k <= right; k++) {
			if (i > mid) {
				arr[k] = aux[j];
				j++;
			} else if (j > right) {
				arr[k] = aux[i];
				i++;
			} else if (isLess(aux[i], arr[j])) {
				arr[k] = aux[i];
				i++;
			} else {
				arr[k] = aux[j];
				j++;
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static boolean isLess(Comparable current, Comparable other) {
		return current.compareTo(other) < 0;
	}
}
