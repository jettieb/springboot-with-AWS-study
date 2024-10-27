package com.book.springboot_with_AWS.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
//JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드를 createdDate, modifiedDate도 칼럼으로 인식할 수 있도록
@MappedSuperclass
//BaseTimeEntity 클래스에 Auditing 기능 포함.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    // Entity가 생성되어 저장될 때 시간 자동 저장
    @CreatedDate
    private LocalDateTime createdDate;
    // 엔티티의 값을 변경할 때 자동 생성
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
