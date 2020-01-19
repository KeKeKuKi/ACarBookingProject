<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/layui/css/layui.css"
	type="text/css">
<script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
<script
	src="${pageContext.request.contextPath }/static/js/jquery-1.2.6.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="position: relative;">
	<script type="text/javascript">
function dalete(id) {
	 if(confirm("确实要删除吗？")){
		 $.ajax({
	         url:"${pageContext.request.contextPath }/deleteCar",
	         method:"post",
	         data:{id:id},
	         success:function (result) {
	              window.location.reload();
	              alert("删除成功！");
	         },
	         error:function () {
	             alert("系统异常，删除失败！");
	         }
	     }) 
	 }
}

function edit(id){
	$("#edit-form").show();
	
	$.ajax({
        url:"${pageContext.request.contextPath }/findACarById",
        async:true,
        method:"post",
        data:{id:id},
        success:function (result) {
        	result = result.split(",");
        	console.log(result);
        	var carid = result[0];
        	var carname = result[1];
        	var cartype = result[2];
        	var carprice = result[3];
        	$("#edit-form-id").val(carid);
        	$("#edit-form-name").val(carname);
        	$("#edit-form-type").val(cartype);
        	$("#edit-form-price").val(carprice);
        	//window.location.reload();
        },
        error:function () {
            alert("系统异常,请稍后重试！");
        }
    }) 
	
	
	
}

function hidenform() {
	$("#edit-form").hide();
}

function updateCar(id) {
	 if(confirm("确实要修改吗？")){
		 var carid = $("#edit-form-id").val();
		 var carname = $("#edit-form-name").val();
		 var cartype = $("#edit-form-type").val();
		 var carprice = $("#edit-form-price").val();
		
		 $.ajax({
	         url:"${pageContext.request.contextPath }/updateCar",
	         async:true,
	         method:"post",
	         data:{"carid":carid,"carname":carname,"cartype":cartype,"carprice":carprice},
	         success:function (result) {
	        	 if(result=="true"){
	        		 window.location.reload();
	        		 alert("修改成功！");
	        	 }	
	        	 else
	        		alert("修改失败！");
	              
	         },
	         error:function () {
	             alert("系统异常，修改失败！");
	         }
	     }) 
	 }
}

function addACar() {
	if(confirm("确实要添加此车吗？")){
		 var acarname = $("#acarname").val();
		 var acartype = $("#acartype").val();
		 var acarprice = $("#acarprice").val();
		 if(acarname==""){
			 alert("请输入车名");
		 }
		 if(acartype==""){
			 alert("请输入型号");
		 }
		 if(acarprice==""){
			 alert("请输入价格");
		 }
		
		 $.ajax({
	         url:"${pageContext.request.contextPath }/addCar",
	         async:true,
	         method:"post",
	         data:{"acarname":acarname,"acartype":acartype,"acarprice":acarprice},
	         success:function (result) {
	        	 if(result=="true"){
	        		    alert("添加成功！");
		        	 	$("#acarname").val("");
		        	 	$("#acartype").val("");
		        	 	$("#acarprice").val(""); 
	        	 }else{
	        		 alert("添加失败！");
	        		 $("#acarprice").css("background-color","rgb(255,200,200)");
	        	 }
	         },
	         error:function () {
	             alert("系统异常，添加失败！");
	         }
	     }) 
	 }
}
function changepricecoloer() {
	$("#acarprice").css("background-color","rgb(255,255,255)");
}
</script>
	<script>
	layui.use('element', function() {
		var element = layui.element;

	});
</script>

	<div id="edit-form" style="display: none; position: absolute; z-index: 999;width: 100%;top: 150%;background-color: rgb(80, 80, 80); opacity: 0.8">
		<div style="font-size: 26px; margin: 20px;margin-left: 35%">
			<input type="hidden" id="edit-form-id" name="carid">
			
			<span style="color: white;">车名：</span>
			<input type="text" id="edit-form-name" style="background-color: rgb(100, 100, 100);color: white;z-index: 999;"><br /> 
			
			<span style="color: white;">型号：</span>
			<input type="text" id="edit-form-type" style="background-color: rgb(100, 100, 100);color: white;z-index: 999;"><br /> 
			
			<span style="color: white;">价格：</span>
			<input type="text" id="edit-form-price" style="background-color: rgb(100, 100, 100);color: white;z-index: 999;"><br />
			
			<button type="submit" class="layui-btn" onclick="updateCar()"
				style="margin: 10px;z-index: 999;">立即修改</button>
			<button type="button" class="layui-btn" onclick="hidenform()"
				style="margin: 10px;margin-left: 160px;z-index: 999">取消修改</button>
		</div>
	</div>


	<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
		<ul class="layui-tab-title">
			<li class="layui-this">所有车辆信息维护</li>
			<li>添加车辆信息</li>
		</ul>
		<div class="layui-tab-content" style="height: 100px;">
			<div class="layui-tab-item layui-show">
				<div class="layui-form">
					<button type="button" class="layui-btn layui-btn-normal">
						<a href="${pageContext.request.contextPath }/allCarsServlet?page=1" style="color: white;">显示所有</a>
					</button>

					<form style="display: inline; margin-left: 90px"
						action="${pageContext.request.contextPath }/findById">
						<input name="id" placeholder="输入ID查找"
							style="width: 120px; height: 25px">
						<button type="submit"
							class="layui-btn layui-btn-sm layui-btn-normal">立即查询</button>
					</form>

					<form style="display: inline; margin-left: 90px"
						action="${pageContext.request.contextPath }/findByKeyWord">
						<input name="word" placeholder="输入关键字查找"
							style="width: 200px; height: 25px"> <input type="hidden"
							name="page" value="1">
						<button type="submit"
							class="layui-btn layui-btn-sm layui-btn-normal">立即查询</button>
					</form>

					<form style="display: inline; margin-left: 90px"
						action="${pageContext.request.contextPath }/findByPrice">
						<input name="min" placeholder="最小价格"
							style="width: 120px; height: 25px">-<input name="max"
							placeholder="最大价格" style="width: 120px; height: 25px"> <input
							type="hidden" name="page" value="1">
						<button type="submit"
							class="layui-btn layui-btn-sm layui-btn-normal">立即查询</button>
					</form>


					<table class="layui-table">
						<colgroup>
							<col width="150">
							<col width="150">
							<col width="200">
							<col>
						</colgroup>
						<thead>
							<tr>
								<th>车辆名称</th>
								<th>车辆类型</th>
								<th>车辆价格</th>
								<th>图片展示</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>

						</thead>
						<tbody>
							<c:forEach var="car" items="${requestScope.allCars}">
								<tr id="${car.carId}">
									<td id="td1${car.carId}">${car.carName}</td>
									<td id="td2${car.carId}">${car.carType}</td>
									<td id="td3${car.carId}">${car.carPrice}</td>
									<td><a style="color: blue;"
										href="${car.carPhotoAdress}${car.carType}${car.carName}">${car.carName}</a></td>
									<td><button type="button" class="layui-btn"
											onclick="edit(${car.carId})">
											<i class="layui-icon"></i>
										</button></td>
									<td><button type="button" class="layui-btn"
											onclick="dalete(${car.carId})">
											<i class="layui-icon"></i>
										</button></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
					<c:forEach var="page" items="${requestScope.pageBuffer}">
						<button type="button" class="layui-btn">
							<a style="color: white;" href="${pageContext.request.contextPath }${page.value}">${page.key}</a>
						</button>
					</c:forEach>
				</div>
			</div>
			<div class="layui-tab-item">
				<form class="layui-form" action="" lay-filter="example">
					<div class="layui-form-item">
						<label class="layui-form-label">汽车名称</label>
						<div class="layui-input-block">
							<input type="text" id="acarname" name="acarname" lay-verify="title"
								autocomplete="off" placeholder="请输入汽车名称" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">汽车类型</label>
						<div class="layui-input-block">
							<input type="text" id="acartype" name="acartype" lay-verify="title"
								autocomplete="off" placeholder="请输入汽车类型" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">汽车价格</label>
						<div class="layui-input-block">
							<input type="text" id="acarprice" name="acarprice" lay-verify="title"
								autocomplete="off" onfocus="changepricecoloer()" placeholder="请输入汽车价格" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button type="button" class="layui-btn" lay-filter="demo1" onclick="addACar()">立即添加</button>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,pass: [
      /^[\S]{6,12}$/
      ,'密码必须6到12位，且不能出现空格'
    ]
    ,content: function(value){
      layedit.sync(editIndex);
    }
  });
  
  //监听指定开关
  form.on('switch(switchTest)', function(data){
    layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
      offset: '6px'
    });
    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
  });
  
  //监听提交
  form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })
    return false;
  });
 
  //表单赋值
  layui.$('#LAY-component-form-setval').on('click', function(){
    form.val('example', {
      "username": "贤心" // "name": "value"
      ,"password": "123456"
      ,"interest": 1
      ,"like[write]": true //复选框选中状态
      ,"close": true //开关状态
      ,"sex": "女"
      ,"desc": "我爱 layui"
    });
  });
  
  //表单取值
  layui.$('#LAY-component-form-getval').on('click', function(){
    var data = form.val('example');
    alert(JSON.stringify(data));
  });
  
});
</script>
</body>
</html>