package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;

public class CreateDatabase implements DatabaseCommand{
    private String DatabaseName;
    private ExecutionEnvironment Environment;

    public CreateDatabase(ExecutionEnvironment environment, String databaseName) {
        this.Environment = environment;
        this.DatabaseName = databaseName;
    }

    public DatabaseCommandResult execute() throws DatabaseException {
        try {
            Environment.addDatabase(Environment.getDatabase(DatabaseName).get());
            return DatabaseCommandResult.MyDatabaseCommandResult.success("Database was created");
        } catch (Exception e) {
            return DatabaseCommandResult.MyDatabaseCommandResult.error(e.getMessage());
        }
    }
}