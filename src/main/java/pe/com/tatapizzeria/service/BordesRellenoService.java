package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.BordesRellenoEntity;

public interface BordesRellenoService {
    List<BordesRellenoEntity> findAll();
    List<BordesRellenoEntity> findAllCustom();
    BordesRellenoEntity findById(Long id);
    BordesRellenoEntity add(BordesRellenoEntity obj);
    BordesRellenoEntity update(BordesRellenoEntity obj, Long id);
    BordesRellenoEntity delete(Long id);
    BordesRellenoEntity enable(Long id);
}
