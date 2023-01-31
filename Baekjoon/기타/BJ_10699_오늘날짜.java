import java.text.SimpleDateFormat;
import java.util.Date;

public class BJ_10699_오늘날짜 {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println(dateFormat.format(date));
	}

}
