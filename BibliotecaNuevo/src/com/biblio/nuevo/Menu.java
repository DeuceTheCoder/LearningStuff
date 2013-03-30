package com.biblio.nuevo;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> options;

    public Menu() {
        options = new ArrayList<String>();
    }

    public String showOptions() {
        String allOptions = "";
        for(String o:options)
            allOptions += "<" + options.indexOf(o) + "> " + o  + '\n';

        return allOptions;
    }

    public void addOption(String s) {
        options.add(s);
    }

    public String selectOption(int i) {
        if (i == -1)
            return "quit";
        else if (i<-1)
            return null;
        else if(i>=options.size())
            return null;
        else
            return options.get(i);
    }
}
