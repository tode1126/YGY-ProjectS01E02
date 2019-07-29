/**
 * 
 */
function check(f) {
var emailRules = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	if (!emailRules.test(f.email.value)) {
		f.email.value = '';
		swal("Oops", "올바른 형식의 이메일 작성 규칙에 어긋났습니다", "error");
		return false
	}
	
	return true;
}