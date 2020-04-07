package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    class MyDatabaseCommandResult implements DatabaseCommandResult {
        private String Result;
        private boolean Status;

        private MyDatabaseCommandResult(String result, boolean status) {
            this.Result = result;
            this.Status = status;
        }

        public static DatabaseCommandResult success(String result) {
            return new MyDatabaseCommandResult(result, true);
        }

        public static DatabaseCommandResult error(String error) {
            return new MyDatabaseCommandResult(error, false);
        }

        public Optional<String> getResult() {
            return this.Status ? Optional.of(this.Result) : Optional.empty();
        }

        public DatabaseCommandStatus getStatus() {
            return this.Status ? DatabaseCommandStatus.SUCCESS : DatabaseCommandStatus.FAILED;
        }

        public boolean isSuccess() {
            return this.Status;
        }

        public String getErrorMessage() {
            return this.Result;
        }
    }
}