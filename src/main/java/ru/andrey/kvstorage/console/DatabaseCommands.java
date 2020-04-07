package ru.andrey.kvstorage.console;

public enum DatabaseCommands {
    CREATE_DATABASE{
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args.length != 2) {
                throw new IllegalArgumentException("Wrong number of arguments");
            }
            return new CreateDatabase(env, args[1]);
        }
    },
    CREATE_TABLE{
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args.length != 3) {
                throw new IllegalArgumentException("Wrong number of arguments");
            }
            return new CreateTable(env, args[1], args[2]);
        }
    },
    READ_KEY{
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args.length != 4) {
                throw new IllegalArgumentException("Wrong number of arguments");
            }
            return new ReadKey(env, args[1], args[2], args[3]);
        }
    },
    UPDATE_KEY{
        public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
            if (args.length != 5) {
                throw new IllegalArgumentException("Wrong number of arguments");
            }
            return new UpdateKey(env, args[1], args[2], args[3], args[4]);
        }
    };
    public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String... args);
}
