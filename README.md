# JavaGameMichaelS - Working title

A javafx 2d game with basic platforming mechanics.

To play the game you can either open the project in an IDE or download JavaGameMichaelS.jar and run it.

## **Game Instructions**

##### **SPACE : SHOOT**

##### **W :   JUMP**

##### **A :   LEFT**

##### **D :   RIGHT**

The game is a work in progress , right now you can jump around on the platfroms and throw ninjastars at the static enemy ninja.

I've also have implemented code to read the save files from the program:  
[Tiled](http://www.mapeditor.org/ "Tiled Map Editor")
in Json format to generate tiles and collision objects.

This Project Uses Gson to parse the mapdata.

Only orthogonal maps are compatible , and one tileset per map file.

## **Opening the Project**

Clone or download the project.

## Intellij:
Import project.
Select "Create project from existing sources" radio button.
Then continue pressing next meanwhile making sure the libaries are selected and then press finnish.

## Eclipse
Import as general project.
Go to Project build path then choose Project facets and pick java , apply.
After that you will neeed to add gson libary.
Go to project Properties -> configure build path -> java build path.
in java build path , pick the libary tab and add Gson.jar that is in src/lib.

