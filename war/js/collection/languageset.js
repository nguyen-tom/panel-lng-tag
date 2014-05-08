var LanguageCollection =  Backbone.Collection.extend({
	model: Language,
	url: 'lang/language',
	parse: function (response) {
		
		console.log("Start Parse..." + response);
		var datas = response.datas;
		//Parse the response and construct models			
		for (var i = 0, length = datas.length; i < length; i++) {
			var currentValues = datas[i];
			var language = new Language();
			language.set({name:currentValues.name});
			language.set({id:currentValues.key});
			language.set({description:currentValues.description});
			//push the model object
			this.models.push(company);	
		}
		return this.models;

	},
	
	initialize: function () {
		   
	}
	
});