package dao;

import model.Branch;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Branches {
    Map<String, Branch>  branchMap;
    public static Branches instance = null;
    static Logger log = Logger.getLogger(Vehicles.class.getName());

    public static Branches getInstance() {
        if (instance == null) instance = new Branches();
        return instance;
    }
    private Branches() {
        branchMap = new HashMap<>();
    }

    public synchronized void addBranch(Branch branch){
        log.info("Branch: " + branch.getBranchId() + " is added");
        branchMap.put(branch.getBranchId(), branch);
    }
    public synchronized void removeBranch(Branch branch){
        branchMap.remove(branch.getBranchId());
    }
    public synchronized Branch getBranch(String branchId){
        return branchMap.get(branchId);
    }
    public synchronized boolean exists(String branchId){
        return branchMap.containsKey(branchId);
    }

}
