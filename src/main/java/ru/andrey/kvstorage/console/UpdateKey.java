package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;

public class UpdateKey implements DatabaseCommand {
    private String DatabaseName;
    private String TableName;
    private String Key;
    private String Value;
    private ExecutionEnvironment Environment;

    public UpdateKey(ExecutionEnvironment Environment, String DatabaseName, String TableName, String Key, String Value) {
        this.Environment = Environment;
        this.DatabaseName = DatabaseName;
        this.TableName = TableName;
        this.Key = Key;
        this.Value = Value;
    }
    public DatabaseCommandResult execute() throws DatabaseException {
        try {
            Environment.getDatabase(DatabaseName).get().write(TableName, Key, Value);
            return DatabaseCommandResult.MyDatabaseCommandResult.success("Key was updated");
        } catch (Exception e) {
            return DatabaseCommandResult.MyDatabaseCommandResult.error(e.getMessage());
        }
    }
}