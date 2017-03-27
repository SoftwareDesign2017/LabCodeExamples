package command;

import model.SampleModel;

/**
 * Created by Alex on 27/03/2017.
 */
public class SetTextCommand implements Command {

    private final SampleModel model;
    private final String textValue;

    public SetTextCommand(SampleModel model, String textValue) {
        this.model = model;
        this.textValue = textValue;
    }

    @Override
    public void apply() {
        model.setField(textValue);
    }
}
