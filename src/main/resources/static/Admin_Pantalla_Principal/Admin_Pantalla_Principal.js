const apiUrl = "http://localhost:5000/usuarios/datos-administrador";

new Vue({
        el: '#app',
        data() {
            return {
                administrador: {}
            }
        },

        created() {
            var idSesion = localStorage.getItem("IDSESION"); //recupera ID
            fetch(apiUrl, {
                headers: {
                    "Authorization": idSesion //se envia el IDSESION para identificar al usuario en backend
                }
            })
            .then(response =>{return response.json()})
            .then(adminObtenido => {
                this.administrador = adminObtenido;
            })
        }
})