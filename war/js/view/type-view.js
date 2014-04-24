var TypeView = Backbone.View.extend({
	initialize:function () {
		 if(this.listTypeView) this.listTypeView.close();
		   listType  = new TypeSet();
		   listType.fetch({
			   success:function(){
				   console.log(listType);
				   this.listTypeView  = new ListView({model:listType});
				   listObjectsView.render().$el.html(this.listTypeView.render().el);
			   }
		   });
		   Events.on("showAddType","showAddTypeView");
	},
	render:function(){
		$(this.el).html(this.template());
		return this;
	},
	onClose:function(){
		console.log("TypeView Closing...");
		this.listTypeView.close();
	},
	showAddTypeView:function(){
		console.log("Trigger showAddTypeView...");
	}
	
	 
	
});