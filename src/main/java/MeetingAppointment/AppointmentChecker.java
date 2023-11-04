package MeetingAppointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentChecker {
    ArrayList<MeetingAppointment> calenderMeetings = null;

    public AppointmentChecker(){
        calenderMeetings = new ArrayList<>();
    }

    public AppointmentChecker(ArrayList<MeetingAppointment> calender){
        if(calender == null){
            calenderMeetings = new ArrayList<MeetingAppointment>();
            return;
        }
        for(MeetingAppointment m: calender){
            if(!m.isValid()){
                calenderMeetings = new ArrayList<MeetingAppointment>();
                return;
            }
        }        calenderMeetings = calender;
    }

    /**
     * checks if any given MeetingAppointment fits the current calender
     * returns true in case of a fit and false if not
     * @param meetingToCheck
     * @return
     */
    public boolean checkAppointment(MeetingAppointment meetingToCheck){
        for(MeetingAppointment m: calenderMeetings){
            if(m.getStartTime().before(meetingToCheck.getStartTime())&&meetingToCheck.getStartTime().before(m.getEndTime()))
                return false;
            if(m.getStartTime().before(meetingToCheck.getEndTime())&&meetingToCheck.getEndTime().before(m.getEndTime()))
                return false;
            if(meetingToCheck.getStartTime().before(m.getStartTime())&&m.getEndTime().before(meetingToCheck.getEndTime()))
                return false;
            if(meetingToCheck.getEndTime().equals(m.getStartTime())||meetingToCheck.getStartTime().equals(m.getEndTime()))
                return false;
            if(meetingToCheck.getStartTime().equals(m.getStartTime())||meetingToCheck.getEndTime().equals(m.getEndTime()))
                return false;
        }

        return true;
    }

    /**
     * removes any given meeting from current calender
     * returns true in case of a success and false in case of failure
     * @param meeting
     * @return
     */
    public boolean removeMeeting(MeetingAppointment meeting){
        if(calenderMeetings.contains(meeting)){
            calenderMeetings.remove(meeting);
            return true;
        }
        return false;
    }

    /**
     * changes start and end time of any given meeting that is also part of the current calender
     * returns true in case of a success and false in case of failure
     * @param meeting
     * @param start
     * @param end
     * @return
     */
    public boolean changeMeeting(MeetingAppointment meeting, Date start, Date end){
        if(calenderMeetings.contains(meeting)){
            meeting.setStartTime(start);
            meeting.setEndTime(end);
            return true;
        }
        return false;
    }

    /**
     * adds any given meeting to the calender
     * returns true in case of a success and false in case of failure
     * @param meeting
     * @return
     */
    public boolean addMeeting(MeetingAppointment meeting){
        if(!this.checkAppointment(meeting)){
            return false;
        }
        if(!meeting.isValid()){
            return false;
        }
        calenderMeetings.add(meeting);
        return true;

    }
}