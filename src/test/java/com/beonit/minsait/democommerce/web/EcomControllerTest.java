package com.beonit.minsait.democommerce.web;

import com.beonit.minsait.democommerce.exception.NotFoundPriceException;
import com.beonit.minsait.democommerce.model.PriceDto;
import com.beonit.minsait.democommerce.model.PriceQueryDto;
import com.beonit.minsait.democommerce.service.PriceService;
import com.beonit.minsait.democommerce.util.DtoCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EcomControllerTest {

    @Mock
    private PriceService service;

    @InjectMocks
    private EcomController controller;

    @Test
    void testGetAllPricesOk() {
        PriceDto dummy = DtoCreator.buildPriceDto();

        when(service.getAllPrices()).thenReturn(List.of(dummy));

        ResponseEntity<List<PriceDto>> result = controller.getAllPrices();

        assertNotNull(result);
        assertNotNull(result.getBody());

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("EUR", result.getBody().getFirst().getCurr());
    }

    @Test
    void getPriceByCriteriaQueryOk() throws NotFoundPriceException {
        PriceQueryDto dummy = DtoCreator.buildPriceQueryDto();

        when(service.getPriceByCriteriaQuery(any(Timestamp.class), anyInt(), anyLong())).thenReturn(dummy);

        ResponseEntity<PriceQueryDto> result = controller.getPriceByCriteriaQuery(
                "2020-06-14 00:00:00", 1, 1L);

        assertNotNull(result);
        assertNotNull(result.getBody());

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(200, result.getBody().getPrice());
    }

    @Test
    void getPriceByCriteriaQueryKo() throws NotFoundPriceException {

        when(service.getPriceByCriteriaQuery(any(Timestamp.class), anyInt(), anyLong()))
                .thenThrow(new NotFoundPriceException("FAIL"));

        assertThrows(NotFoundPriceException.class, () -> controller
                .getPriceByCriteriaQuery("2020-06-14 00:00:00", 1, 1L));
    }
}