package org.acme.quarkus.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="double_ids")
public class TestRecordOne extends PanacheEntityBase {

    // marked tid as the pk for this object and not the id field to show
    // the LinkProcessor uses the id field to render self link and not the
    // tid value.
    @Id
    @Column(name="tid", columnDefinition = "BIGINT", nullable = false)
    private Long tid;
    @Column(name="id", columnDefinition = "BIGINT", nullable = false)
    private Long id;

    @Column(name="name", columnDefinition = "TEXT", nullable = false)
    private String name;

    public TestRecordOne() {}
    public TestRecordOne(Long tid, Long id, String name) {
        this.tid = tid;
        this.id = id;
        this.name = name;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
