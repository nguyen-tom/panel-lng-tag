define([
  'jquery',
  'underscore',
  'backbone',
  'modal',
  'transition',
  'app_registry',
  'router',
  'view/type-view',
  'util/utils',
  'model/language',
  'view/modal-add-language',
  'text!/tpl/list_menu.html'
  
], function($, _, Backbone,modal,transition,app_registry,
		Router,
		TypeView,
		Utils,
		Language,
		ModalAddLanguageView,
		UpdateTypeTemplate){

		var ListMenuView  = Backbone.View.extend({
			
			initialize: function(options) {
				 this.template = _.template(UpdateTypeTemplate);
			 },
			 render:function (eventName) {
				 $(this.el).html(this.template());
			        return this;
			   },
			   events:{
				   "click #type":'clickType',
				   "click #company": 'clickCompany',
				   "click .btn-add": 'clickAddLanguage'
			   },
			   clickType:function(event){
				  var typeView  = new TypeView();
				  var utils  = Utils();
				  
				  utils.showView(contentRightView,typeView);
				   
			   },
			   clickAddLanguage:function(event){
				    var lang = new Language();
			    	var modalview  = new ModalAddLanguageView({model:lang});
			    	modalview.render();
			    	$('#myModal').html(modalview.el);
			    	$('#myModal').modal();
			   },
			   clickCompany:function(event){
				   console.log("click Company Menu...");
				  if(this.listCompanyView) this.listCompanyView.close();
				  companyCollection  = new CompanyCollection();
				  companyCollection.fetch({
					   success:function(){
						   console.log(companyCollection);
						   this.listCompanyView  = new ListCompanyView({model:companyCollection});
						   app.showView(listObjectsView,this.listCompanyView);
					   }
				   });
			  }
			   
		});
		
	return ListMenuView;
});