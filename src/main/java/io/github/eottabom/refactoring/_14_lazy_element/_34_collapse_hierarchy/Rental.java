package io.github.eottabom.refactoring._14_lazy_element._34_collapse_hierarchy;

import java.time.LocalDateTime;
import java.util.List;

public class Rental {

	// 하위 클래스로 내리려면 Refactor -> Pull Members down 으로 가능하고,
	// CameraRental 클래스를 상위 클래스로 올리려면 Refactor -> Pull Members up 으로 가능하다. (인텔리제이에서)
	private LocalDateTime startDateTime;

	private LocalDateTime endDateTime;

	private List<String> users;

	private String requester;

	private boolean paymentComplete;

}
