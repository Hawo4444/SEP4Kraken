package persistance;

import java.sql.*;

public class JDBCConnector
{
    private Connection connection;
    private String workingSchema;

    public JDBCConnector(String workingSchema)
    {
        this.workingSchema = workingSchema;
    }

    public void connect(int portNo, String userName, String password)
    {
        // Establishing a PostgreSQL database connection
        String databaseUrl = "jdbc:postgresql://localhost:" + portNo + "/postgres";

        try
        {
            connection = DriverManager.getConnection(databaseUrl, userName, password);
            System.out.println("Connection established to: " + databaseUrl);
        }
        catch (Exception exception)
        {
            System.out.println("Connection failed");
            exception.printStackTrace();
        }
    }

    public void close()
    {
        // Close the connection
        try
        {
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException exception) {
            System.out.println("Connection closing failed");
            exception.printStackTrace();
        }
    }
}
