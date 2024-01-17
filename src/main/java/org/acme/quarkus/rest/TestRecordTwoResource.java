package org.acme.quarkus.rest;

import org.acme.quarkus.entity.TestRecordTwo;
import io.quarkus.hibernate.reactive.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path="/api/two", hal=true)
public interface TestRecordTwoResource extends PanacheEntityResource<TestRecordTwo, Long> {
}
