<!DOCTYPE html>
<html>
<head>
   <title>Fields helper</title>
   <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="js/ZeroClipboard.js"></script>
   <style type="text/css">
   td,th{
   text-align:center;
   }
    </style>
    
  <link rel="shortcut icon" href="http://o6n610sp1.bkt.clouddn.com/logo.ico">
</head>
<body>
<header>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="javascript:void(0)">Field Helper</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="http://smallsand.github.io/about/" target="_blank">关于</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href='javascriot:void(0)'data-toggle='modal' data-target='#recommendModal'> 提供数据</a></li>
        <li class="dropdown">
          <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">探索<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="javascript:void(0)">命名规范</a></li>
            <li><a href="mailto:1107050213@qq.com?subject=关于Field Helper的网站建议">网站建议</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</header>
<div clase="main-content" style="padding:200px 100px 10px;">
<img src="image/logo3.gif"class="img-responsive center-block img-rounded" width="300" height="300" style="margin-bottom: 50px;"></img>
   <form class="bs-example bs-example-form" role="form">
         <div style="width: 100%;max-width: 60%;margin-left: auto;margin-right: auto;" >
            <div class="input-group">
               <input type="text" class="form-control" id="name-input" placeholder="请输入中文字段名" autocomplete="off">
               <span class="input-group-btn">
                  <button class="btn btn-default" type="button" id="search">
                     Go!
                  </button>
               </span>
            </div><!-- /input-group -->
         </div>
   </form>
   
   <table class="table" style="width: 100%;max-width: 72%;margin-bottom: 20px;margin-top: 80px;margin-left: auto;margin-right: auto;" id="table">
   <thead id="thead">
      <tr>
         <th>中文名</th>
          <th>字段名</th>
         <th>操作</th>
      </tr>
   </thead>
   <tbody id="tbody">

   </tbody>
</table>
      <!-- /END THE FEATURETTES -->
 </div>

	  
<div class="modal fade" id="recommendModal" tabindex="-1" role="dialog" 
   aria-labelledby="recommendLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="recommendLabel">
             感谢您给我们提供数据
            </h4>
         </div>
         <div class="modal-body">
          	  
			<form class="form-horizontal"role="form" id="recommend">
			   <div class="form-group">
			      <label for="firstname" class="col-sm-2 control-label">中文名</label>
			      <div class="col-sm-8">
			         <input type="text" class="form-control" id="firstname" 
			            placeholder="中文名" autocomplete="off">
			      </div>
			   </div>
			   <div class="form-group">
			      <label for="lastname" class="col-sm-2 control-label">英文名</label>
			      <div class="col-sm-8">
			         <input type="text" class="form-control" id="lastname" 
			            placeholder="英文名" autocomplete="off">
			      </div>
			   </div>
			</form>
         </div>
         <div class="modal-footer">
            <button type="button" id="submit-recommend"  data-dismiss="modal" class="btn btn-primary">
         	      提交更改
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->	  

 <script type="text/javascript">
      
     function hide(){
     $("[data-toggle='popover']").popover("hide");
     };
     
     $("#table").hide();
   $("#search").click(function(){
   	 var name=$("#name-input").val();
	 if(name==""){
		 return false;
	 }
       $.ajax({  
	         type:'post',      
	         url:'search/',  
	         data:"name="+name,  
	         cache:false,  
	         dataType:'json',  
	         success:function(data){ 
	          $("#tbody").html("");
	         var tr="<tr>";
	         var leng=data.length;
	         if(leng>0){
	         $("#table").show();
	         }else{
	         $("#table").show();
	         $("#thead").hide();
	          $("#firstname").val(name); 
	         $("tbody").append("<tr><td align='center' colspan='3'>很抱歉，没有结果，给我们<a href='javascriot:void(0)'data-toggle='modal' data-target='#recommendModal'> 推荐</a>？</td><tr>");
	         return;
	         }
	          for(var i=0; i<data.length; i++){
	  		      tr+="<td>"+data[i].name+"</td>";
	  		      tr+="<td>"+data[i].field+"</td>";
     		      tr+="<td><button type='button' class='btn btn-primary clip_button'data-container='body' data-toggle='popover' data-placement='right' data-content='复制成功'>复制</button></td>";
       		      tr+="</tr>";  
       		       }
       		      $("#tbody").append(tr);  
      var client = new ZeroClipboard( $('.clip_button') );

      client.on( 'ready', function(event) {
        // console.log( 'movie is loaded' );

        client.on( 'copy', function(event) {
          event.clipboardData.setData('text/plain',event.target.parentElement.parentElement.cells[1].innerText);
        } );

        client.on( 'aftercopy', function(event) {
          //console.log('Copied text to clipboard: ' + event.data['text/plain']);
        } );
      } );

      client.on( 'error', function(event) {
        // console.log( 'ZeroClipboard error of type "' + event.name + '": ' + event.message );
        ZeroClipboard.destroy();
      } );
       		 
      $(function () 
     { 
     $("[data-toggle='popover']").popover();
     });

      $(function () {  $("[data-toggle='popover']").on('shown.bs.popover', function () {
    	 setTimeout("hide()",1000);
      })});
       		       				
     
         }  
     });
   })
   
   
     $("#submit-recommend").click(function(){
	var firstname=$("#firstname").val();
	var lastname=$("#lastname").val();
	$.ajax({
		url:"recommend/",
		type:"post",
		data:"name="+firstname+"&field="+lastname,
		dataType:"json",
		cache:false,
		success:function(obj){
		}
	})
});
    </script>
</body>
</html>