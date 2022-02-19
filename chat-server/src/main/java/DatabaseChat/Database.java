package DatabaseChat;

import error.WrongCredentialsException;

import java.sql.*;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement ps;
    private static String UPDATE_Statement = "UPDATE accounts (nick) values (?) ;";
    private static final String EXAMPLE_CALL = "{call do_something_prc(?,?,?,?)}";
    private static final String DB_CONNECTION_STRING = "jdbc:sqlite:db/accounts.db";
    private static final String CREATE_REQUEST = "create table if not exists accounts " +
            "(id integer primary key autoincrement, login text, password text, nick text, secret text);";
    private static final String DROP_REQUEST = "drop table if exists accounts;";
    private static final String SIMPLE_INSERT_REQUEST =
            "insert into accounts (login, password, nick, secret) values ('log1','pass1','nick1','secret1'), " +
                    "('log2', 'pass2','nick2','secret2'), ('log3', 'pass3','nick3', 'secret3');";

    private static void massInsertBatchExample()  throws SQLException  {
        var start = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 0; i < 5000; i++) {
            ps.setInt(2, i);
            ps.setString(1, "Student #" + i + 1);
            ps.addBatch();
        }
        ps.executeBatch();
        connection.setAutoCommit(true);
        System.out.println(System.currentTimeMillis() - start);
    }


    public static String preparedStatementExample(String login, String nick2)  throws SQLException  {
        ps = connection.prepareStatement(UPDATE_Statement);
            ps.setString(1,login);
        if(ps.equals(login)) {
            ps.setString(3,nick2);
        }
        return nick2;
    }


    public static String AuthRead (String login, String password)  throws SQLException  {
        try (var resultSet = statement.executeQuery("select login, password, nick from accounts " +
                "where password =? and login=? and nick=?" )) {
            String log = resultSet.getString("login");
            String pass  = resultSet.getString("password");
            String nick  = resultSet.getString("nick");
            if (log.equals(login) & pass.equals(password)) {
                return nick;
            }
            throw new WrongCredentialsException("Wrong username or password");
        }
    }

//    public static void simpleUpdateExample()  throws SQLException  {
//        var count = statement.executeUpdate("update students set name = 'Alex' where score > 90;");
//        System.out.printf("Updated %d rows\n", count);
//    }
//
//    public static void dropExample()  throws SQLException  {
//        statement.execute(DROP_REQUEST);
//    }
//
//    public static void simpleInsertExample()  throws SQLException  {
//        var count = statement.executeUpdate(SIMPLE_INSERT_REQUEST);
//        System.out.printf("Inserted %d rows\n", count);
//    }

    public static void createTable() throws SQLException {
        statement.execute(CREATE_REQUEST);
    }


    public static void connect() throws SQLException   {
        connection = DriverManager.getConnection(DB_CONNECTION_STRING);
        statement = connection.createStatement();
        //ps = connection.prepareStatement(insertStatement);
    }

    public static void disconnect() {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
