package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {

	private String bd="Tienda_Organica";
	private String url="jdbc:mysql://localhost:3306/"+bd;
	private String user="root";
	private String pass="";
	Connection conec=null;
	
	public Connection Conectar() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conec= DriverManager.getConnection(url,user,pass);
		System.out.println("Conexion Exitosa!");
		}catch(Exception e) {
			System.out.println("Conexion Fallida!"+e.getMessage());
		}
		return conec;
	}
//	public static void main(String[] args) {
//		Conexion con=new Conexion();
//		con.Conectar();
//	}

}
