var APPID = "55d9fe4f59ef082b39a97c7a6c7dbf00";

function initAJAX() {
	var xmlHttpRequest;
	
	if (window.XMLHttpRequest) {
		xmlHttpRequest = new XMLHttpRequest();
	} else {
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttpRequest;
}

function searchWeather() {
	console.log("searchWeather() initialized.");
	
	var zipCode = document.getElementById("zip").value;
	pattern = /[0-9]{5}([- ]?[0-9]{4})?/;
	
	if (pattern.test(zipCode)) {
		$.getJSON('https://api.openweathermap.org/data/2.5/weather?zip=' + zipCode + ',us&appid=' + APPID, function(data) {
			var html = '<h2>' + `${data.name}` + '</h2>';
			html += '<img src="images/tmp-low.png" width="20" height="30" />' + `${data.main.temp_min}` + '	';
			html += '<img src="images/tmp-high.png" width="20" height="30" />' + `${data.main.temp_max}`;
			$("#contentBlock").html(html);
		});
	} else {
		throw new ZipCodeFormatException(zipCode);
	}
}

function searchCities() {
	console.log("searchCities() initialized.");
	
	if (navigator.geolocation) {
		var location = navigator.geolocation.getCurrentPosition(showPosition);
		
	} else {
		throw "Geolocation is not supported by this browser.";
	}
}

function showPosition(position) {
	$.getJSON('https://api.openweathermap.org/data/2.5/find?lat=' + position.coords.latitude + '&lon=' + position.coords.longitude + '&cnt=10&appid=' + APPID, function(data) {
		var html = '<h2>City</h2><table style="width:50%">';
		
		$.each(data.list, function(index, value) {
			html += '<tr>' + '<td>' + value.name + '</td>' + '</tr>';
		})
		
		html += '</table>';

		$("#contentBlock").html(html);
	});
}
