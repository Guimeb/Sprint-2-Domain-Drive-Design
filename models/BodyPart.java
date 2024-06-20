package models;

import java.util.HashMap;
import java.util.Map;

public class BodyPart {
    private Part partType;
    private boolean hasForeignObj; // Variável para indicar se há um ForeignObj preso na parte do corpo
    private Map<ForeignObj.Type, ForeignObj> foreignObjInPart; // Mapeamento de objetos estrangeiros presos na parte do corpo

    public enum Part {
        BRACO,
        CORPO,
        PERNAS
    }

    public BodyPart(Part partType) {
        this.partType = partType;
        this.hasForeignObj = false; // Por padrão, não há objeto estrangeiro preso na parte do corpo
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

    public Map<ForeignObj.Type, ForeignObj> getForeignObjInPart() {
        return foreignObjInPart;
    }
}
