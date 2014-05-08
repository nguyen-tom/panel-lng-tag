define([
  'jquery',
  'underscore',
  'backbone',
  'text!/tpl/modal_add_language.html'
  ], function($, _, Backbone,ModalAddLanguage){
	
	var ModalAddLanguageView = Backbone.View.extend({
		 tagName:"div",
		initialize:function () {
	        this.template = _.template(ModalAddLanguage);
	        this.model.bind("change", this.render, this);
	        console.log( this.et);
	    },

	    render:function (eventName) {
	        $(this.el).html(this.template(this.model.toJSON()));
	        return this;
	    },
	    events:{
	        "change input":"change",
	        "click #btn-add": "addLanguage",
	        "click #btn-cancel": "cancel"
	    },
	    showModal:function(){
	    	console.log("SHOW MODAL>>>");
	    	console.log("My modal :" + $('#myModal'));
	    	  // initialized with no keyboard
	    	
	    	$('#myModal').modal({show:true}) ;
	    },
	    cancel:function(event){
	    	$('#myModal').modal('hide');
	    },
	    change:function (event) {
	        var target = event.target;
	        console.log('changing ' + target.id + ' from: ' + target.defaultValue + ' to: ' + target.value);
	    },
	    addLanguage:function(event){
	    	console.log("Click Add New Language ...");
	    	var input_name  = $("#name").val();
	    	var input_des   = $("#description").val();
	    	console.log("[" + input_name + "," + input_des + "]")
	    	this.model.set({"name" : input_name,"description":input_des});
	    	this.model.save({ 
	    			   success:function () {
	    				  console.log("close modal");
	                       modalEl.modal('hide');
	    			 }
	                });
	    }
	   
	});
	
	return ModalAddLanguageView;
});

