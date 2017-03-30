package controller;

import command.Command;

import java.util.Stack;

/**
 * Created by Alex on 29/03/2017.
 */
public class CommandStack {

    public final Stack<Command> undoStack;
    public final Stack<Command> redoStack;

    public CommandStack() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void push(Command command) {
        redoStack.clear();
        undoStack.push(command);
    }

    public Command undo() {
        if (undoStack.size() > 1) {
            Command lastActionDone = undoStack.peek();
            redoStack.push(lastActionDone);
            undoStack.pop();
        }
        return undoStack.peek();
    }

    public Command redo() {
        if (redoStack.size() > 0) {
            Command lastActionDone = redoStack.peek();
            undoStack.push(lastActionDone);
            redoStack.pop();
        }
        return undoStack.peek();
    }
}
