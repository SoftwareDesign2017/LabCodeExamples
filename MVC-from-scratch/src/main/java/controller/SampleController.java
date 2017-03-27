package controller;

import command.Command;
import command.SetTextCommand;
import model.SampleModel;
import view.SampleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alex on 27/03/2017.
 */
public class SampleController implements Observer {

    private final List<Command> commands;

    private final SampleView view;
    private final SampleModel model;

    public SampleController(SampleView view, SampleModel model) {
        this.view = view;
        this.model = model;
        this.view.addUpdateButtonListener(new UpdateButtonListener());
        this.view.addUndoButtonListener(new UndoButtonListener());
        this.commands = new ArrayList<>();
        commands.add(getEmptyTextCommand());
        model.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        String fieldText = model.getField();
        view.updateFieldA(fieldText);
        view.updateFieldB(fieldText);
    }

    private final class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fieldAText = view.getFieldAText();
            model.setField(fieldAText);
            commands.add(new SetTextCommand(model, view.getFieldAText()));
        }
    }

    private final class UndoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!commands.isEmpty()) {
                commands.remove(commands.size() - 1);
            }
            if (commands.isEmpty()) {
                commands.add(getEmptyTextCommand());
            }
            executeCommands();
        }
    }

    private void executeCommands() {
        commands.forEach(Command::apply);
    }

    private SetTextCommand getEmptyTextCommand() {
        return new SetTextCommand(model, "");
    }


}
