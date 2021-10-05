package Controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.clientesDAO;
import Modelo.clientesDTO;
import Modelo.productosDAO;
import Modelo.productosDTO;
import Modelo.usuariosDAO;
import Modelo.usuariosDTO;




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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		if(request.getParameter("consultarC")!=null) {
					clientesDAO clie= new clientesDAO();
					
					
					String cedula_C,nombre;
					cedula_C=request.getParameter("cedula_C");
					
					clientesDTO cli=clie.Buscar_Cliente(cedula_C);
					
					if(cli!=null) {
					cedula_C=cli.getCedula();
					nombre=cli.getNombre();
					response.sendRedirect("ventas.jsp?ced="+cedula_C+"&&nombre="+nombre);
					}else
					{
						response.sendRedirect("ventas.jsp?men=El Cliente no existe");
					}
			}
		
		
		
		if(request.getParameter("consultarE")!=null) {
			usuariosDAO usu= new usuariosDAO();
			
			
			String cedula_E,nombreU;
			cedula_E=request.getParameter("cedula_E");
			
			usuariosDTO us=usu.Buscar_Usuario(cedula_E);
			
			if(us!=null) {
			cedula_E=us.getCedula();
			nombreU=us.getNombre();
			response.sendRedirect("ventas.jsp?cedU="+cedula_E+"&&nombreU="+nombreU);
			}else
			{
				response.sendRedirect("ventas.jsp?men=El empleado no existe");
			}
	}
		
		
		if(request.getParameter("consultarP1")!=null) {
			productosDAO prod= new productosDAO();
			
			
			String codigoP,nombreP;
			codigoP=request.getParameter("codigoP");
			
			productosDTO produc=prod.Buscar_Producto(codigoP)	;
			
			if(produc!=null) {
			codigoP=produc.getCodigo_producto();
			nombreP=produc.getNombre_producto();
			response.sendRedirect("ventas.jsp?codP="+codigoP+"&&nombreP="+nombreP);
			}else
			{
				response.sendRedirect("ventas.jsp?men=El PRODUCTO no existe");
			}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
}
