package fastjson.object;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 *
 * @author zhangke
 * @date 2020-2-18
 */
public class StaffTest {

    public static void main(String[] args) {
		//test0();
        //test1();
        //test2();
        test3();
    }

	/**
	 * 1、json对象JSONObject
	 * 2、json对象->json字符串：JSON.toJSONString
	 */
	public static void test0() {

		JSONObject jsonObject =new JSONObject();
		jsonObject.put("name","jack");
		jsonObject.put("sex","12");
		//输出{"sex":"12","name":"jack"}
		System.out.println(jsonObject);

		//JOSN.parseObjet()方法同样可以转换
		Map<String, Object> itemMap = JSONObject.toJavaObject(jsonObject, Map.class);
		System.out.println(itemMap);
	}




    /**
     * 1、json字符串->json对象: JSON.parseObject
	 * 2、json对象->json字符串：JSON.toJSONString
     */
    public static void test1() {

        //如果对象的属性对不上就为空
        String jsonString = "{name:'Antony',age:'12',sex:'male',telephone:'88888'}";
        Staff staff1 = JSON.parseObject(jsonString, Staff.class);
		//输出：Staff{name='Antony', age=12, sex='male', birthday=null}
        System.out.println(staff1.toString());


		Staff staff2 = new Staff();
		staff2.setName("jack");
		staff2.setSex("男");
		staff2.setAge(22);
		staff2.setBirthday(new Date());
		String jsonStr2 = JSON.toJSONString(staff2);
		//输出;{"age":12,"name":"Antony","sex":"male"}
		System.out.println(jsonStr2);
    }

    /**
     * 1、将map->jsonObject：JSONObject.parseObject(JSON.toJSONString(map对象))
	 * 2、将jmap形式的json字符串->map：JSON.parseObject(JSON.toJSONString(itemMap), HashMap.class)
	 * 3、将jsonObject->map：JSONObject.toJavaObject(jsonObject, Map.class)
     */
    public static void test2() {

        Map<String ,String> itemMap1 =new HashMap<>();
        itemMap1.put("name","jack");
        itemMap1.put("sex","12");
        //1、将Map类型的itemInfo转换成jsonString类型
		String jsonString1 = JSON.toJSONString(itemMap1);
		//2、jsonString字符串再经JSONObject转换实现。
		JSONObject itemJSONObj1 = JSONObject.parseObject(jsonString1);
        System.out.println(itemJSONObj1);

		Map<String ,String> itemMap2 =new HashMap<>();
		itemMap2.put("name","jack");
		itemMap2.put("sex","12");
		Map<String,String> map = JSON.parseObject(JSON.toJSONString(itemMap2), HashMap.class);
		System.out.println(map.toString());

		JSONObject jsonObject =new JSONObject();
		jsonObject.put("name","jack");
		jsonObject.put("sex","12");
		//JOSN.parseObjet()方法同样可以转换
		Map<String, Object> itemMap = JSONObject.toJavaObject(jsonObject, Map.class);
		System.out.println(itemMap);
    }

    /**
     * 1、将List<Object>->JSONArray：JSON.toJSONString(List对象)
	 * 2、将JSONArray->List<Object>：JSONArray.parseArray(json字符串)
     */
    public static void test3() {
		List<String>itemList =new  ArrayList<>();
		itemList.add("jack");
		itemList.add("Robot");
		//list和map都需要先转换为json格式的字符串（JSON.toJSONString），在把json格式的字符串转换为json对象
		String jsonString = JSON.toJSONString(itemList);
		System.out.println(jsonString);

		String jsonStr="[\"jack\",\"Robot\"]";
		List<String> jsonArray = JSONArray.parseArray(jsonStr,String.class);
		jsonArray.forEach(s->System.out.println(s));

		String staffListJson = "[{name:'Antony',age:'12',sex:'male',telephone:'88888'},{name:'zhangke',age:'12',sex:'male',telephone:'88888'}]";
		List<Staff> staffList = JSONArray.parseArray(staffListJson,Staff.class);
		staffList.forEach(s->System.out.println(s));

	}


}
