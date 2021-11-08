const apiAdmin = "http://localhost:5000/usuarios/registrar-admin";
const apiVoluntario = "http://localhost:5000/usuarios/registrar-voluntario";

new Vue({
	el:"#app",
	data () {
		return {
			rules: [
				{ message: "Requiere un caracter especial", regex:/[@#$/%!_*?¿-]+/ },
				{ message: "Requiere una mayúscula",  regex:/[A-Z]+/ },
				{ message: "Mínimo de 8 caracteres", regex:/.{8,}/ },
				{ message: "Requiere un número", regex:/[0-9]+/ }
			],
			form: {
			    usuario: '',
            	password: '',
			},
			checkPassword: '',
			submitted: false,
			rol: ''
		}
	},
	computed: {
		notSamePasswords () {
			return (this.form.password !== this.checkPassword)
		},

		passwordsFilled () {
			return (this.form.password !== '' && this.checkPassword !== '')
		},

		passwordValidation () {
			let errors = []
			for (let condition of this.rules) {
				if (!condition.regex.test(this.form.password)) {
					errors.push(condition.message)
				}
			}
			if (errors.length === 0) {
				return { valid:true, errors }
			} else {
				return { valid:false, errors }
			}
		}

	},

	methods: {
	    enviar: function() {
	        var api;
	        if(this.rol == "ADMINISTRADOR") {
	            api = apiAdmin;
	        } else {
	            api = apiVoluntario;
	        }

            if(!this.notSamePasswords && this.passwordsFilled && this.passwordValidation.valid) {
                axios.post(api, this.form)
                .then((result) => {
                                    console.log(result);
                                    alert("El usuario se ha creado correctamente. Pulse Aceptar para volver a la pantalla principal");
                                    /* no se como hacer que lleve a la pagina principal*/
                                    })
            }
	    }
	}

})
