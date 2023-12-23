// Create a Leaflet map and set its initial view
var map = L.map('map').setView([41.996323507715786, 21.431642725601918], 13);
mapLink = "<a href='http://openstreetmap.org'>OpenStreetMap</a>";

// Add a tile layer to the map using OpenStreetMap tiles
L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: 'Leaflet &copy; ' + mapLink + ', contribution',
    maxZoom: 18
}).addTo(map);

// Load external data
fetch('data/result.json')
    .then(response => response.json())
    .then(data => {
        createMarkers(data); // Call createMarkers after data is loaded
    })
    .catch(error => console.error('Грешка при вчитување на JSON: ', error));


function createMarkers(galleries) {
    // Create a Leaflet map and set its initial view
    // var map = L.map('map').setView([41.996323507715786, 21.431642725601918], 13);
    mapLink = "<a href='http://openstreetmap.org'>OpenStreetMap</a>";
    // Add a tile layer to the map using OpenStreetMap tiles
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: 'Leaflet &copy; ' + mapLink + ', contribution',
        maxZoom: 18
    }).addTo(map);

    var markers = []; // Array to store Leaflet markers

    // Iterate through each gallery in the data
    galleries.forEach(function (gallery) {
        // Check if the gallery has latitude (lat) and longitude (lon) coordinates
        if (gallery.lat && gallery.lon) {
            // Create a Leaflet marker at the gallery's coordinates and add it to the map
            var marker = L.marker([parseFloat(gallery.lat), parseFloat(gallery.lon)]).addTo(map);
            // Bind a popup to the marker with the gallery name (or 'Unknown Gallery' if name is not available)
            marker.bindPopup(gallery.name || 'Unknown Gallery');
            markers.push(marker); // Add the marker to the markers array
        }
    });

    // Create a Leaflet feature group from the markers array
    var group = new L.featureGroup(markers);

    // Adjust the map view to fit the bounds of the markers
    map.fitBounds(group.getBounds());
}



