var CompanyCollection =  Backbone.Collection.extend({
	model: Company,
	url: 'company/company',
	parse: function (response) {
		
		console.log("Start Parse..." + response);
		var datas = response.datas;
		//Parse the response and construct models			
		for (var i = 0, length = datas.length; i < length; i++) {
			var currentValues = datas[i];
			var company = new Company();
			company.set({name:currentValues.name});
			company.set({id:currentValues.key});
			company.set({address:currentValues.address});
			company.set({taxcode:currentValues.taxcode});
			//push the model object
			this.models.push(company);	
		}
		return this.models;

	},
	
	initialize: function () {
		   
	}
	
});