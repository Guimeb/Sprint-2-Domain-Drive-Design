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
    
    public void addForeignObj(ForeignObj foreignObj) { // Adiciona um corpo estranho a parte do corpo
        this.hasForeignObj = true;
        this.foreignObjInPart.put(foreignObj.getItemType(), foreignObj);
    }

    public void removeForeignObj() { // Remove um corpo estranho da parte do corpo
        this.hasForeignObj = false;
        this.foreignObjInPart.clear();
    }

    public boolean hasForeignObj() { // Verifica se a parte do corpo tem um corpo estranho
        return hasForeignObj;
    }

    // Getters e setters
    public Part getPartType() {
        return partType;
    }

    public void setHasForeignObj(boolean hasForeignObj) {
        this.hasForeignObj = hasForeignObj;
    }

    public Map<String, ForeignObj> getForeignObjInPart() {
        return foreignObjInPart;
    }
}
