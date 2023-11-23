package demo.finanzas_backend.service.Impl;

import demo.finanzas_backend.entities.Tables;
import demo.finanzas_backend.repository.ItablesRepository;
import demo.finanzas_backend.service.ItablesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public  class ITablesImplService implements ItablesService {
    private final ItablesRepository itablesRepository;
    public ITablesImplService(ItablesRepository itablesRepository) {
        this.itablesRepository = itablesRepository;
    }

    @Override
    @Transactional
    public Tables save(Tables tables)  {
        return itablesRepository.save(tables);
    }

    @Override
    public void delete(Long id) throws Exception {
     itablesRepository.deleteById(id);
    }

    @Override
    public List<Tables> getAll() throws Exception {
        return itablesRepository.findAll();
    }

    @Override
    public Tables getById(Long id) throws Exception {
        return itablesRepository.findById(id).orElseThrow(()->new Exception("La tabla no existe"));
    }
}
