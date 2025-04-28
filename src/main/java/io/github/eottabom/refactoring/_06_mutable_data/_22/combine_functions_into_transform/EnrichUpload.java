package io.github.eottabom.refactoring._06_mutable_data._22.combine_functions_into_transform;

// EnrichUpload 이 baseCost 를 가지게 해보자.
//public record EnrichUpload(Upload upload) {
public record EnrichUpload(Upload upload, double baseCost, double overCost) {
}
