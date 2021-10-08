package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class detalleventaDAO {
	
	Conexion cnn= new Conexion();
	Connection con= cnn.Conectar();
	PreparedStatement ps= null;
	ResultSet res= null;

	
public boolean Insertar_detalleventa(detalleventaDTO d) {
		
		boolean resul=false;
		try {
		String sql="insert into detalle_ventas(cantidad_producto,codigo_producto,codigo_venta,valor_venta,valor_total,valor_iva) values(?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setInt(1, d.getCantidadPro());
		ps.setInt(2, d.getCodigo_producto());
		ps.setInt(3, d.getCodigo_venta());
		ps.setDouble(4, d.getValor_ventaD());
		ps.setDouble(5, d.getValor_total());
		ps.setDouble(6, d.getValor_iva());
		
		
		resul=ps.executeUpdate()>0;	//Inserto datos basicos
		if(resul) {
			sql="Select codigo_detalle_venta from detalle_ventas order by codigo_detalle_venta desc limit 1;";
			ps = con.prepareStatement(sql);
			res=ps.executeQuery();
			int codigoD=0;
			while(res.next()) {
				codigoD=res.getInt(1);
			}
			
			/*
			sql="Select codigo_venta from ventas order by codigo_venta desc limit 1;";
			ps = con.prepareStatement(sql);
			res=ps.executeQuery();
			int codigo=0;
			while(res.next()) {
				codigo=res.getInt(1);
			}
			*/
			
		
			
			
			/////////////////////////////////////////////
			
		}
		}catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,"error al insertar prestamo: "+ex);
		}
		return resul;
	}
	
	
	
	
	
	
	
	
	
}
