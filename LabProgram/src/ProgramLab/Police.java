/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramLab;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author tuandung
 */
public class Police extends Human implements DestroySkill, Comparable<Police> {

    protected int atk = 1;

    public Police(String name, Date dob, Point current_position, int speed, int atk) {
        super(name, dob, current_position, speed);
        this.atk = atk;
    }

    

    Police() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void destroy(Machine target) {
        target.being_destroyed(atk);
    }
//    public int compareTo(Police police) {
//        return (this.getName()+this.getAge()).compareTo(police.getName()+police.getAge());
//        
//    }

    @Override
    public String toString() {
        return "Police{" + "name=" + name + ", age=" + dob.toString() + ", point=" + current_position.toString() + ", speed=" + speed + ", printatk=" + atk + '}';
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
//    public static Police jsonToObject(String s){
//        Police p = new Police("", 0, 0, 0, 0);
//        String[] pairs = s.substring(1, s.length() - 1).split(",");
//        for(String pair : pairs){
//           System.out.println(pair);
//            String[] tokens = pair.split(":|\"");
//            if ("name".equals(tokens[1])){
//                p.setName(tokens[4]);
//                System.out.println(tokens);
//            }
//            if ("age".equals(tokens[1])){
//                try {
//                    p.setAge(Integer.parseInt(tokens[4]));
//                } catch (AgeException ex) {
//                    Logger.getLogger(Main_Lab5.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (NumberFormatException ex) {
//                    Logger.getLogger(Main_Lab5.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }               
//        }
//        System.out.println(p.toString());
//        return p;
//    }

//    @Override
//    public String toString() {
//        return "Police{" + "name=" + name + ", age=" + age + ", current_position=" + current_position + ", speed=" + speed + ", printatk=" + atk + '}';
//    }

    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.atk;
        return (int)(hash+hash);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Police other = (Police) obj;
        return true;
    }

    @Override
    public void climb() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Police o) {
        return 0;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}