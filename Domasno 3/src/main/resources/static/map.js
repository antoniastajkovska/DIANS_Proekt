//create a map
//setView returns the map object
var map = L.map('map').setView([41.996323507715786, 21.431642725601918], 13);

//add a tile layer to the map
L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);






