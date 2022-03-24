package model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class RentalApp {
    private String name;
    private List<String> branchIds;
    static Logger log = Logger.getLogger(RentalApp.class.getName());

    public RentalApp(String name){
        this.name = name;
        branchIds = new ArrayList<>();
        log.info("Rental Service Initialized: " + name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBrancheIds() {
        return branchIds;
    }

    public void addBranch(String branche_id) {
        this.branchIds.add(branche_id);
    }

}
