package cat.dto;

import java.util.Date;

public class AttendDto {

    private Integer seq;
    private String id;
    private Date inTime;
    private Date outTime;


    public AttendDto() {}

    public AttendDto(Integer seq, String id, Date inTime, Date outTime) {
        this.seq = seq;
        this.id = id;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }


    @Override
    public String toString() {
        return "AttendDto{" +
                "seq=" + seq +
                ", id='" + id + '\'' +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                '}';
    }
}
