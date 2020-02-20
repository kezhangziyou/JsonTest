# [json的demo实例](https://github.com/kezhangziyou/JsonTest)

## 一、json的基础知识
### 1、普通字符串：
```
var str = "绿叶学习网json教程";
```
### 2、JSON对象：(这是个对象)
```
var jsonObj = {
    "name":"helicopter",
    "age":23,
    "gender":"男"
};
```
其实就是map形式的对象，键和值都是双引号
### 3、JSON字符串：
```
var jsonStr ='
                {
                "name": "helicopter",
                "age":23, 
                "gender": "男"
                }
             ';
```
JSON字符串：符合“JSON格式”的字符串，也就是JSON对象外面加一对单引号。
### 4、json数组结构：
```
var arr =[{
                "键名1":值1,
                "键名2":值2
           },
           {
               "键名3":值3,
               "键名4":值4
            },
    ……
          ]
```
取值;arr[i].key1
## 二、常用的json转换api：
* 1、com.alibaba.fastjson（最常用）  
* 2、net.sf.json：
###  FastJson对于json格式字符串的解析主要用到了下面三个类： 
**1.JSON：fastJson的解析器，用于JSON格式字符串与JSON对象及javaBean之间的转换**   
**2.JSONObject：fastJson提供的json对象**   
**3.JSONArray：fastJson提供json数组对象。**   