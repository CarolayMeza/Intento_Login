package Modelo;

public class ventasDTO {

	private int codigo_venta;
	private String cedula_cliente;
	private String cedula_usuario;
	private int codigo_producto;
	private double Iva_venta;
	private double Total_venta;   //valor de venta sin iva
	private double Valor_ventaV;   //totaal_venta+iva_venta
	
	
	private int cod_detalleventa;  //1 por producto insertado
	private int cantidad;
	private int valor_ventaD;

	private double valor_iva;
	private double valor_total;  //valor_iva + valor_venta
	
	
	
	
	public ventasDTO(int codigo_venta, String cedula_cliente, String cedula_usuario, int codigo_producto,
			int cantidad) {
		super();
		this.codigo_venta = codigo_venta;
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.codigo_producto = codigo_producto;
		this.cantidad = cantidad;
	}
	public int getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public String getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(String cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(String cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public double getIva_venta() {
		return Iva_venta;
	}
	public void setIva_venta(double iva_venta) {
		Iva_venta = iva_venta;
	}
	public double getTotal_venta() {
		return Total_venta;
	}
	public void setTotal_venta(double total_venta) {
		Total_venta = total_venta;
	}
	public double getValor_ventaV() {
		return Valor_ventaV;
	}
	public void setValor_ventaV(double valor_ventaV) {
		Valor_ventaV = valor_ventaV;
	}
	public int getCod_detalleventa() {
		return cod_detalleventa;
	}
	public void setCod_detalleventa(int cod_detalleventa) {
		this.cod_detalleventa = cod_detalleventa;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getValor_ventaD() {
		return valor_ventaD;
	}
	public void setValor_ventaD(int valor_ventaD) {
		this.valor_ventaD = valor_ventaD;
	}
	public double getValor_iva() {
		return valor_iva;
	}
	public void setValor_iva(double valor_iva) {
		this.valor_iva = valor_iva;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
