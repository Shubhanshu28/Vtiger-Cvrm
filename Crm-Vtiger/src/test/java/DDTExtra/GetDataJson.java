package DDTExtra;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataJson {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader fr = new FileReader("./src/test/resources/cd.json");

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		JSONObject jobj = (JSONObject) obj;
		String url = jobj.get("url").toString();
		String userName = jobj.get("un").toString();
		String password = jobj.get("pwd").toString();
          System.out.println(url);
		System.out.println(userName);
		System.out.println(password);
	}

}
