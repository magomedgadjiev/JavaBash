package ru.magomed.command.impl;

import ru.magomed.command.api.Command;

import java.util.LinkedList;
import java.util.Queue;

public class CommandConveyor implements Command {

    private Queue<Command> queue = new LinkedList<>();

    @Override
    public boolean execute() {
        boolean success = true;
        while (!queue.isEmpty()) {
            Command command = queue.poll();
            boolean result = command.execute();

            if (!result && command.isRequiredSuccess()) {
                success = false;
                break;
            }
        }
        return success;
    }

    @Override
    public boolean isRequiredSuccess() {
        return true;
    }

    @Override
    public void setRequiredSuccess(boolean flag) {
        ;
    }

    public void add(Command command) {
        queue.add(command);
    }
}
