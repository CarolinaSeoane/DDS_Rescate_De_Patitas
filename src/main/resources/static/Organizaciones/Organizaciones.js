const apiUrl ="http://localhost:5000/registrar/api/organizaciones";

new Vue({
        el: '#app',
        data() {
            return{
                organizaciones: []
            }
        },
        created() {
            fetch(apiUrl)
                .then(response => response.json())
                .then(organizacionesObtenidas => {
                    this.organizaciones = organizacionesObtenidas
                })
        }
    })