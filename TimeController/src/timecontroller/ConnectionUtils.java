/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timecontroller;

import da.TaskDA;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Task;
/**
 *
 * @author tuandung
 */
public class ConnectionUtils {
 
  //
  // Test Connection ...
  //
  public static void main(String[] args) throws SQLException,
          ClassNotFoundException {
 
      System.out.println("Get connection ... ");
 
      // Lấy ra đối tượng Connection kết nối vào database.
      Task task = new Task(
              0, 
              "â  ", 
              new Date(System.currentTimeMillis()), 
              new Date(System.currentTimeMillis()), 
              " ", 
              0, 
              " ");
      //System.out.println("Get connection " + conn);
      new TaskDA().Insert(task);
      System.out.println("Done!");
  }
}
