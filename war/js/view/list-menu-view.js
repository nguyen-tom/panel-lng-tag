var ListMenuView  = Backbone.View.extend({
	
	initialize: function(options) {
		 this.template = _.template(tpl.get('list_menu'));
	 },
	 render:function (eventName) {
		 $(this.el).html(this.template());
	        return this;
	   },
	   events:{
		   "click #type":'clickType',
		   "click #company": 'clickCompany'
	   },
	   clickType:function(event){
		  var typeView  = new TypeView();
		  app.showView(contentRightView,typeView);
		   
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