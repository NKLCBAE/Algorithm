import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_10867_SortWithoutDuplication {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int index = 0;
		int[] arr = new int[set.size()];
		StringBuilder sb = new StringBuilder();
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			arr[index++] = iter.next();
		}
		Arrays.sort(arr);
		for (int i : arr) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}

}
