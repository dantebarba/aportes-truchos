
let anUrl = settingsUrl();

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
	components: {
		    'vue-recaptcha': VueRecaptcha
	},
	data: {
		url: anUrl,
		entries: [],
		message: '',
		activeClass: '',
		dni: ''
	},
	methods: {
	    onCaptchaExpired: function () {
	        this.$refs.recaptcha.reset();
	    },
	    getAportes: function (recaptchaToken) {
	    	return this.$refs.recaptcha.execute();
	    },
		hayResultados: function (event) {
			return this.entries.length > 0;
		},
		onCaptchaVerified: function (recaptchaToken) {
			let vm = this;
			let cons = console;
			vm.$refs.recaptcha.reset();
				this.$http.get(this.url + '/aportes/' + this.dni).then((response) => {
					if (response.status == 200) {
						if (response.data.length == 0) {
							this.entries = [];
							vm.viewMessage("Usted no se encuentra en la lista de aportantes", vm.getSuccess());
						} else {
							vm.viewMessage("Se han encontrado aportes realizados por usted.", vm.getError());
						}
						cons.log(response)
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
						this.entries = [];
						vm.viewMessage("Ops!, ocurrió un problema", vm.getError());
					}

				}, error => { vm.viewMessage("Ops!, ocurrió un problema", vm.getError()); this.entries = []; })
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
			return true;
		}
	}
})
