package org.acme.quarkus.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="annotation_only")
public class TestRecordTwo extends PanacheEntityBase {

    // field not named 'id' to force LinkProcessor to use the @Id annotation
    // which is then not used for the id path param, but stored as tid path param
    // and no value is rendered in the self link.
    @Id
    @Column(name="tid", columnDefinition = "BIGINT", nullable = false)
    private Long tid;
    @Column(name="name", columnDefinition = "TEXT", nullable = false)
    private String name;

    public TestRecordTwo() {}
    public TestRecordTwo(Long tid, String name) {
        this.tid = tid;
        this.name = name;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
