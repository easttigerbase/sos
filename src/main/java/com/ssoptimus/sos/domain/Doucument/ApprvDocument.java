package com.ssoptimus.sos.domain.Doucument;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "APPRV_LIST")
public class ApprvDocument {
    @Id
    String APPRV_ID;
    String APPRV_STATUS;
    String DRAFT_CODE;
    String DRAFT_NAME;
    String DRAFT_DATE;
    String DRAFT_EMP_NAME;
    String DRAFT_EMP_ID;
    String DRAFT_DOC_NO;
    String DRAFT_DOC_CHANGE_NUM;
    String APPRV_DOC_NO;

}
