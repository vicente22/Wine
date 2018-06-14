package cl.vicentepc.wine.models;

import com.orm.SugarRecord;

public class Wine extends SugarRecord {

    private String wineName, wineYear, wineType;

    public Wine() {
    }

    public Wine(String wineName, String wineYear, String wineType) {
        this.wineName = wineName;
        this.wineYear = wineYear;
        this.wineType = wineType;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getWineYear() {
        return wineYear;
    }

    public void setWineYear(String wineYear) {
        this.wineYear = wineYear;
    }

    public String getWineType() {
        return wineType;
    }

    public void setWineType(String wineType) {
        this.wineType = wineType;
    }
}
