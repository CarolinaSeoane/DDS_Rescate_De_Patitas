
function initMap(lat, long) {
    const uluru = { lat: lat, lng: long };

    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 16,
        center: uluru,
    });

    const marker = new google.maps.Marker({
        position: uluru,
        map: map,
    });
}


const urlParams = new URLSearchParams(window.location.search);

const apiUrl ="http://localhost:5000/api/perdidas/publicaciones/"+ urlParams.get('publicacion');

new Vue({
    el: '#publicacion',
    data () {
        return{
            solicitudIniciada: false,
            estado_Solicitud: "",
            colorText:"red",
            fotoPrincipal:{},
            fotos:[],
            publicacion: {
                mascota: {
                    estado: ""
                }
            }
        }
    },
    created(){
        fetch(apiUrl)
            .then(response =>{return response.json()})
            .then(publicacion =>{
                this.publicacion = publicacion;
                this.fotos = publicacion.mascota.fotos;
                this.fotoPrincipal = this.fotos[0];
            }).then(nada =>{
            initMap( this.publicacion.mascota.ubicacion.lat,this.publicacion.mascota.ubicacion.long );
        });

    },
    methods:{
        setFirst: function (foto){
            this.fotoPrincipal = foto;
        },
        contactar: function (){
            this.solicitudIniciada = true;
            var idSesion = localStorage.getItem("IDSESION");
            this.colorText = "#4ba0dd";
            this.estado_Solicitud = "Procesando solicitud"
            fetch("http://localhost:5000/api/perdidas/publicaciones/"+ + this.publicacion.id +"/contactar", {
                method: "GET",
                headers: {
                    "Authorization": idSesion
                }
            })
                .then(response => response.json())
                .then(estado =>{
                    if (estado){
                        this.colorText = "green";
                        this.estado_Solicitud = "Se notifico al dueño de la mascota";
                    }else{
                        this.colorText = "red";
                        this.estado_Solicitud = "Hubo un error";
                    }

                });
        }
    }
});