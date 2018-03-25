package com.nt.pjt.components;

import java.util.HashMap;
import java.util.Map;

public enum Direction {


    NORTH(0), EAST(1), SOUTH(2), WEST(3);
    private static Map<Integer, Direction> map = new HashMap<Integer, Direction>();

    static {
        for (Direction directionEnum : Direction.values()) {
            map.put(directionEnum.directionIndex, directionEnum);
        }
    }

    private int directionIndex;

    private Direction(int direction) {
        this.directionIndex = direction;
    }

    public static Direction valueOf(int directionNum) {
        return map.get(directionNum);
    }


    /*This method checks the new index of direction
    If the index exceeds the map size,reset to 0
    If the index become -1 ,reset to map size
     */

    private Direction rotate(int i) {
        {
            int newIndex = (this.directionIndex + i) < 0 ?
                    map.size() - 1 :
                    (this.directionIndex + i) % map.size();
            return Direction.valueOf(newIndex);
        }
    }

    public Direction rightDirection() {
        return rotate(1);
    }

    public Direction leftDirection() {
        return rotate(-1);

    }


}
