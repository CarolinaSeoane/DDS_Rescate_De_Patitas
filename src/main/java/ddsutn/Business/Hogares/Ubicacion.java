package ddsutn.Business.Hogares;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "ubicacion")

public class Ubicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "latitud")
	private double lat;

	@Column(name = "longitud")
	@JsonProperty("long")
	private double _long;


	public Ubicacion(String direccion, double lat, double _long) {
		this.direccion = direccion;
		this.lat = lat;
		this._long = _long;
	}

	public Double calcularDistancia(Ubicacion ubicacion){
		double x = _long - ubicacion.get_long();
		double y = lat - ubicacion.getLat();
		return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
	}

}
