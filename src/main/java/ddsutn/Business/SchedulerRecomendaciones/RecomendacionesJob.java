package ddsutn.Business.SchedulerRecomendaciones;

import ddsutn.Servicios.PublicacionMascotaEncontradaSvc;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class RecomendacionesJob implements Job {

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		this.buscarMatchEntrePublicaciones();
	}


	public void buscarMatchEntrePublicaciones() {
		// this.publicacionesInteresados.forEach(publInteresado -> this.buscarMatchParaPublicacion(publInteresado));
	}
/*
	private void buscarMatchParaPublicacion(PublicacionInteresado publInteresado) {
		Preferencias mascotaBuscada = publInteresado.getPreferencias();

		List<PublicacionDarEnAdopcion> recomendaciones = new ArrayList<>();

		this.publicacionesDarEnAdopcion.forEach(publEnAdopcion -> {
			if (this.haceMatchMascota(mascotaBuscada, publEnAdopcion.getMascota())) {
				recomendaciones.add(publEnAdopcion);
			}
		});

		if(!recomendaciones.isEmpty()) {
			publInteresado.notificarRecomendacionesSemanales(recomendaciones);
			for(PublicacionDarEnAdopcion pub : recomendaciones) {
				pub.notificarDuenioSobreInteresado(publInteresado.getContactoInteresado());
			}
		}
	}

	private Boolean haceMatchMascota(Preferencias mascotaBuscada, Mascota mascotaEnAdopcion) {
		return (
				mascotaBuscada.getTipo().equals(mascotaEnAdopcion.getTipo()) &&
						mascotaBuscada.getSexo().equals(mascotaEnAdopcion.getSexo()) &&
						this.tieneXEnComun(mascotaBuscada.getCaracteristicas(), mascotaEnAdopcion.getCaracteristicas(), 3)
		);
	}

	private Boolean tieneXEnComun(Set<String> caracteristicas1, Set<String> caracteristicas2, int cantidadParaMatch) {
		int i = 0;
		for (String caracteristica : caracteristicas1) {
			if(caracteristicas2.contains(caracteristica)) {
				i++;
			}
		}
		return i >= cantidadParaMatch;
	*/
}
