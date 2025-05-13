package io.github.eottabom.refactoring._01_smell_mysterious_name;

import java.util.List;

public record Post(int id, List<Comment> comments) {

}
