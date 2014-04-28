
define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){
	

var DetailObjetsView  = Backbone.View.extend({
	el: $('#detail-object'),
	render:function (eventName) {
        return this;
	}
   });

return DetailObjetsView;
});