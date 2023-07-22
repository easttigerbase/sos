package com.ssoptimus.sos.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
/**
*
* 모든 entity 상위 클래스로 createDate,modifeddate 자동으로 관리
 *MappedSuperclass -> 베이스 타임 상속시 필드들을 컬럼 자동으로 인식
 *
 * @createDate 객체 생성시 자동으로 값 입력
 * @LastNodifiedDate  객체 수정시 값 입력
 * */
public abstract class BaseTime {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedData;
}
