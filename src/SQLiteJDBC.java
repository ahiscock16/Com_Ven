import java.sql.*;

public class SQLiteJDBC
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
     /*String sql = "CREATE TABLE EVENTS " +
                   "(EVENTID INTEGER PRIMARY KEY AUTOINCREMENT," +
                   " NAME           TEXT    NOT NULL, " + 
                   " COMEDIAN       VARCHAR(255)     NOT NULL, " + 
                   " DATE          DATE NOT NULL," + 
                   " SEATS        INT NOT NULL)"; */
      /*String sql = "CREATE TABLE BOOKINGS " + 
                    "(BOOKINGID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "CUSTNAME VARCHAR(255) NOT NULL," + 
                    "TICKETS INT NOT NULL," + 
                    "EVENTID INTEGER NOT NULL," + 
                    "FOREIGN KEY (EVENTID) REFERENCES EVENTS(EVENTID))";*/
      String sql = "CREATE TABLE FEEDBACK" +
                    "(FDBKID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "FEEDBK TEXT NOT NULL," +
                    "EVENTID INTEGER NOT NULL," +
                    "FOREIGN KEY(EVENTID) REFERENCES EVENTS(EVENTID))";
      // Brian Duppeeeeee
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }
}
