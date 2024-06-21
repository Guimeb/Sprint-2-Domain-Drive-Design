package models;

import java.util.HashMap;
import java.util.Map;

public class BodyPart {
    private Part partType;
    private boolean hasForeignObj;
    private Map<String, ForeignObj> foreignObjInPart;

    public enum Part {
        BRACO,
        CORPO,
        PERNAS
    }

    public BodyPart(Part partType) {
        this.partType = partType;
        this.hasForeignObj = false;
        this.foreignObjInPart = new HashMap<>();
    }

    // Getters e setters
    public Part getPartType() {
        return partType;
    }

    public boolean hasForeignObj() {
        return hasForeignObj;
    }

    public void setHasForeignObj(boolean hasForeignObj) {
        this.hasForeignObj = hasForeignObj;
    }

    public Map<String, ForeignObj> getForeignObjInPart() {
        return foreignObjInPart;
    }

    public void addForeignObj(ForeignObj foreignObj) {
        this.hasForeignObj = true;
        this.foreignObjInPart.put(foreignObj.getItemType(), foreignObj);
    }

    public void removeForeignObj() {
        this.hasForeignObj = false;
        this.foreignObjInPart.clear();
    }
}
