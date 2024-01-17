package org.acme.quarkus.rest;

import org.acme.quarkus.entity.TestRecordOne;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path="/api/one", hal=true)
public interface TestRecordOneResource extends PanacheEntityResource<TestRecordOne, Long> {
}
