package starter.wikipedia.services;

import starter.wikipedia.models.Buttons;

import java.util.HashMap;

public class ButtonService {
    public  HashMap<Buttons, String> buttonsHashMap(){
        HashMap<Buttons, String> buttons = new HashMap<>();
        buttons.put(Buttons.JOB, "jobButton");
        buttons.put(Buttons.LINKEDIN, "linkedinButton");
        buttons.put(Buttons.GITHUB, "gitHubButton");
        buttons.put(Buttons.EMAILME, "emailMeButton");
        buttons.put(Buttons.CHANGETHEME, "changeThemeButton");
        return buttons;
    }
}
