package controller;

import model.SampleModel;
import view.SampleView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alex on 27/03/2017.
 */
public class SampleController implements Observer {

    private final SampleView view;
    private final SampleModel model;

    public SampleController(SampleView view, SampleModel model) {
        this.view = view;
        this.model = model;
        this.view.addUpdateButtonListener(new UpdateButtonListener());
        model.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        String fieldText = model.getField();
        view.updateFieldB(fieldText);
    }

    private final class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fieldAText = view.getFieldAText();
            model.setField(fieldAText);
        }
    }

}
