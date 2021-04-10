package resources;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class CommonTestUtils {

	public static Response sendGetRequest(String restURL) {
		return given().get(restURL);
	}
}
