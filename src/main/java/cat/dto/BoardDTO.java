package cat.dto;

import java.util.Date;
import java.util.Objects;

public class BoardDTO {
    private Integer board_num;
    private String board_title;
    private String board_content;
    private String board_writer;
    private int view_cnt;
    private int comment_cnt;
    private Date reg_date;

    public Integer getBoard_num() {
        return board_num;
    }

    public void setBoard_num(Integer board_num) {
        this.board_num = board_num;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public String getBoard_writer() {
        return board_writer;
    }

    public void setBoard_writer(String board_writer) {
        this.board_writer = board_writer;
    }

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public int getComment_cnt() {
        return comment_cnt;
    }

    public void setComment_cnt(int comment_cnt) {
        this.comment_cnt = comment_cnt;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "board_num=" + board_num +
                ", board_title='" + board_title + '\'' +
                ", board_content='" + board_content + '\'' +
                ", board_writer='" + board_writer + '\'' +
                ", view_cnt=" + view_cnt +
                ", comment_cnt=" + comment_cnt +
                ", reg_date=" + reg_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardDTO)) return false;
        BoardDTO boardDTO = (BoardDTO) o;
        return Objects.equals(board_num, boardDTO.board_num) && Objects.equals(board_title, boardDTO.board_title) && Objects.equals(board_content, boardDTO.board_content) && Objects.equals(board_writer, boardDTO.board_writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board_num, board_title, board_content, board_writer);
    }
}
