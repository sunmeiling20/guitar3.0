<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
添加吉他：
        <form action="addGuitar" method="get">
         
            <p>
      序列号：<input type="text" name="number">
            </p>  
                <p>
      创建者：<input type="text" name="builder">
            </p>
      
       <p>
     价格：<input type="text" name="price">
            </p>      
      <p>
     类型：<input type="text" name="type">
            </p>
            <p>
      模型：<input type="text" name="model">
            </p>
                    
   <p>   
       
顶部材料：<input type="text" name="topwood">
       </p>
       <p>
      背部材料：<input type="text" name="backwood">
            </p>
      
            <input type="submit" value="查找">
            
        </form>
</body>
</html>