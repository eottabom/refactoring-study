package io.github.eottabom.refactoring._08_shotgun_surgery;

import java.util.Map;

class Test {

		Map<Long, Long> count(Map<String, UserStats>... visits) {

			if  (visits == null || visits.length == 0) {
				return Collections.emptyMap();
			}

			return Arrays.stream(visits)
					.filter(Objects::nonNull)
					.flatMap((map) -> map.entrySet().stream())
					.filter((entry) -> isValidUserId(entry.getKey()))
					.filter((entry) -> isValidVisitCount(entry.getValue()))
					.map(this::parseEntry)
					.filter(Objects::nonNull)
					.collect(Collectors.toMap(
							Map.Entry::getKey,
							Map.Entry::getValue,
							Long::sum
					));
		}

		private Map.Entry<Long, Long> parseEntry(Map.Entry<String, UserStats> entry) {
			Long userId = Long.parseLong(entry.getKey());
			Long count = entry.getValue().getVisitCount().get();
			return new AbstractMap.SimpleImmutableEntry<>(userId, count);
		}

		private boolean isValidUserId(String key) {
			if (key == null) {
				return false;
			}
			try {
				Long.parseLong(key);
				return true;
			}
			catch (NumberFormatException ex) {
				UnsupportedOperationException
				return false;
			}
		}

		private boolean isValidVisitCount(UserStats stats) {
			return Optional.ofNullable(stats)
					.map(UserStats::getVisitCount)
					.orElse(Optional.empty())
					.isPresent();
		}

}

