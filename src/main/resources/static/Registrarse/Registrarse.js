const apiEstandar = "http://localhost:5000/usuarios/registrar-estandar";

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
			submitted: false
		}
	},
	computed: {
		passwordsFilled () {
			return (this.form.password !== '');
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
	            if(this.passwordsFilled && this.passwordValidation.valid) {
                axios.post(apiEstandar, this.form)
                .then((result) => {
                    console.log(result);
                    alert("Ir a pantala principal o a completar datos personales?");
                    /* no se como hacer que lleve a la pagina principal*/
                    })
            }
	    }
	}

})