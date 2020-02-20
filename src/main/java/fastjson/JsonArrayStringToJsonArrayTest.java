package fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by 刘权 on 2020-2-20.
 * json字符串-简单对象型与Json对象之间的转换:
 * JSON.parseObject：将Json字符串转化为相应的对象
 */
public class JsonArrayStringToJsonArrayTest {
    //json字符串-数组类型
    private static final String JSON_ARRAY_STR = "[" +
            "{\"studentName\":\"lily\",\"studentAge\":12}," +
            "{\"studentName\":\"lucy\",\"studentAge\":15}]";

    public static void main(String[] args) {
        testJSONStrToJSONArray();
        testJSONArrayToJSONStr();
    }

    /**
     * json数组字符串—>json数组对象
     */
    public static void testJSONStrToJSONArray() {
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);

        //遍历方式1
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                    + jsonObject.getInteger("studentAge"));
        }
        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" +
                    " studentAge:" + jsonObject.getInteger("studentAge"));
        }
    }

    /**
     * json数组对象—>json数组字符串
     */
    public static void testJSONArrayToJSONStr() {
        //已知JSONArray,目标要转换为json字符串
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
        //第一种方式，使用JSONArray的方法
       // String jsonString = JSONArray.toJSONString(jsonArray);
        // 第二种方式
        String jsonString = jsonArray.toJSONString(jsonArray);
        System.out.println(jsonString);
    }

}
