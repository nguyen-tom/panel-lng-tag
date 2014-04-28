define([
  'jquery',
  'underscore',
  'backbone',
  'model/type'
], function($, _, Backbone,Type){

		var TypeSet =  Backbone.Collection.extend({
			model: Type,
			url: 'type/types',
			parse: function (response) {
				
				console.log("Start Parse..." + response);		
				//Parse the response and construct models			
				for (var i = 0, length = response.length; i < length; i++) {
					var currentValues = response[i];
					var type = new Type();
					type.set({description:currentValues.description});
					type.set({id:currentValues.key});
					type.set({name:currentValues.name});
					type.set({maxItem:currentValues.maxItem});
					type.set({minItem:currentValues.minItem});
					//push the model object
					this.models.push(type);	
				}
				return this.models;
		
			},
			
			initialize: function () {
				   
			}
			
		});
		return TypeSet;
		
});