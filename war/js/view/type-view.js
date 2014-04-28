define([
  'jquery',
  'underscore',
  'backbone',
  'app_registry',
  'collection/typeset',
  'view/list_type_view',
  'view/list-objects-view'
], function($, _, Backbone,app_registry,
		TypeSet,ListView,ListObjectsView){

		var TypeView = Backbone.View.extend({
			initialize:function () {
				 if(this.listTypeView) this.listTypeView.close();
				   var listType  = new TypeSet();
				   app_registry.models.listType = listType;
				   listType.fetch({
					   success:function(){
						   console.log(listType);
						   this.listTypeView  = new ListView({model:listType});
						   var listObjectsView  = new  ListObjectsView();
						   listObjectsView.render().$el.html(this.listTypeView.render().el);
					   }
				   });
				   //Events.on("showAddType","showAddTypeView");
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
		return TypeView;
		
});