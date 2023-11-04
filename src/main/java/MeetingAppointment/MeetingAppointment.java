package MeetingAppointment;

import java.util.Date;
import java.util.Objects;

public class MeetingAppointment {
    public enum MeetingType{
        privatMeeting,
        jobMeeting,
        videoCall
    }

    private Date startTime = null;
    private Date endTime = null;
    private String appointmentText = null;
    private MeetingType typeOfMeeting = null;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAppointmentText() {
        return appointmentText;
    }

    public void setAppointmentText(String appointmentText) {
        this.appointmentText = appointmentText;
    }

    public MeetingType getTypeOfMeeting() {
        return typeOfMeeting;
    }

    public void setTypeOfMeeting(MeetingType typeOfMeeting) {
        this.typeOfMeeting = typeOfMeeting;
    }

    public MeetingAppointment(){
        startTime = new Date(System.currentTimeMillis());
        endTime = new Date(startTime.getYear(), startTime.getMonth(), startTime.getDay(), startTime.getHours()+1, 0, 0);
        appointmentText = "new Meeting reserved";
    }

    public MeetingAppointment(Date start, Date end){
        startTime = start;
        endTime = end;
    }

    public MeetingAppointment(Date start, Date end, String appointmentText){
        startTime = start;
        endTime = end;
        this.appointmentText = appointmentText;
    }

    public MeetingAppointment(Date start, Date end, String appointmentText, MeetingType type){
        startTime = start;
        endTime = end;
        this.appointmentText = appointmentText;
        typeOfMeeting = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingAppointment that = (MeetingAppointment) o;
        return Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(appointmentText, that.appointmentText) && typeOfMeeting == that.typeOfMeeting;
    }

    public boolean isValid(){
        if(this.startTime.before(this.endTime))
            return true;
        return false;
    }
}