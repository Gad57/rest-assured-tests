package Api.models;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import javax.xml.crypto.dsig.spec.XPathType;

public class CastomFilter implements Filter {
    @Override
    public Response filter(
            FilterableRequestSpecification requestSpec,
            FilterableResponseSpecification responseSpec,
            FilterContext ctx) {

        System.out.println("========== REQUEST ==========");
        System.out.println("URI: " + requestSpec.getURI());
        System.out.println("METHOD: " + requestSpec.getMethod());

        Response response = ctx.next(requestSpec, responseSpec);

        System.out.println("========== RESPONSE ==========");
        System.out.println("STATUS: " + response.getStatusCode());

        return response;
    }
}
