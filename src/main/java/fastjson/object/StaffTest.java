package fastjson.object;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Created by 刘权 on 2020-2-18.
 */
public class StaffTest {

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
    }

    /**
     * json字符串和json对象相互转换
     */
    public static void test1() {
        //如果对象的属性对不上就为空
        String jsonString = "{name:'Antony',age:'12',sex:'male',telephone:'88888'}";
        Staff staff = JSON.parseObject(jsonString, Staff.class);
        System.out.println(staff.toString());//输出：Staff{name='Antony', age=12, sex='male', birthday=null}
        String jsonStr = JSON.toJSONString(staff);
        System.out.println(jsonStr); //输出;{"age":12,"name":"Antony","sex":"male"}
    }

    /**
     * json对象转化为json字符串
     */
    public static void test2() {

        Staff staff = new Staff();
        staff.setName("jack");
        staff.setSex("男");
        staff.setAge(22);
        staff.setBirthday(new Date());
        String jsonStr = JSON.toJSONString(staff);
        System.out.println(jsonStr); //输出;{"age":12,"name":"Antony","sex":"male"}
    }

    /**
     * 3、将map转换成jsonObject 
     */
    public static void test3() {
        Map<String ,String> itemMap =new HashMap<>();
        itemMap.put("name","jack");
        itemMap.put("sex","12");
        //将Map类型的itemInfo转换成jsonString类型，再经JSONObject转换实现。
        JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(itemMap));
        System.out.println(itemJSONObj);
    }

    /**
     * 4、将List转换成JSONArray
     */
    public static void test4() {
        List<String>itemList =new  ArrayList<>();
        itemList.add("jack");
        itemList.add("Robot");
        //list和map都需要先转换为json格式的字符串（JSON.toJSONString），在把json格式的字符串转换为json对象
        System.out.println(JSON.toJSONString(itemList));
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(itemList));
        System.out.println(jsonArray);
    }

    /**
     * 5、将jsonObject转换成Map
     */
    public static void test5() {
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("name","jack");
        jsonObject.put("sex","12");
        //JOSN.parseObjet()方法同样可以转换
        Map<String, Object> itemMap = JSONObject.toJavaObject(jsonObject, Map.class);
        System.out.println(itemMap);
    }
}
