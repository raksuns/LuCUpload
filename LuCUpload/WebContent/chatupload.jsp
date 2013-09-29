<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
</head>
<body>
<form name="chatImageUpload" action="/chatphoto/chatImageUpload.do" method="post" enctype="multipart/form-data">
	room_id : <input type="text" name="talk_room_id"><br/>
	
	thumbSizeWidth : <input type="text" name="thumbSizeWidth"><br/>
	thumbSizeHeight : <input type="text" name="thumbSizeHeight"><br/>
	originImage : <input type="file" name="originImage"><br/>
	thumbImage : <input type="file" name="thumbImage"><br/>
	
	<input type="submit" name="send" value="submit">
</form>
</body>
</html>