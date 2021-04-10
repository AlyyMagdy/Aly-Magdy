package BestBuy.BestBuy_Automation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.qameta.allure.Feature;
import io.restassured.response.Response;
import junit.framework.Assert;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import resources.CommonTestUtils;
import resources.Constants;

@Feature("Get Product API")
public class GetProductAPITest extends CommonTestUtils {

	private static final long validProductID = 43900;
	private static final long invalidProductID = 439001;

	@Test(description = "Get Product Request with Valid Product ID.")
	public void getProductRequestIfIdIsValid() {
		Response response = sendGetRequest(Constants.getBaseURL() + "/products/" + validProductID);
		assertEquals(response.getStatusCode(), 200);
		response.then().body("name", equalTo("Duracell - AAA Batteries (4-Pack)"));
		response.then().body("type", equalTo("HardGood"));
		response.then().body("price", equalTo(5.49F));
		response.then().body("categories[0].name", equalTo("Alkaline Batteries"));
	}

	@Test(description = "Get Product Request with Invalid Product ID.")
	public void getProductRequestIfIdIsInvalid() {
		Response response = sendGetRequest(Constants.getBaseURL() + "/products/" + invalidProductID);
		assertEquals(response.getStatusCode(), 404);
		assertEquals(response.path("message"), "No record found for id '" + invalidProductID + "'");
	}

	@Test(description = "Get Product Request with wrong endpoint.")
	public void getProductRequestIfIEndPointIsInvalid() {
		Response response = sendGetRequest(Constants.getBaseURL() + "/product/" + validProductID);
		assertEquals(response.getStatusCode(), 404);
		assertEquals(response.path("message"), "Page not found");
	}

	@Test(description = "Get Product Request with Null Product ID.")
	public void getProductRequestIfIdIsNull() {
		Response response = sendGetRequest(Constants.getBaseURL() + "/products/" + null);
		assertEquals(response.getStatusCode(), 404);
		assertEquals(response.path("message"), "No record found for id '" + null + "'");
	}
}
