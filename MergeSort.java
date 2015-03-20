public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = ms.split(new int[] { 5, 3, 7,9,0,1,3,1, 4, 2 });
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public int[] split(int[] arr) {
		if (arr.length == 1)
			return arr;
		else {
			int[] a = new int[arr.length / 2];
			int[] b = new int[arr.length - (arr.length / 2)];

			for (int i = 0; i < arr.length / 2; i++) {
				a[i] = arr[i];
			}
			for (int i = arr.length / 2; i < arr.length; i++) {
				b[i - (arr.length / 2)] = arr[i];
			}

			return merge(split(a), split(b));
		}

	}

	public int[] merge(int[] arr1, int[] arr2) {
		int k = 0, j = 0, i = 0;
		int n = arr1.length + arr2.length;
		int[] arr3 = new int[n];
		while (k != n && j < arr2.length && i < arr1.length) {
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				i++;
			} else {
				arr3[k] = arr2[j];
				j++;
			}
			k++;
		}

		if (j < arr2.length) {
			for (int r = k; r < n; r++){
				arr3[r] = arr2[j];
				j++;
			}
		} else {
			for (int r = k; r < n; r++){
				arr3[r] = arr1[i];
				i++;
			}
		}

		return arr3;
	}
}
