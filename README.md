# MapArt documentation

This project is a Spring Boot application designed to help users explore and discover art galleries in Skopje, North Macedonia. The application provides functionalities to search, browse, and view information about galleries and find the shortest path to a desired art gallery.

Contributors:

•	Gordon Velickovski (211585)

•	Monika Jovevska (203028)

•	Irina Jovanovska (183099)

•	Antonia Stajkovska (211048)

## Setup: 

To set up the project, follow these steps:

1.Clone the project repository from GitHub: https://github.com/antoniastajkovska/DIANS_Proekt  

2.Open the file as IntelliJ IDEA project

3.Run MapArtApplication.java

4.Open your web browser and visit http://localhost:9090/home to access the home page.

Technologies used: Java Spring Boot, HTML, Thymeleaf, CSS, Bootstrap, JavaScript.

## Data: 

### Obtaining data: 

For obtaining data we used the OpenStreetMap platform. The optained data is in XML format.

### Converting data: 

The OSMToJsonConverterAndFilter Java program is designed to convert and filter OpenStreetMap (OSM) XML data to JSON format. It reads an input OSM XML file, extracts relevant information such as latitude, longitude, and specific tags, and writes the structured data into a JSON file. The output JSON represents an array of objects, each corresponding to a node or way element in the OSM XML, with properties like latitude, longitude, and additional tags. The program employs filtering logic to process the XML data and create a more manageable JSON representation for further analysis or use.

## Key features: 

### Navigation:

Users can navigate through different parts of the website with the navigation bar.

-	HomeController: Handles requests mapped to the "/home" endpoint. When a GET request is made to "/home," the getHomePage method is executed, and it returns the Thymeleaf template named "home.html".
  
-	AboutUsController: Handles requests mapped to the "/about_us" endpoint. When a GET request is made to "/about_us," the getHomePage method is executed, and it returns the Thymeleaf template named " aboutUs.html".
  
-	GalleryController: Manages the interaction with the "/galleries" endpoint, handles both GET and POST requests, and interacts with the associated Thymeleaf template to display gallery-related information.
  
-	RoutesController: Manages the interaction with the "/routes" endpoint, handles GET requests, and interacts with the associated Thymeleaf template to display the route finder page.
  
### Searching: 

When a user enters a search query and submits the form, the data is sent to the server, and the getGalleriesPage method in the GalleryController processes the search query to retrieve matching galleries. The search results are then displayed on the page. 

### Gallery listing: 

-	The GalleryController with the getGalleriesPage method handles requests to display a page containing a list of galleries with additional information. It fetches a list of all galleries and adds it to the model. The method returns the galleries.html to render the HTML page.
  
-	The galleries.html displays the list of galleries in a Bootstrap card format. Each card includes the gallery name, a button to set the gallery location on the map, and a collapsible section with additional information. Information includes email, opening hours, phone, street, number, and postcode.

### Interactive map: 

Users can see an interactive map displayed on the web page,  they can zoom in and out and explore the map. The interactivity of the map on the web page is facilitated by the Leaflet JavaScript library.

### Display each gallery on map: 

When a user triggers the createMarker function in map.js (when the user clicks on the “View information” button about a gallery), a marker is added to the map at specific coordinates (latitude and longitude) that represents a gallery location. 

### Search routes to desired galleries: 

The RoutesController prepares the data (list of galleries). The thymeleaf HTML view ("routes.html")  renders the galleries and includes the map. The JavaScript file ("routefinder.js") interacts with the Leaflet library to handle map-related functionalities (map creation, marker creation, user interactions and route finding). 

## Dependencies: 

•	Bootstrap: https://getbootstrap.com/

•	Leaflet: https://leafletjs.com/

•	Leaflet Routing Machine: https://www.liedman.net/leaflet-routing-machine/ 


