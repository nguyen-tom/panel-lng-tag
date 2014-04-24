var Type =  Backbone.Model.extend({
	
	defaults:{
		"id":null,
		"name":"",
	    "description":"",
	    "maxItem":"",
	    "minItem":""
	},
//	validate: function(attributes){
//	      if ( attributes.maxItem < 0 ){
//	          return 'maxItem must be positive.';
//	      }
//	      if ( attributes.minItem < 0 ){
//	          return 'minItem must be positive.';
//	      }
//	      if ( attributes.maxItem <  attributes.minItem){
//	          return 'ERROR MAX Item must bigger than MIN Item.';
//	      }
//	      if ( !attributes.name ){
//	          return 'Every person must have a name.';
//	      }
//	  },
	methodUrl: {
		'read'  : '/type/getType',
		'update': 'type/addType',
	    'create': '/type/addType',
	    'delete': '/type/delete'
	  },

	  sync: function(method, model, options) {
		    options = options || {};
		    options.url = model.methodUrl[method.toLowerCase()];
		    //options.data = JSON.stringify(this.get('id'));
		    return Backbone.sync.apply(this, arguments);
		  },
	  save: function (attributes, options) {
		  options       = options || {};
		  attributes    = attributes || {};
		 
		  this.set(attributes);
		 
		  options.data  = this.toJSON();
		 
		  return Backbone.Model.prototype.save.call(this, attributes, options);
		},

});