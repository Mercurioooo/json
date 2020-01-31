package Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class demo1 {
	
	private static void map1() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "zs");
		map.put("2","ls");
		map.put("3","ww");
		JSONObject json = new JSONObject(map);
		System.out.println(json);
		/*
		 * {"1":"zs","2":"ls","3":"ww"}
		 * */
	}
	
	private static void object2() {
		Person person = new Person();
		person.setName("zs");
		person.setAge(23);
		person.setAddress(new Address("西安","北京"));
		JSONObject json = new JSONObject(person);
		System.out.println(json);
		/*
{
"address":{"schoolAddress":"北京","homeAddress":"西安"},
"name":"zs",
"age":23}
		 */
	}
	
	public static void string3() throws JSONException{
		// {"name":"zs","age":23}
		//上面的粘贴到“”内会自动转义
		String str = "{\"name\":\"zs\",\"age\":23}";
		JSONObject json = new JSONObject(str);
		System.out.println(json);
	}
	
	public void file4() throws IOException, JSONException {
		//文件->String->json
		InputStream in = super.getClass().getClassLoader().getResourceAsStream("Test/person.json");
		byte[] bs = new byte[10];
		int len = -1;
		StringBuffer sb = new StringBuffer();
		while((len = in.read(bs))!=-1) {
			sb.append(new String(bs,0,len));
		}
		System.out.println(sb);
		JSONObject json = new JSONObject(sb.toString());
		System.out.println(json);
	}
	public static void file5() throws IOException, JSONException {
		//文件->String->json
		String string = FileUtils.readFileToString(new File("/Users/dylan/MyLibrary/EclipseWorkspace/JsonProject/src/Test/person.json"));
		JSONObject json = new JSONObject(string);
		System.out.println(json);
	}
	public static void json6() throws IOException, JSONException {
		Map<String,Person> map = new HashMap<>();
		Person p1 = new Person(23,"zs",new Address("xa","lz"));
		Person p2 = new Person(2,"ls",new Address("lz","cs"));
		Person p3 = new Person(3,"ww",new Address("cs","sh"));
		map.put("zs", p1);
		map.put("ls", p2);
		map.put("ww", p3);
		
		JSONObject json = new JSONObject(map);
		//下面需要写你自己文件的绝对路径
		Writer writer = new FileWriter("/Users/dylan/desktop/jjj.json");
		json.write(writer);
		writer.close();
		//System.out.println(json);
	}
	public static void jsonArray7() throws IOException, JSONException {
		String str = "[{\"classname\":\"ljn\",\"classno\":1},{\"schoolname\":\"hnu\",\"zone\":\"cs\"}]";
		JSONArray array = new JSONArray(str);
		System.out.println(array);
	}
	
	public static void map2jsonArray8() throws IOException, JSONException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "zs");
		map.put("2","ls");
		map.put("3","ww");
		net.sf.json.JSONArray jarray = new net.sf.json.JSONArray();
		jarray = jarray.fromObject(map);
		System.out.println(jarray);
	}
	
	public static void jsonArray2map9() {
		String string = "[{\"classname\":\"ljn\",\"classno\":1},{\"schoolname\":\"hnu\",\"zone\":\"cs\"}]";
		net.sf.json.JSONArray jarray = new net.sf.json.JSONArray();
		jarray = jarray.fromObject(string);
		Map<String,Object> map = new HashMap<>();
		for(int i=0; i < jarray.size();i++){
			Object o = jarray.get(i);
		  net.sf.json.JSONObject json = (net.sf.json.JSONObject)o;
		  Set<String> keys = json.keySet();
		  for(String key:keys){
				Object value = json.get(key);
		    map.put(key,value);
		  }
		}
		System.out.println(map);
	}
	
	
	public static void main(String[] args) throws JSONException, IOException {
//		
//		//1.map
//		System.out.println("map:");
//		map1();
//		//2.object对象
//		System.out.println("对象:");
//		object2();
//		//3.字符串
//		System.out.println("字符串:");
//		string3();
//		//4.文件方法一
//		demo1 demo = new demo1();
//		demo.file4();
//		//5.文件方法二
//		file5();
		//6.生成json文件
//		json6();
//		jsonArray7();
//		map2jsonArray8();
		jsonArray2map9();
		
		
		
		
		
		
		
	}
}
