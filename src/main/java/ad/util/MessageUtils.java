package ad.util;

import com.alibaba.fastjson.JSONObject;

public class MessageUtils {

	public static String commonReturnMessage(int code, String message) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("message", message);
		return json.toJSONString();
	}

	public static JSONObject strToJSONobject(String str) {
		return JSONObject.parseObject(str);
	}

	public static String jsonRetrunListTotalMessage(int code, String message, Object li, long count) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("message", message);
		json.put("list", li);
		json.put("total", count);
		return json.toJSONString();

	}

	public static String jsonRetrunListMessage(int code, String message, Object li) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("message", message);
		json.put("list", li);
		return json.toJSONString();
	}

	public static String jsonRetrunListMessage(int code, String message, Object li, Object jsonCount) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("message", message);
		json.put("list", li);
		json.put("jsonCount", jsonCount);
		return json.toJSONString();
	}
	public static String jsonRetrunListMessage2(int code, String message, Object li,Object li1, Object jsonCount) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("message", message);
		json.put("list", li);
		json.put("list1", li1);
		json.put("jsonCount", jsonCount);
		return json.toJSONString();
	}

	public static String jsonRetrunListMessage1(int code,int pageSize, String message, Object li,Object li1, Object jsonCount) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("pageSize", pageSize);
		json.put("message", message);
		json.put("list", li);
		json.put("list1", li1);
		json.put("jsonCount", jsonCount);
		return json.toJSONString();
	}
	
	public static String jsonRetrunMessage(int code, String message, Object li, Object proxy, Object firstList,
			Object twoList, Object threeList) {
		JSONObject json = new JSONObject();
		json.put("firstList", firstList);
		json.put("twoList", twoList);
		json.put("threeList", threeList);
		json.put("code", code);
		json.put("message", message);
		json.put("list", li);
		json.put("proxy", proxy);
		return json.toJSONString();
	}

	public static String commonReturnMessage(int code, String message, String imgUrl, String pixel) {
		JSONObject json = new JSONObject();
		json.put("code", code);
		json.put("message", message);
		json.put("commonUrl", imgUrl);
		json.put("pixel", pixel);
		return json.toJSONString();
	}

}
