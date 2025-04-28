package io.github.eottabom.refactoring._06_mutable_date._22_conbine_functions_into_transform;

import java.time.Month;
import java.time.Year;

import io.github.eottabom.refactoring._06_mutable_data._22_combine_functions_into_transform.Client1;
import io.github.eottabom.refactoring._06_mutable_data._22_combine_functions_into_transform.Client2;
import io.github.eottabom.refactoring._06_mutable_data._22_combine_functions_into_transform.Client3;
import io.github.eottabom.refactoring._06_mutable_data._22_combine_functions_into_transform.Upload;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UploadClientTests {

	@Test
	void client1() {
		Client1 client1 = new Client1(acquireUpload());
		assertThat(client1.getBaseCost()).isEqualTo(50d);
	}

	@Test
	void client2() {
		Client2 client2 = new Client2(acquireUpload());
		assertThat(client2.getBaseCost()).isEqualTo(50d);
		assertThat(client2.getOverageCharge()).isEqualTo(60d);
	}

	@Test
	void client3() {
		Client3 client3 = new Client3(acquireUpload());
		assertThat(client3.getBaseCharge()).isEqualTo(50d);
	}

	private Upload acquireUpload() {
		return new Upload("eottabom", 10, Year.of(2025), Month.APRIL);
	}

}
