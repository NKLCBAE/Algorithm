import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_1076_Resistance {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, R> map = new HashMap<>();
		map.put("black", new R(0, 1));
		map.put("brown", new R(1, 10));
		map.put("red", new R(2, 100));
		map.put("orange", new R(3, 1000));
		map.put("yellow", new R(4, 10000));
		map.put("green", new R(5, 100000));
		map.put("blue", new R(6, 1000000));
		map.put("violet", new R(7, 10000000));
		map.put("grey", new R(8, 100000000));
		map.put("white", new R(9, 1000000000));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		System.out.println(Long.parseLong(map.get(a).val + "" + map.get(b).val) * map.get(c).mul);
	}

	public static class R {
		int val;
		int mul;

		R(int val, int mul) {
			this.val = val;
			this.mul = mul;
		}
	}

}
