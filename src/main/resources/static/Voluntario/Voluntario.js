const apiUrlPublicaciones ="http://localhost:5000/api/perdidas/publicaciones";

new Vue({
	el: '#app',
	data: {
		publicaciones: [{
			id: null,
			mascota: {},
			rescatista: {},
			aceptada: null
		}]
	},
	created() {
		fetch(apiUrlPublicaciones)
			.then(response => response.json())
			.then(publicaciones => { this.publicaciones = publicaciones;})
	},
	methods: {}
})