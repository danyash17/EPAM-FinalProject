package com.epam.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/*<div class="account-info-position">You are currently at <b class="${participation}">${listPosition+1}</b> position
        of <b class="participation-amount">${competitionParticipants}</b>
        of ${specialization} specialization(Plan - <b class="participation-amount">${specializationPlan}</b>)
</div>*/
public class CompetitionTag extends SimpleTagSupport {
    private int listPosition;
    private int competitionParticipants;
    private int specializationPlan;
    private String specialization;

    public void setListPosition(int listPosition) {
        this.listPosition = listPosition;
    }

    public void setCompetitionParticipants(int competitionParticipants) {
        this.competitionParticipants = competitionParticipants;
    }

    public void setSpecializationPlan(int specializationPlan) {
        this.specializationPlan = specializationPlan;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String style=getStyle();
        out.write("You are currently at <b class=\""+style+"\">"+(listPosition+1)+
                "</b> position of <b class=\"participation-amount\">"+competitionParticipants+"</b> of "+
                specialization+"specialization(Plan - <b class=\"participation-amount\">"+specializationPlan+")</b>"
                );
    }

    private boolean isEnrolled() {
        if(listPosition+1<=specializationPlan){
            return true;
        }
        else return false;
    }
    private String getStyle(){
        boolean isEnrolled=isEnrolled();
        if(isEnrolled){
            return "participation-winning";
        }
        else return "participation-loosing";
    }
}
