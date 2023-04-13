/**
 *
 */

/* 게시글 등록, 수정시 입력 필수항목 체크 */
function boardCheck() {
    var $writer = $("#writer");
    var $content = $("#content");
    var $title = $("#title");

    if ($title.val().length == 0) {
        alert("글 제목을 입력해 주세요.");
        $title.focus();
        return false;
    } else if ($title.val().length > 15) {
        alert("글 제목은 15자 이내로 입력가능 합니다.");
        $title.focus();
        return false;
    }

    if ($writer.val().length == 0) {
        alert("작성자 이름을 입력해주세요.");
        $writer.focus();
        return false;
    } else if ($writer.val().length > 5) {
        alert("작성자 이름은 10자 이내로 입력가능 합니다.");
        $writer.focus();
        return false;
    }

    /*
    if (isNaN($pass.val())) {
        alert("비밀번호는 숫자로 입력해 주세요.");
        $pass.focus();
        return false;
    }
    */

    /*
    if ($image.val() == "") {
        alert("상품 이미지를 선택해주세요!");
        $image.focus();
        return false;
    }
    */

    if ($content.val().length == 0) {
        alert("글 내용을 입력해 주세요.");
        $content.focus();
        return false;
    } else if ($content.val().length > 50) {
        alert("글 내용은 100자 이내로 입력가능 합니다.");
        $content.focus();
        return false;
    }

    return true;
}

/* 게시글 수정, 삭제를 위한 비밀번호 입력창 띄우기 */
function open_win(url, name) {
    // url : boardView.jsp에서 넘겨준 BoardServlet?command=board_check_pass_form&num=${board.num}
    // name : update 또는 delete

    window.open(url, name, "width=500, height=200");
}

/* 비밀번호 확인 */
function passCheck() {

    if ($("#pass").val() == "") {
        alert("비밀번호를 입력해 주세요.");
        $("#pass").focus();
        return false;
    }

    return true;
}