import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-11-29
 * Time: 20:49
 */
public class CVTETest {
    public static void main(String[] args) {
        String str1 = "welcome to bit";
        String str2 = "come";
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch + "")) {
                list.add(ch);
            }
        }
        for(char ch : list) {
            System.out.println(ch);
        }
    }
}
