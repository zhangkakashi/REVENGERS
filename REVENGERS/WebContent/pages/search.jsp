<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.revengers.beans.Video, com.revengers.service.IVideoService,
    com.revengers.service.impl.VideoService, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>

<link rel="stylesheet" type="text/css" href="../css/search.css">
<script src="../js/jquery-1.11.0.js"></script>
<script src="../js/search.js"></script>
</head>
<body>
<h1 align="center">search(Autocomplete Function)</h1>
    <div align="center"><input type="text" style="width:300px;height:20px;font-size:14pt;" id="o" onkeyup="autoComplete.start(event)"></div>
    <div class="auto_hidden" id="auto"></div>
    <%
    IVideoService vs = new VideoService();
	List<Video> list = vs.list();
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
	out.print("<script>var autoComplete=new AutoComplete('o','auto',[" + nameList + "],[" + idList + "]);</script>");
    %>
    <div id="result"> </div>
    <!-- <script src="../js/search_result.js"> </script>-->






<form action = "" method = "post">

<input hidden type= text name="userId" />

<input type=text name="friendId" id="friendId" value="" >
<li class="topButton"><input type="submit" title="search" value="goto" href=""></input></li>
</form>
</body>
</html>