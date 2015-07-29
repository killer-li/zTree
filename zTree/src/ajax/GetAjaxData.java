package ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

@SuppressWarnings("serial")
public class GetAjaxData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		List<String> list = new ArrayList<String>();
		
		String s00 = "{id:0, name=\"根路径\"}";
		
		String s11 = "{id:1, pId:0, name:\"ajax演示\"}";
		String s12 = "{id:101, pId:1, name:\"ajax演示11\", file:\"hao123.com\"}";
		String s13 = "{id:102, pId:1, name:\"ajax演示12\", file:\"baidu.com\"}";
		
		String s21 = "{id:2, pId:0, name:\"ajax演示\", open:true}";
		String s22 = "{id:201, pId:2, name:\"ajax演示21\", file:\"hao123.com\"}";
		String s23 = "{id:202, pId:2, name:\"ajax演示22\", file:\"baidu.com\"}";
		
		list.add(s00);
		
		list.add(s11);
		list.add(s12);
		list.add(s13);
		
		list.add(s21);
		list.add(s22);
		list.add(s23);
		
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		
		//用Map构造数据源
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", 0);
		map.put("name", "根目录");
		listMap.add(map);
		
		map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("pId", 0);
		map.put("name", "ajax map 演示");
		map.put("open", true);
		listMap.add(map);
		
		map = new HashMap<String, Object>();
		map.put("id", 101);
		map.put("pId", 1);
		map.put("name", "ajax map 演示101");
		map.put("file", "www.baidu.com");
		listMap.add(map);
		
		map = new HashMap<String, Object>();
		map.put("id", 2);
		map.put("pId", 0);
		map.put("name", "ajax map 演示2");
		listMap.add(map);
		
		map = new HashMap<String, Object>();
		map.put("id", 201);
		map.put("pId", 2);
		map.put("name", "ajax map 演示201");
		map.put("file", "www.baidu.com");
		listMap.add(map);
		
		map = new HashMap<String, Object>();
		map.put("id", 202);
		map.put("pId", 2);
		map.put("name", "ajax map 演示202");
		map.put("file", "www.hao123.com");
		listMap.add(map);
		
		map = new HashMap<String, Object>();
		map.put("id", 3);
		map.put("pId", 0);
		map.put("name", "ajax map 演示3");
		listMap.add(map);
		
		map = new HashMap<String, Object>();
		map.put("id", 301);
		map.put("pId", 3);
		map.put("name", "ajax map 演示302");
		map.put("file", "www.hao123.com");
		listMap.add(map);
		
		//resp.getWriter().print(JSONArray.fromObject(list).toString());
		resp.getWriter().print(JSONArray.fromObject(listMap).toString());
	}
	
}
