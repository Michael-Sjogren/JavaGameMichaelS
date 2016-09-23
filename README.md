# JavaGameMichaelS - Working title

A javafx 2d game with basic platforming mechanics.

#### **Game Instructions**

##### **SPACE : SHOOT**

##### **W :   JUMP**

##### **A :   LEFT**

##### **D :   RIGHT**

I've also have implemented code to read the save files from the program:  
[Tiled](http://www.mapeditor.org/ "Tiled Map Editor")
in Json format to generate tiles and collision objects.

This Project Uses Gson to parse the mapdata.

Only orthogonal maps are compatible , and one tileset per map file.

## **Opening the Project**

Clone or download the project.

## Intellij:

Select "Create project from existing sources" radio button and continue pressing next , make sure the libaries are selected and then finnish.

## Eclipse
import as general project.
Go to Project build path then choose Project facets and pick java , apply.
After that you will neeed to add gson libary.
Go to project Properties -> configure build path -> java build path.
in java build path , pick the libary tab and add Gson.jar that is in src/lib.

