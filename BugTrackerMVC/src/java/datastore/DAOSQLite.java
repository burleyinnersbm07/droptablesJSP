package datastore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Bug;

/**
 * DAOSQLite Data Access Object for an SQLite database
 *
 * @author John Phillips
 * @version 0.3 on 2015-11-03 revised 2015-11-19
 */
public class DAOSQLite {

    protected final static String DRIVER = "org.sqlite.JDBC";
    protected final static String JDBC = "jdbc:sqlite";

    /**
     * Inserts an record into the database table. Note the use of a
     * parameterized query to prevent SQL Injection attacks.
     *
     * @param bug the object to insert
     * @param dbPath the path to the SQLite database
     */
    public static void createRecord(Bug bug, String dbPath) {
        String q = "insert into bug (id, game, operatingsystem, pythonversion, problemdesc, notes) "
                + "values (null, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setString(1, bug.getGame());
            ps.setString(2, bug.getOperatingSystem());
            ps.setString(3, bug.getPythonVersion());
            ps.setString(4, bug.getProblemDesc());
            ps.setString(5, bug.getNotes());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retrieve all of the records in the database as a list sorted by
     * email+date+time. This method was replaced by a more advanced method.
     *
     * @param dbPath the path to the SQLite database
     * @return list of objects
     */
//    public static List<User> retrieveAllRecords(String dbPath) {
//        String q = "select * from user order by email, date, time";
//        List<User> list = null;
//        try (Connection conn = getConnectionDAO(dbPath);
//                PreparedStatement ps = conn.prepareStatement(q)) {
//            list = myQuery(conn, ps);
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOSQLite.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    
//    /**
//     * This is a much more advanced retrieve method. It can get all of the
//     * records from the database or a subset based on the various parameters
//     * passed in.
//     *
//     * @param dbPath the path to the SQLite database
//     * @param email - the email of the user/patient
//     * @param startdate - the starting date of the readings to show
//     * @param enddate - the ending date of the readings to show
//     * @param lowhigh - controls which bloodsugar levels to show; values include all, low, high, and lowhigh
//     * @return list of objects
//     */
//    public static List<Reservation> retrieveRecords(String dbPath, String email, String startdate, String enddate, String lowhigh) {
//        // Need a better solution to the hard coded low/high values below.
//        String q = "select * from user where email like ? and date between ? and ? order by email, date, time";
//        if (lowhigh.equalsIgnoreCase("low")) {
//            q = "select * from user where email like ? and date between ? and ? and bloodsugar < 50 order by email, date, time";
//        } else if (lowhigh.equalsIgnoreCase("high")) {
//            q = "select * from user where email like ? and date between ? and ? and bloodsugar > 200 order by email, date, time";
//        } else if (lowhigh.equalsIgnoreCase("lowhigh")) {
//            q = "select * from user where email like ? and date between ? and ? and (bloodsugar < 50 or bloodsugar > 200) order by email, date, time";
//        }
//
//        List<Reservation> list = null;
//        try (Connection conn = getConnectionDAO(dbPath);
//                PreparedStatement ps = conn.prepareStatement(q)) {
//            // the % sign is an sql wildcard so that we can search by just a few letters of the email name
//            ps.setString(1, email + "%");
//            ps.setString(2, startdate);
//            ps.setString(3, enddate);
//            System.out.println(q);
//            list = myQuery(conn, ps);
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOSQLite.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    
    public static List<Bug> retrieveAllRecords(String dbPath) {
        List<Bug> list = new ArrayList();
        String query = "select * from bug order by game";        
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String game = rs.getString("game");
                String operatingSystem = rs.getString("operatingsystem");
                String pythonVersion = rs.getString("pythonversion");
                String problemDesc = rs.getString("problemdesc");
                String notes = rs.getString("notes");
                Bug r = new Bug(id, game, operatingSystem, pythonVersion, problemDesc, notes);
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in DAOSQLite.retrieveAllRecords()");
        }
        return list;
    }
    
    public static List<Bug> retrieveGameRecords(String dbPath, String gameName) {
        List<Bug> list = new ArrayList();
        String query = "select * from bug where game = '" + gameName + "' order by game";        
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String game = rs.getString("game");
                String operatingSystem = rs.getString("operatingsystem");
                String pythonVersion = rs.getString("pythonversion");
                String problemDesc = rs.getString("problemdesc");
                String notes = rs.getString("notes");
                Bug r = new Bug(id, game, operatingSystem, pythonVersion, problemDesc, notes);
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error in DAOSQLite.retrieveAllRecords()");
        }
        return list;
    }

    /**
     * Delete a record from the database given its id. Note the use of a
     * parameterized query to prevent SQL Injection attacks.
     *
     * @param id the id of the record to delete
     * @param dbPath the path to the SQLite database
     */
    public static void deleteRecord(int id, String dbPath) {
        String q = "delete from bug where id = ?";
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates a new user table.
     *
     * @param dbPath the path to the SQLite database
     */
    public static void createTable(String dbPath) {
        String q = "create table bug ("
                + "id integer not null primary key autoincrement, "
                + "game varchar(20) not null, "
                + "operatingsystem integer not null, "
                + "pythonversion varchar(10) not null, "
                + "problemdesc varchar(10) not null, "
                + "notes varchar(255) null)";
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(q)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Drops the user table erasing all of the data.
     *
     * @param dbPath the path to the SQLite database
     */
    public static void dropTable(String dbPath) {
        final String q = "drop table if exists bug";
        try (Connection conn = getConnectionDAO(dbPath);
                PreparedStatement ps = conn.prepareStatement(q)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQLite.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Populates the table with sample data records.
     *
     * @param dbPath the path to the SQLite database
     */
    public static void populateTable(String dbPath) {
        Bug p;
        p = new Bug(0, "fallingSkies", "Windows 8.1", "2.7.10", "I don't like the colors", "");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "fallingSkies", "ubuntu 14", "2.7.10", "too addicting", "");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "invadersFrom", "windows 7", "2.7.10", "games don't stop", "notes");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "petcemetary", "windows 10", "3.4", "no keyboard input", "I use a dvorak keyboard");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "invadersFrom", "Kubuntu", "2.7.10", "menu doesn't work", "");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "fallingSkies", "osx", "2.7.10", "problem", "apple, right");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "invadersFrom", "windows 7", "2.7.10", "does not close", "");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "fallingSkies", "debian", "3.4", "blank screen", "");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "petcemetary", "fedora", "2.7.10", "looks funny", "");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "petcemetary", "windows 10", "3.4", "another problem", "just want to play games");
        DAOSQLite.createRecord(p, dbPath);
        p = new Bug(0, "petcemetary", "windows 7", "2.7.10", "a problem", "");
        DAOSQLite.createRecord(p, dbPath);
    }

//    /**
//     * A helper method that executes a prepared statement and returns the result
//     * set as a list of objects.
//     *
//     * @param conn a connection to the database
//     * @param ps a prepared statement
//     * @return list of objects from the result set
//     */
//    protected static List<Bug> myQuery(Connection conn, PreparedStatement ps) {
//        List<Bug> list = new ArrayList();
//        try (ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String lastName = rs.getString("lastname");
//                String firstName = rs.getString("firstname");
//                String date = rs.getString("date");
//                String time = rs.getString("time");
//                String notes = rs.getString("notes");
//                Bug r = new Bug(id, lastName, firstName, date, time, notes);
//                list.add(r);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOSQLite.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }

    /**
     * Creates a connection to the SQLite database.
     *
     * @param dbPath the path to the SQLite database
     * @return connection to the database
     */
    protected static Connection getConnectionDAO(String dbPath) {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(JDBC + ":" + dbPath);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
