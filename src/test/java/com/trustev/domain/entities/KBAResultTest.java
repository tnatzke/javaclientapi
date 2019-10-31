package com.trustev.domain.entities;

import com.trustev.domain.entities.kba.KBAResult;
import com.trustev.domain.entities.kba.KBAStatus;

public class KBAResultTest extends BaseTest<KBAResult> {


    public KBAResultTest(){
        super(KBAResult.class);
    }

    @Override
    KBAResult generateObject() {

        KBAResult entity = new KBAResult();
        entity.setStatus(KBAStatus.Offered);
        return entity;
    }
}
