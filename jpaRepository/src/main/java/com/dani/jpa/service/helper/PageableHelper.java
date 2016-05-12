package com.dani.jpa.service.helper;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dani.jpa.domain.User_;

public class PageableHelper {

    public static Pageable getPageableFromPageAndSize(final int page, final int size) {
        return new PageRequest(page, size, new Sort(Sort.Direction.ASC, User_.surname.getName()));
    }
}
