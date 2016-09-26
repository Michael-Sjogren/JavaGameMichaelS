# JavaGameMichaelS - Working title

## **Game Description**
A javafx 2d game with basic platforming mechanics.
The game is a work in progress , right now you can jump around on the platfroms and throw ninjastars at the static enemy ninja.

### Libaries and tools im using
I have implemented code to read the save files from the program:  
[Tiled](http://www.mapeditor.org/ "Tiled Map Editor")
in Json format to generate tiles and collision objects.

This Project Uses the **Gson** libary to parse the mapdata into java pojo's.

Only orthogonal maps are compatible , and one tileset per map file.
## **Game Instructions**

To play the game you can either open the project in an IDE or download JavaGameMichaelS.jar and run it.

##### **SPACE : SHOOT**

##### **W :   JUMP**

##### **A :   LEFT**

##### **D :   RIGHT**

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

