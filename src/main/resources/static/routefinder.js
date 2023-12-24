// Create a Leaflet map and set its initial view
var map = L.map('map').setView([41.996323507715786, 21.431642725601918], 13);
mapLink = "<a href='http://openstreetmap.org'>OpenStreetMap</a>";

// Add a tile layer to the map using OpenStreetMap tiles
L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: 'Leaflet &copy; ' + mapLink + ', contribution',
    maxZoom: 18
}).addTo(map);

// Load external data from 'data/result.json'
fetch('data/result.json')
    .then(response => response.json())
    .then(data => {
        createMarkers(data); // Call createMarkers after data is loaded
    })
    .catch(error => console.error('Грешка при вчитување на JSON: ', error));

// Event listener for a click on the map
map.on('click', function (e) {
    // Get coordinates from the 'destination' select element
    var coordinates = document.getElementById('destination').value;
    // Parse latitude and longitude from the coordinates
    var lat = parseFloat(coordinates.split(" ")[0]);
    var lon = parseFloat(coordinates.split(" ")[1]);

    console.log(e);

    // Create a Leaflet Routing control with waypoints and add it to the map
    L.Routing.control({
        waypoints: [
            L.latLng(e.latlng.lat, e.latlng.lng),
            L.latLng(lat, lon),
        ]
    }).on('routesfound').addTo(map);
});
