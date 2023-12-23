
// Fetch API за вчитување на JSON документот
fetch('data/result.json')
    .then(response => response.json())
    .then(data => {
        createMarkers(data);
    })
    .catch(error => console.error('Грешка при вчитување на JSON: ', error));

function createMarkers(galleries) {
    var map = L.map('map').setView([41.996323507715786, 21.431642725601918], 13);

    //add a tile layer to add to our map, in this case it’s a OpenStreetMap tile layer
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map);
    var markers = [];

    galleries.forEach(function (gallery) {
        if (gallery.lat && gallery.lon) {
            var marker = L.marker([parseFloat(gallery.lat), parseFloat(gallery.lon)]).addTo(map);
            marker.bindPopup(gallery.name || 'Unknown Gallery'); // Додадете Popup со името на галеријата
            markers.push(marker);
        }
    });
    
    var group = new L.featureGroup(markers);
    map.fitBounds(group.getBounds());
}