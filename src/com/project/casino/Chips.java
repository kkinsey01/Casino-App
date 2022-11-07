package com.project.casino;

/*
 Name: Kyler Kinsey
 Email: kylerkinsey01@gmail.com
 Date: October 19, 2022
 This chips class creates a chip object to keep track of user's chips
*/

public class Chips {
    private int chipCount;
    private final int MAX_CHIP_COUNT = 100_000;

    public Chips() {
        chipCount = 0;
    }
    public Chips(int chip) {
        this.chipCount = chip;
    }

    public int getChipCount() {
        return chipCount;
    }

    public void setChipCount(int chipCount) {
        this.chipCount = chipCount;
    }
    public boolean addChips(int chip) {
        if (chip + chipCount < MAX_CHIP_COUNT && chip > 0)
            this.chipCount += chip;
        else {
            return false;
        }
        return true;
    }

}
