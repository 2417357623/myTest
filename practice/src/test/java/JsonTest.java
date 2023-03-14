import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @ClassName JsonTest
 * @Description TODO
 * @Author name
 * @Date 2023/3/9
 * @Version 1.0
 **/

public class JsonTest {
    @Test
    public void jsonTest() {
        String jsonString = "{\"package\":{\"List1\":{\"errorCode\":\"0\",\"errorMsg\":\"Success\",\"receiverTradeNum\":\"\"},\"List2\":[{\"medicalNum\":\"15XXXXXX\",\"queryDate\":\"YYYYMMDD\",\"name\":\"XXX\",\"authorizationNum\":\"xxxxx\",\"pageNum\":\"1\"}]}}";
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONObject aPackage = jsonObject.getJSONObject("package");
         JSONArray list2 = aPackage.getJSONArray("List2");
        System.out.println(list2);
        String aPackage1 = jsonObject.getString("package");
        System.out.println(aPackage1);

    }
}

