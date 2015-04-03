package gui.menu;

import config.properties.DialogProperties;

@SuppressWarnings("serial")
public class MenuFile extends A_Menu {

    public MenuFile() {
        super(DialogProperties.Key.File);
        add(new EditProfileAction());
        add(new AddAction());
        add(new ConvertAction());

    }
}
