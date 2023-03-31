package tn.SQL;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import sun.tools.jconsole.Tab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SqlManager {

    private final String host;
    private final int port;
    private final String userName;

    private final String database;
    private final String password;

    private Connection connection;

    private Table table;



    public SqlManager(FileConfiguration config){
        this.host = config.getString("MySQL.host");
        this.port = config.getInt("MySQL.port");
        this.database = config.getString("MySQL.DatabaseName");
        this.userName = config.getString("MySQL.userName");
        this.password = config.getString("MySQL.password");
        try {
            connect();
            Bukkit.getConsoleSender().sendMessage("§aSuccessfully connected! to the MySQL server");
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("§cCouldn't connect to the MySQL server");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.table = new Table(connection);
    }

    public Table getTable() {
        return table;
    }

    private void connect() throws SQLException, ClassNotFoundException {
        if(isConnected())return;
        String url = "jdbc:mysql://"+host+":"+port+"/"+database;
           connection = DriverManager.getConnection(url, userName,password);
    }


    public boolean isConnected(){
        return  connection !=null;
    }




}
