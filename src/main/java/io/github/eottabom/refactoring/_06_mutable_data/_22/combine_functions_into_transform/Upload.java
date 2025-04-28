package io.github.eottabom.refactoring._06_mutable_data._22.combine_functions_into_transform;

import java.time.Month;
import java.time.Year;

// 불변한 데이터를 가진 record
public record Upload(String uploader, double fileSize, Year year, Month month) {
}
