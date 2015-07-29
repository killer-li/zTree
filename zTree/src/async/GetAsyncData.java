package async;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import util.DB;

@SuppressWarnings("serial")
public class GetAsyncData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println(req.getParameter("test"));
		
		String gid = req.getParameter("id");
		if(null == gid || "".equals(gid)) {
			gid = "0";
		}
		int id = Integer.parseInt(gid);
		String name = req.getParameter("name");
		System.out.println("要加载的根节点的id: " + id + " 文本：" + name);
		
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		//用Map构造数据源
		Map<String, Object> map = new HashMap<String, Object>();
		Connection con = new DB().getConn();
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from catalog where pId = " + id;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("name", rs.getString("title"));
				map.put("pId", rs.getInt("pId"));
				map.put("isParent", rs.getInt("isParent")==1?true : false);
				String file = rs.getString("file");
				if(null != file && ("".equals(file)) == false) {
					map.put("file", file);
				}
				listMap.add(map);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.getWriter().print(JSONArray.fromObject(listMap).toString());
	}
}
