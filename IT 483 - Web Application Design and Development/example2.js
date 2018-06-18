var main = function() {
	"use strict";
	$.getJSON("example2.json", function(card) {
		console.log(card);
	});
};

$(document).ready(main);