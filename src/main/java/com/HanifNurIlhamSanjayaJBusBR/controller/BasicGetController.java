package com.HanifNurIlhamSanjayaJBusBR.controller;

import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonTable;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.Serializable;
import com.HanifNurIlhamSanjayaJBusBR.Algorithm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BasicGetController <T extends Serializable> {
    JsonTable<T> getJsonTable();

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public default List<T> getPage(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int pageSize
    ) {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, a -> true);
    }

}