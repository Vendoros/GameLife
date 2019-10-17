package com.company;

import java.util.ArrayList;

public class Cell {
    ArrayList<Cell> near;
    Status status;

    public Cell() {
        status = Status.NONE;
        near = new ArrayList<>();
    }

    void addNear(Cell cell){
        near.add(cell);
    }

    void prepare() {
        int around = countNearCells();
        status = status.prepare(around);
    }

    void replays() {
        status = status.replays();
    }

    int countNearCells() {
        int count = 0;
        for (Cell cell : near) {
            if (cell.status.isCell()) {
                count++;
            }
        }
        return count;
    }

    public void turn() {
        for (Cell cell : near){
            cell.status = cell.status.isCell() ? Status.NONE : Status.LIVE;
        }
    }
}
