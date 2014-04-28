
define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){
	var ListObjectsView  = Backbone.View.extend({
		el: $('#list-objects')
	});
	
	return ListObjectsView;
});