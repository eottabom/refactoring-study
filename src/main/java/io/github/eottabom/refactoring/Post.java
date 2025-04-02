package io.github.eottabom.refactoring;

import java.util.List;

public record Post(int id, List<Comment> comments) {

}
