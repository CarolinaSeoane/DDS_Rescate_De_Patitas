const apiUrl = "http://localhost:5000/usuarios/registrar-admin";

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
			usuario: '',
			password: '',
			checkPassword: '',
			passwordVisible: false,
			submitted: false
		}
	},
	computed: {
		notSamePasswords () {
			if (this.passwordsFilled) {
				return (this.password !== this.checkPassword)
			} else {
				return false
			}
		},
		passwordsFilled () {
			return (this.password !== '' && this.checkPassword !== '')
		},
		passwordValidation () {
			let errors = []
			for (let condition of this.rules) {
				if (!condition.regex.test(this.password)) {
					errors.push(condition.message)
				}
			}
			if (errors.length === 0) {
				return { valid:true, errors }
			} else {
				return { valid:false, errors }
			}
		}
	}
})
