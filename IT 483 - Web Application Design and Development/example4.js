var requestURL = "http://api.flickr.com/services/feeds/photos_public.gne?tags=dog&format=json&jsoncallback=?";
$.getJSON(requestURL, function(response) {
	//console.log(response);
	response.items.forEach(function(photo) {
		//console.log(photo.media.m);
		var $img = $("<img>");
		$img.attr("src", photo.media.m);
		$('.photos').append($img);
	});
});