import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;

//kakao 1번 문제 success	
public class Main {

	public static final String ENTER = "Enter";
	public static final String LEAVE = "Leave";
	public static final String CHANGE = "Change";

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		solution(record);
	}

	public static String[] solution(String[] record) {
		String[] recordInput;
		String id;
		String nickName;
		User user = new User();
		LinkedHashMap<Integer, String> print = new LinkedHashMap<>();
		int temp = 0;
		for (int i = 0; i < record.length; i++) {
			recordInput = record[i].split(" ");
			id = recordInput[1];
			if (recordInput[0].equalsIgnoreCase("ENTER")) {
				nickName = recordInput[2];
				user.add(id, nickName);
				print.put(temp++,id+","+ "님이 들어왔습니다.");
			} else if (recordInput[0].equalsIgnoreCase("LEAVE")) {
				print.put(temp++,id+","+ "님이 나갔습니다.");
			} else if (recordInput[0].equalsIgnoreCase("CHANGE")) {
				nickName = recordInput[2];
				user.change(id, nickName);
			}
		}
		String[] answer = new String[print.size()];
		Iterator<String> it = print.values().iterator();
		temp = 0;
		while (it.hasNext()) {
			String msg = it.next();
			String[] msgSplit = msg.split(",");
			answer[temp] = user.getNickname(msgSplit[0])+msgSplit[1];
			//System.out.println(answer[temp]);
			temp++;
		}
		return answer;
	}

	static class User {
		Hashtable<String, String> user = new Hashtable<>();

		User() {
		}

		public void add(String id, String nickName) {
			user.put(id, nickName);
		}

		public void change(String id, String nickName) {
			user.put(id, nickName);
		}

		public String getNickname(String id) {
			return user.get(id);
		}

	}

}
