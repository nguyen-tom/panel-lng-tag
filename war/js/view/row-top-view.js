define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){

	var RowTopView = Backbone.View.extend({
		el:$("#row-top"),
	});
	
	return RowTopView;
});