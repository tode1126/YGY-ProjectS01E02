var nickCk = 1;

function userCheck() {
	var path = '';
	path = getContextPath();
	window.location.href = path + '/main.do';

}

function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/',
			hostIndex + 1));
}

$(function() {
	$("#hp1").keyup(function() {
		$(this).val($(this).val().replace(/[^0-9]/g, ""));
		if ($(this).val().length == 3)
			$("#hp2").focus();
	});

	$("#hp2").keyup(function() {
		$(this).val($(this).val().replace(/[^0-9]/g, ""));
		if ($(this).val().length == 4)
			$("#hp3").focus();
	});
	$("#hp3").keyup(function() {
		$(this).val($(this).val().replace(/[^0-9]/g, ""));
	});

	$('input[name=nickName]').keyup(function() {
		var nickName = $('input[name=nickName]').val();
		if (nickName.length > 0) {
			$.ajax({
				async : true,
				type : 'POST',
				data : nickName,
				url : "nickNameCheck.do",
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					if (data.cnt > 0) {
						console.log("0");
						nickCk = 0;
					} else {
						// 닉네임이 중복하지 않으면 nickCk = 1 
						console.log("1");
						nickCk = 1;
					}
				},
				error : function(error) {
					alert("error : " + error);
				}
			});
		}
	});

});

function check(f) {

	var passwordRules = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,20}$/;
	if (!passwordRules.test(f.password.value)) {
		f.password.value = '';
		f.password2.value = '';
		swal("Oops", "비밀번호는 영어,숫자,특수문자 조합의 \n 6글자 이상 20자 이하로 입력해주세요", "error");
		return false;
	}

	var nickNameRules = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|\*]{4,20}$/;
	if (!nickNameRules.test(f.nickName.value)) {
		f.nickName.value = '';
		swal("Oops", "닉네임은 한글,영어,숫자로 \n 4글자 이상 20자 이하로 입력해주세요", "error");
		return false;
	}

	if (f.password.value != f.password2.value) {
		swal("Oops", "비밀번호가 서로 맞지않습니다", "error");
		f.password.value = '';
		f.password2.value = '';
		f.password.focus();
		return false;
	}

	if (nickCk == 0) {
		swal("Oops", "사용 불가능한 닉네임 입니다. \n 다시작성해주세요", "error");
		return false;
	}

	f.pass.value = SHA256(f.password.value);

	return true;
}

/**
 * 
 */
