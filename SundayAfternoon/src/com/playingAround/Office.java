package com.playingAround;

import org.springframework.beans.factory.annotation.Autowired;

public class Office {

    private double workToBeDone;
    @Autowired
    private ThoughtWorker dev1;

    public Office(Double work) {
        workToBeDone = work;
//        dev1 = new ThoughtWorker("Ralph");
    }

    public void workOnASundayAfternoon() {
        while (workToBeDone > 0) {
            double productivity = dev1.writeCode();
            if(productivity<=0) {
                System.out.println("You're making things worse. Just call it a day, " + dev1.getName());
                return;
            }
            workToBeDone -= productivity;
            assessWorkStatus(dev1, workToBeDone);
        }
    }

    private void assessWorkStatus(ThoughtWorker ralph, double workToBeDone) {
        if(workToBeDone >= 0) {
            checkEmployeeStatus(ralph);
            System.out.println("And we still have " + workToBeDone + " units of work to do!");
        }
        else
            System.out.println("Good work, " + ralph.getName() + ". Let's go home.");
    }

    private void checkEmployeeStatus(ThoughtWorker worker) {
        System.out.println(worker.getName() + " is working hard at a rate of "
                + (worker.getEfficiencyLevel() + worker.getInebriation())*100
                + " work units/hr, but are now " + worker.getInebriation()*100
                + "% inebriated.");
    }
}