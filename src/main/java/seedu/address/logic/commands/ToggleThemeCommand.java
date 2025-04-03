package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Toggle the Ui Theme
 */
public class ToggleThemeCommand extends Command {

    public static final CommandType COMMAND_TYPE = CommandType.TOGGLETHEME;

    public static final String MESSAGE_TOGGLE_THEME_ACKNOWLEDGEMENT = "Switching Theme as requested ...";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_TOGGLE_THEME_ACKNOWLEDGEMENT, false, false, true);
    }

}
