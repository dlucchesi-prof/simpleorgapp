package com.dlucchesi.simpleorgapp.util;

import com.dlucchesi.simpleorgapp.model.BaseSimpleOrgEntity;

import static java.util.Objects.isNull;

public class BaseSimpleOrgEntityUtil {

    public static void changeNew(BaseSimpleOrgEntity entity){
        if (!isNull(entity)){
            entity.setIsActive(true);
            entity.setIsDeleted(false);
        }
    }

    public static void changeDeleted(BaseSimpleOrgEntity entity){
        if (!isNull(entity)){
            entity.setIsActive(false);
            entity.setIsDeleted(true);
        }
    }

}
