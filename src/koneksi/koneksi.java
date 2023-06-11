/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.*;
/**
 *
 * @author lucky
 */
public class koneksi {
    private Connection koneksi;
    public Connection connect(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Berhasil Koneksi");
        }catch(ClassNotFoundException ex){
            System.out.println("Gagal Koneksi" + ex);
        }
        String url = "jdbc:mysql://localhost:3306/partstock";
        try{
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil Koneksi DataBase");
        }catch(SQLException ex){
            System.out.println("Gagal Koneksi DataBase" + ex);
        }
        
       return koneksi;
    }
}

//public class koneksi {
//    private Connection koneksi;
//    public Connection connect(){
//        
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Berhasil Koneksi");
//        }catch(ClassNotFoundException ex){
//            System.out.println("Gagal Koneksi" + ex);
//        }
//        String url = "jdbc:mysql://34.128.94.33:3306/partstock";
//        try{
//            koneksi = DriverManager.getConnection(url,"partstock","");
//            System.out.println("Berhasil Koneksi DataBase");
//        }catch(SQLException ex){
//            System.out.println("Gagal Koneksi DataBase" + ex);
//        }
//        
//       return koneksi;
//    }
//}


