package com.beonit.minsait.democommerce;

import com.beonit.minsait.democommerce.model.PriceDto;
import com.beonit.minsait.democommerce.model.PriceQueryDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemocommerceApplicationTests {

    @LocalServerPort
    int port;
    private String baseUrl = "http://localhost";
    private static RestTemplate restTemplate;

    @BeforeAll
    static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    void beforeSetup() {
        baseUrl = baseUrl.concat(":" + port);
    }

    @Test
    void contextLoads() {
        // contextLoads
    }

    @Test
    void testGetPriceListOk() {
        List<PriceDto> priceDtoList =
                restTemplate
                        .exchange(
                                baseUrl.concat("/ecom/list"),
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<List<PriceDto>>() {
                                })
                        .getBody();

        assertNotNull(priceDtoList);
        assertEquals(4, priceDtoList.size());
    }

    @Test
    void testGetPriceListByIdQueryTesting() {

        // - Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        PriceQueryDto priceQueryDto =
                restTemplate
                        .exchange(baseUrl.concat(
                                        "/ecom/list/price?requiredDate=2020-06-14 10:00:00&productId=35455&brandId=1"),
                                HttpMethod.GET, null, new ParameterizedTypeReference<PriceQueryDto>() {
                                })
                        .getBody();
        assertNotNull(priceQueryDto);

        // - Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        priceQueryDto =
                restTemplate
                        .exchange(
                                baseUrl.concat(
                                        "/ecom/list/price?requiredDate=2020-06-14 16:00:00&productId=35455&brandId=1"),
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<PriceQueryDto>() {
                                })
                        .getBody();
        assertNotNull(priceQueryDto);

        // - Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        priceQueryDto =
                restTemplate
                        .exchange(
                                baseUrl.concat(
                                        "/ecom/list/price?requiredDate=2020-06-14 21:00:00&productId=35455&brandId=1"),
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<PriceQueryDto>() {
                                })
                        .getBody();
        assertNotNull(priceQueryDto);

        // - Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
        priceQueryDto =
                restTemplate
                        .exchange(
                                baseUrl.concat(
                                        "/ecom/list/price?requiredDate=2020-06-15 10:00:00&productId=35455&brandId=1"),
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<PriceQueryDto>() {
                                })
                        .getBody();
        assertNotNull(priceQueryDto);

        // -  Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
        priceQueryDto =
                restTemplate
                        .exchange(
                                baseUrl.concat(
                                        "/ecom/list/price?requiredDate=2020-06-16 21:00:00&productId=35455&brandId=1"),
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<PriceQueryDto>() {
                                })
                        .getBody();
        assertNotNull(priceQueryDto);
    }

}
