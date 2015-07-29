package async;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestTree extends HttpServlet {  
	  
    @Override  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
//      System.out.println("--------doGet--------");  
        this.doPost(request, response);  
    }  
  
    @Override  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
//      System.out.println("--------doPost--------");  
        String id = request.getParameter("id");  
        String name = request.getParameter("name");  
        String level = request.getParameter("level");  
        String otherParam = request.getParameter("otherParam");  
        System.out.println(id + "|" + name + "|" + level + "|" + otherParam);  
          
        JSONObject json = new JSONObject();  
        List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();  
          
        for(int i = 0; i < 5; i++){  
            HashMap<String,Object> hm = new HashMap<String,Object>();   //最外层，父节点             
            hm.put("id", id + i);//id属性  ，数据传递    
            hm.put("name", id + i); //name属性，显示节点名称    
            hm.put("pId", id);  
              
            list.add(hm);  
        }  
          
        JSONArray arr = JSONArray.fromObject(list);  
        json.put("success", true);  
        json.put("arr", arr);  
          
        System.out.println("--------json------" + json.toString());  
        response.getWriter().write(arr.toString());  
//      response.getWriter().write(json.toString());  
//      response.getWriter().write("[{pId:'2',name:'20',id:'20'}]");  
    }  
  
}  
