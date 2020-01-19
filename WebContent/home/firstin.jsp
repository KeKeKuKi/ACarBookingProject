<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css" type="text/css">
<script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery-1.2.6.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
layui.use(['carousel', 'form'], function(){
  var carousel = layui.carousel
  ,form = layui.form;
  

  
  //设定各种参数
  var ins3 = carousel.render({
    elem: '#test3'
  });
  //图片轮播
  carousel.render({
    elem: '#test10'
    ,width: '1466px'
    ,height: '600px'
    ,interval: 3000
  });
  
  //事件
  carousel.on('change(test4)', function(res){
    console.log(res)
  });
  
  var $ = layui.$, active = {
    set: function(othis){
      var THIS = 'layui-bg-normal'
      ,key = othis.data('key')
      ,options = {};
      
      othis.css('background-color', '#5FB878').siblings().removeAttr('style'); 
      options[key] = othis.data('value');
      ins3.reload(options);
    }
  };
  
  //监听开关
  form.on('switch(autoplay)', function(){
    ins3.reload({
      autoplay: this.checked
    });
  });
  

  

});
</script>

<div class="layui-carousel" id="test10" style="margin-left: 2px;margin-top: 40px">
  <div carousel-item="">
    <div><img src="${pageContext.request.contextPath }/static/images/loginBac.jpg"></div>
    <div><img src="${pageContext.request.contextPath }/static/images/loginBac.jpg"></div>
    <div><img src="${pageContext.request.contextPath }/static/images/loginBac.jpg"></div>
  </div>
</div>
</body>
</html>