package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;

public class ReadKey implements DatabaseCommand {
    private String DatabaseName;
    private String TableName;
    private String Key;
    private ExecutionEnvironment Environment;

    public ReadKey(ExecutionEnvironment Environment, String DatabaseName, String TableName, String Key) {
        this.Environment = Environment;
        this.DatabaseName = DatabaseName;
        this.TableName = TableName;
        this.Key = Key;
    }
    public DatabaseCommandResult execute() throws DatabaseException {
        try {
            return DatabaseCommandResult.MyDatabaseCommandResult.
                    success(Environment.getDatabase(DatabaseName).get().read(TableName, Key));
        } catch (Exception e) {
            return DatabaseCommandResult.MyDatabaseCommandResult.error(e.getMessage());
        }
    }
}