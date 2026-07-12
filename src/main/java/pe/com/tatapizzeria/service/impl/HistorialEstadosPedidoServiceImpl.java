package pe.com.tatapizzeria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tatapizzeria.entity.HistorialEstadosPedidoEntity;
import pe.com.tatapizzeria.repository.HistorialEstadosPedidoRepository;
import pe.com.tatapizzeria.service.HistorialEstadosPedidoService;
import java.util.List;

@Service
public class HistorialEstadosPedidoServiceImpl implements HistorialEstadosPedidoService {

    @Autowired
    private HistorialEstadosPedidoRepository repositorio;

    @Override
    public List<HistorialEstadosPedidoEntity> findAll() { return repositorio.findAll(); }

    @Override
    public HistorialEstadosPedidoEntity findById(Long id) { return repositorio.findById(id).orElse(null); }

    @Override
    public HistorialEstadosPedidoEntity add(HistorialEstadosPedidoEntity obj) { return repositorio.save(obj); }
}
