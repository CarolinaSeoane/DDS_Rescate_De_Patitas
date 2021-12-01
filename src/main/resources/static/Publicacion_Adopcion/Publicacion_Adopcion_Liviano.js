adoptar = function (id){
    var idsesion = document.getElementById("idSesion").value;
    this.solicitudIniciada = true;
    this.colorText = "#4ba0dd";
    this.estado_Solicitud = "Procesando solicitud";
    window.location.href="http://localhost:5000/cliente-liviano/adoptar/publicacion/"+ id +"/adoptar?sesion="+idsesion;



};
goToRegistrarse= function() {
    window.location.href = 'http://localhost:5000/cliente-liviano/inicio_sesion';
};
gotoIniciarSesion= function() {
    window.location.href = 'http://localhost:63342/TPDDS_Grupo5_K3002/templates/Registrarse.html';
};
