package be.vdab.stevesmovietheatre.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.*;

@Component
@SessionScope
public class Mandje implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Set<Long> ids = new LinkedHashSet<>();

    private long klantId = 0;

    public void add(Long id){
        ids.add(id);
    }

    public void delete(Long[] id){
        ids.removeAll(Arrays.stream(id).toList());
    }

    public Set<Long> getFilms() {
        return ids;
    }

    public long getKlantId() {
        return klantId;
    }

    public void setKlantId(long klantId){
        this.klantId = klantId;
    }

    public void emptyCart(){
        setKlantId(0);
        getFilms().clear();
    }
}
