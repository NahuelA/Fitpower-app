package fitpower.model.operational;

import fitpower.model.base.Date;

import java.time.LocalDateTime;

public class AttendanceRecord extends Date {

    private String attendanceRecordId;
    private String clientDni;
    private int attendanceCount;
    private String meetingId;
    private String meetingType;
    private String details;
    private LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public String getClientDni() {
        return clientDni;
    }

    public void setClientDni(String clientDni) {
        this.clientDni = clientDni;
    }

    public String getAttendanceRecordId() {
        return attendanceRecordId;
    }

    public void setAttendanceRecordId(String attendanceRecordId) {
        this.attendanceRecordId = attendanceRecordId;
    }
}
