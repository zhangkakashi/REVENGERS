package com.revengers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revengers.beans.Video;
import com.revengers.service.IVideoService;
import com.revengers.service.impl.VideoService;

/**
 * Servlet implementation class SearchBar
 */
@WebServlet("/SearchBar")
public class SearchBar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBar() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//String videoName = request.getParameter("videoname");
		IVideoService vs = new VideoService();
		List<Video> list = vs.list();
		//var autoComplete=new AutoComplete('o','auto',['baidu','xinlang'],['http://www.baidu.com','http://www.sina.com']);
		String nameList=null, idList=null;
		for(int i=0;i<list.size();i++){
			if(i==0){
				nameList = "'" + list.get(i).getTitle() + "'";
				idList = "'" + list.get(i).getId() + "'";
			}
			else{
				nameList=nameList + ",'" + list.get(i).getTitle() + "'";
				idList=idList + ",'" + list.get(i).getId() + "'";
			}
		}
		out.print("var autoComplete=new AutoComplete('o','auto',[" + nameList + "],[" + idList + "]);");
		//out.print("autoComplete.start(event);");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
