import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_16165_GirlGroupMasterJunSeok {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, List<String>> groupToMember = new HashMap<>();
		Map<String, String> memberToGroup = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String group = br.readLine();
			int mem = Integer.parseInt(br.readLine());
			List<String> members = new ArrayList<>();
			for (int j = 0; j < mem; j++) {
				String member = br.readLine();
				members.add(member);
				memberToGroup.put(member, group);
			}
			Collections.sort(members);
			groupToMember.put(group, members);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			int problemType = Integer.parseInt(br.readLine());
			if (problemType == 1) {
				sb.append(memberToGroup.get(s)).append("\n");
			} else {
				for (String m : groupToMember.get(s)) {
					sb.append(m).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
