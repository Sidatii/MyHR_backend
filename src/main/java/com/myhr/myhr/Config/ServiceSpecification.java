package com.myhr.myhr.Config;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface ServiceSpecification<T, H, I> {

    public T get(I id);
    public Page<T> getAll(Pageable pageable);
    public T create(H h) throws IOException;
    public T update(H h, I id) throws IOException;
    public void delete(I id);
}
