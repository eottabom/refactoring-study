package io.github.eottabom.refactoring._06_mutable_data._22_combine_functions_into_transform._00_before;

import java.time.Month;
import java.time.Year;

public record Upload(String uploader, double fileSize, Year year, Month month) {
}
