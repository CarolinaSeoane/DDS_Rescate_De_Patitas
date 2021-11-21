const apiUrl = "http://localhost:5000/api/mascota/obtener-QR";

new Vue({
        el: '#app',
        data() {
            return{
                foto: {}
            }
        },
        created() {
            fetch(apiUrl)
                .then(response => response.json())
                .then(qrObtenido => {
                    this.foto = qrObtenido;
                    console.log(this.QR);
                })
        }
    })