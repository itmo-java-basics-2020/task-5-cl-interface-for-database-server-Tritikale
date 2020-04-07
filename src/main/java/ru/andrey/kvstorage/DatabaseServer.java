package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.console.DatabaseCommands;
import ru.andrey.kvstorage.logic.Database;
import java.util.Optional;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {

        this.env = env;
    }

    public static void main(String[] args) {
        // here you can place code which creates DatabaseServer instance by
        // passing mocked ExecutionEnvironment into it for testing purposes
    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        try {
            String[] CommandsFromText = commandText.split(" ");
            return DatabaseCommands.valueOf(CommandsFromText[0]).getCommand(this.env, CommandsFromText).execute();
        } catch (Exception e) {
            return DatabaseCommandResult.MyDatabaseCommandResult.error(e.getMessage());
        }
    }
}
