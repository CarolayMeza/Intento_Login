package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Modelo.clientesDAO;
import Modelo.clientesDTO;
import Modelo.productosDAO;
import Modelo.productosDTO;
import Modelo.usuariosDAO;
import Modelo.usuariosDTO;
import Modelo.ventasDAO;
import Modelo.ventasDTO;

/**
 * Servlet implementation class Controlador_ventas
 */
@WebServlet("/Controlador_ventas")
public class Controlador_ventas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controlador_ventas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//CONSULTA DE CLIENTE
		if (request.getParameter("consultarC") != null) {
			clientesDAO clie = new clientesDAO();

			String cedula_C, nombre;
			cedula_C = request.getParameter("cedula_C");

			clientesDTO cli = clie.Buscar_Cliente(cedula_C);

			if (cli != null) {
				cedula_C = cli.getCedula();
				nombre = cli.getNombre();
				response.sendRedirect("ventas.jsp?ced=" + cedula_C + "&&nombre=" + nombre);
			} else {
				response.sendRedirect("ventas.jsp?men=El Cliente no existe");
			}
		}

		
		///CONSULTA DE USUARIO
		if (request.getParameter("consultarE") != null) {
			usuariosDAO usu = new usuariosDAO();

			String cedula_E, nombreU;
			cedula_E = request.getParameter("cedula_E");

			usuariosDTO us = usu.Buscar_Usuario(cedula_E);

			if (us != null) {
				cedula_E = us.getCedula();
				nombreU = us.getNombre();
				response.sendRedirect("ventas.jsp?cedU=" + cedula_E + "&&nombreU=" + nombreU);
			} else {
				response.sendRedirect("ventas.jsp?men=El empleado no existe");
			}
		}

		
		//CONSULTA DE PRODUCTO 1
		if (request.getParameter("ConsultarP1") != null) {

			productosDAO prod = new productosDAO();

			String codigoP, nombreP;
			Double precioP, ivaP;
			codigoP = request.getParameter("codigoP");

			productosDTO produc = prod.Buscar_Producto(codigoP);

			if (produc != null) {
				codigoP = produc.getCodigo_producto();
				nombreP = produc.getNombre_producto();
				precioP = produc.getPrecio_venta();
				ivaP=produc.getIvacompra();
				response.sendRedirect("ventas.jsp?codP=" + codigoP + "&&nombreP=" + nombreP + "&&precioP=" + precioP + "&&ivaP=" + ivaP);
			} else {
				response.sendRedirect("ventas.jsp?men=El PRODUCTO 1 no existe");
			}
		}
		
		//CONSULTA DE PRODUCTO 2
		if (request.getParameter("ConsultarP2") != null) {
			productosDAO prod = new productosDAO();

			String codigoP2, nombreP2;
			Double precioP2, ivaP2;
			codigoP2 = request.getParameter("codigoP2");

			productosDTO produc = prod.Buscar_Producto(codigoP2);

			if (produc != null) {
				codigoP2 = produc.getCodigo_producto();
				nombreP2 = produc.getNombre_producto();
				precioP2 = produc.getPrecio_venta();
				ivaP2=produc.getIvacompra();
				response.sendRedirect("ventas.jsp?codP2=" + codigoP2 + "&&nombreP2=" + nombreP2 + "&&precioP2=" + precioP2 + "&&ivaP2=" + ivaP2);
			} else {
				response.sendRedirect("ventas.jsp?men=El PRODUCTO 2 no existe");
			}
		}
		
		//CONSULTA DE PRODUCTO 3
		if (request.getParameter("ConsultarP3") != null) {
			productosDAO prod = new productosDAO();

			String codigoP3, nombreP3;
			Double precioP3, ivaP3;
			codigoP3 = request.getParameter("codigoP3");

			productosDTO produc = prod.Buscar_Producto(codigoP3);

			if (produc != null) {
				codigoP3 = produc.getCodigo_producto();
				nombreP3 = produc.getNombre_producto();
				precioP3 = produc.getPrecio_venta();
				ivaP3=produc.getIvacompra();
				response.sendRedirect("ventas.jsp?codP3=" + codigoP3 + "&&nombreP3=" + nombreP3 + "&&precioP3=" + precioP3 + "&&ivaP3=" + ivaP3);
			} else {
				response.sendRedirect("ventas.jsp?men=El PRODUCTO 3 no existe");
			}
		}

	

		if (request.getParameter("Confirmar") != null) {

			int  cant1,cant2,cant3;
			double tot,tot1,tot2; //precios de productos
			double res,res1,res2; //cantxprecio seria valor_venta (detalle_venta)
			double totalIva1, totalIva2, totalIva3; //total1,total2,total3  valores iva de cada producto
			double valorVP1,valorVP2,valorVP3; //valor venta para c/prod
			double totalsiniva,totaliva,totalconiva; //valores para tabla ventas
			
			
			cant1=Integer.parseInt(request.getParameter("cantP"));
			cant2=Integer.parseInt(request.getParameter("cantP2"));
			cant3=Integer.parseInt(request.getParameter("cantP3"));
			
			res=Double.parseDouble(request.getParameter("valorT1"));
			res1=Double.parseDouble(request.getParameter("valorT2"));
			res2=Double.parseDouble(request.getParameter("valorT3"));
			
			tot=Double.parseDouble(request.getParameter("precio1"));
			tot1=Double.parseDouble(request.getParameter("precio2"));
			tot2=Double.parseDouble(request.getParameter("precio3"));
			
			totalIva1=Double.parseDouble(request.getParameter("totalIva1"));
			totalIva2=Double.parseDouble(request.getParameter("totalIva2"));
			totalIva3=Double.parseDouble(request.getParameter("totalIva3"));
			
			valorVP1=Double.parseDouble(request.getParameter("ValorVP1"));
			valorVP2=Double.parseDouble(request.getParameter("ValorVP2"));
			valorVP3=Double.parseDouble(request.getParameter("ValorVP3"));
		
			totalsiniva=Double.parseDouble(request.getParameter("totalV"));
			totaliva=Double.parseDouble(request.getParameter("totalIva"));
			totalconiva=Double.parseDouble(request.getParameter("totalConIva"));
			
			int i=JOptionPane.showConfirmDialog(null,"DESEA CONFIRMAR LA VENTA");
			 if(i==0) {
			
				 String cliente,usuario;
				 double ivaventa,valorventa,totalventa;
				 
			
			cliente = request.getParameter("ceduC");
			usuario = request.getParameter("ceduUS");
			ivaventa=totaliva;
			valorventa=totalsiniva;
			totalventa=totalconiva;
			
			
				ventasDTO v = new ventasDTO(cliente, usuario,ivaventa,valorventa,totalventa);
				ventasDAO vDao = new ventasDAO();
				if (vDao.Insertar_Venta(v)) {

					response.sendRedirect("ventas.jsp?men=Se Registró la venta Exitosamente");
				} else {
					response.sendRedirect("ventas.jsp?men=NO Se Registró la venta");
				}

			} else {
				response.sendRedirect("ventas.jsp");

			}

		}
	}
		


//	private void buscarProducto(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		HttpSession sesion = request.getSession();
//		productosDTO prodDTO = new productosDTO();
//		String codigoProducto = request.getParameter("codigoP");
//		prodDTO = new productosDAO().Buscar_Producto2(new productosDTO(codigoProducto));
//		sesion.setAttribute("producto", prodDTO);
//		response.sendRedirect("ventas.jsp");
//
//	}

}
