// Create a Leaflet map and set its initial view
var map = L.map('map').setView([41.996323507715786, 21.431642725601918], 13);
mapLink = "<a href='http://openstreetmap.org'>OpenStreetMap</a>";
var marker;
var markers =[];

// Add a tile layer to the map using OpenStreetMap tiles
L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: 'Leaflet &copy; ' + mapLink + ', contribution',
    maxZoom: 18
}).addTo(map);


function createMarker(info){
    // Clear existing markers
    clearMarkers();

    var lat = parseFloat(info.split(", ")[0]);
    var lon = parseFloat(info.split(", ")[1]);
    var name = info.split(", ")[2];
    console.log(name)
    if (lat && lon) {
        // Update the map view to the new coordinates
        map.setView([lat, lon], 14);

        // Create a Leaflet marker at the gallery's coordinates and add it to the map
        marker = L.marker([parseFloat(lat), parseFloat(lon)]).addTo(map);
        // Bind a popup to the marker with the gallery name (or 'Unknown Gallery' if name is not available)
        marker.bindPopup(name || 'Unknown Gallery');
        markers.push(marker); // Add the marker to the markers array
    }

    $('.collapse').on('show.bs.collapse', function () {
        $('.collapse.show').not(this).collapse('hide');
    });
}

// Function to clear existing markers
function clearMarkers() {
    for (var i = 0; i < markers.length; i++) {
        map.removeLayer(markers[i]); // Remove the marker from the map
    }
    markers = []; // Clear the markers array
}