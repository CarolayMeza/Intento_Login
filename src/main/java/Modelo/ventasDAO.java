package Modelo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ventasDAO {

	
	Conexion cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null;
	ResultSet res= null;
	
	

	
	
public boolean Insertar_Venta(ventasDTO ven) {
		
		boolean resul=false;
		try {
		String sql="insert into ventas(cedula_cliente,cedula_usuario,iva_venta,total_venta,valor_venta) values(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, ven.getCedula_cliente());
		ps.setString(2, ven.getCedula_usuario());
		ps.setDouble(3, ven.getIva_venta());
		ps.setDouble(4, ven.getTotal_venta());
		ps.setDouble(5, ven.getValor_ventaV());
		
		resul=ps.executeUpdate()>0;	//Inserto datos basicos
		
		
		
		if(resul) {
			sql="Select codigo_venta from ventas order by codigo_venta desc limit 1;";
			ps = con.prepareStatement(sql);
			res=ps.executeQuery();
			int codigo=0;
			while(res.next()) {
				codigo=res.getInt(1);
				
			}
			
		
		}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al insertar prestamo: "+ex);
		}
		return resul;
	}
	
	
	


	
	
	
}
