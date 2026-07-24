package pe.com.tatapizzeria.service;

import java.util.List;
import pe.com.tatapizzeria.entity.BordesRellenoEntity;

public interface BordesRellenoService {
    List<BordesRellenoEntity> findAll();
    List<BordesRellenoEntity> findAllCustom();
    BordesRellenoEntity findById(Integer id);
    BordesRellenoEntity add(BordesRellenoEntity obj);
    BordesRellenoEntity update(BordesRellenoEntity obj,Integer id);
    BordesRellenoEntity delete(Integer id);
    BordesRellenoEntity enable(Integer id);
}
