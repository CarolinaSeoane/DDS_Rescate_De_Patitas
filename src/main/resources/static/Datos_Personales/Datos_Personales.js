class Menu extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `

    `;
    }
}

customElements.define('main-datos-personales', DatosPersonales);