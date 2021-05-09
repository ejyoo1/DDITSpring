/**
 * 회원 시스템 공통 js
 */

function validation(url){
	var userId = document.getElementById("userId").value;
	var userPw = document.getElementById("userPw").value;
	var userPhone = document.getElementById("userPhone").value;
	var userEmail = document.getElementById("userEmail").value;
	
	if(userId == "" || userPw == "" || userPhone == "" || userEmail == ""){
		alert('모든 항목을 입력해 주세요.');
		return;
	} else if(userId == null || userPw == null || userPhone == null || userEmail == null){
		alert('입력한 항목이 유효하지 않습니다. 관리자에게 문의하여 주세요.');
	} else if(userId == 'undefined' || userPw == 'undefined' || userPhone == 'undefined' || userEmail == 'undefined'){
		alert('입력한 항목이 유효하지 않습니다. 관리자에게 문의하여 주세요.');
 	} else {
		goPost(url);
	}
}

function goPost(url){
	var fm = document.getElementById("fm");
	console.log("url : " + url);
	
	fm.action = url;
	fm.method = "post";
	fm.submit();
}

function confirmForm(msg,url,userNo){
	
	console.log(url);
	var message = "";
	if(msg=="delete"){
		message = "삭제하시겠습니까?";
	}
	
	if(confirm(message)){
		$.ajax({
			url : url+"?userNo="+userNo
			,type : "post"
			,data : userNo
			,success : function(data){
				alert("회원이 삭제되었습니다.");
				location.href='memberList';
			}
			,error : function(xhr){
				console.log(xhr);
				alert("회원삭제가 실패하였습니다.");
				location.href='memberList';
			}
		});
	}else{
		history.go(0);
	}
}