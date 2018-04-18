/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Task;
import timecontroller.MySQLConnUtils;

/**
 *
 * @author tuandung
 */
public class TaskDA {

    public void Insert(Task task) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnUtils.getMySQLConnection();

        PreparedStatement statement = conn.prepareStatement("INSERT INTO Task(Taskname,DateCreate,DateDeadline,Typetask,Priority,Description) VALUES(?,?,?,?,?,?)");
        statement.setString(1, task.getTaskname());
        statement.setDate(2, task.getDateCreate());
        statement.setDate(3, task.getDateDeadline());
        statement.setString(4, task.getTypetask());
        statement.setInt(5, task.getPriority());
        statement.setString(6, task.getDescription());
        statement.execute();

    }

    // get all task in the table?
    public List<Task> All() throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnUtils.getMySQLConnection();

        PreparedStatement statement = conn.prepareStatement("SELECT * FROM task");
        return toList(statement.executeQuery());
    }
    //public List<Task> FindByName(String s){}

    //convert from result set to list
    public List<Task> toList(ResultSet rs) throws SQLException {
        List<Task> results = new LinkedList<>();
        while (rs.next()) {
            Task t = new Task(
                    rs.getInt(0),
                    rs.get
            );
            results.add(t);
        }
        return results;
    }

}
