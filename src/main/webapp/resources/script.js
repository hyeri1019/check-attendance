/**
 * 
 */

/* 
 * 회원가입 화면에서 유효성 검사 
 */
function joinCheck() {
	/* 변수 등록 */
	var $name = $("#name");
	var $jumin = $("#jumin");
	var $id = $("#id");
	var $pwd = $("#pwd");
	
	var juminTest = "123456-1234567";
	
	/* 이름 공백 검사 */
	if($name.val() == "") {
		alert("이름을 형식에 맞게 올바르게 입력해주세요")
		$name.focus();
		return false;
	}
	/* 주민번호 글자수 검사 */
	if($jumin.val().length != juminTest.length) {
		alert("주민등록번호를 형식에 맞게 올바르게 입력해주세요")
		$jumin.focus();
		return false;
	}
	/* 아이디 글자수 검사 */
	if($id.val().length < 4) {
		alert("아이디는 4글자 이상 사용 가능합니다")
		$id.focus();
		return false;
	}
	/* 비밀번호 글자수 검사 */
	if($pwd.val().length < 7 || $pwd.val().length > 14) {
		alert("비밀번호를 형식에 맞게 올바르게 입력해주세요")
		$pwd.focus();
		return false;
	}
	
	return true;
}

/* 
 * 정보수정 화면에서 유효성 검사 
 */
function updateCheck() {
	/* 변수 등록 */
	var $id = $("#id");
	var $pwd = $("#pwd");

	/* 아이디 글자수 검사 */
	if($id.val().length < 4) {
		alert("아이디는 4글자 이상 사용 가능합니다")
		$id.focus();
		return false;
	}
	/* 비밀번호 글자수 검사 */
	if($pwd.val().length < 7 || $pwd.val().length > 14) {
		alert("비밀번호를 형식에 맞게 올바르게 입력해주세요")
		$pwd.focus();
		return false;
	}
	
	return true;
}











