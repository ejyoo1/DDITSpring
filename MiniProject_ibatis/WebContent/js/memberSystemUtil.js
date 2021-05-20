/**
 * 회원 시스템 공통 js
 */
idFlag = false;
//runIdCheckFlag = false;

$(document).ready(function(){
	 $("#userId").keydown(function(){ // 아이디 입력 시 check 초기화
		 console.log("키보드 입력 이벤트 발생");
		 idFlag = false;
		 $("#userId").attr({"class":"form-control"});
		 $("#idchk").text(idFlag);
	 });
});

function confirmMessage(type,url){
	if(type=="delete"){
		if (confirm("정말 삭제하시겠습니까??") == true){
			goLocation(url);
		}else{
		    return;
		}
	}
}

function goLocation(url){
	location.href = url;
}

//ID 유효성 검사
function validationId(reqContextPath){
	var userId = $("#userId").val();
	
	// 빈 값 체크
	if(isEmpty(userId)){
		alert("아이디가 입력되지 않았습니다.");
		$("#userId").focus();
	    return;
	}
	
	// 공백 체크
	if(hasBlank(userId)) {
		alert("아이디에 빈 칸은 입력하실 수 없습니다.");
		$("#userId").focus();
		return false;
	}
	
    var regExp = /^(?=.*[a-z])[a-z0-9]{4,12}$/;
    if(!regExp.test(userId)){ // 정규식 값에 맞는지 확인함.
    	alert("4~12자 영문 소문자, 숫자를 사용하세요. 영문 소문자는 필수입니다.");
    	$("#userId").focus();
    	return;
    }
    
    chkId(userId,reqContextPath);
}

// ajax chkId
function chkId(userId,reqContextPath){
	idFlag = false;
//	runIdCheckFlag = true;
	
	$.ajax({
		url : reqContextPath+"/memberList?userId="+userId
		, type : "post"
		, async : false
		, success : function(data){
			console.log(data);
			if(data > 0){
				idFlag = false;
				alert("중복된 아이디가 존재합니다.");
				$("#userId").attr({"class":"form-control is-invalid"});
		    	$("#userId").focus();
		    	$("#idchk").text(idFlag);
		    	return;
			}else{
				idFlag = true;
				alert("사용가능한 아이디입니다.");
				$("#userId").attr({"class":"form-control is-valid"});
				$("#idchk").text(idFlag);
			}
		}
		, error : function(xhr){
			console.log(xhr);
			alert("ID 중복 검사 중 오류가 발생했습니다. 관리자에게 문의하세요.");
		}
	});
}

function goPost(url){
	var fm = document.getElementById("fm");
	
	fm.action = url;
	fm.method = "post";
	fm.submit();
}

// 빈 값 체크
function isEmpty(val) {
	if(val == undefined) return true;
	if(val == null) return true;
	if(val == "null") return true;
	
	val = jQuery.trim(val);
	if(val.length == 0) return true;
	
	return false;
}

//공백 체크
function hasBlank(str) {
	return str.match(" ");
}

//정규식 확인
function checkRegExp(str, regExp) {
	return regExp.test(str);
}
