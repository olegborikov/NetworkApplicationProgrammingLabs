package com.borikov.laba8_1.controller.command;

import java.util.Optional;

public class CommandProvider {
    private CommandProvider() {
    }

    public static Optional<Command> defineCommand(String commandName) {
        Optional<Command> currentCommand;
        if (commandName != null && !commandName.isBlank()) {
            try {
                CommandType currentType = CommandType.valueOf(commandName.toUpperCase());
                currentCommand = Optional.of(currentType.getCommand());
            } catch (IllegalArgumentException e) {
                currentCommand = Optional.empty();
            }
        } else {
            currentCommand = Optional.empty();
        }
        return currentCommand;
    }
}
