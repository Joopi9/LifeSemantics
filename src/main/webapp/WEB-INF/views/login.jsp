<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 페이지</title>
<link href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.6.0.js"></script>
<script>
var result='${result}';
if(result == '0'){
	alert("비밀번호가 일치하지 않습니다.")
}else if(result == '-1'){
	alert("아이디가 존재하지 않습니다.")
}

$(document).ready(function(){
	debugger;
	var savedId = '${savedId}';
	if(savedId != null) {
		$("#id").val(savedId);
		$("#remember").prop("checked",true);
	}
	// 빈칸체크
	login();
	// 로그인
	loginBtn();
})

/***************
 * 2022.11.17
 * 빈칸 체크 
 ***************/
function login(){
	$("#loginBtn").click(function(){
		if($("#id").val() == ""){
			alert("아이디를 입력해주세요.");
		}else if($("#password").val() == ""){
			alert("비밀번호를 입력해주세요.")
		}
	})
}

/***************
 * 2022.11.18
 * 로그인 클릭 시
 ***************/
 function loginBtn(){
	var check;
	$('input[type=checkbox][name=remember]').change(function(){
		if($(this).prop("checked")) {
			check = true;
		} else {
			check = false;
		}
	});
	$("#loginBtn").click(function(){
		// remember 값
		var param = JSON.stringify({
				  memberId	: $("#id").val()
				, password	: $("#password").val()
				, remember	: check
		});
		console.log(param);
		
		$.ajax({
			type:		 "POST"
		  , url:		 "/login/loginProcess"
		  , data:		 param
		  , dataType:	 "json"
		  , contentType: "application/json;charset=UTF-8" 	
		  , success:	function(){
			  location.href="/hospital/";
		  }
// 		  , error:		function(XMLHttpRequest, textStatus, errorThrown){
// 			  alert("로그인 실패");
// 		  }
		})
	});
}

</script>
</head>

<body>
<div id="loginform" >
   <h1 class="lifeSemantics">Life Semantics</h1>
      <hr>
      <b>아이디</b>
      <input type="text" name="id" placeholder="Enter id" id="id" required>
      <b>Password</b>
      <input type="password" id="password" name="password" placeholder="Enter password" required>
      <label>
      <input type="checkbox" id="remember" name="remember">
	      로그인 상태 유지
      </label>
      <div class="clearfix">
         <button id="loginBtn" type="submit" class="submitbtn">로그인</button>
      </div>
</div>
</body>
</html>   