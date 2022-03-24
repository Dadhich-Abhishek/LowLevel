package exceptions;

import java.util.logging.Logger;

public class DuplicateBranch extends Exception{
    static Logger log = Logger.getLogger(DuplicateBranch.class.getName());

    public DuplicateBranch(String branchId) {
        log.warning("A branch with same name exist:" + branchId);
    }
}
