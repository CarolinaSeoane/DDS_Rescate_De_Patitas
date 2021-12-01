document.addEventListener('DOMContentLoaded', () => {


    var lat= parseFloat(document.getElementById("lat").value);
    var long = parseFloat(document.getElementById("long").value);

    initMap(lat,long);
} );

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

setFirst = function (id){
    var str = 'foto_'+id;
    document.getElementById("principal").src= document.getElementById(str).src;

};

contactar = function (){

    var idSesion = localStorage.getItem("IDSESION");
    if(idSesion == null) {
        this.unlocked = true
    } else {
        this.solicitudIniciada = true;
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
};

goToRegistrarse = function() {
    window.location.href = 'http://localhost:63342/TPDDS_Grupo5_K3002/templates/Iniciar_Sesion.html';
};
gotoIniciarSesion = function() {
    window.location.href = 'http://localhost:63342/TPDDS_Grupo5_K3002/templates/Registrarse.html';
};
