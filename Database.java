/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queryBuilder;

/**
 *
 * @author arisygdc
 */

import java.sql.*;
import java.util.ArrayList;


public class Database {
    private static Connection konek;
    private final String url = "jdbc:mysql://localhost:3306/library";
    private final String user = "root";
    private final String password = "root";
    protected static String query;
    ArrayList<String> extr = new ArrayList<String>();

    Database() {
        try {
            konek = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Koneksi gagal " + e.getMessage());
        }
    }

    protected static String list(String[] list, int style) {
        String output = "";
        String[] separator = {"",","};
        if (style==1) {
            separator[0] = "'";
            separator[1] = "',";
        }
        for (String s : list) {
            output = output.concat(separator[0] + s + separator[1]);
        }
        output = output.substring(0,(output.length()-1));
        return output;
    }

    public Database insert(String table) {
        query = "INSERT INTO " + table + " (@field/s)";
        return this;
    }

    public Database select(String table) {
        query = "SELECT @field/s FROM " + table ;
        return this;
    }

    public Database update(String table) {
        query = "UPDATE " + table + " SET ";
        return this;
    }

    public Database delete(String table) {
        query = "DELETE FROM " + table;
        return this;
    }

    public Database field(String[] field) {
        String concat = list(field,0);
        query = query.replace("@field/s",concat);
        return this;
    }

    public Database field(String field) {
        query = query.replace("@field/s", field);
        return this;
    }

    public Database value(String[] val) {
        query = query.concat(" VALUES (" + list(val,1) + ")");
        return this;
    }

    public Database value(String val) {
        query = query.concat(" VALUES (" + val + ")");
        return this;
    }

    public Database data(String[][] in) {
        this.field(in[0]);
        this.value(in[1]);
        return this;
    }

    public Database set(String[][] in) {
        for (String[] s : in) {
            query = query.concat(s[0] + " = '" + s[1] + "',");
        }
        query = query.substring(0,(query.length()-1));
        return this;
    }

    //Not-Complete
    public Database set(String field, String value) {
        query = query.concat(field + " = '" + value + "',");
//        query = query.substring(0,(query.length()-1));
        return this;
    }

    //Not-Complete
    public Database innerJoin(String field) {
        query = query.concat("INNER JOIN " + field);
        return this;
    }

    public Database on() {
        return this;
    }

    public Database where(String field, String find) {
        query = query.concat(" WHERE " + field + " = '" + find + "' ");
        return this;
    }

    public Database where(String field, int find) {
        query = query.concat(" WHERE " + field + " = " + find + " ");
        return this;
    }

    public void println() {
        System.out.println(query);
    }

    //Not-Complete
    protected static void fetch() {

    }

    public boolean exec() {
        try {
            PreparedStatement prepare = konek.prepareStatement(query);
            prepare.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
