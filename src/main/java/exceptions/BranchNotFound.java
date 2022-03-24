package exceptions;

import java.util.logging.Logger;

public class BranchNotFound extends Exception{
    static Logger log = Logger.getLogger(BranchNotFound.class.getName());

    public BranchNotFound(String branchId) {
        log.warning("Branch Not Found: " + branchId);
    }
}
