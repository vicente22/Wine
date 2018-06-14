package cl.vicentepc.wine.data;

import java.util.ArrayList;
import java.util.List;

import cl.vicentepc.wine.models.Wine;

public class Queries {

    public List<Wine> wines() {

        List<Wine> wines = new ArrayList<>();
        List<Wine> wineList = Wine.listAll(Wine.class);

        return wineList;

    }

}