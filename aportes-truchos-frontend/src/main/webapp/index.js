var mixin = {
	methods: {
		foo: function () {
			console.log('foo')
		},
		conflicting: function () {
			console.log('from mixin')
		}
	}
}


let app = new Vue({
	el: '#app',
	mixin: [mixin],
	data: {
		route: 'http://api:8080/api/',
		entries: [],
		message: '',
		activeClass: ''
	},
	methods: {
		hayResultados: function (event) {
			return false;
		},
		getAportes: function (event) {
			let vm = this;
			if (vm.checkRecaptcha()) {
				this.$http.get(this.route).then((response) => {
					if (response.status == 200) {
						if (response.data.length == 0) {
							vm.viewMessage("Usted no se encuentra en la lista de aportantes", vm.getSuccess());
						} else {
							vm.viewMessage("Se han encontrado aportes realizados por usted.", vm.getError());
						}
						for (var i = 0; i < response.data.length; i++) {
							this.entries.push({
								nombre: response.data[i].nombre,
								apellido: response.data[i].apellido,
								dni: response.data[i].dni,
								tipo: response.data[i].tipo,
								importe: response.data[i].importe
							});
						}
					}
					if (response.status == 404) {
						vm.viewMessage("Ops!, ocurrió un problema", vm.getError());
					}

				}, error => { vm.viewMessage("Ops!, ocurrió un problema", vm.getError()) })
			} else {
				vm.viewMessage("Por favor compruebe el captcha primero.", vm.getError());
			}
		},
		viewMessage: function (message2, severity) {
			this.activeClass = severity;
			this.message = message2;
		},
		getError: function () {
			return 'alert alert-danger';
		},
		getSuccess: function () {
			return 'alert alert-success';
		},
		dismissMessage: function (event) {
			this.message = '';
		},
		checkRecaptcha: function (event) {
			return (grecaptcha && grecaptcha.getResponse().length > 0);
		}
	}
})
