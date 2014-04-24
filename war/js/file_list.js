// OnReady Event
jQuery(document).ready(function() {

	// Bind the submit event to File Upload form.
	jQuery('#upload_button').click(function(){
		return fileUpload();
	});
	
});


var fileUpload = function() {
	var params = {
			method : 'upload_img',
	};
		var uploader = new FDSFileUploader(params);
		uploader.upload();
	return false;
};


function FDSFileUploader(arg) {
	var processingFlag = false;
	
	var params         = arg;

	this.upload = function(){
		if (processingFlag) {
			return false;
		}

		setUp();
		main();
		tearDown();
	};

	var setUp = function() {
		this.processingFlag = true;
	};

	var handleSuccess = function(res) {
		var msg = 'upload completed';
		alert(msg);
	};
	var handleError = function(res){
		var errors  = res.errors;
		var errorArray  = errors.error;
		var error_item  = errorArray[0];
		alert(error_item.message);
	};
	var handleComplete = function(){
		jQuery('#file_upload')[0].reset();
		
	}

	var main = function() {
		$('#csv_file').upload(
				'/file',
				params,
				function(res) {
					switch (res.result) {
					case 0:
						handleError(res);
						break;
					case 1:
						handleSuccess(res);
						break;
					}
					handleComplete();
				},
				'json'
		);
	};

	var tearDown = function() {
		this.processingFlag = false;
	};
}


 


