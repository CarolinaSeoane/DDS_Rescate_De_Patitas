const apiQR = "http://localhost:5000/api/mascota/obtener-QR";
const apiUrlUsuario = "http://localhost:5000/usuarios/datos-estandar";

new Vue({
        el: '#app',
        data() {
            return{
                foto: {},
                usuario: {}
            }
        },
        created() {
            fetch(apiQR)
                .then(response => response.json())
                .then(qrObtenido => {
                    this.foto = qrObtenido;
                    console.log(this.QR);
            })

            var idSesion = localStorage.getItem("IDSESION");

            fetch(apiUrlUsuario, {
                headers: {
                    "Authorization": idSesion //se envia el IDSESION para identificar al usuario en backend
                }})
            .then(response =>{ return response.json()})
            .then(estandar => {
                this.usuario = estandar;
            })

        }
    })