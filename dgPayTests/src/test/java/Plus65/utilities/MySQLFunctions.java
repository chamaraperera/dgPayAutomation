package Plus65.utilities;


import net.thucydides.core.annotations.Step;

import org.openqa.selenium.By;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLFunctions {
	

	public  Connection connection = null;
    public  Session session = null;
    
    
	public  void connectToServer(String dataBaseName) throws SQLException {
        connectSSH();
        connectToDataBase(dataBaseName);
    }

    public  void connectSSH() throws SQLException {
        String sshHost = "139.59.230.245";
        String sshuser = "git";
        String userDirectorty =  System.getProperty("user.dir");
        System.out.println(userDirectorty);
        String SshKeyFilepath = userDirectorty+ "/TestData/id_rsa";

        int localPort = 8740; // any free port can be used
        String remoteHost = "10.130.42.217";
        int remotePort = 3306;

        /***************/
        String driverName = "com.mysql.jdbc.Driver";

        try {
            java.util.Properties config = new java.util.Properties();
            JSch jsch = new JSch();
            session = jsch.getSession(sshuser, sshHost, 64222);
            jsch.addIdentity(SshKeyFilepath);
            config.put("userauth.password", "VuchaPHaFR5s");
            config.put("StrictHostKeyChecking", "no");
            config.put("ConnectionAttempts", "3");
            session.setConfig(config);
            session.connect();

            System.out.println("SSH Connected");

            Class.forName(driverName).newInstance();

            int assinged_port = session.setPortForwardingL(localPort, remoteHost, remotePort);

            System.out.println("localhost:" + assinged_port + " -> " + remoteHost + ":" + remotePort);
            System.out.println("Port Forwarded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void connectToDataBase(String dataBaseName) throws SQLException {
        String dbuserName = "arrowme_user";
        String dbpassword = "suzecA5hu?h2";
        int localPort = 8740; // any free port can be used
        String localSSHUrl = "localhost";
        try {

            //mysql database connectivity
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName(localSSHUrl);
            dataSource.setPortNumber(localPort);
            dataSource.setUser(dbuserName);
            dataSource.setAllowMultiQueries(true);

            dataSource.setPassword(dbpassword);
            dataSource.setDatabaseName(dataBaseName);

            connection = dataSource.getConnection();

            System.out.print("Connection to server successful!:" + connection + "\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void closeConnections() {
        CloseDataBaseConnection();
        CloseSSHConnection();
    }
    
    public  void CloseDataBaseConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Closing Database Connection");
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  void CloseSSHConnection() {
        if (session != null && session.isConnected()) {
            System.out.println("Closing SSH Connection");
            session.disconnect();
        }
    }


    // works ONLY FOR  single query (one SELECT or one DELETE etc)
    
	public  ResultSet executeMyQuery(String query, String dataBaseName) {
        ResultSet resultSet = null;

        try {
            connectToServer(dataBaseName);
            Statement stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query);
            System.out.println("Database connection success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       

        return resultSet;
        

        
    }
	
	public  void executeUpdateQuery(String query, String dataBaseName) {


        try {
            connectToServer(dataBaseName);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Database connection success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        finally {
            CloseDataBaseConnection();
            closeConnections();
        }

    }

    public void DeleteOrganisationReferencesFromDB(String organisationsLike) {
        try {
            connectToServer("ServerName");
            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery("select * from DB1");

            String organisationsToDelete = "";
            List<String> organisationsIds = new ArrayList<String>();

            // create string with id`s values to delete organisations references
            while (resultSet.next()) {
                String actualValue = resultSet.getString("id");
                organisationsIds.add(actualValue);
            }

            for (int i = 0; i < organisationsIds.size(); i++) {
                organisationsToDelete = " " + organisationsToDelete + organisationsIds.get(i);
                if (i != organisationsIds.size() - 1) {
                    organisationsToDelete = organisationsToDelete + ", ";
                }
            }

            stmt.executeUpdate(" DELETE FROM `DB1`.`table1` WHERE `DB1`.`table1`.`organisation_id` in ( " + organisationsToDelete + " );");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }

    public  List<String> getOrganisationsDBNamesBySubdomain(String organisationsLike) {
        List<String> organisationDbNames = new ArrayList<String>();
        ResultSet resultSet = executeMyQuery("select `DB`.organisation.dbname from `DB1`.organisation where subdomain like '" + organisationsLike + "%'", "DB1");
        try {
            while (resultSet.next()) {
                String actualValue = resultSet.getString("dbname");
                organisationDbNames.add(actualValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return organisationDbNames;
    }

     public  List<String> getAllDBNames() {
        // get all live db names incentral DB
        List<String> organisationDbNames = new ArrayList<String>();
        ResultSet resultSet = executeMyQuery("show databases", "DB1");
        try {
            while (resultSet.next()) {
                String actualValue = resultSet.getString("Database");
                organisationDbNames.add(actualValue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
        return organisationDbNames;
    }

      public  void deleteDataBasesByName(List<String> DataBasesNamesList) {
        try {
            connectSSH();
            int dataBasesAmount = DataBasesNamesList.size();
            for (int i = 0; i < dataBasesAmount; i++) {
                connectToDataBase(DataBasesNamesList.get(i));

                Statement stmt = connection.createStatement();
                stmt.executeUpdate("DROP database `" + DataBasesNamesList.get(i) + "`");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseDataBaseConnection();
            closeConnections();
        }
    }
      
	public String runSelectQuery(String query, String dbName, String columnName) throws SQLException {

		String actualValue = null;
		try {
			ResultSet resultSet = executeMyQuery(query, dbName);
			resultSet.next();
			actualValue = resultSet.getString(columnName);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return actualValue;



	}
	 
	  

}
