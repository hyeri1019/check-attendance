package cat.dto;

import java.util.Date;
import java.util.Objects;

public class UserDto {

        private String id;
        private String pwd;
        private String name;
        private String jumin;
        private Date regDate;
        private Integer attendance;
        private Integer late;
        private Integer earlyLeave;
        private Integer absence;
        private String role;

        public UserDto() {}
        public UserDto(String id, String pwd, String name, String jumin, Date regDate, Integer attendance, Integer late, Integer earlyLeave, Integer absence, String role) {
            this.id = id;
            this.pwd = pwd;
            this.name = name;
            this.jumin = jumin;
            this.regDate = regDate;
            this.attendance = attendance;
            this.late = late;
            this.earlyLeave = earlyLeave;
            this.absence = absence;
            this.role = role;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJumin() {
            return jumin;
        }

        public void setJumin(String jumin) {
            this.jumin = jumin;
        }

        public Date getRegDate() {
            return regDate;
        }

        public void setRegDate(Date regDate) {
            this.regDate = regDate;
        }

        public Integer getAttendance() {
            return attendance;
        }

        public void setAttendance(Integer attendance) {
            this.attendance = attendance;
        }

        public Integer getLate() {
            return late;
        }

        public void setLate(Integer late) {
            this.late = late;
        }

        public Integer getEarlyLeave() {
            return earlyLeave;
        }

        public void setEarlyLeave(Integer earlyLeave) {
            this.earlyLeave = earlyLeave;
        }

        public Integer getAbsence() {
            return absence;
        }

        public void setAbsence(Integer absence) {
            this.absence = absence;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof cat.dto.UserDto)) return false;
            cat.dto.UserDto userDto = (cat.dto.UserDto) o;
            return Objects.equals(id, userDto.id) && Objects.equals(pwd, userDto.pwd) && Objects.equals(name, userDto.name) && Objects.equals(jumin, userDto.jumin) && Objects.equals(regDate, userDto.regDate) && Objects.equals(attendance, userDto.attendance) && Objects.equals(late, userDto.late) && Objects.equals(earlyLeave, userDto.earlyLeave) && Objects.equals(absence, userDto.absence) && Objects.equals(role, userDto.role);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, pwd, name, jumin, regDate, attendance, late, earlyLeave, absence, role);
        }

        @Override
        public String toString() {
            return "UsersDto{" +
                    "id='" + id + '\'' +
                    ", pwd='" + pwd + '\'' +
                    ", name='" + name + '\'' +
                    ", jumin='" + jumin + '\'' +
                    ", regDate=" + regDate +
                    ", attendance=" + attendance +
                    ", late=" + late +
                    ", earlyLeave=" + earlyLeave +
                    ", absence=" + absence +
                    ", role='" + role + '\'' +
                    '}';
        }
    }