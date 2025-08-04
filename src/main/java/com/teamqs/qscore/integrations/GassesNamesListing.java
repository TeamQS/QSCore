package com.teamqs.qscore.integrations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teamqs.qscore.Constants;
import com.teamqs.qscore.QSCore;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GassesNamesListing {

    public GassesNamesListing() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        List<Gas> gasses = GasRegistry.getRegisteredGasses();
        List<GasNames> gasNames = new ArrayList<>();
        for (Gas gas : gasses) {
            gasNames.add(new GasNames(gas.getName(), gas.getID()));
        }
        try (FileWriter writer = new FileWriter(Constants.MEKA_CONFIG_DIR + "/gasses.json")) {
            gson.toJson(gasNames, writer);
        } catch (IOException e) {
            QSCore.LOGGER.error(e);
        }
    }

    private class GasNames {
        public String name;
        public int id;

        public GasNames(String name, int id) {
            this.id = id;
            this.name = name;
        }
    }
}