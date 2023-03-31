package tn.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table {

    private Connection connection;

    public Table(Connection connection){
        this.connection = connection;
        if(connection == null)return;
        CreateTable();
    }

    public void CreateTable(){
        try {
            PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS Quiz(uuid varchar(100),points int(10),PRIMARY KEY (uuid))");
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void CreatePlayer(String uuid){
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Quiz(uuid,points) VALUES(?,?)");
            ps.setString(1, uuid);
            ps.setInt(2, 0);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int getPoints(String uuid){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Quiz WHERE uuid =?");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("points");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addPoints(String uuid, int points){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Quiz SET points =? WHERE uuid =?");
            ps.setInt(1, points);
            ps.setString(2, uuid);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean PlayerExists(String uuid){
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Quiz WHERE uuid =?");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
