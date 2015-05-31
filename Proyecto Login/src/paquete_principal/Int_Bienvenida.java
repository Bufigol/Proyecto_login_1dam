package paquete_principal;

import javax.swing.JTable;

public interface Int_Bienvenida {
	public void setControlador(Controlador controlador);

	public void setModelo(Modelo modelo);

	public String getTxfNombre();

	public String getTxfPais();

	public String getTxfCiudad();

	public String getTxfArquitecto();

	public String getTxfLocalizacion();
}
