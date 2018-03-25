# Bike Simulator

## Table of contents:

* [Description](./README.md#description)
  * [Example Input and Output](./README.md#example-input-and-output)
* [Prerequisite](./README.md#setup)
* [Compiling the code](./README.md#compiling-the-code)
* [Running the tests](./README.md#running-the-tests)
* [Running the application](./README.md#running-the-application)

## Description

* The application is a simulation of a bike driving on a 7  x 7 grid.

* The bike is free to move around the grid but must be prevented from exiting the grid.
  Any movement that would cause the bike to leave the grid must be prevented,
  however further valid movement must still be allowed.

* The following commands must be supported by the application:
```
PLACE <X>,<Y>,<Facing Direction>
FORWARD
TURN_LEFT
TURN_RIGHT
GPS_REPORT
```

* PLACE will put the bike at position (X,Y) facing NORTH, SOUTH, EAST or WEST, where
  (0,0) is the south-west corner.

* The application should discard all commands until a valid PLACE command has been
  executed. The application should also ignore all invalid commands.

* After the initial PLACE command any sequence of commands may be issued (and in any
  order) including another PLACE command.

* FORWARD will move the bike one unit forward in the direction it is currently facing.

* TURN_LEFT and TURN_RIGHT will rotate the bike in the specified direction without
  changing its position on the grid.

* GPS_REPORT will output the bike's position and facing in the following format:
  (<X>, <Y>), <Facing-direction>

* The bike must not exit the grid during movement. This includes the PLACE command.
  Any move that would cause the bike to leave the grid must be ignored.

* Input for the bike can be from a file.



### Example Input and Output:

#### Example a

    PLACE 0,5,NORTH
    FORWARD
    GPS_REPORT

Expected output:

    GPS POSITION:(0,6),NORTH

#### Example b

    PLACE 0,0,NORTH
    TURN_LEFT
    GPS_REPORT

Expected output:

    GPS POSITION:(0,0),WEST

#### Example c

    PLACE 1,2,EAST
    FORWARD
    FORWARD
    TURN_LEFT
    FORWARD
    GPS_REPORT

Expected output

    GPS POSITION:(3,3),NORTH


## Prerequisite

1. The following softwares are installed in machine

    ```java 1.8```
    
    ```maven 4.0.0```
    
    ```junit 3.8.1```
2. The iput file is placed in below location:
 ```D:\Docs\lines.txt```

3. Clone this repo:

    ```git clone git@github.com/NeethuTom/Bike-Simulator.git```
### Compiling the code:
```mvn compile```

compiled jar in target/ folder
### Running the tests:
```mvn test```

test report in target/ surefire-reports
### Running the application:
```mvn exec:java```

