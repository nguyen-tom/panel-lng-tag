define([
  'jquery',
  'underscore',
  'backbone',
  'text!/tpl/dialog_progress.html'
  ], function($, _, Backbone,ModalAddLanguage){
	var NoteProgressBar = Backbone.View.extend({
		 tagName:"div",
		initialize:function () {
	        this.template = _.template(ModalAddLanguage);
	    },

	    render:function (eventName) {
	        $(this.el).html(this.template());
	        return this;
	    },
	    
	    showModal:function(){
	    	console.log("SHOW MODAL>>>");
	    	console.log("My modal :" + $('#myModal'));
	    	  // initialized with no keyboard
	    	
	    	$('#myModal').modal('show') ;
	    },
	    cancel:function(event){
	    	$('#myModal').modal('hide');
	    }
	    
	});
	
	return NoteProgressBar;
	
});
	