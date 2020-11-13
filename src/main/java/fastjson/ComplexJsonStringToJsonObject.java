package fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fastjson.object.Student;

import java.util.List;

/**
 * Created by 刘权 on 2020-2-20.
 */
public class ComplexJsonStringToJsonObject {
	/**
	 * 复杂格式json字符串
	 */
	private static final String COMPLEX_JSON_STR ="{" +
            "\"teacherName\": \"crystall\"," +
            "\"teacherAge\": 27," +
            "\"course\": {" +
            "\"courseName\": \"english\"," +
            "\"code\": 1270" +
            "}," +
            "\"students\": [{" +
            "\"studentName\": \"lily\"," +
            "\"studentAge\": 12" +
            "}, {" +
            "\"studentName\": \"lucy\"," +
            "\"studentAge\": 15" +
            "}]" +
            "}";
    public static void main(String[] args) {
        testComplexJSONStrToJSONObject();
        //testJSONObjectToComplexJSONStr();
    }

    /**
     * json格式字符串->复杂JSONObject
     * ComplexJsonString——>sonObject
     */
    public static  void testComplexJSONStrToJSONObject() {
        //1、Json字符串转化为相应的对象
        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

        //2、获取JSONObject中属性为String的数据
        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        System.out.println("teacherName:  " + teacherName + "   teacherAge:  " + teacherAge);

        //3、获取JSONObject中属性为Object的数据
        JSONObject jsonObjectCourse = jsonObject.getJSONObject("course");
        String courseName = jsonObjectCourse.getString("courseName");
        Integer code = jsonObjectCourse.getInteger("code");
        System.out.println("courseName:  " + courseName + "   code:  " + code);

        //4、取得json对象中的属性值为Array的属性
        JSONArray jsonArrayStudents = jsonObject.getJSONArray("students");
		List<Student> staffList = JSONArray.parseArray(jsonArrayStudents.toString(),Student.class);
		staffList.forEach(student -> System.out.println(student));
        //遍历JSONArray对象
        for (Object object : jsonArrayStudents) {
            //转换对象为接送对象
            JSONObject jsonObjectItem = (JSONObject) object;
            String studentName = jsonObjectItem.getString("studentName");
            Integer studentAge = jsonObjectItem.getInteger("studentAge");
            System.out.println("studentName:  " + studentName + "   studentAge:  " + studentAge);
        }
    }
    /**
     * 复杂JSONObject->json格式字符串
     */
    public static void testJSONObjectToComplexJSONStr() {
        //复杂JSONObject,目标要转换为json字符串,和JSONArray不一样
        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);
        //第一种方式
        //String jsonString = JSONObject.toJSONString(jsonObject);
        //第二种方式
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
    }

}
