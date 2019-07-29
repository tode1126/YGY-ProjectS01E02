function check(f) {
	f.pass.value = SHA256(f.password.value);
	return true;
}

function passError() {
	swal("Oops", "비밀번호가 틀렸습니다 \n 다시시도해주세요", "error");
}

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