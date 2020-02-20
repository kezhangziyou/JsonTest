package fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by 刘权 on 2020-2-20.
 * json字符串-简单对象型与Json对象之间的转换:
 * JSON.parseObject：将Json字符串转化为相应的对象
 */
public class JsonStringToJsonObjectTest {
    public static void main(String[] args) {
        //json字符串-简单对象型
        String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
        System.out.println(JSON_OBJ_STR);
        /**
         * json 格式的对象为：

         {
         "studentName":"lily",
         "studentAge":12
         }
         */

        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        String teacherName = jsonObject.getString("studentName");//取得对象的属性值。
        System.out.println(teacherName);
        Integer teacherAge = jsonObject.getInteger("studentAge");
        System.out.println(teacherAge);
    }
}
