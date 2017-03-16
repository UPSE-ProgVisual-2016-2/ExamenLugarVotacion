package application;


import java.io.IOException;
import java.time.LocalDate;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerVotante {

	@FXML Button btnBuscar;
	@FXML TextField txtCedula;
	@FXML TextField txtNombre;
	@FXML Label lblMensaje;
	@FXML ImageView imgVotante;
	Votante v;

	public void initialize()
	{
		validar();
		imgVotante.addEventFilter(MouseEvent.MOUSE_CLICKED,
				e -> {
					if(v==null || imgVotante==null)
					{
						e.consume();
					}
				});
		
		imgVotante.setOnMouseClicked(agrandarFoto());
		agrandarFoto();
		
		RecintoElectoral miRecinto = new RecintoElectoral(25, "Jujan", 25, application.Provincia.GUAYAS, "Jujan", "Parquesito");
		Votante ivan = new Votante("1309518445", "Ivan Sanchez", LocalDate.now(), "./resources/img/fotoIvan.jpg", false, miRecinto);
		CNE.padron.add(ivan);
		CNE.recintosDisponibles.add(miRecinto);
		
	}
	
	public Scene irARecinto() throws IOException
	{
		if(v.getRecinto()!=null)
		{
			Scene s;
			Stage escenarioActual = (Stage)btnBuscar.getScene().getWindow();
		    
			Parent p = FXMLLoader.load(getClass().getResource("/GUI_Recinto.fxml"));
			s = new Scene(p);
			escenarioActual.setScene(s);
			return s;
		}else{
			lblMensaje.setText("No hay recinto cargado");
		}
		return null;
	}
	
	public EventHandler<MouseEvent> agrandarFoto()
	{
		EventHandler<MouseEvent> evento = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				imgVotante.setLayoutX(imgVotante.getLayoutX()*2);
				imgVotante.setLayoutY(imgVotante.getLayoutY()*2);
			}
			
			};
		return evento;
	}
	
	public void validar()
	{
		validarExpresionRegular(txtCedula, "\\d{10}");
		validarExpresionRegular(txtNombre, "\\[A-Za-z]+");
	}
	
	public void votanteEnMesaResaltar()
	{
		if(v.isAsignadoAMesa())
		{
			txtNombre.setStyle("-fx-text-color: red;");
		}
	}
	
	public void eliminarVotante()
	{
		if(v!=null)
		{
			CNE.padron.remove(v);
			limpiarPantalla();
		}else
		{
			alertaVotanteNulo();
		}
	}
	
	public void buscar()
	{
		Votante votanteBuscado = buscarPorCedula(txtCedula.getText());
		
		if(votanteBuscado==null)
		{
			lblMensaje.setText("Votante no Encontrado");
			limpiarPantalla();
			bloquearCampos();
		}else{
			cargarVotante(votanteBuscado);
			v = votanteBuscado;
		}
	}
	
	public void bloquearCampos()
	{
		txtNombre.setEditable(false);
		txtNombre.setDisable(true);
		//bloquear todos los otros campos
	}
	
	public Votante buscarPorCedula(String cedula)
	{
		for(Votante v: CNE.padron)
		{
			if(v.getCedula().equals(cedula))
			{
				cargarVotante(v);
				return v;
			}
					
		}
		return null;
	}
	
	public void imprimirDomicilio()
	{
		if(v!=null)
		{
			lblMensaje.setText(v.imprimirDomicilioElectoral());
		}else{
			alertaVotanteNulo();
		}
	}
	
	public void alertaVotanteNulo()
	{
		lblMensaje.setText("Cuidado el votante es nulo!!!");
	}
	
	public void limpiarPantalla()
	{
		txtNombre.setText("");
		txtCedula.setText("");
	}
	
	public void cargarVotante(Votante v)
	{
		txtNombre.setText(v.getNombre());
	}
	
	public static void validarExpresionRegular(TextField txtField, String regex)
	{
		if(txtField.getText().matches(regex))
		{
			txtField.setText("");
		}
	}
}
